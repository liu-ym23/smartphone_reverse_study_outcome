package com.ss.android.ugc.aweme.newfollow.model;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.profile.model.User;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u00020\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0013\u0010#\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010%\u001a\u00020$8\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/newfollow/model/BaseFlowFeed;", "Lcom/ss/android/ugc/aweme/discover/commodity/ECSearchBaseResponse;", "", "", "requestId", "", "setRequestId", "getRequestId", "requestIdInner", "Ljava/lang/String;", "Lcom/ss/android/ugc/aweme/feed/model/Aweme;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "getAweme", "()Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "setAweme", "(Lcom/ss/android/ugc/aweme/feed/model/Aweme;)V", ShareChannel.DOUYIN, "", "Lcom/ss/android/ugc/aweme/profile/model/User;", "b", "Ljava/util/List;", "getLikeList", "()Ljava/util/List;", "setLikeList", "(Ljava/util/List;)V", "likeList", "", "getFeedType", "()I", "setFeedType", "(I)V", "feedType", "getAwemeAuthorId", "()Ljava/lang/String;", "awemeAuthorId", "", "needUpdateComment", "Z", "getNeedUpdateComment", "()Z", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseFlowFeed extends ECSearchBaseResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Aweme f451294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient List<User> f451295b;
    private String requestIdInner;

    public abstract int getFeedType();

    public boolean getNeedUpdateComment() {
        return false;
    }

    public abstract void setFeedType(int r100);

    public final String getAwemeAuthorId() {
        Aweme r100 = getAweme();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAuthorUid();
    }

    public BaseFlowFeed() {
    }

    public Aweme getAweme() {
        return this.f451294a;
    }

    public List<User> getLikeList() {
        return this.f451295b;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    public String getRequestId() {
        return this.requestIdInner;
    }

    public void setAweme(Aweme r100) {
        this.f451294a = r100;
    }

    public void setLikeList(List<User> r100) {
        this.f451295b = r100;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    public void setRequestId(String r100) {
        this.requestIdInner = r100;
    }
}
