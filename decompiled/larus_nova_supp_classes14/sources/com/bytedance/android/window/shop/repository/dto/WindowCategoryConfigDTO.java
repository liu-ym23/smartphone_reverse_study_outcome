package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0005\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "", "", "categoryTabType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "HybridTabType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowCategoryConfigDTO {

    @SerializedName("category_tab_type")
    private final Integer categoryTabType;

    @SerializedName("schema")
    private final String schema;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO$HybridTabType;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface HybridTabType {
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WindowCategoryConfigDTO) == false) goto L10;
        WindowCategoryConfigDTO r4 = (WindowCategoryConfigDTO) r3;
        if (Intrinsics.areEqual(this.categoryTabType, r4.categoryTabType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.categoryTabType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.schema;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowCategoryConfigDTO(categoryTabType=" + this.categoryTabType + ", schema=" + this.schema + ")";
    }

    public WindowCategoryConfigDTO() {
        this.categoryTabType = null;
        this.schema = null;
    }

    public final Integer a() {
        return this.categoryTabType;
    }

    public final String b() {
        return this.schema;
    }
}
