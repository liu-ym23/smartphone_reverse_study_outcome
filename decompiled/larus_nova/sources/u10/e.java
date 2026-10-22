package u10;

import com.bytedance.android.live.broadcastgame.opengame.network.outer.IOpenNetworkApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.config.ns;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f548267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f548268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Long, LiveCall<HttpResponse>> f548269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f548270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, IOpenNetworkApi> f548271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f548272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i20.a f548273g;

    public static final class a {
    }

    static {
    }

    @Override // u10.b
    public final boolean c() {
        if (this.f548269c.size() < this.f548267a) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        this.f548273g.b();
        this.f548272f.f548287a.clear();
        Iterator<Map.Entry<Long, LiveCall<HttpResponse>>> r100 = this.f548269c.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().cancel();
        goto L4
    L6:
        this.f548269c.clear();
    }

    public e(k r100) {
        Intrinsics.checkNotNullParameter(r100, "retrofitProvider");
        this.f548273g = new i20.a();
        this.f548272f = r100;
        this.f548267a = 10;
        this.f548268b = 60000;
        this.f548269c = new ConcurrentHashMap();
        this.f548270d = new AtomicLong(1);
        this.f548271e = new ConcurrentHashMap();
    }

    public final IOpenNetworkApi e(String r100) {
        IOpenNetworkApi r101 = this.f548271e.get(r100);
        if (r101 != null) goto L6;
        IOpenNetworkApi r102 = (IOpenNetworkApi) this.f548272f.getRetrofitInstance(r100).create(IOpenNetworkApi.class);
        this.f548271e.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final void g(long r100) {
        if (1 <= r100) goto L6;
    L8:
        this.f548268b = 60000;
        return;
    L6:
        if (60000 < r100) goto L8;
        this.f548268b = r100;
    }

    public final void d(Call<?> r100, long r101, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r102, Function1<? super Throwable, Unit> r110, boolean r111) {
        c r103 = new c(r100);
        long r104 = this.f548270d.getAndIncrement();
        this.f548269c.put(Long.valueOf(r104), r103);
        if (r101 <= 60000) goto L6;
        r101 = 60000;
    L8:
        if (r111 == false) goto L10;
        Observable r105 = Observable.never();
    L11:
        Disposable r106 = Observable.create(new f(r103)).delaySubscription(r105).timeout(r101, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r102, r104), new h(this, r110, r104));
        Intrinsics.checkNotNullParameter(r106, "$this$autoDispose");
        this.f548273g.a(r106);
        return;
    L10:
        r105 = Observable.empty();
        goto L11
    L6:
        if (r101 > 0) goto L8;
        r101 = this.f548268b;
        goto L8
    }

    @Override // u10.b
    public final void b(String r110, String r111, String r112, Map<String, String> r113, Map<String, String> r114, long r210, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r211, Function1<? super Throwable, Unit> r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, "domain");
        Intrinsics.checkNotNullParameter(r111, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r112, "relativeUrl");
        Intrinsics.checkNotNullParameter(r113, "headerMap");
        Intrinsics.checkNotNullParameter(r114, "queryMap");
        Intrinsics.checkNotNullParameter(r211, "onSuccess");
        Intrinsics.checkNotNullParameter(r212, LynxVideoManagerLite.EVENT_ON_ERROR);
        if (ns.f120856a.getValue().booleanValue() == true) goto L28;
        return;
    L28:
    L25:
        th = move-exception;
        r212.invoke(th);
        ALogger.e("OpenNetworkExecutor", "doRequestWithQueryMap", th);
        return;
    L6:
        switch(r111.hashCode()) {
            case -531492226: goto L18;
            case 70454: goto L15;
            case 2213344: goto L12;
            case 2012838315: goto L9;
            default: goto L21;
        };     // Catch: Throwable -> L25
    L21:
        r212.invoke(new Throwable("http method error."));     // Catch: Throwable -> L25
        Call<?> r100 = null;
    L20:
        Call<?> r101 = r100;
        if (r101 == null) goto L30;
        d(r101, r210, r211, r212, r213);     // Catch: Throwable -> L25
        return;
    L30:
        return;
    L9:
        if (r111.equals("DELETE") == false) goto L21;
        r100 = e(r110).doDelete(false, Integer.MAX_VALUE, r112, r113, r114);     // Catch: Throwable -> L25
        goto L20
    L12:
        if (r111.equals("HEAD") == false) goto L21;
        r100 = e(r110).doHead(false, Integer.MAX_VALUE, r112, r113, r114);     // Catch: Throwable -> L25
        goto L20
    L15:
        if (r111.equals("GET") == false) goto L21;
        r100 = e(r110).doGet(false, Integer.MAX_VALUE, r112, r113, r114);     // Catch: Throwable -> L25
        goto L20
    L18:
        if (r111.equals("OPTIONS") == false) goto L21;
        r100 = e(r110).doOptions(false, Integer.MAX_VALUE, r112, r113, r114);     // Catch: Throwable -> L25
        goto L20
    }

    @Override // u10.b
    public final void a(String r110, String r111, String r112, Map<String, String> r113, byte[] r210, String r211, long r212, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r213, Function1<? super Throwable, Unit> r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r110, "domain");
        Intrinsics.checkNotNullParameter(r111, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r112, "relativeUrl");
        Intrinsics.checkNotNullParameter(r113, "headerMap");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r213, "onSuccess");
        Intrinsics.checkNotNullParameter(r214, LynxVideoManagerLite.EVENT_ON_ERROR);
        if (ns.f120856a.getValue().booleanValue() == true) goto L24;
        return;
    L24:
        int r100 = r111.hashCode();     // Catch: Throwable -> L21
        if (r100 == 79599) goto L14;
        if (r100 == 2461856) goto L11;
    L16:
        r214.invoke(new Throwable("http method error."));     // Catch: Throwable -> L21
        Call<TypedInput> r101 = null;
    L17:
        Call<TypedInput> r102 = r101;
        if (r102 == null) goto L26;
        d(r102, r212, r213, r214, r215);     // Catch: Throwable -> L21
        return;
    L26:
        return;
    L11:
        if (r111.equals("POST") == false) goto L16;
        r101 = e(r110).doPost(false, Integer.MAX_VALUE, r112, r113, new TypedByteArray(r211, r210, new String[0]));     // Catch: Throwable -> L21
        goto L17
    L14:
        if (r111.equals("PUT") == false) goto L16;
        r101 = e(r110).doPut(false, Integer.MAX_VALUE, r112, r113, new TypedByteArray(r211, r210, new String[0]));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r214.invoke(th);
        ALogger.e("OpenNetworkExecutor", "doRequestWithBody", th);
    }
}
