package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;", "", "double_check_enable", "", "double_check_url", "", "double_check_param", "(ILjava/lang/String;Ljava/lang/String;)V", "getDouble_check_enable", "()I", "getDouble_check_param", "()Ljava/lang/String;", "getDouble_check_url", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponGuideDoubleCheckConfig {

    @SerializedName("double_check_enable")
    private final int double_check_enable;

    @SerializedName("double_check_param")
    private final String double_check_param;

    @SerializedName("double_check_url")
    private final String double_check_url;

    public GrouponGuideDoubleCheckConfig() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ GrouponGuideDoubleCheckConfig copy$default(GrouponGuideDoubleCheckConfig r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.double_check_enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.double_check_url;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.double_check_param;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.double_check_enable;
    }

    public final String component2() {
        return this.double_check_url;
    }

    public final String component3() {
        return this.double_check_param;
    }

    public final GrouponGuideDoubleCheckConfig copy(int r100, String r101, String r102) {
        return new GrouponGuideDoubleCheckConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponGuideDoubleCheckConfig) == true) goto L8;
        return false;
    L8:
        GrouponGuideDoubleCheckConfig r101 = (GrouponGuideDoubleCheckConfig) r100;
        if (this.double_check_enable == r101.double_check_enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.double_check_url, r101.double_check_url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.double_check_param, r101.double_check_param) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.double_check_enable * 31;
        String r101 = this.double_check_url;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.double_check_param;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GrouponGuideDoubleCheckConfig(double_check_enable=" + this.double_check_enable + ", double_check_url=" + this.double_check_url + ", double_check_param=" + this.double_check_param + ')';
    }

    public final int getDouble_check_enable() {
        return this.double_check_enable;
    }

    public final String getDouble_check_param() {
        return this.double_check_param;
    }

    public final String getDouble_check_url() {
        return this.double_check_url;
    }

    public GrouponGuideDoubleCheckConfig(int r100, String r101, String r102) {
        this.double_check_enable = r100;
        this.double_check_url = r101;
        this.double_check_param = r102;
    }

    public /* synthetic */ GrouponGuideDoubleCheckConfig(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
