package com.bytedance.ee.bear.doc.structure.pad.container;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.structure.StructureViewModel;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import nz4.k;
import nz4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PadCatalogController {
    public static final /* synthetic */ int i = 0;
    public final WeakReference<PluginHost> a;
    public final Lazy b;
    public final Lazy c;
    public final CatalogViewModel d;
    public final StructureViewModel e;
    public final CatalogListView f;
    public int g;
    public Function0<Unit> h;

    public static final class a {
    }

    static {
    }

    public final PluginHost f() {
        return this.a.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.ee.bear.doc.structure.pad.container.PadCatalogController$setupView$3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g() {
        CatalogViewModel r0 = this.d;
        PluginHost r1 = f();
        LifecycleOwner r2 = null;
        if (r1 == null) goto L7;
        vo5.a r3 = r1.getUserComponent();
        if (r3 == null) goto L7;
        by4.d r4 = (by4.d) r3.a(by4.d.class);
    L8:
        r0.setKvStorage(r4);
        StructureViewModel r5 = this.e;
        PluginHost r6 = f();
        if (r6 == null) goto L11;
        Fragment r7 = r6.getHostFragment();
    L12:
        if (r7 == null) goto L15;
        r5.getContent().observe(r7, new c(this));
        r5.addContentTouchListener(new d(this));
    L15:
        PluginHost r8 = f();
        if (r8 == null) goto L18;
        LifecycleOwner r9 = r8.getLifecycleOwner();
    L19:
        if (r9 == null) goto L21;
        this.d.isCatalogOpenLiveData().observe(r9, new e(this));
        this.d.isModeChangedToPadLiveData().observe(r9, new f(this));
        this.d.getCatalogModeLiveData().observe(r9, new h(this));
        this.d.isEmbedModeChangedLiveData().observe(r9, new i(this));
        this.d.getActiveCatalogItemLiveData().observe(r9, new j(this));
    L21:
        this.f.setItemClickListener(new PadCatalogController$setupView$1(this));
        this.f.setItemHoverListener(new com.bytedance.ee.bear.doc.structure.pad.container.a(this));
        this.h = this.f.a(new PadCatalogController$setupView$3(this));
        View r10 = e();
        if (r10 == null) goto L31;
        PluginHost r11 = f();
        if (r11 == null) goto L27;
        r2 = r11.getLifecycleOwner();
    L27:
        if (r2 == null) goto L32;
        this.d.observeWidthChange(r10, r2);
        return;
    L32:
        return;
    L31:
        return;
    L18:
        r9 = null;
        goto L19
    L11:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final View e() {
        PluginHost r0 = f();
        if (r0 == null) goto L7;
        t r1 = r0.getUIContainer();
        if (r1 == null) goto L7;
        return r1.getContentView();
    L7:
        return null;
    }

    public PadCatalogController(WeakReference<PluginHost> r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginHostRef");
        this.a = r4;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.b = LazyKt.lazy(r5, new PadCatalogController$catalogContainer$2(this));
        this.c = LazyKt.lazy(r5, new PadCatalogController$webContainer$2(this));
        PluginHost r6 = f();
        if (r6 == null) goto L5;
        CatalogViewModel r7 = (CatalogViewModel) q.c(r6, CatalogViewModel.class, null);
    L7:
        if (r7 == null) goto L22;
        this.d = r7;
        PluginHost r8 = f();
        if (r8 == null) goto L11;
        StructureViewModel r9 = (StructureViewModel) q.c(r8, StructureViewModel.class, null);
    L12:
        if (r9 == null) goto L20;
        this.e = r9;
        PluginHost r2 = f();
        if (r2 == null) goto L18;
        this.f = new CatalogListView(r2.getContext(), null);
        return;
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        r9 = null;
        goto L12
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r7 = null;
        goto L7
    }

    public static final void a(final PadCatalogController r11) {
        final ViewGroup r0 = (ViewGroup) r11.b.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.indexOfChild(r11.f) == (-1)) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L24;
        ViewGroup r2 = (ViewGroup) r11.c.getValue();
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L15:
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        WeakHashMap<View, Animator> r4 = k.a;
        Function0<Unit> r5 = new PadCatalogController$hide$1$1(r11, r0);
        Intrinsics.checkNotNullParameter(r0, "view");
        WeakHashMap<View, Animator> r12 = k.a;
        Animator r6 = r12.remove(r0);
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        r0.setVisibility(0);
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{RangesKt.coerceAtLeast(r0.getWidth(), 0), 0});
        r7.setDuration(300);
        r7.setStartDelay(0);
        r7.setInterpolator(new AccelerateDecelerateInterpolator());
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        r7.addUpdateListener(new nz4.a(r0));
        r7.addListener(new nz4.b(r0, r8, r5));
        r12.put(r0, r7);
        r7.start();
        return;
    L20:
        WeakHashMap<View, Animator> r9 = k.a;
        Function0<Unit> r10 = new PadCatalogController$hide$1$2(r11, r0);
        int r13 = r0.getWidth();
        Intrinsics.checkNotNullParameter(r0, "view");
        r0.setVisibility(0);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{0.0f, -r13});
        r14.setDuration(300);
        r14.setStartDelay(0);
        r14.setInterpolator(new AccelerateDecelerateInterpolator());
        r14.addListener(new nz4.j(null, r0, r10));
        r14.start();
        return;
    L13:
        r3 = null;
        goto L15
    L24:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static final void b(PadCatalogController r4) {
        CatalogMode r0 = r4.d.getCatalogMode();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == CatalogMode.DIALOG) goto L17;
        String r1 = r0.getModeName();
        Boolean r2 = (Boolean) r4.d.isCatalogOpenLiveData().getValue();
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        JSONObject r5 = new JSONObject();
        r5.put("mode", r1);
        r5.put("isShowing", Boolean.valueOf(r3));
        vv4.k r6 = r4.e.getWeb();
        if (r6 == null) goto L16;
        r6.j("lark.biz.catalog.changeDisplayMode", r5);
        return;
    L16:
        return;
    L10:
        r3 = false;
        goto L11
    }

    public static final void c(final PadCatalogController r13) {
        if (r13.d.getCatalogMode() != null) goto L5;
        return;
    L5:
        if (r13.d.getCatalogMode() != CatalogMode.DIALOG) goto L7;
        return;
    L7:
        if (r13.d.isCatalogOpen() == false) goto L41;
        final ViewGroup r0 = (ViewGroup) r13.b.getValue();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.indexOfChild(r13.f) == (-1)) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L42;
        r0.setBackgroundResource(2131233843);
        int r2 = u0c.a.a(r13.d(r13.d.getCatalogMode()));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        ViewGroup r5 = (ViewGroup) r13.c.getValue();
        if (r5 == null) goto L20;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L22:
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        int r7 = 8388611;
    L25:
        r3.gravity = r7;
        r3.width = r2;
        ViewGroup r8 = (ViewGroup) r13.c.getValue();
        if (r8 == null) goto L28;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L30:
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        r0.setVisibility(0);
        r0.addView(r13.f, r3);
        WeakHashMap<View, Animator> r4 = k.a;
        Function0<Unit> r10 = new PadCatalogController$show$1$1(r0, r13);
        Intrinsics.checkNotNullParameter(r0, "view");
        WeakHashMap<View, Animator> r14 = k.a;
        Animator r11 = r14.remove(r0);
        if (r11 == null) goto L34;
        r11.cancel();
    L34:
        r0.setVisibility(0);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{RangesKt.coerceAtLeast(r0.getWidth(), 0), r2});
        r12.setDuration(300);
        r12.setStartDelay(0);
        r12.setInterpolator(new AccelerateDecelerateInterpolator());
        Ref.BooleanRef r16 = new Ref.BooleanRef();
        r12.addUpdateListener(new nz4.c(r0));
        r12.addListener(new nz4.d(r0, r16, r2, r10));
        r14.put(r0, r12);
        r12.start();
        return;
    L35:
        r0.setVisibility(4);
        r0.addView(r13.f, r3);
        WeakHashMap<View, Animator> r17 = k.a;
        Function0<Unit> r18 = new PadCatalogController$show$1$2(r13);
        int r19 = r0.getWidth();
        Intrinsics.checkNotNullParameter(r0, "view");
        r0.setTranslationX(-r0.getWidth());
        r0.setVisibility(0);
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{-r19, 0.0f});
        r110.setDuration(300);
        r110.setStartDelay(0);
        r110.setInterpolator(new AccelerateDecelerateInterpolator());
        r110.addListener(new nz4.i(null, r18));
        r110.start();
        return;
    L28:
        r9 = null;
        goto L30
    L24:
        r7 = 17;
        goto L25
    L20:
        r6 = null;
        goto L22
    L42:
        return;
    L14:
        r1 = false;
        goto L15
    }

    public final int d(CatalogMode r6) {
        int r0 = n.a;
        View r1 = e();
        if (r1 == null) goto L5;
        int r2 = r1.getWidth();
        Resources r3 = Resources.getSystem();
        int r4 = (int) ((r2 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    L6:
        if (r6 != null) goto L8;
        int r7 = -1;
    L10:
        if (r7 == 1) goto L16;
        if (r7 != 2) goto L22;
        return 272;
    L22:
        return 0;
    L16:
        if (r4 < 1240) goto L18;
        double r5 = 0.2361d;
    L20:
        return MathKt.roundToInt(r5 * ((double) r4));
    L18:
        r5 = 0.2d;
        goto L20
    L8:
        r7 = n.a.a[r6.ordinal()];
        goto L10
    L5:
        r4 = 0;
        goto L6
    }
}
