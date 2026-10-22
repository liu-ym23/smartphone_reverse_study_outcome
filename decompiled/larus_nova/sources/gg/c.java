package gg;

import android.text.TextUtils;
import cf.l;
import cf.w;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.common.impl.usertracker.ecmarketing.model.RecordActionResponse;
import com.bytedance.android.ec.common.impl.usertracker.repository.api.TrackerMarketingApi;
import com.bytedance.android.ec.model.ECMActionConditionData;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements IECUserTrackerService, of.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Map<String, hg.a>> f481088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Map<String, Map<String, hg.a>>> f481089b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, hg.a> f481090c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<hg.b, hg.b> f481091d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Disposable f481092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f481093f = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f481094a = null;

        static {
            f481094a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RecordActionResponse r101 = (RecordActionResponse) r100;
            if (r101.getStatusCode() != 0) goto L10;
            List<hg.b> r102 = r101.getSwitchList();
            if (r102 == null) goto L12;
            Iterator<T> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L13;
            hg.b r104 = (hg.b) r103.next();
            r104.f485000a = System.currentTimeMillis();
            c.f481091d.put(r104, r104);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f481095a = null;

        static {
            f481095a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public c() {
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void enterPage(of.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    static {
        f481093f = new c();
        f481088a = new ConcurrentHashMap();
        f481089b = new ConcurrentHashMap();
        f481090c = new ConcurrentHashMap();
        f481091d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final of.a getMarketingService() {
        return new gg.a();
    }

    @Override // com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService
    public final void leavePage(of.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f481090c.clear();
    }

    @Override // of.a
    public final void a(String r110, PostActionType r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "scene");
        int r100 = ig.a.f489698a;
        Intrinsics.checkNotNullParameter(r112, "scene");
        if (TextUtils.equals(r112, "live") == false) goto L11;
        int r101 = ECSdk.f48106a;
        l r102 = (l) ECSdk.a(l.class);
        if (r102 == null) goto L11;
        w r103 = r102.getRoomInfo();
        if (r103 == null) goto L11;
        Boolean r104 = r103.f23493c;
        if (r104 == null) goto L11;
        boolean r105 = r104.booleanValue();
    L12:
        if (r105 == true) goto L14;
        return;
    L14:
        Intrinsics.checkNotNullParameter(r112, "scene");
        if (TextUtils.equals("live", r112) == false) goto L21;
        int r106 = ECSdk.f48106a;
        l r107 = (l) ECSdk.a(l.class);
        if (r107 == null) goto L21;
        w r108 = r107.getRoomInfo();
        if (r108 == null) goto L21;
        String r109 = r108.f23491a;
    L23:
        if (TextUtils.isEmpty(r109) == true) goto L84;
        if (r109 == null) goto L90;
        ConcurrentHashMap<String, Map<String, hg.a>> r113 = f481088a;
        Map<String, hg.a> r114 = r113.get(r112);
        if (r114 == null) goto L29;
        hg.a r115 = r114.get(r110);
    L30:
        if (r115 != null) goto L37;
        Map<String, Map<String, hg.a>> r116 = f481089b.get(r112);
        if (r116 == null) goto L36;
        Map<String, hg.a> r117 = r116.get(r109);
        if (r117 == null) goto L36;
        r115 = r117.get(r110);
    L36:
        r115 = null;
    L37:
        if (r115 != null) goto L39;
        r115 = f481090c.get(r110);
    L39:
        ECMActionConditionData.a r118 = ig.a.a(r110);
        if (r118 != null) goto L43;
        return;
    L43:
        if (r115 != null) goto L65;
        r115 = new hg.a(r110);
        Integer r119 = r118.b();
        if (r119 != null) goto L48;
    L53:
        if (r119 != null) goto L56;
    L64:
        f481090c.put(r110, r115);
        goto L65
    L56:
        if (r119.intValue() != 2) goto L64;
        ConcurrentHashMap<String, Map<String, Map<String, hg.a>>> r120 = f481089b;
        Map<String, Map<String, hg.a>> r121 = r120.get(r112);
        if (r121 != null) goto L60;
        LinkedHashMap r122 = new LinkedHashMap();
        LinkedHashMap r123 = new LinkedHashMap();
        r123.put(r110, r115);
        Unit r124 = Unit.INSTANCE;
        r122.put(r109, r123);
        r120.put(r112, r122);
        goto L65
    L60:
        Map<String, hg.a> r125 = r121.get(r109);
        if (r125 != null) goto L63;
        r125 = new LinkedHashMap();
        r121.put(r109, r125);
    L63:
        r125.put(r110, r115);
        goto L65
    L48:
        if (r119.intValue() != 1) goto L53;
        Map<String, hg.a> r126 = r113.get(r112);
        if (r126 != null) goto L52;
        r126 = new LinkedHashMap();
        r113.put(r112, r126);
    L52:
        r126.put(r110, r115);
    L65:
        List<ECMActionConditionData.a.C0834a> r127 = r118.c();
        int r128 = gg.b.f481087a[r111.ordinal()];
        if (r128 == 1) goto L82;
        if (r128 != 2) goto L69;
        ArrayList r129 = new ArrayList();
        if (f481092e != null) goto L88;
        f481092e = com.bytedance.android.ec.core.rxjava.a.a(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new d(r115, r127, r112, r109, r110, r129), e.f481102a);
        return;
    L88:
        return;
    L69:
        if (r128 != 3) goto L91;
        Disposable r130 = f481092e;
        if (r130 != null) goto L74;
        return;
    L74:
        if (r130.isDisposed() == true) goto L86;
        Disposable r131 = f481092e;
        if (r131 == null) goto L78;
        r131.dispose();
    L78:
        f481092e = null;
        return;
    L86:
        return;
    L91:
        return;
    L82:
        b(r115, r127, r112, r109, r110, new ArrayList());
        return;
    L29:
        r115 = null;
        goto L30
    L90:
        return;
    L84:
        return;
    L21:
        r109 = null;
    L11:
        r105 = false;
        goto L12
    }

    public static void b(hg.a r100, List r101, String r110, String r111, String r112, List r113) {
        r100.f484998a++;
        if (r101 == null) goto L46;
        Iterator r102 = r101.iterator();
        int r103 = 1;
    L6:
        if (r102.hasNext() == false) goto L47;
        ECMActionConditionData.a.C0834a r104 = (ECMActionConditionData.a.C0834a) r102.next();
        if (r104 == null) goto L6;
        if (r100.f484998a < r104.a()) goto L14;
        if (CollectionsKt.contains(r100.f484999b, r104.c()) == true) goto L14;
    L19:
        String r105 = r104.c();
        Iterator<T> r106 = f481091d.values().iterator();
    L21:
        if (r106.hasNext() == false) goto L38;
        hg.b r107 = (hg.b) r106.next();
        if (Intrinsics.areEqual(r107.c(), r105) == false) goto L21;
        if (Intrinsics.areEqual(r107.d(), r110) == true) goto L31;
        if (Intrinsics.areEqual(r107.e(), r111) == true) goto L31;
        if (Intrinsics.areEqual(r107.a(), r112) == false) goto L21;
    L31:
        if (r107.f() == true) goto L21;
        if (r107.b() > 0) goto L35;
    L37:
        boolean r108 = false;
    L39:
        if (r108 == false) goto L6;
        String r109 = r104.c();
        if (r109 != null) goto L43;
        r109 = "";
    L43:
        r113.add(r109);
        if (r104.b() <= r103) goto L6;
        r103 = r104.b();
        goto L6
    L35:
        if (((System.currentTimeMillis() - r107.f485000a) / ((long) 1000)) <= r107.b()) goto L37;
    L38:
        r108 = true;
    L14:
        if (CollectionsKt.contains(r100.f484999b, r104.c()) == false) goto L6;
        if (r104.d() == false) goto L6;
        if ((r100.f484998a % r104.a()) != 0) goto L6;
    L47:
        List r114 = r113;
        if ((true ^ r114.isEmpty()) == true) goto L50;
        return;
    L50:
        if (Random.Default.nextInt(2, 100) > r103) goto L114;
        ((ArrayList) r100.f484999b).addAll(r114);
        Iterator r115 = r113.iterator();
        String r116 = null;
        String r117 = null;
    L53:
        if (r115.hasNext() == false) goto L59;
        String r118 = (String) r115.next();
        if (TextUtils.isEmpty(r117) == true) goto L58;
        r118 = r117 + ',' + r118;
    L58:
        r117 = r118;
        goto L53
    L59:
        r113.clear();
        ECMActionConditionData.a r119 = ig.a.a(r112);
        if (r119 == null) goto L62;
        Integer r120 = r119.d();
    L63:
        TrackerMarketingApi.f43588a.getClass();
        TrackerMarketingApi r121 = TrackerMarketingApi.a.f43589a;
        Intrinsics.checkNotNull(r117);
        Intrinsics.checkNotNullParameter(r110, "scene");
        if (TextUtils.equals("live", r110) == false) goto L77;
        JSONObject r122 = new JSONObject();
        int r123 = ECSdk.f48106a;
        l r124 = (l) ECSdk.a(l.class);
        if (r124 == null) goto L70;
        w r125 = r124.getRoomInfo();
        if (r125 == null) goto L70;
        String r126 = r125.f23491a;
    L71:
        r122.putOpt("room_id", r126);
        l r127 = (l) ECSdk.a(l.class);
        if (r127 == null) goto L76;
        w r128 = r127.getRoomInfo();
        if (r128 == null) goto L76;
        r116 = r128.f23492b;
    L76:
        r122.putOpt("kol_uid", r116);
        r116 = r122.toString();
    L70:
        r126 = null;
    L77:
        Observable<RecordActionResponse> r129 = r121.recordAction(r117, r110, r111, r112, r116);
        if (r120 == null) goto L82;
        int r130 = ECSdk.f48106a;
        g r131 = (g) ECSdk.a(g.class);
        if (r131 == null) goto L82;
        r131.J();
    L82:
        r129.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(a.f481094a, b.f481095a);
        return;
    L62:
        r120 = null;
        goto L63
    L114:
        return;
    L46:
        r103 = 1;
        goto L47
    }
}
