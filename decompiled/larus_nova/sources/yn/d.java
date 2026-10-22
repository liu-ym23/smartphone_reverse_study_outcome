package yn;

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
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.shopping.floatlive.FloatScene;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f568443q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f568444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FloatScene f568445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IECLivePlayerClient f568446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WindowV3LiveRoomVO f568447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f568448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<? extends IECLivePlayerClient> f568449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f568450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f568451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f568452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f568453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final QLiveData<Boolean> f568454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<o> f568455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final QLiveData<Boolean> f568456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f568457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Runnable> f568458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Boolean> f568459p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f568460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f568461b;

        public b(d r100, boolean r101) {
            this.f568460a = r100;
            this.f568461b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f568460a.b(this.f568461b);     // Catch: Throwable -> L4
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
        public final /* synthetic */ d f568462a;

        @Override // com.bytedance.android.ec.model.j
        public final void onReturnClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onShow() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClick() {
            int r100 = yn.a.f568440a;
            yn.b.a(null);
            LinkedHashMap r101 = new LinkedHashMap();
            m r102 = this.f568462a.f568448e;
            if (r102 == null) goto L5;
            String r103 = r102.f568488i;
        L6:
            String r104 = "";
            if (com.bytedance.android.shopping.extensions.k.c(r103) == false) goto L16;
            m r105 = this.f568462a.f568448e;
            if (r105 == null) goto L11;
            String r106 = r105.f568488i;
        L12:
            if (r106 == null) goto L15;
            r104 = r106;
        L15:
            r101.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r104);
        L24:
            int r107 = com.bytedance.android.ec.window.base.utils.i.f49729a;
            m r108 = this.f568462a.f568448e;
            if (r108 == null) goto L31;
            Context r109 = r108.getContext();
            if (r109 == null) goto L31;
            FragmentActivity r110 = l0.c(r109);
            if (r110 == null) goto L31;
            JSONObject r111 = xn.c.c(r110);
        L32:
            com.bytedance.android.ec.window.base.utils.i.e(r111, "live_play", null, r101, "shop_window_ad");
            return;
        L31:
            r111 = null;
            goto L32
        L11:
            r106 = null;
            goto L12
        L16:
            m r112 = this.f568462a.f568448e;
            if (r112 == null) goto L19;
            String r113 = r112.f568489j;
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

        public c(d r100) {
            this.f568462a = r100;
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClose(boolean r100) {
            m r101 = this.f568462a.f568448e;
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
            int r106 = yn.a.f568440a;
            yn.b.a(null);
            this.f568462a.f568454k.g(Boolean.FALSE);
            Function0<? extends IECLivePlayerClient> r107 = this.f568462a.f568449f;
            if (r107 == null) goto L21;
            IECLivePlayerClient r108 = r107.invoke();
            if (r108 == null) goto L21;
            this.f568462a.f568446c = r108;
            r108.resumePlay();
        L21:
            if (r100 == false) goto L25;
            d r109 = this.f568462a;
            r109.f568452i = true;
            r109.h(true);
            Set<String> r110 = qp.a.f534326a;
            FloatScene r111 = this.f568462a.f568445b;
            if (r111 == null) goto L37;
            qp.a.f534326a.add(r111.getValue());
            return;
        L37:
            return;
        L25:
            d r112 = this.f568462a;
            if (r112.f568452i == false) goto L28;
        L31:
            boolean r113 = true;
        L32:
            if (r113 == false) goto L34;
            r112.h(true);
        L35:
            this.f568462a.f568453j = false;
            return;
        L34:
            r112.j(true);
            goto L35
        L28:
            if (r112.f568453j == true) goto L31;
            r113 = false;
        L11:
            r105 = null;
            goto L13
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onMuteButtonClick(boolean r100) {
            d r101 = this.f568462a;
            r101.f568452i = r100;
            Iterator<T> r102 = r101.f568455l.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((o) r102.next()).c(r100);
            goto L4
        }
    }

    static {
    }

    public final boolean e() {
        Boolean r100 = this.f568454k.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final boolean f() {
        Boolean r100 = this.f568456m.a();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public final void a() {
        if (e() == true) goto L10;
        int r100 = yn.c.f568442a;
        boolean r101 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), Boolean.TRUE) == false) goto L11;
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L12;
        r103.cancelMuteLiveRoom();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void c() {
        if (e() == false) goto L6;
        b(false);
        h(true);
        this.f568452i = true;
        return;
    }

    public d(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "couldLive");
        this.f568459p = r100;
        QLiveData<Boolean> r101 = new QLiveData();
        Boolean r102 = Boolean.FALSE;
        r101.g(r102);
        Unit r103 = Unit.INSTANCE;
        this.f568454k = r101;
        this.f568455l = new LinkedHashSet();
        QLiveData<Boolean> r104 = new QLiveData();
        boolean r105 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), r102) == false) goto L5;
        r104.g(r102);
    L6:
        this.f568456m = r104;
        this.f568457n = new c(this);
        this.f568458o = new ArrayList();
        return;
    L5:
        r104.g(Boolean.TRUE);
        goto L6
    }

    public final void b(boolean r100) {
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L6;
        return;
    L6:
        if (this.f568444a == true) goto L10;
        List<Runnable> r102 = this.f568458o;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new b(this, r100));
        return;
    L10:
        if (e() == true) goto L12;
        if (r100 == true) goto L12;
        return;
    L12:
        yn.a.a();
        this.f568454k.g(Boolean.FALSE);
    }

    public final void g(boolean r100) {
        if (e() == false) goto L6;
        int r101 = yn.c.f568442a;
        boolean r102 = ECServiceManager.f42805a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), Boolean.TRUE) == true) goto L6;
    L7:
        int r103 = yn.c.f568442a;
        int r104 = ECSdk.f48106a;
        IAdapterService r105 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r105 == null) goto L12;
        r105.muteLiveRoom();
        return;
    L12:
        return;
    L6:
        if (r100 == true) goto L7;
    }

    public final void h(boolean r100) {
        IECLivePlayerClient r101 = this.f568446c;
        if (r101 == null) goto L5;
        r101.mute();
    L5:
        this.f568456m.g(Boolean.TRUE);
        if (r100 == false) goto L11;
        Iterator<T> r102 = this.f568455l.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        ((o) r102.next()).c(true);
        goto L9
    L13:
        return;
    }

    public final void j(boolean r100) {
        IECLivePlayerClient r101 = this.f568446c;
        if (r101 == null) goto L5;
        r101.unmute();
    L5:
        this.f568456m.g(Boolean.FALSE);
        if (r100 == false) goto L11;
        Iterator<T> r102 = this.f568455l.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        ((o) r102.next()).c(false);
        goto L9
    L13:
        return;
    }

    public static void i(d r110, boolean r111, int r112) {
        d r100 = r110;
        if ((r112 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if (r100.f568444a == true) goto L9;
        ((ArrayList) r100.f568458o).add(new e(r100, r101));
        return;
    L9:
        Lazy r102 = ECAppInfoService.f48110a;
        if (we.a.f559330a == true) goto L137;
        if (yn.c.a() == false) goto L32;
        WindowV3LiveRoomVO r103 = r100.f568447d;
        if (r103 == null) goto L21;
        String r104 = r103.getEnterUrl();
        if (r104 == null) goto L21;
        String r105 = a2.d(r104);
        if (r105 == null) goto L21;
        Uri r106 = UriProtector.parse(r105);
    L22:
        if (r106 == null) goto L24;
        String r107 = UriProtector.getQueryParameter(r106, "is_reenter");
    L25:
        boolean r108 = Intrinsics.areEqual(r107, "1");
        if (r100.f568459p.invoke().booleanValue() == false) goto L29;
        if (r108 == false) goto L29;
        boolean r109 = true;
    L30:
        if (r109 == true) goto L32;
    L29:
        r109 = false;
        goto L30
    L24:
        r107 = null;
    L21:
        r106 = null;
    L32:
        Set<String> r113 = qp.a.f534326a;
        FloatScene r114 = r100.f568445b;
        Set<String> r115 = qp.a.f534326a;
        if (r114 == null) goto L35;
        String r116 = r114.getValue();
    L37:
        if ((!CollectionsKt.contains(r115, r116)) == false) goto L137;
        if (r100.f568447d == null) goto L137;
        if (r110.e() == false) goto L46;
        if (r101 == false) goto L137;
    L46:
        if (r100.f568451h == false) goto L48;
        boolean r117 = r100.f568452i;
    L49:
        int r118 = yn.a.f568440a;
        m r119 = r100.f568448e;
        if (r119 == null) goto L52;
        Context r120 = r119.getContext();
    L53:
        Activity r121 = l0.b(r120);
        m r122 = r100.f568448e;
        if (r122 == null) goto L56;
        Fragment r123 = r122.f568481b;
    L58:
        if ((r123 instanceof DialogFragment) == true) goto L60;
        r123 = null;
    L60:
        DialogFragment r124 = (DialogFragment) r123;
        if (r122 == null) goto L63;
        FrameLayout r125 = r122.f568482c;
    L64:
        WindowV3LiveRoomVO r126 = r100.f568447d;
        if (r122 == null) goto L67;
        String r127 = r122.f568484e;
    L68:
        if (r122 == null) goto L70;
        String r128 = r122.f568485f;
    L71:
        if (r122 == null) goto L73;
        String r129 = r122.f568486g;
    L74:
        if (r122 == null) goto L76;
        Integer r130 = Integer.valueOf(r122.f568487h);
    L77:
        c r131 = r100.f568457n;
        FloatScene r132 = r100.f568445b;
        if (r126 == null) goto L83;
        if (r121 != null) goto L84;
        if (r124 == null) goto L83;
        if (r125 == null) goto L83;
    L84:
        if (r131 == null) goto L86;
        yn.b.a(r131);
    L86:
        HashMap<String, String> r133 = new HashMap();
        r133.put("enter_from_merge", "store_page");
        r133.put("enter_method", "mini_window");
        r133.put("channel_id", "1111836");
        r133.put("list_entrance", "store_rec_inner");
        if (r132 == null) goto L90;
        String r134 = r132.getValue();
        if (r134 == null) goto L90;
    L91:
        r133.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r134);
        com.bytedance.commerce.base.json.a[] r135 = new com.bytedance.commerce.base.json.a[2];
        JSONObject r136 = com.bytedance.android.shopping.extensions.k.u(r127);
        xn.c.b(r136, r121);
        r135[0] = JsonDslUtilKt.d("pass_through_log_data", r136.toString());
        com.bytedance.commerce.base.json.a[] r137 = new com.bytedance.commerce.base.json.a[1];
        if (r128 != null) goto L94;
        r128 = "";
    L94:
        r137[0] = JsonDslUtilKt.d("ecom_scene_id", r128);
        r135[1] = JsonDslUtilKt.d("multi_room_data", JsonDslUtilKt.a(r137).toString());
        r133.put(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, JsonDslUtilKt.a(r135).toString());
        r133.put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        if (r129 == null) goto L97;
        r133.put("search_params", r129);
    L97:
        com.bytedance.android.ec.adapter.api.a r138 = new com.bytedance.android.ec.adapter.api.a();
        String r139 = r126.getEnterUrl();
        if (r139 == null) goto L102;
        String r140 = a2.d(r139);
        if (r140 == null) goto L102;
        Uri r141 = UriProtector.parse(r140);
    L103:
        if (r141 == null) goto L105;
        String r142 = UriProtector.getQueryParameter(r141, "is_reenter");
    L106:
        r138.f42672d = Intrinsics.areEqual(r142, "1");
        RelativeLayout.LayoutParams r143 = new RelativeLayout.LayoutParams(1, 1);
        r143.addRule(12);
        r143.addRule(11);
        if (r130 == null) goto L109;
        int r144 = r130.intValue();
    L110:
        r143.bottomMargin = r144;
        Unit r145 = Unit.INSTANCE;
        r138.f42674f = r143;
        Intrinsics.checkNotNullParameter("store_page", "<set-?>");
        r138.f42669a = "store_page";
        String r146 = r126.getRoomId();
        if (r146 == null) goto L115;
        Intrinsics.checkNotNullParameter(r146, "$this$safeToLong");
        Long r147 = Long.valueOf(CastLongProtector.parseLong(r146));     // Catch: Exception -> L144
    L116:
        r138.f42670b = r147;
        r138.f42673e = r133;
        r138.f42671c = r117;
        boolean r148 = false;
        new com.bytedance.android.ec.adapter.api.k(0);
        Unit r149 = Unit.INSTANCE;
        FloatScene r150 = FloatScene.SHOP;
        Set<String> r151 = qp.a.f534326a;
        Intrinsics.checkNotNullParameter(r138, "floatExtra");
        Set<String> r152 = qp.a.f534326a;
        if (r132 == null) goto L119;
        String r153 = r132.getValue();
    L121:
        if (CollectionsKt.contains(r152, r153) == true) goto L133;
        int r154 = ECSdk.f48106a;
        IAdapterService r155 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r155 == null) goto L133;
        com.bytedance.android.ec.adapter.api.j r156 = r155.getLiveWindowService();
        if (r156 == null) goto L133;
        if (r124 == null) goto L130;
        if (r125 == null) goto L130;
        r156.a(r124, r125, r138);
    L132:
        r148 = true;
    L130:
        if (r121 == null) goto L133;
        r156.c(r121, r138);
    L133:
        r100 = r110;
        if (r148 == false) goto L137;
        r100.f568452i = r117;
        r100.f568454k.g(Boolean.TRUE);
        goto L137
    L119:
        r153 = null;
    L115:
        r147 = null;
        goto L116
    L109:
        r144 = com.bytedance.android.shopping.extensions.b.b(142);
        goto L110
    L105:
        r142 = null;
    L102:
        r141 = null;
    L90:
        r134 = FloatScene.SHOP.getValue();
    L83:
        r148 = false;
        goto L133
    L76:
        r130 = null;
        goto L77
    L73:
        r129 = null;
        goto L74
    L70:
        r128 = null;
        goto L71
    L67:
        r127 = null;
        goto L68
    L63:
        r125 = null;
        goto L64
    L56:
        r123 = null;
        goto L58
    L52:
        r120 = null;
        goto L53
    L48:
        r117 = r110.f();
        goto L49
    L35:
        r116 = null;
    L137:
        if (r100.f568450g == true) goto L139;
    L142:
        r100.h(true);
        return;
    L139:
        if (r110.e() == false) goto L142;
        r100.f568456m.g(Boolean.TRUE);
        return;
    L5:
        r101 = r111;
        goto L7
    }

    public static void d(d r100, FloatScene r101, boolean r102, WindowV3LiveRoomVO r103, boolean r104, m r105, boolean r106, Function0 r107, int r110) {
        if ((r110 & 32) == 0) goto L6;
        r106 = false;
    L6:
        if ((r110 & 128) == 0) goto L8;
        r107 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "floatLiveContext");
        r100.f568445b = r101;
        r100.f568451h = r102;
        r100.f568447d = r103;
        r100.f568448e = r105;
        r100.f568449f = r107;
        r100.f568450g = r106;
        r100.f568456m.g(Boolean.valueOf(r104));
        r100.f568444a = true;
    L10:
        if ((!((ArrayList) r100.f568458o).isEmpty()) == false) goto L12;
        ((Runnable) ListProtector.remove(r100.f568458o, 0)).run();
        goto L10
    }
}
