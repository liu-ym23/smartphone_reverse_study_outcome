package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "Lcom/bytedance/ee/util/io/NonProguard;", "key", "", "disabled", "", "text", "typeX", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getText", "getTypeX", "type", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogActionType;", "getType", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogActionType;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ConfirmDialogAction implements NonProguard {
    private final Boolean disabled;
    private final String key;
    private final String text;
    private final String typeX;

    public static /* synthetic */ IWidget$Internal$ConfirmDialogAction copy$default(IWidget$Internal$ConfirmDialogAction r100, String r101, Boolean r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.disabled;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.text;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.typeX;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.key;
    }

    public final Boolean component2() {
        return this.disabled;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.typeX;
    }

    public final IWidget$Internal$ConfirmDialogAction copy(String r100, Boolean r101, String r102, @JSONField(name = "type") String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "typeX");
        return new IWidget$Internal$ConfirmDialogAction(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$Internal$ConfirmDialogAction) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ConfirmDialogAction r101 = (IWidget$Internal$ConfirmDialogAction) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disabled, r101.disabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.typeX, r101.typeX) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.key.hashCode() * 31;
        Boolean r101 = this.disabled;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.text.hashCode()) * 31) + this.typeX.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ConfirmDialogAction(key=" + this.key + ", disabled=" + this.disabled + ", text=" + this.text + ", typeX=" + this.typeX + ')';
    }

    public final IWidget$Internal$ConfirmDialogActionType getType() {
        IWidget$Internal$ConfirmDialogActionType.a r100 = IWidget$Internal$ConfirmDialogActionType.Companion;
        String r101 = this.typeX;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        IWidget$Internal$ConfirmDialogActionType[] r102 = IWidget$Internal$ConfirmDialogActionType.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        IWidget$Internal$ConfirmDialogActionType r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r101) == true) goto L9;
        r104 = r104 + 1;
    L9:
        if (r105 == null) goto L12;
        return r105;
    L12:
        return IWidget$Internal$ConfirmDialogActionType.Secondary;
    L8:
        r105 = null;
        goto L9
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTypeX() {
        return this.typeX;
    }

    public IWidget$Internal$ConfirmDialogAction(String r100, Boolean r101, String r102, @JSONField(name = "type") String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "typeX");
        this.key = r100;
        this.disabled = r101;
        this.text = r102;
        this.typeX = r103;
    }
}
