package com.bytedance.locallife.live.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/live/model/CouponPopWindow;", "Ljava/io/Serializable;", "text", "", "canUseDate", "clickButtonText", "bgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "getCanUseDate", "getClickButtonText", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CouponPopWindow implements Serializable {

    @SerializedName("background_url")
    private final String bgUrl;

    @SerializedName("can_use_date")
    private final String canUseDate;

    @SerializedName("click_btn_txt")
    private final String clickButtonText;

    @SerializedName("content")
    private final String text;

    public CouponPopWindow() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CouponPopWindow copy$default(CouponPopWindow r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.canUseDate;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.clickButtonText;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bgUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.canUseDate;
    }

    public final String component3() {
        return this.clickButtonText;
    }

    public final String component4() {
        return this.bgUrl;
    }

    public final CouponPopWindow copy(String r100, String r101, String r102, String r103) {
        return new CouponPopWindow(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CouponPopWindow) == true) goto L8;
        return false;
    L8:
        CouponPopWindow r101 = (CouponPopWindow) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canUseDate, r101.canUseDate) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clickButtonText, r101.clickButtonText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgUrl, r101.bgUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.canUseDate;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.clickButtonText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bgUrl;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "CouponPopWindow(text=" + this.text + ", canUseDate=" + this.canUseDate + ", clickButtonText=" + this.clickButtonText + ", bgUrl=" + this.bgUrl + ')';
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getCanUseDate() {
        return this.canUseDate;
    }

    public final String getClickButtonText() {
        return this.clickButtonText;
    }

    public final String getText() {
        return this.text;
    }

    public CouponPopWindow(String r100, String r101, String r102, String r103) {
        this.text = r100;
        this.canUseDate = r101;
        this.clickButtonText = r102;
        this.bgUrl = r103;
    }

    public /* synthetic */ CouponPopWindow(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
