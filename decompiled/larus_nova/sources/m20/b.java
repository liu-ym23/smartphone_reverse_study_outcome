package m20;

import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayPerfPanelView f511636a;

    public b(XplayPerfPanelView r100) {
        this.f511636a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<XplayPerfPanelView.c> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        XplayPerfPanelView r100 = this.f511636a;
        r100.f62318f += r100.f62326n.b();
        XplayPerfPanelView r101 = this.f511636a;
        r101.f62319g += r101.f62326n.c();
        XplayPerfPanelView r102 = this.f511636a;
        float r103 = r102.f62320h;
        r102.f62326n.getClass();
        IHostPerformanceMonitor r104 = (IHostPerformanceMonitor) OpenPlatformPerfDog.f60695f.getValue();
        if (r104 == null) goto L5;
        float r105 = (float) r104.getGpuUsage();
    L6:
        r102.f62320h = r103 + r105;
        XplayPerfPanelView r106 = this.f511636a;
        r106.f62321i += r106.f62326n.a();
        XplayPerfPanelView r107 = this.f511636a;
        r107.f62322j += r107.f62326n.getUIStallRate();
        XplayPerfPanelView r108 = this.f511636a;
        r108.f62323k = Math.max(r108.f62323k, r108.f62326n.d());
        XplayPerfPanelView r109 = this.f511636a;
        int r111 = r109.f62324l + 1;
        r109.f62324l = r111;
        String r112 = XplayPerfPanelView.a(r109, r109.f62319g, r111);
        XplayPerfPanelView r113 = this.f511636a;
        String r114 = XplayPerfPanelView.a(r113, r113.f62320h, r113.f62324l);
        XplayPerfPanelView r115 = this.f511636a;
        String r116 = XplayPerfPanelView.a(r115, r115.f62321i, r115.f62324l);
        XplayPerfPanelView r117 = this.f511636a;
        String r118 = XplayPerfPanelView.a(r117, r117.f62322j, r117.f62324l);
        XplayPerfPanelView r119 = this.f511636a;
        String r120 = XplayPerfPanelView.a(r119, r119.f62318f, r119.f62324l);
        XplayPerfPanelView r121 = this.f511636a;
        r110.onNext(new XplayPerfPanelView.c(r112, r114, r116, r118, r120, XplayPerfPanelView.a(r121, r121.f62323k, 1)));
        r110.onComplete();
        return;
    L5:
        r105 = -1.0f;
        goto L6
    }
}
