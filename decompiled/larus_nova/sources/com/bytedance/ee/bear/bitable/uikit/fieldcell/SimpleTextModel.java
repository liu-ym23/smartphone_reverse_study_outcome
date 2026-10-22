package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/SimpleTextModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", "textColor", "leftIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "rightIcon", "backgroundColor", "textUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/panel/Icon;Lcom/bytedance/ee/bear/bitable/panel/Icon;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTextColor", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getRightIcon", "getBackgroundColor", "setBackgroundColor", "(Ljava/lang/String;)V", "getTextUrl", "setTextUrl", "isEmptyValue", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleTextModel implements h0, NonProguard {
    private String backgroundColor;
    private final Icon leftIcon;
    private final Icon rightIcon;
    private final String text;
    private final String textColor;
    private String textUrl;

    public static /* synthetic */ SimpleTextModel copy$default(SimpleTextModel r100, String r101, String r102, Icon r103, Icon r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.leftIcon;
    L11:
        Icon r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.rightIcon;
    L14:
        Icon r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.backgroundColor;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.textUrl;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.textColor;
    }

    public final Icon component3() {
        return this.leftIcon;
    }

    public final Icon component4() {
        return this.rightIcon;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final String component6() {
        return this.textUrl;
    }

    public final SimpleTextModel copy(String r100, String r110, Icon r111, Icon r112, String r113, String r114) {
        return new SimpleTextModel(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SimpleTextModel) == true) goto L8;
        return false;
    L8:
        SimpleTextModel r101 = (SimpleTextModel) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightIcon, r101.rightIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textUrl, r101.textUrl) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Icon r107 = this.leftIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Icon r110 = this.rightIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.backgroundColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.textUrl;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "SimpleTextModel(text=" + this.text + ", textColor=" + this.textColor + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", backgroundColor=" + this.backgroundColor + ", textUrl=" + this.textUrl + ')';
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return TextUtils.isEmpty(this.text);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextUrl() {
        return this.textUrl;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setTextUrl(String r100) {
        this.textUrl = r100;
    }

    public SimpleTextModel(String r100, String r101, Icon r102, Icon r103, String r104, String r105) {
        this.text = r100;
        this.textColor = r101;
        this.leftIcon = r102;
        this.rightIcon = r103;
        this.backgroundColor = r104;
        this.textUrl = r105;
    }
}
