package com.ss.android.ugc.aweme.poi.coi;

import com.bytedance.locallife.model.poi.resp.PoiSpuStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/PoiSpuListModuleStruct;", "Ljava/io/Serializable;", "moduleTitle", "", "moduleDesc", "spuList", "", "Lcom/bytedance/locallife/model/poi/resp/PoiSpuStruct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getModuleDesc", "()Ljava/lang/String;", "getModuleTitle", "getSpuList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiSpuListModuleStruct implements Serializable {

    @SerializedName("module_desc")
    private final String moduleDesc;

    @SerializedName("module_title")
    private final String moduleTitle;

    @SerializedName("spu_list")
    private final List<PoiSpuStruct> spuList;

    public PoiSpuListModuleStruct() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiSpuListModuleStruct copy$default(PoiSpuListModuleStruct r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.moduleTitle;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.moduleDesc;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.spuList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.moduleTitle;
    }

    public final String component2() {
        return this.moduleDesc;
    }

    public final List<PoiSpuStruct> component3() {
        return this.spuList;
    }

    public final PoiSpuListModuleStruct copy(String r100, String r101, List<PoiSpuStruct> r102) {
        return new PoiSpuListModuleStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiSpuListModuleStruct) == true) goto L8;
        return false;
    L8:
        PoiSpuListModuleStruct r101 = (PoiSpuListModuleStruct) r100;
        if (Intrinsics.areEqual(this.moduleTitle, r101.moduleTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.moduleDesc, r101.moduleDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spuList, r101.spuList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.moduleTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.moduleDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<PoiSpuStruct> r107 = this.spuList;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiSpuListModuleStruct(moduleTitle=" + this.moduleTitle + ", moduleDesc=" + this.moduleDesc + ", spuList=" + this.spuList + ')';
    }

    public final String getModuleDesc() {
        return this.moduleDesc;
    }

    public final String getModuleTitle() {
        return this.moduleTitle;
    }

    public final List<PoiSpuStruct> getSpuList() {
        return this.spuList;
    }

    public PoiSpuListModuleStruct(String r100, String r101, List<PoiSpuStruct> r102) {
        this.moduleTitle = r100;
        this.moduleDesc = r101;
        this.spuList = r102;
    }

    public /* synthetic */ PoiSpuListModuleStruct(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
