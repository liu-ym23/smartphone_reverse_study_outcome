package za;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f571085a = 0;

    static {
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        b(3, r100, r101);
    }

    public static void b(int r100, String r101, Function0 r102) {
        if (r100 != 3) goto L8;
        if (h.f246501h.f246502a == false) goto L8;
        HybridLogger r103 = HybridLogger.f246343a;
        HybridLogger.f(r101, (String) r102.invoke(), null, 12);
        return;
    L8:
        if (r100 != 4) goto L10;
    L11:
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.m(r101, (String) r102.invoke(), null, null, 12);
        return;
    L10:
        if (r100 == 5) goto L11;
    }
}
