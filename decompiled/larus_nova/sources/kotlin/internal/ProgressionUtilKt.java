package kotlin.internal;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ProgressionUtilKt {
    private static final long mod(long r100, long r101) {
        long r102 = r100 % r101;
        if (r102 < 0) goto L6;
        return r102;
    L6:
        return r102 + r101;
    }

    private static final int mod(int r100, int r101) {
        int r102 = r100 % r101;
        if (r102 < 0) goto L6;
        return r102;
    L6:
        return r102 + r101;
    }

    private static final int differenceModulo(int r100, int r101, int r102) {
        return mod(mod(r100, r102) - mod(r101, r102), r102);
    }

    public static final long getProgressionLastElement(long r100, long r101, long r110) {
        if (r110 > 0) goto L5;
        if (r110 >= 0) goto L15;
        if (r100 > r101) goto L13;
        return r101;
    L13:
        return r101 + differenceModulo(r100, r101, -r110);
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (r100 < r101) goto L16;
        return r101;
    L16:
        return r101 - differenceModulo(r101, r100, r110);
    }

    private static final long differenceModulo(long r100, long r101, long r102) {
        return mod(mod(r100, r102) - mod(r101, r102), r102);
    }

    public static final int getProgressionLastElement(int r100, int r101, int r102) {
        if (r102 <= 0) goto L6;
        if (r100 < r101) goto L13;
        return r101;
    L13:
        return r101 - differenceModulo(r101, r100, r102);
    L6:
        if (r102 >= 0) goto L12;
        if (r100 > r101) goto L10;
        return r101;
    L10:
        return r101 + differenceModulo(r100, r101, -r102);
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }
}
