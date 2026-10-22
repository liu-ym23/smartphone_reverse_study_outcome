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
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.structure.StructureViewModel;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes16.dex */
public final class PadCatalogController {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f218228i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<PluginHost> f218229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f218230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f218231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CatalogViewModel f218232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StructureViewModel f218233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CatalogListView f218234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f218235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f218236h;

    public static final class a {
    }

    static {
    }

    public final PluginHost f() {
        return this.f218229a.get();
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
        CatalogViewModel r100 = this.f218232d;
        PluginHost r101 = f();
        LifecycleOwner r102 = null;
        if (r101 == null) goto L7;
        vo5.a r103 = r101.getUserComponent();
        if (r103 == null) goto L7;
        by4.d r104 = (by4.d) r103.a(by4.d.class);
    L8:
        r100.setKvStorage(r104);
        StructureViewModel r105 = this.f218233e;
        PluginHost r106 = f();
        if (r106 == null) goto L11;
        Fragment r107 = r106.getHostFragment();
    L12:
        if (r107 == null) goto L15;
        r105.getContent().observe(r107, new c(this));
        r105.addContentTouchListener(new d(this));
    L15:
        PluginHost r108 = f();
        if (r108 == null) goto L18;
        LifecycleOwner r109 = r108.getLifecycleOwner();
    L19:
        if (r109 == null) goto L21;
        this.f218232d.isCatalogOpenLiveData().observe(r109, new e(this));
        this.f218232d.isModeChangedToPadLiveData().observe(r109, new f(this));
        this.f218232d.getCatalogModeLiveData().observe(r109, new h(this));
        this.f218232d.isEmbedModeChangedLiveData().observe(r109, new i(this));
        this.f218232d.getActiveCatalogItemLiveData().observe(r109, new j(this));
    L21:
        this.f218234f.setItemClickListener(new PadCatalogController$setupView$1(this));
        this.f218234f.setItemHoverListener(new com.bytedance.ee.bear.doc.structure.pad.container.a(this));
        this.f218236h = this.f218234f.a(new PadCatalogController$setupView$3(this));
        View r110 = e();
        if (r110 == null) goto L31;
        PluginHost r111 = f();
        if (r111 == null) goto L27;
        r102 = r111.getLifecycleOwner();
    L27:
        if (r102 == null) goto L32;
        this.f218232d.observeWidthChange(r110, r102);
        return;
    L32:
        return;
    L31:
        return;
    L18:
        r109 = null;
        goto L19
    L11:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final View e() {
        PluginHost r100 = f();
        if (r100 == null) goto L7;
        t r101 = r100.getUIContainer();
        if (r101 == null) goto L7;
        return r101.getContentView();
    L7:
        return null;
    }

    public PadCatalogController(WeakReference<PluginHost> r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHostRef");
        this.f218229a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f218230b = LazyKt.lazy(r101, new PadCatalogController$catalogContainer$2(this));
        this.f218231c = LazyKt.lazy(r101, new PadCatalogController$webContainer$2(this));
        PluginHost r102 = f();
        if (r102 == null) goto L5;
        CatalogViewModel r103 = (CatalogViewModel) q.c(r102, CatalogViewModel.class, null);
    L7:
        if (r103 == null) goto L22;
        this.f218232d = r103;
        PluginHost r104 = f();
        if (r104 == null) goto L11;
        StructureViewModel r105 = (StructureViewModel) q.c(r104, StructureViewModel.class, null);
    L12:
        if (r105 == null) goto L20;
        this.f218233e = r105;
        PluginHost r106 = f();
        if (r106 == null) goto L18;
        this.f218234f = new CatalogListView(r106.getContext(), null);
        return;
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        r105 = null;
        goto L12
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r103 = null;
        goto L7
    }

    public static final void a(final PadCatalogController r110) {
        final ViewGroup r100 = (ViewGroup) r110.f218230b.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.indexOfChild(r110.f218234f) == (-1)) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L24;
        ViewGroup r102 = (ViewGroup) r110.f218231c.getValue();
        if (r102 == null) goto L13;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L15:
        if ((r103 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        WeakHashMap<View, Animator> r104 = k.f521405a;
        Function0<Unit> r105 = new PadCatalogController$hide$1$1(r110, r100);
        Intrinsics.checkNotNullParameter(r100, "view");
        WeakHashMap<View, Animator> r111 = k.f521405a;
        Animator r106 = r111.remove(r100);
        if (r106 == null) goto L19;
        r106.cancel();
    L19:
        r100.setVisibility(0);
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{RangesKt.coerceAtLeast(r100.getWidth(), 0), 0});
        r107.setDuration(300);
        r107.setStartDelay(0);
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        Ref.BooleanRef r108 = new Ref.BooleanRef();
        r107.addUpdateListener(new nz4.a(r100));
        r107.addListener(new nz4.b(r100, r108, r105));
        r111.put(r100, r107);
        r107.start();
        return;
    L20:
        WeakHashMap<View, Animator> r109 = k.f521405a;
        Function0<Unit> r112 = new PadCatalogController$hide$1$2(r110, r100);
        int r113 = r100.getWidth();
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setVisibility(0);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -r113});
        r114.setDuration(300);
        r114.setStartDelay(0);
        r114.setInterpolator(new AccelerateDecelerateInterpolator());
        r114.addListener(new nz4.j(null, r100, r112));
        r114.start();
        return;
    L13:
        r103 = null;
        goto L15
    L24:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static final void b(PadCatalogController r100) {
        CatalogMode r101 = r100.f218232d.getCatalogMode();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == CatalogMode.DIALOG) goto L17;
        String r102 = r101.getModeName();
        Boolean r103 = r100.f218232d.isCatalogOpenLiveData().getValue();
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        JSONObject r105 = new JSONObject();
        r105.put2("mode", r102);
        r105.put2("isShowing", Boolean.valueOf(r104));
        vv4.k r106 = r100.f218233e.getWeb();
        if (r106 == null) goto L16;
        r106.j("lark.biz.catalog.changeDisplayMode", r105);
        return;
    L16:
        return;
    L10:
        r104 = false;
        goto L11
    }

    public static final void c(final PadCatalogController r110) {
        if (r110.f218232d.getCatalogMode() != null) goto L5;
        return;
    L5:
        if (r110.f218232d.getCatalogMode() != CatalogMode.DIALOG) goto L7;
        return;
    L7:
        if (r110.f218232d.isCatalogOpen() == false) goto L41;
        final ViewGroup r100 = (ViewGroup) r110.f218230b.getValue();
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.indexOfChild(r110.f218234f) == (-1)) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == true) goto L42;
        r100.setBackgroundResource(R.drawable.doc_list_item_bg);
        int r102 = u0c.a.a(r110.d(r110.f218232d.getCatalogMode()));
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        ViewGroup r104 = (ViewGroup) r110.f218231c.getValue();
        if (r104 == null) goto L20;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L22:
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        int r106 = GravityCompat.START;
    L25:
        r103.gravity = r106;
        r103.width = r102;
        ViewGroup r107 = (ViewGroup) r110.f218231c.getValue();
        if (r107 == null) goto L28;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L30:
        if ((r108 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        r100.setVisibility(0);
        r100.addView(r110.f218234f, r103);
        WeakHashMap<View, Animator> r109 = k.f521405a;
        Function0<Unit> r111 = new PadCatalogController$show$1$1(r100, r110);
        Intrinsics.checkNotNullParameter(r100, "view");
        WeakHashMap<View, Animator> r112 = k.f521405a;
        Animator r113 = r112.remove(r100);
        if (r113 == null) goto L34;
        r113.cancel();
    L34:
        r100.setVisibility(0);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{RangesKt.coerceAtLeast(r100.getWidth(), 0), r102});
        r114.setDuration(300);
        r114.setStartDelay(0);
        r114.setInterpolator(new AccelerateDecelerateInterpolator());
        Ref.BooleanRef r115 = new Ref.BooleanRef();
        r114.addUpdateListener(new nz4.c(r100));
        r114.addListener(new nz4.d(r100, r115, r102, r111));
        r112.put(r100, r114);
        r114.start();
        return;
    L35:
        r100.setVisibility(4);
        r100.addView(r110.f218234f, r103);
        WeakHashMap<View, Animator> r116 = k.f521405a;
        Function0<Unit> r117 = new PadCatalogController$show$1$2(r110);
        int r118 = r100.getWidth();
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setTranslationX(-r100.getWidth());
        r100.setVisibility(0);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-r118, 0.0f});
        r119.setDuration(300);
        r119.setStartDelay(0);
        r119.setInterpolator(new AccelerateDecelerateInterpolator());
        r119.addListener(new nz4.i(null, r117));
        r119.start();
        return;
    L28:
        r108 = null;
        goto L30
    L24:
        r106 = 17;
        goto L25
    L20:
        r105 = null;
        goto L22
    L42:
        return;
    L14:
        r101 = false;
        goto L15
    }

    public final int d(CatalogMode r100) {
        int r101 = n.f521409a;
        View r102 = e();
        if (r102 == null) goto L5;
        int r103 = r102.getWidth();
        Resources r104 = Resources.getSystem();
        int r105 = (int) ((r103 / WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f);
    L6:
        if (r100 != null) goto L8;
        int r106 = -1;
    L10:
        if (r106 == 1) goto L16;
        if (r106 != 2) goto L22;
        return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME;
    L22:
        return 0;
    L16:
        if (r105 < 1240) goto L18;
        double r107 = 0.2361d;
    L20:
        return MathKt.roundToInt(r107 * ((double) r105));
    L18:
        r107 = 0.2d;
        goto L20
    L8:
        r106 = n.a.f521410a[r100.ordinal()];
        goto L10
    L5:
        r105 = 0;
        goto L6
    }
}
