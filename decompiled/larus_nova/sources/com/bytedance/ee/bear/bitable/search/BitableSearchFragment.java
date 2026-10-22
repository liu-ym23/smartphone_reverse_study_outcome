package com.bytedance.ee.bear.bitable.search;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.common.TouchDetectFrameLayout;
import com.bytedance.ee.bear.bitable.databinding.BitableSearchFragmentBinding;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SearchConfigIcon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0019\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020$H\u0002J\u0006\u0010,\u001a\u00020$J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitableSearchFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/bitable/search/BitableSearchModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onClose", "Ljava/lang/Runnable;", "<init>", "(Landroidx/lifecycle/MutableLiveData;Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;Ljava/lang/Runnable;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;)V", "isClosing", "", "isConsumingHeaderTouch", "topContainerBounds", "Landroid/graphics/Rect;", "textWatcher", "com/bytedance/ee/bear/bitable/search/BitableSearchFragment$textWatcher$1", "Lcom/bytedance/ee/bear/bitable/search/BitableSearchFragment$textWatcher$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onBackPressed", "startTopBarShowAnim", "startTopBarHideAnim", "closeKeyBoardIfNeed", "isTouchInsideHeaderArea", "event", "Landroid/view/MotionEvent;", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "", "orientation", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSearchFragment extends BaseFragment implements ocb.a, l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f215279m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<BitableSearchModel> f215280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gv4.a f215281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f215282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BitableSearchFragmentBinding f215283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f215284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f215285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f215286k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.search.d f215287l;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215288a;

        public a(BitableSearchFragment r100) {
            this.f215288a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f215288a.W90();
        }
    }

    public static final class b implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215289a;

        public b(BitableSearchFragment r100) {
            this.f215289a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 3) goto L6;
            BitableSearchFragment r103 = this.f215289a;
            int r104 = BitableSearchFragment.f215279m;
            r103.U90();
            return true;
        L6:
            return false;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215290a;

        public c(BitableSearchFragment r100) {
            this.f215290a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getActionMasked();
            boolean r103 = false;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L6;
        L8:
            BitableSearchFragment r104 = this.f215290a;
            boolean r105 = r104.f215285j;
            r104.f215285j = false;
            return r105;
        L6:
            if (r102 == 3) goto L8;
            return this.f215290a.f215285j;
        L9:
            BitableSearchFragment r106 = this.f215290a;
            Intrinsics.checkNotNull(r101);
            int r107 = BitableSearchFragment.f215279m;
            FragmentActivity r108 = r106.getActivity();
            if (r108 == null) goto L24;
            View r109 = r108.findViewById(R.id.bitable_top_container);
            if (r109 == null) goto L24;
            if (r109.getGlobalVisibleRect(r106.f215286k) == false) goto L24;
            if (r101.getRawX() < r106.f215286k.left) goto L24;
            if (r101.getRawX() >= r106.f215286k.right) goto L24;
            if (r101.getRawY() >= r106.f215286k.bottom) goto L24;
            r103 = true;
        L24:
            r106.f215285j = r103;
            BitableSearchFragment r110 = this.f215290a;
            if (r110.f215285j == false) goto L27;
            r110.W90();
        L29:
            return this.f215290a.f215285j;
        L27:
            r110.U90();
            goto L29
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215291a;

        public d(BitableSearchFragment r100) {
            this.f215291a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            BitableSearchModel r101 = (BitableSearchModel) r100;
            SimpleItemModel r102 = r101.getTipsItem();
            if (r102 == null) goto L9;
            BitableSearchFragment r103 = this.f215291a;
            m.z(r103.V90().f211025d, true);
            r103.V90().f211027f.setText(r102.getText());
            Icon r104 = r102.getIcon();
            if (r104 == null) goto L7;
            com.bytedance.ee.bear.bitable.panel.e.i(r103.V90().f211026e, r104);
            Unit r105 = Unit.INSTANCE;
        L8:
            if (r105 == null) goto L9;
        L10:
            this.f215291a.V90().f211024c.a(r101.getRightIcon(), this.f215291a.f215281f);
            Integer r106 = r101.getSearchKeywordLengthLimit();
            if (r106 == null) goto L14;
            BitableSearchFragment r107 = this.f215291a;
            int r108 = r106.intValue();
            r107.V90().f211029h.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r108)});
            return;
        L14:
            return;
        L7:
            r105 = null;
        L9:
            m.z(this.f215291a.V90().f211025d, false);
            goto L10
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215292a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BitableSearchFragment f215293a;

            public a(BitableSearchFragment r100) {
                this.f215293a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BitableSearchModel r100 = this.f215293a.f215280e.getValue();     // Catch: Throwable -> L10
                if (r100 == null) goto L13;
                Icon r101 = r100.getRightIcon();     // Catch: Throwable -> L10
                if (r101 == null) goto L17;
                ActionPayload r102 = r101.getClickActionPayload();     // Catch: Throwable -> L10
                if (r102 == null) goto L18;
                this.f215293a.f215281f.a(r102);     // Catch: Throwable -> L10
                return;
            L18:
                return;
            L17:
                return;
            L13:
                return;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        public e(BitableSearchFragment r100) {
            this.f215292a = r100;
        }

        public final void a() {
            rcb.c.h(this.f215292a.V90().f211029h, null);
            sk5.c r100 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
            if (r100.f("base_new_global_search_guide") == false) goto L6;
            Log.i("BitableSearchFragment", "onboard>>> isMissionFinished.");
            return;
        L6:
            FragmentActivity r101 = this.f215292a.getActivity();
            if (r101 == null) goto L16;
            BitableSearchFragment r102 = this.f215292a;
            MutableLiveData<BitableSearchModel> r103 = r102.f215280e;
            if (r103 == null) goto L17;
            BitableSearchModel r104 = r103.getValue();
            if (r104 == null) goto L18;
            String r105 = r104.getOnboardingText();
            if (r105 == null) goto L19;
            r100.g(new com.bytedance.ee.bear.bitable.search.c(r102.V90().f211024c, r105, new a(r102)), r101);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f extends com.bytedance.ee.bear.bitable.common.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSearchFragment f215294a;

        public f(BitableSearchFragment r100) {
            this.f215294a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f215294a.V90().f211031j.setVisibility(8);
            this.f215294a.f215282g.run();
        }
    }

    public final BitableSearchFragmentBinding V90() {
        BitableSearchFragmentBinding r100 = this.f215283h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void W90() {
        if (this.f215284i == false) goto L5;
        return;
    L5:
        this.f215284i = true;
        TranslateAnimation r100 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        r100.setDuration(200);
        r100.setAnimationListener(new f(this));
        V90().f211031j.startAnimation(r100);
    }

    public final void U90() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (pcb.a.AbstractC7181a.b(getActivity()).getVisibleKeyboardHeight() <= 0) goto L9;
        rcb.c.d(V90().f211029h);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        W90();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        V90().f211029h.removeTextChangedListener(this.f215287l);
        U90();
        if (getActivity() == null) goto L6;
        pcb.a.AbstractC7181a.b(getActivity()).a(this);
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (r100.orientation != 2) goto L5;
        V90().f211030i.setPadding(0, n.d(9), 0, n.d(9));
        return;
    L5:
        V90().f211030i.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()) + n.d(9), 0, n.d(9));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f215284i = false;
        int r100 = R.id.rest_container;
        TouchDetectFrameLayout r101 = (TouchDetectFrameLayout) ViewBindings.findChildViewById(r110, R.id.rest_container);
        if (r101 == null) goto L27;
        r100 = R.id.search_box;
        if (((LinearLayout) ViewBindings.findChildViewById(r110, R.id.search_box)) == null) goto L27;
        r100 = R.id.search_config;
        SearchConfigIcon r102 = (SearchConfigIcon) ViewBindings.findChildViewById(r110, R.id.search_config);
        if (r102 == null) goto L27;
        r100 = R.id.search_desc;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.search_desc);
        if (r103 == null) goto L27;
        r100 = R.id.search_desc_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.search_desc_icon);
        if (r104 == null) goto L27;
        r100 = R.id.search_desc_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r110, R.id.search_desc_text);
        if (r105 == null) goto L27;
        r100 = R.id.search_done;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r110, R.id.search_done);
        if (r106 == null) goto L27;
        r100 = R.id.search_et;
        SpaceEditText r112 = (SpaceEditText) ViewBindings.findChildViewById(r110, R.id.search_et);
        if (r112 == null) goto L27;
        r100 = R.id.search_titlebar;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.search_titlebar);
        if (r113 == null) goto L27;
        r100 = R.id.search_top_bar;
        SpaceShadowLayout r114 = (SpaceShadowLayout) ViewBindings.findChildViewById(r110, R.id.search_top_bar);
        if (r114 == null) goto L27;
        BitableSearchFragmentBinding r107 = new BitableSearchFragmentBinding((LinearLayout) r110, r101, r102, r103, r104, r105, r106, r112, r113, r114);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f215283h = r107;
        V90().f211029h.addTextChangedListener(this.f215287l);
        V90().f211028g.setOnClickListener(new a(this));
        V90().f211029h.setOnEditorActionListener(new b(this));
        V90().f211023b.setOnTouchListener(new c(this));
        V90().f211030i.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()) + n.d(9), 0, n.d(9));
        this.f215280e.observe(this, new d(this));
        V90().f211029h.postDelayed(new e(this), 200);
        V90().f211031j.setVisibility(0);
        TranslateAnimation r115 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        r115.setDuration(200);
        V90().f211031j.startAnimation(r115);
        if (getActivity() == null) goto L28;
        pcb.a.AbstractC7181a.b(getActivity()).c(this);
        return;
    L28:
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public BitableSearchFragment(MutableLiveData r100, gv4.d r101, com.bytedance.ee.bear.bitable.search.e r102) {
        Intrinsics.checkNotNullParameter(r100, "liveData");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "onClose");
        this.f215280e = r100;
        this.f215281f = r101;
        this.f215282g = r102;
        this.f215286k = new Rect();
        this.f215287l = new com.bytedance.ee.bear.bitable.search.d(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_search_fragment, r101, false);
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        if (r101 != 0) goto L5;
        V90().f211029h.clearFocus();
        return;
    }
}
