package com.ss.ugc.effectplatform.model.net;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "", "busi_key_list", "", "", "resource_key_list", "(Ljava/util/List;Ljava/util/List;)V", "getBusi_key_list", "()Ljava/util/List;", "setBusi_key_list", "(Ljava/util/List;)V", "getResource_key_list", "setResource_key_list", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class DeleteCmd {
    private List<String> busi_key_list;
    private List<String> resource_key_list;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteCmd() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteCmd copy$default(DeleteCmd r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.busi_key_list;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.resource_key_list;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.busi_key_list;
    }

    public final List<String> component2() {
        return this.resource_key_list;
    }

    public final DeleteCmd copy(List<String> r100, List<String> r101) {
        return new DeleteCmd(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DeleteCmd) == false) goto L10;
        DeleteCmd r101 = (DeleteCmd) r100;
        if (Intrinsics.areEqual(this.busi_key_list, r101.busi_key_list) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resource_key_list, r101.resource_key_list) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.busi_key_list;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.resource_key_list;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DeleteCmd(busi_key_list=" + this.busi_key_list + ", resource_key_list=" + this.resource_key_list + ")";
    }

    public final List<String> getBusi_key_list() {
        return this.busi_key_list;
    }

    public final List<String> getResource_key_list() {
        return this.resource_key_list;
    }

    public final void setBusi_key_list(List<String> r100) {
        this.busi_key_list = r100;
    }

    public final void setResource_key_list(List<String> r100) {
        this.resource_key_list = r100;
    }

    public DeleteCmd(List<String> r100, List<String> r101) {
        this.busi_key_list = r100;
        this.resource_key_list = r101;
    }

    public /* synthetic */ DeleteCmd(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
