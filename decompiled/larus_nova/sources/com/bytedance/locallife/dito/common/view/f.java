package com.bytedance.locallife.dito.common.view;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/dito/common/view/f;", "", "", "height", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "offsetType", "e", "", "eventTrans", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "nodeTag", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "hasSeparator", "b", "separatorColor", "f", "", "separatorHeight", "Ljava/lang/Float;", ce.f26391f, "()Ljava/lang/Float;", "separatorMarginLeft", "h", "separatorMarginRight", RXScreenCaptureService.KEY_INDEX, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("event_trans")
    private final Boolean eventTrans;

    @SerializedName("has_separator")
    private final Boolean hasSeparator;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("node_tag")
    private final String nodeTag;

    @SerializedName("offset_type")
    private final Integer offsetType;

    @SerializedName("separator_color")
    private final String separatorColor;

    @SerializedName("separator_height")
    private final Float separatorHeight;

    @SerializedName("separator_margin_left")
    private final Integer separatorMarginLeft;

    @SerializedName("separator_margin_right")
    private final Integer separatorMarginRight;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offsetType, r101.offsetType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventTrans, r101.eventTrans) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasSeparator, r101.hasSeparator) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.separatorColor, r101.separatorColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.separatorHeight, r101.separatorHeight) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.separatorMarginLeft, r101.separatorMarginLeft) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.separatorMarginRight, r101.separatorMarginRight) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.height;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.offsetType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.eventTrans;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.nodeTag;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasSeparator;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.separatorColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.separatorHeight;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.separatorMarginLeft;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.separatorMarginRight;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GeneralPlaceholderData(height=" + this.height + ", offsetType=" + this.offsetType + ", eventTrans=" + this.eventTrans + ", nodeTag=" + this.nodeTag + ", hasSeparator=" + this.hasSeparator + ", separatorColor=" + this.separatorColor + ", separatorHeight=" + this.separatorHeight + ", separatorMarginLeft=" + this.separatorMarginLeft + ", separatorMarginRight=" + this.separatorMarginRight + ')';
    }

    public f() {
        Boolean r100 = Boolean.FALSE;
        this.height = null;
        this.offsetType = null;
        this.eventTrans = r100;
        this.nodeTag = null;
        this.hasSeparator = r100;
        this.separatorColor = "";
        this.separatorHeight = null;
        this.separatorMarginLeft = null;
        this.separatorMarginRight = null;
    }

    public final Boolean a() {
        return this.eventTrans;
    }

    public final Boolean b() {
        return this.hasSeparator;
    }

    public final Integer c() {
        return this.height;
    }

    public final String d() {
        return this.nodeTag;
    }

    public final Integer e() {
        return this.offsetType;
    }

    public final String f() {
        return this.separatorColor;
    }

    public final Float g() {
        return this.separatorHeight;
    }

    public final Integer h() {
        return this.separatorMarginLeft;
    }

    public final Integer i() {
        return this.separatorMarginRight;
    }
}
