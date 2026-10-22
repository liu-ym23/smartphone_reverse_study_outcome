package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLocalCandidate;", "Ljava/io/Serializable;", "name", "", "avatarUrl", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "recommendReason", "schema", "uid", "(Ljava/lang/String;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getName", "()Ljava/lang/String;", "getRecommendReason", "getSchema", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyLocalCandidate implements Serializable {

    @SerializedName("avatar_url")
    private final UrlModel avatarUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("recommend_reason")
    private final String recommendReason;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("uid")
    private final String uid;

    public NearbyLocalCandidate() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ NearbyLocalCandidate copy$default(NearbyLocalCandidate r100, String r101, UrlModel r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.avatarUrl;
    L8:
        UrlModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.recommendReason;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.schema;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.uid;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.name;
    }

    public final UrlModel component2() {
        return this.avatarUrl;
    }

    public final String component3() {
        return this.recommendReason;
    }

    public final String component4() {
        return this.schema;
    }

    public final String component5() {
        return this.uid;
    }

    public final NearbyLocalCandidate copy(String r100, UrlModel r101, String r110, String r111, String r112) {
        return new NearbyLocalCandidate(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyLocalCandidate) == true) goto L8;
        return false;
    L8:
        NearbyLocalCandidate r101 = (NearbyLocalCandidate) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recommendReason, r101.recommendReason) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlModel r104 = this.avatarUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.recommendReason;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.schema;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.uid;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyLocalCandidate(name=" + this.name + ", avatarUrl=" + this.avatarUrl + ", recommendReason=" + this.recommendReason + ", schema=" + this.schema + ", uid=" + this.uid + ')';
    }

    public final UrlModel getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRecommendReason() {
        return this.recommendReason;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUid() {
        return this.uid;
    }

    public NearbyLocalCandidate(String r100, UrlModel r101, String r102, String r103, String r104) {
        this.name = r100;
        this.avatarUrl = r101;
        this.recommendReason = r102;
        this.schema = r103;
        this.uid = r104;
    }

    public /* synthetic */ NearbyLocalCandidate(String r100, UrlModel r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        UrlModel r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r106 = "";
    L14:
        if ((r110 & 8) == 0) goto L16;
        String r107 = "";
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r113 = "";
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
