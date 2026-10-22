package com.bytedance.locallife.live.card;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.service.ICurrentInteractionUiAction;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.biz.utils.ToastUtils;
import com.bytedance.locallife.live.api.Api;
import com.bytedance.locallife.live.experiment.LiveLocalLifePreloadOrderPageExperiment;
import com.bytedance.locallife.live.goodsshelves.bean.DisplayControl;
import com.bytedance.locallife.live.goodsshelves.bean.DrawTicketParamsInfo;
import com.bytedance.locallife.live.model.AutoCollectCouponResponse;
import com.bytedance.locallife.live.model.GroupPurchaseCardNearStoreInfo;
import com.bytedance.locallife.live.model.GroupPurchaseFlashSale;
import com.bytedance.locallife.live.model.GroupPurchaseMinusSale;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.b0;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/card/LiveLocalLifeBaseCard;", "Landroidx/lifecycle/LifecycleObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public class LiveLocalLifeBaseCard implements LifecycleObserver {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f259161m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f259163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.locallife.live.card.a f259164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRoomState f259165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.locallife.live.card.f f259166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f259167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f259168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f259169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f259170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.locallife.live.msgcenter.b f259171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f259172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public nv6.n f259173l;

    public static final class a {
        public static String a(String r100, nv6.n r101, Map r102, String r103, Map r104) {
            int r105 = com.bytedance.locallife.live.util.t.f260731a;
            u r106 = null;
            if (r101 == null) goto L7;
            nv6.p r107 = r101.a();
            if (r107 == null) goto L7;
            Map<String, Object> r108 = r107.k();
        L8:
            HashMap r109 = com.bytedance.locallife.live.util.t.b(r100, r108);
            r109.putAll(r102);
            if (r101 == null) goto L14;
            nv6.p r110 = r101.a();
            if (r110 == null) goto L14;
            String r111 = r110.q();
            if (r111 == null) goto L14;
        L15:
            r109.put("product_id", r111);
            LiveLocalLifeRoomInfo r112 = LiveLocalLifeUtil.e(r100);
            if (com.bytedance.locallife.live.util.s.d(r112.getDeliveryStatusStart()) == false) goto L18;
            r109.put("delivery_status_start", r112.getDeliveryStatusStart());
        L18:
            int r113 = com.bytedance.locallife.live.util.p.f260728a;
            if (r101 == null) goto L21;
            nv6.p r114 = r101.a();
        L22:
            com.bytedance.locallife.live.util.p.e(r100, r114, r109, r104);
            if (r101 == null) goto L29;
            nv6.p r115 = r101.a();
            if (r115 == null) goto L29;
            GroupPurchaseCardNearStoreInfo r116 = r115.z();
            if (r116 == null) goto L29;
            String r117 = r116.getDeliveryTime();
        L30:
            boolean r118 = false;
            if (r117 != null) goto L33;
        L36:
            boolean r119 = true;
        L37:
            if (r119 == true) goto L42;
            r109.put("live_delivery_time", String.valueOf((CastIntegerProtector.parseInt(r117) * 60) * 1000));     // Catch: Exception -> L40
        L42:
            if (Intrinsics.areEqual(r103, "dsl") == false) goto L60;
            LiveLocalLifeViewModel.Companion.getClass();
            LiveLocalLifeViewModel r120 = LiveLocalLifeViewModel.Companion.a(r100);
            if (r120 == null) goto L60;
            MutableLiveData<com.bytedance.locallife.live.goodsshelves.bean.c> r121 = r120.getLynxDslExpoundCardResponse();
            if (r121 == null) goto L60;
            com.bytedance.locallife.live.goodsshelves.bean.c r122 = r121.getValue();
            if (r122 == null) goto L60;
            if (r122.f259594d == null) goto L52;
            r118 = true;
        L52:
            if (r118 == false) goto L54;
            Map r123 = r122.f259595e;
        L55:
            if (r123 == null) goto L60;
            Iterator r124 = r123.entrySet().iterator();
        L58:
            if (r124.hasNext() == false) goto L60;
            Map.Entry r125 = (Map.Entry) r124.next();
            r109.put((String) r125.getKey(), (String) r125.getValue());
            goto L58
        L54:
            r123 = new LinkedHashMap();
        L60:
            String r126 = com.bytedance.locallife.live.util.t.a(r109);
            LiveLocalLifeViewModel.Companion.getClass();
            LiveLocalLifeViewModel r127 = LiveLocalLifeViewModel.Companion.a(r100);
            if (r127 == null) goto L63;
            r106 = r127.getGroupPurchaseInfoRepository();
        L63:
            if (r106 == null) goto L69;
            String r128 = r106.f259346f;
            if (r128 == null) goto L68;
            com.bytedance.locallife.live.util.t.d(r128);
        L68:
            r106.f259346f = r126;
        L69:
            return r126;
        L33:
            if (r117.length() == 0) goto L36;
            r119 = false;
        L29:
            r117 = null;
            goto L30
        L21:
            r114 = null;
        L14:
            r111 = "";
        L7:
            r108 = null;
            goto L8
        }
    }

    public interface b {
        void a();
    }

    public static final class c implements pv6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeBaseCard f259174a;

        public c(LiveLocalLifeBaseCard r100) {
            this.f259174a = r100;
        }

        @Override // pv6.c
        public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            if (r101 == null) goto L5;
            boolean r103 = Intrinsics.areEqual(r101.get("is_open"), Boolean.TRUE);
        L6:
            if (r103 == false) goto L8;
            LiveLocalLifeBaseCard r104 = this.f259174a;
            r104.f259169h = SystemClock.elapsedRealtime();
            return;
        L8:
            LiveLocalLifeBaseCard r105 = this.f259174a;
            long r106 = r105.f259168g;
            long r107 = SystemClock.elapsedRealtime();
            LiveLocalLifeBaseCard r108 = this.f259174a;
            r105.f259168g = r106 + (r107 - r108.f259169h);
            r108.f259169h = -1;
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeBaseCard f259175a;

        public d(LiveLocalLifeBaseCard r100) {
            this.f259175a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            LinearLayout r101 = this.f259175a.h();
            if (r101 == null) goto L8;
            ViewTreeObserver r102 = r101.getViewTreeObserver();
            if (r102 == null) goto L9;
            r102.addOnGlobalLayoutListener(this.f259175a.f259172k);
            return;
        L9:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            LinearLayout r101 = this.f259175a.h();
            if (r101 == null) goto L8;
            ViewTreeObserver r102 = r101.getViewTreeObserver();
            if (r102 == null) goto L9;
            r102.removeOnGlobalLayoutListener(this.f259175a.f259172k);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeBaseCard f259176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f259177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f259178c;

        public e(LiveLocalLifeBaseCard r100, String r101, Map<String, String> r102) {
            this.f259176a = r100;
            this.f259177b = r101;
            this.f259178c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            AutoCollectCouponResponse r111 = (AutoCollectCouponResponse) r110;
            if (r111 == null) goto L5;
            String r100 = r111.getToastMsg();
        L7:
            if (com.bytedance.locallife.live.util.s.d(r100) == false) goto L14;
            Lazy r101 = ToastUtils.f256981a;
            Activity r102 = this.f259176a.f259163b;
            if (r111 == null) goto L12;
            String r103 = r111.getToastMsg();
            if (r103 == null) goto L12;
        L13:
            ToastUtils.a(r102, r103, 1);
        L12:
            r103 = com.bytedance.locallife.live.util.s.c(R.string.live_local_life_toast_ticket_collect_success);
        L14:
            LiveLocalLifeBaseCard r104 = this.f259176a;
            String r105 = this.f259177b;
            Map<String, String> r106 = this.f259178c;
            int r107 = LiveLocalLifeBaseCard.f259161m;
            r104.c(r105, r106);
            List<Map<String, String>> r112 = r111.getLogExtraList();
            if (r112 == null) goto L20;
            LiveLocalLifeBaseCard r108 = this.f259176a;
            Iterator<T> r113 = r112.iterator();
        L18:
            if (r113.hasNext() == false) goto L22;
            Map r109 = (Map) r113.next();
            int r114 = qv6.i.f534919a;
            qv6.i.c(r108.f259162a, BrowserDependency.UrlClickType.CARD, "button", "3004", null, null, r109, 48);
            goto L18
        L22:
            return;
        L20:
            return;
        L5:
            r100 = null;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeBaseCard f259179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f259180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f259181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DrawTicketParamsInfo f259182d;

        public f(LiveLocalLifeBaseCard r100, String r101, Map<String, String> r102, DrawTicketParamsInfo r103) {
            this.f259179a = r100;
            this.f259180b = r101;
            this.f259181c = r102;
            this.f259182d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            LiveLocalLifeBaseCard r112 = this.f259179a;
            String r100 = this.f259180b;
            Map<String, String> r101 = this.f259181c;
            int r102 = LiveLocalLifeBaseCard.f259161m;
            r112.c(r100, r101);
            DrawTicketParamsInfo r113 = this.f259182d;
            if (r113 == null) goto L10;
            List<Map<String, String>> r114 = r113.getTrackParamsList();
            if (r114 == null) goto L12;
            LiveLocalLifeBaseCard r103 = this.f259179a;
            Iterator<T> r115 = r114.iterator();
        L8:
            if (r115.hasNext() == false) goto L13;
            Map r104 = (Map) r115.next();
            int r105 = qv6.i.f534919a;
            qv6.i.b(r103.f259162a, BrowserDependency.UrlClickType.CARD, "button", "3004", "fail", "error", r104);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeBaseCard f259183a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f259183a.f();
            LiveLocalLifeBaseCard r100 = this.f259183a;
            if (r100.f259170i == true) goto L79;
            boolean r101 = true;
            r100.f259170i = true;
            LiveLifeSaaSUtil.o().a("live_life_card_show");
            LiveLocalLifeViewModel.Companion r102 = LiveLocalLifeViewModel.Companion;
            String r103 = this.f259183a.f259162a;
            r102.getClass();
            LiveLocalLifeViewModel r104 = LiveLocalLifeViewModel.Companion.a(r103);
            if (r104 == null) goto L9;
            com.bytedance.locallife.live.util.l r105 = r104.getLiveLifePreloadManager();
            if (r105 == null) goto L9;
            r105.a(this.f259183a.f259163b);
        L9:
            Lazy r106 = MsgCenter.f260620a;
            LinkedHashMap r107 = new LinkedHashMap();
            r107.put("data_name", "CardHasShow");
            r107.put("data", Boolean.TRUE);
            Unit r108 = Unit.INSTANCE;
            String r109 = null;
            MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("live_life_set_data", r107, null, 4));
            com.bytedance.locallife.live.card.f r110 = this.f259183a.f259166e;
            if (r110 != null) goto L12;
        L14:
            boolean r111 = false;
        L15:
            if (r111 == true) goto L79;
            LiveLocalLifeBaseCard r112 = this.f259183a;
            nv6.n r113 = r112.k();
            if (r113 == null) goto L30;
            nv6.p r114 = r113.a();
            if (r114 == null) goto L30;
            Integer r115 = r114.t();
            if (r115 == null) goto L30;
            if (r115.intValue() != 20) goto L30;
            String r116 = r114.M();
            if (r116 == null) goto L30;
            r112.f259167f = Observable.just(r116).subscribeOn(Schedulers.io()).filter(h.f259241a).map(new i(r112)).subscribe(new j(r112));
        L30:
            LiveLocalLifeBaseCard r117 = this.f259183a;
            r117.getClass();
            Lazy r118 = LiveLocalLifePreloadOrderPageExperiment.f259495a;
            if (((Number) r118.getValue()).intValue() <= 0) goto L33;
            boolean r119 = true;
        L34:
            if (r119 == false) goto L79;
            nv6.n r120 = r117.k();
            if (r120 == null) goto L46;
            nv6.p r121 = r120.a();
            if (r121 == null) goto L46;
            Integer r122 = r121.t();
            if (r122 == null) goto L46;
            if (r122.intValue() != 20) goto L46;
            boolean r123 = true;
        L47:
            if (r123 == true) goto L79;
            nv6.n r124 = r117.k();
            if (r124 == null) goto L59;
            nv6.p r125 = r124.a();
            if (r125 == null) goto L59;
            DisplayControl r126 = r125.m();
            if (r126 == null) goto L59;
            String r127 = r126.getButtonJumpUrl();
            if (r127 == null) goto L59;
            r109 = r127;
        L64:
            if (r109 != null) goto L66;
        L69:
            boolean r128 = true;
        L70:
            if (r128 == true) goto L79;
            if (((Number) r118.getValue()).intValue() == 2) goto L76;
            r101 = false;
        L76:
            if (r101 == false) goto L78;
            com.bytedance.locallife.common.utils.k.c(new k(r109), 2000);
            goto L79
        L78:
            int r129 = com.bytedance.locallife.live.util.l.f260717d;
            com.bytedance.locallife.live.util.l.a.d(r109);
            goto L79
        L66:
            if (r109.length() == 0) goto L69;
            r128 = false;
        L59:
            nv6.n r130 = r117.k();
            if (r130 == null) goto L64;
            nv6.p r131 = r130.a();
            if (r131 == null) goto L64;
            r109 = r131.A();
        L46:
            r123 = false;
            goto L47
        L33:
            r119 = false;
            goto L34
        L12:
            if (r110.isPreview() != true) goto L14;
            r111 = true;
        L79:
            LinearLayout r132 = this.f259183a.h();
            if (r132 == null) goto L85;
            ViewTreeObserver r133 = r132.getViewTreeObserver();
            if (r133 == null) goto L86;
            r133.removeOnGlobalLayoutListener(this);
            return;
        L86:
            return;
        }

        public g(LiveLocalLifeBaseCard r100) {
            this.f259183a = r100;
        }
    }

    static {
    }

    public void f() {
    }

    public LinearLayout h() {
        return null;
    }

    public long j() {
        return 0;
    }

    public long l() {
        return 0;
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public final long i() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L7;
        u r103 = r102.getGroupPurchaseInfoRepository();
        if (r103 == null) goto L7;
        long r104 = r103.f259342b;
    L8:
        long r105 = r104 * ((long) 1000);
        long r106 = System.currentTimeMillis();
        com.bytedance.locallife.live.card.a r107 = g();
        if (r107 == null) goto L11;
        long r108 = r107.f259217f;
    L13:
        return r105 + (r106 - r108);
    L11:
        r108 = System.currentTimeMillis();
    L7:
        r104 = 0;
        goto L8
    }

    public final nv6.n k() {
        nv6.n r100 = this.f259173l;
        if (r100 != null) goto L9;
        com.bytedance.locallife.live.card.a r101 = g();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.f259213b;
    L9:
        return r100;
    }

    public void m() {
        LinearLayout r100 = h();
        if (r100 == null) goto L6;
        r100.setLayoutParams(new FrameLayout.LayoutParams((int) j0.b(112.0f), (int) j0.b(210.0f)));
    L6:
        LinearLayout r101 = h();
        if (r101 == null) goto L10;
        r101.addOnAttachStateChangeListener(new d(this));
        return;
    }

    public final boolean n() {
        long r100 = l();
        long r101 = j();
        long r102 = i();
        if (r100 <= r102) goto L5;
        return false;
    L5:
        if (r102 > r101) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean o() {
        nv6.n r100 = k();
        if (r100 == null) goto L14;
        nv6.p r101 = r100.a();
        if (r101 == null) goto L14;
        DisplayControl r102 = r101.m();
        if (r102 == null) goto L14;
        Integer r103 = r102.getButtonJumpType();
        if (r103 == null) goto L14;
        if (r103.intValue() != 2) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean p() {
        nv6.n r100 = k();
        if (r100 == null) goto L13;
        nv6.p r101 = r100.a();
        if (r101 == null) goto L13;
        GroupPurchaseMinusSale r102 = r101.y();
        if (r102 == null) goto L13;
        String r103 = r102.getSaleId();
        if (r103 == null) goto L13;
        if (r103.length() <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean q() {
        nv6.n r100 = k();
        if (r100 == null) goto L7;
        nv6.p r101 = r100.a();
        if (r101 == null) goto L7;
        long r102 = r101.H();
    L9:
        if (n() == false) goto L25;
        nv6.n r103 = k();
        if (r103 == null) goto L17;
        nv6.p r104 = r103.a();
        if (r104 == null) goto L17;
        GroupPurchaseFlashSale r105 = r104.p();
        if (r105 == null) goto L17;
        long r106 = r105.getLeftQuantity();
    L19:
        if (r106 != 0) goto L21;
    L22:
        return true;
    L21:
        if (r102 == 0) goto L22;
        return false;
    L17:
        r106 = 0;
        goto L19
    L25:
        if (r102 != 0) goto L29;
        return true;
    L29:
        return false;
    L7:
        r102 = 0;
        goto L9
    }

    public final boolean r() {
        nv6.n r100 = k();
        if (r100 == null) goto L7;
        nv6.p r101 = r100.a();
        if (r101 == null) goto L7;
        long r102 = r101.F();
    L8:
        nv6.n r103 = k();
        if (r103 == null) goto L13;
        nv6.p r104 = r103.a();
        if (r104 == null) goto L13;
        long r105 = r104.E();
    L14:
        LongRange r106 = new LongRange(r102, r105);
        LiveLocalLifeViewModel.Companion r107 = LiveLocalLifeViewModel.Companion;
        String r108 = this.f259162a;
        r107.getClass();
        LiveLocalLifeViewModel r109 = LiveLocalLifeViewModel.Companion.a(r108);
        if (r109 == null) goto L19;
        u r110 = r109.getGroupPurchaseInfoRepository();
        if (r110 == null) goto L19;
        Long r111 = Long.valueOf(r110.f259342b);
    L21:
        if (r111 != null) goto L23;
    L25:
        boolean r112 = false;
    L26:
        if (r112 == false) goto L28;
    L31:
        return true;
    L28:
        if (r102 == 0) goto L31;
        if (r105 == 0) goto L31;
        return false;
    L23:
        if (r106.contains(r111.longValue()) == false) goto L25;
        r112 = true;
    L19:
        r111 = null;
    L13:
        r105 = 0;
    L7:
        r102 = 0;
        goto L8
    }

    public void z() {
        LinearLayout r100 = h();
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L7;
        r101.removeOnGlobalLayoutListener(this.f259172k);
    L7:
        Lazy r102 = MsgCenter.f260620a;
        MsgCenter.h(this.f259171j);
    }

    public com.bytedance.locallife.live.card.a g() {
        return this.f259164c;
    }

    public static /* synthetic */ void u(LiveLocalLifeCard r100) {
        r100.t("native", true, null);
    }

    public final void e(String r110) {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        String r103 = null;
        if (r102 == null) goto L5;
        LiveLocalLifeRoomInfo r104 = r102.getRoomInfo();
    L7:
        if (com.bytedance.locallife.live.goodsshelves.manager.h.f259722b == true) goto L9;
    L11:
        long r105 = 0;
    L12:
        Pair[] r106 = new Pair[4];
        r106[0] = TuplesKt.to("duration_time", String.valueOf(Math.max(0, (SystemClock.elapsedRealtime() - this.f259168g) - r105)));
        if (r104 == null) goto L15;
        String r107 = r104.getRoomId();
    L16:
        r106[1] = TuplesKt.to("room_id", r107);
        if (r104 == null) goto L19;
        r103 = r104.getAnchorId();
    L19:
        r106[2] = TuplesKt.to("anchor_id", r103);
        r106[3] = TuplesKt.to("dismiss_reason", r110);
        Map r111 = MapsKt.mapOf(r106);
        int r108 = qv6.e.f534905a;
        qv6.e.a("live_life_card_show_duration", r111, true, this.f259162a);
        this.f259168g = -1;
        this.f259169h = -1;
        Lazy r112 = MsgCenter.f260620a;
        MsgCenter.h(this.f259171j);
        w();
        return;
    L15:
        r107 = null;
        goto L16
    L9:
        if (this.f259169h <= 0) goto L11;
        r105 = SystemClock.elapsedRealtime() - this.f259169h;
        goto L12
    L5:
        r104 = null;
        goto L7
    }

    public static /* synthetic */ void b(LiveLocalLifeBaseCard r100, nv6.n r101) {
        r100.a(r101, 1);
    }

    public void a(nv6.n r100, int r101) {
        this.f259173l = r100;
    }

    public final void c(String r210, Map<String, String> r211) {
        Map<String, String> r100 = r211;
        com.bytedance.locallife.live.card.f r101 = this.f259166e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        String r104 = null;
        nv6.t r105 = null;
        String r106 = null;
        r104 = null;
        if (r103 == false) goto L20;
        com.bytedance.locallife.live.card.f r107 = this.f259166e;
        if (r107 == null) goto L229;
        JSONObject r108 = new JSONObject();
        JSONObject r109 = new JSONObject();
        r109.put("from", "card_button");
        r109.put("action", "jump_by_card_button");
        JSONObject r110 = new JSONObject();
        r110.put("group_purchase_card_info", com.bytedance.locallife.live.util.h.c(LiveLifeSaaSUtil.r(), k(), "preview_card_button", 2));
        Gson r111 = LiveLifeSaaSUtil.r();
        com.bytedance.locallife.live.card.a r112 = g();
        if (r112 == null) goto L15;
        r105 = r112.f259214c;
    L15:
        r110.put("group_purchase_extra", com.bytedance.locallife.live.util.h.c(r111, r105, "preview_card_button", 2));
        r110.put("event_from", r210);
        if (r100 != null) goto L18;
        r100 = MapsKt.emptyMap();
    L18:
        r110.put("life_extra_info_map", new JSONObject(r100));
        Unit r113 = Unit.INSTANCE;
        r109.put("group_purchase_card_params", r110);
        r108.put("preview_params", r109);
        r107.j(r108.toString());
        return;
    L229:
        return;
    L20:
        LiveLocalLifeRoomInfo r114 = LiveLocalLifeUtil.e(this.f259162a);
        String r115 = this.f259162a;
        nv6.n r116 = k();
        com.bytedance.locallife.live.card.a r117 = g();
        if (r117 == null) goto L23;
        nv6.t r118 = r117.f259214c;
    L24:
        Activity r119 = this.f259163b;
        Pair[] r120 = new Pair[5];
        r120[0] = TuplesKt.to("life_req_id", r114.getRequestId());
        r120[1] = TuplesKt.to("life_room_id", r114.getRoomId());
        nv6.n r121 = k();
        if (r121 == null) goto L30;
        nv6.p r122 = r121.a();
        if (r122 == null) goto L30;
        String r123 = r122.q();
        if (r123 == null) goto L30;
    L31:
        r120[2] = TuplesKt.to("life_product_id", r123);
        r120[3] = TuplesKt.to("enter_from", r114.getEnterFromMerge());
        r120[4] = TuplesKt.to("enter_method", r114.getEnterMethod());
        String r124 = com.bytedance.locallife.biz.btm.c.b(r119, "c2627.d6587", MapsKt.mutableMapOf(r120));
        Intrinsics.checkNotNullParameter(r115, "uniqueKey");
        Intrinsics.checkNotNullParameter(r210, "eventFrom");
        FragmentActivity r125 = com.bytedance.locallife.live.util.o.a(r115);
        if (r125 == null) goto L231;
        if (r116 == null) goto L43;
        nv6.p r126 = r116.a();
        if (r126 == null) goto L43;
        Integer r127 = r126.t();
        if (r127 == null) goto L43;
        if (r127.intValue() != 20) goto L43;
        boolean r128 = true;
    L45:
        if (r128 == false) goto L72;
        Map r129 = MapsKt.mapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_PAGE, "livebroadcasting"), TuplesKt.to(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_METHOD, "click_promotion_card_mini")});
        int r130 = com.bytedance.locallife.live.util.p.f260728a;
        if (r116 == null) goto L49;
        nv6.p r131 = r116.a();
    L50:
        Intrinsics.checkNotNull(r129, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        com.bytedance.locallife.live.util.p.e(r115, r131, (HashMap) r129, r100);
        int r132 = com.bytedance.locallife.live.util.r.f260730a;
        if (r116 == null) goto L55;
        nv6.p r133 = r116.a();
        if (r133 == null) goto L55;
        String r134 = r133.A();
    L57:
        if (r116 == null) goto L64;
        nv6.p r135 = r116.a();
        if (r135 == null) goto L64;
        String r136 = r135.q();
        if (r136 == null) goto L64;
        String r137 = r136;
    L66:
        if (r118 == null) goto L68;
        String r138 = r118.c();
    L69:
        if (r118 == null) goto L71;
        r106 = r118.d();
    L71:
        com.bytedance.locallife.live.util.r.h(r115, r125, r134, "live_popup_card", r137, "button", r138, r106, r129);
        return;
    L68:
        r138 = null;
    L64:
        r137 = "";
    L55:
        r134 = null;
        goto L57
    L49:
        r131 = null;
        goto L50
    L72:
        String r139 = a.a(r115, r116, MapsKt.mapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_PAGE, "livebroadcasting"), TuplesKt.to(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_METHOD, "click_promotion_card")}), r210, r100);
        if (r116 == null) goto L77;
        nv6.p r140 = r116.a();
        if (r140 == null) goto L77;
        String r141 = r140.A();
    L78:
        if (r141 != null) goto L80;
    L83:
        boolean r142 = true;
    L84:
        if (r142 == false) goto L90;
        if (r116 == null) goto L89;
        nv6.p r143 = r116.a();
        if (r143 == null) goto L89;
        r141 = r143.M();
    L89:
        r141 = null;
    L90:
        int r144 = com.bytedance.locallife.live.util.r.f260730a;
        if (r116 == null) goto L95;
        nv6.p r145 = r116.a();
        if (r145 == null) goto L95;
        GroupPurchaseFlashSale r146 = r145.p();
    L96:
        if (r116 == null) goto L100;
        nv6.p r147 = r116.a();
        if (r147 == null) goto L100;
        String r148 = r147.g();
    L101:
        JSONObject r149 = com.bytedance.locallife.live.util.r.b(r141, r146, r148);
        if (r116 == null) goto L108;
        nv6.p r150 = r116.a();
        if (r150 == null) goto L108;
        DisplayControl r151 = r150.m();
        if (r151 == null) goto L108;
        String r152 = r151.getButtonJumpUrl();
    L109:
        if (r152 != null) goto L111;
    L114:
        boolean r153 = true;
    L115:
        if (r153 == false) goto L121;
        if (r116 == null) goto L120;
        nv6.p r154 = r116.a();
        if (r154 == null) goto L120;
        r152 = r154.A();
    L120:
        String r155 = null;
    L122:
        if (r116 == null) goto L128;
        nv6.p r156 = r116.a();
        if (r156 == null) goto L128;
        DisplayControl r157 = r156.m();
        if (r157 == null) goto L128;
        Integer r158 = r157.getButtonJumpType();
    L129:
        if (r158 != null) goto L132;
    L188:
        nv6.n r159 = r116;
        String r212 = r115;
        if (r159 == null) goto L193;
        nv6.p r160 = r159.a();
        if (r160 == null) goto L193;
        String r161 = r160.g();
    L194:
        if (r159 == null) goto L198;
        nv6.p r162 = r159.a();
        if (r162 == null) goto L198;
        String r163 = r162.q();
    L199:
        String r164 = com.bytedance.locallife.live.util.r.d(r212, r161, r163, r149.toString(), "live_card", r139, r155, r124);
    L201:
        if (LiveLifeSaaSUtil.A() == false) goto L203;
        int r165 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("good_order_schema_card", MapsKt.mapOf(TuplesKt.to("schema", r164)));
    L203:
        int r166 = com.bytedance.locallife.live.util.t.f260731a;
        if (r159 == null) goto L208;
        nv6.p r167 = r159.a();
        if (r167 == null) goto L208;
        String r168 = r167.q();
    L209:
        if (r159 == null) goto L213;
        nv6.p r169 = r159.a();
        if (r169 == null) goto L213;
        r104 = r169.e();
    L213:
        String r170 = r212;
        com.bytedance.locallife.live.util.t.e(r170, r168, r104);
        if (r164.length() != 0) goto L216;
        r102 = true;
    L216:
        if (r102 == false) goto L227;
        ICurrentInteractionUiAction r171 = ((ILiveService) jc1.k.n(ILiveService.class)).getCurrentInteractionUiAction();
        if (r171 == null) goto L227;
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r172 = LiveLocalLifeViewModel.Companion.a(r170);
        if (r172 == null) goto L225;
        LiveLocalLifeRoomInfo r173 = r172.getRoomInfo();
        if (r173 == null) goto L225;
        String r174 = r173.getRoomId();
        if (r174 == null) goto L225;
    L226:
        r171.showInteractionAndEnterRoom(r174);
    L225:
        r174 = "";
    L227:
        LiveLifeSaaSUtil.j().s(r164);
        LiveLocalLifeUtil.k(r164, r125);
        b0.a(r170, "enterLifeOrderPage", "explain_button", r164);
        return;
    L208:
        r168 = null;
    L198:
        r163 = null;
    L193:
        r161 = null;
        goto L194
    L132:
        if (r158.intValue() != 2) goto L188;
        if (r116 == null) goto L139;
        nv6.p r175 = r116.a();
        if (r175 == null) goto L139;
        DisplayControl r176 = r175.m();
        if (r176 == null) goto L139;
        String r177 = r176.getButtonJumpUrl();
    L140:
        if (r177 != null) goto L142;
    L145:
        boolean r178 = true;
    L146:
        if (r178 == true) goto L188;
        if (Intrinsics.areEqual(r210, "native") == false) goto L150;
    L151:
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r179 = LiveLocalLifeViewModel.Companion.a(r115);
        if (r179 == null) goto L159;
        qv6.h r180 = r179.getLiveLocalLifeCardTracker();
        if (r180 == null) goto L159;
        if (r116 == null) goto L157;
        nv6.p r181 = r116.a();
    L158:
        r180.g(r125, r181, "life_member_entrance_click");
        goto L159
    L157:
        r181 = null;
    L159:
        if (r116 == null) goto L163;
        nv6.p r182 = r116.a();
        if (r182 == null) goto L163;
        String r183 = r182.g();
    L164:
        if (r116 == null) goto L168;
        nv6.p r184 = r116.a();
        if (r184 == null) goto L168;
        String r185 = r184.q();
    L169:
        if (r118 == null) goto L176;
        Long r186 = r118.a();
        if (r186 == null) goto L176;
        String r187 = r186.toString();
        if (r187 == null) goto L176;
        String r188 = r187;
    L177:
        if (r116 == null) goto L181;
        nv6.p r189 = r116.a();
        if (r189 == null) goto L181;
        Integer r190 = r189.o();
    L182:
        if (r116 == null) goto L186;
        nv6.p r191 = r116.a();
        if (r191 == null) goto L186;
        Integer r192 = r191.b();
    L187:
        Integer r193 = r192;
        r159 = r116;
        r212 = r115;
        r164 = com.bytedance.locallife.live.util.r.e(r115, r183, r185, r188, r190, r193, r149.toString(), "live_card", r139, r155, r124);
    L186:
        r192 = null;
    L181:
        r190 = null;
    L176:
        r188 = "";
    L168:
        r185 = null;
    L163:
        r183 = null;
        goto L164
    L150:
        if (com.bytedance.locallife.live.settings.c.j() == false) goto L159;
    L142:
        if (r177.length() == 0) goto L145;
        r178 = false;
    L139:
        r177 = null;
    L128:
        r158 = null;
    L121:
        r155 = r152;
        goto L122
    L111:
        if (r152.length() == 0) goto L114;
        r153 = false;
    L108:
        r152 = null;
    L100:
        r148 = null;
    L95:
        r146 = null;
        goto L96
    L80:
        if (r141.length() == 0) goto L83;
        r142 = false;
    L77:
        r141 = null;
    L43:
        r128 = false;
        goto L45
    L231:
        return;
    L30:
        r123 = "";
        goto L31
    L23:
        r118 = null;
        goto L24
    L5:
        if (r101.isPreview() != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void d(String r210, Map<String, String> r211) {
        Map<String, String> r100 = r211;
        nv6.n r101 = k();
        if (r101 == null) goto L85;
        nv6.p r102 = r101.a();
        if (r102 == null) goto L88;
        qs6.b r103 = LiveLifeSaaSUtil.t();
        StringBuilder r104 = new StringBuilder("click card with lynxurl = ");
        String r105 = r102.v();
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r104.append(r105);
        r104.append(", with weburl = ");
        String r106 = r102.M();
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r104.append(r106);
        r103.i("LiveLocalLifeCard", r104.toString());
        com.bytedance.locallife.live.card.f r107 = this.f259166e;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L32;
        com.bytedance.locallife.live.card.f r109 = this.f259166e;
        if (r109 == null) goto L84;
        JSONObject r110 = new JSONObject();
        JSONObject r111 = new JSONObject();
        r111.put("from", "card_container");
        r111.put("action", "jump_by_card_container");
        JSONObject r112 = new JSONObject();
        r112.put("group_purchase_card_info", com.bytedance.locallife.live.util.h.c(LiveLifeSaaSUtil.r(), k(), "preview_card_button", 2));
        Gson r113 = LiveLifeSaaSUtil.r();
        com.bytedance.locallife.live.card.a r114 = g();
        if (r114 == null) goto L26;
        nv6.t r115 = r114.f259214c;
    L27:
        r112.put("group_purchase_extra", com.bytedance.locallife.live.util.h.c(r113, r115, "preview_card_button", 2));
        r112.put("event_from", r210);
        if (r100 != null) goto L30;
        r100 = MapsKt.emptyMap();
    L30:
        r112.put("life_extra_info_map", new JSONObject(r100));
        Unit r116 = Unit.INSTANCE;
        r111.put("group_purchase_card_params", r112);
        r110.put("preview_params", r111);
        r109.j(r110.toString());
        return;
    L26:
        r115 = null;
        goto L27
    L84:
        return;
    L32:
        LiveLocalLifeRoomInfo r117 = LiveLocalLifeUtil.e(this.f259162a);
        String r118 = this.f259162a;
        nv6.n r119 = k();
        com.bytedance.locallife.live.card.a r120 = g();
        if (r120 == null) goto L35;
        nv6.t r121 = r120.f259214c;
    L36:
        Activity r122 = this.f259163b;
        Pair[] r123 = new Pair[5];
        r123[0] = TuplesKt.to("life_req_id", r117.getRequestId());
        r123[1] = TuplesKt.to("life_room_id", r117.getRoomId());
        nv6.n r124 = k();
        if (r124 == null) goto L42;
        nv6.p r125 = r124.a();
        if (r125 == null) goto L42;
        String r126 = r125.q();
        if (r126 == null) goto L42;
    L43:
        r123[2] = TuplesKt.to("life_product_id", r126);
        r123[3] = TuplesKt.to("enter_from", r117.getEnterFromMerge());
        r123[4] = TuplesKt.to("enter_method", r117.getEnterMethod());
        String r212 = com.bytedance.locallife.biz.btm.c.b(r122, "c2627.d4434", MapsKt.mutableMapOf(r123));
        Intrinsics.checkNotNullParameter(r118, "uniqueKey");
        Intrinsics.checkNotNullParameter(r210, "eventFrom");
        FragmentActivity r127 = com.bytedance.locallife.live.util.o.a(r118);
        if (r127 == null) goto L89;
        if (r119 == null) goto L86;
        nv6.p r128 = r119.a();
        if (r128 == null) goto L90;
        qs6.b r129 = LiveLifeSaaSUtil.t();
        StringBuilder r130 = new StringBuilder("click card with lynxurl = ");
        String r131 = r128.v();
        if (r131 != null) goto L53;
        r131 = "";
    L53:
        r130.append(r131);
        r130.append(", with weburl = ");
        String r132 = r128.M();
        if (r132 != null) goto L56;
        r132 = "";
    L56:
        r130.append(r132);
        r129.i("LiveLocalLifeCard", r130.toString());
        Integer r133 = r128.t();
        if (r133 != null) goto L60;
    L74:
        int r134 = com.bytedance.locallife.live.util.r.f260730a;
        JSONObject r135 = com.bytedance.locallife.live.util.r.b(r128.M(), r128.p(), r128.g());
        int r136 = com.bytedance.locallife.live.util.t.f260731a;
        nv6.p r137 = r119.a();
        if (r137 == null) goto L77;
        String r138 = r137.q();
    L78:
        nv6.p r139 = r119.a();
        if (r139 == null) goto L81;
        String r140 = r139.e();
    L82:
        com.bytedance.locallife.live.util.t.e(r118, r138, r140);
        String r141 = a.a(r118, r119, MapsKt.mapOf(new Pair[]{TuplesKt.to("detail_enter_page", "livebroadcasting"), TuplesKt.to("detail_enter_method", "click_promotion_card")}), r210, r100);
        int r142 = com.bytedance.locallife.live.util.f.f260701a;
        com.bytedance.locallife.live.util.f.a(r118, r127, r128.v(), r135.toString(), r141, false, null, null, r212, false, 192);
        return;
    L81:
        r140 = null;
        goto L82
    L77:
        r138 = null;
        goto L78
    L60:
        if (r133.intValue() != 20) goto L74;
        Map r143 = MapsKt.mapOf(new Pair[]{TuplesKt.to("detail_enter_page", "livebroadcasting"), TuplesKt.to("detail_enter_method", "click_promotion_card_mini")});
        int r144 = com.bytedance.locallife.live.util.p.f260728a;
        nv6.p r145 = r119.a();
        Intrinsics.checkNotNull(r143, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        com.bytedance.locallife.live.util.p.e(r118, r145, (HashMap) r143, r100);
        int r146 = com.bytedance.locallife.live.util.r.f260730a;
        String r147 = r128.M();
        nv6.p r148 = r119.a();
        if (r148 == null) goto L65;
        String r149 = r148.q();
        if (r149 == null) goto L65;
    L67:
        if (r121 == null) goto L69;
        String r150 = r121.c();
    L70:
        if (r121 == null) goto L72;
        String r151 = r121.d();
    L73:
        com.bytedance.locallife.live.util.r.h(r118, r127, r147, "live_popup_card", r149, BrowserDependency.UrlClickType.CARD, r150, r151, r143);
        return;
    L72:
        r151 = null;
        goto L73
    L69:
        r150 = null;
    L65:
        r149 = "";
        goto L67
    L90:
        return;
    L86:
        return;
    L89:
        return;
    L42:
        r126 = "";
        goto L43
    L35:
        r121 = null;
        goto L36
    L16:
        if (r107.isPreview() != true) goto L18;
        r108 = true;
        goto L20
    L88:
        return;
    }

    public final void s(final String r100, boolean r101, final Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventFrom");
        com.bytedance.locallife.live.util.m r103 = com.bytedance.locallife.live.util.n.f260724a;
        LinkedHashMap r104 = new LinkedHashMap();
        nv6.n r105 = k();
        if (r105 == null) goto L8;
        nv6.p r106 = r105.a();
        if (r106 == null) goto L8;
        String r107 = r106.g();
        if (r107 == null) goto L8;
    L9:
        r104.put("card_id", r107);
        Unit r108 = Unit.INSTANCE;
        com.bytedance.locallife.live.util.n.a("card_click", r104);
        nv6.n r109 = k();
        if (r109 == null) goto L14;
        nv6.p r110 = r109.a();
        if (r110 == null) goto L14;
        final DrawTicketParamsInfo r111 = r110.n();
    L15:
        if (r111 == null) goto L17;
        String r112 = r111.getDrawTicketParams();
    L19:
        if (com.bytedance.locallife.live.util.s.d(r112) == false) goto L22;
        if (r101 == false) goto L22;
        LiveLocalLifeUtil.a(this.f259163b, new LiveLocalLifeBaseCard$jumpToGoodsDetailPage$2(this, r111, r100, r102), null);
        return;
    L22:
        d(r100, r102);
        return;
    L17:
        r112 = null;
    L14:
        r111 = null;
    L8:
        r107 = "";
        goto L9
    }

    public final void t(String r110, boolean r210, Map<String, String> r211) {
        Intrinsics.checkNotNullParameter(r110, "eventFrom");
        if ((this.f259163b instanceof FragmentActivity) == true) goto L5;
        return;
    L5:
        com.bytedance.locallife.live.util.m r100 = com.bytedance.locallife.live.util.n.f260724a;
        LinkedHashMap r101 = new LinkedHashMap();
        nv6.n r102 = k();
        if (r102 == null) goto L11;
        nv6.p r103 = r102.a();
        if (r103 == null) goto L11;
        String r104 = r103.g();
        if (r104 == null) goto L11;
    L12:
        r101.put("card_id", r104);
        Unit r105 = Unit.INSTANCE;
        com.bytedance.locallife.live.util.n.a("card_button_click", r101);
        nv6.n r106 = k();
        String r107 = null;
        if (r106 == null) goto L17;
        nv6.p r108 = r106.a();
        if (r108 == null) goto L17;
        DrawTicketParamsInfo r109 = r108.n();
    L18:
        if (r109 == null) goto L20;
        String r111 = r109.getDrawTicketParams();
    L22:
        if (com.bytedance.locallife.live.util.s.d(r111) == false) goto L28;
        if (r210 == false) goto L28;
        Api r112 = com.bytedance.locallife.live.api.a.f259156a;
        String r113 = this.f259162a;
        if (r109 == null) goto L27;
        r107 = r109.getDrawTicketParams();
    L27:
        com.bytedance.locallife.live.api.a.a(r113, "", null, null, null, null, null, null, null, null, r107, 1020).subscribe(new e(this, r110, r211), new f(this, r110, r211, r109));
        return;
    L28:
        c(r110, r211);
        return;
    L20:
        r111 = null;
    L17:
        r109 = null;
    L11:
        r104 = "";
        goto L12
    }

    public LiveLocalLifeBaseCard(String r100, Activity r101, com.bytedance.locallife.live.card.a r102, IRoomState r103, b r104, com.bytedance.locallife.live.card.f r105) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r104, "closeListener");
        this.f259162a = r100;
        this.f259163b = r101;
        this.f259164c = r102;
        this.f259165d = r103;
        this.f259166e = r105;
        this.f259168g = -1;
        this.f259169h = -1;
        this.f259171j = new com.bytedance.locallife.live.msgcenter.b("event_clear_screen_mode_change", null, new c(this));
        this.f259172k = new g(this);
    }
}
