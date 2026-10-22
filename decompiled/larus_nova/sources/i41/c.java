package i41;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.RandomMatchStrategy;
import com.bytedance.android.livesdk.link.model.g0;
import com.bytedance.android.livesdk.link.model.r4;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f488168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f488169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f488170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f488171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f488172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f488173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f488174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f488175i;

    public c(a r100, int r101, Function1 r102, int r103, boolean r104, boolean r105, long r106, String r107, long r110) {
        this.f488167a = r100;
        this.f488168b = r101;
        this.f488169c = r102;
        this.f488170d = r103;
        this.f488171e = r104;
        this.f488172f = r105;
        this.f488173g = r106;
        this.f488174h = r107;
        this.f488175i = r110;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        ExtraResponse r111 = (ExtraResponse) r110;
        r4 r100 = (r4) r111.data;
        LiveFullLinkPKMonitor r101 = null;
        String r102 = "";
        if (this.f488168b != 1) goto L36;
        EXTRA r103 = r111.extra;
        if (r103 == 0) goto L27;
        if (((com.bytedance.android.livesdk.link.model.a) r103).a() == null) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r104 = this.f488167a.f488165k;
        if (r104 == null) goto L11;
        com.bytedance.android.live.revlink.impl.control.d r105 = r104.Rc();
    L12:
        if (r105 == null) goto L19;
        g0 r106 = ((com.bytedance.android.livesdk.link.model.a) r111.extra).a();
        if (r106 == null) goto L17;
        String r107 = r106.getImprId();
        if (r107 == null) goto L17;
    L18:
        r105.setRequestId(r107);
    L17:
        r107 = "";
    L19:
        this.f488167a.f488158d = r100.getBattleAttachedInfo();
        Function1 r108 = this.f488169c;
        if (r108 == null) goto L27;
        String r112 = this.f488167a.f488158d;
        long r113 = r100.getMatchStrategy();
        if (this.f488170d != 13) goto L24;
        boolean r114 = true;
    L25:
        Unit r109 = (Unit) r108.invoke(new com.bytedance.android.live.revlink.impl.pk.vm.linkout.p(r112, r113, r114));
        goto L27
    L24:
        r114 = false;
        goto L25
    L11:
        r105 = null;
    L27:
        if (this.f488171e == true) goto L36;
        if (this.f488172f == true) goto L36;
        if (r100.getMaxWaitTime() <= 0) goto L33;
        long r115 = r100.getMaxWaitTime();
    L34:
        a r116 = this.f488167a;
        com.bytedance.revenue.platform.api.core.rx.l r117 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        int r118 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        r116.f488163i = Observable.timer((r115 + 1) * ((long) 1000), TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        goto L36
    L33:
        r115 = 180;
    L36:
        if (r100.getRivalRoom() == null) goto L38;
        a r119 = this.f488167a;
        r119.f488160f = false;
        Disposable r120 = r119.f488159e;
        if (r120 == null) goto L55;
        r120.dispose();
        this.f488167a.f488159e = null;
    L55:
        Disposable r121 = this.f488167a.f488163i;
        if (r121 == null) goto L58;
        r121.dispose();
        this.f488167a.f488163i = null;
    L58:
        EXTRA r122 = r111.extra;
        if (r122 != 0) goto L61;
    L74:
        Iterator r123 = ((ArrayList) this.f488167a.f488155a).iterator();
    L76:
        if (r123.hasNext() == false) goto L82;
        p r124 = (p) r123.next();
        String r125 = this.f488174h;
        String r126 = this.f488167a.f488158d;
        long r127 = RandomMatchStrategy.Normal.ordinal();
        if (this.f488170d != 13) goto L80;
        boolean r128 = true;
    L81:
        r124.Nh(r100, r125, new com.bytedance.android.live.revlink.impl.pk.vm.linkout.p(r126, r127, r128));
        goto L76
    L80:
        r128 = false;
    L82:
        com.bytedance.android.live.revlink.impl.global.c r129 = this.f488167a.f488165k;
        if (r129 == null) goto L85;
        r101 = r129.getLiveFullLinkPKMonitor();
    L85:
        LiveFullLinkPKMonitor r130 = r101;
        if (r130 == null) goto L96;
        i97.a r131 = i97.a.f488802a;
        LiveFullLinkPKMonitor.s(r130, "linkmic/battle/auto_match", System.currentTimeMillis() - this.f488175i, 0, 0, null, 28);
        return;
    L96:
        return;
    L61:
        if (((com.bytedance.android.livesdk.link.model.a) r122).a() == null) goto L74;
        com.bytedance.android.live.revlink.impl.global.c r132 = this.f488167a.f488165k;
        if (r132 == null) goto L65;
        com.bytedance.android.live.revlink.impl.control.d r133 = r132.Rc();
    L66:
        if (r133 == null) goto L74;
        g0 r134 = ((com.bytedance.android.livesdk.link.model.a) r111.extra).a();
        if (r134 == null) goto L73;
        String r135 = r134.getImprId();
        if (r135 == null) goto L73;
        r102 = r135;
    L73:
        r133.setRequestId(r102);
        goto L74
    L65:
        r133 = null;
        goto L66
    L38:
        if (this.f488173g != 0) goto L44;
        this.f488167a.getClass();
        Iterator r136 = ((ArrayList) this.f488167a.f488155a).iterator();
    L41:
        if (r136.hasNext() == false) goto L43;
        ((p) r136.next()).qn(this.f488171e, true, AutoMatchSource.PollingEnd);
        goto L41
    L43:
        this.f488167a.f488160f = false;
        goto L82
    L44:
        Iterator r137 = ((ArrayList) this.f488167a.f488155a).iterator();
    L46:
        if (r137.hasNext() == false) goto L82;
        p r138 = (p) r137.next();
        if (this.f488168b != 1) goto L50;
        boolean r139 = true;
    L51:
        r138.Ug(r100, r139, this.f488174h);
        goto L46
    L50:
        r139 = false;
        goto L51
    }
}
