package com.ss.android.dypay.activity.f;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.android.ttcjpaysdk.bdpay.counter.outer.CJCallbackOuterManager;
import com.android.ttcjpaysdk.bdpay.counter.outer.base.CJOuterBaseProcessor;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.dypay.activity.DyPayEntranceActivity;
import com.ss.android.dypay.activity.DyPayH5Activity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.dypay.utils.DyActivityResultMonitor;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements qta.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f408412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f408413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f408414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f408415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f408416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f408417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Map<String, String> f408418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Map<String, String> f408419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public rta.b f408420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public rta.d f408421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public rta.e f408422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qta.d f408423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final qta.b f408424m;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f408425a;

        public a(i r100, String r101) {
            this.f408425a = r100;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            i r100 = this.f408425a;
            e.a r101 = e.a.f408387b;
            vta.b r102 = r100.f408424m.c();
            if (r102 == null) goto L5;
            vta.a r103 = r102.f557255h;
        L6:
            r100.d(r101, r103);
            rta.b r104 = this.f408425a.f408420i;
            if (r104 == null) goto L10;
            r104.b();
        L10:
            return Unit.INSTANCE;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b extends Lambda implements Function2<e.a, vta.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f408426a;

        public b(i r100, String r101) {
            this.f408426a = r100;
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(e.a r100, vta.a r101) {
            i r102 = this.f408426a;
            r102.d(r100, r101);
            rta.b r103 = this.f408426a.f408420i;
            if (r103 == null) goto L6;
            r103.b();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f408427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f408428b;

        public c(i r100, Function2 r101) {
            this.f408427a = r100;
            this.f408428b = r101;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            if (r101 == false) goto L5;
            e.a r102 = e.a.f408388c;
        L6:
            if (r101 == false) goto L11;
            vta.b r103 = this.f408427a.f408424m.c();
            if (r103 == null) goto L10;
            vta.a r104 = r103.f557255h;
        L12:
            this.f408428b.invoke(r102, r104);
            return Unit.INSTANCE;
        L10:
            r104 = null;
            goto L12
        L11:
            r104 = new vta.a(1, "https://cashier.douyinpay.com/bytepay-cashdesk/h5-ssr/open-v0.html?hide_title_bar=1&disable_bounce=1&trans_status_bar=1");
            goto L12
        L5:
            r102 = e.a.f408389d;
            goto L6
        }
    }

    public static final class d implements com.ss.android.dypay.utils.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f408429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.d f408430b;

        public d(i r100, e.d r101) {
            this.f408429a = r100;
            this.f408430b = r101;
        }

        @Override // com.ss.android.dypay.utils.i.a
        public final void b() {
            i.h(this.f408429a, this.f408430b);
        }

        @Override // com.ss.android.dypay.utils.i.a
        public final void a() {
            i r100 = this.f408429a;
            vta.b r101 = r100.f408424m.c();
            if (r101 == null) goto L11;
            vta.h r102 = r101.f557248a;
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.f557280h != true) goto L13;
            new Handler().post(new qta.g(r100));
            return;
        L13:
            return;
        }

        @Override // com.ss.android.dypay.utils.i.a
        public final void a(String r110) {
            i r100 = this.f408429a;
            e.d r101 = this.f408430b;
            r100.f408414c = true;
            com.ss.android.dypay.utils.e.a r102 = r100.m();
            k r103 = new k(r100);
            int r104 = r102.ordinal();
            if (r104 == 0) goto L10;
            if (r104 != 1) goto L6;
            String r105 = "com.ss.android.ugc.aweme.lite";
        L11:
            Intent r106 = new Intent();
            r106.setComponent(new ComponentName(r105, CJOuterBaseProcessor.DY_PAY_ROOTER_ACTIVITY_CLASS));
            r103.invoke(r106);
            DyPayEntranceActivity r107 = r100.f408423l.b();
            qta.f r108 = new qta.f(r100, r101);
            qta.a.f(r107, r106, 2000, new com.ss.android.dypay.utils.i.b(r108), new com.ss.android.dypay.utils.i.c(r108), new com.ss.android.dypay.utils.i.d(r108));
            com.ss.android.dypay.base.d r109 = com.ss.android.dypay.base.d.f408440g;
            if (r109 == null) goto L16;
            Map<String, Object> r111 = r109.f408446f;
            if (r111 == null) goto L16;
            r111.put("intent_type", 4);
        L16:
            JSONObject r112 = sta.a.f543575a;
            sta.a.g("start_activity_exception_first_launch: " + r110);
            return;
        L6:
            if (r104 != 2) goto L10;
            r105 = "com.ss.android.ugc.live";
        L10:
            r105 = "com.ss.android.ugc.aweme";
            goto L11
        }
    }

    public static final class f extends Lambda implements Function1<Intent, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f408431a;

        public f(i r100) {
            this.f408431a = r100;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Intent r100) {
            i r101 = this.f408431a;
            i.f(r101, r100);
            return Unit.INSTANCE;
        }
    }

    public i(qta.d r100, e r101) {
        this.f408423l = r100;
        this.f408424m = r101;
    }

    @Override // qta.c
    public final boolean a(int r100) {
        if (r100 == 0) goto L11;
        return false;
    L11:
        this.f408423l.b().runOnUiThread(new qta.e(this));     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        th.getStackTrace();
        return true;
    }

    public final void b() {
        int r100 = this.f408413b + 1;
        this.f408413b = r100;
        if (r100 <= 1) goto L12;
        e.a r101 = e.a.f408390e;
        vta.b r102 = this.f408424m.c();
        if (r102 == null) goto L7;
        vta.a r103 = r102.f557255h;
    L8:
        d(r101, r103);
        rta.b r104 = this.f408420i;
        if (r104 == null) goto L17;
        r104.b();
        return;
    L17:
        return;
    L7:
        r103 = null;
        goto L8
    L12:
        rta.b r105 = this.f408420i;
        if (r105 == null) goto L15;
        r105.c();
    L15:
        l("try_continue_pay", new a(this, "try_continue_pay"), new b(this, "try_continue_pay"));
    }

    public final com.ss.android.dypay.utils.e.a m() {
        com.ss.android.dypay.utils.e.a r100 = this.f408424m.a();
        rta.e r101 = this.f408422k;
        if (r101 == null) goto L66;
        com.ss.android.dypay.utils.e.a r102 = com.ss.android.dypay.utils.e.a.f408485a;
        DyPayEntranceActivity r103 = null;
        if (r100 == r102) goto L7;
    L17:
        if (r100 == r102) goto L19;
    L29:
        WeakReference<qta.b> r104 = r101.f539211b;
        if (r104 == null) goto L62;
        qta.b r105 = r104.get();
        if (r105 == null) goto L62;
        vta.b r106 = r105.c();
        if (r106 == null) goto L62;
        if (r106.f557252e != 2) goto L62;
        if (r100 != r102) goto L62;
        String r107 = com.ss.android.dypay.utils.e.f408484a;
        WeakReference<qta.d> r108 = r101.f539210a;
        if (r108 == null) goto L43;
        qta.d r109 = r108.get();
        if (r109 == null) goto L43;
        DyPayEntranceActivity r110 = r109.b();
    L45:
        if (com.ss.android.dypay.utils.e.a(r110, "com.ss.android.ugc.aweme.lite", "ttcjpay://dypay/awemelite", null) == false) goto L62;
        WeakReference<qta.d> r111 = r101.f539210a;
        if (r111 == null) goto L51;
        qta.d r112 = r111.get();
        if (r112 == null) goto L51;
        DyPayEntranceActivity r113 = r112.b();
    L53:
        if (Intrinsics.areEqual(com.ss.android.dypay.utils.e.c(r113, "com.ss.android.ugc.aweme.cjpay.loginstatus.provider"), Boolean.FALSE) == false) goto L62;
        WeakReference<qta.d> r114 = r101.f539210a;
        if (r114 == null) goto L60;
        qta.d r115 = r114.get();
        if (r115 == null) goto L60;
        r103 = r115.b();
    L60:
        if (Intrinsics.areEqual(com.ss.android.dypay.utils.e.c(r103, "com.ss.android.ugc.aweme.lite.cjpay.loginstatus.provider"), Boolean.TRUE) == false) goto L62;
    L61:
        com.ss.android.dypay.utils.e.a r116 = com.ss.android.dypay.utils.e.a.f408486b;
    L63:
        if (r116 != null) goto L65;
        return r100;
    L65:
        return r116;
    L51:
        r113 = null;
    L43:
        r110 = null;
    L62:
        r116 = r100;
        goto L63
    L19:
        if (rta.e.f539209c != e.b.f408395c) goto L29;
        String r117 = com.ss.android.dypay.utils.e.f408484a;
        WeakReference<qta.d> r118 = r101.f539210a;
        if (r118 == null) goto L25;
        qta.d r119 = r118.get();
        if (r119 == null) goto L25;
        DyPayEntranceActivity r120 = r119.b();
    L27:
        if (com.ss.android.dypay.utils.e.a(r120, "com.ss.android.ugc.live", "dypay8663://dypay/cashier", null) == false) goto L29;
        r116 = com.ss.android.dypay.utils.e.a.f408487c;
    L25:
        r120 = null;
        goto L27
    L7:
        if (rta.e.f539209c != e.b.f408394b) goto L17;
        String r121 = com.ss.android.dypay.utils.e.f408484a;
        WeakReference<qta.d> r122 = r101.f539210a;
        if (r122 == null) goto L13;
        qta.d r123 = r122.get();
        if (r123 == null) goto L13;
        DyPayEntranceActivity r124 = r123.b();
    L15:
        if (com.ss.android.dypay.utils.e.a(r124, "com.ss.android.ugc.aweme.lite", "ttcjpay://dypay/awemelite", null) == false) goto L17;
    L13:
        r124 = null;
        goto L15
    L66:
        return r100;
    }

    public final void c(Intent r100) {
        if (r100 == null) goto L27;
        String r101 = r100.getStringExtra("resultCode");
        if (r101 != null) goto L7;
        r101 = String.valueOf(2);
    L7:
        int r102 = r101.hashCode();
        if (r102 == 49587) goto L16;
        if (r102 == 49588) goto L13;
    L18:
        String r103 = r100.getStringExtra("errorMsg");
        if (r103 != null) goto L22;
        r103 = "unknown";
    L22:
        String r104 = r100.getStringExtra("extraParams");
        if (r104 != null) goto L26;
        r104 = "";
    L26:
        k(r101, r103, r104);
        return;
    L13:
        if (r101.equals("202") == false) goto L18;
        rta.e.f539209c = e.b.f408395c;
        e(e.d.f408401c, com.ss.android.dypay.utils.e.a.f408487c);
        return;
    L16:
        if (r101.equals("201") == false) goto L18;
        rta.e.f539209c = e.b.f408394b;
        e(e.d.f408401c, com.ss.android.dypay.utils.e.a.f408486b);
        return;
    L27:
        sta.a.g("onActivityPayResult_intent_null");
    }

    public static final void f(i r100, Intent r101) {
        r100.getClass();
        String r102 = "?payInfo=" + r100.f408424m.b();
        int r103 = r100.m().ordinal();
        if (r103 == 0) goto L23;
        if (r103 != 1) goto L6;
        StringBuilder r104 = new StringBuilder("ttcjpay://dypay/awemelite");
    L22:
        r104.append(r102);
        Uri r105 = UriProtector.parse(r104.toString());
    L38:
        r101.setData(r105);
        com.ss.android.dypay.activity.g.a r106 = new com.ss.android.dypay.activity.g.a(r100);
        Parcel r107 = Parcel.obtain();
        r106.writeToParcel(r107, 0);
        r107.setDataPosition(0);
        ResultReceiver r108 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r107);
        r107.recycle();
        r101.putExtra(CJOuterPayManager.KEY_HIDE_LOADING_CALLBACK, r108);
        com.ss.android.dypay.activity.g.b r109 = new com.ss.android.dypay.activity.g.b(r100);
        Parcel r110 = Parcel.obtain();
        r109.writeToParcel(r110, 0);
        r110.setDataPosition(0);
        ResultReceiver r111 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r110);
        r110.recycle();
        r101.putExtra(CJCallbackOuterManager.KEY_OPEN_DY_CALLBACK, r111);
        vta.b r112 = r100.f408424m.c();
        if (r112 != null) goto L41;
    L43:
        String r113 = "0";
    L44:
        r101.putExtra("support_login_opt", r113);
        Bundle r114 = new Bundle();
        vta.b r115 = r100.f408424m.c();
        if (r115 == null) goto L47;
        String r116 = r115.a();
    L48:
        r114.putString("cj_biz_tag", r116);
        r101.putExtras(r114);
        com.ss.android.dypay.base.d r117 = com.ss.android.dypay.base.d.f408440g;
        if (r117 == null) goto L101;
        Bundle r118 = new Bundle();
        r118.putString("clientSessionId", r117.f408441a);
        r118.putString("cjAppId", r117.f408443c);
        r118.putString("cjSource", "outer_pay");
        r118.putString("merchantId", r117.f408442b);
        r118.putLong("baselineTime", r117.f408444d);
        Map<String, Object> r119 = r117.f408446f;
        if (r119 == null) goto L78;
        Bundle r120 = new Bundle();
        Iterator<Map.Entry<String, Object>> r121 = r119.entrySet().iterator();
    L54:
        if (r121.hasNext() == false) goto L77;
        Map.Entry<String, Object> r122 = r121.next();
        String r123 = r122.getKey();
        Object r124 = r122.getValue();
        if (r124 == null) goto L54;
        if ((r124 instanceof Boolean) == true) goto L59;
        if ((r124 instanceof String) == true) goto L62;
        if ((r124 instanceof Integer) == false) goto L68;
        r120.putInt(r123, ((Number) r124).intValue());
        goto L54
    L68:
        if ((r124 instanceof Long) == false) goto L71;
        r120.putLong(r123, ((Number) r124).longValue());
        goto L54
    L71:
        if ((r124 instanceof Double) == false) goto L74;
        r120.putDouble(r123, ((Number) r124).doubleValue());
        goto L54
    L74:
        if ((r124 instanceof Float) == false) goto L76;
        r120.putFloat(r123, ((Number) r124).floatValue());
        goto L54
    L76:
        String r125 = "Type not supported: ".concat(r124.getClass().getName());
    L63:
        r120.putString(r123, r125);
        goto L54
    L62:
        r125 = (String) r124;
        goto L63
    L59:
        r120.putBoolean(r123, ((Boolean) r124).booleanValue());
        goto L54
    L77:
        r118.putBundle("eventParams", r120);
    L78:
        r101.putExtras(r118);
        return;
    L101:
        return;
    L47:
        r116 = null;
        goto L48
    L41:
        if (r112.f557252e != 1) goto L43;
        r113 = "1";
        goto L44
    L6:
        if (r103 == 2) goto L20;
        StringBuilder r126 = new StringBuilder();
        String r127 = com.ss.android.dypay.utils.e.f408484a;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
        if (r128 == (-557969986)) goto L18;
        if (r128 != 0) goto L36;
        if (r127.equals("") == false) goto L36;
    L32:
        String r129 = "ttcjpay://dypay/cashier";
    L37:
        r126.append(r129);
        r126.append(r102);
        r105 = UriProtector.parse(r126.toString());
        goto L38
    L18:
        if (r127.equals(IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY) == false) goto L36;
    L35:
        r129 = "ttcjpay://dypay/sign";
    L36:
        r129 = "dypay://aweme";
        goto L37
    L20:
        r104 = new StringBuilder("dypay8663://dypay/cashier");
        goto L22
    L23:
        r126 = new StringBuilder();
        String r130 = com.ss.android.dypay.utils.e.f408484a;
        if (r130 == null) goto L36;
        int r131 = r130.hashCode();
        if (r131 == (-557969986)) goto L34;
        if (r131 != 0) goto L36;
        if (r130.equals("") == false) goto L36;
    L34:
        if (r130.equals(IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY) == false) goto L36;
        goto L35
    }

    public static final void h(i r100, e.d r101) {
        i(r100, "start_activity_success", null, null, null, 14);
        rta.d r102 = r100.f408421j;
        if (r102 == null) goto L10;
        String r103 = r101.f408405a;
        com.ss.android.dypay.utils.g r104 = r102.f539206c;
        if (r104 == null) goto L10;
        com.ss.android.dypay.utils.f r105 = r104.f408493b;
        if (r105 == null) goto L9;
        r105.cancel();
    L9:
        r104.f408492a = "CALLING";
        r104.f408494c = 0;
        com.ss.android.dypay.utils.f r106 = new com.ss.android.dypay.utils.f(r104, r103, r104.f408496e, r104.f408495d);
        r104.f408493b = r106;
        r106.start();
    L10:
        qta.a.d(r100.f408423l.b());
    }

    @Override // qta.c
    public final void a(int r100, Bundle r101) {
        rta.d r102 = this.f408421j;     // Catch: Throwable -> L15
        if (r102 != null) goto L5;
    L10:
        if (r102 == null) goto L20;
        com.ss.android.dypay.utils.g r103 = r102.f539206c;     // Catch: Throwable -> L15
        if (r103 == null) goto L21;
        r103.a(r100, r101);     // Catch: Throwable -> L15
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r100 != 1000) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L10;
        this.f408416e = true;     // Catch: Throwable -> L15
        goto L10
    L7:
        r104 = false;
    L15:
        th = move-exception;
        th.getStackTrace();
    }

    public final void d(e.a r110, vta.a r111) {
        if (r111 == null) goto L5;
        String r100 = r111.f557247b;
    L7:
        if (r100 != null) goto L9;
    L11:
        if (r100 != null) goto L14;
    L13:
        r100 = "https://cashier.douyinpay.com/bytepay-cashdesk/h5-ssr/open-v0.html?hide_title_bar=1&disable_bounce=1&trans_status_bar=1";
    L14:
        int r101 = DyPayH5Activity.f408351v;
        DyPayEntranceActivity r102 = this.f408423l.b();
        String r103 = this.f408424m.b();
        boolean r104 = true ^ this.f408416e;
        Map<String, String> r105 = this.f408418g;
        Map<String, String> r106 = this.f408419h;
        String r107 = DyPayH5Activity.a.a(r103);
        String r108 = new JSONObject(r103).optString("sdk_ext");     // Catch: JSONException -> L17
    L18:
        if (r102 == null) goto L31;
        Intent r109 = new Intent(r102, DyPayH5Activity.class);
        r109.putExtra("url", r100);
        r109.putExtra("payInfo", r107);
        r109.putExtra("scene", "try_continue_pay");
        r109.putExtra(DownloadConstants.KEY_TOAST, r104);
        if (r105 != null) goto L43;
    L25:
        if (r106 != null) goto L39;
    L30:
        r109.putExtra("sdk_ext", r108);
        qta.a.f(r102, r109, 3000, null, com.ss.android.dypay.activity.c.f408380a, null);
        goto L31
    L39:
        JSONObject r112 = new JSONObject(r106);     // Catch: Exception -> L28
    L29:
        r109.putExtra("monitor_reason", r112.toString());
    L28:
        r112 = new JSONObject();
        goto L29
    L43:
        JSONObject r113 = new JSONObject(r105);     // Catch: Exception -> L23
    L24:
        r109.putExtra("fail_reason", r113.toString());
    L23:
        r113 = new JSONObject();
    L31:
        JSONObject r114 = new JSONObject();
        r114.put("config_source", r110.f408392a);     // Catch: Exception -> L37
    L47:
        r114.put("from_source", "cancel");     // Catch: Exception -> L38
    L35:
        i(this, "open_h5", null, r114, null, 10);
        return;
    L17:
        r108 = "";
        goto L18
    L9:
        if (StringsKt.isBlank(r100) != true) goto L11;
    L5:
        r100 = null;
        goto L7
    }

    public final void e(e.d r110, com.ss.android.dypay.utils.e.a r111) {
        rta.b r100 = this.f408420i;
        Instrumentation r101 = null;
        boolean r102 = false;
        int r103 = 1;
        if (r100 == null) goto L32;
        WeakReference<qta.d> r104 = r100.f539200a;
        if (r104 == null) goto L9;
        qta.d r105 = r104.get();
        if (r105 == null) goto L9;
        DyPayEntranceActivity r106 = r105.b();
    L10:
        if (r106 == null) goto L32;
        WeakReference<qta.d> r107 = r100.f539200a;
        if (r107 == null) goto L22;
        qta.d r108 = r107.get();
        if (r108 == null) goto L22;
        Intent r109 = r108.c();
        if (r109 == null) goto L22;
        if (r109.getBooleanExtra(DyPayConstant.KEY_SHOW_LOADING, true) == true) goto L22;
        boolean r112 = false;
    L23:
        if (r112 == false) goto L32;
        rta.a r113 = r100.f539202c;
        if (r113 == null) goto L28;
        r113.cancel();
    L28:
        rta.a r114 = new rta.a(r100, r100.a());
        r100.f539202c = r114;
        r114.start();
        if (r110 == e.d.f408401c) goto L32;
        r100.c();
    L22:
        r112 = true;
    L9:
        r106 = null;
    L32:
        sta.a r115 = sta.a.f543576b;
        JSONObject r116 = new JSONObject();
        r116.put("trigger_from", r110.f408405a);     // Catch: Exception -> L35
    L36:
        sta.a.f(r115, "out_wallet_cashier_out_to_in", r116);
        this.f408416e = false;
        if (Build.VERSION.SDK_INT < 34) goto L69;
        vta.b r117 = this.f408424m.c();
        if (r117 == null) goto L69;
        vta.h r118 = r117.f557248a;
        if (r118 == null) goto L69;
        if (r118.f557279g != true) goto L69;
        rta.d r119 = this.f408421j;
        if (r119 == null) goto L69;
        com.ss.android.dypay.activity.f.f r120 = new com.ss.android.dypay.activity.f.f(this, r110);
        WeakReference<qta.d> r121 = r119.f539204a;
        if (r121 == null) goto L69;
        qta.d r122 = r121.get();
        if (r122 == null) goto L69;
        DyPayEntranceActivity r123 = r122.b();
        if (r123 == null) goto L69;
        if (r119.f539207d != null) goto L69;
        r119.f539207d = new DyActivityResultMonitor(new rta.c(r120));
        if (r119.f539208e == null) goto L163;
    L66:
        Instrumentation r124 = r119.f539208e;
        if (r124 == null) goto L69;
        r124.addMonitor(r119.f539207d);
        goto L69
    L163:
        Field r125 = Activity.class.getDeclaredField("mInstrumentation");     // Catch: Throwable -> L162
        r125.setAccessible(true);     // Catch: Throwable -> L162
        Object r126 = r125.get(r123);     // Catch: Throwable -> L162
        if ((r126 instanceof Instrumentation) == true) goto L63;
        r126 = null;
    L63:
        r101 = (Instrumentation) r126;     // Catch: Throwable -> L162
    L65:
        r119.f539208e = r101;
    L69:
        int r127 = com.ss.android.dypay.utils.i.f408500a;
        this.f408423l.b();
        vta.b r128 = this.f408424m.c();
        f r129 = new f(this);
        if (r128 == null) goto L76;
        vta.h r130 = r128.f557248a;
        if (r130 == null) goto L76;
        if (r130.f557273a != true) goto L76;
        boolean r131 = true;
    L78:
        if (r128 == null) goto L82;
        vta.h r132 = r128.f557248a;
        if (r132 == null) goto L82;
        boolean r133 = ArraysKt.contains(new String[]{"1", "2", "3"}, r132.f557275c);
    L83:
        if (r133 == false) goto L151;
        Intent r134 = com.ss.android.dypay.utils.i.a(r111, r129);
        if (r128 == null) goto L91;
        vta.h r135 = r128.f557248a;
        if (r135 == null) goto L91;
        String r136 = r135.f557275c;
        if (r136 == null) goto L91;
    L93:
        switch(r136.hashCode()) {
            case 49: goto L103;
            case 50: goto L99;
            case 51: goto L96;
            default: goto L145;
        };
    L145:
        Pair r137 = TuplesKt.to(r134, "0");
    L146:
        Intent r138 = (Intent) r137.component1();
        String r139 = r136 + '_' + ((String) r137.component2());
        com.ss.android.dypay.base.d r140 = com.ss.android.dypay.base.d.f408440g;
        if (r140 == null) goto L153;
        Map<String, Object> r141 = r140.f408446f;
        if (r141 == null) goto L153;
        r141.put("opt_call_type", r139);
    L153:
        Intent r142 = r138;
    L155:
        Integer r143 = Integer.valueOf(r103);
        com.ss.android.dypay.base.d r144 = com.ss.android.dypay.base.d.f408440g;
        if (r144 == null) goto L160;
        Map<String, Object> r145 = r144.f408446f;
        if (r145 == null) goto L160;
        r145.put("intent_type", r143);
    L160:
        DyPayEntranceActivity r146 = this.f408423l.b();
        d r147 = new d(this, r110);
        qta.a.f(r146, r142, 2000, new com.ss.android.dypay.utils.i.b(r147), new com.ss.android.dypay.utils.i.c(r147), new com.ss.android.dypay.utils.i.d(r147));
        return;
    L96:
        if (r136.equals("3") == false) goto L145;
        r134 = Intent.createChooser(r134, "");
    L101:
        r137 = TuplesKt.to(r134, r136);
        goto L146
    L99:
        if (r136.equals("2") == false) goto L145;
        r134.setAction("android.intent.action.SEND");
        goto L101
    L103:
        if (r136.equals("1") == false) goto L145;
        if (com.ss.android.dypay.utils.k.f() == false) goto L107;
    L144:
        r134.setAction("android.intent.action.SEND");
        r137 = TuplesKt.to(r134, "2");
        goto L146
    L107:
        if (com.ss.android.dypay.utils.k.c(AppConstants.CHANNEL_OPPO) == true) goto L144;
        if (com.ss.android.dypay.utils.k.e("oneplus") == false) goto L111;
    L114:
        boolean r148 = true;
    L115:
        if (r148 == true) goto L144;
        if (com.ss.android.dypay.utils.k.c(DimLocationCheckUtil.XIAOMI) == false) goto L120;
    L143:
        r137 = TuplesKt.to(Intent.createChooser(r134, ""), "3");
        goto L146
    L120:
        if (com.ss.android.dypay.utils.k.c("redmi") == true) goto L143;
        if (com.ss.android.dypay.utils.k.e(RomUtils.BRAND_HUAWEI) == false) goto L124;
    L127:
        boolean r149 = true;
    L128:
        if (r149 == true) goto L143;
        if (com.ss.android.dypay.utils.k.e(SmEditTextLeakOpt.SAMSUNG) == false) goto L132;
    L135:
        boolean r150 = true;
    L136:
        if (r150 == true) goto L143;
        if (com.ss.android.dypay.utils.k.e("realme") == false) goto L140;
    L141:
        r102 = true;
    L142:
        if (r102 == false) goto L145;
    L140:
        if (com.ss.android.dypay.utils.k.c("realme") == false) goto L142;
    L132:
        if (com.ss.android.dypay.utils.k.c(SmEditTextLeakOpt.SAMSUNG) == true) goto L135;
        r150 = false;
        goto L136
    L124:
        if (com.ss.android.dypay.utils.k.c(RomUtils.BRAND_HUAWEI) == true) goto L127;
        r149 = false;
        goto L128
    L111:
        if (com.ss.android.dypay.utils.k.c("oneplus") == true) goto L114;
        r148 = false;
    L91:
        r136 = "1";
        goto L93
    L151:
        if (r131 == false) goto L154;
        r138 = com.ss.android.dypay.utils.i.a(r111, r129);
        r103 = 2;
        goto L153
    L154:
        Intent r151 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r129.invoke(r151);
        r103 = 3;
        r142 = r151;
    L82:
        r133 = true;
    L76:
        r131 = false;
        goto L78
    }

    public final void j(String r100, c r101) {
        com.ss.android.dypay.bean.c r102 = this.f408424m.d();
        vta.e r103 = new vta.e(r102.f408458b, r102.f408457a, r102.f408459c);
        if (r100.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r103.f557263a = r100;
    L8:
        this.f408424m.b(this.f408423l.b(), r103, r101);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static final void g(i r110, e.a r111, vta.a r112) {
        r110.getClass();
        if (r112 == null) goto L5;
        int r100 = r112.f557246a;
    L6:
        String r101 = "";
        if (r100 != 1) goto L30;
        String r102 = com.ss.android.dypay.utils.b.f408479a;
        com.ss.android.dypay.utils.b.b(r110.f408423l.b(), false);
        if (r112 == null) goto L11;
        String r103 = r112.f557247b;
    L12:
        if (r103 != null) goto L14;
    L16:
        if (r103 != null) goto L19;
    L18:
        r103 = "https://cashier.douyinpay.com/bytepay-cashdesk/h5-ssr/open-v0.html?hide_title_bar=1&disable_bounce=1&trans_status_bar=1";
    L19:
        int r104 = DyPayH5Activity.f408351v;
        DyPayEntranceActivity r105 = r110.f408423l.b();
        String r106 = r110.f408424m.b();
        String r107 = DyPayH5Activity.a.a(r106);
        r101 = new JSONObject(r106).optString("sdk_ext");     // Catch: JSONException -> L22
    L23:
        if (r105 == null) goto L25;
        Intent r108 = new Intent(r105, DyPayH5Activity.class);
        r108.putExtra("url", r103);
        r108.putExtra("payInfo", r107);
        r108.putExtra("sdk_ext", r101);
        qta.a.f(r105, r108, 3000, null, com.ss.android.dypay.activity.b.f408379a, null);
    L25:
        JSONObject r109 = new JSONObject();
        r109.put("config_source", r111.f408392a);     // Catch: Exception -> L32
    L36:
        r109.put("from_source", "uninstall");     // Catch: Exception -> L33
    L29:
        i(r110, "open_h5", null, r109, null, 10);
        return;
    L14:
        if (StringsKt.isBlank(r103) != true) goto L16;
    L11:
        r103 = null;
        goto L12
    L30:
        r110.k(String.valueOf(2), "未安装抖音", "");
        sta.a.f(sta.a.f543576b, "out_wallet_cashier_uninstalled", new JSONObject());
        return;
    L5:
        r100 = 1;
        goto L6
    }

    public final void k(String r100, String r101, String r102) {
        com.ss.android.dypay.core.b.a r103 = com.ss.android.dypay.core.a.f408464c;
        if (r103 == null) goto L5;
        r103.onResult(MapsKt.mapOf(new Pair[]{TuplesKt.to("resultCode", r100), TuplesKt.to("errorMsg", r101), TuplesKt.to("extraParams", r102)}));
    L6:
        com.ss.android.dypay.core.a.f408464c = null;
        this.f408423l.b().finish();     // Catch: Throwable -> L9
        qta.a.d(this.f408423l.b());     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        sta.a.g("dypay_result_callback_null");
        goto L6
    }

    public final void l(String r100, Function0<Unit> r101, Function2<? super e.a, ? super vta.a, Unit> r110) {
        com.ss.android.dypay.bean.c r102 = this.f408424m.d();
        String r103 = r102.f408458b;
        String r104 = r102.f408457a;
        SharedPreferences r105 = vta.d.a();
        long r106 = 0;
        if (r105 == null) goto L5;
        r106 = r105.getLong(r103 + r104 + "last_update_time", 0);
    L5:
        vta.b r107 = vta.d.b(r103, r104);
        if (r107 == null) goto L8;
        int r108 = r107.f557251d;
    L9:
        long r109 = ((long) r108) * 1000;
        long r111 = System.currentTimeMillis();
        if (r107 != null) goto L12;
    L14:
        boolean r112 = false;
    L15:
        if (r112 == false) goto L17;
        r101.invoke();
        j(r100, null);
        return;
    L17:
        j(r100, new c(this, r110));
        return;
    L12:
        if ((r111 - r106) >= r109) goto L14;
        r112 = true;
        goto L15
    L8:
        r108 = AnnouncementViewModel.HOUR_DURATION;
        goto L9
    }

    public static void i(i r100, String r101, String r102, JSONObject r103, JSONObject r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        r102 = "";
    L5:
        String r104 = r102;
        if ((r111 & 4) == 0) goto L8;
        JSONObject r105 = null;
    L10:
        if ((r111 & 8) == 0) goto L12;
        JSONObject r106 = null;
    L13:
        r100.getClass();
        sta.a.e(SearchResultParam.ENTER_PAGE_TYPE_MIDDLE_PAGE, r101, r104, r105, r106, 32);
        return;
    L12:
        r106 = r110;
        goto L13
    L8:
        r105 = r103;
        goto L10
    }
}
