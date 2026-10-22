package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010%R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoPagingCheckedResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "component3", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "component1", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "component2", "component4", "PanelInfoResponse", "CategoryEffectsResponse", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "getPanelInfoResponse", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "setPanelInfoResponse", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;)V", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "getCategoryEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "setCategoryEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "Ljava/lang/String;", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoPagingCheckedResponse extends e<PanelInfoModel> {
    private CategoryEffectListResponse CategoryEffectsResponse;
    private PanelInfoCheckedResponse PanelInfoResponse;
    private String message;
    private int status_code;

    public PanelInfoPagingCheckedResponse() {
        this(null, null, null, 0, 15, null);
    }

    private final String component3() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoPagingCheckedResponse copy$default(PanelInfoPagingCheckedResponse r100, PanelInfoCheckedResponse r101, CategoryEffectListResponse r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.PanelInfoResponse;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.CategoryEffectsResponse;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.message;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.status_code;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PanelInfoCheckedResponse component1() {
        return this.PanelInfoResponse;
    }

    public final CategoryEffectListResponse component2() {
        return this.CategoryEffectsResponse;
    }

    public final int component4() {
        return this.status_code;
    }

    public final PanelInfoPagingCheckedResponse copy(PanelInfoCheckedResponse r100, CategoryEffectListResponse r101, String r102, int r103) {
        return new PanelInfoPagingCheckedResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PanelInfoPagingCheckedResponse) == false) goto L14;
        PanelInfoPagingCheckedResponse r101 = (PanelInfoPagingCheckedResponse) r100;
        if (Intrinsics.areEqual(this.PanelInfoResponse, r101.PanelInfoResponse) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.CategoryEffectsResponse, r101.CategoryEffectsResponse) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
        return false;
    L12:
        if (this.status_code == r101.status_code) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        PanelInfoCheckedResponse r100 = this.PanelInfoResponse;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CategoryEffectListResponse r104 = this.CategoryEffectsResponse;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.message;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.status_code;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PanelInfoPagingCheckedResponse(PanelInfoResponse=" + this.PanelInfoResponse + ", CategoryEffectsResponse=" + this.CategoryEffectsResponse + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        PanelInfoCheckedResponse r100 = this.PanelInfoResponse;
        if (r100 == null) goto L18;
        PanelInfoModel r101 = null;
        if (r100 == null) goto L8;
        Boolean r102 = r100.getUpdated();
    L10:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L15;
        PanelInfoCheckedResponse r103 = this.PanelInfoResponse;
        if (r103 == null) goto L14;
        r101 = r103.getData();
    L14:
        if (r101 != null) goto L15;
        return false;
    L15:
        return true;
    L8:
        r102 = null;
        goto L10
    L18:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public PanelInfoModel getResponseData() {
        return new PanelInfoPagingCheckedModel(this.PanelInfoResponse, this.CategoryEffectsResponse).getPanelInfo();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        PanelInfoCheckedResponse r100 = this.PanelInfoResponse;
        if (r100 == null) goto L16;
        PanelInfoModel r101 = r100.getData();
        if (r101 == null) goto L16;
        CategoryEffectModel r102 = r101.getCategory_effects();
        if (r102 == null) goto L16;
        List<Effect> r103 = r102.getCollection();
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        if (b.a((Effect) r104.next()) == true) goto L12;
        return false;
    L16:
        PanelInfoCheckedResponse r105 = this.PanelInfoResponse;
        if (r105 == null) goto L30;
        PanelInfoModel r106 = r105.getData();
        if (r106 == null) goto L30;
        CategoryEffectModel r107 = r106.getCategory_effects();
        if (r107 == null) goto L30;
        List<Effect> r108 = r107.getBind_effects();
        if (r108 == null) goto L30;
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L30;
        if (b.a((Effect) r109.next()) == true) goto L26;
        return false;
    L30:
        PanelInfoCheckedResponse r110 = this.PanelInfoResponse;
        if (r110 == null) goto L44;
        PanelInfoModel r111 = r110.getData();
        if (r111 == null) goto L55;
        CategoryEffectModel r112 = r111.getCategory_effects();
        if (r112 == null) goto L56;
        List<Effect> r113 = r112.getCategory_effects();
        if (r113 == null) goto L57;
        Iterator<T> r114 = r113.iterator();
    L40:
        if (r114.hasNext() == false) goto L58;
        if (b.a((Effect) r114.next()) == true) goto L40;
        return false;
    L58:
        return true;
    L57:
        return true;
    L56:
        return true;
    L55:
        return true;
    L44:
        return true;
    }

    public final CategoryEffectListResponse getCategoryEffectsResponse() {
        return this.CategoryEffectsResponse;
    }

    public final PanelInfoCheckedResponse getPanelInfoResponse() {
        return this.PanelInfoResponse;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ PanelInfoModel getResponseData() {
        return getResponseData();
    }

    public final void setCategoryEffectsResponse(CategoryEffectListResponse r100) {
        this.CategoryEffectsResponse = r100;
    }

    public final void setPanelInfoResponse(PanelInfoCheckedResponse r100) {
        this.PanelInfoResponse = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public PanelInfoPagingCheckedResponse(PanelInfoCheckedResponse r100, CategoryEffectListResponse r101, String r102, int r103) {
        this.PanelInfoResponse = r100;
        this.CategoryEffectsResponse = r101;
        this.message = r102;
        this.status_code = r103;
    }

    public /* synthetic */ PanelInfoPagingCheckedResponse(PanelInfoCheckedResponse r100, CategoryEffectListResponse r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
