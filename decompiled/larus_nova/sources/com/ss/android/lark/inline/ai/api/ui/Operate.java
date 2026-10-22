package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0005H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J=\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "Ljava/io/Serializable;", "type", "", "icon", "", "text", "btnType", "disabled", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getText", "setText", "getBtnType", "setBtnType", "getDisabled", "()Z", "setDisabled", "(Z)V", "toString", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "BtnType", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Operate implements Serializable {
    private String btnType;
    private boolean disabled;
    private int icon;
    private String text;
    private String type;

    public static /* synthetic */ Operate copy$default(Operate r100, String r101, int r102, String r103, String r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.btnType;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.disabled;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.btnType;
    }

    public final boolean component5() {
        return this.disabled;
    }

    public final Operate copy(String r100, int r101, String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "text");
        return new Operate(r100, r101, r110, r111, r112);
    }

    public int hashCode() {
        int r100 = ((((this.type.hashCode() * 31) + this.icon) * 31) + this.text.hashCode()) * 31;
        String r101 = this.btnType;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.disabled == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Operate(type='" + this.type + "', icon=" + this.icon + ", text='" + this.text + "', btnType=" + this.btnType + ", disabled=" + this.disabled + ')';
    }

    public final String getBtnType() {
        return this.btnType;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Operate) == false) goto L16;
        Operate r101 = (Operate) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L7;
        return false;
    L7:
        if (this.icon == r101.icon) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.btnType, r101.btnType) == true) goto L13;
        return false;
    L13:
        if (this.disabled != r101.disabled) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public final void setBtnType(String r100) {
        this.btnType = r100;
    }

    public final void setDisabled(boolean r100) {
        this.disabled = r100;
    }

    public final void setIcon(int r100) {
        this.icon = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public Operate(String r100, int r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "text");
        this.type = r100;
        this.icon = r101;
        this.text = r102;
        this.btnType = r103;
        this.disabled = r104;
    }

    public /* synthetic */ Operate(String r100, int r101, String r102, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        String r103 = r110;
        if ((r112 & 16) == 0) goto L8;
        boolean r104 = false;
    L9:
        this(r100, r101, r102, r103, r104);
        return;
    L8:
        r104 = r111;
        goto L9
    }
}
