package im;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.shopping.floatlive.FloatScene;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f490366q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f490367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FloatScene f490368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IECLivePlayerClient f490369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StoreV3LiveRoomVO f490370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f490371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<? extends IECLivePlayerClient> f490372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f490373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f490374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f490375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f490376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final QLiveData<Boolean> f490377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f490378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final QLiveData<Boolean> f490379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f490380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Runnable> f490381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Boolean> f490382p;

    public static final class a {
    }

    /* JADX INFO: renamed from: im.b$b, reason: collision with other inner class name */
    public static final class RunnableC6285b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f490383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f490384b;

        public RunnableC6285b(b r100, boolean r101) {
            this.f490383a = r100;
            this.f490384b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f490383a.a(this.f490384b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.android.ec.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f490385a;

        @Override // com.bytedance.android.ec.model.j
        public final void onReturnClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onShow() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClick() {
            int r100 = k.f490405a;
            im.a.a(null);
            LinkedHashMap r101 = new LinkedHashMap();
            o r102 = this.f490385a.f490371e;
            if (r102 == null) goto L5;
            String r103 = r102.f490416i;
        L6:
            String r104 = "";
            if (com.bytedance.android.shopping.extensions.k.c(r103) == false) goto L16;
            o r105 = this.f490385a.f490371e;
            if (r105 == null) goto L11;
            String r106 = r105.f490416i;
        L12:
            if (r106 == null) goto L15;
            r104 = r106;
        L15:
            r101.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r104);
        L24:
            int r107 = com.bytedance.android.ec.store.utils.h.f48668a;
            o r108 = this.f490385a.f490371e;
            if (r108 == null) goto L31;
            Context r109 = r108.getContext();
            if (r109 == null) goto L31;
            FragmentActivity r110 = l0.c(r109);
            if (r110 == null) goto L31;
            JSONObject r111 = hm.c.d(r110);
        L32:
            com.bytedance.android.ec.store.utils.h.d(r111, "live_play", null, r101, "shop_window_ad");
            return;
        L31:
            r111 = null;
            goto L32
        L11:
            r106 = null;
            goto L12
        L16:
            o r112 = this.f490385a.f490371e;
            if (r112 == null) goto L19;
            String r113 = r112.f490417j;
        L20:
            if (r113 == null) goto L23;
            r104 = r113;
        L23:
            r101.put("uid", r104);
            goto L24
        L19:
            r113 = null;
            goto L20
        L5:
            r103 = null;
            goto L6
        }

        public c(b r100) {
            this.f490385a = r100;
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClose(boolean r100) {
            o r101 = this.f490385a.f490371e;
            if (r101 == null) goto L5;
            Context r102 = r101.getContext();
        L6:
            FragmentActivity r103 = l0.c(r102);
            if (r103 == null) goto L11;
            Lifecycle r104 = r103.getLifecycle();
            if (r104 == null) goto L11;
            Lifecycle.State r105 = r104.getCurrentState();
        L13:
            if (r105 == Lifecycle.State.RESUMED) goto L15;
            return;
        L15:
            int r106 = k.f490405a;
            im.a.a(null);
            QLiveData<Boolean> r107 = this.f490385a.f490377k;
            Boolean r108 = Boolean.FALSE;
            r107.g(r108);
            Function0<? extends IECLivePlayerClient> r109 = this.f490385a.f490372f;
            if (r109 == null) goto L20;
            IECLivePlayerClient r110 = r109.invoke();
            if (r110 == null) goto L20;
            this.f490385a.f490369c = r110;
            r110.resumePlay();
        L20:
            if (r100 == false) goto L32;
            b r111 = this.f490385a;
            r111.f490376j = true;
            r111.g();
            int r112 = ECSdk.f48106a;
            IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r113 == null) goto L29;
            wu1.a r114 = r113.getECLiveStateController();
            if (r114 == null) goto L29;
            FloatWindowState r115 = FloatWindowState.STOP;
            Scene r116 = Scene.LIVE;
            StoreV3LiveRoomVO r117 = this.f490385a.f490370d;
            if (r117 == null) goto L28;
            r117.getRoomId();
        L28:
            r114.b(r115);
        L29:
            Set<String> r118 = jn.a.f499721a;
            FloatScene r119 = this.f490385a.f490368b;
            if (r119 == null) goto L32;
            jn.a.f499721a.add(r119.getValue());
        L32:
            b r120 = this.f490385a;
            if (r120.f490376j == false) goto L35;
            r120.g();
            return;
        L35:
            IECLivePlayerClient r121 = r120.f490369c;
            if (r121 == null) goto L38;
            r121.unmute();
        L38:
            r120.f490379m.g(r108);
            return;
        L11:
            r105 = null;
            goto L13
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onMuteButtonClick(boolean r100) {
            this.f490385a.f490376j = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f490386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f490387b;

        public d(b r100, boolean r101) {
            this.f490386a = r100;
            this.f490387b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.i(this.f490386a, this.f490387b, false, 2);     // Catch: Throwable -> L4
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

    public final boolean d() {
        Boolean r100 = this.f490377k.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean e() {
        Boolean r100 = this.f490379m.a();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public final void g() {
        IECLivePlayerClient r100 = this.f490369c;
        if (r100 == null) goto L5;
        r100.mute();
    L5:
        this.f490379m.g(Boolean.TRUE);
    }

    public final void b() {
        if (d() == false) goto L6;
        a(false);
        g();
        this.f490376j = true;
        return;
    }

    public final void j() {
        if (d() == false) goto L5;
        return;
    L5:
        this.f490378l = true;
        i(this, false, false, 3);
    }

    public b(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "couldLive");
        this.f490382p = r100;
        this.f490374h = true;
        QLiveData<Boolean> r101 = new QLiveData();
        Boolean r102 = Boolean.FALSE;
        r101.g(r102);
        Unit r103 = Unit.INSTANCE;
        this.f490377k = r101;
        QLiveData<Boolean> r104 = new QLiveData();
        boolean r105 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), r102) == false) goto L5;
        r104.g(r102);
    L6:
        this.f490379m = r104;
        this.f490380n = new c(this);
        this.f490381o = new ArrayList();
        return;
    L5:
        r104.g(Boolean.TRUE);
        goto L6
    }

    public final void a(boolean r100) {
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L8;
        if (ECStoreSettings.e() == true) goto L8;
        return;
    L8:
        if (this.f490367a == true) goto L12;
        List<Runnable> r102 = this.f490381o;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new RunnableC6285b(this, r100));
        return;
    L12:
        if (d() == true) goto L14;
        if (r100 == true) goto L14;
        return;
    L14:
        this.f490377k.g(Boolean.FALSE);
        k.a();
    }

    public final void f(boolean r100) {
        if (d() == false) goto L6;
        int r101 = l.f490406a;
        boolean r102 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), Boolean.TRUE) == true) goto L6;
    L7:
        int r103 = l.f490406a;
        int r104 = ECSdk.f48106a;
        IAdapterService r105 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r105 == null) goto L10;
        r105.muteLiveRoom();
    L10:
        this.f490376j = true;
        return;
    L6:
        if (r100 == true) goto L7;
    }

    public final void h(boolean r110, boolean r111) {
        b r100 = this;
        if (r100.f490374h == true) goto L6;
        return;
    L6:
        if (r100.f490367a == true) goto L9;
        ((ArrayList) r100.f490381o).add(new d(r100, r110));
        return;
    L9:
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == true) goto L12;
    L14:
        int r102 = l.f490406a;
        int r103 = ECSdk.f48106a;
        cf.l r104 = (cf.l) ECSdk.a(cf.l.class);
        if (r104 == null) goto L17;
        boolean r105 = r104.za();
    L19:
        if (r105 == false) goto L38;
        StoreV3LiveRoomVO r106 = r100.f490370d;
        if (r106 == null) goto L27;
        String r107 = r106.getEnterUrl();
        if (r107 == null) goto L27;
        String r108 = a2.d(r107);
        if (r108 == null) goto L27;
        Uri r109 = UriProtector.parse(r108);
    L28:
        if (r109 == null) goto L30;
        String r112 = UriProtector.getQueryParameter(r109, "is_reenter");
    L31:
        boolean r113 = Intrinsics.areEqual(r112, "1");
        if (r100.f490382p.invoke().booleanValue() == false) goto L35;
        if (r113 == false) goto L35;
        boolean r114 = true;
    L36:
        if (r114 == true) goto L38;
    L161:
        if (r100.f490373g == true) goto L163;
    L164:
        g();
        return;
    L163:
        if (d() == false) goto L164;
        return;
    L35:
        r114 = false;
        goto L36
    L30:
        r112 = null;
    L27:
        r109 = null;
    L38:
        if (r111 == true) goto L55;
        Set<String> r115 = jn.a.f499721a;
        FloatScene r116 = r100.f490368b;
        Set<String> r117 = jn.a.f499721a;
        if (r116 == null) goto L42;
        String r118 = r116.getValue();
    L44:
        if (CollectionsKt.contains(r117, r118) == false) goto L51;
        boolean r119 = ECServiceManager.f42805a;
        IAdapterService r120 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r120 == null) goto L50;
        wu1.a r121 = r120.getECLiveStateController();
        if (r121 == null) goto L50;
        r121.e();
    L50:
        boolean r122 = false;
    L52:
        if (r122 == true) goto L55;
    L51:
        r122 = true;
        goto L52
    L42:
        r118 = null;
    L55:
        if (r100.f490370d == null) goto L161;
        if (d() == false) goto L60;
        if (r110 == false) goto L161;
    L60:
        if (r111 == false) goto L63;
        boolean r123 = false;
    L66:
        int r124 = k.f490405a;
        o r125 = r100.f490371e;
        if (r125 == null) goto L69;
        Context r126 = r125.getContext();
    L70:
        Activity r127 = l0.b(r126);
        o r128 = r100.f490371e;
        if (r128 == null) goto L73;
        Fragment r129 = r128.f490409b;
    L75:
        if ((r129 instanceof DialogFragment) == true) goto L77;
        r129 = null;
    L77:
        DialogFragment r130 = (DialogFragment) r129;
        if (r128 == null) goto L80;
        FrameLayout r131 = r128.f490410c;
    L81:
        StoreV3LiveRoomVO r132 = r100.f490370d;
        if (r128 == null) goto L84;
        String r133 = r128.f490412e;
    L85:
        if (r128 == null) goto L87;
        String r134 = r128.f490413f;
    L88:
        if (r128 == null) goto L90;
        String r135 = r128.f490414g;
    L91:
        if (r128 == null) goto L93;
        Integer r136 = Integer.valueOf(r128.f490415h);
    L94:
        c r137 = r100.f490380n;
        FloatScene r138 = r100.f490368b;
        if (r132 == null) goto L100;
        if (r127 != null) goto L101;
        if (r130 == null) goto L100;
        if (r131 == null) goto L100;
    L101:
        if (r137 == null) goto L103;
        im.a.a(r137);
    L103:
        HashMap<String, String> r139 = new HashMap();
        r139.put("enter_from_merge", "store_page");
        r139.put("enter_method", "mini_window");
        r139.put("channel_id", "1111836");
        r139.put("list_entrance", "store_rec_inner");
        if (r138 == null) goto L107;
        String r140 = r138.getValue();
        if (r140 == null) goto L107;
    L108:
        r139.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r140);
        com.bytedance.commerce.base.json.a[] r141 = new com.bytedance.commerce.base.json.a[2];
        JSONObject r142 = com.bytedance.android.shopping.extensions.k.u(r133);
        hm.c.c(r142, r127);
        r141[0] = JsonDslUtilKt.d("pass_through_log_data", r142.toString());
        com.bytedance.commerce.base.json.a[] r143 = new com.bytedance.commerce.base.json.a[1];
        if (r134 != null) goto L111;
        r134 = "";
    L111:
        r143[0] = JsonDslUtilKt.d("ecom_scene_id", r134);
        r141[1] = JsonDslUtilKt.d("multi_room_data", JsonDslUtilKt.a(r143).toString());
        r139.put(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, JsonDslUtilKt.a(r141).toString());
        r139.put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        if (r135 == null) goto L114;
        r139.put("search_params", r135);
    L114:
        com.bytedance.android.ec.adapter.api.a r144 = new com.bytedance.android.ec.adapter.api.a();
        String r145 = r132.getEnterUrl();
        if (r145 == null) goto L119;
        String r146 = a2.d(r145);
        if (r146 == null) goto L119;
        Uri r147 = UriProtector.parse(r146);
    L120:
        if (r147 == null) goto L122;
        String r148 = UriProtector.getQueryParameter(r147, "is_reenter");
    L123:
        r144.f42672d = Intrinsics.areEqual(r148, "1");
        RelativeLayout.LayoutParams r149 = new RelativeLayout.LayoutParams(1, 1);
        r149.addRule(12);
        r149.addRule(11);
        if (r136 == null) goto L126;
        int r150 = r136.intValue();
    L127:
        r149.bottomMargin = r150;
        Unit r151 = Unit.INSTANCE;
        r144.f42674f = r149;
        Intrinsics.checkNotNullParameter("store_page", "<set-?>");
        r144.f42669a = "store_page";
        String r152 = r132.getRoomId();
        if (r152 == null) goto L133;
        Intrinsics.checkNotNullParameter(r152, "$this$safeToLong");
        Long r153 = Long.valueOf(CastLongProtector.parseLong(r152));     // Catch: Exception -> L132
    L134:
        r144.f42670b = r153;
        r144.f42673e = r139;
        r144.f42671c = r123;
        boolean r154 = false;
        new com.bytedance.android.ec.adapter.api.k(0);
        Unit r155 = Unit.INSTANCE;
        FloatScene r156 = FloatScene.SHOP;
        Set<String> r157 = jn.a.f499721a;
        Intrinsics.checkNotNullParameter(r144, "floatExtra");
        if (r111 == true) goto L147;
        Set<String> r158 = jn.a.f499721a;
        if (r138 == null) goto L139;
        String r159 = r138.getValue();
    L141:
        if (CollectionsKt.contains(r158, r159) == false) goto L147;
        boolean r160 = ECServiceManager.f42805a;
        IAdapterService r161 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r161 == null) goto L157;
        wu1.a r162 = r161.getECLiveStateController();
        if (r162 == null) goto L157;
        r162.e();
    L157:
        r100 = this;
        if (r154 == false) goto L161;
        r100.f490376j = !Intrinsics.areEqual(r100.f490379m.a(), Boolean.FALSE);
        r100.f490377k.g(Boolean.TRUE);
        goto L161
    L139:
        r159 = null;
    L147:
        int r163 = ECSdk.f48106a;
        IAdapterService r164 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r164 == null) goto L157;
        com.bytedance.android.ec.adapter.api.j r165 = r164.getLiveWindowService();
        if (r165 == null) goto L157;
        if (r130 == null) goto L154;
        if (r131 == null) goto L154;
        r165.a(r130, r131, r144);
    L156:
        r154 = true;
    L154:
        if (r127 == null) goto L157;
        r165.c(r127, r144);
    L133:
        r153 = null;
        goto L134
    L126:
        r150 = com.bytedance.android.shopping.extensions.b.b(142);
        goto L127
    L122:
        r148 = null;
    L119:
        r147 = null;
    L107:
        r140 = FloatScene.SHOP.getValue();
    L100:
        r154 = false;
        goto L157
    L93:
        r136 = null;
        goto L94
    L90:
        r135 = null;
        goto L91
    L87:
        r134 = null;
        goto L88
    L84:
        r133 = null;
        goto L85
    L80:
        r131 = null;
        goto L81
    L73:
        r129 = null;
        goto L75
    L69:
        r126 = null;
        goto L70
    L63:
        if (r100.f490375i == false) goto L65;
        r123 = r100.f490376j;
        goto L66
    L65:
        r123 = e();
        goto L66
    L17:
        r105 = false;
        goto L19
    L12:
        if (ECStoreSettings.e() == true) goto L14;
        goto L14
    }

    public static /* synthetic */ void i(b r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        r100.h(r101, r102);
    }

    public static void c(b r100, FloatScene r101, boolean r102, StoreV3LiveRoomVO r103, boolean r104, o r105, boolean r106, boolean r107, int r110) {
        if ((r110 & 32) == 0) goto L6;
        r106 = false;
    L6:
        if ((r110 & 64) == 0) goto L8;
        r107 = true;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "floatLiveContext");
        r100.f490368b = r101;
        r100.f490375i = r102;
        r100.f490370d = r103;
        r100.f490371e = r105;
        r100.f490372f = null;
        r100.f490373g = r106;
        r100.f490374h = r107;
        r100.f490379m.g(Boolean.valueOf(r104));
        r100.f490367a = true;
    L10:
        if ((!((ArrayList) r100.f490381o).isEmpty()) == false) goto L12;
        ((Runnable) ListProtector.remove(r100.f490381o, 0)).run();
        goto L10
    }
}
