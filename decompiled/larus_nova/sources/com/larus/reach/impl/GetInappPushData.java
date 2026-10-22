package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/reach/impl/GetInappPushData;", "", "pushInfoList", "", "Lcom/larus/reach/api/ReachNotify;", "<init>", "(Ljava/util/List;)V", "getPushInfoList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class GetInappPushData {

    @SerializedName("push_info_list")
    private final List<ns9.m> pushInfoList;

    /* JADX WARN: Multi-variable type inference failed */
    public GetInappPushData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetInappPushData copy$default(GetInappPushData r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.pushInfoList;
    L6:
        return r100.copy(r101);
    }

    public final List<ns9.m> component1() {
        return this.pushInfoList;
    }

    public final GetInappPushData copy(List<ns9.m> r100) {
        return new GetInappPushData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetInappPushData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.pushInfoList, ((GetInappPushData) r100).pushInfoList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ns9.m> r100 = this.pushInfoList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "GetInappPushData(pushInfoList=" + this.pushInfoList + ')';
    }

    public final List<ns9.m> getPushInfoList() {
        return this.pushInfoList;
    }

    public GetInappPushData(List<ns9.m> r100) {
        this.pushInfoList = r100;
    }

    public /* synthetic */ GetInappPushData(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
