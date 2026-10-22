package com.bytedance.locallife.pdp.container;

import com.bytedance.locallife.pdp.view.GoodsDetailDialogFragment;
import com.vivo.push.PushClientConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class GoodsDetailFragmentInstanceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c<GoodsDetailDialogFragment> f261106a;

    static {
        f261106a = new c(GoodsDetailDialogFragment.class.getName(), "GoodsDetailDialogFragment", GoodsDetailFragmentInstanceUtil$delegate$1.INSTANCE);
    }

    public static void a(String r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "simpleName");
        Intrinsics.checkNotNullParameter(r102, "getIns");
        if (Intrinsics.areEqual(f261106a.f261133a, r100) == false) goto L5;
        return;
    L5:
        c<GoodsDetailDialogFragment> r103 = f261106a;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (Intrinsics.areEqual(f261106a.f261133a, r100) == true) goto L10;
        f261106a = new c(r100, r101, r102);     // Catch: Throwable -> L13
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r103);
    }
}
