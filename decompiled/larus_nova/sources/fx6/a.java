package fx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jx6.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfx6/a;", "", "Ljx6/m;", "imageVO", "Ljx6/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/m;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("imageVO")
    private final m imageVO;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.imageVO, ((a) r100).imageVO) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.imageVO.hashCode();
    }

    public final String toString() {
        return "HeadImageDitoData(imageVO=" + this.imageVO + ')';
    }

    public final m a() {
        return this.imageVO;
    }
}
