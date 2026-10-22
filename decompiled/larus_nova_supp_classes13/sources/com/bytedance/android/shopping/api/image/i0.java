package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR>\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/image/i0;", "Lcom/bytedance/android/shopping/api/image/x;", "Lcom/bytedance/android/shopping/api/image/w;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "targetServiceId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "targetTemplateName", "d", "customParams", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "matchersType", "g", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class i0 implements x, w, d.b {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("contents")
    private final List<d> supportMather;

    @SerializedName("target_service_id")
    private final String targetServiceId;

    @SerializedName("target_template")
    private final String targetTemplateName;

    public final int hashCode() {
        List<d> r0 = this.supportMather;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.targetServiceId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.targetTemplateName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.customParams;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        HashMap<String, Object> r13 = this.finalParams;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.matchersType;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.ignoreMatch;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "ReplaceObjTmplModel(supportMather=" + this.supportMather + ", targetServiceId=" + this.targetServiceId + ", targetTemplateName=" + this.targetTemplateName + ", customParams=" + this.customParams + ", finalParams=" + this.finalParams + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ")";
    }

    public i0() {
        this.supportMather = null;
        this.targetServiceId = null;
        this.targetTemplateName = null;
        this.customParams = null;
        this.finalParams = null;
        this.matchersType = null;
        this.ignoreMatch = null;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String b() {
        return this.targetServiceId;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    @Override // com.bytedance.android.shopping.api.image.w
    public final String d() {
        return this.targetTemplateName;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i0) == false) goto L20;
        i0 r4 = (i0) r3;
        if (Intrinsics.areEqual(this.supportMather, r4.supportMather) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetServiceId, r4.targetServiceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.targetTemplateName, r4.targetTemplateName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customParams, r4.customParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.finalParams, r4.finalParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.matchersType, r4.matchersType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ignoreMatch, r4.ignoreMatch) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }
}
