package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lnv6/e0;", "", "Lnv6/d;", "background", "Lnv6/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/d;", "", "Lnv6/e;", "content", "Ljava/util/List;", "b", "()Ljava/util/List;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("background")
    private final d background;

    @SerializedName("content")
    private final List<e> content;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        d r100 = this.background;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.content;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NormalUiData(background=" + this.background + ", content=" + this.content + ')';
    }

    public e0() {
        List<e> r100 = CollectionsKt.emptyList();
        this.background = null;
        this.content = r100;
    }

    public final d a() {
        return this.background;
    }

    public final List<e> b() {
        return this.content;
    }
}
