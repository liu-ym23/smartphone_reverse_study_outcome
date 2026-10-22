package o17;

import android.text.TextUtils;
import com.bytedance.lynx.webview.internal.Setting;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l17.o;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f521709c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f521710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f521711b;

    public static class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public b() {
        if (Setting.c().b("sdk_enable_setting_with_cookie", false) == false) goto L10;
        this.f521711b = new o(CookiePolicy.ACCEPT_ALL);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public static HttpURLConnection a(b r100, e r101) throws IOException, KeyManagementException, NoSuchAlgorithmException {
        r100.getClass();
        URL r102 = new URL(r101.f521715b);
        String r103 = r102.getHost();     // Catch: Throwable -> L8 IOException -> L47
        String r104 = r102.getPath();     // Catch: Throwable -> L8 IOException -> L47
        if (com.obric.assistant.network.okhttp.a.c(r103, r104) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r103 + " path=" + r104);     // Catch: Throwable -> L8 IOException -> L47
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r103, r104), r103, r104);     // Catch: Throwable -> L8 IOException -> L47
        throw new IOException("[NetGuard] dropped " + r102);     // Catch: Throwable -> L8 IOException -> L47
    L10:
        HttpURLConnection r105 = (HttpURLConnection) r102.openConnection();
        r105.setConnectTimeout(r101.f521718e);
        r105.setReadTimeout(r101.f521718e);
        r105.setUseCaches(false);
        r105.setDoInput(true);
        Map<String, String> r106 = r101.f521714a;
        if (r106 == null) goto L49;
        Iterator<String> r107 = r106.keySet().iterator();
    L14:
        if (r107.hasNext() == false) goto L49;
        String r108 = r107.next();
        r105.addRequestProperty(r108, r101.f521714a.get(r108));
    L49:
        o r109 = r100.f521711b;     // Catch: Exception -> L31
        if (r109 == null) goto L33;
        Map<String, List<String>> r110 = r109.get(new URI(r101.f521715b), new HashMap());     // Catch: Exception -> L31
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L31
        if (r110 == null) goto L27;
        List r112 = (List) ((HashMap) r110).get("Cookie");     // Catch: Exception -> L31
        if (r112 == null) goto L27;
        Iterator r113 = r112.iterator();     // Catch: Exception -> L31
    L25:
        if (r113.hasNext() == false) goto L27;
        r111.append((String) r113.next());     // Catch: Exception -> L31
    L27:
        String r114 = r111.toString();     // Catch: Exception -> L31
        if (r114.isEmpty() == true) goto L33;
        r105.addRequestProperty("Cookie", r114);     // Catch: Exception -> L31
    L33:
        if ("POST".equals(r101.f521716c) == false) goto L35;
    L43:
        r105.setRequestMethod(r101.f521716c);
        if (r101.f521717d == null) goto L46;
        r105.setDoOutput(true);
        DataOutputStream r115 = new DataOutputStream(r105.getOutputStream());
        r115.write(r101.f521717d.getBytes());
        r115.close();
    L46:
        return r105;
    L35:
        if ("PUT".equals(r101.f521716c) == true) goto L43;
        if ("PATCH".equals(r101.f521716c) == true) goto L43;
        if (TextUtils.isEmpty(r101.f521716c) == true) goto L42;
        r105.setRequestMethod(r101.f521716c);
        goto L46
    L42:
        r105.setRequestMethod("GET");
    L47:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }

    public static byte[] b(b r100, InputStream r101) throws IOException {
        r100.getClass();
        if (r101 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        byte[] r103 = new byte[2048];
    L6:
        int r104 = r101.read(r103, 0, 2048);
        if (r104 == (-1)) goto L9;
        r102.write(r103, 0, r104);
        goto L6
    L9:
        r102.flush();
        return r102.toByteArray();
    }

    public final void d(e r100, c r101) {
        o17.a r102 = new o17.a(this, r100, r101);
        if (this.f521710a != null) goto L5;
        this.f521710a = PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("DefaultHttpAdapter"));
    L5:
        this.f521710a.execute(r102);
    }

    public static String c(b r100, InputStream r101, d.a r102) throws IOException {
        r100.getClass();
        if (r101 != null) goto L5;
        return null;
    L5:
        StringBuilder r103 = new StringBuilder();
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r101));
        char[] r105 = new char[2048];
    L6:
        int r106 = r104.read(r105);
        if (r106 == (-1)) goto L11;
        r103.append(r105, 0, r106);
        if (r102 == null) goto L6;
        r103.length();
        goto L6
    L11:
        r104.close();
        return r103.toString();
    }
}
