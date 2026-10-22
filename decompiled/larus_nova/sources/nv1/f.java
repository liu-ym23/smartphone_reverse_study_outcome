package nv1;

import com.bytedance.android.livesdkapi.feed.IDislikeRepository;
import com.bytedance.android.livesdkapi.feed.IOpenFeedRepository;
import com.bytedance.android.livesdkapi.feed.IOpenFeedService;
import com.bytedance.android.livesdkapi.feed.open.IOpenLiveListFactory;

/* JADX INFO: loaded from: classes8.dex */
public class f implements IOpenFeedService {
    public f() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.IOpenFeedService
    public IDislikeRepository getDislikeRepository() {
        return new tw1.a();
    }

    @Override // com.bytedance.android.livesdkapi.feed.IOpenFeedService
    public IOpenFeedRepository getFeedRepository() {
        return new tw1.b();
    }

    @Override // com.bytedance.android.livesdkapi.feed.IOpenFeedService
    public IOpenLiveListFactory getOpenLiveListFactory() {
        return mw1.e.f515919a;
    }
}
