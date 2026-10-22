package com.bytedance.locallife.groupon.struct;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;", "", ReportConstant.COMMON_ACTION_TYPE, "", "actionParam", "", "pollingLimit", "pollingInterval", "actionApiUrl", "(ILjava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)V", "getActionApiUrl", "()Ljava/lang/String;", "getActionParam", "getActionType", "()I", "getPollingInterval", "getPollingLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponBubbleDotOnShowAction {

    @SerializedName("action_api_url")
    private final String actionApiUrl;

    @SerializedName("action_param")
    private final String actionParam;

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName("polling_interval")
    private final int pollingInterval;

    @SerializedName("polling_limit")
    private final Integer pollingLimit;

    public GrouponBubbleDotOnShowAction() {
        this(0, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ GrouponBubbleDotOnShowAction copy$default(GrouponBubbleDotOnShowAction r100, int r101, String r102, Integer r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.actionType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.actionParam;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.pollingLimit;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.pollingInterval;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.actionApiUrl;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.actionType;
    }

    public final String component2() {
        return this.actionParam;
    }

    public final Integer component3() {
        return this.pollingLimit;
    }

    public final int component4() {
        return this.pollingInterval;
    }

    public final String component5() {
        return this.actionApiUrl;
    }

    public final GrouponBubbleDotOnShowAction copy(int r100, String r101, Integer r110, int r111, String r112) {
        return new GrouponBubbleDotOnShowAction(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponBubbleDotOnShowAction) == true) goto L8;
        return false;
    L8:
        GrouponBubbleDotOnShowAction r101 = (GrouponBubbleDotOnShowAction) r100;
        if (this.actionType == r101.actionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionParam, r101.actionParam) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pollingLimit, r101.pollingLimit) == true) goto L18;
        return false;
    L18:
        if (this.pollingInterval == r101.pollingInterval) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionApiUrl, r101.actionApiUrl) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.actionType * 31;
        String r101 = this.actionParam;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.pollingLimit;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.pollingInterval) * 31;
        String r108 = this.actionApiUrl;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GrouponBubbleDotOnShowAction(actionType=" + this.actionType + ", actionParam=" + this.actionParam + ", pollingLimit=" + this.pollingLimit + ", pollingInterval=" + this.pollingInterval + ", actionApiUrl=" + this.actionApiUrl + ')';
    }

    public final String getActionApiUrl() {
        return this.actionApiUrl;
    }

    public final String getActionParam() {
        return this.actionParam;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final int getPollingInterval() {
        return this.pollingInterval;
    }

    public final Integer getPollingLimit() {
        return this.pollingLimit;
    }

    public GrouponBubbleDotOnShowAction(int r100, String r101, Integer r102, int r103, String r104) {
        this.actionType = r100;
        this.actionParam = r101;
        this.pollingLimit = r102;
        this.pollingInterval = r103;
        this.actionApiUrl = r104;
    }

    public /* synthetic */ GrouponBubbleDotOnShowAction(int r100, String r101, Integer r102, int r103, String r104, int r110, DefaultConstructorMarker r111) {
        int r105 = 0;
        if ((r110 & 1) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = 1000;
    L13:
        Integer r107 = r102;
        if ((r110 & 8) != 0) goto L18;
        r105 = r103;
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r113 = "";
    L21:
        this(r112, r106, r107, r105, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
