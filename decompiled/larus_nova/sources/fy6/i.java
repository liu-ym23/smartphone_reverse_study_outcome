package fy6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfy6/i;", "", "Lfy6/a;", "addressIntro", "Lfy6/a;", "getAddressIntro", "()Lfy6/a;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("address_intro")
    private final a addressIntro;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.addressIntro, ((i) r100).addressIntro) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        a r100 = this.addressIntro;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "RichInfo(addressIntro=" + this.addressIntro + ')';
    }

    public i() {
        this.addressIntro = null;
    }
}
