package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$FilePickerShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "maxSelectedCount", "", "title", "", "confirmText", "showSystemPicker", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getMaxSelectedCount", "()I", "getTitle", "()Ljava/lang/String;", "getConfirmText", "getShowSystemPicker", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$FilePickerShowOptions implements NonProguard {
    private final String confirmText;
    private final int maxSelectedCount;
    private final boolean showSystemPicker;
    private final String title;

    public static /* synthetic */ IWidget$FilePickerShowOptions copy$default(IWidget$FilePickerShowOptions r100, int r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.maxSelectedCount;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.confirmText;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showSystemPicker;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.maxSelectedCount;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.confirmText;
    }

    public final boolean component4() {
        return this.showSystemPicker;
    }

    public final IWidget$FilePickerShowOptions copy(int r100, String r101, String r102, boolean r103) {
        return new IWidget$FilePickerShowOptions(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$FilePickerShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$FilePickerShowOptions r101 = (IWidget$FilePickerShowOptions) r100;
        if (this.maxSelectedCount == r101.maxSelectedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.confirmText, r101.confirmText) == true) goto L18;
        return false;
    L18:
        if (this.showSystemPicker == r101.showSystemPicker) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.maxSelectedCount * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.confirmText;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.showSystemPicker == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "FilePickerShowOptions(maxSelectedCount=" + this.maxSelectedCount + ", title=" + this.title + ", confirmText=" + this.confirmText + ", showSystemPicker=" + this.showSystemPicker + ')';
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    public final int getMaxSelectedCount() {
        return this.maxSelectedCount;
    }

    public final boolean getShowSystemPicker() {
        return this.showSystemPicker;
    }

    public final String getTitle() {
        return this.title;
    }

    public IWidget$FilePickerShowOptions(int r100, String r101, String r102, boolean r103) {
        this.maxSelectedCount = r100;
        this.title = r101;
        this.confirmText = r102;
        this.showSystemPicker = r103;
    }

    public /* synthetic */ IWidget$FilePickerShowOptions(int r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = true;
    L8:
        this(r100, r101, r102, r103);
    }
}
