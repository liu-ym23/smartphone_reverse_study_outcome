package com.bytedance.locallife.dito.common.plugin;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.baseview.DitoStickLayout;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/dito/common/plugin/DitoTopShadowPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "Lfq6/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoTopShadowPlugin extends AbsDitoLifeCyclePlugin implements fq6.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f257503k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f257504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f257505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Stack<Pair<String, Boolean>> f257506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f257507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Pair<String, Boolean>> f257508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f257509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f257510j;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoTopShadowPlugin f257511a;

        public b(DitoTopShadowPlugin r100) {
            this.f257511a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DitoDataCenter.g r101 = (DitoDataCenter.g) r100;
            if (r101 == null) goto L30;
            String r102 = r101.f258020d;
            com.bytedance.locallife.dito.data.m r103 = this.f257511a.g().i(r102);
            if (r103 == null) goto L16;
            DitoNode r104 = r103.f258221a;
            if (r104 == null) goto L16;
            com.bytedance.locallife.dito.data.d r105 = r104.getData();
            if (r105 == null) goto L16;
            JsonObject r106 = r105.f258198a;
            if (r106 == null) goto L16;
            JsonElement r107 = r106.get("stick_need_shadow");
            if (r107 == null) goto L16;
            boolean r108 = r107.getAsBoolean();
        L18:
            if (r101.f258019c != true) goto L20;
            this.f257511a.f257506f.push(new Pair(r102, Boolean.valueOf(r108)));
        L28:
            this.f257511a.t();
            return;
        L20:
            Stack<Pair<String, Boolean>> r109 = this.f257511a.f257506f;
            if ((!r109.empty()) == true) goto L24;
            r109 = null;
        L24:
            if (r109 == null) goto L28;
            if (Intrinsics.areEqual(r109.peek().getFirst(), r102) == false) goto L28;
            r109.pop();
        L16:
            r108 = false;
            goto L18
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoTopShadowPlugin f257512a;

        public c(DitoTopShadowPlugin r100) {
            this.f257512a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DitoDataCenter.i r101 = (DitoDataCenter.i) r100;
            if (r101.f258024b != true) goto L15;
            Stack<Pair<String, Boolean>> r102 = this.f257512a.f257506f;
            if ((true ^ r102.empty()) == true) goto L8;
            r102 = null;
        L8:
            if (r102 == null) goto L17;
            DitoTopShadowPlugin r103 = this.f257512a;
            Pair<String, Boolean> r104 = r102.peek();
            if (Intrinsics.areEqual(r104.getFirst(), r101.f258025c) == false) goto L17;
            if (r103.f257508h.containsKey(r104.getFirst()) == true) goto L17;
            r103.f257508h.put(r104.getFirst(), r102.pop());
        L17:
            DitoTopShadowPlugin r105 = this.f257512a;
            r105.f257507g.post(new k(r105));
            return;
        L15:
            if (this.f257512a.f257508h.containsKey(r101.f258025c) == false) goto L17;
            DitoTopShadowPlugin r106 = this.f257512a;
            r106.f257506f.push(r106.f257508h.remove(r101.f258025c));
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.core.AbsDitoPlugin, com.bytedance.locallife.dito.core.d0
    public final String getName() {
        return "dito_top_shadow_plugin";
    }

    public final void t() {
        if (this.f257506f.empty() == true) goto L8;
        Pair<String, Boolean> r100 = this.f257506f.peek();
        if (r100 == null) goto L8;
        boolean r101 = r100.getSecond().booleanValue();
    L9:
        View r102 = null;
        if (r101 == false) goto L18;
        DitoFragment r103 = f();
        if (r103 == null) goto L16;
        DitoStickLayout r104 = r103.Aa0();
        if (r104 == null) goto L16;
        r102 = (View) CollectionsKt.lastOrNull(com.bytedance.locallife.dito.utils.n.e(r104));
    L16:
        s(r102, 1.0f);
        return;
    L18:
        if (this.f257506f.empty() == true) goto L20;
    L27:
        DitoFragment r105 = f();
        if (r105 == null) goto L40;
        FrameLayout r106 = r105.ra0();
        if (r106 != null) goto L32;
        return;
    L32:
        if ((r106.getBackground() instanceof op6.a) == true) goto L35;
        r106 = null;
    L35:
        if (r106 == null) goto L42;
        r106.setBackground(null);
        return;
    L42:
        return;
    L40:
        return;
    L20:
        if (this.f257504d == false) goto L27;
        if (this.f257505e <= 0.0f) goto L27;
        DitoFragment r107 = f();
        if (r107 == null) goto L26;
        r102 = r107.wa0();
    L26:
        s(r102, this.f257505e);
        return;
    L8:
        r101 = false;
        goto L9
    }

    public DitoTopShadowPlugin() {
        this.f257506f = new Stack();
        this.f257507g = new Handler(Looper.getMainLooper());
        this.f257508h = new LinkedHashMap();
        this.f257509i = LazyKt.lazy(new DitoTopShadowPlugin$headShadowData$2(this));
        this.f257510j = LazyKt.lazy(new DitoTopShadowPlugin$stickContainerLayoutListener$2(this));
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public final void h() {
        super.h();
        DitoFragment r100 = f();
        if (r100 == null) goto L6;
        e().C0().observe(r100, new b(this));
        e().D0().observe(r100, new c(this));
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void n(com.bytedance.locallife.dito.data.t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        g().f258043i.c("add_shadow_below_head", this);
        g().f258043i.c("nav_bar_alpha_change", this);
        DitoFragment r101 = f();
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        DitoStickLayout r102 = r101.Aa0();
        if (r102 == null) goto L9;
        r102.removeOnLayoutChangeListener((View.OnLayoutChangeListener) this.f257510j.getValue());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void o(com.bytedance.locallife.dito.data.t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        g().f258043i.a("add_shadow_below_head", this);
        g().f258043i.a("nav_bar_alpha_change", this);
        DitoFragment r101 = f();
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        DitoStickLayout r102 = r101.Aa0();
        if (r102 == null) goto L9;
        r102.addOnLayoutChangeListener((View.OnLayoutChangeListener) this.f257510j.getValue());
        return;
    L9:
        return;
    }

    public final void s(View r100, float r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = com.bytedance.locallife.dito.utils.n.f258708a;
        Integer r102 = com.bytedance.locallife.dito.utils.n.i(r100);
        if (r102 == null) goto L18;
        int r103 = r102.intValue();
        DitoFragment r104 = f();
        if (r104 == null) goto L19;
        FrameLayout r105 = r104.ra0();
        if (r105 == null) goto L20;
        com.bytedance.locallife.dito.common.data.d r106 = (com.bytedance.locallife.dito.common.data.d) this.f257509i.getValue();
        if (r106 != null) goto L13;
        return;
    L13:
        if (r110 >= 1.0f) goto L15;
        int r107 = r106.f257338a;
        int r108 = aq6.d.f15903a;
        int r111 = Color.argb((int) (Color.alpha(r107) * r110), Color.red(r107), Color.green(r107), Color.blue(r107));
    L16:
        r105.setBackground(new op6.a(r111, r106.f257339b, r106.f257340c, r106.f257341d, r103));
        r105.setLayerType(1, null);
        return;
    L15:
        r111 = r106.f257338a;
        goto L16
    L20:
        return;
    L19:
        return;
    }

    @Override // fq6.a
    public final boolean u(DitoViewModel r100, com.bytedance.locallife.dito.provider.a r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "ditoAction");
        String r102 = r101.f258661a.getType();
        if (Intrinsics.areEqual(r102, "add_shadow_below_head") == false) goto L6;
        this.f257504d = true;
        return true;
    L6:
        if (Intrinsics.areEqual(r102, "nav_bar_alpha_change") == false) goto L17;
        Map<String, Object> r103 = r101.f258661a.getParams();
        Number r104 = null;
        if (r103 == null) goto L10;
        Object r105 = r103.get("alpha");
    L12:
        if ((r105 instanceof Number) == false) goto L14;
        r104 = (Number) r105;
    L14:
        if (r104 != null) goto L16;
        r104 = 0;
    L16:
        this.f257505e = r104.floatValue();
        t();
        return true;
    L10:
        r105 = null;
        goto L12
    L17:
        return false;
    }
}
