package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/c;", "", "", "cardType", "I", "", "objectID", "Ljava/lang/String;", "objectName", "cardHeadText", "cardContentText", "Lt14/a;", "coverUrl", "Lt14/a;", "coverLabelUrl", "", "coverAvatarUrl", "Ljava/util/List;", "coverLabelText", "", "coverAwemeId", "Ljava/lang/Long;", "videoHeight", "videoWidth", "coverHeight", "coverWidth", "", "videoRatio", "D", "latitude", "longitude", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    @SerializedName("content_text")
    private String cardContentText;

    @SerializedName("head_text")
    private String cardHeadText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private int cardType;

    @SerializedName("cover_avatar_url")
    private List<? extends t14.a> coverAvatarUrl;

    @SerializedName("cover_aweme_id")
    private Long coverAwemeId;

    @SerializedName("cover_height")
    private int coverHeight;

    @SerializedName("cover_label_text")
    private String coverLabelText;

    @SerializedName("cover_label_url")
    private t14.a coverLabelUrl;

    @SerializedName("cover_url")
    private t14.a coverUrl;

    @SerializedName("cover_width")
    private int coverWidth;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("object_id")
    private String objectID;

    @SerializedName("object_name")
    private String objectName;

    @SerializedName("video_height")
    private int videoHeight;

    @SerializedName("video_height_width_ratio")
    private double videoRatio;

    @SerializedName("video_width")
    private int videoWidth;

    public c() {
    }
}
