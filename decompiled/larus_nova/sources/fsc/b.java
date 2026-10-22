package fsc;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PathEffect;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f478744a = 0.0f;

    static {
        f478744a = (float) 0.017453292519943295d;
    }

    public static final long d(List<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = ((Number) ListProtector.get(r100, 0)).floatValue();
        float r102 = ((Number) ListProtector.get(r100, 1)).floatValue();
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    public static final void a(Paint r100, PathEffect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "effect");
        if (r100.getPathEffect() != null) goto L5;
        r100.setPathEffect(r101);
        return;
    L5:
        PathEffect.Companion r102 = PathEffect.Companion;
        PathEffect r103 = r100.getPathEffect();
        Intrinsics.checkNotNull(r103);
        r100.setPathEffect(r102.chainPathEffect(r101, r103));
    }

    public static final int b(float r100, float r101) {
        int r102 = (int) r100;
        int r103 = (int) r101;
        int r104 = r102 / r103;
        if ((r102 ^ r103) < 0) goto L5;
        boolean r105 = true;
    L6:
        int r106 = r102 % r103;
        if (r105 == true) goto L11;
        if (r106 == 0) goto L11;
        r104 = r104 - 1;
    L11:
        return r102 - (r103 * r104);
    L5:
        r105 = false;
        goto L6
    }

    public static final float c(int r100, float r101, float r102, float r103) {
        float r104 = (r100 + (r101 / 30.0f)) % 12.0f;
        return r103 - ((r102 * Math.min(r103, 1.0f - r103)) * Math.max(-1.0f, Math.min(r104 - 3, Math.min(9 - r104, 1.0f))));
    }
}
