package com.larus.doc.api.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/doc/api/data/DeleteRequest;", "Ljava/io/Serializable;", "resourceId", "", "", ForwardDependency$ForwardLocation.FLAG, "", "<init>", "(Ljava/util/List;I)V", "getResourceId", "()Ljava/util/List;", "getFlag", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteRequest implements Serializable {

    @SerializedName(ForwardDependency$ForwardLocation.FLAG)
    private final int flag;

    @SerializedName("page_tokens")
    private final List<String> resourceId;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteRequest() {
        List r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteRequest copy$default(DeleteRequest r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.resourceId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.flag;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.resourceId;
    }

    public final int component2() {
        return this.flag;
    }

    public final DeleteRequest copy(List<String> r100, int r101) {
        return new DeleteRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeleteRequest) == true) goto L8;
        return false;
    L8:
        DeleteRequest r101 = (DeleteRequest) r100;
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L12;
        return false;
    L12:
        if (this.flag == r101.flag) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.resourceId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.flag;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "DeleteRequest(resourceId=" + this.resourceId + ", flag=" + this.flag + ')';
    }

    public final int getFlag() {
        return this.flag;
    }

    public final List<String> getResourceId() {
        return this.resourceId;
    }

    public DeleteRequest(List<String> r100, int r101) {
        this.resourceId = r100;
        this.flag = r101;
    }

    public /* synthetic */ DeleteRequest(List r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
