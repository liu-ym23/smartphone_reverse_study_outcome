package com.bytedance.ee.bear.doc.structure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Range;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mz4.f;
import mz4.g;
import mz4.h;
import mz4.i;
import mz4.j;
import mz4.k;
import mz4.l;
import mz4.m;
import mz4.o;
import mz4.p;
import mz4.r;
import mz4.s;
import mz4.t;
import mz4.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FloatingStructureFragment extends BaseFragment {
    public static final /* synthetic */ int F = 0;
    public final f A;
    public final g B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final String e;
    public w f;
    public StructureViewModel g;
    public float h;
    public float i;
    public int j;
    public View k;
    public boolean l;
    public int m;
    public View n;
    public View o;
    public ParagraphLayout p;
    public ViewGroup q;
    public e r;
    public List<View> s;
    public boolean t;
    public ObjectAnimator u;
    public AnimatorSet v;
    public ObjectAnimator w;
    public String x;
    public final s y;
    public final t z;

    public class a implements Observer<Structure> {
        public final /* synthetic */ FloatingStructureFragment a;

        public a(FloatingStructureFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Structure r6 = (Structure) r5;
            final FloatingStructureFragment r0 = this.a;
            int r1 = 0;
            r0.t = false;
            if (r6 == null) goto L6;
            r1 = r6.getParagraphCount();
        L6:
            int r7 = r0.p.getChildCount();
            int r2 = ((ArrayList) r0.s).size();
            if (r1 <= (r7 + r2)) goto L9;
            final ArrayList r3 = new ArrayList();
            Disposable r8 = Flowable.just(Integer.valueOf((r1 - r7) - r2)).flatMap(new h(r0, r3)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i(r0, r3), new j(r0));
            tt5.a.h(r0.e, "disposable = " + r8);
            return;
        L9:
            r0.aa0();
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ FloatingStructureFragment a;

        public b(FloatingStructureFragment r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r3) {
            this.a.E = true;
            return super.onDown(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            FloatingStructureFragment r5 = this.a;
            r5.E = false;
            r5.V90();
            com.bytedance.ee.util.ui.j.e(this.a.y);
            com.bytedance.ee.util.ui.j.d(this.a.y, 2000);
            return false;
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ FloatingStructureFragment a;

        public c(FloatingStructureFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.p.setVisibility(4);
            this.a.p.setAlpha(1.0f);
            this.a.Y90();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            com.bytedance.ee.util.ui.j.e(this.a.A);
            com.bytedance.ee.util.ui.j.d(this.a.A, 150);
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ FloatingStructureFragment a;

        public d(FloatingStructureFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.k.setVisibility(4);
        }
    }

    public class e implements g45.a, VcKeyboardChangeEventProducer {
        public MutableLiveData<Boolean> a;

        @Override // g45.a
        public final String getPanelName() {
            return "catalog";
        }

        @Override // g45.a
        public final void requestNotFocus(Context r1) {
        }

        @Override // g45.a
        public final LiveData<Boolean> getActive() {
            if (this.a != null) goto L6;
            this.a = new MutableLiveData();
        L6:
            return this.a;
        }

        public e() {
        }

        @Override // g45.a
        public final KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
            return KeyboardShowingStatusMode.ALWAYS_SHOW;
        }

        @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
        public final VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
            return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
        }

        @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
        public final VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
            return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
        }

        public final void a(boolean r3) {
            MutableLiveData r0 = getActive();
            if (r0.getValue() != null) goto L5;
        L6:
            r0.setValue(Boolean.valueOf(r3));
            return;
        L5:
            if (((Boolean) r0.getValue()).booleanValue() != r3) goto L6;
        }

        @Override // g45.a
        public final int getPanelHeight(Context r2) {
            return r2.getResources().getDimensionPixelSize(2131168470);
        }

        @Override // g45.a
        public final void onBecomeActive(g45.d r1, g45.a r2) {
            if (r2 != null) goto L5;
            r1.requestUpdateWebContentHeight();
            return;
        }

        @Override // g45.a
        public final void onBecomeInactive(g45.d r1, g45.a r2) {
            if (r2 != null) goto L5;
            r1.requestUpdateWebContentHeight();
            return;
        }
    }

    public final void Y90() {
        StructurePlugin r1 = (StructurePlugin) PluginHost.fromFragment(this).findPlugin(StructurePlugin.class);     // Catch: PluginInfoExtractException -> L11
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L14;
        tt5.a.k(this.e, "notifyFloatingStructureHiddenIfNeeded failed, plugin is null");     // Catch: PluginInfoExtractException -> L11
    L14:
        return;
    L6:
        if (r1.isFloatingStructureShowing() == false) goto L8;
        tt5.a.h(this.e, "notifyFloatingStructureHiddenIfNeeded");     // Catch: PluginInfoExtractException -> L11
        r1.notifyFloatingStructureVisibilityChanged(false);     // Catch: PluginInfoExtractException -> L11
    L11:
        e = move-exception;
        tt5.a.f(this.e, e, false);
    }

    public final void U90() {
        com.bytedance.ee.util.ui.j.e(this.y);
        tt5.a.b(this.e, "animationExit");
        Z90();
        W90();
    }

    public final void V90() {
        if (this.k.getVisibility() != 0) goto L6;
        return;
    L6:
        if (((Structure) this.g.getContent().getValue()) != null) goto L8;
        return;
    L8:
        if (this.t == false) goto L13;
        tt5.a.b(this.e, "animationInDragHandle");
        this.m = this.g.computeContentHeight();
        this.k.setVisibility(0);
        View r0 = this.k;
        ObjectAnimator.ofFloat(r0, "x", new float[]{r0.getWidth(), 0.0f}).setDuration(200).start();
        return;
    }

    public final void W90() {
        ObjectAnimator r0 = this.u;
        if (r0 == null) goto L7;
        if (r0.isRunning() == false) goto L7;
        return;
    L7:
        if (this.k.getVisibility() != 0) goto L11;
        View r1 = this.k;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "x", new float[]{r1.getX(), this.k.getWidth()}).setDuration(300);
        this.u = r2;
        r2.addListener(new d(this));
        this.u.start();
        return;
    }

    public final Range<Float> X90() {
        float r0 = this.q.getPaddingTop();
        float r1 = (this.q.getHeight() - this.q.getPaddingBottom()) - this.k.getHeight();
        if (r0 < r1) goto L7;
        return new Range(Float.valueOf(r0), Float.valueOf(r0 + 1.0f));
    L7:
        return new Range(Float.valueOf(r0), Float.valueOf(r1));
    }

    public final void Z90() {
        AnimatorSet r0 = this.v;
        if (r0 == null) goto L7;
        if (r0.isRunning() == false) goto L7;
        return;
    L7:
        if (this.p.getVisibility() != 0) goto L11;
        ParagraphLayout r1 = this.p;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "x", new float[]{r1.getX(), this.o.getWidth()});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.p, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r4 = new AnimatorSet();
        this.v = r4;
        r4.playTogether(new Animator[]{r2, r3});
        this.v.addListener(new c(this));
        this.v.setDuration(300).start();
        return;
    }

    public final void aa0() {
        tt5.a.b(this.e, "resetParagraphViews");
        Structure r0 = (Structure) this.g.getContent().getValue();
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = this.p.getChildCount();
        if (r2 <= (((ArrayList) this.s).size() + r3)) goto L11;
        tt5.a.d(this.e, "resetParagraphViews ERR");
        return;
    L11:
        if (r3 <= r2) goto L16;
        int r5 = 0;
    L14:
        if (r5 >= (r3 - r2)) goto L21;
        ParagraphLayout r6 = this.p;
        View r7 = r6.getChildAt(r6.getChildCount() - 1);
        this.p.removeView(r7);
        ((ArrayList) this.s).add(r7);
        r5 = r5 + 1;
    L21:
        int r4 = 0;
    L22:
        if (r4 >= r2) goto L27;
        TextView r8 = (TextView) this.p.getChildAt(r4);
        final Structure.Paragraph r9 = r0.getParagraph(r4);
        r8.setText(r9.title);
        r8.setTag(r9);
        if (this.C == false) goto L26;
        LarkFont r10 = LarkFont.BODY1;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "larkFont");
        Context r11 = r8.getContext();
        ZoomLevel6 r12 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r10, "larkFont");
        r8.setTextSize(0, zz7.b.a(r11, zz7.b.c(r10)));
    L26:
        r8.setOnClickListener(new k(this, r9));
        r4 = r4 + 1;
        goto L22
    L27:
        this.m = this.g.computeContentHeight();
        ba0(this.g.getContentScroll());
        this.t = true;
        return;
    L16:
        if (r3 >= r2) goto L21;
        int r13 = 0;
    L19:
        if (r13 >= (r2 - r3)) goto L21;
        View r14 = (View) ListProtector.remove(this.s, 0);
        this.p.addView(r14);
        r13 = r13 + 1;
        goto L19
    L5:
        r2 = r0.getParagraphCount();
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [mz4.s] */
    /* JADX WARN: Type inference failed for: r0v4, types: [mz4.t] */
    /* JADX WARN: Type inference failed for: r0v5, types: [mz4.f] */
    /* JADX WARN: Type inference failed for: r0v6, types: [mz4.g] */
    public FloatingStructureFragment() {
        this.e = "FloatingStructure#" + Integer.toHexString(hashCode());
        this.x = "";
        this.y = new s(this);
        this.z = new t(this);
        this.A = new f(this);
        this.B = new g(this);
        this.D = false;
        this.E = false;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.ee.util.ui.j.e(this.y);
        Y90();
        this.r.a(false);
        this.g.setContentScrollListener(null);
        this.g.setContentTouchListener(null);
    }

    static {
    }

    public final void ba0(int r9) {
        Structure r0 = (Structure) this.g.getContent().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.m;
        if (r1 != 0) goto L8;
        return;
    L8:
        float r10 = r9;
        Range<Float> r2 = X90();
        this.k.setY(((Float) X90().clamp(Float.valueOf(((r10 / r1) * (((Float) r2.getUpper()).floatValue() - ((Float) r2.getLower()).floatValue())) + ((Float) r2.getLower()).floatValue()))).floatValue());
        if (this.g.isUpdateActiveByFixedStructure() == false) goto L19;
        String r11 = this.g.getActive();
        int r3 = r0.getParagraphCount();
        if (r3 == 0) goto L21;
        Structure.Paragraph r4 = r0.getParagraph(0);
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L30;
        Structure.Paragraph r6 = r0.getParagraph(r5);
        if (r11.equals(r6.getHash()) == true) goto L17;
        r5 = r5 + 1;
        goto L14
    L17:
        r4 = r6;
    L30:
        this.g.setIsUpdateActiveByFixedStructure(false);
        if (r4 == null) goto L39;
        int r12 = this.p.getChildCount();
        int r7 = 0;
    L34:
        if (r7 >= r12) goto L39;
        if (r4 == this.p.getChildAt(r7).getTag()) goto L40;
        r7 = r7 + 1;
    L40:
        if (r7 < 0) goto L54;
        this.g.setActive(r4.getHash());
        float r8 = ((this.k.getY() + (this.k.getHeight() / 2.0f)) - (((TextView) this.p.getChildAt(r7)).getHeight() / 2.0f)) + (this.q.getTop() - this.p.getTop());
        int r13 = this.p.getChildCount();
        int r14 = n.d(4);
        int r16 = r13 - 1;
    L42:
        if (r16 < 0) goto L65;
        TextView r17 = (TextView) this.p.getChildAt(r16);
        int r18 = r16 - r7;
        r17.setY(((r17.getHeight() + r14) * r18) + r8);
        if (r18 != 0) goto L46;
        boolean r19 = true;
    L47:
        r17.setSelected(r19);
        if (r19 == false) goto L50;
        da0(this.g.getActive());
    L50:
        if (r19 == false) goto L52;
        int r20 = 5;
    L53:
        r17.setElevation(n.d(r20));
        r16 = r16 - 1;
        goto L42
    L52:
        r20 = 0;
        goto L53
    L46:
        r19 = false;
        goto L47
    L65:
        return;
    L54:
        return;
    L39:
        r7 = -1;
    L21:
        r4 = null;
        goto L30
    L19:
        float r21 = (this.q.getTop() + this.k.getY()) + r10;
        int r22 = r0.getParagraphCount();
        if (r22 == 0) goto L21;
        r4 = r0.getParagraph(0);
        int r23 = 0;
    L23:
        if (r23 >= r22) goto L30;
        Structure.Paragraph r24 = r0.getParagraph(r23);
        int r26 = r24.top;
        if (r26 < 0) goto L30;
        if (r21 <= r26) goto L30;
        r23 = r23 + 1;
        r4 = r24;
        goto L23
    }

    public final void ca0(float r5) {
        float r0 = this.i + (r5 - this.h);
        Range<Float> r6 = X90();
        if ((Math.abs(this.k.getY() - ((Float) r6.clamp(Float.valueOf(r0))).floatValue()) / (((Float) r6.getUpper()).floatValue() - ((Float) r6.getLower()).floatValue())) >= 0.001f) goto L5;
        return;
    L5:
        this.k.setY(((Float) X90().clamp(Float.valueOf(r0))).floatValue());
        int r7 = Math.round(((this.k.getY() - ((Float) r6.getLower()).floatValue()) / (((Float) r6.getUpper()).floatValue() - ((Float) r6.getLower()).floatValue())) * this.m);
        if (r7 >= 0) goto L8;
        r7 = 0;
    L12:
        if (this.j != 0) goto L14;
        this.j = r7;
    L14:
        this.g.scrollTo(this.j, r7);
        this.j = r7;
        return;
    L8:
        int r1 = this.m;
        if (r7 <= r1) goto L12;
        r7 = r1;
        goto L12
    }

    public final void da0(String r4) {
        if (this.p.getVisibility() == 0) goto L5;
        this.x = "";
        return;
    L5:
        if (this.x.equals(r4) == true) goto L7;
        eu5.h.a(getContext(), 10, 50);
    L7:
        this.x = r4;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        StructureViewModel r0 = (StructureViewModel) q.a(this, StructureViewModel.class);
        this.g = r0;
        this.f = r0.getStructureAnalytic();
        EditPanelsManager r1 = (EditPanelsManager) ViewModelProviders.of(r4).get(EditPanelsManager.class);
        e r2 = new e();
        this.r = r2;
        r1.registerEditPanel(this, r2);
        pcb.a.a.b(r4).c(r1);
        this.s = new ArrayList();
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.C = r5.getBoolean(StructurePlugin.ENABLE_FONT_SCALE);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        this.o = r6.findViewById(2131367796);
        View r0 = r6.findViewById(2131370194);
        this.k = r0;
        r0.setVisibility(4);
        ViewGroup r1 = (ViewGroup) r6.findViewById(2131370195);
        this.q = r1;
        r1.setOnTouchListener(new mz4.e(this));
        this.g.floatingStructureVisible().observe(this, new l(this));
        if (getActivity() != null) goto L5;
    L7:
        ParagraphLayout r2 = (ParagraphLayout) r6.findViewById(2131381916);
        this.p = r2;
        r2.setVisibility(4);
        if (en4.a.l() == false) goto L17;
        View r3 = getView();
        if (r3 == null) goto L17;
        if (r3.findViewById(2131367796) == null) goto L17;
        ConstraintLayout.LayoutParams r8 = this.p.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r8).height = 0;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = n.d(50);
        r8.topToTop = 0;
        r8.bottomToTop = 2131386372;
        this.p.setLayoutParams(r8);
    L17:
        this.p.setOnActionDownListener(new m(this));
        this.p.setOnTouchListener(new mz4.n(this));
        ((KeyboardPlaceholderView) r6.findViewById(2131376823)).setNeedRecordVisible(false);
        View r9 = r6.findViewById(2131386372);
        this.n = r9;
        if (this.C == false) goto L20;
        TextView r10 = (TextView) r9;
        LarkFont r11 = LarkFont.BODY1;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "larkFont");
        Context r4 = r10.getContext();
        ZoomLevel6 r5 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r11, "larkFont");
        r10.setTextSize(0, zz7.b.a(r4, zz7.b.c(r11)));
    L20:
        this.n.setVisibility(4);
        this.n.setOnClickListener(new o(this));
        this.g.getContent().observe(this, new a(this));
        this.g.setContentScrollListener(new p(this));
        final GestureDetector r12 = new GestureDetector(getContext(), new b(this));
        this.g.setContentTouchListener(new mz4.q(r12));
        this.g.setFixMode(false);
        this.o.setOnTouchListener(new r(this));
        if (ForsetiHelper.s(this) == false) goto L24;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(n.d(44), n.d(70));
        this.k.setLayoutParams(r13);
        return;
    L24:
        return;
    L5:
        if (yo5.a.a(getActivity()) == false) goto L7;
        ((ImageView) this.k).setImageDrawable(AppCompatResources.getDrawable(getActivity(), 2131235412));
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131561116, r3, false);
    }
}
