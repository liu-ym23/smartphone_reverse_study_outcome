package com.bytedance.android.window.shop.home.tabcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.j0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.ability.s;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.ec.window.base.utils.quick.f;
import com.bytedance.android.window.shop.home.ECWindowActivity;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.tab.tabplugin.e;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/tabcard/HybridTabCardFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "HybridTabCardPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridTabCardFragment extends Fragment {
    public QUIManager d;

    public static final class HybridTabCardPresenter extends QFragmentPresenter {
        public WindowHybridTabCardGroup f;
        public final Lazy g;

        public static final class a<T> implements Observer {
            public final /* synthetic */ HybridTabCardPresenter a;

            public a(HybridTabCardPresenter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                HybridTabCardPresenter.d0(this.a, ((Float) r2).floatValue());
            }
        }

        public static final class b<T> implements Observer {
            public final /* synthetic */ HybridTabCardPresenter a;

            public b(HybridTabCardPresenter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r3) {
                Pair r4 = (Pair) r3;
                View r0 = this.a.a0();
                if ((r0 instanceof LinearLayout) == true) goto L5;
                r0 = null;
            L5:
                LinearLayout r1 = (LinearLayout) r0;
                if (r1 != null) goto L8;
            L10:
                HybridTabCardPresenter.d0(this.a, RangesKt.coerceIn(Math.abs(((Number) r4.getFirst()).intValue() / RangesKt.coerceAtLeast(((Number) r4.getSecond()).intValue(), 1.0f)), 0.0f, 1.0f));
                return;
            L8:
                if (r1.getChildCount() != 0) goto L10;
            }
        }

        public final void c0() {
            WindowHybridTabCardGroup r0 = this.f;
            if (r0 == null) goto L6;
            r0.h.unregisterReceiver(r0.c);
            r0.b.b();
            return;
        }

        public HybridTabCardPresenter(HybridTabCardFragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.g = LazyKt.lazy(new HybridTabCardFragment$HybridTabCardPresenter$shopViewModel$2(this));
        }

        public final void b0(QModel r8) {
            FragmentActivity r9 = l0.c(Y().c());
            ECHybridListContainer r2 = null;
            if (r9 == null) goto L42;
            List r3 = r9.getSupportFragmentManager().getFragments();
            ArrayList r4 = new ArrayList();
            Iterator r5 = r3.iterator();
        L7:
            if (r5.hasNext() == false) goto L11;
            Object r6 = r5.next();
            if ((r6 instanceof ECWindowDialogFragment) == false) goto L7;
            r4.add(r6);
            goto L7
        L11:
            Fragment r7 = (Fragment) CollectionsKt.firstOrNull(r4);
            if (r7 == null) goto L14;
            QViewModelOwner r10 = (QViewModelOwner) r7;
        L43:
            if (r10 != null) goto L46;
            return;
        L46:
            if (((ECWindowViewModel) this.g.getValue()).isCroppedStyle() == false) goto L48;
            ((ECWindowViewModel) this.g.getValue()).getSubCollapseProgress().observe(((QFragmentPresenter) this).e, new a(this));
        L49:
            ECWindowHybridTabCardViewModel r11 = ECQuickUtilKt.d(Y(), ECWindowHybridTabCardViewModel.class, ECWindowDialogFragment.class);
            if (this.f == null) goto L52;
            return;
        L52:
            ECHybridListContainer r12 = ((QFragmentPresenter) this).e.getView();
            if ((r12 instanceof ECHybridListContainer) == false) goto L56;
            r2 = r12;
        L56:
            ECHybridListContainer r13 = r2;
            if (r13 != null) goto L59;
            return;
        L59:
            WindowHybridTabCardGroup r14 = new WindowHybridTabCardGroup(((QFragmentPresenter) this).e, r13, r11, (ECWindowViewModel) this.g.getValue());
            this.f = r14;
            Iterator r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to(m0.class, new com.bytedance.android.window.shop.home.tabcard.a(r14)), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.l0.class, new WindowHybridTabCardGroup$windowAbilities$2()), TuplesKt.to(j0.class, new com.bytedance.android.window.shop.home.tabcard.b())}).entrySet().iterator();
        L61:
            if (r15.hasNext() == false) goto L67;
            Map.Entry r16 = (Map.Entry) r15.next();
            Class r17 = (Class) r16.getKey();
            s r18 = (s) r16.getValue();
            ECHybridListEngine r19 = (ECHybridListEngine) r14.e.getValue();
            if (r17 == null) goto L66;
            r19.b(r17, r18);
            goto L61
        L66:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.bytedance.android.ec.hybrid.list.ability.IAbility>");
        L67:
            r14.h.registerReceiver(r14.c);
            r14.b.a(new e[]{new WindowHybridTabCardGroup.WindowNotifyShakePlugin(r14)});
            return;
        L48:
            ((ECWindowViewModel) this.g.getValue()).getOffsetState().a(((QFragmentPresenter) this).e, new b(this), false);
            goto L49
        L14:
            List r20 = r9.getSupportFragmentManager().getFragments();
            ArrayList r21 = new ArrayList();
            Iterator r22 = r20.iterator();
        L16:
            if (r22.hasNext() == false) goto L23;
            Object r23 = r22.next();
            if (((Fragment) r23).getHost() == null) goto L20;
            boolean r24 = true;
        L21:
            if (r24 == false) goto L16;
            r21.add(r23);
            goto L16
        L20:
            r24 = false;
            goto L21
        L23:
            ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator r26 = r21.iterator();
        L25:
            if (r26.hasNext() == false) goto L27;
            r25.add(((Fragment) r26.next()).getChildFragmentManager().getFragments());
            goto L25
        L27:
            List r27 = CollectionsKt.flatten(r25);
            ArrayList r28 = new ArrayList();
            Iterator r29 = r27.iterator();
        L29:
            if (r29.hasNext() == false) goto L33;
            Object r30 = r29.next();
            if ((r30 instanceof ECWindowDialogFragment) == false) goto L29;
            r28.add(r30);
            goto L29
        L33:
            Fragment r31 = (Fragment) CollectionsKt.firstOrNull(r28);
            if (r31 == null) goto L37;
            r10 = (QViewModelOwner) r31;
            goto L43
        L37:
            if (Intrinsics.areEqual(r9.getClass(), ECWindowActivity.class) == false) goto L42;
            if ((r9 instanceof QViewModelOwner) == true) goto L41;
            r9 = null;
        L41:
            r10 = (QViewModelOwner) r9;
        L42:
            r10 = null;
            goto L43
        }

        public static final void d0(HybridTabCardPresenter r3, float r4) {
            r3.getClass();
            float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
            View r0 = r3.a0();
            ViewGroup.LayoutParams r2 = null;
            if ((r0 instanceof LinearLayout) == true) goto L5;
            r0 = null;
        L5:
            LinearLayout r1 = (LinearLayout) r0;
            if (r1 != null) goto L8;
        L10:
            ViewGroup.LayoutParams r6 = r3.a0().getLayoutParams();
            if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
            r2 = r6;
        L14:
            ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r2;
            if (r7 == null) goto L20;
            r7.topMargin = -((int) (r3.a0().getHeight() * r5));
            r3.a0().setLayoutParams(r7);
            return;
        L20:
            return;
        L8:
            if (r1.getChildCount() != 0) goto L10;
        }
    }

    public final void onDestroy() {
        QUIManager r0 = this.d;
        if (r0 == null) goto L5;
        f.b(r0);
    L5:
        super.onDestroy();
    }

    public HybridTabCardFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        QUIManager r4 = this.d;
        if (r4 == null) goto L6;
        f.a(r4, null);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        QUIManager r5 = this.d;
        if (r5 != null) goto L5;
        this.d = new QUIManager();
        ECHybridListContainer r6 = new ECHybridListContainer(requireContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        QUIManager r7 = this.d;
        if (r7 == null) goto L9;
        d.a(r7, new com.bytedance.android.ec.window.base.utils.quick.e(r6, this, new AnonymousClass1(this)), requireContext(), this);
    L9:
        return r6;
    L5:
        return r5.p();
    }
}
