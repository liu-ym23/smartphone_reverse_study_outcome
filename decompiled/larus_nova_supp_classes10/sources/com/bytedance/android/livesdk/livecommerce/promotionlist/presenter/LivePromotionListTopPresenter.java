package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.rotation.BaseRotationAdapter;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListTopPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a {
    public final List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> j;
    public com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b k;
    public boolean l;
    public final b m;

    public static final class a {
    }

    public static final class b implements ul.c {
        public final /* synthetic */ LivePromotionListTopPresenter a;

        public b(LivePromotionListTopPresenter r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L9;
            LivePromotionListTopPresenter r5 = this.a;
            r5.l = false;
            com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r6 = r5.k;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.o == true) goto L8;
            r6.j();
        L8:
            r6.p = false;
            return;
        L9:
            LivePromotionListTopPresenter r7 = this.a;
            r7.l = true;
            com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r8 = r7.k;
            if (r8 == null) goto L15;
            ((BaseRotationAdapter) r8).l.setVisibility(8);
            r8.p = true;
            r8.a();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LivePromotionListTopPresenter a;

        public c(LivePromotionListTopPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a.d0().isInSplitScreen() == false) goto L5;
            return;
        L5:
            this.a.d0().closePromotionListFragmentNow();
        }
    }

    static {
    }

    public final void clear() {
        ((ArrayList) this.j).clear();
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.k = null;
        View r1 = a0();
        if (r1 == null) goto L10;
        ((FrameLayout) r1).removeAllViews();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void c0() {
        super.c0();
        s0.e(this);
        clear();
        List r0 = ul.b.a;
        ul.b.a(this.m);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.a0.class), new LivePromotionListTopPresenter$init$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.s.class), new LivePromotionListTopPresenter$init$2(this));
        a0().setOnClickListener(new c(this));
        s0.c(this);
        wj2.g r0 = d0().getInitialAction();
        if ((r0 instanceof wj2.g.c) == true) goto L5;
        r0 = null;
    L5:
        wj2.g.c r1 = (wj2.g.c) r0;
        if (r1 != null) goto L8;
    L13:
        List r2 = ul.b.a;
        ul.b.b(this.m);
        return;
    L8:
        if (r1.b != true) goto L13;
        this.l = true;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r3 = this.k;
        if (r3 == null) goto L12;
        ((BaseRotationAdapter) r3).l.setVisibility(8);
        r3.p = true;
        r3.a();
    L12:
        List r4 = ul.b.a;
        b r5 = this.m;
        Intrinsics.checkNotNullParameter(r5, "listener");
        List r6 = ul.b.a;
        ListProtector.add(r6, Math.max(0, ((ArrayList) r6).size() - 1), r5);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveTopFragmentStatusChanged(wk.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        throw null;
    }

    public LivePromotionListTopPresenter(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3);
        this.j = new ArrayList();
        this.m = new b(this);
    }

    public static final void h0(LivePromotionListTopPresenter r4, boolean r5, List r6) {
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r0 = r4.k;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L17:
        r4.clear();
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r7 = r4.j;
        List r8 = CollectionsKt.sortedWith(r6, new a0());
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r2.add(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a((ECPromotionInterationData) r9.next()));
        goto L19
    L21:
        ((ArrayList) r7).addAll(r2);
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r10 = r4.j;
        if (r10 != null) goto L24;
    L27:
        if (r1 == true) goto L46;
        View r11 = r4.a0();
        if (r11 == null) goto L40;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r12 = new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b((FrameLayout) r11, r4.d0().getPromotionListParams(), r4.d0().getRoomContextController());
        r4.k = r12;
        if (r4.d0().isInSplitScreen() == false) goto L34;
        float r13 = 0.74f;
    L35:
        r12.m = r13;
        List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> r14 = r4.j;
        Intrinsics.checkNotNullParameter(r14, "barrages");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        ((com.bytedance.android.ec.core.utils.rotation.e) r12).a = r14;
        r12.a();
        if (r4.l == true) goto L45;
        r12.j();
        return;
    L45:
        return;
    L34:
        r13 = 0.64f;
        goto L35
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L46:
        return;
    L24:
        if (((ArrayList) r10).isEmpty() == true) goto L27;
        r1 = false;
        goto L27
    L5:
        if (r0.o == true) goto L17;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r15 = r6.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r3.add(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a((ECPromotionInterationData) r15.next()));
        goto L9
    L11:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b r16 = r4.k;
        if (r16 == null) goto L43;
        r16.r = r5;
        if (r5 == false) goto L16;
        ((ArrayList) r16.q).clear();
    L16:
        ((ArrayList) r16.q).addAll(r3);
        return;
    }
}
