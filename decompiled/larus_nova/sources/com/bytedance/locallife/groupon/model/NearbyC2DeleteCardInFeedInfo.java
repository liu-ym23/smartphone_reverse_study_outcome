package com.bytedance.locallife.groupon.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/groupon/model/NearbyC2DeleteCardInFeedInfo;", "", "deleteCardId", "", "(Ljava/lang/String;)V", "getDeleteCardId", "()Ljava/lang/String;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyC2DeleteCardInFeedInfo {

    @SerializedName("delete_card_id")
    private final String deleteCardId;

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyC2DeleteCardInFeedInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getDeleteCardId() {
        return this.deleteCardId;
    }

    public NearbyC2DeleteCardInFeedInfo(String r100) {
        this.deleteCardId = r100;
    }

    public /* synthetic */ NearbyC2DeleteCardInFeedInfo(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
