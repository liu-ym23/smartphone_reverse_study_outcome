package com.ss.ugc.effectplatform.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/MaterialModel;", "", "use_count", "", "sticker_data", "Lcom/ss/ugc/effectplatform/model/Effect;", "(Ljava/lang/Long;Lcom/ss/ugc/effectplatform/model/Effect;)V", "getSticker_data", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setSticker_data", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getUse_count", "()Ljava/lang/Long;", "setUse_count", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Lcom/ss/ugc/effectplatform/model/Effect;)Lcom/ss/ugc/effectplatform/model/MaterialModel;", "equals", "", "other", "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class MaterialModel {
    private Effect sticker_data;
    private Long use_count;

    /* JADX WARN: Multi-variable type inference failed */
    public MaterialModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MaterialModel copy$default(MaterialModel r100, Long r101, Effect r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.use_count;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sticker_data;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.use_count;
    }

    public final Effect component2() {
        return this.sticker_data;
    }

    public final MaterialModel copy(Long r100, Effect r101) {
        return new MaterialModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MaterialModel) == false) goto L10;
        MaterialModel r101 = (MaterialModel) r100;
        if (Intrinsics.areEqual(this.use_count, r101.use_count) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sticker_data, r101.sticker_data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Long r100 = this.use_count;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Effect r104 = this.sticker_data;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MaterialModel(use_count=" + this.use_count + ", sticker_data=" + this.sticker_data + ")";
    }

    public final Effect getSticker_data() {
        return this.sticker_data;
    }

    public final Long getUse_count() {
        return this.use_count;
    }

    public final void setSticker_data(Effect r100) {
        this.sticker_data = r100;
    }

    public final void setUse_count(Long r100) {
        this.use_count = r100;
    }

    public MaterialModel(Long r100, Effect r101) {
        this.use_count = r100;
        this.sticker_data = r101;
    }

    public /* synthetic */ MaterialModel(Long r100, Effect r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
