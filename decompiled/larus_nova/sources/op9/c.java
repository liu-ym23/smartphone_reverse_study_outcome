package op9;

import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f524787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mp9.b f524788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<MediaTab, List<d>> f524789c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f524787a == r101.f524787a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f524788b, r101.f524788b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f524789c, r101.f524789c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f524787a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f524788b.hashCode()) * 31) + this.f524789c.hashCode();
    }

    public final String toString() {
        return "UIMediaFolder(id=" + this.f524787a + ", mediaFolder=" + this.f524788b + ", uiMediaItemsMap=" + this.f524789c + ')';
    }

    public c(long r100, mp9.b r101, Map<MediaTab, List<d>> r102) {
        Intrinsics.checkNotNullParameter(r101, "mediaFolder");
        Intrinsics.checkNotNullParameter(r102, "uiMediaItemsMap");
        this.f524787a = r100;
        this.f524788b = r101;
        this.f524789c = r102;
    }
}
