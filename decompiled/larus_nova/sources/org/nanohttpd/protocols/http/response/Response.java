package org.nanohttpd.protocols.http.response;

import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.ErrorCode;
import com.byted.cast.proxy.IServerListener;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.request.Method;

/* JADX INFO: loaded from: classes42.dex */
public class Response implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f526201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f526203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f526204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f526205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f526206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Method f526207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f526208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f526209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f526210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GzipUsage f526211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IServerListener f526212l;

    public static final enum GzipUsage extends Enum<GzipUsage> {
        public static final GzipUsage ALWAYS = null;
        public static final GzipUsage DEFAULT = null;
        public static final GzipUsage NEVER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GzipUsage[] f526213a = null;

        static {
            GzipUsage r100 = new GzipUsage("DEFAULT", 0);
            DEFAULT = r100;
            GzipUsage r101 = new GzipUsage("ALWAYS", 1);
            ALWAYS = r101;
            GzipUsage r102 = new GzipUsage("NEVER", 2);
            NEVER = r102;
            f526213a = new GzipUsage[]{r100, r101, r102};
        }

        public static GzipUsage[] values() {
            return (GzipUsage[]) f526213a.clone();
        }

        public static GzipUsage valueOf(String r100) {
            return (GzipUsage) r27.a.a(GzipUsage.class, r100);
        }

        public GzipUsage(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream r100 = this.f526203c;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public final boolean g() {
        return "close".equals(c(WsConstants.KEY_CONNECTION));
    }

    public final void r() {
        this.f526211k = GzipUsage.NEVER;
    }

    public final boolean t() {
        GzipUsage r100 = this.f526211k;
        if (r100 != GzipUsage.DEFAULT) goto L14;
        String r101 = this.f526202b;
        if (r101 != null) goto L7;
    L11:
        return false;
    L7:
        if (r101.toLowerCase().contains("text/") == false) goto L9;
        return true;
    L9:
        if (this.f526202b.toLowerCase().contains("/json") == false) goto L11;
        return true;
    L14:
        if (r100 == GzipUsage.ALWAYS) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<String> a() {
        return this.f526210j;
    }

    public final InputStream b() {
        return this.f526203c;
    }

    public final String d() {
        return this.f526202b;
    }

    public final Method e() {
        return this.f526207g;
    }

    public final b f() {
        return this.f526201a;
    }

    public final String c(String r100) {
        Map<String, String> r101 = this.f526206f;
        HashMap r102 = (HashMap) r101;
        return (String) r102.get(r100.toLowerCase());
    }

    public final void k(OutputStream r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        r101.setTimeZone(TimeZone.getTimeZone("GMT"));
    L61:
        e = move-exception;
        NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", e);
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FFMPEG_WRITE_DATA_ERROR, "Could not send response to the client:" + e);
        return;
    L4:
        if (this.f526201a == null) goto L60;
        String r102 = new rwc.a(this.f526202b).f539736c;     // Catch: IOException -> L61
        if (r102 != null) goto L8;
        r102 = "US-ASCII";
    L8:
        PrintWriter r103 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(r100, r102)), false);     // Catch: IOException -> L61
        r103.append("HTTP/1.1 ").append(this.f526201a.getDescription()).append(" \r\n");     // Catch: IOException -> L61
        String r104 = this.f526202b;     // Catch: IOException -> L61
        if (r104 == null) goto L12;
        j(r103, "Content-Type", r104);     // Catch: IOException -> L61
    L12:
        if (c("date") != null) goto L14;
        j(r103, "Date", r101.format(new Date()));     // Catch: IOException -> L61
    L14:
        Iterator r105 = ((HashMap) this.f526205e).entrySet().iterator();     // Catch: IOException -> L61
    L16:
        if (r105.hasNext() == false) goto L18;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: IOException -> L61
        j(r103, (String) r106.getKey(), (String) r106.getValue());     // Catch: IOException -> L61
        goto L16
    L18:
        Iterator r107 = ((ArrayList) this.f526210j).iterator();     // Catch: IOException -> L61
    L20:
        if (r107.hasNext() == false) goto L23;
        j(r103, "Set-Cookie", (String) r107.next());     // Catch: IOException -> L61
        goto L20
    L23:
        if (c(WsConstants.KEY_CONNECTION) != null) goto L30;
        if (this.f526209i == false) goto L27;
        String r108 = "keep-alive";
    L28:
        j(r103, "Connection", r108);     // Catch: IOException -> L61
        goto L30
    L27:
        r108 = "close";
    L30:
        if (c("content-length") == null) goto L33;
        this.f526211k = GzipUsage.NEVER;     // Catch: IOException -> L61
    L33:
        if (t() == false) goto L36;
        j(r103, "Content-Encoding", DownloadHelper.GZIP);     // Catch: IOException -> L61
        this.f526208h = true;     // Catch: IOException -> L61
    L36:
        if (this.f526203c == null) goto L38;
        long r109 = this.f526204d;     // Catch: IOException -> L61
    L39:
        Method r110 = this.f526207g;     // Catch: IOException -> L61
        Method r111 = Method.HEAD;     // Catch: IOException -> L61
        if (r110 == r111) goto L45;
        if (this.f526208h == false) goto L45;
        j(r103, "Transfer-Encoding", DownloadHelper.VALUE_CHUNKED);     // Catch: IOException -> L61
    L47:
        r103.append("\r\n");     // Catch: IOException -> L61
        r103.flush();     // Catch: IOException -> L61
        if (this.f526207g != r111) goto L50;
    L57:
        m(r100, r109);     // Catch: IOException -> L61
    L58:
        r100.flush();     // Catch: IOException -> L61
        NanoHTTPD.safeClose(this.f526203c);     // Catch: IOException -> L61
        return;
    L50:
        if (this.f526208h == false) goto L57;
        a r112 = new a(r100);     // Catch: IOException -> L61
        m(r112, -1);     // Catch: IOException -> L61
        r112.a();     // Catch: Exception -> L54
    L55:
        if (this.f526203c == null) goto L58;
        this.f526203c.close();     // Catch: IOException -> L61
    L45:
        if (t() == true) goto L47;
        r109 = n(r103, r109);     // Catch: IOException -> L61
        goto L47
    L38:
        r109 = 0;
        goto L39
    L60:
        throw new Error("sendResponse(): Status can't be null.");     // Catch: IOException -> L61
    }

    public final void p(boolean r100) {
        this.f526209i = r100;
    }

    public final void q(Method r100) {
        this.f526207g = r100;
    }

    public final void l(OutputStream r110, long r111) throws IOException {
        byte[] r100 = new byte[(int) 16777216];
        if (r111 != (-1)) goto L5;
        boolean r101 = true;
    L7:
        if (r111 > 0) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        if (r101 == false) goto L11;
        long r102 = 16777216;
    L12:
        int r103 = this.f526203c.read(r100, 0, (int) r102);
        if (r103 <= 0) goto L14;
        r110.write(r100, 0, r103);     // Catch: Exception -> L18
        if (r101 == true) goto L7;
        r111 = r111 - ((long) r103);
    L18:
        e = move-exception;
        if (this.f526203c == null) goto L22;
        this.f526203c.close();
    L22:
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FFMPEG_WRITE_BODY_DATA_ERROR, "sendBody write Exception:" + e);
        return;
    L14:
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FFMPEG_READ_DATA_ERROR, "read size is " + r103 + ", bytesToRead is " + r102);
        return;
    L11:
        r102 = Math.min(r111, 16777216);
        goto L12
    L5:
        r101 = false;
        goto L7
    }

    public final void m(OutputStream r100, long r101) throws IOException {
        if (t() == true) goto L14;
        l(r100, r101);
        return;
    L14:
        GZIPOutputStream r102 = new GZIPOutputStream(r100);     // Catch: Exception -> L6
    L10:
        if (r102 == null) goto L16;
        l(r102, -1);
        r102.finish();
        return;
    L16:
        return;
    L6:
        InputStream r103 = this.f526203c;
        if (r103 == null) goto L9;
        r103.close();
    L9:
        r102 = null;
        goto L10
    }

    public final long n(PrintWriter r100, long r101) {
        String r102 = c("content-length");
        if (r102 != null) goto L9;
        r100.print("Content-Length: " + r101 + "\r\n");
        return r101;
    L9:
        return CastLongProtector.parseLong(r102);
    L6:
        NanoHTTPD.LOG.severe("content-length was no number ".concat(r102));
        return r101;
    }

    public static Response h(Status r100, String r110, String r111) {
        rwc.a r101 = new rwc.a(r110);
        if (r111 == null) goto L5;
        String r102 = r101.f539736c;     // Catch: UnsupportedEncodingException -> L21
        String r103 = "US-ASCII";
        if (r102 != null) goto L11;
        r102 = "US-ASCII";
    L11:
        if (Charset.forName(r102).newEncoder().canEncode(r111) == false) goto L13;
    L15:
        String r112 = r101.f539736c;     // Catch: UnsupportedEncodingException -> L21
        if (r112 == null) goto L19;
        r103 = r112;
    L19:
        byte[] r113 = r111.getBytes(r103);     // Catch: UnsupportedEncodingException -> L21
    L24:
        return new Response(r100, r101.f539734a, new ByteArrayInputStream(r113), r113.length);
    L13:
        if (r101.f539736c != null) goto L15;
        r101 = new rwc.a(r110.concat("; charset=UTF-8"));     // Catch: UnsupportedEncodingException -> L21
    L21:
        e = move-exception;
        NanoHTTPD.LOG.log(Level.SEVERE, "encoding problem, responding nothing", e);
        r113 = new byte[0];
        goto L24
    L5:
        return new Response(r100, r110, new ByteArrayInputStream(new byte[0]), 0);
    }

    public static Response i(Status r100, String r101, byte[] r102) {
        return new Response(r100, r101, new ByteArrayInputStream(r102), r102.length);
    }

    public static void j(PrintWriter r100, String r101, String r102) {
        r100.append(r101).append(": ").append(r102).append("\r\n");
    }

    public Response(Status r100, String r101, InputStream r102, long r103) {
        this.f526205e = new AnonymousClass1(this);
        this.f526206f = new HashMap();
        this.f526211k = GzipUsage.DEFAULT;
        this.f526201a = r100;
        this.f526202b = r101;
        boolean r104 = false;
        if (r102 != null) goto L5;
        this.f526203c = new ByteArrayInputStream(new byte[0]);
        this.f526204d = 0;
    L7:
        if (this.f526204d >= 0) goto L9;
        r104 = true;
    L9:
        this.f526208h = r104;
        this.f526209i = true;
        this.f526210j = new ArrayList(10);
        return;
    L5:
        this.f526203c = r102;
        this.f526204d = r103;
        goto L7
    }
}
