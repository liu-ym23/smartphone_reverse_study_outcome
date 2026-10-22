package orc;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ScaleFactor;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f525004a = 0;

    static {
        ScaleFactor.m6346constructorimpl((Float.floatToRawIntBits(1.0f) << 32) | (Float.floatToRawIntBits(1.0f) & BodyPartID.bodyIdMax));
    }

    public static final long c(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        long r103 = Float.floatToRawIntBits(r101);
        return Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final <T> T a(o<T> r100, T r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        if (r100 != null) goto L6;
        return r101;
    L6:
        return (T) b(r100, r102, r101);
    }

    public static final <T> T b(o<T> r100, prc.f r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "state");
        return r100.a(r101, r102);
    }
}
