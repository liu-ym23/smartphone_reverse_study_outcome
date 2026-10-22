package pk0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wb6.a.b f529547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f529548b;

    public d(com.bytedance.android.live.livelink.multilink.pipeline.c r100, long r101) {
        this.f529547a = r100;
        this.f529548b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse<LinkFinishResult, Extra> r101 = (ExtraResponse) r100;
        LinkMonitor.a("LinkApiM", "finish success", null, null, null, false, 124);
        wb6.a.b r102 = this.f529547a;
        if (r102 == null) goto L6;
        r102.bp(dc6.a.a(this.f529548b), r101);
        return;
    }
}
