package nt1;

import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livesdk.dislike.layout.RecommendToFriendsLayout;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements ILiveRecommendToFriendsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendToFriendsLayout f520474a;

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onFailed() {
    }

    public d(RecommendToFriendsLayout r100) {
        this.f520474a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onLiveRecommendSuccess(long r100) {
        int r101 = RecommendLiveHelper.f122216a;
        boolean r102 = RecommendLiveHelper.b(r100);
        RecommendToFriendsLayout.a(this.f520474a, r102);
        this.f520474a.b(r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onSuccess(long r100) {
        int r101 = RecommendLiveHelper.f122216a;
        boolean r102 = RecommendLiveHelper.b(r100);
        RecommendToFriendsLayout.a(this.f520474a, r102);
        this.f520474a.b(r102);
    }
}
