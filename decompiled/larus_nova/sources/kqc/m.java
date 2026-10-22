package kqc;

import android.text.TextUtils;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public final class m {
    public static int a(i r100) {
        g r101 = r100.f505698a.a();
        monitor-enter(r101);
        long r102 = r101.f505697a;     // Catch: Throwable -> L8
        monitor-exit(r101);
        return (int) r102;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b(byte[] r100, d r101) throws IOException {
        b r102 = new b(r100, r101);
        ByteArrayInputStream r103 = new ByteArrayInputStream(r100);
        if (r102.f505679f == false) goto L6;
        r102.f505679f = false;
        r102.f505678e = null;
        r102.f505680g = null;
        b.a r104 = r102.f505681h;
        r104.f505690b = 0;
        r104.f505691c = 0;
        r102.f505683j = -1;
        r102.f505684k = null;
    L6:
        r102.f505678e = new i(new k(new g(r103)));
    L8:
        if (r102.f505678e == null) goto L21;
        r102.a();     // Catch: IOException -> L14
        if (r102.f505683j != 1) goto L8;
        return;
    L14:
        e = move-exception;
        if (r102.f505679f == false) goto L19;
        r102.f505679f = false;
        r102.f505678e = null;
        r102.f505680g = null;
        b.a r105 = r102.f505681h;
        r105.f505690b = 0;
        r105.f505691c = 0;
        r102.f505683j = -1;
        r102.f505684k = null;
    L19:
        throw e;
    L21:
        throw new RuntimeException("Parser is not opened.");
    }

    public static void d(String r100, byte[] r101, d r102) throws Throwable {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r102.f505696e.contains(r100) == true) goto L9;
        return;
    L9:
        if (r100.equals(ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME) == false) goto L12;
        b(r101, r102);
        return;
    L12:
        if (r100.endsWith(".xml") == false) goto L16;
        if (r100.startsWith("res/") == false) goto L16;
    L17:
        b(r101, r102);
        return;
    L16:
        if (TextUtils.equals(r100, ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME) == true) goto L17;
        if (r100.equals("resources.arsc") == false) goto L58;
        a r103 = new a(r101, r102);
        r103.b();
        r103.a(2);
        int r104 = r103.f505667c.readInt();
        n.a(r103.f505667c);
        r103.b();
        int r105 = 0;
    L21:
        if (r105 >= r104) goto L59;
        r103.a(512);
        r103.f505667c.readInt();
        r103.f505667c.skipBytes(256);
        r103.f505667c.skipBytes(4);
        r103.f505667c.skipBytes(4);
        r103.f505667c.skipBytes(4);
        r103.f505667c.skipBytes(4);
        if (r103.f505669e.f505671b == 288) goto L25;
    L29:
        n.a(r103.f505667c);
        n.a(r103.f505667c);
        r103.b();
        boolean r106 = true;
    L30:
        if (r106 == false) goto L43;
        short r107 = r103.f505669e.f505670a;
        if (r107 != 514) goto L34;
        r103.e();
        goto L30
    L34:
        if (r107 != 515) goto L35;
        r103.a(515);
        int r108 = r103.f505667c.readInt();
        int r109 = 0;
    L37:
        if (r109 >= r108) goto L40;
        r103.f505667c.readInt();
        r103.f505667c.skipBytes(256);
        r109 = r109 + 1;
    L40:
        if (r103.b().f505670a != 513) goto L30;
        r103.e();
        goto L40
    L35:
        r106 = false;
        goto L30
    L43:
        r105 = r105 + 1;
        goto L21
    L25:
        if (r103.f505667c.readInt() <= 0) goto L29;
        throw new RuntimeException("don't support");
    L59:
        return;
    }

    public static int c(byte[] r110, int r111, int r112, j r113) {
        if (r111 < 2130706432) goto L24;
        d r114 = (d) r113;
        r114.getClass();
        String r100 = "0x" + Integer.toHexString(r111);
        String r101 = (String) r114.f505692a.opt(r100);
        if (r101 == null) goto L23;
        int r102 = r114.f505693b.getIdentifier(r101.split(" ")[1], r101.split(" ")[0], Zeus.getAppApplication().getPackageName());
        if (r102 != 0) goto L11;
        r102 = r114.f505693b.getIdentifier(r101.split(" ")[1].replaceAll("_", "."), r101.split(" ")[0], Zeus.getAppApplication().getPackageName());
    L11:
        if (r102 != 0) goto L13;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(r101));
        goto L23
    L13:
        String r103 = "0x" + Integer.toHexString(r102);
        if (TextUtils.equals(r114.f505694c.optString(r100), r101) == false) goto L25;
        r114.f505694c.remove(r100);
    L25:
        r114.f505694c.put(r103, r101);     // Catch: Throwable -> L18
    L20:
        if (r102 == r111) goto L22;
        int[] r115 = r114.f505695d;
        r115[0] = r115[0] + 1;
    L22:
        r111 = r102;
    L18:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
    L23:
        byte r104 = (byte) (r111 >> 0);
        byte[] r116 = {r104, (byte) (r111 >> 8), (byte) (r111 >> 16), (byte) (r111 >> 24)};
        r110[r112] = r104;
        r110[r112 + 1] = r116[1];
        r110[r112 + 2] = r116[2];
        r110[r112 + 3] = r116[3];
    L24:
        return r111;
    }
}
