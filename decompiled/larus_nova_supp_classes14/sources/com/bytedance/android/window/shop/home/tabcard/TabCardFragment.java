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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/tabcard/TabCardFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TabCardPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabCardFragment extends Fragment {
    public QUIManager d;

    public static final class TabCardPresenter extends QFragmentPresenter {
        public WindowTabCardGroup f;
        public final Lazy g;

        public static final class a<T> implements Observer {
            public final /* synthetic */ TabCardPresenter a;

            public a(TabCardPresenter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                TabCardPresenter.d0(this.a, ((Float) r2).floatValue());
            }
        }

        public static final class b<T> implements Observer {
            public final /* synthetic */ TabCardPresenter a;

            public b(TabCardPresenter r1) {
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
                TabCardPresenter.d0(this.a, RangesKt.coerceIn(Math.abs(((Number) r4.getFirst()).intValue() / RangesKt.coerceAtLeast(((Number) r4.getSecond()).intValue(), 1.0f)), 0.0f, 1.0f));
                return;
            L8:
                if (r1.getChildCount() != 0) goto L10;
            }
        }

        public final void c0() {
            WindowTabCardGroup r0 = this.f;
            if (r0 == null) goto L6;
            r0.f.unregisterReceiver(r0.b);
            r0.a.b();
            return;
        }

        public TabCardPresenter(TabCardFragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.g = LazyKt.lazy(new TabCardFragment$TabCardPresenter$shopViewModel$2(this));
        }

        public final void b0(QModel r8) {
            FragmentActivity r9 = l0.c(Y().c());
            View r2 = null;
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
            ECWindowTabCardViewModel r11 = ECQuickUtilKt.d(Y(), ECWindowTabCardViewModel.class, ECWindowDialogFragment.class);
            if (this.f == null) goto L52;
            return;
        L52:
            View r12 = ((QFragmentPresenter) this).e.getView();
            if ((r12 instanceof LinearLayout) == false) goto L56;
            r2 = r12;
        L56:
            LinearLayout r13 = (LinearLayout) r2;
            if (r13 != null) goto L59;
            return;
        L59:
            WindowTabCardGroup r14 = new WindowTabCardGroup(((QFragmentPresenter) this).e, r13, r11, (ECWindowViewModel) this.g.getValue());
            this.f = r14;
            r14.e.removeAllViews();
            r14.f.registerReceiver(r14.b);
            r14.a.a(new e[]{new WindowTabCardGroup.WindowNotifyShakePlugin(r14)});
            return;
        L48:
            ((ECWindowViewModel) this.g.getValue()).getOffsetState().a(((QFragmentPresenter) this).e, new b(this), false);
            goto L49
        L14:
            List r15 = r9.getSupportFragmentManager().getFragments();
            ArrayList r16 = new ArrayList();
            Iterator r17 = r15.iterator();
        L16:
            if (r17.hasNext() == false) goto L23;
            Object r18 = r17.next();
            if (((Fragment) r18).getHost() == null) goto L20;
            boolean r19 = true;
        L21:
            if (r19 == false) goto L16;
            r16.add(r18);
            goto L16
        L20:
            r19 = false;
            goto L21
        L23:
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator r21 = r16.iterator();
        L25:
            if (r21.hasNext() == false) goto L27;
            r20.add(((Fragment) r21.next()).getChildFragmentManager().getFragments());
            goto L25
        L27:
            List r22 = CollectionsKt.flatten(r20);
            ArrayList r23 = new ArrayList();
            Iterator r24 = r22.iterator();
        L29:
            if (r24.hasNext() == false) goto L33;
            Object r25 = r24.next();
            if ((r25 instanceof ECWindowDialogFragment) == false) goto L29;
            r23.add(r25);
            goto L29
        L33:
            Fragment r26 = (Fragment) CollectionsKt.firstOrNull(r23);
            if (r26 == null) goto L37;
            r10 = (QViewModelOwner) r26;
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

        public static final void d0(TabCardPresenter r3, float r4) {
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

    public TabCardFragment() {
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
        LinearLayout r6 = new LinearLayout(requireContext());
        r6.setOrientation(1);
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
