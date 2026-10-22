package e92;

import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f471481a = null;

    static {
        f471481a = new o();
    }

    public o() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        SeiRegion r102 = (SeiRegion) r100;
        SeiRegion r103 = (SeiRegion) r101;
        Intrinsics.checkNotNullParameter(r102, "regionL");
        Intrinsics.checkNotNullParameter(r103, "regionR");
        if (r102.getY() == r103.getY()) goto L8;
        if (r102.getY() >= r103.getY()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r102.getX() != r103.getX()) goto L10;
        return 0;
    L10:
        if (r102.getX() < r103.getX()) goto L6;
        return 1;
    }
}
