package com.ss.android.lark.ug.dialog;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/ss/android/lark/ug/dialog/DialogData;", "", "title", "", "description", "image", "confirmLink", "confirmLinkType", "", "confirmText", "cancelText", "cancelLink", "cancelLinkType", "canClose", "", "dialogType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZI)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getImage", "getConfirmLink", "getConfirmLinkType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfirmText", "getCancelText", "getCancelLink", "getCancelLinkType", "getCanClose", "()Z", "getDialogType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZI)Lcom/ss/android/lark/ug/dialog/DialogData;", "equals", "other", "hashCode", "toString", "ug-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DialogData {

    @SerializedName("canClose")
    private final boolean canClose;

    @SerializedName("cancelLink")
    private final String cancelLink;

    @SerializedName("cancelLinkType")
    private final Integer cancelLinkType;

    @SerializedName("cancelText")
    private final String cancelText;

    @SerializedName("confirmLink")
    private final String confirmLink;

    @SerializedName("confirmLinkType")
    private final Integer confirmLinkType;

    @SerializedName("confirmText")
    private final String confirmText;

    @SerializedName("description")
    private final String description;

    @SerializedName("dialogType")
    private final int dialogType;

    @SerializedName("image")
    private final String image;

    @SerializedName("title")
    private final String title;

    public static /* synthetic */ DialogData copy$default(DialogData r110, String r111, String r112, String r113, String r114, Integer r115, String r116, String r117, String r210, Integer r211, boolean r212, int r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.description;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.image;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.confirmLink;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Integer r104 = r110.confirmLinkType;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.confirmText;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.cancelText;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.cancelLink;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Integer r118 = r110.cancelLinkType;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r119 = r110.canClose;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        int r108 = r110.dialogType;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.canClose;
    }

    public final int component11() {
        return this.dialogType;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.confirmLink;
    }

    public final Integer component5() {
        return this.confirmLinkType;
    }

    public final String component6() {
        return this.confirmText;
    }

    public final String component7() {
        return this.cancelText;
    }

    public final String component8() {
        return this.cancelLink;
    }

    public final Integer component9() {
        return this.cancelLinkType;
    }

    public final DialogData copy(String r110, String r111, String r112, String r113, Integer r114, String r115, String r210, String r211, Integer r212, boolean r213, int r214) {
        return new DialogData(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DialogData) == true) goto L8;
        return false;
    L8:
        DialogData r101 = (DialogData) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmLink, r101.confirmLink) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.confirmLinkType, r101.confirmLinkType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.confirmText, r101.confirmText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cancelText, r101.cancelText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cancelLink, r101.cancelLink) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cancelLinkType, r101.cancelLinkType) == true) goto L36;
        return false;
    L36:
        if (this.canClose == r101.canClose) goto L39;
        return false;
    L39:
        if (this.dialogType == r101.dialogType) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.image;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.confirmLink;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.confirmLinkType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.confirmText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.cancelText;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.cancelLink;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.cancelLinkType;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        if (this.canClose == false) goto L41;
        int r127 = 1231;
    L43:
        return ((r126 + r127) * 31) + this.dialogType;
    L41:
        r127 = 1237;
        goto L43
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

    public String toString() {
        return "DialogData(title=" + this.title + ", description=" + this.description + ", image=" + this.image + ", confirmLink=" + this.confirmLink + ", confirmLinkType=" + this.confirmLinkType + ", confirmText=" + this.confirmText + ", cancelText=" + this.cancelText + ", cancelLink=" + this.cancelLink + ", cancelLinkType=" + this.cancelLinkType + ", canClose=" + this.canClose + ", dialogType=" + this.dialogType + ')';
    }

    public final boolean getCanClose() {
        return this.canClose;
    }

    public final String getCancelLink() {
        return this.cancelLink;
    }

    public final Integer getCancelLinkType() {
        return this.cancelLinkType;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getConfirmLink() {
        return this.confirmLink;
    }

    public final Integer getConfirmLinkType() {
        return this.confirmLinkType;
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDialogType() {
        return this.dialogType;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public DialogData(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, String r107, Integer r108, boolean r110, int r111) {
        this.title = r100;
        this.description = r101;
        this.image = r102;
        this.confirmLink = r103;
        this.confirmLinkType = r104;
        this.confirmText = r105;
        this.cancelText = r106;
        this.cancelLink = r107;
        this.cancelLinkType = r108;
        this.canClose = r110;
        this.dialogType = r111;
    }

    public /* synthetic */ DialogData(String r110, String r111, String r112, String r113, Integer r210, String r211, String r212, String r213, Integer r214, boolean r215, int r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 512) == 0) goto L5;
        boolean r114 = true;
    L7:
        if ((r217 & 1024) == 0) goto L9;
        int r115 = 1;
    L10:
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r114, r115);
        return;
    L9:
        r115 = r216;
        goto L10
    L5:
        r114 = r215;
        goto L7
    }
}
