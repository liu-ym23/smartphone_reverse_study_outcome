package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR:\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R:\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/api/image/p0;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "imgFormats", "Ljava/util/HashSet;", "d", "()Ljava/util/HashSet;", "alphaFormats", "a", "Ljava/util/HashMap;", "Lcom/bytedance/android/shopping/api/image/g0;", "Lkotlin/collections/HashMap;", "originTemplates", "Ljava/util/HashMap;", "e", "()Ljava/util/HashMap;", "", "Lcom/bytedance/android/shopping/api/image/i0;", "replaceObjTemplates", "Ljava/util/List;", "h", "()Ljava/util/List;", "replaceEmptyTemplates", "f", "Lcom/bytedance/android/shopping/api/image/j0;", "replaceOldTemplates", "i", "Lcom/bytedance/android/shopping/api/image/k0;", "replaceSpecialResizeTemplates", "j", "Lcom/bytedance/android/shopping/api/image/q0;", "ecCommonTemplates", "b", "Lcom/bytedance/android/shopping/api/image/g;", "replaceFormats", "g", "Lcom/bytedance/android/shopping/api/image/h0;", "replaceQuality", "getReplaceQuality", "", "enableUnifiedFlag", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("img_alpha_formats")
    private final HashSet<String> alphaFormats;

    @SerializedName("ec_common_templates")
    private final HashMap<String, q0> ecCommonTemplates;

    @SerializedName("enable_unified_flag")
    private final Boolean enableUnifiedFlag;

    @SerializedName("img_static_formats")
    private final HashSet<String> imgFormats;

    @SerializedName("origin_templates")
    private final HashMap<String, g0> originTemplates;

    @SerializedName("replace_empty_templates")
    private final List<i0> replaceEmptyTemplates;

    @SerializedName("replace_format")
    private final List<g> replaceFormats;

    @SerializedName("replace_obj_templates")
    private final List<i0> replaceObjTemplates;

    @SerializedName("replace_old_templates")
    private final HashMap<String, j0> replaceOldTemplates;

    @SerializedName("replace_quality")
    private final List<h0> replaceQuality;

    @SerializedName("replace_special_resize_templates")
    private final List<k0> replaceSpecialResizeTemplates;

    public p0() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p0) == false) goto L28;
        p0 r4 = (p0) r3;
        if (Intrinsics.areEqual(this.imgFormats, r4.imgFormats) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.alphaFormats, r4.alphaFormats) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originTemplates, r4.originTemplates) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replaceObjTemplates, r4.replaceObjTemplates) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.replaceEmptyTemplates, r4.replaceEmptyTemplates) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.replaceOldTemplates, r4.replaceOldTemplates) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.replaceSpecialResizeTemplates, r4.replaceSpecialResizeTemplates) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecCommonTemplates, r4.ecCommonTemplates) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.replaceFormats, r4.replaceFormats) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.replaceQuality, r4.replaceQuality) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.enableUnifiedFlag, r4.enableUnifiedFlag) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        HashSet<String> r0 = this.imgFormats;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HashSet<String> r4 = this.alphaFormats;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, g0> r7 = this.originTemplates;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<i0> r10 = this.replaceObjTemplates;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<i0> r13 = this.replaceEmptyTemplates;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        HashMap<String, j0> r16 = this.replaceOldTemplates;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<k0> r19 = this.replaceSpecialResizeTemplates;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        HashMap<String, q0> r22 = this.ecCommonTemplates;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<g> r25 = this.replaceFormats;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<h0> r28 = this.replaceQuality;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.enableUnifiedFlag;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
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
        return "TmplConvModel(imgFormats=" + this.imgFormats + ", alphaFormats=" + this.alphaFormats + ", originTemplates=" + this.originTemplates + ", replaceObjTemplates=" + this.replaceObjTemplates + ", replaceEmptyTemplates=" + this.replaceEmptyTemplates + ", replaceOldTemplates=" + this.replaceOldTemplates + ", replaceSpecialResizeTemplates=" + this.replaceSpecialResizeTemplates + ", ecCommonTemplates=" + this.ecCommonTemplates + ", replaceFormats=" + this.replaceFormats + ", replaceQuality=" + this.replaceQuality + ", enableUnifiedFlag=" + this.enableUnifiedFlag + ")";
    }

    public final HashSet<String> a() {
        return this.alphaFormats;
    }

    public final HashMap<String, q0> b() {
        return this.ecCommonTemplates;
    }

    public final Boolean c() {
        return this.enableUnifiedFlag;
    }

    public final HashSet<String> d() {
        return this.imgFormats;
    }

    public final HashMap<String, g0> e() {
        return this.originTemplates;
    }

    public final List<i0> f() {
        return this.replaceEmptyTemplates;
    }

    public final List<g> g() {
        return this.replaceFormats;
    }

    public final List<i0> h() {
        return this.replaceObjTemplates;
    }

    public final HashMap<String, j0> i() {
        return this.replaceOldTemplates;
    }

    public final List<k0> j() {
        return this.replaceSpecialResizeTemplates;
    }

    public p0(Object r1) {
        this.imgFormats = null;
        this.alphaFormats = null;
        this.originTemplates = null;
        this.replaceObjTemplates = null;
        this.replaceEmptyTemplates = null;
        this.replaceOldTemplates = null;
        this.replaceSpecialResizeTemplates = null;
        this.ecCommonTemplates = null;
        this.replaceFormats = null;
        this.replaceQuality = null;
        this.enableUnifiedFlag = null;
    }
}
