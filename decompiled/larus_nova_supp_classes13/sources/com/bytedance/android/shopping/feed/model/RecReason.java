package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/RecReason;", "Ljava/io/Serializable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "link", "getLink", "rankId", "getRankId", "rankNo", "", "getRankNo", "()Ljava/lang/Long;", "Ljava/lang/Long;", "type", "", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "typeName", "getTypeName", "uid", "getUid", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecReason implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("link")
    private final String link;

    @SerializedName("rank_id")
    private final String rankId;

    @SerializedName("rank_no")
    private final Long rankNo;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("type_name")
    private final String typeName;

    @SerializedName("uid")
    private final String uid;

    public RecReason() {
    }

    public final String getContent() {
        return this.content;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final Long getRankNo() {
        return this.rankNo;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final String getUid() {
        return this.uid;
    }
}
