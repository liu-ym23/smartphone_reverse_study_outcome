package qg7;

import com.bytedance.bpea.basics.Cert;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.scene.ScenesDetector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532876a = 0;

    static {
    }

    public static b a(Cert r100, Function0 r101) {
        String r102 = r100.certToken();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        rg7.b r103 = rg7.a.f537714c;
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L16;
        return new b(false, "disable fastPass", r102, 0);
    L16:
        if (rg7.a.e(r102) == true) goto L18;
        boolean r105 = ScenesDetector.f270865a;
        if (ScenesDetector.e() == false) goto L22;
        boolean r106 = TMEnv.f270767a;
        if (((Boolean) r101.invoke()).booleanValue() == true) goto L28;
        return new b(true, "Can't read clipboard when clipboard content is empty", r102, -6001);
    L28:
        if (ScenesDetector.f() == false) goto L38;
        long r107 = ScenesDetector.b();
        rg7.b r108 = rg7.a.f537714c;
        if (r108 == null) goto L32;
        int r109 = r108.a();
    L34:
        if (r107 <= r109) goto L38;
        return new b(true, "Can't read clipboard in background", r102, -6003);
    L32:
        r109 = 30000;
    L38:
        return new b(false, "read fastPass check pass", r102, 0);
    L22:
        return new b(true, "Can't read clipboard before  agreed   privacy policy.", r102, -6002);
    L18:
        return new b(true, "token was Expired", r102, -6000);
    L9:
        if (((r103.b() | rg7.a.b(r102).d()) & 1) == 0) goto L11;
        r104 = true;
        goto L12
    }
}
