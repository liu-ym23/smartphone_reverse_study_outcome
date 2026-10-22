package com.bytedance.creativex.mediaimport.preview.internal.main;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.creativex.mediaimport.repository.api.IMediaItem;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMaterialSelectionListView;
import com.larus.nova.R;
import com.larus.photopicker.impl.ui.PhotoPickerFragment;
import com.larus.photopicker.impl.ui.f1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.tools.view.base.BaseTransitionView;
import com.ss.android.ugc.tools.view.base.TransitionViewState;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m0 implements ei4.c<ki4.r> {
    public boolean A;
    public final CompositeDisposable B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f203523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f203524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fi4.d<ki4.r> f203525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f203526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ei4.b<ki4.r>> f203527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ei4.a> f203528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f203529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f203530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f203531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f203532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f203533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MediaType f203534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f203535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public hi4.c f203536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ii4.e f203537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ii4.d f203538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public yi4.g f203539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PublishSubject f203540r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PublishSubject f203541s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PublishSubject f203542t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PublishSubject f203543u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PublishSubject f203544v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PublishSubject f203545w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1<? super ki4.r, ? extends View> f203546x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ki4.a0 f203547y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f203548z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f203549a;

        public a() {
            this.f203549a = 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f203550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f203551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<? super Boolean, Unit> f203552c;

        public b(boolean r100, boolean r101, Function1<? super Boolean, Unit> r102) {
            this.f203550a = r100;
            this.f203551b = r101;
            this.f203552c = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<? super b1.c, Unit> f203553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<? super gi4.s.a, Unit> f203554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function1<? super gi4.a.C6027a, Unit> f203555c;

        public c(int r100) {
            this.f203553a = null;
            this.f203554b = null;
            this.f203555c = null;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f203556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f203557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f203558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f203559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f203560e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f203561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super gi4.r.a, Unit> f203562g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function1<? super BaseMaterialSelectionListView.a, Unit> f203563h;

        public d(int r100) {
            this.f203556a = true;
            this.f203557b = false;
            this.f203558c = false;
            this.f203559d = null;
            this.f203560e = 0;
            this.f203561f = null;
            this.f203562g = null;
            this.f203563h = null;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f203564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f203565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f203566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f203567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<Unit> f203568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f203569f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final d f203570g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final c f203571h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final a f203572i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f203573j;

        public e() {
            this(null);
        }

        public e(Object r100) {
            d r101 = new d(0);
            c r102 = new c(0);
            a r103 = new a();
            b r104 = new b(false, false, null);
            Intrinsics.checkNotNullParameter(r101, "selectorViewConfigure");
            Intrinsics.checkNotNullParameter(r102, "pagerViewConfigure");
            Intrinsics.checkNotNullParameter(r103, "contentViewConfigure");
            Intrinsics.checkNotNullParameter(r104, "originalImageConfigure");
            this.f203564a = true;
            this.f203565b = true;
            this.f203566c = false;
            this.f203567d = true;
            this.f203568e = null;
            this.f203569f = true;
            this.f203570g = r101;
            this.f203571h = r102;
            this.f203572i = r103;
            this.f203573j = r104;
        }
    }

    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f203574a = null;

        static {
            int[] r100 = new int[MediaType.values().length];
            r100[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f203574a = r100;
        }
    }

    @Override // ei4.c
    public final Observable<ei4.c.a<? extends ki4.r>> a() {
        return this.f203541s.hide();
    }

    public final void c() {
        FLogger.f375446a.d("effect_platform", "destroy PreviewView");
        fi4.d<ki4.r> r100 = this.f203525c;
        if (r100 == null) goto L7;
        fi4.c<ki4.r> r101 = r100.c();
        if (r101 == null) goto L7;
        r101.b(null, 0);
    L7:
        this.f203546x = null;
    }

    @Override // ei4.c
    public final void exit() {
        FLogger.f375446a.d("effect_platform", "exit PreviewView");
        d(new n(this));
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.creativex.mediaimport.preview.internal.main.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.creativex.mediaimport.preview.internal.main.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.creativex.mediaimport.preview.internal.main.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.bytedance.creativex.mediaimport.preview.internal.main.w] */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.bytedance.creativex.mediaimport.preview.internal.main.x] */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.bytedance.creativex.mediaimport.preview.internal.main.v] */
    @Override // ei4.c
    public final boolean b(ei4.d<ki4.r> r210) {
        Intrinsics.checkNotNullParameter(r210, "param");
        ki4.r r100 = r210.f472780a;
        Intrinsics.checkNotNullParameter(r100, "materialItem");
        if ((r100 instanceof IMediaItem) == false) goto L5;
        IMediaItem r101 = (IMediaItem) r100;
    L7:
        if (r101 == null) goto L9;
        boolean r102 = ri4.b.a(r101.getPath(), r101.getUri());
    L11:
        if (r102 == true) goto L13;
        this.f203542t.onNext(r100);
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
        return false;
    L16:
        List<ei4.b<ki4.r>> r104 = this.f203527e;
        if ((r104 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L25;
        ((ei4.b) r105.next()).a(r100);
    L25:
        this.f203541s.onNext(new ei4.c.a.e(r100, r210.f472781b, r210.f472782c, r210.f472783d));
        List<ki4.r> r106 = r210.f472781b;
        int r107 = r210.f472782c;
        this.f203547y = r210.f472784e;
        this.f203546x = r210.f472785f;
        this.f203548z = true;
        this.A = true;
        if (this.C == true) goto L104;
        this.C = true;
        ViewGroup r108 = this.f203523a;
        Intrinsics.checkNotNullParameter(r108, RootDescription.ROOT_ELEMENT);
        View r109 = LayoutInflater.from(r108.getContext()).inflate(R.layout.larus_tools_media_import_preview_root_view, r108, false);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup r110 = (ViewGroup) r109;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f203529g = r110;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r110 = null;
    L32:
        Intrinsics.checkNotNullParameter(r110, "content");
        final ViewGroup r111 = this.f203523a;
        final ?? r112 = new z();
        final ?? r113 = new a0(this);
        Intrinsics.checkNotNullParameter(r111, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "transitionProvider");
        Intrinsics.checkNotNullParameter(r113, "onHideEnd");
        k r114 = new k(r111, r110, new BaseTransitionView(r110, r110, new l(r112, r111, r110, r113)));
        Observable<TransitionViewState> r115 = r114.b();
        Consumer<? super TransitionViewState> r116 = new i0(this);
        com.ss.android.ugc.tools.utils.h.a r117 = com.ss.android.ugc.tools.utils.h.a.f454861a;
        Disposable r118 = r115.subscribe(r116, r117);
        this.B.add(r118);
        this.f203535m = r114;
        LifecycleOwner r119 = this.f203524b;
        final ViewGroup r120 = this.f203529g;
        if (r120 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r120 = null;
    L36:
        final ?? r121 = new j0(this);
        Intrinsics.checkNotNullParameter(r119, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r120, "content");
        Intrinsics.checkNotNullParameter(r121, "pageViewConfigure");
        ViewPager r122 = (ViewPager) r120.findViewById(R.id.preview_view_pager);
        Intrinsics.checkNotNull(r122);
        Intrinsics.checkNotNullParameter(r120, "content");
        Intrinsics.checkNotNullParameter(r121, "pageViewConfigure");
        hi4.c r123 = new hi4.c(r122, new w(this, r120, r121));
        Disposable r124 = r123.f203425d.hide().subscribe(new k0(this), r117);
        this.B.add(r124);
        Disposable r125 = ((ti4.b0) r123.f203825b.getValue()).a().subscribe(new l0(this), r117);
        this.B.add(r125);
        Disposable r126 = r123.f203426e.hide().subscribe(new o(this), r117);
        this.B.add(r126);
        this.f203536n = r123;
        if (this.f203526d.f203564a == false) goto L79;
        Intrinsics.checkNotNullParameter(r119, NewBroadcastMonitor.STAGE.LIFECYCLE);
        fi4.d<ki4.r> r127 = this.f203525c;
        if (r127 == null) goto L41;
        ti4.m<ki4.r> r128 = r127.b();
    L42:
        fi4.d<ki4.r> r129 = this.f203525c;
        if (r129 == null) goto L45;
        fi4.c<ki4.r> r130 = r129.c();
    L46:
        final yi4.g r131 = new yi4.g(r119, r128, r130, new x());
        LifecycleOwner r132 = r131.f567919a;
        ti4.m<DATA> r133 = r131.f567920b;
        if (r133 == 0) goto L49;
        r133.getSelectedMaterials().observe(r132, new yi4.e(r131));
    L49:
        ti4.t r134 = r131.f567921c;
        if (r134 == null) goto L52;
        r134.a().observe(r132, new yi4.f(r131));
    L52:
        this.f203539q = r131;
        Intrinsics.checkNotNullParameter(r119, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r120, "content");
        d r135 = this.f203526d.f203570g;
        ViewGroup r136 = (ViewGroup) r120.findViewById(R.id.selector_view_content);
        fi4.d<ki4.r> r137 = this.f203525c;
        if (r137 == null) goto L55;
        ti4.m<ki4.r> r138 = r137.b();
    L56:
        fi4.d<ki4.r> r139 = this.f203525c;
        if (r139 == null) goto L59;
        fi4.c<ki4.r> r140 = r139.c();
    L60:
        boolean r141 = r135.f203556a;
        Boolean r142 = r135.f203559d;
        if (r142 == null) goto L63;
        Intrinsics.checkNotNull(r142);
        boolean r143 = r142.booleanValue();
    L64:
        String r144 = r135.f203561f;
        if (r144 != null) goto L71;
        Resources r145 = this.f203523a.getContext().getResources();
        int r146 = r135.f203560e;
        if (r146 != 0) goto L70;
        r146 = R.string.larus_album_next_btn;
    L70:
        String r211 = r145.getString(r146);
    L72:
        ti4.m<ki4.r> r147 = r138;
        ii4.e r148 = new ii4.e(r136, r119, r147, r131, r140, r141, r143, r211, new q(r135, this));
        r148.c();
        Disposable r149 = r148.f203864g.hide().subscribe(new f0(this), r117);
        this.B.add(r149);
        this.f203537o = r148;
        if (this.f203526d.f203565b == false) goto L79;
        yi4.g r150 = this.f203539q;
        Intrinsics.checkNotNullParameter(r119, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r120, "content");
        Context r151 = r120.getContext();
        fi4.d<ki4.r> r152 = this.f203525c;
        if (r152 == null) goto L77;
        ti4.m<ki4.r> r153 = r152.b();
    L78:
        ii4.d r154 = new ii4.d(r151, r119, r153, r150, (ViewGroup) r120.findViewById(R.id.selection_list_view_container), new v(this));
        r154.k();
        Disposable r155 = r154.f203690p.hide().subscribe(new g0(this), r117);
        this.B.add(r155);
        Disposable r156 = r154.f203691q.hide().subscribe(new h0(this), r117);
        this.B.add(r156);
        this.f203538p = r154;
        goto L79
    L77:
        r153 = null;
        goto L78
    L71:
        r211 = r144;
        goto L72
    L63:
        r143 = r141;
        goto L64
    L59:
        r140 = null;
        goto L60
    L55:
        r138 = null;
        goto L56
    L45:
        r130 = null;
        goto L46
    L41:
        r128 = null;
    L79:
        Intrinsics.checkNotNullParameter(r120, "content");
        View r157 = r120.findViewById(R.id.btn_back);
        r157.setOnClickListener(new p(this));
        this.f203530h = r157;
        Intrinsics.checkNotNullParameter(r120, "content");
        ImageView r158 = (ImageView) r120.findViewById(R.id.btn_back);
        if (r158 == null) goto L84;
        int r159 = this.f203526d.f203572i.f203549a;
        if (r159 == 0) goto L84;
        r158.setImageResource(r159);
    L84:
        final b r160 = this.f203526d.f203573j;
        if (r160.f203550a == false) goto L104;
        ViewGroup r161 = this.f203529g;
        if (r161 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r161 = null;
    L90:
        Intrinsics.checkNotNullParameter(r161, "content");
        this.f203531i = (ViewGroup) r161.findViewById(R.id.container_original_image);
        ViewGroup r162 = this.f203529g;
        if (r162 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        r162 = null;
    L94:
        Intrinsics.checkNotNullParameter(r162, "content");
        this.f203532j = (ImageView) r162.findViewById(R.id.checkbox_original_image);
        ViewGroup r163 = this.f203531i;
        if (r163 == null) goto L97;
        ci4.a.a(r163, true);
    L97:
        boolean r164 = r160.f203551b;
        this.f203533k = r164;
        View r165 = this.f203532j;
        if (r165 == null) goto L100;
        r165.setSelected(r164);
    L100:
        ViewGroup r166 = this.f203531i;
        if (r166 == null) goto L104;
        r166.setOnClickListener(new e0(this, r160));
    L104:
        if (this.f203526d.f203566c == false) goto L109;
        k r167 = this.f203535m;
        if (r167 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("transitionView");
        r167 = null;
    L108:
        r167.show();
    L113:
        hi4.c r168 = this.f203536n;
        if (r168 == null) goto L131;
        List<ki4.r> r169 = r106;
        ArrayList r170 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r169, 10));
        Iterator<T> r171 = r169.iterator();
    L117:
        if (r171.hasNext() == false) goto L119;
        r170.add(new ti4.s((ki4.r) r171.next(), ""));
        goto L117
    L119:
        Intrinsics.checkNotNullParameter(r170, "pages");
        ((ArrayList) r168.f203424c).clear();
        ((ArrayList) r168.f203424c).addAll(r170);
        ((fi4.b) r168.f203427f.getValue()).e(r168.f203424c);
        if (r168.f203824a.getAdapter() == null) goto L122;
        r168.f203824a.setAdapter(null);
    L122:
        r168.f203824a.setAdapter(r168.b());
        if (r107 <= 0) goto L125;
        r168.f203824a.setCurrentItem(r107);
        return true;
    L125:
        if (r107 != 0) goto L133;
        r168.f203428g.onPageSelected(0);
        return true;
    L133:
        return true;
    L131:
        return true;
    L109:
        k r172 = this.f203535m;
        if (r172 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("transitionView");
        r172 = null;
    L112:
        r172.c();
        goto L113
    L19:
        if (r104.isEmpty() == false) goto L21;
    L13:
        r103 = true;
        goto L14
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public final void d(Function0<Unit> r100) {
        FLogger.f375446a.d("effect_platform", "tryExit PreviewView exitActionSize=" + ((ArrayList) this.f203528f).size());
        List<ei4.a> r101 = this.f203528f;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = ((ArrayList) r101).iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        ei4.a r103 = (ei4.a) r102.next();
        boolean r104 = r103.d(new y(r100));
        FLogger.f375446a.d("effect_platform", "tryExit PreviewView reuslt=" + r104 + " class=" + r103.getClass().getSimpleName());
        if (r104 == false) goto L9;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        return;
    L16:
        r100.invoke();
        return;
    L13:
        r105 = false;
        goto L14
    L5:
        if (((ArrayList) r101).isEmpty() == false) goto L7;
        goto L7
    }

    public final void e(ki4.r r100) {
        fi4.d<ki4.r> r101 = this.f203525c;
        if (r101 == null) goto L25;
        ki4.a0 r102 = this.f203547y;
        boolean r103 = false;
        if (r102 != null) goto L9;
        hi4.c r104 = this.f203536n;
        if (r104 == null) goto L23;
        r103 = r104.c(r100);
    L23:
        if (r103 == true) goto L31;
        this.f203541s.onNext(new ei4.c.a.g(r100, r102));
        return;
    L31:
        return;
    L9:
        ti4.r<ki4.r> r105 = r101.a(r102);
        if (r105 == null) goto L23;
        Integer r106 = Integer.valueOf(r105.getDataPosition(r100));
        if (r106.intValue() < 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L18;
        r106 = null;
    L18:
        if (r106 == null) goto L23;
        int r108 = r106.intValue();
        hi4.c r109 = this.f203536n;
        if (r109 == null) goto L22;
        r109.d(r108, false);
    L22:
        r103 = true;
        goto L23
    L14:
        r107 = false;
        goto L15
    L25:
        hi4.c r110 = this.f203536n;
        if (r110 != null) goto L28;
        return;
    L28:
        if (r110.c(r100) == true) goto L34;
        this.f203541s.onNext(new ei4.c.a.g(r100, this.f203547y));
        return;
    }

    public m0(ViewGroup r100, PhotoPickerFragment r101, ji4.c r102, f1 r103) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f203523a = r100;
        this.f203524b = r101;
        this.f203525c = r102;
        e r104 = new e(null);
        this.f203526d = r104;
        this.f203527e = CollectionsKt.mutableListOf(new ei4.b[]{com.bytedance.creativex.mediaimport.view.internal.validator.f.f204101a});
        this.f203528f = new ArrayList();
        this.f203540r = PublishSubject.create();
        this.f203541s = PublishSubject.create();
        this.f203542t = PublishSubject.create();
        this.f203543u = PublishSubject.create();
        this.f203544v = PublishSubject.create();
        this.f203545w = PublishSubject.create();
        this.f203548z = true;
        this.B = new CompositeDisposable();
        r103.invoke(r104);
    }
}
