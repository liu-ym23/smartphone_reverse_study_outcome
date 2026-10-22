package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim.RecyclerViewItemAnimator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class BodyContainerController extends com.bytedance.kmp.ec.yata.view.render.controller.common.a<RecyclerView> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BodyAdapter f251892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f251893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f251894f;

    public BodyContainerController() {
        super(ContainerPosition.BODY);
        this.f251893e = true;
        this.f251894f = LazyKt.lazy(new BodyContainerController$itemAnimator$2(this));
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.a
    public final void c() {
        this.f251892d = new BodyAdapter(b());
        RecyclerView r100 = a();
        BodyAdapter r101 = this.f251892d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r101 = null;
    L5:
        r100.setAdapter(r101);
        a().setItemAnimator(null);
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.a
    public final void d(String r100, ba6.g r101, LinkedHashSet<com.bytedance.kmp.ec.yata.view.render.controller.common.c> r102, final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "storeData");
        Intrinsics.checkNotNullParameter(r102, "viewHolderLinkedSet");
        RecyclerView.ItemAnimator r103 = (RecyclerView.ItemAnimator) this.f251894f.getValue();
        if ((r103 instanceof RecyclerViewItemAnimator) == false) goto L5;
        RecyclerViewItemAnimator r104 = (RecyclerViewItemAnimator) r103;
    L6:
        if (r104 == null) goto L9;
        r104.f251930b = r101;
    L9:
        final List<? extends T> r105 = CollectionsKt.toMutableList(r102);
        int r106 = com.bytedance.kmp.ec.yata.view.render.controller.common.b.f251845a;
        com.bytedance.kmp.ec.yata.view.c r107 = b();
        BodyAdapter r108 = this.f251892d;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r108 = null;
    L12:
        List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r109 = r108.f251891a.f251963f;
        RecyclerView.ItemAnimator r111 = a().getItemAnimator();
        if (r111 == null) goto L17;
        boolean r112 = true;
        if (r111.isRunning() != true) goto L17;
    L19:
        if (com.bytedance.kmp.ec.yata.view.render.controller.common.b.a(r107, r101, r109, r105, r112) == true) goto L21;
        a().setItemAnimator(null);
    L24:
        BodyAdapter r113 = this.f251892d;
        if (r113 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r113 = null;
    L27:
        RecyclerView r114 = a();
        final Runnable r115 = new a(this, r110);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "recyclerView");
        Intrinsics.checkNotNullParameter(r105, "list");
        Intrinsics.checkNotNullParameter(r115, "callback");
        final h<com.bytedance.kmp.ec.yata.view.render.controller.common.c> r116 = r113.f251891a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r114, "recyclerView");
        List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r117 = r116.f251961d;
        if (r105 != r117) goto L30;
        r115.run();
        return;
    L30:
        if (r105 != 0) goto L32;
        Intrinsics.checkNotNull(r117);
        int r118 = r117.size();
        r116.f251961d = null;
        r116.f251962e = r116.f251963f;
        r116.f251963f = CollectionsKt.emptyList();
        r116.f251958a.onRemoved(0, r118);
        r115.run();
        return;
    L32:
        if (r117 != null) goto L34;
        r116.f251961d = r105;
        r116.f251962e = r116.f251963f;
        r116.f251963f = Collections.unmodifiableList(r105);
        r116.f251958a.onInserted(0, r105.size());
        r115.run();
        return;
    L34:
        final List r119 = CollectionsKt.toList(r117);
        if (r119 != null) goto L37;
        r119 = new ArrayList();
    L37:
        final DiffUtil.DiffResult r120 = DiffUtil.calculateDiff(new SyncListDiffer$submitList$result$1(r119, r105, r116));
        r116.f251961d = r105;
        if (r114.isComputingLayout() == false) goto L43;
        final LaunchListFixHelper r121 = r116.f251960c;
        Function0<Unit> r122 = new SyncListDiffer$launchList$1(r116, r105, r120, r115);
        r121.getClass();
        Intrinsics.checkNotNullParameter(r114, "recyclerView");
        Intrinsics.checkNotNullParameter(r122, "task");
        r121.f251896b = r114;
        r121.f251897c.offer(r122);
        String r123 = YaTaLog.f251436a;
        YaTaLog.c("LaunchListFixHelper", new LaunchListFixHelper$addTask$1(r121));
        if (r121.f251898d == true) goto L42;
        YaTaLog.c("LaunchListFixHelper", LaunchListFixHelper$addTask$2.INSTANCE);
        r121.a();
        return;
    L42:
        YaTaLog.c("LaunchListFixHelper", LaunchListFixHelper$addTask$3.INSTANCE);
        return;
    L43:
        String r124 = YaTaLog.f251436a;
        YaTaLog.c("SyncListDiffer", SyncListDiffer$launchList$2.INSTANCE);
        r116.f251962e = r116.f251963f;
        r116.f251963f = Collections.unmodifiableList(r105);
        r120.dispatchUpdatesTo(r116.f251958a);
        r115.run();
        return;
    L21:
        if (a().getItemAnimator() != null) goto L24;
        a().setItemAnimator((RecyclerView.ItemAnimator) this.f251894f.getValue());
    L17:
        r112 = false;
        goto L19
    L5:
        r104 = null;
        goto L6
    }
}
