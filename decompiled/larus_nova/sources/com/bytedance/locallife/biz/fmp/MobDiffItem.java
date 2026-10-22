package com.bytedance.locallife.biz.fmp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/biz/fmp/MobDiffItem;", "Ljava/io/Serializable;", "type", "", "rec", "", "name", "nodeTag", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNodeTag", "getRec", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MobDiffItem implements Serializable {

    @SerializedName("name")
    private final String name;

    @SerializedName("nodeTag")
    private final String nodeTag;

    /* JADX INFO: renamed from: rec, reason: collision with root package name */
    @SerializedName("rec")
    private final String f256669rec;

    @SerializedName("type")
    private final int type;

    public static /* synthetic */ MobDiffItem copy$default(MobDiffItem r100, int r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f256669rec;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.name;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.nodeTag;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.f256669rec;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nodeTag;
    }

    public final MobDiffItem copy(int r100, String r101, String r102, String r103) {
        return new MobDiffItem(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MobDiffItem) == true) goto L8;
        return false;
    L8:
        MobDiffItem r101 = (MobDiffItem) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256669rec, r101.f256669rec) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.f256669rec;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.name;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.nodeTag;
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
        return "MobDiffItem(type=" + this.type + ", rec=" + this.f256669rec + ", name=" + this.name + ", nodeTag=" + this.nodeTag + ')';
    }

    public final String getName() {
        return this.name;
    }

    public final String getNodeTag() {
        return this.nodeTag;
    }

    public final String getRec() {
        return this.f256669rec;
    }

    public final int getType() {
        return this.type;
    }

    public MobDiffItem(int r100, String r101, String r102, String r103) {
        this.type = r100;
        this.f256669rec = r101;
        this.name = r102;
        this.nodeTag = r103;
    }
}
