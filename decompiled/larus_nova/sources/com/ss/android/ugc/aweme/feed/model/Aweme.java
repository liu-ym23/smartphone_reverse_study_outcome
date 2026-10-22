package com.ss.android.ugc.aweme.feed.model;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.aweme.feed.model.search.SearchMergedLogData;
import com.ss.android.ugc.aweme.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\nR\u0016\u0010$\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0012R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00106\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u00108\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b7\u0010\r¨\u0006;"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "Ljava/io/Serializable;", "", "", "", "requestId", "", "setRequestId", "getRequestId", "aid", "Ljava/lang/String;", "value", "getRequestIdP", "()Ljava/lang/String;", "setRequestIdP", "(Ljava/lang/String;)V", "", "muteSwitch", "I", "groupId", "getGroupId", "setGroupId", "", "isAd", "Z", "Lcom/ss/android/ugc/aweme/feed/model/Video;", "video", "Lcom/ss/android/ugc/aweme/feed/model/Video;", "getVideo", "()Lcom/ss/android/ugc/aweme/feed/model/Video;", "setVideo", "(Lcom/ss/android/ugc/aweme/feed/model/Video;)V", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchMergedLogData;", "searchMergedLogData", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchMergedLogData;", "fp", "isBrief", "awemePosition", "", "images", "Ljava/util/List;", "photosCurPos", "awemeType", "getAwemeType", "()I", "setAwemeType", "(I)V", "Lcom/ss/android/ugc/aweme/profile/model/User;", "author", "Lcom/ss/android/ugc/aweme/profile/model/User;", "getAd", "()Z", "setAd", "(Z)V", "ad", "getAuthorUid", "authorUid", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public class Aweme implements Serializable, Cloneable {

    @SerializedName(SimilarProductParam.AWEME_ID)
    public String aid;

    @SerializedName("author")
    public User author;
    public int awemePosition;

    @SerializedName("aweme_type")
    private int awemeType;

    /* JADX INFO: renamed from: fp, reason: collision with root package name */
    @SerializedName(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT)
    public String f450814fp;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("images")
    public List<Object> images;

    @SerializedName("is_ads")
    public boolean isAd;

    @SerializedName("is_brief")
    public boolean isBrief;

    @SerializedName("mute_switch")
    public int muteSwitch;
    public transient int photosCurPos;
    private String requestId;
    public transient SearchMergedLogData searchMergedLogData;

    @SerializedName("video")
    private Video video;

    public final String getAuthorUid() {
        User r100 = this.author;
        if (r100 == null) goto L6;
        String r101 = r100.uid;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public Aweme() {
        this.awemePosition = -1;
        this.photosCurPos = -1;
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean getAd() {
        return this.isAd;
    }

    public final int getAwemeType() {
        return this.awemeType;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public final String getRequestIdP() {
        return this.requestId;
    }

    public final Video getVideo() {
        return this.video;
    }

    public final void setAd(boolean r100) {
        this.isAd = r100;
    }

    public final void setAwemeType(int r100) {
        this.awemeType = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public void setRequestId(String r100) {
        setRequestIdP(r100);
    }

    public final void setRequestIdP(String r100) {
        this.requestId = r100;
    }

    public final void setVideo(Video r100) {
        this.video = r100;
    }
}
