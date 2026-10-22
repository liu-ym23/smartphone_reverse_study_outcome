package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u000274R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR.\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\"\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b.\u0010,R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\"\u00101\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\"\u00103\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u0010,R\"\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bD\u0010\u0004\u0012\u0004\bF\u0010G\u001a\u0004\bE\u0010\u0006¨\u0006H"}, d2 = {"Lcom/bytedance/android/shopping/api/image/d;", "", "", "bucketName", "Ljava/lang/String;", "getBucketName", "()Ljava/lang/String;", "serviceId", "getServiceId", "originTmplName", "getOriginTmplName", "tmplName", "getTmplName", "tmplType", "getTmplType", "imgEncode", "getImgEncode", "bizTag", "getBizTag", "bizTagStartsWith", "getBizTagStartsWith", "bizTagContains", "getBizTagContains", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "bizTags", "Ljava/util/HashSet;", "getBizTags", "()Ljava/util/HashSet;", "sceneTag", "getSceneTag", "sceneTagStartsWith", "getSceneTagStartsWith", "sceneTagContains", "getSceneTagContains", "sceneTags", "getSceneTags", "imgEncodes", "getImgEncodes", "", "Lcom/bytedance/android/shopping/api/image/e;", "quality", "Ljava/util/List;", "getQuality", "()Ljava/util/List;", "resizeWidth", "getResizeWidth", "resizeHeight", "getResizeHeight", "pixelSize", "getPixelSize", "netLevel", "b", "Lcom/bytedance/android/shopping/api/image/c;", "deviceScore", "a", "viewType", "c", "Lcom/bytedance/android/shopping/api/image/f;", "hasQuery", "Lcom/bytedance/android/shopping/api/image/f;", "getHasQuery", "()Lcom/bytedance/android/shopping/api/image/f;", "", "isExclude", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "contains", "getContains", "getContains$annotations", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("biz_tag#contains")
    private final String bizTagContains;

    @SerializedName("biz_tag#starts_with")
    private final String bizTagStartsWith;

    @SerializedName("biz_tag#list")
    private final HashSet<String> bizTags;

    @SerializedName("bucket_name")
    private final String bucketName;

    @SerializedName("contains")
    private final String contains;

    @SerializedName("device_score")
    private final List<c> deviceScore;

    @SerializedName("has_query")
    private final f hasQuery;

    @SerializedName("img_encode")
    private final String imgEncode;

    @SerializedName("img_encode#list")
    private final HashSet<String> imgEncodes;

    @SerializedName("is_exclude")
    private final Boolean isExclude;

    @SerializedName("net_level")
    private final List<e> netLevel;

    @SerializedName("origin_tmpl_name")
    private final String originTmplName;

    @SerializedName("pixel_size")
    private final List<e> pixelSize;

    @SerializedName("quality")
    private final List<e> quality;

    @SerializedName("resize_height")
    private final List<e> resizeHeight;

    @SerializedName("resize_width")
    private final List<e> resizeWidth;

    @SerializedName("scene_tag")
    private final String sceneTag;

    @SerializedName("scene_tag#contains")
    private final String sceneTagContains;

    @SerializedName("scene_tag#starts_with")
    private final String sceneTagStartsWith;

    @SerializedName("scene_tag#list")
    private final HashSet<String> sceneTags;

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("tmpl_name")
    private final String tmplName;

    @SerializedName("tmpl_type")
    private final String tmplType;

    @SerializedName("view_type")
    private final String viewType;

    public static final class a {
    }

    public interface b {
        Boolean c();

        List<d> e();

        String g();
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L56;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.bucketName, r4.bucketName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.serviceId, r4.serviceId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originTmplName, r4.originTmplName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tmplName, r4.tmplName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tmplType, r4.tmplType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.imgEncode, r4.imgEncode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizTag, r4.bizTag) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizTagStartsWith, r4.bizTagStartsWith) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bizTagContains, r4.bizTagContains) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bizTags, r4.bizTags) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sceneTag, r4.sceneTag) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.sceneTagStartsWith, r4.sceneTagStartsWith) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sceneTagContains, r4.sceneTagContains) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.sceneTags, r4.sceneTags) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.imgEncodes, r4.imgEncodes) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.quality, r4.quality) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.resizeWidth, r4.resizeWidth) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.resizeHeight, r4.resizeHeight) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.pixelSize, r4.pixelSize) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.netLevel, r4.netLevel) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.deviceScore, r4.deviceScore) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.viewType, r4.viewType) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.hasQuery, r4.hasQuery) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.isExclude, r4.isExclude) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.contains, r4.contains) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    public final int hashCode() {
        String r0 = this.bucketName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.serviceId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.originTmplName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tmplName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.tmplType;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.imgEncode;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.bizTag;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.bizTagStartsWith;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.bizTagContains;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        HashSet<String> r28 = this.bizTags;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.sceneTag;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.sceneTagStartsWith;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.sceneTagContains;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        HashSet<String> r40 = this.sceneTags;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        HashSet<String> r43 = this.imgEncodes;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        List<e> r46 = this.quality;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        List<e> r49 = this.resizeWidth;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        List<e> r52 = this.resizeHeight;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        List<e> r55 = this.pixelSize;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        List<e> r58 = this.netLevel;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        List<c> r61 = this.deviceScore;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.viewType;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        f r67 = this.hasQuery;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        Boolean r70 = this.isExclude;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        String r73 = this.contains;
        if (r73 == null) goto L102;
        r1 = r73.hashCode();
    L102:
        return r72 + r1;
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
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
        return "ECImageUrlMatcher(bucketName=" + this.bucketName + ", serviceId=" + this.serviceId + ", originTmplName=" + this.originTmplName + ", tmplName=" + this.tmplName + ", tmplType=" + this.tmplType + ", imgEncode=" + this.imgEncode + ", bizTag=" + this.bizTag + ", bizTagStartsWith=" + this.bizTagStartsWith + ", bizTagContains=" + this.bizTagContains + ", bizTags=" + this.bizTags + ", sceneTag=" + this.sceneTag + ", sceneTagStartsWith=" + this.sceneTagStartsWith + ", sceneTagContains=" + this.sceneTagContains + ", sceneTags=" + this.sceneTags + ", imgEncodes=" + this.imgEncodes + ", quality=" + this.quality + ", resizeWidth=" + this.resizeWidth + ", resizeHeight=" + this.resizeHeight + ", pixelSize=" + this.pixelSize + ", netLevel=" + this.netLevel + ", deviceScore=" + this.deviceScore + ", viewType=" + this.viewType + ", hasQuery=" + this.hasQuery + ", isExclude=" + this.isExclude + ", contains=" + this.contains + ")";
    }

    public d() {
        Boolean r0 = Boolean.FALSE;
        this.bucketName = null;
        this.serviceId = null;
        this.originTmplName = null;
        this.tmplName = null;
        this.tmplType = null;
        this.imgEncode = null;
        this.bizTag = null;
        this.bizTagStartsWith = null;
        this.bizTagContains = null;
        this.bizTags = null;
        this.sceneTag = null;
        this.sceneTagStartsWith = null;
        this.sceneTagContains = null;
        this.sceneTags = null;
        this.imgEncodes = null;
        this.quality = null;
        this.resizeWidth = null;
        this.resizeHeight = null;
        this.pixelSize = null;
        this.netLevel = null;
        this.deviceScore = null;
        this.viewType = null;
        this.hasQuery = null;
        this.isExclude = r0;
        this.contains = null;
    }

    public final List<c> a() {
        return this.deviceScore;
    }

    public final List<e> b() {
        return this.netLevel;
    }

    public final String c() {
        return this.viewType;
    }

    public final Boolean d() {
        return this.isExclude;
    }

    public final boolean e(l r7, q r8) {
        Intrinsics.checkNotNullParameter(r7, "callerContext");
        String r0 = this.bizTag;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L13:
        String r2 = this.bizTagStartsWith;
        if (r2 != null) goto L16;
    L19:
        boolean r3 = true;
    L20:
        String r4 = null;
        if (r3 == false) goto L23;
    L25:
        String r5 = this.bizTagContains;
        if (r5 != null) goto L28;
    L31:
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
    L36:
        HashSet<String> r9 = this.bizTags;
        if (r9 != null) goto L39;
    L42:
        boolean r10 = true;
    L43:
        if (r10 == false) goto L45;
    L52:
        String r11 = this.sceneTag;
        if (r11 != null) goto L55;
    L58:
        boolean r12 = true;
    L59:
        if (r12 == false) goto L61;
    L63:
        String r13 = this.sceneTagStartsWith;
        if (r13 != null) goto L66;
    L69:
        boolean r14 = true;
    L70:
        if (r14 == false) goto L72;
    L74:
        String r15 = this.sceneTagContains;
        if (r15 != null) goto L77;
    L80:
        boolean r16 = true;
    L81:
        if (r16 == false) goto L83;
    L85:
        HashSet<String> r17 = this.sceneTags;
        if (r17 != null) goto L88;
    L91:
        boolean r18 = true;
    L92:
        if (r18 == false) goto L94;
    L101:
        String r19 = this.contains;
        if (r19 == null) goto L104;
    L129:
        boolean r20 = true;
    L130:
        if (r20 == false) goto L245;
        if (r8 != null) goto L133;
    L244:
        return false;
    L133:
        if (r8.f(this.bucketName, r19) == true) goto L135;
        return false;
    L135:
        String r21 = this.serviceId;
        if (r21 != null) goto L138;
    L141:
        boolean r22 = true;
    L142:
        if (r22 == false) goto L144;
    L146:
        String r23 = this.tmplName;
        if (r23 != null) goto L149;
    L152:
        boolean r24 = true;
    L153:
        if (r24 == false) goto L155;
    L157:
        String r25 = this.tmplType;
        if (r25 != null) goto L160;
    L163:
        boolean r26 = true;
    L164:
        if (r26 == false) goto L166;
    L168:
        String r27 = this.originTmplName;
        if (r27 != null) goto L171;
    L174:
        boolean r28 = true;
    L175:
        if (r28 == true) goto L183;
        String r29 = this.originTmplName;
        t r30 = r8.n();
        if (r30 == null) goto L179;
        String r31 = r30.l();
    L181:
        if ((!Intrinsics.areEqual(r29, r31)) == false) goto L183;
        return false;
    L179:
        r31 = null;
    L183:
        String r32 = this.imgEncode;
        if (r32 != null) goto L186;
    L189:
        boolean r33 = true;
    L190:
        if (r33 == false) goto L192;
    L194:
        List<e> r34 = this.quality;
        if (r34 != null) goto L197;
    L199:
        List<e> r35 = this.resizeWidth;
        if (r35 != null) goto L202;
    L204:
        List<e> r36 = this.resizeHeight;
        if (r36 != null) goto L207;
    L209:
        List<e> r37 = this.pixelSize;
        if (r37 != null) goto L212;
    L214:
        HashSet<String> r38 = this.imgEncodes;
        if (r38 != null) goto L217;
    L220:
        boolean r39 = true;
    L221:
        if (r39 == true) goto L233;
        String r40 = r8.getFormat();
        if (r40 != null) goto L225;
    L228:
        boolean r41 = true;
    L229:
        if (r41 == true) goto L233;
        if (CollectionsKt.contains(this.imgEncodes, r8.getFormat()) == true) goto L233;
        return false;
    L225:
        if (r40.length() == 0) goto L228;
        r41 = false;
    L233:
        f r42 = this.hasQuery;
        if (r42 == null) goto L236;
        r4 = r42.a();
    L236:
        if (r4 == null) goto L245;
        if (this.hasQuery.b() == null) goto L243;
        if ((!Intrinsics.areEqual(this.hasQuery.b(), r8.getQuery().b(this.hasQuery.a()))) == false) goto L245;
        return false;
    L243:
        if (r8.getQuery().a(this.hasQuery.a()) == true) goto L245;
    L217:
        if (r38.isEmpty() == true) goto L220;
        r39 = false;
        goto L221
    L212:
        if (y.a(r37, r8.k()) == true) goto L214;
        return false;
    L207:
        if (y.a(r36, r8.b().getValue()) == true) goto L209;
        return false;
    L202:
        if (y.a(r35, r8.d().getValue()) == true) goto L204;
        return false;
    L197:
        if (y.a(r34, r8.getQuality().getValue()) == true) goto L199;
        return false;
    L192:
        if ((!Intrinsics.areEqual(this.imgEncode, r8.getFormat())) == false) goto L194;
        return false;
    L186:
        if (r32.length() == 0) goto L189;
        r33 = false;
        goto L190
    L171:
        if (r27.length() == 0) goto L174;
        r28 = false;
        goto L175
    L166:
        if ((!Intrinsics.areEqual(this.tmplType, r8.i())) == false) goto L168;
        return false;
    L160:
        if (r25.length() == 0) goto L163;
        r26 = false;
        goto L164
    L155:
        if ((!Intrinsics.areEqual(this.tmplName, r8.l())) == false) goto L157;
        return false;
    L149:
        if (r23.length() == 0) goto L152;
        r24 = false;
        goto L153
    L144:
        if ((!Intrinsics.areEqual(this.serviceId, r8.getServiceId())) == false) goto L146;
        return false;
    L138:
        if (r21.length() == 0) goto L141;
        r22 = false;
    L245:
        return true;
    L104:
        if (this.bucketName != null) goto L129;
        if (this.serviceId != null) goto L129;
        if (this.tmplName != null) goto L129;
        if (this.tmplType != null) goto L129;
        if (this.originTmplName != null) goto L129;
        if (this.imgEncode != null) goto L129;
        if (this.imgEncodes != null) goto L129;
        if (this.quality != null) goto L129;
        if (this.resizeWidth != null) goto L129;
        if (this.resizeHeight != null) goto L129;
        if (this.pixelSize != null) goto L129;
        if (this.hasQuery != null) goto L129;
        r20 = false;
        goto L130
    L94:
        if (r7.a().length() <= 0) goto L96;
        boolean r43 = true;
    L97:
        if (r43 == false) goto L101;
        if (this.sceneTags.contains(r7.a()) == true) goto L101;
        return false;
    L96:
        r43 = false;
        goto L97
    L88:
        if (r17.isEmpty() == true) goto L91;
        r18 = false;
        goto L92
    L83:
        if (StringsKt.contains$default(r7.a(), this.sceneTagContains, false, 2, null) == true) goto L85;
        return false;
    L77:
        if (r15.length() == 0) goto L80;
        r16 = false;
        goto L81
    L72:
        if (StringsKt.startsWith$default(r7.a(), this.sceneTagStartsWith, false, 2, null) == true) goto L74;
        return false;
    L66:
        if (r13.length() == 0) goto L69;
        r14 = false;
        goto L70
    L61:
        if ((!Intrinsics.areEqual(this.sceneTag, r7.a())) == false) goto L63;
        return false;
    L55:
        if (r11.length() == 0) goto L58;
        r12 = false;
        goto L59
    L45:
        if (r7.getBizTag().length() <= 0) goto L47;
        boolean r44 = true;
    L48:
        if (r44 == false) goto L52;
        if (this.bizTags.contains(r7.getBizTag()) == true) goto L52;
        return false;
    L47:
        r44 = false;
        goto L48
    L39:
        if (r9.isEmpty() == true) goto L42;
        r10 = false;
        goto L43
    L34:
        if (StringsKt.contains$default(r7.getBizTag(), this.bizTagContains, false, 2, null) == true) goto L36;
        return false;
    L28:
        if (r5.length() == 0) goto L31;
        r6 = false;
        goto L32
    L23:
        if (StringsKt.startsWith$default(r7.getBizTag(), this.bizTagStartsWith, false, 2, null) == true) goto L25;
        return false;
    L16:
        if (r2.length() == 0) goto L19;
        r3 = false;
        goto L20
    L11:
        if ((!Intrinsics.areEqual(this.bizTag, r7.getBizTag())) == false) goto L13;
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
