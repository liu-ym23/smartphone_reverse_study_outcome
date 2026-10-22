package mk0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f514276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mb6.b.a f514277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f514278c;

    public b(long r100, GuestLinkPipeLineManager.b r101, long r102) {
        this.f514276a = r100;
        this.f514277b = r101;
        this.f514278c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r101 = (ExtraResponse) r100;
        jy0.b.d("GuestLinkApiManager", "enterChannel success duration: " + dc6.a.a(this.f514276a) + ", logId: " + r101.logId);
        mb6.b.a r102 = this.f514277b;
        if (r102 == null) goto L6;
        r102.h(dc6.a.a(this.f514276a), r101, this.f514278c);
        return;
    }
}
