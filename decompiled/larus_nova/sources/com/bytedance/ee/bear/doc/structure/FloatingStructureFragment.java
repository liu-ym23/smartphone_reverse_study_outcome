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
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes16.dex */
public class FloatingStructureFragment extends BaseFragment {
    public static final /* synthetic */ int F = 0;
    public final f A;
    public final g B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f218163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f218164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StructureViewModel f218165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f218166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f218167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f218168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f218169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f218170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f218171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f218172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f218173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ParagraphLayout f218174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f218175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public e f218176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<View> f218177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f218178t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObjectAnimator f218179u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimatorSet f218180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ObjectAnimator f218181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f218182x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s f218183y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final t f218184z;

    public class a implements Observer<Structure> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingStructureFragment f218185a;

        public a(FloatingStructureFragment r100) {
            this.f218185a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Structure r100) {
            Structure r101 = r100;
            final FloatingStructureFragment r102 = this.f218185a;
            int r103 = 0;
            r102.f218178t = false;
            if (r101 == null) goto L6;
            r103 = r101.getParagraphCount();
        L6:
            int r104 = r102.f218174p.getChildCount();
            int r105 = ((ArrayList) r102.f218177s).size();
            if (r103 <= (r104 + r105)) goto L9;
            final ArrayList r106 = new ArrayList();
            Disposable r107 = Flowable.just(Integer.valueOf((r103 - r104) - r105)).flatMap(new h(r102, r106)).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i(r102, r106), new j(r102));
            tt5.a.h(r102.f218163e, "disposable = " + r107);
            return;
        L9:
            r102.aa0();
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingStructureFragment f218186a;

        public b(FloatingStructureFragment r100) {
            this.f218186a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            this.f218186a.E = true;
            return super.onDown(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            FloatingStructureFragment r104 = this.f218186a;
            r104.E = false;
            r104.V90();
            com.bytedance.ee.util.ui.j.e(this.f218186a.f218183y);
            com.bytedance.ee.util.ui.j.d(this.f218186a.f218183y, 2000);
            return false;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingStructureFragment f218187a;

        public c(FloatingStructureFragment r100) {
            this.f218187a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f218187a.f218174p.setVisibility(4);
            this.f218187a.f218174p.setAlpha(1.0f);
            this.f218187a.Y90();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            com.bytedance.ee.util.ui.j.e(this.f218187a.A);
            com.bytedance.ee.util.ui.j.d(this.f218187a.A, 150);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingStructureFragment f218188a;

        public d(FloatingStructureFragment r100) {
            this.f218188a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f218188a.f218169k.setVisibility(4);
        }
    }

    public class e implements g45.a, VcKeyboardChangeEventProducer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MutableLiveData<Boolean> f218189a;

        @Override // g45.a
        public final String getPanelName() {
            return DocumentType.WIKI_FOLDER_NAME;
        }

        @Override // g45.a
        public final void requestNotFocus(Context r100) {
        }

        @Override // g45.a
        public final LiveData<Boolean> getActive() {
            if (this.f218189a != null) goto L6;
            this.f218189a = new MutableLiveData();
        L6:
            return this.f218189a;
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

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(boolean r100) {
            MutableLiveData r101 = (MutableLiveData) getActive();
            if (r101.getValue() != 0) goto L5;
        L6:
            r101.setValue(Boolean.valueOf(r100));
            return;
        L5:
            if (((Boolean) r101.getValue()).booleanValue() != r100) goto L6;
        }

        @Override // g45.a
        public final int getPanelHeight(Context r100) {
            return r100.getResources().getDimensionPixelSize(R.dimen.toolbar_menu_height);
        }

        @Override // g45.a
        public final void onBecomeActive(g45.d r100, g45.a r101) {
            if (r101 != null) goto L5;
            r100.requestUpdateWebContentHeight();
            return;
        }

        @Override // g45.a
        public final void onBecomeInactive(g45.d r100, g45.a r101) {
            if (r101 != null) goto L5;
            r100.requestUpdateWebContentHeight();
            return;
        }
    }

    public final void Y90() {
        StructurePlugin r100 = (StructurePlugin) PluginHost.fromFragment(this).findPlugin(StructurePlugin.class);     // Catch: PluginInfoExtractException -> L11
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L14;
        tt5.a.k(this.f218163e, "notifyFloatingStructureHiddenIfNeeded failed, plugin is null");     // Catch: PluginInfoExtractException -> L11
    L14:
        return;
    L6:
        if (r100.isFloatingStructureShowing() == false) goto L8;
        tt5.a.h(this.f218163e, "notifyFloatingStructureHiddenIfNeeded");     // Catch: PluginInfoExtractException -> L11
        r100.notifyFloatingStructureVisibilityChanged(false);     // Catch: PluginInfoExtractException -> L11
    L11:
        e = move-exception;
        tt5.a.f(this.f218163e, e, false);
    }

    public final void U90() {
        com.bytedance.ee.util.ui.j.e(this.f218183y);
        tt5.a.b(this.f218163e, "animationExit");
        Z90();
        W90();
    }

    public final void V90() {
        if (this.f218169k.getVisibility() != 0) goto L6;
        return;
    L6:
        if (this.f218165g.getContent().getValue() != null) goto L8;
        return;
    L8:
        if (this.f218178t == false) goto L13;
        tt5.a.b(this.f218163e, "animationInDragHandle");
        this.f218171m = this.f218165g.computeContentHeight();
        this.f218169k.setVisibility(0);
        View r100 = this.f218169k;
        ObjectAnimator.ofFloat(r100, "x", new float[]{r100.getWidth(), 0.0f}).setDuration(200).start();
        return;
    }

    public final void W90() {
        ObjectAnimator r100 = this.f218179u;
        if (r100 == null) goto L7;
        if (r100.isRunning() == false) goto L7;
        return;
    L7:
        if (this.f218169k.getVisibility() != 0) goto L11;
        View r101 = this.f218169k;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "x", new float[]{r101.getX(), this.f218169k.getWidth()}).setDuration(300);
        this.f218179u = r102;
        r102.addListener(new d(this));
        this.f218179u.start();
        return;
    }

    public final Range<Float> X90() {
        float r100 = this.f218175q.getPaddingTop();
        float r101 = (this.f218175q.getHeight() - this.f218175q.getPaddingBottom()) - this.f218169k.getHeight();
        if (r100 < r101) goto L7;
        return new Range(Float.valueOf(r100), Float.valueOf(r100 + 1.0f));
    L7:
        return new Range(Float.valueOf(r100), Float.valueOf(r101));
    }

    public final void Z90() {
        AnimatorSet r100 = this.f218180v;
        if (r100 == null) goto L7;
        if (r100.isRunning() == false) goto L7;
        return;
    L7:
        if (this.f218174p.getVisibility() != 0) goto L11;
        ParagraphLayout r101 = this.f218174p;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "x", new float[]{r101.getX(), this.f218173o.getWidth()});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f218174p, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r104 = new AnimatorSet();
        this.f218180v = r104;
        r104.playTogether(new Animator[]{r102, r103});
        this.f218180v.addListener(new c(this));
        this.f218180v.setDuration(300).start();
        return;
    }

