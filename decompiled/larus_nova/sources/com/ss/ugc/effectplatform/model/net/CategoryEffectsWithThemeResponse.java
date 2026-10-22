package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;", "", "component2", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component3", "data", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;)V", "Ljava/lang/String;", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class CategoryEffectsWithThemeResponse extends e<CategoryEffectsWithThemeData> {
    private CategoryEffectsWithThemeData data;
    private String message;
    private int status_code;

    public CategoryEffectsWithThemeResponse() {
        this(null, null, 0, 7, null);
    }

    private final String component2() {
        return this.message;
    }

    public static /* synthetic */ CategoryEffectsWithThemeResponse copy$default(CategoryEffectsWithThemeResponse r100, CategoryEffectsWithThemeData r101, String r102, int r103, int r104, Object r105) {
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

    public final CategoryEffectsWithThemeData component1() {
        return this.data;
    }

    public final int component3() {
        return this.status_code;
    }

    public final CategoryEffectsWithThemeResponse copy(CategoryEffectsWithThemeData r100, String r101, int r102) {
        return new CategoryEffectsWithThemeResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CategoryEffectsWithThemeResponse) == false) goto L12;
        CategoryEffectsWithThemeResponse r101 = (CategoryEffectsWithThemeResponse) r100;
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
        CategoryEffectsWithThemeData r100 = this.data;
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
        return "CategoryEffectsWithThemeResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        CategoryEffectsWithThemeData r100 = this.data;
        if (r100 == null) goto L14;
        CategoryEffect r101 = r100.category_effects_theme;
        if (r101 == null) goto L14;
        List<? extends Effect> r102 = r101.collection;
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (b.a((Effect) r103.next()) == true) goto L10;
        return false;
    L14:
        CategoryEffectsWithThemeData r104 = this.data;
        if (r104 == null) goto L26;
        CategoryEffect r105 = r104.category_effects_theme;
        if (r105 == null) goto L26;
        List<? extends Effect> r106 = r105.bind_effects;
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        if (b.a((Effect) r107.next()) == true) goto L22;
        return false;
    L26:
        CategoryEffectsWithThemeData r108 = this.data;
        if (r108 == null) goto L35;
        CategoryEffect r109 = r108.category_effects_theme;
        if (r109 == null) goto L43;
        Effect r110 = r109.effects;
        if (r110 != null) goto L33;
        return true;
    L33:
        if (b.a(r110) == true) goto L45;
        return false;
    L45:
        return true;
    L43:
        return true;
    L35:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ CategoryEffectsWithThemeData getResponseData() {
        return getResponseData();
    }

    public final CategoryEffectsWithThemeData getData() {
        return this.data;
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
    public CategoryEffectsWithThemeData getResponseData() {
        return this.data;
    }

    public final void setData(CategoryEffectsWithThemeData r100) {
        this.data = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public CategoryEffectsWithThemeResponse(CategoryEffectsWithThemeData r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ CategoryEffectsWithThemeResponse(CategoryEffectsWithThemeData r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
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
