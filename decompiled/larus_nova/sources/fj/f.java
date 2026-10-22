package fj;

import com.bytedance.android.ec.host.api.player.HeaderCtrLynxPendant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lfj/f;", "", "Lcom/bytedance/android/ec/host/api/player/HeaderCtrLynxPendant;", "headerVideoInteractor", "Lcom/bytedance/android/ec/host/api/player/HeaderCtrLynxPendant;", "b", "()Lcom/bytedance/android/ec/host/api/player/HeaderCtrLynxPendant;", "galleryVideoInteractor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("gallery")
    private final HeaderCtrLynxPendant galleryVideoInteractor;

    @SerializedName("header")
    private final HeaderCtrLynxPendant headerVideoInteractor;

    public f() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.headerVideoInteractor, r101.headerVideoInteractor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.galleryVideoInteractor, r101.galleryVideoInteractor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HeaderCtrLynxPendant r100 = this.headerVideoInteractor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HeaderCtrLynxPendant r104 = this.galleryVideoInteractor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoCtrLynxPendantModel(headerVideoInteractor=" + this.headerVideoInteractor + ", galleryVideoInteractor=" + this.galleryVideoInteractor + ")";
    }

    public final HeaderCtrLynxPendant a() {
        return this.galleryVideoInteractor;
    }

    public final HeaderCtrLynxPendant b() {
        return this.headerVideoInteractor;
    }

    public f(HeaderCtrLynxPendant r100, HeaderCtrLynxPendant r101) {
        this.headerVideoInteractor = r100;
        this.galleryVideoInteractor = r101;
    }
}
