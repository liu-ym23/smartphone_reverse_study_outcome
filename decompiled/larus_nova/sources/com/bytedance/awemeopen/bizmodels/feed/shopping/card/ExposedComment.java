package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ExposedComment;", "Ljava/io/Serializable;", "id", "", "content", "", "count", "rank", "", "goodRate", "(JLjava/lang/String;JIJ)V", "getContent", "()Ljava/lang/String;", "getCount", "()J", "getGoodRate", "getId", "getRank", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExposedComment implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("count")
    private final long count;

    @SerializedName("good_rate")
    private final long goodRate;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f198199id;

    @SerializedName("rank")
    private final int rank;

    public static /* synthetic */ ExposedComment copy$default(ExposedComment r100, long r110, String r111, long r112, int r113, long r114, int r115, Object r116) {
        if ((r115 & 1) == 0) goto L5;
        long r101 = r100.f198199id;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r102 = r100.content;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r103 = r100.count;
    L15:
        if ((r115 & 8) == 0) goto L17;
        int r104 = r100.rank;
    L19:
        if ((r115 & 16) == 0) goto L21;
        long r105 = r100.goodRate;
    L23:
        return r100.copy(r101, r102, r103, r104, r105);
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final long component1() {
        return this.f198199id;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.count;
    }

    public final int component4() {
        return this.rank;
    }

    public final long component5() {
        return this.goodRate;
    }

    public final ExposedComment copy(long r110, String r111, long r112, int r113, long r114) {
        return new ExposedComment(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExposedComment) == true) goto L8;
        return false;
    L8:
        ExposedComment r101 = (ExposedComment) r100;
        if (this.f198199id == r101.f198199id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (this.count == r101.count) goto L18;
        return false;
    L18:
        if (this.rank == r101.rank) goto L21;
        return false;
    L21:
        if (this.goodRate == r101.goodRate) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        long r100 = this.f198199id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.content;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.count;
        int r105 = (((((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.rank) * 31;
        long r106 = this.goodRate;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "ExposedComment(id=" + this.f198199id + ", content=" + this.content + ", count=" + this.count + ", rank=" + this.rank + ", goodRate=" + this.goodRate + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCount() {
        return this.count;
    }

    public final long getGoodRate() {
        return this.goodRate;
    }

    public final long getId() {
        return this.f198199id;
    }

    public final int getRank() {
        return this.rank;
    }

    public ExposedComment(long r100, String r101, long r102, int r103, long r104) {
        this.f198199id = r100;
        this.content = r101;
        this.count = r102;
        this.rank = r103;
        this.goodRate = r104;
    }

    public /* synthetic */ ExposedComment(long r110, String r111, long r112, int r113, long r114, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = 0;
    L18:
        this(r100, r101, r102, r103, r114);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
