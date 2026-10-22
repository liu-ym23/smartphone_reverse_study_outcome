package mqc;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f514944a;

    public static String a(Context r110) {
        if (f514944a != null) goto L66;
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.getApplicationInfo().sourceDir);
        String r111 = "";
        ByteBuffer r101 = nqc.a.b(r100);     // Catch: Exception -> L10
        if (nqc.a.d(r101) == false) goto L9;
        String r102 = g.a(r101.array());     // Catch: Exception -> L10
        String r103 = "";
    L11:
        String[] r104 = {r102, nqc.a.f520154a, r103};
        if (TextUtils.isEmpty(r102) == false) goto L62;
        PolarisZipFileWrapper r105 = null;
        PolarisZipFileWrapper r106 = new PolarisZipFileWrapper(r100);     // Catch: Throwable -> L46 Exception -> L68
        goto L51
    L79:
        Enumeration<? extends ZipEntry> r107 = r106.entries();     // Catch: Throwable -> L43 Exception -> L45
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L43 Exception -> L45
        boolean r109 = false;
        boolean r112 = false;
        boolean r113 = false;
    L17:
        if (r107.hasMoreElements() == false) goto L30;
        ZipEntry r114 = r107.nextElement();     // Catch: Throwable -> L43 Exception -> L45
        if (r114.getName().startsWith("META-INF/") == false) goto L17;
        if (r114.getName().endsWith("MANIFEST.MF") == false) goto L24;
        r113 = true;
    L29:
        r108.add(Long.valueOf(r114.getCrc()));     // Catch: Throwable -> L43 Exception -> L45
        goto L17
    L24:
        if (r114.getName().endsWith(".SF") == false) goto L27;
        r109 = true;
        goto L29
    L27:
        if (r114.getName().endsWith(".RSA") == false) goto L29;
        r112 = true;
        goto L29
    L30:
        Collections.sort(r108, Collections.reverseOrder());     // Catch: Throwable -> L43 Exception -> L45
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L43 Exception -> L45
        Iterator r116 = r108.iterator();     // Catch: Throwable -> L43 Exception -> L45
    L32:
        if (r116.hasNext() == false) goto L34;
        r115.append((Long) r116.next());     // Catch: Throwable -> L43 Exception -> L45
        goto L32
    L34:
        if (r113 == false) goto L39;
        if (r109 == false) goto L39;
        if (r112 == false) goto L39;
        String r117 = g.a(r115.toString().getBytes());     // Catch: Throwable -> L43 Exception -> L45
        String r118 = "";
    L75:
        r106.close();     // Catch: Throwable -> L42
    L57:
        r104 = new String[3];
        r104[0] = r117;
        if (TextUtils.isEmpty(r117) == true) goto L61;
        r111 = OuterPayLoginWrapper.LOGIN_STYLE_V1;
    L61:
        r104[1] = r111;
        r104[2] = r118;
        goto L62
    L39:
        r118 = "without v1 signature.";
        r117 = "";
    L45:
        r105 = r106;
    L43:
        th = th;
        r105 = r106;
    L47:
        if (r105 != null) goto L73;
    L50:
        throw th;
    L73:
        r105.close();     // Catch: Throwable -> L67
    L46:
        th = th;
    L51:
        if (r105 != null) goto L69;
    L56:
        r117 = "";
        r118 = r117;
        goto L57
    L69:
        r105.close();     // Catch: Throwable -> L55
    L62:
        String r119 = r104[0];
        f514944a = r119;
        if (TextUtils.isEmpty(r119) == false) goto L66;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + r104[2]);
        goto L66
    L9:
        r103 = "without v2 & v3 signature.";
        r102 = "";
    L10:
        r102 = "";
        r103 = r102;
    L66:
        return f514944a;
    }

    public static String b(String r100, String r101) {
        Mac r102 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L13
        r102.init(new SecretKeySpec(r101.getBytes(), "HmacSHA256"));     // Catch: Exception -> L13
        byte[] r103 = r102.doFinal(r100.getBytes());     // Catch: Exception -> L13
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L13
        int r105 = 0;
    L4:
        if (r103 == null) goto L11;
        if (r105 >= r103.length) goto L11;
        String r106 = Integer.toHexString(r103[r105] & UByte.MAX_VALUE);     // Catch: Exception -> L13
        if (r106.length() != 1) goto L10;
        r104.append('0');     // Catch: Exception -> L13
    L10:
        r104.append(r106);     // Catch: Exception -> L13
        r105 = r105 + 1;     // Catch: Exception -> L13
    L11:
        return r104.toString().toLowerCase();
    L13:
        return "";
    }
}
