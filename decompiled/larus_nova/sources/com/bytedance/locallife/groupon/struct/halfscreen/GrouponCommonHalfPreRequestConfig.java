package com.bytedance.locallife.groupon.struct.halfscreen;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u0012\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/halfscreen/GrouponCommonHalfPreRequestConfig;", "", "matcher", "", "", "jumpKeepEmptyQuery", "", "appendParam", "", "(Ljava/util/Map;ZLjava/util/Map;)V", "getAppendParam", "()Ljava/util/Map;", "getJumpKeepEmptyQuery", "()Z", "getMatcher", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponCommonHalfPreRequestConfig {

    @SerializedName("append_param")
    private final Map<String, String> appendParam;

    @SerializedName("jump_keep_empty_query")
    private final boolean jumpKeepEmptyQuery;

    @SerializedName("matcher")
    private final Map<String, String> matcher;

    public GrouponCommonHalfPreRequestConfig() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponCommonHalfPreRequestConfig copy$default(GrouponCommonHalfPreRequestConfig r100, Map r101, boolean r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.matcher;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.jumpKeepEmptyQuery;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.appendParam;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, String> component1() {
        return this.matcher;
    }

    public final boolean component2() {
        return this.jumpKeepEmptyQuery;
    }

    public final Map<String, String> component3() {
        return this.appendParam;
    }

    public final GrouponCommonHalfPreRequestConfig copy(Map<String, String> r100, boolean r101, Map<String, String> r102) {
        return new GrouponCommonHalfPreRequestConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponCommonHalfPreRequestConfig) == true) goto L8;
        return false;
    L8:
        GrouponCommonHalfPreRequestConfig r101 = (GrouponCommonHalfPreRequestConfig) r100;
        if (Intrinsics.areEqual(this.matcher, r101.matcher) == true) goto L12;
        return false;
    L12:
        if (this.jumpKeepEmptyQuery == r101.jumpKeepEmptyQuery) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appendParam, r101.appendParam) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.matcher;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.jumpKeepEmptyQuery == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        Map<String, String> r106 = this.appendParam;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GrouponCommonHalfPreRequestConfig(matcher=" + this.matcher + ", jumpKeepEmptyQuery=" + this.jumpKeepEmptyQuery + ", appendParam=" + this.appendParam + ')';
    }

    public final Map<String, String> getAppendParam() {
        return this.appendParam;
    }

    public final boolean getJumpKeepEmptyQuery() {
        return this.jumpKeepEmptyQuery;
    }

    public final Map<String, String> getMatcher() {
        return this.matcher;
    }

    public GrouponCommonHalfPreRequestConfig(Map<String, String> r100, boolean r101, Map<String, String> r102) {
        this.matcher = r100;
        this.jumpKeepEmptyQuery = r101;
        this.appendParam = r102;
    }

    public /* synthetic */ GrouponCommonHalfPreRequestConfig(Map r100, boolean r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
