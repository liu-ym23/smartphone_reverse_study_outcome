package ke1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f502999b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f503000c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f503001d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f503002e = 0.0d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, e> f503003f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f503004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f503005h = null;

    public d() {
    }

    static {
        f503005h = new d();
        IMiddlewareUserService r100 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 == null) goto L7;
        String r102 = r101.n();
    L8:
        f502999b = r102;
        LiveTbArchUtils r103 = LiveTbArchUtils.INSTANCE;
        f503000c = r103.enableTrace();
        f503001d = r103.enableTraceSample();
        f503002e = r103.traceSample();
        f503003f = new LinkedHashMap();
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // ke1.a
    public final void b() {
        Map<String, e> r100 = f503003f;
        if ((!r100.isEmpty()) == false) goto L5;
        Map<String, e> r101 = r100;
    L6:
        if (r101 == null) goto L13;
        Map r102 = MapsKt.toMap(r101);
        if (r102 == null) goto L15;
        ((LinkedHashMap) r100).clear();
        Iterator r103 = r102.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        Map.Entry r104 = (Map.Entry) r103.next();
        d r105 = f503005h;
        e r106 = (e) r104.getValue();
        r105.getClass();
        d(r106);
        goto L11
    L16:
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void d(e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f503003f.remove(r100.f503008c);
        if (v.a() == false) goto L7;
    L19:
        boolean r101 = false;
    L20:
        if (r101 == false) goto L22;
        return;
    L22:
        Single.create(new c(r100)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L7:
        if (f503000c == true) goto L10;
    L18:
        r101 = true;
        goto L20
    L10:
        if (f503001d == false) goto L19;
        if (r100.f503007b == true) goto L19;
        double r102 = f503002e;
        if (r102 >= 1.0d) goto L19;
        double r103 = Random.Default.nextDouble();
        if (r103 > r102) goto L19;
        ALogger.d("LiveTbMonitor", "random: " + r103 + "\ttraceSample: " + r102);
        goto L18
    }

    public static String e(DataCenter r100) {
        if (r100 != null) goto L6;
        return "unknown_room";
    L6:
        return lu2.c.f(r100).getIdStr().toString() + '_' + r100.hashCode();
    }

    @Override // ke1.a
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (LiveTbArchUtils.INSTANCE.enableCollectTraceInfo() == true) goto L5;
        return;
    L5:
        e r101 = f503004g;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "node");
        ((ArrayList) r101.f503006a).add(r100);
        if (r100.f503011a == false) goto L12;
        r101.f503007b = true;
        return;
    L12:
        return;
    }

    @Override // ke1.a
    public final void c(com.bytedance.android.live.room.api.base.alog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (LiveTbArchUtils.INSTANCE.enableAlog() == true) goto L5;
        return;
    L5:
        StringBuilder r101 = new StringBuilder();
        e r102 = f503004g;
        if (r102 == null) goto L8;
        String r103 = r102.f503009d;
    L9:
        r101.append(r103);
        r101.append(" ::: ");
        r101.append(r100.f98899a);
        String r104 = r101.toString();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f98899a = r104;
        Throwable r105 = r100.f98900b;
        if (r105 == null) goto L12;
        ALogger.e("LiveTbMonitor", r104, r105);
        return;
    L12:
        ALogger.i("LiveTbMonitor", r104);
        Unit r106 = Unit.INSTANCE;
        return;
    L8:
        r103 = null;
        goto L9
    }
}