    public final void aa0() {
        tt5.a.b(this.f218163e, "resetParagraphViews");
        Structure r100 = this.f218165g.getContent().getValue();
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = this.f218174p.getChildCount();
        if (r101 <= (((ArrayList) this.f218177s).size() + r102)) goto L11;
        tt5.a.d(this.f218163e, "resetParagraphViews ERR");
        return;
    L11:
        if (r102 <= r101) goto L16;
        int r103 = 0;
    L14:
        if (r103 >= (r102 - r101)) goto L21;
        ParagraphLayout r104 = this.f218174p;
        View r105 = r104.getChildAt(r104.getChildCount() - 1);
        this.f218174p.removeView(r105);
        ((ArrayList) this.f218177s).add(r105);
        r103 = r103 + 1;
    L21:
        int r106 = 0;
    L22:
        if (r106 >= r101) goto L27;
        TextView r107 = (TextView) this.f218174p.getChildAt(r106);
        final Structure.Paragraph r108 = r100.getParagraph(r106);
        r107.setText(r108.title);
        r107.setTag(r108);
        if (this.C == false) goto L26;
        LarkFont r109 = LarkFont.BODY1;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r109, "larkFont");
        Context r110 = r107.getContext();
        ZoomLevel6 r111 = zz7.b.f574096a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r109, "larkFont");
        r107.setTextSize(0, zz7.b.a(r110, zz7.b.c(r109)));
    L26:
        r107.setOnClickListener(new k(this, r108));
        r106 = r106 + 1;
        goto L22
    L27:
        this.f218171m = this.f218165g.computeContentHeight();
        ba0(this.f218165g.getContentScroll());
        this.f218178t = true;
        return;
    L16:
        if (r102 >= r101) goto L21;
        int r112 = 0;
    L19:
        if (r112 >= (r101 - r102)) goto L21;
        View r113 = (View) ListProtector.remove(this.f218177s, 0);
        this.f218174p.addView(r113);
        r112 = r112 + 1;
        goto L19
    L5:
        r101 = r100.getParagraphCount();
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [mz4.s] */
    /* JADX WARN: Type inference failed for: r0v4, types: [mz4.t] */
    /* JADX WARN: Type inference failed for: r0v5, types: [mz4.f] */
    /* JADX WARN: Type inference failed for: r0v6, types: [mz4.g] */
    public FloatingStructureFragment() {
        this.f218163e = "FloatingStructure#" + Integer.toHexString(hashCode());
        this.f218182x = "";
        this.f218183y = new s(this);
        this.f218184z = new t(this);
        this.A = new f(this);
        this.B = new g(this);
        this.D = false;
        this.E = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.ee.util.ui.j.e(this.f218183y);
        Y90();
        this.f218176r.a(false);
        this.f218165g.setContentScrollListener(null);
        this.f218165g.setContentTouchListener(null);
    }

    static {
    }

    public final void ba0(int r100) {
        Structure r101 = this.f218165g.getContent().getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = this.f218171m;
        if (r102 != 0) goto L8;
        return;
    L8:
        float r103 = r100;
        Range<Float> r104 = X90();
        this.f218169k.setY(((Float) X90().clamp(Float.valueOf(((r103 / r102) * (((Float) r104.getUpper()).floatValue() - ((Float) r104.getLower()).floatValue())) + ((Float) r104.getLower()).floatValue()))).floatValue());
        if (this.f218165g.isUpdateActiveByFixedStructure() == false) goto L19;
        String r105 = this.f218165g.getActive();
        int r106 = r101.getParagraphCount();
        if (r106 == 0) goto L21;
        Structure.Paragraph r107 = r101.getParagraph(0);
        int r108 = 0;
    L14:
        if (r108 >= r106) goto L30;
        Structure.Paragraph r109 = r101.getParagraph(r108);
        if (r105.equals(r109.getHash()) == true) goto L17;
        r108 = r108 + 1;
        goto L14
    L17:
        r107 = r109;
    L30:
        this.f218165g.setIsUpdateActiveByFixedStructure(false);
        if (r107 == null) goto L39;
        int r110 = this.f218174p.getChildCount();
        int r111 = 0;
    L34:
        if (r111 >= r110) goto L39;
        if (r107 == this.f218174p.getChildAt(r111).getTag()) goto L40;
        r111 = r111 + 1;
    L40:
        if (r111 < 0) goto L54;
        this.f218165g.setActive(r107.getHash());
        float r112 = ((this.f218169k.getY() + (this.f218169k.getHeight() / 2.0f)) - (((TextView) this.f218174p.getChildAt(r111)).getHeight() / 2.0f)) + (this.f218175q.getTop() - this.f218174p.getTop());
        int r113 = this.f218174p.getChildCount();
        int r114 = n.d(4);
        int r115 = r113 - 1;
    L42:
        if (r115 < 0) goto L65;
        TextView r116 = (TextView) this.f218174p.getChildAt(r115);
        int r117 = r115 - r111;
        r116.setY(((r116.getHeight() + r114) * r117) + r112);
        if (r117 != 0) goto L46;
        boolean r118 = true;
    L47:
        r116.setSelected(r118);
        if (r118 == false) goto L50;
        da0(this.f218165g.getActive());
    L50:
        if (r118 == false) goto L52;
        int r119 = 5;
    L53:
        r116.setElevation(n.d(r119));
        r115 = r115 - 1;
        goto L42
    L52:
        r119 = 0;
        goto L53
    L46:
        r118 = false;
        goto L47
    L65:
        return;
    L54:
        return;
    L39:
        r111 = -1;
    L21:
        r107 = null;
        goto L30
    L19:
        float r120 = (this.f218175q.getTop() + this.f218169k.getY()) + r103;
        int r121 = r101.getParagraphCount();
        if (r121 == 0) goto L21;
        r107 = r101.getParagraph(0);
        int r122 = 0;
    L23:
        if (r122 >= r121) goto L30;
        Structure.Paragraph r123 = r101.getParagraph(r122);
        int r124 = r123.top;
        if (r124 < 0) goto L30;
        if (r120 <= r124) goto L30;
        r122 = r122 + 1;
        r107 = r123;
        goto L23
    }

    public final void ca0(float r100) {
        float r101 = this.f218167i + (r100 - this.f218166h);
        Range<Float> r102 = X90();
        if ((Math.abs(this.f218169k.getY() - ((Float) r102.clamp(Float.valueOf(r101))).floatValue()) / (((Float) r102.getUpper()).floatValue() - ((Float) r102.getLower()).floatValue())) >= 0.001f) goto L5;
        return;
    L5:
        this.f218169k.setY(((Float) X90().clamp(Float.valueOf(r101))).floatValue());
        int r103 = Math.round(((this.f218169k.getY() - ((Float) r102.getLower()).floatValue()) / (((Float) r102.getUpper()).floatValue() - ((Float) r102.getLower()).floatValue())) * this.f218171m);
        if (r103 >= 0) goto L8;
        r103 = 0;
    L12:
        if (this.f218168j != 0) goto L14;
        this.f218168j = r103;
    L14:
        this.f218165g.scrollTo(this.f218168j, r103);
        this.f218168j = r103;
        return;
    L8:
        int r104 = this.f218171m;
        if (r103 <= r104) goto L12;
        r103 = r104;
        goto L12
    }

    public final void da0(String r100) {
        if (this.f218174p.getVisibility() == 0) goto L5;
        this.f218182x = "";
        return;
    L5:
        if (this.f218182x.equals(r100) == true) goto L7;
        eu5.h.a(getContext(), 10, 50);
    L7:
        this.f218182x = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        StructureViewModel r102 = (StructureViewModel) q.a(this, StructureViewModel.class);
        this.f218165g = r102;
        this.f218164f = r102.getStructureAnalytic();
        EditPanelsManager r103 = (EditPanelsManager) ViewModelProviders.of(r101).get(EditPanelsManager.class);
        e r104 = new e();
        this.f218176r = r104;
        r103.registerEditPanel(this, r104);
        pcb.a.AbstractC7181a.b(r101).c(r103);
        this.f218177s = new ArrayList();
        Bundle r105 = getArguments();
        if (r105 == null) goto L6;
        this.C = r105.getBoolean(StructurePlugin.ENABLE_FONT_SCALE);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f218173o = r100.findViewById(R.id.contentExcludeKeyboard);
        View r102 = r100.findViewById(R.id.dragHandle);
        this.f218169k = r102;
        r102.setVisibility(4);
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.dragHandleContainer);
        this.f218175q = r103;
        r103.setOnTouchListener(new mz4.e(this));
        this.f218165g.floatingStructureVisible().observe(this, new l(this));
        if (getActivity() != null) goto L5;
    L7:
        ParagraphLayout r104 = (ParagraphLayout) r100.findViewById(R.id.paragraphContainer);
        this.f218174p = r104;
        r104.setVisibility(4);
        if (en4.a.l() == false) goto L17;
        View r105 = getView();
        if (r105 == null) goto L17;
        if (((ConstraintLayout) r105.findViewById(R.id.contentExcludeKeyboard)) == null) goto L17;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) this.f218174p.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r106).height = 0;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = n.d(50);
        r106.topToTop = 0;
        r106.bottomToTop = R.id.showFixedStructure;
        this.f218174p.setLayoutParams(r106);
    L17:
        this.f218174p.setOnActionDownListener(new m(this));
        this.f218174p.setOnTouchListener(new mz4.n(this));
        ((KeyboardPlaceholderView) r100.findViewById(R.id.keyboardPlaceholder)).setNeedRecordVisible(false);
        View r107 = r100.findViewById(R.id.showFixedStructure);
        this.f218172n = r107;
        if (this.C == false) goto L20;
        TextView r108 = (TextView) r107;
        LarkFont r109 = LarkFont.BODY1;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r109, "larkFont");
        Context r110 = r108.getContext();
        ZoomLevel6 r111 = zz7.b.f574096a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r109, "larkFont");
        r108.setTextSize(0, zz7.b.a(r110, zz7.b.c(r109)));
    L20:
        this.f218172n.setVisibility(4);
        this.f218172n.setOnClickListener(new o(this));
        this.f218165g.getContent().observe(this, new a(this));
        this.f218165g.setContentScrollListener(new p(this));
        final GestureDetector r112 = new GestureDetector(getContext(), new b(this));
        this.f218165g.setContentTouchListener(new mz4.q(r112));
        this.f218165g.setFixMode(false);
        this.f218173o.setOnTouchListener(new r(this));
        if (ForsetiHelper.s(this) == false) goto L24;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(n.d(44), n.d(70));
        this.f218169k.setLayoutParams(r113);
        return;
    L24:
        return;
    L5:
        if (yo5.a.a(getActivity()) == false) goto L7;
        ((ImageView) this.f218169k).setImageDrawable(AppCompatResources.getDrawable(getActivity(), R.drawable.floating_structure_handle_pad));
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.floating_structure_fragment, r101, false);
    }
}
