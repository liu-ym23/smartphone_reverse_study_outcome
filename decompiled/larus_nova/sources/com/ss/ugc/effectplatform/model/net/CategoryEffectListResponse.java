package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component2", "component3", "data", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class CategoryEffectListResponse extends e<CategoryPageModel> {
    private CategoryPageModel data;
    private String message;
    private int status_code;

    public CategoryEffectListResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ CategoryEffectListResponse copy$default(CategoryEffectListResponse r100, CategoryPageModel r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status_code;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final CategoryPageModel component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final CategoryEffectListResponse copy(CategoryPageModel r100, String r101, int r102) {
        return new CategoryEffectListResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CategoryEffectListResponse) == false) goto L12;
        CategoryEffectListResponse r101 = (CategoryEffectListResponse) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        CategoryPageModel r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.status_code;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CategoryEffectListResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        CategoryPageModel r100 = this.data;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getCategory_effects() == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        CategoryPageModel r100 = this.data;
        if (r100 == null) goto L14;
        CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L14;
        List<Effect> r102 = r101.getCollection();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (b.a((Effect) r103.next()) == true) goto L10;
        return false;
    L14:
        CategoryPageModel r104 = this.data;
        if (r104 == null) goto L26;
        CategoryEffectModel r105 = r104.getCategory_effects();
        if (r105 == null) goto L26;
        List<Effect> r106 = r105.getBind_effects();
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        if (b.a((Effect) r107.next()) == true) goto L22;
        return false;
    L26:
        CategoryPageModel r108 = this.data;
        if (r108 == null) goto L38;
        CategoryEffectModel r109 = r108.getCategory_effects();
        if (r109 == null) goto L49;
        List<Effect> r110 = r109.getCategory_effects();
        if (r110 == null) goto L50;
        Iterator<T> r111 = r110.iterator();
    L34:
        if (r111.hasNext() == false) goto L51;
        if (b.a((Effect) r111.next()) == true) goto L34;
        return false;
    L51:
        return true;
    L50:
        return true;
    L49:
        return true;
    L38:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ CategoryPageModel getResponseData() {
        return getResponseData();
    }

    public final CategoryPageModel getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public CategoryPageModel getResponseData() {
        return this.data;
    }

    public final void setData(CategoryPageModel r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public CategoryEffectListResponse(CategoryPageModel r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ CategoryEffectListResponse(CategoryPageModel r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
