package hm9;

import com.larus.apm.api.IApmTrace;
import com.larus.common.apphost.AppHost;
import com.larus.dora.device.api.IDoraDeviceInfo;
import com.larus.network.interceptor.http.DoraTaskStatus;
import com.larus.network.util.ScreenStateManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s {
    public static final /* synthetic */ int C = 0;
    public volatile Function1<? super Boolean, Unit> A;
    public volatile boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScreenStateManager.ScreenState f485971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f485972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f485973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f485974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f485975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f485976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f485977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f485978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f485979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f485980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f485981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f485982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f485983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f485984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<String> f485985o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<String> f485986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<String> f485987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f485988r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f485989s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f485990t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f485991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DoraTaskStatus f485992v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f485993w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f485994x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile int f485995y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f485996z;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f485989s.size() <= 0) goto L5;
    L10:
        JSONObject r100 = new JSONObject();
        r100.put("path", this.f485989s.toString());
        r100.put("host", this.f485988r.toString());
        r100.put("allow_host", this.f485991u.toString());
        r100.put("allow_path", this.f485990t.toString());
        IDoraDeviceInfo r101 = (IDoraDeviceInfo) this.f485980j.getValue();
        String r102 = "NULL";
        if (r101 == null) goto L13;
        Object r103 = Integer.valueOf(r101.getProductId());
    L14:
        r100.put("dora_product_id", r103);
        IDoraDeviceInfo r104 = (IDoraDeviceInfo) this.f485980j.getValue();
        if (r104 == null) goto L20;
        String r105 = r104.a();
        if (r105 == null) goto L20;
        r102 = r105;
    L20:
        r100.put("dora_product_name", r102);
        IApmTrace.f286937a.f(this.f485981k, r100, null, null);
        this.f485988r.clear();
        this.f485989s.clear();
        this.f485991u.clear();
        this.f485990t.clear();
        if (AppHost.f326268a.isDebug() == false) goto L25;
        FLogger.f375446a.d("BackgroundNetworkInterceptor#InterceptorContext", "Report Data: " + r100);
        return;
    L25:
        return;
    L13:
        r103 = "NULL";
        goto L14
    L5:
        if (this.f485988r.size() > 0) goto L10;
        if (this.f485991u.size() > 0) goto L10;
        if (this.f485990t.size() > 0) goto L10;
    }

    public s(ScreenStateManager.ScreenState r100) {
        Intrinsics.checkNotNullParameter(r100, "appScreenState");
        this.f485971a = r100;
        this.f485972b = false;
        this.f485973c = false;
        this.f485974d = false;
        this.f485975e = false;
        this.f485976f = false;
        this.f485977g = true;
        this.f485978h = false;
        this.f485979i = "InterceptorContext";
        AppHost.Companion r101 = AppHost.f326268a;
        boolean r102 = ita.k.i(r101.getApplication());
        FLogger.f375446a.i("InterceptorContext", "InterceptorContext init: " + this.f485974d + ", isMainProcess=" + r102);
        this.f485980j = LazyKt.lazy(new r());
        this.f485981k = "background_request_control_event";
        this.f485982l = 30;
        this.f485984n = 100;
        this.f485985o = new ArrayList();
        this.f485986p = new ArrayList();
        this.f485987q = new ArrayList();
        this.f485988r = new ConcurrentHashMap();
        this.f485989s = new ConcurrentHashMap();
        this.f485990t = new ConcurrentHashMap();
        this.f485991u = new ConcurrentHashMap();
        this.f485992v = DoraTaskStatus.WAKE_OFF_OR_DISCONNECTED;
        this.f485994x = r101.a().isAppBackground();
        this.f485995y = 1;
    }

    public final void d(boolean r100) {
        if (this.B != r100) goto L5;
        return;
    L5:
        this.B = r100;
        Function1<? super Boolean, Unit> r101 = this.A;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.invoke(Boolean.valueOf(r100));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e(this.f485979i, "onInterceptingChanged callback failed", e);
    }

    public final int a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "path");
        Sequence r102 = SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.f485985o), new n()), new o());
        Sequence r103 = SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.f485986p), new p()), new q());
        Iterator r104 = r102.iterator();
    L3:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L8;
        String r106 = (String) r104.next();
        if (Intrinsics.areEqual(StringsKt.trim(r100).toString(), r106) == false) goto L3;
        boolean r107 = true;
    L10:
        if (r107 == false) goto L12;
        return 2;
    L12:
        Iterator r108 = r103.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();
        if (StringsKt.contains$default(StringsKt.trim(r101).toString(), r109, false, 2, null) == false) goto L14;
        r105 = true;
    L18:
        if (r105 == true) goto L29;
        return 3;
    L29:
        return 1;
    L8:
        r107 = false;
        goto L10
    }

    public static void b(s r100, String r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r100.f485983m == false) goto L8;
        FLogger.f375446a.e(r101, r102, null);
        int r103 = r100.f485984n - 1;
        r100.f485984n = r103;
        if (r103 > 0) goto L9;
        r100.f485983m = false;
        return;
    L9:
        return;
    }

    public final void e(String r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "path");
        int r103 = 0;
        if (r102 != null) goto L6;
    L13:
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.intValue() == 1) goto L18;
        return;
    L18:
        if (this.f485990t.size() > this.f485982l) goto L27;
        ConcurrentHashMap<String, Integer> r104 = this.f485990t;
        Integer r105 = r104.get(r101);
        if (r105 == null) goto L22;
        r103 = r105.intValue();
    L22:
        r104.put(r101, Integer.valueOf(r103 + 1));
        return;
    L27:
        return;
    L6:
        if (r102.intValue() != 2) goto L13;
        if (this.f485991u.size() > this.f485982l) goto L24;
        ConcurrentHashMap<String, Integer> r106 = this.f485991u;
        Integer r107 = r106.get(r100);
        if (r107 == null) goto L12;
        r103 = r107.intValue();
    L12:
        r106.put(r100, Integer.valueOf(r103 + 1));
        return;
    }
}
