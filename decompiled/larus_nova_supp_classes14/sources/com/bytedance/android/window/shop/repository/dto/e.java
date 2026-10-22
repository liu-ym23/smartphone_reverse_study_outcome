package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/e;", "", "", "rankId", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "rankText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "rankSchema", "b", "trackId", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("rank_id")
    private final Integer rankId;

    @SerializedName("rank_schema")
    private final String rankSchema;

    @SerializedName("rank_text")
    private final String rankText;

    @SerializedName("track_id")
    private final Integer trackId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.rankId, r4.rankId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rankText, r4.rankText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rankSchema, r4.rankSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trackId, r4.trackId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.rankId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.rankText;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.rankSchema;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.trackId;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PopularRankInfoDTO(rankId=" + this.rankId + ", rankText=" + this.rankText + ", rankSchema=" + this.rankSchema + ", trackId=" + this.trackId + ")";
    }

    public e() {
        this.rankId = null;
        this.rankText = null;
        this.rankSchema = null;
        this.trackId = null;
    }

    public final Integer a() {
        return this.rankId;
    }

    public final String b() {
        return this.rankSchema;
    }

    public final String c() {
        return this.rankText;
    }

    public final Integer d() {
        return this.trackId;
    }
}
