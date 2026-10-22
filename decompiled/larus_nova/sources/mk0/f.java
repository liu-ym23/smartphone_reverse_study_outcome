package mk0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f514287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mb6.b.c f514288b;

    public f(long r100, com.bytedance.android.live.livelink.guestlink.pipeline.a r101) {
        this.f514287a = r100;
        this.f514288b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.c, Extra> r101 = (ExtraResponse) r100;
        jy0.b.d("GuestLinkApiManager", "joinChannel success duration: " + dc6.a.a(this.f514287a) + ", logId: " + r101.logId);
        mb6.b.c r102 = this.f514288b;
        if (r102 == null) goto L6;
        r102.C2(dc6.a.a(this.f514287a), r101);
        return;
    }
}
