package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R>\u0010\n\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/image/q0;", "", "", "", "customParams", "Ljava/util/List;", "a", "()Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "", "isOriginImage", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "tmplType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class q0 implements x {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("is_origin_image")
    private final Boolean isOriginImage;

    @SerializedName("tmpl_type")
    private final String tmplType;

    public q0() {
        this(null, null, null, null);
    }

    public final int hashCode() {
        List<String> r0 = this.customParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HashMap<String, Object> r4 = this.finalParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isOriginImage;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tmplType;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TmplModel(customParams=" + this.customParams + ", finalParams=" + this.finalParams + ", isOriginImage=" + this.isOriginImage + ", tmplType=" + this.tmplType + ")";
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    public final String c() {
        return this.tmplType;
    }

    public final Boolean d() {
        return this.isOriginImage;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q0) == false) goto L14;
        q0 r4 = (q0) r3;
        if (Intrinsics.areEqual(this.customParams, r4.customParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.finalParams, r4.finalParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isOriginImage, r4.isOriginImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tmplType, r4.tmplType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public static q0 b(q0 r3, HashMap r4) {
        return new q0(r3.customParams, r4, r3.isOriginImage, r3.tmplType);
    }

    public q0(List<String> r1, HashMap<String, Object> r2, Boolean r3, String r4) {
        this.customParams = r1;
        this.finalParams = r2;
        this.isOriginImage = r3;
        this.tmplType = r4;
    }
}
