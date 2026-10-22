package jx6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljx6/c;", "", "", "buttonText", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "", "enable", "Z", "getEnable", "()Z", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("buttonText")
    private final String buttonText;

    @SerializedName("enable")
    private final boolean enable;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L12;
        return false;
    L12:
        if (this.enable == r101.enable) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.buttonText;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.enable == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ButtonInfo(buttonText=" + this.buttonText + ", enable=" + this.enable + ')';
    }

    public c() {
        this.buttonText = null;
        this.enable = false;
    }
}
