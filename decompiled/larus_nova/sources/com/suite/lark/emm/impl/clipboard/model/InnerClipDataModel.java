package com.suite.lark.emm.impl.clipboard.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/suite/lark/emm/impl/clipboard/model/InnerClipDataModel;", "Ljava/io/Serializable;", "pureText", "", "richTextType", "", "richText", "htmlText", "encryptId", "openAppModel", "Lcom/suite/lark/emm/impl/clipboard/model/OpenAppDataModel;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/suite/lark/emm/impl/clipboard/model/OpenAppDataModel;)V", "getPureText", "()Ljava/lang/String;", "getRichTextType", "()I", "getRichText", "getHtmlText", "getEncryptId", "getOpenAppModel", "()Lcom/suite/lark/emm/impl/clipboard/model/OpenAppDataModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "enterprise-mobility-management-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InnerClipDataModel implements Serializable {
    private final String encryptId;
    private final String htmlText;
    private final OpenAppDataModel openAppModel;
    private final String pureText;
    private final String richText;
    private final int richTextType;

    public static /* synthetic */ InnerClipDataModel copy$default(InnerClipDataModel r100, String r101, int r102, String r103, String r104, String r105, OpenAppDataModel r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.pureText;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.richTextType;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.richText;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.htmlText;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.encryptId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.openAppModel;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.pureText;
    }

    public final int component2() {
        return this.richTextType;
    }

    public final String component3() {
        return this.richText;
    }

    public final String component4() {
        return this.htmlText;
    }

    public final String component5() {
        return this.encryptId;
    }

    public final OpenAppDataModel component6() {
        return this.openAppModel;
    }

    public final InnerClipDataModel copy(String r100, int r110, String r111, String r112, String r113, OpenAppDataModel r114) {
        Intrinsics.checkNotNullParameter(r100, "pureText");
        Intrinsics.checkNotNullParameter(r113, "encryptId");
        return new InnerClipDataModel(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InnerClipDataModel) == true) goto L8;
        return false;
    L8:
        InnerClipDataModel r101 = (InnerClipDataModel) r100;
        if (Intrinsics.areEqual(this.pureText, r101.pureText) == true) goto L12;
        return false;
    L12:
        if (this.richTextType == r101.richTextType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.richText, r101.richText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.htmlText, r101.htmlText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.encryptId, r101.encryptId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.openAppModel, r101.openAppModel) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.pureText.hashCode() * 31) + this.richTextType) * 31;
        String r101 = this.richText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.htmlText;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.encryptId.hashCode()) * 31;
        OpenAppDataModel r108 = this.openAppModel;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "InnerClipDataModel(pureText=" + this.pureText + ", richTextType=" + this.richTextType + ", richText=" + this.richText + ", htmlText=" + this.htmlText + ", encryptId=" + this.encryptId + ", openAppModel=" + this.openAppModel + ')';
    }

    public final String getEncryptId() {
        return this.encryptId;
    }

    public final String getHtmlText() {
        return this.htmlText;
    }

    public final OpenAppDataModel getOpenAppModel() {
        return this.openAppModel;
    }

    public final String getPureText() {
        return this.pureText;
    }

    public final String getRichText() {
        return this.richText;
    }

    public final int getRichTextType() {
        return this.richTextType;
    }

    public InnerClipDataModel(String r100, int r101, String r102, String r103, String r104, OpenAppDataModel r105) {
        Intrinsics.checkNotNullParameter(r100, "pureText");
        Intrinsics.checkNotNullParameter(r104, "encryptId");
        this.pureText = r100;
        this.richTextType = r101;
        this.richText = r102;
        this.htmlText = r103;
        this.encryptId = r104;
        this.openAppModel = r105;
    }
}
