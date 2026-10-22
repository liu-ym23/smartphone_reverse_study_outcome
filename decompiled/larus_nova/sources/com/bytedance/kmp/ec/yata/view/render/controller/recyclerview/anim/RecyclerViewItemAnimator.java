package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ba6.g;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/controller/recyclerview/anim/RecyclerViewItemAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public class RecyclerViewItemAnimator extends SimpleItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f251929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f251930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f251931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f251932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f251933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f251934f;

    public final a a() {
        return (a) this.f251931c.getValue();
    }

    public final d b() {
        return (d) this.f251932d.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        ((c) this.f251933e.getValue()).d();
        b().d();
        a().d();
        ((b) this.f251934f.getValue()).c();
        dispatchAnimationsFinished();
    }

    public final void c() {
        if (isRunning() == true) goto L6;
        String r100 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-Main", RecyclerViewItemAnimator$tryDispatchFinishedWhenDone$1.INSTANCE);
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (b().f() == false) goto L5;
    L12:
        return true;
    L5:
        if (a().f() == true) goto L12;
        if (((c) this.f251933e.getValue()).f() == true) goto L12;
        if (((b) this.f251934f.getValue()).d() == true) goto L12;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        b().g();
        ((c) this.f251933e.getValue()).g();
        ((b) this.f251934f.getValue()).e();
        a().g();
    }

    public RecyclerViewItemAnimator(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f251929a = r100;
        this.f251931c = LazyKt.lazy(new RecyclerViewItemAnimator$addAnimator$2(this));
        this.f251932d = LazyKt.lazy(new RecyclerViewItemAnimator$removeAnimator$2(this));
        this.f251933e = LazyKt.lazy(new RecyclerViewItemAnimator$moveAnimator$2(this));
        this.f251934f = LazyKt.lazy(new RecyclerViewItemAnimator$changeAnimator$2(this));
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return a().i(r100);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return b().i(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        ((c) this.f251933e.getValue()).c(r100);
        a().c(r100);
        b().c(r100);
        ((b) this.f251934f.getValue()).b(r100);
        c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, "payloads");
        ba6.d r102 = i.a(r100);
        if (r102 == null) goto L12;
        g r103 = this.f251930b;
        String r104 = null;
        if (r103 == null) goto L7;
        aa6.a r105 = r103.getStrategy();
    L8:
        g r106 = this.f251930b;
        if (r106 == null) goto L11;
        r104 = r106.getTriggerType();
    L11:
        boolean r107 = r102.j(r105, r104);
    L14:
        return !r107;
    L7:
        r105 = null;
        goto L8
    L12:
        r107 = false;
        goto L14
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return ((c) this.f251933e.getValue()).i(r100, r101, r110, r111, r112);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "oldHolder");
        if (r100 == r110) goto L5;
        ((b) this.f251934f.getValue()).a(r100, r110, r111, r112, r113, r114);
        return true;
    L5:
        return animateMove(r100, r111, r112, r113, r114);
    }
}
