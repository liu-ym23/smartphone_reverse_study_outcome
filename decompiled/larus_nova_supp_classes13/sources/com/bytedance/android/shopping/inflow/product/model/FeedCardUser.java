package com.bytedance.android.shopping.inflow.product.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/inflow/product/model/FeedCardUser;", "Ljava/io/Serializable;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "name", "getName", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "", "isLive", "Z", "()Z", "link", "getLink", "secUid", "getSecUid", "", "roomId", "Ljava/lang/Long;", "getRoomId", "()Ljava/lang/Long;", "followCount", "getFollowCount", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedCardUser implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -21392;

    @SerializedName("avatar")
    private final ECUrlModel avatar;

    @SerializedName("follow_count")
    private final Long followCount;

    @SerializedName(PdpOpenThirdParam.KEY_FOLLOW_STATUS)
    private final Integer followStatus;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_live")
    private final boolean isLive;

    @SerializedName("link")
    private final String link;

    @SerializedName("name")
    private final String name;

    @SerializedName("room_id")
    private final Long roomId;

    @SerializedName("sec_uid")
    private final String secUid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedCardUser() {
    }

    public final ECUrlModel getAvatar() {
        return this.avatar;
    }

    public final Long getFollowCount() {
        return this.followCount;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final boolean isLive() {
        return this.isLive;
    }
}
