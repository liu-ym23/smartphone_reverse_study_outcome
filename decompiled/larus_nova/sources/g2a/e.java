package g2a;

import com.larus.platform.api.f2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f479755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f479756b = null;

    public e() {
    }

    static {
        f479755a = new e();
        a r100 = new a();
        f2.f365106a.getClass();
        FLogger.f375446a.i("FlowSensitiveErase", "delegate type: ".concat("strict"));
        f479756b = r100;
    }

    public final String a(CharSequence r100, boolean r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        a r104 = f479756b;
        if (r104 != null) goto L7;
        return r100.toString();
    L7:
        return r104.f(r100, r101, r102, r103);
    }
}
