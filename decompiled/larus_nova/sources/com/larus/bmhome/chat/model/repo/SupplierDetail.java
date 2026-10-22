package com.larus.bmhome.chat.model.repo;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/SupplierDetail;", "", "supplierId", "", "tiles", "", "Lcom/larus/bmhome/chat/model/repo/Tile;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getSupplierId", "()Ljava/lang/String;", "getTiles", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SupplierDetail {

    @SerializedName("supplier_id")
    private final String supplierId;

    @SerializedName("tiles")
    private final List<Tile> tiles;

    /* JADX WARN: Multi-variable type inference failed */
    public SupplierDetail() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SupplierDetail copy$default(SupplierDetail r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.supplierId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tiles;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.supplierId;
    }

    public final List<Tile> component2() {
        return this.tiles;
    }

    public final SupplierDetail copy(String r100, List<Tile> r101) {
        return new SupplierDetail(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SupplierDetail) == true) goto L8;
        return false;
    L8:
        SupplierDetail r101 = (SupplierDetail) r100;
        if (Intrinsics.areEqual(this.supplierId, r101.supplierId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tiles, r101.tiles) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.supplierId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Tile> r104 = this.tiles;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SupplierDetail(supplierId=" + this.supplierId + ", tiles=" + this.tiles + ')';
    }

    public final String getSupplierId() {
        return this.supplierId;
    }

    public final List<Tile> getTiles() {
        return this.tiles;
    }

    public SupplierDetail(String r100, List<Tile> r101) {
        this.supplierId = r100;
        this.tiles = r101;
    }

    public /* synthetic */ SupplierDetail(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
