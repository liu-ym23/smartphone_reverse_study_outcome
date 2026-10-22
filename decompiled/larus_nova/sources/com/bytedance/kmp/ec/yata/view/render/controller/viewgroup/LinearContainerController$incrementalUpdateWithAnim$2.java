package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ha6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/kmp/ec/yata/view/render/controller/viewgroup/LinearContainerController$incrementalUpdateWithAnim$2", "Landroidx/recyclerview/widget/ListUpdateCallback;", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class LinearContainerController$incrementalUpdateWithAnim$2 implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<com.bytedance.kmp.ec.yata.view.render.controller.common.c> f251973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinearContainerController f251974c;

    public final int a(int r100) {
        List r101 = (List) this.f251972a.getValue();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (((Number) r104).intValue() > r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L12:
        return r102.size();
    }

    public LinearContainerController$incrementalUpdateWithAnim$2(List r100, LinearContainerController r101) {
        this.f251973b = r100;
        this.f251974c = r101;
        this.f251972a = LazyKt.lazy(LinearContainerController$incrementalUpdateWithAnim$2$removedAnimItemIndexList$2.INSTANCE);
        YaTaLog.h();
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int r100, int r101) {
        int r102 = r101 + r100;
    L3:
        if (r100 >= r102) goto L14;
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r103 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251973b, r100);
        ba6.d r104 = r103.c();
        r104.d();
        View r105 = r103.a();
        r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r103.d(r105);
        List r106 = (List) this.f251972a.getValue();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L6:
        if (r108.hasNext() == false) goto L13;
        Object r109 = r108.next();
        if (((Number) r109).intValue() >= r100) goto L10;
        boolean r110 = true;
    L11:
        if (r110 == false) goto L6;
        r107.add(r109);
        goto L6
    L10:
        r110 = false;
        goto L11
    L13:
        int r111 = r107.size() + r100;
        LinearContainerController.e(this.f251974c).addView(r105, r111);
        ((com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a) this.f251974c.f251969e.getValue()).d(r104, r105);
        LinearContainerController.f(this.f251974c);
        r100 = r100 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(final int r100, final int r101) {
        String r102 = YaTaLog.f251436a;
        YaTaLog.c(this.f251974c.f251971g, new LinearContainerController$incrementalUpdateWithAnim$2$onMoved$1(r100, r101));
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int r110, int r111) {
        int r112 = (r111 + r110) - 1;
        if (r110 > r112) goto L11;
    L4:
        final int r100 = r112 + a(r112);
        final View r101 = LinearContainerController.e(this.f251974c).getChildAt(r100);
        final String r102 = e.b(r101);
        ba6.d r113 = e.a(r101);
        final String r103 = null;
        com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a r114 = (com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a) this.f251974c.f251969e.getValue();
        final LinearContainerController r104 = this.f251974c;
        final int r105 = r112;
        if (r114.a(r102, r113, r101, new LinearContainerController$incrementalUpdateWithAnim$2$onRemoved$isNeedDisappearingAnim$1(r104, r101, this, r105, r100, r102, r103)) == false) goto L7;
        ((List) this.f251972a.getValue()).add(Integer.valueOf(r112));
    L8:
        LinearContainerController.f(this.f251974c);
        if (r112 == r110) goto L13;
        r112 = r112 - 1;
        goto L4
    L13:
        return;
    L7:
        LinearContainerController.e(this.f251974c).removeView(r101);
        goto L8
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onChanged(int r100, int r101, Object r102) {
        int r103 = r101 + r100;
    L3:
        if (r100 >= r103) goto L18;
        int r104 = a(r100) + r100;
        View r105 = LinearContainerController.e(this.f251974c).getChildAt(r104);
        String r106 = e.b(r105);
        if (r106 == null) goto L6;
        Iterator<T> r107 = this.f251973b.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((com.bytedance.kmp.ec.yata.view.render.controller.common.c) r108).c().d(), r106) == false) goto L9;
    L14:
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r109 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) r108;
        if (r109 == null) goto L17;
        r109.d(r105);
    L17:
        LinearContainerController.f(this.f251974c);
        r100 = r100 + 1;
        goto L3
    L13:
        r108 = null;
        goto L14
    L6:
        return;
    }
}
