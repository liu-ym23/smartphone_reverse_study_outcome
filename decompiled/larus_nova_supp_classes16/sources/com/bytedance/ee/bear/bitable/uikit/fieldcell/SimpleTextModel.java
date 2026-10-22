package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/SimpleTextModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", "textColor", "leftIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "rightIcon", "backgroundColor", "textUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/panel/Icon;Lcom/bytedance/ee/bear/bitable/panel/Icon;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTextColor", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getRightIcon", "getBackgroundColor", "setBackgroundColor", "(Ljava/lang/String;)V", "getTextUrl", "setTextUrl", "isEmptyValue", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleTextModel implements h0, NonProguard {
    private String backgroundColor;
    private final Icon leftIcon;
    private final Icon rightIcon;
    private final String text;
    private final String textColor;
    private String textUrl;

    public static /* synthetic */ SimpleTextModel copy$default(SimpleTextModel r4, String r5, String r6, Icon r7, Icon r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.text;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.textColor;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.leftIcon;
    L11:
        Icon r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.rightIcon;
    L14:
        Icon r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.backgroundColor;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.textUrl;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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

    public final SimpleTextModel copy(String r9, String r10, Icon r11, Icon r12, String r13, String r14) {
        return new SimpleTextModel(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SimpleTextModel) == true) goto L8;
        return false;
    L8:
        SimpleTextModel r6 = (SimpleTextModel) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftIcon, r6.leftIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightIcon, r6.rightIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textUrl, r6.textUrl) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.textColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Icon r7 = this.leftIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Icon r10 = this.rightIcon;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.backgroundColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        String r17 = this.textUrl;
        if (r17 == null) goto L27;
        r1 = r17.hashCode();
    L27:
        return r16 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setTextUrl(String r1) {
        this.textUrl = r1;
    }

    public SimpleTextModel(String r1, String r2, Icon r3, Icon r4, String r5, String r6) {
        this.text = r1;
        this.textColor = r2;
        this.leftIcon = r3;
        this.rightIcon = r4;
        this.backgroundColor = r5;
        this.textUrl = r6;
    }
}
