package ke6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f503030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f503031b = 0;

    static {
        f503031b = com.bytedance.lark.policy.utils.c.c().h() * ((long) 1000);
    }

    public static void a() {
        a r100 = f503030a;
        a r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r100 = null;
    L6:
        if (r100.hasMessages(101) == true) goto L13;
        a r102 = f503030a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L11:
        r101.sendEmptyMessageDelayed(101, 1000);
        return;
    L10:
        r101 = r102;
        goto L11
    }
}
