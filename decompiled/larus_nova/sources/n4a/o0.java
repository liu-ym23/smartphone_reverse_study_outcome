package n4a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class o0 {
    public static void b(n0 r100) {
        h0 r101 = null;
    L39:
        th = move-exception;
        r.f(th, "leg", "uts");     // Catch: Throwable -> L51
        if (r101 == null) goto L77;
    L62:
        r101.close();     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        th.printStackTrace();
        return;
    L77:
        return;
    L51:
        th = move-exception;
        if (r101 != null) goto L68;
    L57:
        throw th;
    L68:
        r101.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L4:
        if (r100.f517550f.e() == false) goto L41;
        r100.f517550f.a();     // Catch: Throwable -> L39
        r101 = h0.b(new PolarisFileWrapper(r100.f517545a), r100.f517546b);     // Catch: Throwable -> L39
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L39
        byte[] r103 = c(r101, r100, r102);     // Catch: Throwable -> L39
        if (r103 != null) goto L8;
    L66:
        r101.close();     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r103.length == 0) goto L66;
        com.loc.a r104 = new com.loc.a(r103, r100.f517547c);     // Catch: Throwable -> L39
        com.loc.c.c();     // Catch: Throwable -> L39
        JSONObject r105 = new JSONObject(new String(com.loc.c.a(r104).f517453a));     // Catch: Throwable -> L39
        if (r105.has("code") == false) goto L41;
        if (r105.getInt("code") != 1) goto L41;
        h1 r106 = r100.f517550f;     // Catch: Throwable -> L39
        if (r106 == null) goto L19;
        r106.b(r103.length);     // Catch: Throwable -> L39
    L19:
        if (r100.f517550f.d() < Integer.MAX_VALUE) goto L60;
        r101.close();     // Catch: Throwable -> L31
        h0.g(r101.f517312a);     // Catch: Throwable -> L31
    L74:
        return;
    L31:
        th = move-exception;
        r.f(th, "ofm", "dlo");     // Catch: Throwable -> L39
        return;
    L60:
        Iterator r107 = r102.iterator();     // Catch: Throwable -> L26
    L22:
        if (r107.hasNext() == false) goto L24;
        r101.h((String) r107.next());     // Catch: Throwable -> L26
        goto L22
    L24:
        r101.close();     // Catch: Throwable -> L26
    L72:
        return;
    L26:
        th = move-exception;
        r.f(th, "ofm", "dlo");     // Catch: Throwable -> L39
        return;
    L41:
        if (r101 != null) goto L62;
    }

    public static void a(String r100, byte[] r101, n0 r102) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        OutputStream r103 = null;
    L45:
        th = th;
        h0 r104 = null;
    L47:
        if (r103 != null) goto L66;
    L52:
        if (r104 == null) goto L75;
        r104.close();     // Catch: Throwable -> L55
        throw th;
    L55:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L75:
        throw th;
    L66:
        r103.close();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L73:
        boolean r105 = new PolarisFileWrapper(r102.f517545a, r100 + ".0").exists();     // Catch: Throwable -> L7
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r102.f517545a);     // Catch: Throwable -> L45
        if (r106.exists() == true) goto L14;
        r106.mkdirs();     // Catch: Throwable -> L45
    L14:
        r104 = h0.b(r106, r102.f517546b);     // Catch: Throwable -> L45
        int r107 = r102.f517548d;     // Catch: Throwable -> L43
        if (r107 >= 10) goto L19;
        r107 = 10;
    L21:
        r104.f517321j = r107;     // Catch: Throwable -> L43
        byte[] r108 = r102.f517549e.b(r101);     // Catch: Throwable -> L43
        h0.d r109 = r104.f(r100);     // Catch: Throwable -> L43
        OutputStream r110 = r109.a();     // Catch: Throwable -> L43
        r110.write(r108);     // Catch: Throwable -> L41
        if (r109.f517330c == false) goto L25;
        h0.e(r109.f517331d, r109, false);     // Catch: Throwable -> L41
        r109.f517331d.h(r109.f517328a.f517334a);     // Catch: Throwable -> L41
    L26:
        monitor-enter(r104);     // Catch: Throwable -> L41
        r104.p();     // Catch: Throwable -> L38
        r104.q();     // Catch: Throwable -> L38
        r104.f517320i.flush();     // Catch: Throwable -> L38
        monitor-exit(r104);     // Catch: Throwable -> L41
        r110.close();     // Catch: Throwable -> L31
    L64:
        r104.close();     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L64
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L25:
        h0.e(r109.f517331d, r109, true);     // Catch: Throwable -> L41
    L41:
        th = th;
        r103 = r110;
        goto L47
    L19:
        if (r107 <= 10000) goto L21;
        r107 = 10000;
    L43:
        th = th;
        goto L47
    L7:
        th = move-exception;
        r.f(th, "leg", "fet");     // Catch: Throwable -> L45
        r105 = false;
        goto L9
    }

    public static byte[] c(h0 r100, n0 r101, List<String> r110) {
        File r102 = r100.f517312a;     // Catch: Throwable -> L20
        if (r102 == null) goto L23;
        if (r102.exists() == false) goto L23;
        String[] r103 = r102.list();     // Catch: Throwable -> L20
        int r104 = r103.length;     // Catch: Throwable -> L20
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104) goto L15;
        String r107 = r103[r105];     // Catch: Throwable -> L20
        if (r107.contains(".0") == false) goto L14;
        String r108 = r107.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0];     // Catch: Throwable -> L20
        byte[] r109 = t0.c(r100, r108);     // Catch: Throwable -> L20
        r106 = r106 + r109.length;     // Catch: Throwable -> L20
        ((ArrayList) r110).add(r108);     // Catch: Throwable -> L20
        if (r106 > r101.f517550f.d()) goto L15;
        r101.f517551g.c(r109);     // Catch: Throwable -> L20
    L14:
        r105 = r105 + 1;     // Catch: Throwable -> L20
    L15:
        if (r106 > 0) goto L18;
        return null;
    L18:
        return r101.f517551g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        r.f(th, "leg", "gCo");
        goto L23
    }
}
