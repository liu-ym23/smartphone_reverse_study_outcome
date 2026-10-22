package i41;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p> f488155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f488156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f488157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f488158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f488159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f488160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f488161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f488162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f488163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f488164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f488165k;

    /* JADX INFO: renamed from: i41.a$a, reason: collision with other inner class name */
    public static final class C6227a {
    }

    static {
    }

    public final r31.a c() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f488165k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLinkNetwork();
    }

    public a(LinkFakeGlobalService r100) {
        this.f488165k = r100;
        this.f488162h = 1;
        this.f488156b = 10000;
        this.f488155a = new ArrayList();
    }

    public final void a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = ((ArrayList) this.f488155a).size();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f488155a).size() >= r101) goto L5;
        r101 = ((ArrayList) this.f488155a).size();
    L5:
        ListProtector.add(this.f488155a, r101, r100);
    }

    public final void b(AutoMatchSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r41.b.f536016a == true) goto L5;
        this.f488158d = "";
        if (this.f488160f == false) goto L57;
        boolean r101 = false;
        this.f488160f = false;
        Disposable r102 = this.f488159e;
        if (r102 == null) goto L16;
        r102.dispose();
        this.f488159e = null;
    L16:
        Disposable r103 = this.f488164j;
        if (r103 == null) goto L19;
        r103.dispose();
        this.f488164j = null;
    L19:
        Disposable r104 = this.f488163i;
        if (r104 == null) goto L22;
        r104.dispose();
        this.f488163i = null;
    L22:
        String r105 = this.f488161g;
        if (r105 != null) goto L25;
    L26:
        r101 = true;
    L27:
        if (r101 == true) goto L36;
        r31.a r106 = c();
        if (r106 == null) goto L51;
        String r107 = this.f488161g;
        Intrinsics.checkNotNull(r107);
        Observable r108 = r106.s(r107, 12);
        if (r108 == null) goto L51;
        int r109 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r110 = r108.subscribeOn(Schedulers.io());
        if (r110 == null) goto L51;
        r110.subscribe(h.f488184a, i.f488185a);
    L51:
        Iterator r111 = ((ArrayList) this.f488155a).iterator();
    L53:
        if (r111.hasNext() == false) goto L60;
        ((p) r111.next()).F8(r100);
        goto L53
    L60:
        return;
    L36:
        if (this.f488162h < 0) goto L44;
        r31.a r112 = c();
        if (r112 == null) goto L51;
        Observable r113 = r112.s("", this.f488162h);
        if (r113 == null) goto L51;
        int r114 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r115 = r113.subscribeOn(Schedulers.io());
        if (r115 == null) goto L51;
        r115.subscribe(j.f488186a, k.f488187a);
        goto L51
    L44:
        r31.a r116 = c();
        if (r116 == null) goto L51;
        Observable r117 = r116.b();
        if (r117 == null) goto L51;
        int r118 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Observable r119 = r117.subscribeOn(Schedulers.io());
        if (r119 == null) goto L51;
        r119.subscribe(l.f488188a, m.f488189a);
        goto L51
    L25:
        if (r105.length() != 0) goto L27;
    L57:
        return;
    L5:
        if (r100 != AutoMatchSource.ReceiveMultiInviteWhenMatching) goto L8;
        return;
    L8:
        if (this.f488160f == false) goto L59;
        JSONObject r120 = new JSONObject();
        cy0.e.f465759a.getClass();
        cy0.j r121 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r122 = com.bytedance.android.scope.m.b(r121).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r122);
        ((vy0.b) ((f80.a) r122)).sendEventToAllJsBridges("H5_stopAutoMatch", r120);
        return;
    }

    public static /* synthetic */ void e(a r110, long r111, boolean r112) {
        r110.d(r111, r112, false, 0, 0, "", "", null);
    }

    public final void d(long r110, boolean r210, boolean r211, int r212, int r213, String r214, String r215, Function1 r216) {
        String r100 = r215;
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r214, "activityId");
        if (r41.b.f536016a == false) goto L10;
        long r101 = r212;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        JSONObject r102 = new JSONObject();
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, r101);
        r102.put("game_id", r100);
        r102.put("sub_type", 0);
        r102.put("default_limit_time", 60);
        r102.put("accelerate_limit_time", 15);
        r102.put("invite_limit_time", 10);
        r102.put("wait_time_level", 0);
        cy0.e.f465759a.getClass();
        cy0.j r103 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r104 = com.bytedance.android.scope.m.b(r103).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r104);
        ((vy0.b) ((f80.a) r104)).sendEventToAllJsBridges("H5_startAutoMatch", r102);
        return;
    L10:
        if (this.f488160f == false) goto L12;
        return;
    L12:
        this.f488161g = r100;
        this.f488162h = r212;
        this.f488157c = 0;
        this.f488160f = true;
        Iterator r105 = ((ArrayList) this.f488155a).iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        ((p) r105.next()).aq();
        goto L14
    L16:
        Disposable r106 = this.f488159e;
        if (r106 == null) goto L19;
        r106.dispose();
        this.f488159e = null;
    L19:
        Disposable r107 = this.f488163i;
        if (r107 == null) goto L22;
        r107.dispose();
        this.f488163i = null;
    L22:
        this.f488156b = 10000;
        if (r210 == false) goto L25;
        x41.a r108 = x41.a.f562434f;
        r108.getClass();
        this.f488156b = ((Number) x41.a.f562430b.getValue(r108, x41.a.f562429a[0])).intValue();
        int r109 = 1;
    L26:
        com.bytedance.revenue.platform.api.core.rx.l r111 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        long r112 = r109 * 1000;
        int r113 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        this.f488159e = Observable.interval(0, r112, TimeUnit.MILLISECONDS, Schedulers.computation()).take(this.f488156b + 1).map(new n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r110, r210, r211, r212, r213, r214, r215, r216));
        return;
    L25:
        r109 = 3;
        goto L26
    }
}
