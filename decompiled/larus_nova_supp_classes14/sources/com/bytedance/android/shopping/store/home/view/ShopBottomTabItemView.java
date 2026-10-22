package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopBottomTabItemView extends BottomTabItemView {
    public static final /* synthetic */ int s = 0;
    public boolean k;
    public boolean l;
    public final Lazy m;
    public final a n;
    public ECUrlModel o;
    public final long p;
    public final Function0<Boolean> q;
    public final Function0<com.bytedance.android.shopping.store.tabkit.model.k> r;

    public static final class a implements Runnable {
        public final /* synthetic */ ShopBottomTabItemView a;

        public a(ShopBottomTabItemView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getBubbleView().setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final boolean getEnableLiveTabOpt() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView
    public int getResourceId() {
        return 2131560922;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView
    public final void d() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        if (r0 == null) goto L5;
        Integer r1 = r0.n();
    L6:
        int r2 = TabEnum.MEMBER_TAB.getType();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.intValue() != r2) goto L13;
        removeCallbacks(this.n);
        postDelayed(this.n, 60000);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        if (r0 == null) goto L5;
        Integer r1 = r0.n();
    L6:
        int r2 = TabEnum.MEMBER_TAB.getType();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.intValue() != r2) goto L13;
        removeCallbacks(this.n);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Function0<com.bytedance.android.shopping.store.tabkit.model.k> getCurrentTabFunc() {
        return this.r;
    }

    public final Function0<Boolean> getEnableLiveTabPredict() {
        return this.q;
    }

    public final long getMonitorId() {
        return this.p;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView
    public final void e(ECUrlModel r5) {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        if (r0 != null) goto L5;
    L52:
        super.e(r5);
        return;
    L5:
        if (r0.q() != true) goto L52;
        com.bytedance.android.shopping.store.tabkit.model.k r6 = (com.bytedance.android.shopping.store.tabkit.model.k) this.r.invoke();
        ECUrlModel r1 = null;
        if (r6 == null) goto L9;
        Integer r7 = r6.n();
    L10:
        int r2 = TabEnum.LIVE_TAB.getType();
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L24;
        if (c() == false) goto L24;
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        com.bytedance.android.shopping.store.tabkit.model.k r9 = getTab();
        if (r9 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "$this$recordBadgeShow");
        com.bytedance.android.ec.sdk.helper.q.a.c(com.bytedance.android.shopping.store.tabkit.e.j(r9), true);
    L24:
        if (getEnableLiveTabOpt() == true) goto L26;
        com.bytedance.android.shopping.store.tabkit.model.w r10 = getTabStyle();
        if (r10 == null) goto L47;
        ECUrlModel r11 = r10.a();
        if (r11 == null) goto L47;
        r1 = r11;
    L50:
        if (r1 == null) goto L58;
        f(getIconView(), r1);
        return;
    L58:
        return;
    L47:
        com.bytedance.android.shopping.store.tabkit.model.w r12 = getTabStyle();
        if (r12 == null) goto L50;
        r1 = r12.b();
        goto L50
    L26:
        if (this.k == false) goto L29;
        this.k = false;
        com.bytedance.android.shopping.store.tabkit.e.f(getIconView(), 2131236035);
        Lazy r13 = ECTaskManager.b;
        ECTaskManager.a.a().a(this.p, TaskPriority.AFTER_FIRST_SCREEN, new ShopBottomTabItemView$bindIconDelay$1(this));
        return;
    L29:
        if (this.l == false) goto L55;
        com.bytedance.android.shopping.store.tabkit.model.w r14 = getTabStyle();
        if (r14 == null) goto L36;
        ECUrlModel r15 = r14.a();
        if (r15 == null) goto L36;
        r1 = r15;
    L39:
        if (r1 == null) goto L56;
        f(getIconView(), r1);
        return;
    L56:
        return;
    L36:
        com.bytedance.android.shopping.store.tabkit.model.w r16 = getTabStyle();
        if (r16 == null) goto L39;
        r1 = r16.b();
        goto L39
    L55:
        return;
    L14:
        if (r7.intValue() != r2) goto L16;
        r8 = true;
        goto L17
    L9:
        r7 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView, com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public final void a(boolean r1, boolean r2) {
        super.a(r1, r2);
    }

    public final void f(ECDraweeView r2, ECUrlModel r3) {
        if (Intrinsics.areEqual(this.o, r3) == false) goto L5;
        return;
    L5:
        this.o = r3;
        h0 r0 = h0.a;
        com.bytedance.android.shopping.store.tabkit.e.g(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopBottomTabItemView(Context r4, long r5, Function0<Boolean> r7, Function0<? extends com.bytedance.android.shopping.store.tabkit.model.k> r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "enableLiveTabPredict");
        Intrinsics.checkNotNullParameter(r8, "currentTabFunc");
        super(r4, null, 6, 0);
        this.p = r5;
        this.q = r7;
        this.r = r8;
        getIconView().setAutoPlayAnimation(true);
        wg.a.f(getTitleTV(), 0, 0, 0, 5);
        this.k = true;
        this.m = LazyKt.lazy(ShopBottomTabItemView$enableLiveTabOpt$2.INSTANCE);
        this.n = new a(this);
    }
}
