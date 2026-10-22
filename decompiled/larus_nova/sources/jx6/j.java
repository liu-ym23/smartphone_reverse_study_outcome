package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ljx6/j;", "", "", "toastContent", "Ljava/lang/String;", "getToastContent", "()Ljava/lang/String;", "Ljx6/u;", "header", "Ljx6/u;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/u;", "", "Ljx6/v;", "items", "Ljava/util/List;", "b", "()Ljava/util/List;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("header")
    private final u header;

    @SerializedName("items")
    private final List<v> items;

    @SerializedName("toast_content")
    private final String toastContent;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.toastContent, r101.toastContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.toastContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        u r104 = this.header;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<v> r107 = this.items;
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

    public final String toString() {
        return "HeadImageRateData(toastContent=" + this.toastContent + ", header=" + this.header + ", items=" + this.items + ')';
    }

    public j() {
        this.toastContent = null;
        this.header = null;
        this.items = null;
    }

    public final u a() {
        return this.header;
    }

    public final List<v> b() {
        return this.items;
    }
}
