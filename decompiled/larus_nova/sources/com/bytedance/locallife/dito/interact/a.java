package com.bytedance.locallife.dito.interact;

import com.bytedance.locallife.dito.core.DitoInteractDialogFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoInteractDialogFragment f258443a;

    /* JADX INFO: renamed from: com.bytedance.locallife.dito.interact.a$a, reason: collision with other inner class name */
    public static final class C3658a {
    }

    static {
    }

    public a(DitoInteractDialogFragment r100) {
        this.f258443a = r100;
    }

    public static void a(a r100, int r101, CustomBottomBehavior r102, final DitoDataCenter r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "behavior");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        r102.setPeekHeight(r101, false);
        if (r102.M == true) goto L5;
        rq6.a.f538927a.b("DitoPageInPopupHelper", "behavior should set alwaysCollapsedState is true");
        return;
    L5:
        DitoInteractDialogFragment r104 = r100.f258443a;
        if (r104 != null) goto L8;
        rq6.a.f538927a.b("DitoPageInPopupHelper", "interactFragment is null!");
        return;
    L8:
        r104.setViewHeight(r101, new DitoPageInPopupHelper$setPeekHeight$1(r103));
    }
}
