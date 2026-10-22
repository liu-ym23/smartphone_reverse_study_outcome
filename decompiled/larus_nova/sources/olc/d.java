package olc;

import android.graphics.Bitmap;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements Comparator<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f524201a = null;

    static {
        f524201a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Bitmap r100, Bitmap r101) {
        Bitmap r102 = r100;
        Bitmap r103 = r101;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
        return 0;
    L5:
        int r104 = r102.getByteCount() - r103.getByteCount();
        if (r104 != 0) goto L10;
        return -1;
    L10:
        return r104;
    }
}
