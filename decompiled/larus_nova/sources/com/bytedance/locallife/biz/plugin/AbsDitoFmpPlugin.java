package com.bytedance.locallife.biz.plugin;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.bytedance.ies.ugc.aweme.fmp.core.FmpCallback;
import com.bytedance.ies.ugc.aweme.fmp.core.diff.DiffCalMode;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.e0;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.y;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import com.bytedance.locallife.groupon.struct.innerpush.Action;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/biz/plugin/AbsDitoFmpPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDitoFmpPlugin extends AbsDitoLifeCyclePlugin {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f256863p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PoiChainDurationMonitor f256864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.locallife.biz.fmp.a f256865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f256866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f256867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<String> f256868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f256869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f256870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f256871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f256872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f256873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Long> f256874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f256875o;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256876a;

        public b(AbsDitoFmpPlugin r100) {
            this.f256876a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            rq6.a r101 = rq6.a.f538927a;
            StringBuilder r102 = new StringBuilder();
            DitoPageInfo r103 = this.f256876a.g().f258040f;
            String r104 = null;
            if (r103 == null) goto L5;
            String r105 = r103.getSessionId();
        L6:
            r102.append(r105);
            r102.append(" loadCount++ ");
            r102.append(r100);
            r102.append(" url: ");
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Pair<com.bytedance.locallife.dito.core.BaseDitoView<*>?, com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate>");
            CubeInternalSchemaModel r106 = ((IPoiLynxKitDelegate) ((Pair) r100).getSecond()).getCubeContext().c();
            if (r106 == null) goto L9;
            r104 = r106.originSchema;
        L9:
            r102.append(r104);
            r101.a("AbsDitoFmpPlugin", r102.toString());
            if (this.f256876a.e().k0().getValue() != null) goto L13;
            this.f256876a.f256869i++;
            return;
        L13:
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256877a;

        public c(AbsDitoFmpPlugin r100) {
            this.f256877a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            rq6.a r101 = rq6.a.f538927a;
            StringBuilder r102 = new StringBuilder();
            DitoPageInfo r103 = this.f256877a.g().f258040f;
            String r104 = null;
            if (r103 == null) goto L5;
            String r105 = r103.getSessionId();
        L6:
            r102.append(r105);
            r102.append(" loadedCount++ ");
            r102.append(r100);
            r102.append(" url: ");
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Pair<com.bytedance.locallife.dito.core.BaseDitoView<*>?, com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate>");
            CubeInternalSchemaModel r106 = ((IPoiLynxKitDelegate) ((Pair) r100).getSecond()).getCubeContext().c();
            if (r106 == null) goto L9;
            r104 = r106.originSchema;
        L9:
            r102.append(r104);
            r101.a("AbsDitoFmpPlugin", r102.toString());
            if (this.f256877a.e().k0().getValue() != null) goto L13;
            this.f256877a.f256872l++;
            return;
        L13:
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256878a;

        public d(AbsDitoFmpPlugin r100) {
            this.f256878a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.l r101 = (com.bytedance.locallife.dito.data.l) r100;
            PoiChainDurationMonitor r102 = this.f256878a.f256864d;
            if (r102 == null) goto L83;
            String r103 = r101.getType();
            String r104 = "";
            switch(r103.hashCode()) {
                case -1432594897: goto L74;
                case -1052983661: goto L64;
                case -1040011027: goto L60;
                case -460063705: goto L50;
                case -127772062: goto L46;
                case 1306800590: goto L9;
                default: goto L84;
            };
        L84:
            return;
        L9:
            if (r103.equals("API_REQUEST_SUCCESS") == false) goto L85;
            DitoPage r105 = r101.f258215b;
            if (r105 != null) goto L14;
        L16:
            DitoPage r106 = r101.f258215b;
            if (r106 == null) goto L23;
            DitoPageInfo r107 = r106.getPageInfo();
            if (r107 == null) goto L23;
            String r108 = r107.getId();
            if (r108 == null) goto L23;
            ((ConcurrentHashMap) r102.f256674e).put("dito_page_entity_id", r108);
        L23:
            DitoPage r109 = r101.f258215b;
            if (r109 == null) goto L30;
            DitoPageInfo r110 = r109.getPageInfo();
            if (r110 == null) goto L30;
            String r111 = r110.getPageKey();
            if (r111 == null) goto L30;
            r102.h(Action.TYPE_SUB_PAGE, r111);
            r102.h("pageKey", r111);
        L30:
            DitoPage r112 = r101.f258215b;
            if (r112 == null) goto L37;
            DitoPageInfo r113 = r112.getPageInfo();
            if (r113 == null) goto L37;
            String r114 = r113.getPageId();
            if (r114 == null) goto L37;
            r102.h("pageId", r114);
        L37:
            DitoPage r115 = r101.f258215b;
            if (r115 == null) goto L44;
            DitoPageInfo r116 = r115.getPageInfo();
            if (r116 == null) goto L44;
            String r117 = r116.getId();
            if (r117 == null) goto L44;
            r102.h("dito_page_entity_id", r117);
        L44:
            int r118 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.l(r102, "0", "");
            return;
        L14:
            if (r105.getPageInfo() == null) goto L16;
            this.f256878a.getClass();
            goto L16
        L85:
            return;
        L46:
            if (r103.equals("DATA_PARSE_SUCCESS") == false) goto L86;
            int r119 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.g(r102, "0", "");
            return;
        L86:
            return;
        L50:
            if (r103.equals("DATA_PARSE_ERROR") == false) goto L87;
            int r120 = com.bytedance.locallife.biz.utils.c.f256986a;
            Throwable r121 = r101.f258216c;
            if (r121 == null) goto L58;
            String r122 = r121.getMessage();
            if (r122 == null) goto L58;
            r104 = r122;
        L58:
            com.bytedance.locallife.biz.utils.c.g(r102, "1", r104);
            return;
        L87:
            return;
        L60:
            if (r103.equals("API_REQUEST_START") == false) goto L88;
            int r123 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.m(r102);
            this.f256878a.getClass();
            return;
        L88:
            return;
        L64:
            if (r103.equals("API_REQUEST_ERROR") == false) goto L89;
            int r124 = com.bytedance.locallife.biz.utils.c.f256986a;
            Throwable r125 = r101.f258216c;
            if (r125 == null) goto L72;
            String r126 = r125.getMessage();
            if (r126 == null) goto L72;
            r104 = r126;
        L72:
            com.bytedance.locallife.biz.utils.c.l(r102, "1", r104);
            return;
        L89:
            return;
        L74:
            if (r103.equals("REQUEST_READY_REFRESH") == false) goto L90;
            int r127 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.j(r102);
            return;
        L90:
            return;
        }
    }

    public static final class e<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256879a;

        public e(AbsDitoFmpPlugin r100) {
            this.f256879a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            v r101 = (v) r100;
            PoiChainDurationMonitor r102 = this.f256879a.f256864d;
            if (r102 == null) goto L6;
            int r103 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.f(r102);
            return;
        }
    }

    public static final class f<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256880a;

        public f(AbsDitoFmpPlugin r100) {
            this.f256880a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AbsDitoFmpPlugin r101 = this.f256880a;
            r101.f256866f = ((JSONObject) r100).optString(UniContext.KEY_OF_BIZ_CODE);
            AbsDitoFmpPlugin r102 = this.f256880a;
            PoiChainDurationMonitor r103 = r102.f256864d;
            if (r103 == null) goto L6;
            r103.h(UniContext.KEY_OF_BIZ_CODE, r102.f256866f);
            return;
        }
    }

    public static final class g<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256881a;

        public g(AbsDitoFmpPlugin r100) {
            this.f256881a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AbsDitoFmpPlugin r101 = this.f256881a;
            r101.f256867g = ((JSONObject) r100).optString("router_mode");
            AbsDitoFmpPlugin r102 = this.f256881a;
            PoiChainDurationMonitor r103 = r102.f256864d;
            if (r103 == null) goto L6;
            r103.h("router_mode", r102.f256867g);
            return;
        }
    }

    public static final class h<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256882a;

        public h(AbsDitoFmpPlugin r100) {
            this.f256882a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            y r111 = (y) r110;
            AbsDitoFmpPlugin r100 = this.f256882a;
            String r101 = r111.f258159a;
            e0 r102 = r111.f258164f;
            String r103 = r102.f257908a;
            long r104 = r102.f257909b;
            ConcurrentHashMap r105 = new ConcurrentHashMap();
            AbsDitoFmpPlugin r106 = this.f256882a;
            r105.putAll(r111.f258169k);
            r105.put("is_first_open", String.valueOf(AbsDitoFmpPlugin.f256863p ? 1 : 0));
            String r107 = r106.f256866f;
            if (r107 != null) goto L5;
            r107 = "";
        L5:
            r105.put(UniContext.KEY_OF_BIZ_CODE, r107);
            String r108 = r106.f256867g;
            if (r108 != null) goto L8;
            r108 = "0";
        L8:
            r105.put("router_mode", r108);
            r105.putAll(r106.w());
            Unit r109 = Unit.INSTANCE;
            PoiChainDurationMonitor r112 = new PoiChainDurationMonitor(r101, r103, r104, r105);
            Map<String, String> r113 = r112.f256674e;
            ConcurrentHashMap r114 = (ConcurrentHashMap) r113;
            r114.put(LocaleWatchScene.ACTIVITY_CREATE, String.valueOf(r111.f258164f.f257910c));
            Map<String, String> r115 = r112.f256674e;
            ConcurrentHashMap r116 = (ConcurrentHashMap) r115;
            r116.put("lynxview_preload", String.valueOf(r111.f258164f.f257912e));
            AbsDitoFmpPlugin.f256863p = false;
            r100.f256864d = r112;
        }
    }

    public static final class i<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256883a;

        public i(AbsDitoFmpPlugin r100) {
            this.f256883a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.b r101 = (com.bytedance.locallife.dito.data.b) r100;
            BaseDitoModel<?> r102 = r101.f258196b;
            if (r102 == null) goto L52;
            DitoNode r103 = r102.f258493b.f258221a;
            if (r103 == null) goto L55;
            Map<String, String> r104 = r103.getTemplate();
            Map r105 = null;
            if (r104 == null) goto L10;
            String r106 = r104.get("url");
        L12:
            if (r103.getCustomTag() == null) goto L14;
            String r107 = r103.getCustomTag();
        L27:
            if (Intrinsics.areEqual(r107, "null") == false) goto L40;
            BaseDitoModel<?> r108 = r101.f258196b;
            if (r108 == null) goto L33;
            com.bytedance.locallife.dito.data.m r109 = r108.f258493b;
            if (r109 == null) goto L33;
            String r110 = r109.f258222b;
        L34:
            if (r110 == null) goto L40;
            if (r108 == null) goto L39;
            com.bytedance.locallife.dito.data.m r111 = r108.f258493b;
            if (r111 == null) goto L39;
            r107 = r111.f258222b;
        L39:
            r107 = null;
        L33:
            r110 = null;
        L40:
            PoiChainDurationMonitor r112 = this.f256883a.f256864d;
            if (r112 == null) goto L53;
            if (r107 == null) goto L54;
            int r113 = com.bytedance.locallife.biz.utils.c.f256986a;
            Intrinsics.checkNotNullParameter(r112, "durationMonitor");
            Intrinsics.checkNotNullParameter(r107, "cardTag");
            Object r114 = r112.f256673d.get("card_tags");
            if (TypeIntrinsics.isMutableMap(r114) == false) goto L46;
            r105 = (Map) r114;
        L46:
            if (r105 != null) goto L48;
            r105 = new LinkedHashMap();
            r112.f256673d.put("card_tags", r105);
        L48:
            r105.put(r107, Long.valueOf(SystemClock.elapsedRealtime()));
            return;
        L54:
            return;
        L53:
            return;
        L14:
            if (r106 != null) goto L16;
        L19:
            boolean r115 = true;
        L20:
            if (r115 == false) goto L50;
            r107 = r103.getSubType();
            goto L27
        L50:
            r107 = String.valueOf(UriProtector.getQueryParameter(UriProtector.parse(r106), "bundle"));     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            rq6.a.f538927a.b("AbsDitoFmpPlugin", "failed to parse url, " + th);
            r107 = null;
            goto L27
        L16:
            if (r106.length() == 0) goto L19;
            r115 = false;
            goto L20
        L10:
            r106 = null;
            goto L12
        L55:
            return;
        }
    }

    public static final class j<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256887a;

        public j(AbsDitoFmpPlugin r100) {
            this.f256887a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            PoiChainDurationMonitor r102 = this.f256887a.f256864d;
            if (r102 == null) goto L6;
            ((ConcurrentHashMap) r102.f256674e).put("is_retry", "1");
            return;
        }
    }

    public static final class k<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256888a;

        public k(AbsDitoFmpPlugin r100) {
            this.f256888a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            boolean r100 = ((JSONObject) r110).optBoolean("isNew", false);
            PoiChainDurationMonitor r101 = this.f256888a.f256864d;
            if (r101 == null) goto L6;
            int r111 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.i(r101, SystemClock.elapsedRealtime(), r100, 0, 0, 0, 120);
            return;
        }
    }

    public static final class l<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256889a;

        public l(AbsDitoFmpPlugin r100) {
            this.f256889a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = ((JSONObject) r100).optString("duration", "");
            PoiChainDurationMonitor r102 = this.f256889a.f256864d;
            if (r102 == null) goto L9;
            int r103 = com.bytedance.locallife.biz.utils.c.f256986a;
            Intrinsics.checkNotNullParameter(r102, "durationMonitor");
            Intrinsics.checkNotNullParameter(r101, "duration");
            Intrinsics.checkNotNullParameter("poi_request_biz_data_handle", "mName");
            ConcurrentHashMap r104 = new ConcurrentHashMap();
            Intrinsics.checkNotNullParameter("biz_handle_duration", "key");
            if (r101 == null) goto L7;
            String r105 = (String) r104.put("biz_handle_duration", r101);
        L7:
            PoiChainDurationMonitor.b r106 = new PoiChainDurationMonitor.b();
            r106.f256687c = "poi_request_biz_data_handle";
            r106.f256685a = SystemClock.elapsedRealtime();
            r106.f256688d = true;
            ((ConcurrentHashMap) r106.f256686b).putAll(r104);
            r102.e(r106);
            return;
        }
    }

    public static final class m<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDitoFmpPlugin f256890a;

        public m(AbsDitoFmpPlugin r100) {
            this.f256890a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            Iterator<String> r102 = r101.keys();
            AbsDitoFmpPlugin r103 = this.f256890a;
        L4:
            if (r102.hasNext() == false) goto L8;
            String r104 = r102.next();
            PoiChainDurationMonitor r105 = r103.f256864d;
            if (r105 == null) goto L4;
            int r106 = com.bytedance.locallife.biz.utils.c.f256986a;
            com.bytedance.locallife.biz.utils.c.n(r105, r104, r101.optString(r104, ""));
            goto L4
        }
    }

    public abstract boolean A(com.bytedance.locallife.dito.data.b r100);

    public abstract DiffCalMode v();

    public abstract FmpCallback x();

    public abstract Map<String, String> y(long r100, long r101);

    static {
        f256863p = true;
    }

    public AbsDitoFmpPlugin() {
        this.f256868h = new AbsDitoFmpPlugin$bizCodeInvoker$1(this);
        this.f256871k = new b(this);
        this.f256873m = new c(this);
        this.f256874n = new LinkedHashMap();
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public void h() {
        super.h();
        z();
        e().B().observeForever(new h(this));
        e().C().observeForever(new AbsDitoFmpPlugin$register$2(this));
        e().A().observeForever(new AbsDitoFmpPlugin$register$3(this));
        e().J().observeForever(new AbsDitoFmpPlugin$register$4(this));
        e().h().observeForever(new i(this));
        e().a0("dito_fmp_is_retry", 1).observeForever(new j(this));
        e().a0("dito_fmp_update_fmp_complete", 1).observeForever(new k(this));
        e().a0("dito_fmp_request_biz_data", 2).observeForever(new l(this));
        e().a0("dito_fmp_update_public_prop", 1).observeForever(new m(this));
        e().a0("dito_fmp_biz_code", 1).observeForever(new f(this));
        e().a0("dito_fmp_router_mode", 1).observeForever(new g(this));
        DitoDataCenter r100 = e();
        int r101 = DitoDataCenter.f258004d;
        r100.r0("component_cube_load_start", 1).observeForever(this.f256871k);
        e().r0("component_cube_first_screen", 1).observeForever(this.f256873m);
        e().k().observeForever(new com.bytedance.locallife.biz.plugin.b(this));
        e().i().observeForever(new com.bytedance.locallife.biz.plugin.c(this));
    }

    public Map<String, String> t() {
        return MapsKt.emptyMap();
    }

    public Map<String, String> w() {
        return MapsKt.emptyMap();
    }

    public void z() {
        e().H().observeForever(new d(this));
        e().x().observeForever(new e(this));
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public void i(t r110) {
        Intrinsics.checkNotNullParameter(r110, "lifeData");
        if (r110.f258254a == null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        DitoFragment r101 = f();
        if (r101 == null) goto L67;
        Window r102 = r101.getWindow();
        if (r102 != null) goto L13;
    L63:
        com.bytedance.locallife.biz.fmp.a r103 = this.f256865e;
        if (r103 == null) goto L68;
        r103.c();
        return;
    L68:
        return;
    L13:
        if (r101.getView() == null) goto L22;
        View r104 = r101.getView();
        if (r104 == null) goto L17;
        ViewParent r105 = r104.getParent();
    L18:
        if (r105 != null) goto L20;
    L21:
        View r106 = r101.requireView();
    L27:
        View r107 = r106;
        final FmpCallback r108 = x();
        if (r100 == true) goto L33;
        com.bytedance.locallife.biz.fmp.a r109 = this.f256865e;
        if (r109 == null) goto L32;
        r109.d();
    L32:
        this.f256865e = null;
        goto L63
    L33:
        com.bytedance.locallife.host.poi_debug.a r111 = HostServiceUtilsKt.Y();
        if (r111 == null) goto L36;
        r111.m();
    L36:
        String r112 = g().f258038d;
        long r113 = g().o().f257909b;
        DiffCalMode r114 = v();
        int r115 = com.bytedance.locallife.biz.experiment.c.f256648a;
        if (HostServiceUtilsKt.y().b("dito_fmp_include_fresco_image_load_state", 0) != 1) goto L39;
        boolean r116 = true;
    L40:
        String r117 = g().f258038d;
        String r118 = this.f256868h.invoke();
        Map<String, Integer> r119 = com.bytedance.locallife.biz.experiment.a.f256646a;
        Intrinsics.checkNotNullParameter(r117, "page");
        Intrinsics.checkNotNullParameter(r118, "bizCode");
        String r120 = "dito_fmp_allow_lynx_no_size_" + r117 + '_' + r118;
        Map<String, Integer> r121 = com.bytedance.locallife.biz.experiment.a.f256646a;
        Integer r122 = (Integer) ((LinkedHashMap) r121).get(r120);
        if (r122 == null) goto L43;
        int r123 = r122.intValue();
    L45:
        if (r123 != 1) goto L47;
        boolean r124 = true;
    L48:
        String r125 = g().f258038d;
        String r126 = this.f256868h.invoke();
        Map<String, Integer> r127 = com.bytedance.locallife.biz.experiment.b.f256647a;
        Intrinsics.checkNotNullParameter(r125, "page");
        Intrinsics.checkNotNullParameter(r126, "bizCode");
        String r128 = "dito_fmp_cal_first_screen_" + r125 + '_' + r126;
        Map<String, Integer> r129 = com.bytedance.locallife.biz.experiment.b.f256647a;
        Integer r130 = (Integer) ((LinkedHashMap) r129).get(r128);
        if (r130 == null) goto L51;
        int r131 = r130.intValue();
        int r132 = 1;
    L52:
        if (r131 != r132) goto L54;
        boolean r133 = true;
    L55:
        if (r124 == true) goto L58;
        if (r133 == true) goto L58;
        com.bytedance.ies.ugc.aweme.fmp.core.b r134 = null;
    L59:
        com.bytedance.locallife.biz.fmp.a r135 = new com.bytedance.locallife.biz.fmp.a(r112, r107, r102, r113, 0.0f, true, r114, r116, r134, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION);
        if (r111 == null) goto L62;
        r111.h();
    L62:
        r135.b(new AbsDitoFmpPlugin$initFmp$2$1(this, r108));
        this.f256865e = r135;
    L58:
        this.f256870j = r133;
        r134 = new com.bytedance.ies.ugc.aweme.fmp.core.b(r124, r133);
        goto L59
    L54:
        r133 = false;
        goto L55
    L51:
        int r136 = HostServiceUtilsKt.y().b(r128, 0);
        r129.put(r128, Integer.valueOf(r136));
        r131 = r136;
        r132 = 1;
        goto L52
    L47:
        r124 = false;
        goto L48
    L43:
        int r137 = HostServiceUtilsKt.y().b(r120, 0);
        r121.put(r120, Integer.valueOf(r137));
        r123 = r137;
        goto L45
    L39:
        r116 = false;
        goto L40
    L20:
        if ((r101.getView() instanceof ViewGroup) == true) goto L22;
    L17:
        r105 = null;
    L22:
        r106 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L27;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r138 = ThreadMethodProxy.currentThread();
        if (r138 == com.larus.home.impl.utils.c.f346341a) goto L27;
        com.larus.home.impl.utils.c.a(r138, "getDecorView");
        goto L27
    L67:
        return;
    L5:
        if (Intrinsics.areEqual(g().A.get("ignore_fmp"), Boolean.TRUE) == true) goto L7;
        r100 = true;
        goto L8
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void n(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void o(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void q(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        if (this.f256875o == true) goto L19;
        boolean r101 = true;
        this.f256875o = true;
        PoiChainDurationMonitor r102 = this.f256864d;
        if (r102 == null) goto L20;
        DitoFragment r103 = f();
        if (r103 != null) goto L11;
    L13:
        r101 = false;
    L14:
        if (r101 == false) goto L16;
        int r104 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.utils.c.d(r102, "1", t());
        return;
    L16:
        new Handler().postDelayed(new com.bytedance.locallife.biz.plugin.a(r102, this), 700);
        return;
    L11:
        if (r103.isFragmentFinishing() != true) goto L13;
    L20:
        return;
    }

    public boolean s(FmpCallback r100) {
        if (e().G().getValue() != null) goto L5;
    L10:
        return false;
    L5:
        if (r100 == null) goto L7;
        boolean r101 = r100.g();
    L8:
        if (r101 == false) goto L10;
        return true;
    L7:
        r101 = true;
        goto L8
    }
}
