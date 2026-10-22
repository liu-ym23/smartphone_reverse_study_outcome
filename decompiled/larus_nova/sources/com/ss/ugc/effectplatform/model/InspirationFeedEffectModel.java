package com.ss.ugc.effectplatform.model;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/ugc/effectplatform/model/InspirationFeedEffectModel;", "", ShareChannel.DOUYIN, "Lcom/ss/ugc/effectplatform/model/InspirationModel;", "materials", "", "Lcom/ss/ugc/effectplatform/model/MaterialModel;", "(Lcom/ss/ugc/effectplatform/model/InspirationModel;Ljava/util/List;)V", "getAweme", "()Lcom/ss/ugc/effectplatform/model/InspirationModel;", "setAweme", "(Lcom/ss/ugc/effectplatform/model/InspirationModel;)V", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class InspirationFeedEffectModel {
    private InspirationModel aweme;
    private List<MaterialModel> materials;

    /* JADX WARN: Multi-variable type inference failed */
    public InspirationFeedEffectModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InspirationFeedEffectModel copy$default(InspirationFeedEffectModel r100, InspirationModel r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.aweme;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.materials;
    L9:
        return r100.copy(r101, r102);
    }

    public final InspirationModel component1() {
        return this.aweme;
    }

    public final List<MaterialModel> component2() {
        return this.materials;
    }

    public final InspirationFeedEffectModel copy(InspirationModel r100, List<MaterialModel> r101) {
        return new InspirationFeedEffectModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InspirationFeedEffectModel) == false) goto L10;
        InspirationFeedEffectModel r101 = (InspirationFeedEffectModel) r100;
        if (Intrinsics.areEqual(this.aweme, r101.aweme) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.materials, r101.materials) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        InspirationModel r100 = this.aweme;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<MaterialModel> r104 = this.materials;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationFeedEffectModel(aweme=" + this.aweme + ", materials=" + this.materials + ")";
    }

    public final InspirationModel getAweme() {
        return this.aweme;
    }

    public final List<MaterialModel> getMaterials() {
        return this.materials;
    }

    public final void setAweme(InspirationModel r100) {
        this.aweme = r100;
    }

    public final void setMaterials(List<MaterialModel> r100) {
        this.materials = r100;
    }

    public InspirationFeedEffectModel(InspirationModel r100, List<MaterialModel> r101) {
        this.aweme = r100;
        this.materials = r101;
    }

    public /* synthetic */ InspirationFeedEffectModel(InspirationModel r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
