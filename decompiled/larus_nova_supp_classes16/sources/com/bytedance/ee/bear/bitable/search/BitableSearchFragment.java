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
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0019\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020$H\u0002J\u0006\u0010,\u001a\u00020$J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitableSearchFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/bitable/search/BitableSearchModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onClose", "Ljava/lang/Runnable;", "<init>", "(Landroidx/lifecycle/MutableLiveData;Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;Ljava/lang/Runnable;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableSearchFragmentBinding;)V", "isClosing", "", "isConsumingHeaderTouch", "topContainerBounds", "Landroid/graphics/Rect;", "textWatcher", "com/bytedance/ee/bear/bitable/search/BitableSearchFragment$textWatcher$1", "Lcom/bytedance/ee/bear/bitable/search/BitableSearchFragment$textWatcher$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onBackPressed", "startTopBarShowAnim", "startTopBarHideAnim", "closeKeyBoardIfNeed", "isTouchInsideHeaderArea", "event", "Landroid/view/MotionEvent;", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "", "orientation", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSearchFragment extends BaseFragment implements ocb.a, l {
    public static final /* synthetic */ int m = 0;
    public final MutableLiveData<BitableSearchModel> e;
    public final gv4.a f;
    public final Runnable g;
    public BitableSearchFragmentBinding h;
    public boolean i;
    public boolean j;
    public final Rect k;
    public final com.bytedance.ee.bear.bitable.search.d l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BitableSearchFragment a;

        public a(BitableSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.W90();
        }
    }

    public static final class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ BitableSearchFragment a;

        public b(BitableSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 3) goto L6;
            BitableSearchFragment r4 = this.a;
            int r5 = BitableSearchFragment.m;
            r4.U90();
            return true;
        L6:
            return false;
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ BitableSearchFragment a;

        public c(BitableSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            int r7 = r6.getActionMasked();
            boolean r0 = false;
            if (r7 == 0) goto L9;
            if (r7 != 1) goto L6;
        L8:
            BitableSearchFragment r8 = this.a;
            boolean r9 = r8.j;
            r8.j = false;
            return r9;
        L6:
            if (r7 == 3) goto L8;
            return this.a.j;
        L9:
            BitableSearchFragment r10 = this.a;
            Intrinsics.checkNotNull(r6);
            int r2 = BitableSearchFragment.m;
            FragmentActivity r3 = r10.getActivity();
            if (r3 == null) goto L24;
            View r4 = r3.findViewById(2131364253);
            if (r4 == null) goto L24;
            if (r4.getGlobalVisibleRect(r10.k) == false) goto L24;
            if (r6.getRawX() < r10.k.left) goto L24;
            if (r6.getRawX() >= r10.k.right) goto L24;
            if (r6.getRawY() >= r10.k.bottom) goto L24;
            r0 = true;
        L24:
            r10.j = r0;
            BitableSearchFragment r11 = this.a;
            if (r11.j == false) goto L27;
            r11.W90();
        L29:
            return this.a.j;
        L27:
            r11.U90();
            goto L29
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BitableSearchFragment a;

        public d(BitableSearchFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            BitableSearchModel r8 = (BitableSearchModel) r7;
            SimpleItemModel r0 = r8.getTipsItem();
            if (r0 == null) goto L9;
            BitableSearchFragment r3 = this.a;
            m.z(r3.V90().d, true);
            r3.V90().f.setText(r0.getText());
            Icon r1 = r0.getIcon();
            if (r1 == null) goto L7;
            com.bytedance.ee.bear.bitable.panel.e.i(r3.V90().e, r1);
            Unit r2 = Unit.INSTANCE;
        L8:
            if (r2 == null) goto L9;
        L10:
            this.a.V90().c.a(r8.getRightIcon(), this.a.f);
            Integer r9 = r8.getSearchKeywordLengthLimit();
            if (r9 == null) goto L14;
            BitableSearchFragment r4 = this.a;
            int r10 = r9.intValue();
            r4.V90().h.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r10)});
            return;
        L14:
            return;
        L7:
            r2 = null;
        L9:
            m.z(this.a.V90().d, false);
            goto L10
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ BitableSearchFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ BitableSearchFragment a;

            public a(BitableSearchFragment r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BitableSearchModel r0 = (BitableSearchModel) this.a.e.getValue();     // Catch: Throwable -> L10
                if (r0 == null) goto L13;
                Icon r1 = r0.getRightIcon();     // Catch: Throwable -> L10
                if (r1 == null) goto L17;
                ActionPayload r2 = r1.getClickActionPayload();     // Catch: Throwable -> L10
                if (r2 == null) goto L18;
                this.a.f.a(r2);     // Catch: Throwable -> L10
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

        public e(BitableSearchFragment r1) {
            this.a = r1;
        }

        public final void a() {
            rcb.c.h(this.a.V90().h, null);
            sk5.c r0 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
            if (r0.f("base_new_global_search_guide") == false) goto L6;
            Log.i("BitableSearchFragment", "onboard>>> isMissionFinished.");
            return;
        L6:
            FragmentActivity r1 = this.a.getActivity();
            if (r1 == null) goto L16;
            BitableSearchFragment r2 = this.a;
            MutableLiveData<BitableSearchModel> r3 = r2.e;
            if (r3 == null) goto L17;
            BitableSearchModel r4 = (BitableSearchModel) r3.getValue();
            if (r4 == null) goto L18;
            String r5 = r4.getOnboardingText();
            if (r5 == null) goto L19;
            r0.g(new com.bytedance.ee.bear.bitable.search.c(r2.V90().c, r5, new a(r2)), r1);
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
        public final /* synthetic */ BitableSearchFragment a;

        public f(BitableSearchFragment r1) {
            this.a = r1;
        }

        public final void onAnimationEnd(Animation r2) {
            this.a.V90().j.setVisibility(8);
            this.a.g.run();
        }
    }

    public final BitableSearchFragmentBinding V90() {
        BitableSearchFragmentBinding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void W90() {
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        TranslateAnimation r0 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        r0.setDuration(200);
        r0.setAnimationListener(new f(this));
        V90().j.startAnimation(r0);
    }

    public final void U90() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (pcb.a.a.b(getActivity()).getVisibleKeyboardHeight() <= 0) goto L9;
        rcb.c.d(V90().h);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        W90();
        return true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        V90().h.removeTextChangedListener(this.l);
        U90();
        if (getActivity() == null) goto L6;
        pcb.a.a.b(getActivity()).a(this);
        return;
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        if (r5.orientation != 2) goto L5;
        V90().i.setPadding(0, n.d(9), 0, n.d(9));
        return;
    L5:
        V90().i.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()) + n.d(9), 0, n.d(9));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r14, Bundle r16) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r16);
        this.i = false;
        int r0 = 2131384438;
        TouchDetectFrameLayout r4 = ViewBindings.findChildViewById(r14, 2131384438);
        if (r4 == null) goto L27;
        r0 = 2131385341;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131385341)) == null) goto L27;
        r0 = 2131385354;
        SearchConfigIcon r5 = (SearchConfigIcon) ViewBindings.findChildViewById(r14, 2131385354);
        if (r5 == null) goto L27;
        r0 = 2131385367;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131385367);
        if (r6 == null) goto L27;
        r0 = 2131385368;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r14, 2131385368);
        if (r7 == null) goto L27;
        r0 = 2131385369;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131385369);
        if (r8 == null) goto L27;
        r0 = 2131385374;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r14, 2131385374);
        if (r9 == null) goto L27;
        r0 = 2131385429;
        SpaceEditText r10 = ViewBindings.findChildViewById(r14, 2131385429);
        if (r10 == null) goto L27;
        r0 = 2131385620;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131385620);
        if (r11 == null) goto L27;
        r0 = 2131385628;
        SpaceShadowLayout r12 = ViewBindings.findChildViewById(r14, 2131385628);
        if (r12 == null) goto L27;
        BitableSearchFragmentBinding r1 = new BitableSearchFragmentBinding((LinearLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.h = r1;
        V90().h.addTextChangedListener(this.l);
        V90().g.setOnClickListener(new a(this));
        V90().h.setOnEditorActionListener(new b(this));
        V90().b.setOnTouchListener(new c(this));
        V90().i.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()) + n.d(9), 0, n.d(9));
        this.e.observe(this, new d(this));
        V90().h.postDelayed(new e(this), 200);
        V90().j.setVisibility(0);
        TranslateAnimation r17 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        r17.setDuration(200);
        V90().j.startAnimation(r17);
        if (getActivity() == null) goto L28;
        pcb.a.a.b(getActivity()).c(this);
        return;
    L28:
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }

    public BitableSearchFragment(MutableLiveData r2, gv4.d r3, com.bytedance.ee.bear.bitable.search.e r4) {
        Intrinsics.checkNotNullParameter(r2, "liveData");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r4, "onClose");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.k = new Rect();
        this.l = new com.bytedance.ee.bear.bitable.search.d(this);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559144, r3, false);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (r2 != 0) goto L5;
        V90().h.clearFocus();
        return;
    }
}
