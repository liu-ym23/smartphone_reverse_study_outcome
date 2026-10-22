package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J²\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\b\u0010B\u001a\u0004\u0018\u00010\bJ\t\u0010C\u001a\u00020\u0006HÖ\u0001J\t\u0010D\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b(\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018¨\u0006E"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "Ljava/io/Serializable;", "mainPicScale", "", "category", "", "", "mainPicUrl", "", "mainPic11Url", "mainPic34Url", "guidePic34Url", "mainPic34Count", "isAbMatch", "halPdpOptimizeStyle", "insertPicUrl", "insertPicScale", "insertPicUri", "halfPdpHeadScaleParam", "halPdpHeadSpace", "(Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Float;Ljava/lang/String;FI)V", "getCategory", "()Ljava/util/List;", "getGuidePic34Url", "()Ljava/lang/String;", "getHalPdpHeadSpace", "()I", "setHalPdpHeadSpace", "(I)V", "getHalPdpOptimizeStyle", "setHalPdpOptimizeStyle", "getHalfPdpHeadScaleParam", "()F", "setHalfPdpHeadScaleParam", "(F)V", "getInsertPicScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInsertPicUri", "getInsertPicUrl", "setAbMatch", "getMainPic11Url", "getMainPic34Count", "getMainPic34Url", "getMainPicScale", "getMainPicUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Float;Ljava/lang/String;FI)Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "equals", "", "other", "", "getPreferMainPicUrl", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class WireFrameSchemaInfo implements Serializable {

    @SerializedName("category")
    private final List<Integer> category;

    @SerializedName("guide_pic_34_url")
    private final String guidePic34Url;

    @SerializedName("half_head_space")
    private int halPdpHeadSpace;

    @SerializedName("half_pdp_optimize_style")
    private int halPdpOptimizeStyle;

    @SerializedName("half_head_scale")
    private float halfPdpHeadScaleParam;

    @SerializedName("insert_pic_scale")
    private final Float insertPicScale;

    @SerializedName("insert_pic_uri")
    private final String insertPicUri;

    @SerializedName("insert_pic_url")
    private final String insertPicUrl;

    @SerializedName("is_ab_match")
    private int isAbMatch;

    @SerializedName("main_pic_11_url")
    private final String mainPic11Url;

    @SerializedName("main_pic_34_count")
    private final int mainPic34Count;

    @SerializedName("main_pic_34_url")
    private final String mainPic34Url;

    @SerializedName("main_pic_scale")
    private final Float mainPicScale;

    @SerializedName("main_pic_url")
    private final String mainPicUrl;

    public WireFrameSchemaInfo() {
        this(null, null, null, null, null, null, 0, 0, 0, null, null, null, 0.0f, 0, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WireFrameSchemaInfo copy$default(WireFrameSchemaInfo r15, Float r16, List r17, String r18, String r19, String r20, String r21, int r22, int r23, int r24, String r25, Float r26, String r27, float r28, int r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        Float r2 = r15.mainPicScale;
    L7:
        if ((r30 & 2) == 0) goto L9;
        List r3 = r15.category;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.mainPicUrl;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r5 = r15.mainPic11Url;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.mainPic34Url;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = r15.guidePic34Url;
    L27:
        if ((r30 & 64) == 0) goto L29;
        int r8 = r15.mainPic34Count;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r9 = r15.isAbMatch;
    L35:
        if ((r30 & 256) == 0) goto L37;
        int r10 = r15.halPdpOptimizeStyle;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r11 = r15.insertPicUrl;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Float r12 = r15.insertPicScale;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = r15.insertPicUri;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        float r14 = r15.halfPdpHeadScaleParam;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        int r1 = r15.halPdpHeadSpace;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final Float component1() {
        return this.mainPicScale;
    }

    public final String component10() {
        return this.insertPicUrl;
    }

    public final Float component11() {
        return this.insertPicScale;
    }

    public final String component12() {
        return this.insertPicUri;
    }

    public final float component13() {
        return this.halfPdpHeadScaleParam;
    }

    public final int component14() {
        return this.halPdpHeadSpace;
    }

    public final List<Integer> component2() {
        return this.category;
    }

    public final String component3() {
        return this.mainPicUrl;
    }

    public final String component4() {
        return this.mainPic11Url;
    }

    public final String component5() {
        return this.mainPic34Url;
    }

    public final String component6() {
        return this.guidePic34Url;
    }

    public final int component7() {
        return this.mainPic34Count;
    }

    public final int component8() {
        return this.isAbMatch;
    }

    public final int component9() {
        return this.halPdpOptimizeStyle;
    }

    public final WireFrameSchemaInfo copy(Float r17, List<Integer> r18, String r19, String r20, String r21, String r22, int r23, int r24, int r25, String r26, Float r27, String r28, float r29, int r30) {
        return new WireFrameSchemaInfo(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WireFrameSchemaInfo) == false) goto L34;
        WireFrameSchemaInfo r4 = (WireFrameSchemaInfo) r3;
        if (Intrinsics.areEqual(this.mainPicScale, r4.mainPicScale) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.category, r4.category) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainPicUrl, r4.mainPicUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mainPic11Url, r4.mainPic11Url) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mainPic34Url, r4.mainPic34Url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.guidePic34Url, r4.guidePic34Url) == true) goto L18;
        return false;
    L18:
        if (this.mainPic34Count == r4.mainPic34Count) goto L20;
        return false;
    L20:
        if (this.isAbMatch == r4.isAbMatch) goto L22;
        return false;
    L22:
        if (this.halPdpOptimizeStyle == r4.halPdpOptimizeStyle) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.insertPicUrl, r4.insertPicUrl) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.insertPicScale, r4.insertPicScale) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.insertPicUri, r4.insertPicUri) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.halfPdpHeadScaleParam, r4.halfPdpHeadScaleParam) == 0) goto L32;
        return false;
    L32:
        if (this.halPdpHeadSpace == r4.halPdpHeadSpace) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        Float r0 = this.mainPicScale;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.category;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mainPicUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.mainPic11Url;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.mainPic34Url;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.guidePic34Url;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (((((((r15 + r17) * 31) + this.mainPic34Count) * 31) + this.isAbMatch) * 31) + this.halPdpOptimizeStyle) * 31;
        String r19 = this.insertPicUrl;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.insertPicScale;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.insertPicUri;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return ((((r24 + r1) * 31) + Float.floatToIntBits(this.halfPdpHeadScaleParam)) * 31) + this.halPdpHeadSpace;
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

    public String toString() {
        return "WireFrameSchemaInfo(mainPicScale=" + this.mainPicScale + ", category=" + this.category + ", mainPicUrl=" + this.mainPicUrl + ", mainPic11Url=" + this.mainPic11Url + ", mainPic34Url=" + this.mainPic34Url + ", guidePic34Url=" + this.guidePic34Url + ", mainPic34Count=" + this.mainPic34Count + ", isAbMatch=" + this.isAbMatch + ", halPdpOptimizeStyle=" + this.halPdpOptimizeStyle + ", insertPicUrl=" + this.insertPicUrl + ", insertPicScale=" + this.insertPicScale + ", insertPicUri=" + this.insertPicUri + ", halfPdpHeadScaleParam=" + this.halfPdpHeadScaleParam + ", halPdpHeadSpace=" + this.halPdpHeadSpace + ")";
    }

    public final String getPreferMainPicUrl() {
        String r0 = this.mainPic11Url;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.mainPicUrl;
    }

    public final List<Integer> getCategory() {
        return this.category;
    }

    public final String getGuidePic34Url() {
        return this.guidePic34Url;
    }

    public final int getHalPdpHeadSpace() {
        return this.halPdpHeadSpace;
    }

    public final int getHalPdpOptimizeStyle() {
        return this.halPdpOptimizeStyle;
    }

    public final float getHalfPdpHeadScaleParam() {
        return this.halfPdpHeadScaleParam;
    }

    public final Float getInsertPicScale() {
        return this.insertPicScale;
    }

    public final String getInsertPicUri() {
        return this.insertPicUri;
    }

    public final String getInsertPicUrl() {
        return this.insertPicUrl;
    }

    public final String getMainPic11Url() {
        return this.mainPic11Url;
    }

    public final int getMainPic34Count() {
        return this.mainPic34Count;
    }

    public final String getMainPic34Url() {
        return this.mainPic34Url;
    }

    public final Float getMainPicScale() {
        return this.mainPicScale;
    }

    public final String getMainPicUrl() {
        return this.mainPicUrl;
    }

    public final int isAbMatch() {
        return this.isAbMatch;
    }

    public final void setAbMatch(int r1) {
        this.isAbMatch = r1;
    }

    public final void setHalPdpHeadSpace(int r1) {
        this.halPdpHeadSpace = r1;
    }

    public final void setHalPdpOptimizeStyle(int r1) {
        this.halPdpOptimizeStyle = r1;
    }

    public final void setHalfPdpHeadScaleParam(float r1) {
        this.halfPdpHeadScaleParam = r1;
    }

    public WireFrameSchemaInfo(Float r1, List<Integer> r2, String r3, String r4, String r5, String r6, int r7, int r8, int r9, String r10, Float r11, String r12, float r13, int r14) {
        this.mainPicScale = r1;
        this.category = r2;
        this.mainPicUrl = r3;
        this.mainPic11Url = r4;
        this.mainPic34Url = r5;
        this.guidePic34Url = r6;
        this.mainPic34Count = r7;
        this.isAbMatch = r8;
        this.halPdpOptimizeStyle = r9;
        this.insertPicUrl = r10;
        this.insertPicScale = r11;
        this.insertPicUri = r12;
        this.halfPdpHeadScaleParam = r13;
        this.halPdpHeadSpace = r14;
    }

    public /* synthetic */ WireFrameSchemaInfo(Float r16, List r17, String r18, String r19, String r20, String r21, int r22, int r23, int r24, String r25, Float r26, String r27, float r28, int r29, int r30, DefaultConstructorMarker r31) {
        String r2 = null;
        if ((r30 & 1) == 0) goto L5;
        Float r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = null;
    L26:
        int r9 = 0;
        if ((r30 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r30 & 256) == 0) goto L37;
        int r11 = 0;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Float r13 = null;
    L47:
        if ((r30 & 2048) != 0) goto L51;
        r2 = r27;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        float r14 = 0.0f;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r9 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r2, r14, r9);
        return;
    L53:
        r14 = r28;
        goto L55
    L45:
        r13 = r26;
        goto L47
    L41:
        r12 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L26
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
