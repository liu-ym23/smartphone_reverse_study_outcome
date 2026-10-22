package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import ba6.g;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.kmp.ec.yata.view.render.controller.common.YataPerfLinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LinearContainerController extends com.bytedance.kmp.ec.yata.view.render.controller.common.a<LinearLayout> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> f251968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f251969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f251970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251971g;

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.a
    public final void c() {
        if (g() == false) goto L12;
        LinearLayout r100 = a();
        if ((r100 instanceof YataPerfLinearLayout) == false) goto L7;
        YataPerfLinearLayout r101 = (YataPerfLinearLayout) r100;
    L8:
        if (r101 == null) goto L13;
        r101.setShownStateChangedListener(new LinearContainerController$init$1(this));
        return;
    L13:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final boolean g() {
        if (b().f251820c.f251429e == true) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f251842a, "header") == true) goto L13;
        if (Intrinsics.areEqual(this.f251842a, ContainerPosition.BODY) == true) goto L13;
        if (Intrinsics.areEqual(this.f251842a, ContainerPosition.FOOTER) == true) goto L13;
        if ((a() instanceof YataPerfLinearLayout) == false) goto L13;
        return true;
    }

    public LinearContainerController(String r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        super(r100);
        this.f251968d = CollectionsKt.emptyList();
        this.f251969e = LazyKt.lazy(new LinearContainerController$itemAnimator$2(this));
        this.f251971g = "LinearContainerController-".concat(r100);
    }

    public static final /* synthetic */ LinearLayout e(LinearContainerController r100) {
        return r100.a();
    }

    public static final void f(LinearContainerController r100) {
        r100.getClass();
        YaTaLog.h();
    }

    public final void h(List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r100) {
        a().removeAllViews();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        int r101 = r100.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r103 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(r100, r102);
        View r104 = r103.a();
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r103.d(r104);
        a().addView(r104, r102);
        r102 = r102 + 1;
        goto L6
    }

    public final void i(g r100, LinkedHashSet<com.bytedance.kmp.ec.yata.view.render.controller.common.c> r101) {
        final List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r102 = CollectionsKt.toList(r101);
        if (Intrinsics.areEqual(r100.getStrategy(), aa6.a.C0038a.f2348b) == false) goto L5;
        boolean r103 = false;
    L6:
        ((com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a) this.f251969e.getValue()).reset();
        if (r103 == false) goto L13;
        List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r104 = this.f251968d;
        String r105 = YaTaLog.f251436a;     // Catch: IndexOutOfBoundsException -> L11
        YaTaLog.c(this.f251971g, LinearContainerController$incrementalUpdateWithAnim$1.INSTANCE);     // Catch: IndexOutOfBoundsException -> L11
        b.a(DiffUtil.calculateDiff(new HolderDiffCallback(r104, r102), false), new LinearContainerController$incrementalUpdateWithAnim$2(r102, this));     // Catch: IndexOutOfBoundsException -> L11
        ((com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a) this.f251969e.getValue()).c();     // Catch: IndexOutOfBoundsException -> L11
    L18:
        this.f251968d = r102;
        return;
    L11:
        e = move-exception;
        YataErrorManager r106 = b().f251821d;
        com.bytedance.kmp.ec.yata.common.error.d r107 = com.bytedance.kmp.ec.yata.common.error.c.j();
        r107.c("linearlayout_incrementalUpdateWithAnim");
        r107.i(e);
        r107.d("LinearLayout 更新数据Crash");
        r106.c(r107);
        h(r102);
        goto L18
    L13:
        List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r108 = this.f251968d;
        String r109 = YaTaLog.f251436a;     // Catch: IndexOutOfBoundsException -> L16
        YaTaLog.c(this.f251971g, LinearContainerController$incrementalUpdateWithoutAnim$1.INSTANCE);     // Catch: IndexOutOfBoundsException -> L16
        b.a(DiffUtil.calculateDiff(new HolderDiffCallback(r108, r102), false), new LinearContainerController$incrementalUpdateWithoutAnim$2(r102, this));     // Catch: IndexOutOfBoundsException -> L16
    L16:
        e = move-exception;
        YataErrorManager r110 = b().f251821d;
        com.bytedance.kmp.ec.yata.common.error.d r111 = com.bytedance.kmp.ec.yata.common.error.c.j();
        r111.c("linearlayout_incrementalUpdateWithoutAnim");
        r111.i(e);
        r111.d("LinearLayout 更新数据Crash");
        r110.c(r111);
        h(r102);
        goto L18
    L5:
        int r112 = com.bytedance.kmp.ec.yata.view.render.controller.common.b.f251845a;
        r103 = com.bytedance.kmp.ec.yata.view.render.controller.common.b.a(b(), r100, this.f251968d, r102, false);
        goto L6
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.a
    public final void d(String r100, final g r101, final LinkedHashSet<com.bytedance.kmp.ec.yata.view.render.controller.common.c> r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "storeData");
        Intrinsics.checkNotNullParameter(r102, "viewHolderLinkedSet");
        ((com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a) this.f251969e.getValue()).b(r101);
        if (g() == true) goto L5;
    L7:
        i(r101, r102);
    L8:
        a().post(new d(r103));
        return;
    L5:
        if (a().isShown() == true) goto L7;
        this.f251970f = new c(this, r101, r102);
        goto L8
    }
}
