package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitFragmentPagerAdapter;
import com.bytedance.android.shopping.store.tabkit.TabKitHybridTabFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.commerce.base.view.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rk3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab", "", "setCurrentTab", "Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView$a;", "e", "Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView$a;", "getOnPageChangeListener", "()Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView$a;", "setOnPageChangeListener", "(Lcom/bytedance/android/shopping/store/tabkit/view/TabKitMainContainerView$a;)V", "onPageChangeListener", "Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "getViewModel", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "viewModel", "Landroid/view/View;", "getLandingWebView", "()Landroid/view/View;", "landingWebView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitMainContainerView extends FrameLayout {
    public final ArrayList<k> a;
    public TabKitFragment b;
    public final HashMap<k, Boolean> c;
    public final ArrayList<Fragment> d;
    public a e;
    public boolean f;
    public WeakReference<TabKitHybridTabFragment> g;

    public interface a {
        void T(ScrollableViewPager r1);

        void b(ScrollableViewPager r1, int r2, int r3);

        void d(ScrollableViewPager r1, int r2);
    }

    private final View getLandingWebView() {
        WeakReference<TabKitHybridTabFragment> r0 = this.g;
        if (r0 == null) goto L7;
        TabKitHybridTabFragment r1 = r0.get();
        if (r1 == null) goto L7;
        return r1.getHybridView();
    L7:
        return null;
    }

    private final TabKitViewModel getViewModel() {
        TabKitFragment r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final a getOnPageChangeListener() {
        return this.e;
    }

    public TabKitMainContainerView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r0v13, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.viewpager.widget.ViewPager, com.bytedance.android.shopping.store.tabkit.view.ScrollableViewPager] */
    public final void a(List<? extends k> r7) {
        Iterator r0 = b.a(this).iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L8;
        View r1 = (View) r0.next();
        if ((true ^ Intrinsics.areEqual(r1, getLandingWebView())) == false) goto L3;
        removeView(r1);
        goto L3
    L8:
        this.a.clear();
        this.c.clear();
        if (r7 == null) goto L11;
        this.a.addAll(r7);
    L11:
        TabKitFragment r8 = this.b;
        if (r8 == null) goto L22;
        FragmentManager r9 = r8.getChildFragmentManager();
        if (r9 == null) goto L22;
        FragmentTransaction r10 = r9.beginTransaction();
        if (r10 == null) goto L22;
        Iterator<Fragment> r3 = this.d.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        r10.remove(r3.next());
        goto L19
    L21:
        r10.commitNow();
    L22:
        this.d.clear();
        Iterator<k> r11 = this.a.iterator();
    L23:
        Object r4 = null;
        if (r11.hasNext() == false) goto L30;
        k r5 = r11.next();
        this.c.put(r5, Boolean.FALSE);
        if (r5.g() == false) goto L28;
        final ?? r6 = new ScrollableViewPager(getContext(), null);
        r6.setOffscreenPageLimit(4);
        r6.setScrollable(false);
        r6.addOnPageChangeListener(new TabKitMainContainerView$updateHomeTabs$$inlined$forEach$lambda$1(r6, this));
    L29:
        r6.setId(ViewCompat.generateViewId());
        f.a(this, r6);
        goto L23
    L28:
        r6 = new FrameLayout(getContext());
        goto L29
    L30:
        TabKitViewModel r12 = getViewModel();
        if (r12 == null) goto L131;
        TabKitAbilityConfig r13 = r12.getAbilityConfig();
        if (r13 == null) goto L131;
        if (r13.a("web_landing_opt") != 2) goto L131;
        View r14 = getLandingWebView();
        if (r14 == null) goto L40;
        r14.bringToFront();
    L40:
        if (this.f == true) goto L102;
        ArrayList<k> r15 = this.a;
        if (r15.size() != 1) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L48;
        r15 = null;
    L48:
        if (r15 == null) goto L131;
        k r17 = (k) ListProtector.get(r15, 0);
        if (r17 == null) goto L131;
        TabKitViewModel r18 = getViewModel();
        if (r18 != null) goto L55;
    L74:
        TabKitViewModel r19 = getViewModel();
        if (r19 == null) goto L79;
        MutableLiveData<Boolean> r20 = r19.isLandingFinished();
        if (r20 == null) goto L79;
        Boolean r21 = (Boolean) r20.getValue();
    L80:
        boolean r22 = Intrinsics.areEqual(r21, Boolean.FALSE);
    L82:
        if (r17.e == true) goto L84;
    L87:
        r2 = false;
    L88:
        this.f = r2;
        if (r2 == false) goto L131;
        TabKitViewModel r23 = getViewModel();
        if (r23 == null) goto L93;
        TabKitTabFragment r24 = TabKitViewModel.getTabFragment$default(r23, r17, false, 2, null);
    L95:
        if ((r24 instanceof TabKitHybridTabFragment) == false) goto L98;
        r4 = r24;
    L98:
        TabKitHybridTabFragment r25 = (TabKitHybridTabFragment) r4;
        if (r25 == null) goto L131;
        this.g = new WeakReference(r25);
        r25.setWebLandingRoot(this);
        goto L131
    L93:
        r24 = null;
        goto L95
    L84:
        if (e.m(r17) == false) goto L87;
        if (r22 == false) goto L87;
    L79:
        r21 = null;
        goto L80
    L55:
        if (r18.getLandingFinishedOpt() != true) goto L74;
        TabKitViewModel r26 = getViewModel();
        if (r26 == null) goto L73;
        TabKitRouterParams r27 = r26.getRouterParams();
        if (r27 == null) goto L73;
        String r28 = r27.getAnchorUrl();
        if (r28 == null) goto L73;
        if (com.bytedance.android.shopping.extensions.k.c(r28) != true) goto L73;
        TabKitViewModel r29 = getViewModel();
        if (r29 == null) goto L69;
        MutableLiveData<Boolean> r30 = r29.getPageLandingFinished();
        if (r30 == null) goto L69;
        Boolean r31 = (Boolean) r30.getValue();
    L71:
        if (Intrinsics.areEqual(r31, Boolean.FALSE) == false) goto L73;
        r22 = true;
    L69:
        r31 = null;
    L73:
        r22 = false;
        goto L82
    L44:
        r16 = false;
        goto L45
    L102:
        TabKitViewModel r32 = getViewModel();
        if (r32 != null) goto L105;
    L123:
        TabKitViewModel r33 = getViewModel();
        if (r33 == null) goto L128;
        MutableLiveData<Boolean> r34 = r33.isLandingFinished();
        if (r34 == null) goto L128;
        r4 = (Boolean) r34.getValue();
    L128:
        r2 = Intrinsics.areEqual(r4, Boolean.TRUE);
    L129:
        if (r2 == false) goto L131;
        this.f = false;
        post(new d(this));
        goto L131
    L105:
        if (r32.getLandingFinishedOpt() != true) goto L123;
        TabKitViewModel r35 = getViewModel();
        if (r35 == null) goto L122;
        TabKitRouterParams r36 = r35.getRouterParams();
        if (r36 == null) goto L122;
        String r37 = r36.getAnchorUrl();
        if (r37 == null) goto L122;
        if (com.bytedance.android.shopping.extensions.k.c(r37) != true) goto L122;
        TabKitViewModel r38 = getViewModel();
        if (r38 == null) goto L120;
        MutableLiveData<Boolean> r39 = r38.getPageLandingFinished();
        if (r39 == null) goto L120;
        r4 = (Boolean) r39.getValue();
    L120:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L129;
    L122:
        r2 = false;
    L131:
        TabKitViewModel r40 = getViewModel();
        if (r40 == null) goto L150;
        MutableLiveData<y> r41 = r40.getCurrentTab();
        if (r41 == null) goto L151;
        y r42 = (y) r41.getValue();
        if (r42 == null) goto L152;
        k r43 = r42.a;
        if (r43 == null) goto L153;
        setCurrentTab(r43);
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    }

    public final void setCurrentTab(k r14) {
        Intrinsics.checkNotNullParameter(r14, "tab");
        Pair<Integer, Integer> r0 = r14.b;
        int r1 = ((Number) r0.getFirst()).intValue();
        Integer r2 = (Integer) r0.getSecond();
        Iterator r3 = b.a(this).iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L8;
        View r5 = (View) r3.next();
        if ((true ^ Intrinsics.areEqual(r5, getLandingWebView())) == false) goto L3;
        r5.setVisibility(4);
        goto L3
    L8:
        View r6 = getChildAt(r1);
        if (r6 == null) goto L11;
        ExtensionsKt.visible(r6);
    L11:
        k r7 = r14.a;
        if (r7 != null) goto L14;
        r7 = r14;
    L14:
        TabKitFragment r8 = this.b;
        Integer r9 = null;
        if (r8 == null) goto L51;
        FragmentManager r10 = r8.getChildFragmentManager();
        if (r10 == null) goto L51;
        if (Intrinsics.areEqual(this.c.get(r7), Boolean.FALSE) == false) goto L51;
        int r11 = ((Number) r7.b.getFirst()).intValue();
        View r12 = getChildAt(r11);
        if (r7.g() == false) goto L41;
        Object r13 = getChildAt(r11);
        if ((r13 instanceof ScrollableViewPager) == true) goto L26;
        r13 = null;
    L26:
        ScrollableViewPager r15 = (ScrollableViewPager) r13;
        if (r15 == null) goto L50;
        TabKitFragmentPagerAdapter r16 = new TabKitFragmentPagerAdapter(r10);
        List<k> r17 = r7.m();
        if (r17 == null) goto L38;
        Iterator<T> r18 = r17.iterator();
    L32:
        if (r18.hasNext() == false) goto L38;
        k r19 = (k) r18.next();
        TabKitViewModel r110 = getViewModel();
        if (r110 == null) goto L32;
        TabKitTabFragment r111 = TabKitViewModel.getTabFragment$default(r110, r19, false, 2, null);
        if (r111 == null) goto L32;
        r16.a.add(r111);
    L38:
        this.d.addAll(r16.a);
        Unit r20 = Unit.INSTANCE;
        r15.setAdapter(r16);
        PagerAdapter r21 = r15.getAdapter();
        if (r21 == null) goto L50;
        r21.notifyDataSetChanged();
    L50:
        this.c.put(r7, Boolean.TRUE);
        goto L51
    L41:
        TabKitViewModel r22 = getViewModel();
        if (r22 == null) goto L50;
        TabKitTabFragment r23 = TabKitViewModel.getTabFragment$default(r22, r7, false, 2, null);
        if (r23 == null) goto L50;
        FragmentTransaction r24 = r10.beginTransaction();
        int r25 = r12.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r24, r23, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r25) == true) goto L49;
        r24 = r24.add(r25, r23);
    L49:
        r24.commitNow();
        this.d.add(r23);
    L51:
        if (r2 == null) goto L93;
        Object r26 = getChildAt(r1);
        if ((r26 instanceof ScrollableViewPager) == true) goto L55;
        r26 = null;
    L55:
        ScrollableViewPager r27 = (ScrollableViewPager) r26;
        if (r27 == null) goto L94;
        TabKitViewModel r28 = getViewModel();
        if (r28 == null) goto L65;
        TabKitAbilityConfig r29 = r28.getAbilityConfig();
        if (r29 == null) goto L65;
        if (r29.b("web_nested_scroll") != true) goto L65;
        r27.setScrollable(true);
    L79:
        r27.setCurrentItem(r2.intValue(), false);
        return;
    L65:
        if (e.l(r14) == true) goto L78;
        Intrinsics.checkNotNullParameter(r14, "$this$isHybridTab");
        s r112 = r14.f();
        if (r112 == null) goto L69;
        r9 = r112.c();
    L69:
        if (r9 != null) goto L72;
    L74:
        boolean r113 = false;
    L75:
        if (r113 == true) goto L78;
        r4 = false;
        goto L78
    L72:
        if (r9.intValue() != 4) goto L74;
        r113 = true;
    L78:
        r27.setScrollable(r4);
        goto L79
    L94:
        return;
    }

    public final void setOnPageChangeListener(a r1) {
        this.e = r1;
    }

    public TabKitMainContainerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new ArrayList();
        this.c = new HashMap();
        this.d = new ArrayList();
    }
}
