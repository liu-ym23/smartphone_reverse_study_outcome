package com.bytedance.locallife.poi.newdetail.widget.contentplayer;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/i;", "", "", "tabText", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "tabId", "c", "", "tabType", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "tabNum", "I", "d", "()I", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/a;", "contentItem", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/a;", "b", "()Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/a;", "textGradient", ce.f26391f, "bgGradient", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f263426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f263427b;

    @SerializedName("bg_gradient")
    private final String bgGradient;

    @SerializedName("content_item")
    private final a contentItem;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NUM)
    private final int tabNum;

    @SerializedName("tab_text")
    private final String tabText;

    @SerializedName("tab_type")
    private final Integer tabType;

    @SerializedName("text_gradient")
    private final String textGradient;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.tabText, r101.tabText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L18;
        return false;
    L18:
        if (this.tabNum == r101.tabNum) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentItem, r101.contentItem) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textGradient, r101.textGradient) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bgGradient, r101.bgGradient) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f263426a, r101.f263426a) == true) goto L33;
        return false;
    L33:
        if (this.f263427b == r101.f263427b) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.tabText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.tabType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.tabNum) * 31;
        a r110 = this.contentItem;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.textGradient;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.bgGradient;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f263426a;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return ((r118 + r101) * 31) + this.f263427b;
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
        return "TagItem(tabText=" + this.tabText + ", tabId=" + this.tabId + ", tabType=" + this.tabType + ", tabNum=" + this.tabNum + ", contentItem=" + this.contentItem + ", textGradient=" + this.textGradient + ", bgGradient=" + this.bgGradient + ", renderText=" + this.f263426a + ", tabInnerIndex=" + this.f263427b + ')';
    }

    public final String a() {
        return this.bgGradient;
    }

    public final a b() {
        return this.contentItem;
    }

    public final String c() {
        return this.tabId;
    }

    public final int d() {
        return this.tabNum;
    }

    public final String e() {
        return this.tabText;
    }

    public final Integer f() {
        return this.tabType;
    }

    public final String g() {
        return this.textGradient;
    }

    public i(String r100) {
        this.tabText = r100;
        this.tabId = null;
        this.tabType = null;
        this.tabNum = 1;
        this.contentItem = null;
        this.textGradient = null;
        this.bgGradient = null;
        this.f263426a = null;
        this.f263427b = 1;
    }
}
