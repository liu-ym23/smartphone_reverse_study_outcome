package pk0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f529560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f529561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wb6.a.e f529562c;

    public k(String r100, long r101, com.bytedance.android.live.livelink.multilink.pipeline.d r102) {
        this.f529560a = r100;
        this.f529561b = r101;
        this.f529562c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<? extends g1, Extra> r101 = (ExtraResponse) r100;
        LinkMonitor.a("LinkApiM", "leaveChannel success", null, null, null, false, 124);
        InteractLinkFullLinkMonitor.x(this.f529560a, dc6.a.a(this.f529561b), r101.logId);
        wb6.a.e r102 = this.f529562c;
        if (r102 == null) goto L6;
        r102.Xf(dc6.a.a(this.f529561b), r101);
        return;
    }
}
