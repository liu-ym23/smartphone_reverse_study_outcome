package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u00168\u0016X\u0097\u0004¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR.\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010%j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/image/b;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "cacheSize", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "reuseLevel", "f", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "", "Lcom/bytedance/android/shopping/api/image/o0;", "supportTemplates", "Ljava/util/Map;", "k", "()Ljava/util/Map;", "", "supportReuseImageCache", "Ljava/lang/Boolean;", "i", "()Ljava/lang/Boolean;", "supportReuseImageCacheForThumb", "j", "supportReuseBitmap", "h", "matchersType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "ignoreMatch", "c", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ignoreReuseOptBizTag", "Ljava/util/HashSet;", "b", "()Ljava/util/HashSet;", "ignoreThumbOptBizTag", "d", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b implements d.b {

    @SerializedName("cache_size")
    private final Integer cacheSize;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("ignore_reuse_opt_biz_tags")
    private final HashSet<String> ignoreReuseOptBizTag;

    @SerializedName("ignore_thumb_opt_biz_tags")
    private final HashSet<String> ignoreThumbOptBizTag;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("reuse_level")
    private final Integer reuseLevel;

    @SerializedName("support_mather")
    private final List<d> supportMather;

    @SerializedName("support_reuse_bitmap")
    private final Boolean supportReuseBitmap;

    @SerializedName("support_reuse_image_cache")
    private final Boolean supportReuseImageCache;

    @SerializedName("support_reuse_image_cache_for_thumb")
    private final Boolean supportReuseImageCacheForThumb;

    @SerializedName("support_templates")
    private final Map<String, o0> supportTemplates;

    public b() {
        this(null);
    }

    public final int hashCode() {
        Integer r0 = this.cacheSize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.reuseLevel;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<d> r7 = this.supportMather;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, o0> r10 = this.supportTemplates;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.supportReuseImageCache;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.supportReuseImageCacheForThumb;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.supportReuseBitmap;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.matchersType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.ignoreMatch;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        HashSet<String> r28 = this.ignoreReuseOptBizTag;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        HashSet<String> r31 = this.ignoreThumbOptBizTag;
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
        return "ECImageMultiReuseModel(cacheSize=" + this.cacheSize + ", reuseLevel=" + this.reuseLevel + ", supportMather=" + this.supportMather + ", supportTemplates=" + this.supportTemplates + ", supportReuseImageCache=" + this.supportReuseImageCache + ", supportReuseImageCacheForThumb=" + this.supportReuseImageCacheForThumb + ", supportReuseBitmap=" + this.supportReuseBitmap + ", matchersType=" + this.matchersType + ", ignoreMatch=" + this.ignoreMatch + ", ignoreReuseOptBizTag=" + this.ignoreReuseOptBizTag + ", ignoreThumbOptBizTag=" + this.ignoreThumbOptBizTag + ")";
    }

    public final Integer a() {
        return this.cacheSize;
    }

    public final HashSet<String> b() {
        return this.ignoreReuseOptBizTag;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    public final HashSet<String> d() {
        return this.ignoreThumbOptBizTag;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    public final Integer f() {
        return this.reuseLevel;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public final Boolean h() {
        return this.supportReuseBitmap;
    }

    public final Boolean i() {
        return this.supportReuseImageCache;
    }

    public final Boolean j() {
        return this.supportReuseImageCacheForThumb;
    }

    public final Map<String, o0> k() {
        return this.supportTemplates;
    }

    public b(Object r1) {
        this.cacheSize = null;
        this.reuseLevel = null;
        this.supportMather = null;
        this.supportTemplates = null;
        this.supportReuseImageCache = null;
        this.supportReuseImageCacheForThumb = null;
        this.supportReuseBitmap = null;
        this.matchersType = null;
        this.ignoreMatch = null;
        this.ignoreReuseOptBizTag = null;
        this.ignoreThumbOptBizTag = null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L28;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.cacheSize, r4.cacheSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reuseLevel, r4.reuseLevel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportMather, r4.supportMather) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.supportTemplates, r4.supportTemplates) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.supportReuseImageCache, r4.supportReuseImageCache) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.supportReuseImageCacheForThumb, r4.supportReuseImageCacheForThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportReuseBitmap, r4.supportReuseBitmap) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.matchersType, r4.matchersType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ignoreMatch, r4.ignoreMatch) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ignoreReuseOptBizTag, r4.ignoreReuseOptBizTag) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.ignoreThumbOptBizTag, r4.ignoreThumbOptBizTag) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }
}
