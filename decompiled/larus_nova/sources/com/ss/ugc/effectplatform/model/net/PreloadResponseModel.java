package com.ss.ugc.effectplatform.model.net;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019JD\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadResponseModel;", "", "preload_resource_list", "", "Lcom/ss/ugc/effectplatform/model/net/PreloadResourceList;", "delete_cmd", "Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "busi_info", "Lcom/ss/ugc/effectplatform/model/net/Busi_info;", "protection_period", "", "(Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;Lcom/ss/ugc/effectplatform/model/net/Busi_info;Ljava/lang/Long;)V", "getBusi_info", "()Lcom/ss/ugc/effectplatform/model/net/Busi_info;", "setBusi_info", "(Lcom/ss/ugc/effectplatform/model/net/Busi_info;)V", "getDelete_cmd", "()Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "setDelete_cmd", "(Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;)V", "getPreload_resource_list", "()Ljava/util/List;", "setPreload_resource_list", "(Ljava/util/List;)V", "getProtection_period", "()Ljava/lang/Long;", "setProtection_period", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;Lcom/ss/ugc/effectplatform/model/net/Busi_info;Ljava/lang/Long;)Lcom/ss/ugc/effectplatform/model/net/PreloadResponseModel;", "equals", "", "other", "hashCode", "", "toString", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadResponseModel {
    private Busi_info busi_info;
    private DeleteCmd delete_cmd;
    private List<PreloadResourceList> preload_resource_list;
    private Long protection_period;

    public PreloadResponseModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadResponseModel copy$default(PreloadResponseModel r100, List r101, DeleteCmd r102, Busi_info r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.preload_resource_list;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.delete_cmd;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.busi_info;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.protection_period;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<PreloadResourceList> component1() {
        return this.preload_resource_list;
    }

    public final DeleteCmd component2() {
        return this.delete_cmd;
    }

    public final Busi_info component3() {
        return this.busi_info;
    }

    public final Long component4() {
        return this.protection_period;
    }

    public final PreloadResponseModel copy(List<PreloadResourceList> r100, DeleteCmd r101, Busi_info r102, Long r103) {
        return new PreloadResponseModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreloadResponseModel) == false) goto L14;
        PreloadResponseModel r101 = (PreloadResponseModel) r100;
        if (Intrinsics.areEqual(this.preload_resource_list, r101.preload_resource_list) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.delete_cmd, r101.delete_cmd) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.busi_info, r101.busi_info) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.protection_period, r101.protection_period) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<PreloadResourceList> r100 = this.preload_resource_list;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DeleteCmd r104 = this.delete_cmd;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Busi_info r107 = this.busi_info;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.protection_period;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PreloadResponseModel(preload_resource_list=" + this.preload_resource_list + ", delete_cmd=" + this.delete_cmd + ", busi_info=" + this.busi_info + ", protection_period=" + this.protection_period + ")";
    }

    public final Busi_info getBusi_info() {
        return this.busi_info;
    }

    public final DeleteCmd getDelete_cmd() {
        return this.delete_cmd;
    }

    public final List<PreloadResourceList> getPreload_resource_list() {
        return this.preload_resource_list;
    }

    public final Long getProtection_period() {
        return this.protection_period;
    }

    public final void setBusi_info(Busi_info r100) {
        this.busi_info = r100;
    }

    public final void setDelete_cmd(DeleteCmd r100) {
        this.delete_cmd = r100;
    }

    public final void setPreload_resource_list(List<PreloadResourceList> r100) {
        this.preload_resource_list = r100;
    }

    public final void setProtection_period(Long r100) {
        this.protection_period = r100;
    }

    public PreloadResponseModel(List<PreloadResourceList> r100, DeleteCmd r101, Busi_info r102, Long r103) {
        this.preload_resource_list = r100;
        this.delete_cmd = r101;
        this.busi_info = r102;
        this.protection_period = r103;
    }

    public /* synthetic */ PreloadResponseModel(List r100, DeleteCmd r101, Busi_info r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0L;
    L14:
        this(r100, r101, r102, r103);
    }
}
