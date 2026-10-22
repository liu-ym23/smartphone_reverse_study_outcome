package ws7;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArrayList<APICallback<Pair<File, String>>>> f561074a = null;

    static {
        f561074a = new ConcurrentHashMap();
    }

    public e() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static Pair<File, String> b(String r110, String r111, String r112, String r113, int r210) {
        String r100 = r110;
        String r101 = r111;
        String r102 = r113;
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L93:
        RecordService r103 = RecordService.getInstance();
        String[] r104 = new String[10];
        r104[0] = "url";
        if (r100 != null) goto L96;
        r100 = "null";
    L96:
        r104[1] = r100;
        r104[2] = "fileSavePath";
        if (r101 != null) goto L99;
        r101 = "null";
    L99:
        r104[3] = r101;
        r104[4] = "fileName";
        if (r112 != null) goto L102;
        String r105 = "null";
    L103:
        r104[5] = r105;
        r104[6] = "fileMD5";
        if (r102 != null) goto L106;
        r102 = "null";
    L106:
        r104[7] = r102;
        r104[8] = "retryTimes";
        r104[9] = String.valueOf(r210);
        r103.recordEvent(4, "dowloadFileError", r104);
        return null;
    L102:
        r105 = r112;
        goto L103
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L93;
        if (TextUtils.isEmpty(r112) == false) goto L10;
        String r106 = i.f(r110.getBytes());
    L11:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101 + File.separator + r106);
        if (r107.exists() == true) goto L14;
        PolarisFileWrapper r108 = r107;
        int r114 = -1;
        BufferedInputStream r115 = null;
        PolarisFileOutputStreamWrapper r116 = null;
    L16:
        if (r114 >= r210) goto L92;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L22
        if (r109.exists() == false) goto L20;
    L24:
        URL r117 = new URL(r100);     // Catch: Throwable -> L22
        HttpURLConnection r118 = (HttpURLConnection) a(r117);     // Catch: Throwable -> L22
        r118.setRequestMethod("GET");     // Catch: Throwable -> L22
        r118.setConnectTimeout(5000);     // Catch: Throwable -> L22
        r118.setReadTimeout(10000);     // Catch: Throwable -> L22
        r118.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L22
        r118.connect();     // Catch: Throwable -> L22
        PolarisFileWrapper r119 = new PolarisFileWrapper(r101 + File.separator + r106);     // Catch: Throwable -> L22
        a(r117);     // Catch: Throwable -> L58
        BufferedInputStream r120 = new BufferedInputStream(r118.getInputStream());     // Catch: Throwable -> L58
        PolarisFileOutputStreamWrapper r121 = new PolarisFileOutputStreamWrapper(r119);     // Catch: Throwable -> L56
        byte[] r122 = new byte[1024];     // Catch: Throwable -> L54
    L29:
        int r123 = r120.read(r122);     // Catch: Throwable -> L54
        if (r123 == (-1)) goto L33;
        r121.write(r122, 0, r123);     // Catch: Throwable -> L54
        goto L29
    L33:
        if (TextUtils.isEmpty(r113) == false) goto L35;
        Pair<File, String> r124 = new Pair(r119, r100);     // Catch: Throwable -> L54
        r120.close();     // Catch: Throwable -> L51
        r121.close();     // Catch: Throwable -> L51
    L53:
        return r124;
    L51:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L53
    L35:
        if (r102.equals(i.e(r119.getAbsolutePath())) == false) goto L42;
        Pair<File, String> r125 = new Pair(r119, r100);     // Catch: Throwable -> L54
        r120.close();     // Catch: Throwable -> L39
        r121.close();     // Catch: Throwable -> L39
    L41:
        return r125;
    L39:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L41
    L42:
        f.f(r119);     // Catch: Throwable -> L54
        Pair<File, String> r126 = new Pair(null, "MD5-ERROR");     // Catch: Throwable -> L54
        r120.close();     // Catch: Throwable -> L45
        r121.close();     // Catch: Throwable -> L45
    L47:
        return r126;
    L45:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L54:
        th = th;
        r115 = r120;
        r116 = r121;
    L59:
        r108 = r119;
    L110:
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L80
        f.f(r108);     // Catch: Throwable -> L80
        r114 = r114 + 1;     // Catch: Throwable -> L80
        if (r114 >= r210) goto L62;
        if (r115 == null) goto L76;
        r115.close();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L76:
        if (r116 == null) goto L16;
        r116.close();     // Catch: Throwable -> L74
        goto L16
    L62:
        Pair<File, String> r127 = new Pair(null, "RETRY-OVER");     // Catch: Throwable -> L80
        if (r115 != null) goto L119;
    L67:
        if (r116 == null) goto L71;
        r116.close();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L71:
        return r127;
    L119:
        r115.close();     // Catch: Throwable -> L65
    L80:
        th = move-exception;
        if (r115 != null) goto L117;
    L86:
        if (r116 == null) goto L139;
        r116.close();     // Catch: Throwable -> L84
        throw th;
    L84:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        throw th;
    L139:
        throw th;
    L117:
        r115.close();     // Catch: Throwable -> L84
    L56:
        th = th;
        r115 = r120;
    L58:
        th = th;
        goto L59
    L20:
        if (r109.exists() == true) goto L24;
        r109.mkdirs();     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L110
    L92:
        return new Pair(r108, r108.getAbsolutePath());
    L14:
        return new Pair(r107, r107.getAbsolutePath());
    L10:
        r106 = r112;
        goto L11
    }
}
