package org.nanohttpd.protocols.http;

import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.IServerListener;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

/* JADX INFO: loaded from: classes42.dex */
public abstract class NanoHTTPD {
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = null;
    public static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    public static final Pattern CONTENT_DISPOSITION_PATTERN = null;
    public static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    public static final Pattern CONTENT_TYPE_PATTERN = null;
    public static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    public static final Logger LOG = null;
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    protected static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    protected uwc.b asyncRunner;
    public volatile org.nanohttpd.protocols.http.a currentHandler;
    public final String hostname;
    private vwc.c<c, Response> httpHandler;
    protected List<vwc.c<c, Response>> interceptors;
    public final int myPort;
    private volatile ServerSocket myServerSocket;
    private Thread myThread;
    protected IServerListener serverListener;
    private vwc.b<ServerSocket, IOException> serverSocketFactory;
    private vwc.a<twc.d> tempFileManagerFactory;

    public static final class ResponseException extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final Status status;

        public Status getStatus() {
            return this.status;
        }

        public ResponseException(Status r100, String r101) {
            super(r101);
            this.status = r100;
        }

        public ResponseException(Status r100, String r101, Exception r102) {
            super(r101, r102);
            this.status = r100;
        }
    }

    public class a implements vwc.c<c, Response> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NanoHTTPD f526177a;

        public a(NanoHTTPD r100) {
            this.f526177a = r100;
        }

        @Override // vwc.c
        public final Response a(Object r100) {
            NanoHTTPD r101 = this.f526177a;
            return r101.serve((c) r100);
        }
    }

    public synchronized void closeAllConnections() {
        monitor-enter(this);
        stop();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        CONTENT_DISPOSITION_PATTERN = PatternProtector.compile(CONTENT_DISPOSITION_REGEX, 2);
        CONTENT_TYPE_PATTERN = PatternProtector.compile(CONTENT_TYPE_REGEX, 2);
        CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = PatternProtector.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
        LOG = Logger.getLogger(NanoHTTPD.class.getName());
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES != null) goto L8;
        HashMap r100 = new HashMap();
        MIME_TYPES = r100;
        loadMimeTypes(r100, "META-INF/nanohttpd/default-mimetypes.properties");
        loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
        if (MIME_TYPES.isEmpty() == false) goto L8;
        LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
    L8:
        return MIME_TYPES;
    }

    public final int getListeningPort() {
        if (this.myServerSocket != null) goto L6;
        return -1;
    L6:
        return this.myServerSocket.getLocalPort();
    }

    public void start() throws IOException {
        start(5000);
    }

    public boolean stop() {
        safeClose(this.myServerSocket);     // Catch: Exception -> L11
        uwc.a r100 = (uwc.a) this.asyncRunner;     // Catch: Exception -> L11
        r100.getClass();     // Catch: Exception -> L11
        Iterator r101 = new ArrayList(r100.f551962b).iterator();     // Catch: Exception -> L11
    L4:
        if (r101.hasNext() == false) goto L6;
        org.nanohttpd.protocols.http.a r102 = (org.nanohttpd.protocols.http.a) r101.next();     // Catch: Exception -> L11
        safeClose(r102.f526179b);     // Catch: Exception -> L11
        safeClose(r102.f526180c);     // Catch: Exception -> L11
        goto L4
    L6:
        Thread r103 = this.myThread;     // Catch: Exception -> L11
        if (r103 == null) goto L17;
        ThreadMethodProxy.join(r103);     // Catch: Exception -> L11
        return true;
    L17:
        return true;
    L11:
        e = move-exception;
        LOG.log(Level.SEVERE, "Could not stop all connections", e);
        return false;
    }

    public final boolean wasStarted() {
        if (this.myServerSocket != null) goto L5;
    L7:
        return false;
    L5:
        if (this.myThread == null) goto L7;
        return true;
    }

    public final boolean isAlive() {
        if (wasStarted() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.myServerSocket.isClosed() == true) goto L9;
        if (ThreadMethodProxy.isAlive(this.myThread) == false) goto L9;
        return true;
    }

    public String getHostname() {
        return this.hostname;
    }

    public ServerSocket getMyServerSocket() {
        return this.myServerSocket;
    }

    public IServerListener getServerListener() {
        return this.serverListener;
    }

    public vwc.b<ServerSocket, IOException> getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public vwc.a<twc.d> getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public NanoHTTPD(int r100) {
        this(null, r100);
    }

    public static Map<String, List<String>> decodeParameters(String r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L19;
        StringTokenizer r102 = new StringTokenizer(r100, "&");
    L6:
        if (r102.hasMoreTokens() == false) goto L19;
        String r103 = r102.nextToken();
        int r104 = r103.indexOf(61);
        if (r104 < 0) goto L10;
        String r105 = decodePercent(r103.substring(0, r104));
    L11:
        String r106 = r105.trim();
        if (r101.containsKey(r106) == true) goto L14;
        r101.put(r106, new ArrayList());
    L14:
        if (r104 < 0) goto L16;
        String r107 = decodePercent(r103.substring(r104 + 1));
    L17:
        if (r107 == null) goto L6;
        ((List) r101.get(r106)).add(r107);
        goto L6
    L16:
        r107 = null;
        goto L17
    L10:
        r105 = decodePercent(r103);
    L19:
        return r101;
    }

    public static String decodePercent(String r100) {
        return URLDecoder.decode(r100, "UTF8");
    L4:
        e = move-exception;
        LOG.log(Level.WARNING, "Encoding not supported, ignored", e);
        return null;
    }

    public static String getMimeTypeForFile(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 < 0) goto L5;
        String r102 = mimeTypes().get(r100.substring(r101 + 1).toLowerCase());
    L6:
        if (r102 != null) goto L9;
        return "application/octet-stream";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final void safeClose(Object r100) {
        if (r100 == null) goto L18;
    L14:
        e = move-exception;
        LOG.log(Level.SEVERE, "Could not close", e);
        return;
    L4:
        if ((r100 instanceof Closeable) == false) goto L7;
        ((Closeable) r100).close();     // Catch: IOException -> L14
        return;
    L7:
        if ((r100 instanceof Socket) == false) goto L10;
        ((Socket) r100).close();     // Catch: IOException -> L14
        return;
    L10:
        if ((r100 instanceof ServerSocket) == false) goto L13;
        ((ServerSocket) r100).close();     // Catch: IOException -> L14
        return;
    L13:
        throw new IllegalArgumentException("Unknown object to close");     // Catch: IOException -> L14
    }

    public void addHTTPInterceptor(vwc.c<c, Response> r100) {
        this.interceptors.add(r100);
    }

    public d createServerRunnable(int r100) {
        return new d(this, r100);
    }

    public Response handle(c r100) {
        Iterator<vwc.c<c, Response>> r101 = this.interceptors.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Response r102 = r101.next().a(r100);
        if (r102 == null) goto L4;
        return r102;
    L9:
        return this.httpHandler.a(r100);
    }

    public Response serve(c r100) {
        return Response.h(Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void setAsyncRunner(uwc.b r100) {
        this.asyncRunner = r100;
    }

    public void setHTTPHandler(vwc.c<c, Response> r100) {
        this.httpHandler = r100;
    }

    public void setServerListener(IServerListener r100) {
        this.serverListener = r100;
    }

    public void setServerSocketFactory(vwc.b<ServerSocket, IOException> r100) {
        this.serverSocketFactory = r100;
    }

    public void setTempFileManagerFactory(vwc.a<twc.d> r100) {
        this.tempFileManagerFactory = r100;
    }

    public void start(int r100) throws IOException {
        start(r100, true);
    }

    public static Map<String, List<String>> decodeParameters(Map<String, String> r100) {
        return decodeParameters(r100.get(QUERY_STRING_PARAMETER));
    }

    public NanoHTTPD(String r100, int r101) {
        this.serverSocketFactory = new swc.a();
        this.interceptors = new ArrayList(4);
        this.hostname = r100;
        this.myPort = r101;
        setTempFileManagerFactory(new twc.b());
        setAsyncRunner(new uwc.a());
        this.httpHandler = new a(this);
    }

    private static void loadMimeTypes(Map<String, String> r100, String r110) {
        Enumeration<URL> r101 = NanoHTTPD.class.getClassLoader().getResources(r110);     // Catch: IOException -> L18
    L4:
        if (r101.hasMoreElements() == false) goto L25;
        URL r102 = r101.nextElement();     // Catch: IOException -> L18
        Properties r103 = new Properties();     // Catch: IOException -> L18
        InputStream r104 = null;
        r104 = r102.openStream();     // Catch: Throwable -> L10 IOException -> L12
        r103.load(r104);     // Catch: Throwable -> L10 IOException -> L12
    L8:
        safeClose(r104);     // Catch: IOException -> L18
        r100.putAll(r103);     // Catch: IOException -> L18
        goto L4
    L12:
        e = move-exception;
        LOG.log(Level.SEVERE, "could not load mimetypes from " + r102, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        safeClose(r104);     // Catch: IOException -> L18
        throw th;     // Catch: IOException -> L18
    L25:
        return;
    L18:
        LOG.log(Level.INFO, "no mime types available at " + r110);
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String r100, char[] r101) throws IOException {
        KeyStore r102 = KeyStore.getInstance(KeyStore.getDefaultType());     // Catch: Exception -> L9
        InputStream r103 = NanoHTTPD.class.getResourceAsStream(r100);     // Catch: Exception -> L9
        if (r103 == null) goto L8;
        r102.load(r103, r101);     // Catch: Exception -> L9
        KeyManagerFactory r104 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());     // Catch: Exception -> L9
        r104.init(r102, r101);     // Catch: Exception -> L9
        return makeSSLSocketFactory(r102, r104);
    L8:
        throw new IOException("Unable to load keystore from classpath: " + r100);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    public org.nanohttpd.protocols.http.a createClientHandler(Socket r100, InputStream r101) {
        this.currentHandler = new org.nanohttpd.protocols.http.a(this, r101, r100);
        return this.currentHandler;
    }

    public void makeSecure(SSLServerSocketFactory r100, String[] r101) {
        this.serverSocketFactory = new swc.b(r100, r101);
    }

    public void notifyError(int r100, String r101) {
        CastProxyMonitor.getInstance().notifyError(r100, r101);
    }

    public void start(int r100, boolean r101) throws IOException {
        this.myServerSocket = getServerSocketFactory().create();
        this.myServerSocket.setReuseAddress(true);
        d r102 = createServerRunnable(r100);
        PthreadThreadV2 r103 = new PthreadThreadV2(r102, "ttp/NanoHTTPD");
        this.myThread = r103;
        r103.setDaemon(r101);
        ThreadMethodProxy.setName(this.myThread, "NanoHttpd Main Listener");
        ThreadMethodProxy.start(this.myThread);
    L4:
        if (r102.f526199d == true) goto L10;
        if (r102.f526198c != null) goto L10;
        Thread.sleep(10);     // Catch: Throwable -> L14
    L10:
        IOException r104 = r102.f526198c;
        if (r104 != null) goto L13;
        return;
    L13:
        throw r104;
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore r100, KeyManager[] r101) throws IOException {
        TrustManagerFactory r102 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: Exception -> L4
        r102.init(r100);     // Catch: Exception -> L4
        SSLContext r103 = SSLContext.getInstance("TLS");     // Catch: Exception -> L4
        r103.init(r101, r102.getTrustManagers(), null);     // Catch: Exception -> L4
        return r103.getServerSocketFactory();
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore r100, KeyManagerFactory r101) throws IOException {
        return makeSSLSocketFactory(r100, r101.getKeyManagers());
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }
}
