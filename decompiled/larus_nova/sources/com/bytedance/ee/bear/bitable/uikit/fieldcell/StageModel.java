package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/StageModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", "textColor", "capsuleColor", "type", "borderColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTextColor", "getCapsuleColor", "getType", "getBorderColor", "isEmptyValue", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageModel implements h0, NonProguard {
    private final String borderColor;
    private final String capsuleColor;
    private final String text;
    private final String textColor;
    private final String type;

    public static /* synthetic */ StageModel copy$default(StageModel r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.capsuleColor;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.type;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.borderColor;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.textColor;
    }

    public final String component3() {
        return this.capsuleColor;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.borderColor;
    }

    public final StageModel copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "capsuleColor");
        Intrinsics.checkNotNullParameter(r111, "type");
        return new StageModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StageModel) == true) goto L8;
        return false;
    L8:
        StageModel r101 = (StageModel) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.capsuleColor, r101.capsuleColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L23;
        return false;
    L23:
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
        int r106 = (((((r103 + r105) * 31) + this.capsuleColor.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r107 = this.borderColor;
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
        return "StageModel(text=" + this.text + ", textColor=" + this.textColor + ", capsuleColor=" + this.capsuleColor + ", type=" + this.type + ", borderColor=" + this.borderColor + ')';
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return TextUtils.isEmpty(this.text);
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getCapsuleColor() {
        return this.capsuleColor;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getType() {
        return this.type;
    }

    public StageModel(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "capsuleColor");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.text = r100;
        this.textColor = r101;
        this.capsuleColor = r102;
        this.type = r103;
        this.borderColor = r104;
    }

    public /* synthetic */ StageModel(String r100, String r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
