package qg7;

import com.bytedance.bpea.basics.Cert;
import com.bytedance.timonbase.scene.ScenesDetector;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    static {
    }

    public static b a(Cert r100) {
        String r101 = r100.certToken();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        rg7.b r102 = rg7.a.f537714c;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L16;
        return new b(false, "disable fastPass", r101, 0);
    L16:
        if (rg7.a.e(r101) == true) goto L18;
        boolean r104 = ScenesDetector.f270865a;
        if (ScenesDetector.e() == true) goto L24;
        return new b(true, "Can't write clipboard before  agreed   privacy policy.", r101, -6002);
    L24:
        if (ScenesDetector.f() == false) goto L34;
        long r105 = ScenesDetector.b();
        rg7.b r106 = rg7.a.f537714c;
        if (r106 == null) goto L28;
        int r107 = r106.a();
    L30:
        if (r105 <= r107) goto L34;
        return new b(true, "Can't write clipboard in background", r101, -6003);
    L28:
        r107 = 30000;
    L34:
        return new b(false, "write fastPass check pass", r101, 0);
    L18:
        return new b(true, "token was Expired", r101, -6000);
    L9:
        if (((r102.b() | rg7.a.b(r101).d()) & 1) == 0) goto L11;
        r103 = true;
        goto L12
    }
}
