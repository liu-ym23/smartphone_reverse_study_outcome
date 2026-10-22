package mk0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f514282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mb6.b.InterfaceC6793b f514283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f514284c;

    public d(long r100, GuestLinkPipeLineManager.f r101, String r102) {
        this.f514282a = r100;
        this.f514283b = r101;
        this.f514284c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r101 = (ExtraResponse) r100;
        jy0.b.d("GuestLinkApiManager", "finishChannel success duration: " + dc6.a.a(this.f514282a) + ", logId: " + r101.logId);
        mb6.b.InterfaceC6793b r102 = this.f514283b;
        if (r102 == null) goto L6;
        r102.j(dc6.a.a(this.f514282a), this.f514284c, r101);
        return;
    }
}
