package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import rd3.q;
import rd3.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/ApplyAnchorRedPacketResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lrd3/r;", "feedItemAnchors", "Lrd3/r;", "getFeedItemAnchors", "()Lrd3/r;", "Lrd3/q;", "banner", "Lrd3/q;", "getBanner", "()Lrd3/q;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ApplyAnchorRedPacketResponse extends CommerceBaseResponse {

    @SerializedName("red_packet_banner")
    private final q banner;

    @SerializedName("red_packet_toast")
    private final r feedItemAnchors;

    public ApplyAnchorRedPacketResponse() {
    }

    public final q getBanner() {
        return this.banner;
    }

    public final r getFeedItemAnchors() {
        return this.feedItemAnchors;
    }
}
