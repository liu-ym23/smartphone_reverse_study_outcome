package com.larus.ivykit.plugin;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/ivykit/plugin/TemplateInfo;", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "", "templateUrl", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "cardType", "mixtureCardId", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getTemplateId", "()Ljava/lang/String;", "getTemplateUrl", "getGravity", "()I", "getCardType", "getMixtureCardId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateInfo {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName(GXTemplateKey.GAIAX_LAYER_GRAVITY)
    private final int gravity;

    @SerializedName("mixture_card_id")
    private final String mixtureCardId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final String templateId;

    @SerializedName("template_url")
    private final String templateUrl;

    public TemplateInfo() {
        this(null, null, 0, 0, null, 31, null);
    }

    public static /* synthetic */ TemplateInfo copy$default(TemplateInfo r100, String r101, String r102, int r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.templateId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.templateUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.gravity;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.cardType;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.mixtureCardId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.templateId;
    }

    public final String component2() {
        return this.templateUrl;
    }

    public final int component3() {
        return this.gravity;
    }

    public final int component4() {
        return this.cardType;
    }

    public final String component5() {
        return this.mixtureCardId;
    }

    public final TemplateInfo copy(String r100, String r101, int r110, int r111, String r112) {
        return new TemplateInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateInfo) == true) goto L8;
        return false;
    L8:
        TemplateInfo r101 = (TemplateInfo) r100;
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L15;
        return false;
    L15:
        if (this.gravity == r101.gravity) goto L18;
        return false;
    L18:
        if (this.cardType == r101.cardType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mixtureCardId, r101.mixtureCardId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.templateId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templateUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.gravity) * 31) + this.cardType) * 31;
        String r107 = this.mixtureCardId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TemplateInfo(templateId=" + this.templateId + ", templateUrl=" + this.templateUrl + ", gravity=" + this.gravity + ", cardType=" + this.cardType + ", mixtureCardId=" + this.mixtureCardId + ')';
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final String getMixtureCardId() {
        return this.mixtureCardId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public TemplateInfo(String r100, String r101, int r102, int r103, String r104) {
        this.templateId = r100;
        this.templateUrl = r101;
        this.gravity = r102;
        this.cardType = r103;
        this.mixtureCardId = r104;
    }

    public /* synthetic */ TemplateInfo(String r100, String r101, int r102, int r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
