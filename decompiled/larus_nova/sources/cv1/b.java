package cv1;

import com.bytedance.android.live.base.model.push.LivePushInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements LivePushInfo.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePushInfo f465480a;

    @Override // com.bytedance.android.live.base.model.push.LivePushInfo.e
    public final a getController() {
        return new a();
    }

    @Override // com.bytedance.android.live.base.model.push.LivePushInfo.e
    public final LivePushInfo getPushInfo() {
        return this.f465480a;
    }

    public b(LivePushInfo r100) {
        this.f465480a = r100;
    }
}
