package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.common.lynx.AbsDitoBaseLynxView;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.data.DitoActionModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.data.l;
import com.bytedance.locallife.dito.data.n;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.data.u;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.interact.AbstractInteractBehavior;
import com.bytedance.locallife.dito.interact.CustomBottomBehavior;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.poi.experiment.PoiScrollFixExperiment;
import com.bytedance.locallife.poi.poidetail.container.mob.j;
import com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.bean.AutoScrollConfig;
import com.ss.android.ugc.aweme.poi.event.PoiChangePageStateEvent;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiBusinessAutoScrollPlugin;", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", "Lcom/ss/android/ugc/aweme/poi/event/PoiChangePageStateEvent;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiBusinessAutoScrollPlugin extends PoiDetailBizContainerPlugin {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f263890r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f263891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<String, Integer>> f263892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f263893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f263894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f263895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f263896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f263897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f263898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f263899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f263900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f263901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f263902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f263903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f263904q;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263905a;

        public b(PoiBusinessAutoScrollPlugin r100) {
            this.f263905a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            u r101 = (u) r100;
            PoiBusinessAutoScrollPlugin r102 = this.f263905a;
            if (r102.f263891d == false) goto L5;
            return;
        L5:
            if (r101.f258256b == 0) goto L9;
            r102.f263891d = true;
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263906a;

        public c(PoiBusinessAutoScrollPlugin r100) {
            this.f263906a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == true) goto L6;
            PoiBusinessAutoScrollPlugin.B(this.f263906a);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263907a;

        public d(PoiBusinessAutoScrollPlugin r100) {
            this.f263907a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == true) goto L6;
            PoiBusinessAutoScrollPlugin.B(this.f263907a);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263908a;

        public e(PoiBusinessAutoScrollPlugin r100) {
            this.f263908a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == true) goto L6;
            PoiBusinessAutoScrollPlugin.B(this.f263908a);
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263909a;

        public f(PoiBusinessAutoScrollPlugin r100) {
            this.f263909a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            n r101 = (n) r100;
            PoiBusinessAutoScrollPlugin.B(this.f263909a);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263910a;

        public g(PoiBusinessAutoScrollPlugin r100) {
            this.f263910a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r9v9, types: [java.util.ArrayList] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            if (((v) r210).f258263a == true) goto L122;
            PoiBusinessAutoScrollPlugin r100 = this.f263910a;
            if (r100.f263904q == true) goto L137;
            r100.f263904q = true;
            DitoPageInfo r101 = r100.g().f258040f;
            CustomBottomBehavior r102 = null;
            if (r101 == null) goto L12;
            Map<String, Object> r103 = r101.getData();
            if (r103 == null) goto L12;
            Object r104 = r103.get("ab_map");
        L14:
            if ((r104 instanceof Map) == false) goto L16;
            Map r105 = (Map) r104;
        L17:
            boolean r106 = false;
            if (r105 == null) goto L24;
            Object r107 = r105.get("poi_detail_update_video");
            if (r107 == null) goto L24;
            Integer r108 = com.bytedance.locallife.groupon.utils.b.a(r107);
            if (r108 == null) goto L24;
            int r109 = r108.intValue();
        L25:
            if (r101 == null) goto L29;
            Map<String, Object> r110 = r101.getData();
            if (r110 == null) goto L29;
            Object r111 = r110.get("need_anchor_interaction");
        L31:
            if ((r111 instanceof Boolean) == false) goto L33;
            Boolean r112 = (Boolean) r111;
        L34:
            if (r112 == null) goto L36;
            boolean r113 = r112.booleanValue();
        L37:
            if (r101 == null) goto L41;
            Map<String, Object> r114 = r101.getData();
            if (r114 == null) goto L41;
            Object r115 = r114.get("not_need_anchor_in_full_screen");
        L43:
            if ((r115 instanceof Boolean) == false) goto L45;
            Boolean r116 = (Boolean) r115;
        L46:
            if (r116 == null) goto L48;
            r106 = r116.booleanValue();
        L48:
            r100.f263900m = r106;
            if (r101 == null) goto L53;
            Map<String, Object> r117 = r101.getData();
            if (r117 == null) goto L53;
            Object r118 = r117.get("default_anchor_node_tags");
        L55:
            if ((r118 instanceof String) == false) goto L57;
            String r119 = (String) r118;
        L59:
            if (r119 == null) goto L68;
            List r120 = StringsKt.split$default(r119, new String[]{",", HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
            if (r120 == null) goto L68;
            ?? r121 = new ArrayList();
            Iterator<T> r122 = r120.iterator();
        L64:
            if (r122.hasNext() == false) goto L69;
            T r123 = r122.next();
            if ((!StringsKt.isBlank((String) r123)) == false) goto L64;
            r121.add(r123);
        L69:
            r100.f263901n = r121;
            if (r101 == null) goto L74;
            Map<String, Object> r124 = r101.getData();
            if (r124 == null) goto L74;
            Object r125 = r124.get("elevator_node_tags");
        L76:
            if ((r125 instanceof String) == false) goto L78;
            String r126 = (String) r125;
        L79:
            if (r126 == null) goto L88;
            List r127 = StringsKt.split$default(r126, new String[]{",", HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
            if (r127 == null) goto L88;
            ArrayList r128 = new ArrayList();
            Iterator<T> r129 = r127.iterator();
        L84:
            if (r129.hasNext() == false) goto L89;
            T r130 = r129.next();
            if ((!StringsKt.isBlank((String) r130)) == false) goto L84;
            r128.add(r130);
        L89:
            r100.f263902o = r128;
            if (r101 == null) goto L94;
            Map<String, Object> r131 = r101.getData();
            if (r131 == null) goto L94;
            Object r132 = r131.get("elevator_node_height");
        L96:
            if ((r132 instanceof Number) == false) goto L98;
            Number r133 = (Number) r132;
        L99:
            if (r133 == null) goto L101;
            Integer r134 = Integer.valueOf(r133.intValue());
        L102:
            r100.f263903p = r134;
            if (r109 <= 0) goto L133;
            if (r113 == false) goto L134;
            DitoFragment r135 = r100.f();
            if (r135 == null) goto L118;
            Context r136 = r135.getContext();
            if (r136 == null) goto L118;
            DitoFragment r137 = r100.f();
            if (r137 == null) goto L112;
            AbstractInteractBehavior<? extends View> r138 = r137.Da0();
        L114:
            if ((r138 instanceof CustomBottomBehavior) == false) goto L116;
            r102 = (CustomBottomBehavior) r138;
        L116:
            if (r102 == null) goto L118;
            r102.f258392k = r136.getResources().getDimensionPixelSize(R.dimen.uikit_default_title_bar_height) + UIUtils.getStatusBarHeight(r136);
            goto L118
        L112:
            r138 = null;
        L118:
            r100.e().S().observeForever(new com.bytedance.locallife.poi.poidetail.container.plugin.business.d(r100));
            Integer r139 = r100.e().W().getValue();
            if (r139 == null) goto L135;
            r100.e().W().setValue(r139);
            return;
        L135:
            return;
        L134:
            return;
        L133:
            return;
        L101:
            r134 = null;
            goto L102
        L98:
            r133 = null;
        L94:
            r132 = null;
        L88:
            r128 = null;
            goto L89
        L78:
            r126 = null;
        L74:
            r125 = null;
        L68:
            r121 = CollectionsKt.listOf(new String[]{"poi_shelf_container_turbo", "poi_star_shelf_card", "poi_star_shelf_card_normal"});
            goto L69
        L57:
            r119 = null;
        L53:
            r118 = null;
            goto L55
        L45:
            r116 = null;
        L41:
            r115 = null;
            goto L43
        L36:
            r113 = false;
            goto L37
        L33:
            r112 = null;
        L29:
            r111 = null;
        L24:
            r109 = 0;
            goto L25
        L16:
            r105 = null;
        L12:
            r104 = null;
            goto L14
        L137:
            return;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiBusinessAutoScrollPlugin f263911a;

        public h(PoiBusinessAutoScrollPlugin r100) {
            this.f263911a = r100;
        }

        public final void a() {
            Integer r100 = this.f263911a.e().S().getValue();
            if (r100 != null) goto L6;
        L7:
            Integer r101 = this.f263911a.e().S().getValue();
            if (r101 != null) goto L11;
            return;
        L11:
            if (r101.intValue() != 7) goto L20;
        L12:
            this.f263911a.e().L0().setValue("full");
            if (Intrinsics.areEqual(IPoiSetting.a().g(), Boolean.TRUE) == false) goto L21;
            DitoFragment r102 = this.f263911a.f();
            if (r102 == null) goto L22;
            RecyclerView r103 = r102.f257790l;
            if (r103 == null) goto L23;
            r103.setBackgroundColor(com.bytedance.locallife.poi.dito.util.a.a("#00000000"));
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L6:
            if (r100.intValue() == 6) goto L12;
            goto L7
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

    static {
    }

    public PoiBusinessAutoScrollPlugin() {
        this.f263892e = new ArrayList();
        this.f263898k = 300;
        this.f263901n = CollectionsKt.emptyList();
    }

    public final void E() {
        DitoFragment r100 = f();
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = r100.getView();
        if (r101 == null) goto L12;
        h r102 = new h(this);
        Long r103 = IPoiSetting.a().l();
        if (r103 != null) goto L10;
        r103 = 0L;
    L10:
        r101.postDelayed(r102, r103.longValue());
        return;
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin, com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public final void h() {
        super.h();
        vn6.b.b(this);
        if (((Number) PoiScrollFixExperiment.f262566a.getValue()).intValue() != 1) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        e().X0().observeForever(new c(this));
    L9:
        e().x().observeForever(new g(this));
        DitoFragment r101 = f();
        if (r101 == null) goto L32;
        Context r102 = r101.getContext();
        if (r102 == null) goto L33;
        AutoScrollConfig r103 = IPoiSetting.a().a();
        int r104 = aq6.h.a(r102);
        if (r104 != 1) goto L16;
        if (r103 == null) goto L29;
        long r105 = r103.b();
    L30:
        this.f263898k = r105;
        return;
    L29:
        r105 = 500;
        goto L30
    L16:
        if (r104 != 2) goto L18;
        if (r103 == null) goto L26;
        r105 = r103.d();
    L26:
        r105 = 700;
        goto L30
    L18:
        if (r104 == 3) goto L21;
        if (r103 == null) goto L26;
        r105 = r103.a();
        goto L30
    L21:
        if (r103 == null) goto L23;
        r105 = r103.c();
        goto L30
    L23:
        r105 = 900;
        goto L30
    L33:
        return;
    L32:
        return;
    L8:
        e().x().observeForever(new d(this));
        e().y().observeForever(new e(this));
        e().I().observeForever(new f(this));
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [T, com.bytedance.locallife.poi.poidetail.container.plugin.business.b] */
    public static final void B(PoiBusinessAutoScrollPlugin r210) {
        if ((!((ArrayList) r210.f263892e).isEmpty()) == true) goto L5;
        return;
    L5:
        if (r210.f263891d == true) goto L92;
        CopyOnWriteArrayList r100 = (CopyOnWriteArrayList) ((LinkedHashMap) r210.g().f258051q).get(ContainerPosition.BODY);
        if (r100 == null) goto L62;
        int r110 = r100.size();
        boolean r101 = false;
        int r111 = 0;
    L9:
        if (r111 >= r110) goto L61;
        int r102 = ((ArrayList) r210.f263892e).size();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L58;
        if (((Number) ((Pair) ListProtector.get(r210.f263892e, r103)).getSecond()).intValue() != 1) goto L17;
        if (Intrinsics.areEqual(((BaseDitoModel) r100.get(r111)).f258493b.f258222b, ((Pair) ListProtector.get(r210.f263892e, r103)).getFirst()) == false) goto L17;
    L25:
        if (r210.f263897j == false) goto L27;
    L30:
        BaseDitoModel r112 = (BaseDitoModel) r100.get(r111);
        PoiBundle r104 = r210.v();
        if (r104 == null) goto L34;
        String r105 = r104.enterMethod;
        if (r105 == null) goto L34;
    L38:
        com.bytedance.locallife.poi.poidetail.container.mob.f r106 = new com.bytedance.locallife.poi.poidetail.container.mob.f(r105, ((BaseDitoModel) r100.get(r111)).f258493b.f258222b, r210.f263893f);
        DitoFragment r113 = r210.f();
        if (r113 == null) goto L55;
        AbstractInteractBehavior<? extends View> r107 = r113.Da0();
        PoiBundle r108 = r210.v();
        if (r108 == null) goto L44;
        Integer r109 = r108.retryTimesAfterTargetFound;
    L45:
        if (r109 != null) goto L47;
        int r114 = IPoiSetting.a().s();
    L48:
        int r115 = r114;
        DitoFragment r116 = r210.f();
        if (r116 == null) goto L52;
        Ref.BooleanRef r117 = new Ref.BooleanRef();
        Ref.BooleanRef r118 = new Ref.BooleanRef();
        Ref.ObjectRef r119 = new Ref.ObjectRef();
        r119.element = new com.bytedance.locallife.poi.poidetail.container.plugin.business.b(r119, r118, r117, r210, r116, r106);
        r210.e().Z().observe(r116, (Observer) r119.element);
    L52:
        View r120 = r113.getView();
        if (r120 == null) goto L55;
        r120.postDelayed(new com.bytedance.locallife.poi.poidetail.container.plugin.business.c(r107, r210, r112, r115), r210.f263898k);
        goto L55
    L47:
        r114 = r109.intValue();
        goto L48
    L44:
        r109 = null;
    L55:
        r210.f263891d = true;
    L56:
        r101 = true;
    L34:
        PoiBundle r121 = r210.v();
        if (r121 == null) goto L37;
        r105 = r121.clickMethod;
        goto L38
    L37:
        r105 = null;
        goto L38
    L27:
        if (r210.f263895h == true) goto L30;
        r210.f263895h = true;
    L17:
        if (((Number) ((Pair) ListProtector.get(r210.f263892e, r103)).getSecond()).intValue() != 0) goto L57;
        DitoNode r122 = ((BaseDitoModel) r100.get(r111)).f258493b.f258221a;
        if (r122 == null) goto L21;
        String r123 = r122.getSubType();
    L23:
        if (Intrinsics.areEqual(r123, ((Pair) ListProtector.get(r210.f263892e, r103)).getFirst()) == false) goto L57;
    L21:
        r123 = null;
    L57:
        r103 = r103 + 1;
    L58:
        if (r101 == true) goto L61;
        r111 = r111 + 1;
    L61:
        boolean r124 = r101;
    L63:
        if (r124 == false) goto L65;
        return;
    L65:
        if (r210.f263897j == true) goto L67;
        return;
    L67:
        if (r210.f263896i == true) goto L95;
        r210.f263896i = true;
        PoiBundle r125 = r210.v();
        if (r125 == null) goto L72;
        String r126 = r125.enterMethod;
        if (r126 == null) goto L72;
    L76:
        PoiBundle r127 = r210.v();
        if (r127 == null) goto L79;
        String r128 = r127.scrollToComponent;
    L80:
        if (r128 != null) goto L82;
        r128 = "";
    L82:
        r210.D(new com.bytedance.locallife.poi.poidetail.container.mob.f(r126, r128, r210.f263893f), "fail", "target_not_found_after_chunk_end");
        return;
    L79:
        r128 = null;
    L72:
        PoiBundle r129 = r210.v();
        if (r129 == null) goto L75;
        r126 = r129.clickMethod;
        goto L76
    L75:
        r126 = null;
        goto L76
    L95:
        return;
    L62:
        r124 = false;
        goto L63
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        DitoFragment r101 = f();
        if (r101 != null) goto L5;
        return;
    L5:
        e().Y().observe(r101, new b(this));
        PoiBundle r102 = v();
        if (r102 == null) goto L19;
        String r103 = r102.scrollToComponent;
        if (r103 == null) goto L19;
        List r104 = StringsKt.split$default(r103, new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
        if (r104 == null) goto L19;
        Iterator r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        String r106 = (String) r105.next();
        List<Pair<String, Integer>> r107 = this.f263892e;
        if (Intrinsics.areEqual(r106, "city_page_feed_tab") == false) goto L17;
        Pair r108 = new Pair("dito_common_tag", 0);
    L18:
        ((ArrayList) r107).add(r108);
        goto L13
    L17:
        r108 = new Pair(r106, 1);
    L19:
        PoiBundle r109 = v();
        if (r109 == null) goto L24;
        String r110 = r109.scrollToSubview;
        if (r110 == null) goto L24;
        this.f263893f = r110;
    L24:
        PoiBundle r111 = v();
        if (r111 == null) goto L31;
        this.f263894g = r111.scrollOffset;
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void l(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        vn6.b.c(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiChangePageStateEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        throw null;
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin
    public final void x(l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        if (HostServiceUtilsKt.i().isLogin() == false) goto L6;
        this.f263897j = true;
        return;
    }

    public final void C(String r110, final Function0<Unit> r111) {
        DitoFragment r100 = f();
        if (r100 != null) goto L5;
        return;
    L5:
        AbstractInteractBehavior<? extends View> r101 = r100.Da0();
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) ((LinkedHashMap) g().f258051q).get(ContainerPosition.BODY);
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return;
    L14:
        List<String> r106 = this.f263902o;
        if (r106 != null) goto L18;
        r106 = CollectionsKt.listOf(new String[]{"poi_fix_elevator_v2", "shelf_fix_elevator"});
    L18:
        if ((r102 instanceof Collection) == true) goto L20;
    L22:
        Iterator r107 = r102.iterator();
    L24:
        if (r107.hasNext() == false) goto L28;
        if (r106.contains(((BaseDitoModel) r107.next()).f258493b.f258222b) == false) goto L24;
        boolean r108 = true;
    L29:
        Integer r109 = this.f263903p;
        if (r109 == null) goto L32;
        int r112 = r109.intValue();
    L33:
        if (r108 == true) goto L36;
        r112 = 0;
    L36:
        if (r112 <= 0) goto L38;
        boolean r113 = true;
    L39:
        if (r101 == null) goto L41;
        r101.e();
    L41:
        Pair[] r114 = new Pair[6];
        r114[0] = TuplesKt.to("nodeTag", r110);
        r114[1] = TuplesKt.to("speedMultiple", Float.valueOf(100.0f));
        r114[2] = TuplesKt.to(GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, Boolean.TRUE);
        r114[3] = TuplesKt.to("retryTimesAfterTargetFound", 3);
        if (r113 == true) goto L47;
        Dito r115 = Dito.f257280a;
        if (com.bytedance.locallife.dito.utils.l.k().getSkipInvalidTimeCheckWhenTargetFoundRetry() == true) goto L47;
        r103 = false;
    L47:
        r114[4] = TuplesKt.to("skipInvalidTimeCheckWhenTargetFoundRetry", Boolean.valueOf(r103));
        AbstractInteractBehavior<? extends View> r116 = r100.Da0();
        if ((r116 instanceof CustomBottomBehavior) == false) goto L50;
        CustomBottomBehavior r117 = (CustomBottomBehavior) r116;
    L51:
        if (r117 == null) goto L53;
        r104 = r117.f258392k;
    L53:
        r114[5] = TuplesKt.to("offsetY", Integer.valueOf((com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r104)) + 2) - r112));
        com.bytedance.locallife.dito.provider.a r118 = new com.bytedance.locallife.dito.provider.a(new DitoActionModel("dito_ak_locate", MapsKt.mutableMapOf(r114), null, 4, null), null, null, null, new PoiBusinessAutoScrollPlugin$locateToNode$action$1(r111), 8);
        g().u(r118);
        return;
    L50:
        r117 = null;
        goto L51
    L38:
        r113 = false;
        goto L39
    L32:
        r112 = 40;
    L28:
        r108 = false;
        goto L29
    L20:
        if (r102.isEmpty() == false) goto L22;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r105 = false;
        goto L12
    }

    public final void D(com.bytedance.locallife.poi.poidetail.container.mob.f r210, String r211, String r212) {
        int r100 = j.f263878a;
        DitoFragment r101 = f();
        wy6.a r102 = s();
        if (r102 == null) goto L5;
        com.bytedance.locallife.poi.poidetail.container.ability.common.e r103 = r102.e();
    L6:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "result");
        String r104 = r210.f263868d;
        String r105 = r210.f263869e;
        boolean r110 = false;
        if (Intrinsics.areEqual(r211, "success") == false) goto L86;
        if (r101 != null) goto L10;
        com.bytedance.locallife.poi.poidetail.container.mob.g r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
    L87:
        String r107 = r210.f263869e;
        boolean r108 = j.c(r106.f263873d, r106.f263872c);
        boolean r109 = j.c(r106.f263874e, r106.f263872c);
        if (Intrinsics.areEqual(r211, "success") == false) goto L123;
        if (r107 != null) goto L92;
    L95:
        boolean r111 = true;
    L96:
        if (r111 == false) goto L99;
        if (r108 == false) goto L99;
    L107:
        String r112 = "exact";
    L125:
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("anchor_source", r210.f263865a);
        r113.put("anchor_method", r210.f263866b);
        String r114 = r210.f263867c;
        String r115 = "";
        if (r114 != null) goto L128;
        r114 = "";
    L128:
        r113.put("enter_method", r114);
        r113.put("target_node_tag", r210.f263868d);
        String r116 = r210.f263869e;
        if (r116 != null) goto L131;
        r116 = "";
    L131:
        r113.put("target_sub_view_id", r116);
        r113.put("result", r211);
        r113.put(LocationMonitorConst.ACCURACY, r112);
        if (Intrinsics.areEqual(r112, "exact") == false) goto L134;
        String r117 = "1";
    L135:
        r113.put("is_accurate", r117);
        String r118 = r106.f263870a;
        if (r118 != null) goto L138;
        r118 = "";
    L138:
        r113.put("actual_top_node_tag", r118);
        String r119 = r106.f263871b;
        if (r119 == null) goto L142;
        r115 = r119;
    L142:
        r113.put("actual_top_sub_view_id", r115);
        j.e(r113, "anchor_line_on_screen", r106.f263872c);
        j.e(r113, "node_top_on_screen", r106.f263873d);
        j.e(r113, "sub_view_top_on_screen", r106.f263874e);
        Integer r120 = r106.f263873d;
        Integer r121 = r106.f263872c;
        if (r120 == null) goto L147;
        if (r121 == null) goto L147;
        Integer r122 = Integer.valueOf(r120.intValue() - r121.intValue());
    L148:
        j.e(r113, "node_top_delta_to_anchor", r122);
        Integer r123 = r106.f263874e;
        Integer r124 = r106.f263872c;
        if (r123 == null) goto L153;
        if (r124 == null) goto L153;
        Integer r125 = Integer.valueOf(r123.intValue() - r124.intValue());
    L154:
        j.e(r113, "sub_view_top_delta_to_anchor", r125);
        if (r212 == null) goto L163;
        if ((!StringsKt.isBlank(r212)) == false) goto L159;
        String r126 = r212;
    L160:
        if (r126 == null) goto L163;
        r113.put("fail_reason", r126);
        goto L163
    L159:
        r126 = null;
    L163:
        if (r103 == null) goto L165;
        r103.b("life_poi_anchor_status_tech", r113);
        Unit r127 = Unit.INSTANCE;
    L166:
        if (r127 != null) goto L175;
        int r128 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("life_poi_anchor_status_tech", r113);
        return;
    L175:
        return;
    L165:
        r127 = null;
    L153:
        r125 = null;
    L147:
        r122 = null;
        goto L148
    L134:
        r117 = "0";
    L99:
        if (r107 != null) goto L101;
    L104:
        boolean r129 = true;
    L105:
        if (r129 == true) goto L108;
        if (r109 == true) goto L107;
    L108:
        if (r107 != null) goto L110;
    L113:
        boolean r130 = true;
    L114:
        if (r130 == true) goto L117;
        if (r108 == false) goto L117;
        r112 = "partial";
    L117:
        String r131 = r106.f263870a;
        if (r131 != null) goto L120;
    L121:
        r110 = true;
    L122:
        if (r110 == true) goto L123;
        r112 = "mismatch";
        goto L125
    L120:
        if (StringsKt.isBlank(r131) == false) goto L122;
    L110:
        if (StringsKt.isBlank(r107) == true) goto L113;
        r130 = false;
        goto L114
    L101:
        if (StringsKt.isBlank(r107) == true) goto L104;
        r129 = false;
        goto L105
    L92:
        if (StringsKt.isBlank(r107) == true) goto L95;
        r111 = false;
    L123:
        r112 = "unknown";
        goto L125
    L10:
        com.bytedance.locallife.poi.newdetail.h r132 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        int r133 = com.bytedance.locallife.poi.newdetail.h.g(r101.getContext());
        RecyclerView r134 = r101.f257790l;
        if (r134 != null) goto L13;
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
        goto L87
    L13:
        int r135 = r134.getChildCount();
        int r136 = 0;
    L15:
        if (r136 >= r135) goto L29;
        View r137 = r134.getChildAt(r136);
        if (r137 == null) goto L28;
        int r138 = r134.getChildAdapterPosition(r137);
        if (r138 == (-1)) goto L28;
        BaseDitoModel r139 = (BaseDitoModel) CollectionsKt.getOrNull(r101.la0().f257893c, r138);
        if (r139 == null) goto L28;
        if (Intrinsics.areEqual(r139.f258493b.f258222b, r104) == false) goto L28;
    L30:
        if (r138 != (-1)) goto L32;
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
        goto L87
    L32:
        BaseDitoModel r140 = (BaseDitoModel) CollectionsKt.getOrNull(r101.la0().f257893c, r138);
        if (r140 != null) goto L35;
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
        goto L87
    L35:
        RecyclerView.LayoutManager r141 = r134.getLayoutManager();
        if (r141 == null) goto L85;
        View r142 = r141.findViewByPosition(r138);
        if (r142 == null) goto L85;
        int[] r143 = new int[2];
        r142.getLocationOnScreen(r143);
        int r144 = r143[1];
        if (r105 != null) goto L43;
    L46:
        boolean r145 = true;
    L47:
        if (r145 == true) goto L78;
        RecyclerView.LayoutManager r146 = r134.getLayoutManager();
        if (r146 == null) goto L52;
        View r147 = r146.findViewByPosition(r138);
    L54:
        if ((r147 instanceof ViewGroup) == false) goto L56;
        ViewGroup r148 = (ViewGroup) r147;
    L57:
        if (r148 != null) goto L59;
    L67:
        KeyEvent.Callback r149 = null;
    L68:
        if (r149 == null) goto L78;
        if ((r149 instanceof AbsDitoBaseLynxView) == false) goto L74;
        View r150 = ((AbsDitoBaseLynxView) r149).g0(r105);
    L77:
        if (r150 == null) goto L78;
        int[] r151 = new int[2];
        r150.getLocationOnScreen(r151);
        Integer r152 = Integer.valueOf(r151[1]);
    L81:
        if (j.c(r152, Integer.valueOf(r133)) == false) goto L83;
        String r153 = r105;
    L84:
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(r140.f258493b.f258222b, r153, Integer.valueOf(r133), Integer.valueOf(r144), r152);
        goto L87
    L83:
        r153 = null;
        goto L84
    L74:
        if ((r149 instanceof xp6.a) == false) goto L76;
        r150 = ((xp6.a) r149).a();
        goto L77
    L76:
        r150 = null;
        goto L77
    L59:
        if (r148.getChildCount() <= 0) goto L61;
        boolean r154 = true;
    L62:
        if (r154 == true) goto L65;
        r148 = null;
    L65:
        if (r148 == null) goto L67;
        r149 = r148.getChildAt(0);
        goto L68
    L61:
        r154 = false;
        goto L62
    L56:
        r148 = null;
        goto L57
    L52:
        r147 = null;
    L78:
        r152 = null;
        goto L81
    L43:
        if (StringsKt.isBlank(r105) == true) goto L46;
        r145 = false;
    L85:
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
    L28:
        r136 = r136 + 1;
        goto L15
    L29:
        r138 = -1;
        goto L30
    L86:
        r106 = new com.bytedance.locallife.poi.poidetail.container.mob.g(0);
        goto L87
    L5:
        r103 = null;
        goto L6
    }
}
