package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Float> f491056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Float> f491057b = null;

    static {
        Float r100 = Float.valueOf(0.0f);
        f491056a = CollectionsKt.listOf(new Float[]{r100, r100, r100});
        Float r101 = Float.valueOf(100.0f);
        f491057b = CollectionsKt.listOf(new Float[]{r101, r101, r101});
    }

    public static final f1.c c(f1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f1.c(f491056a, null, null);
    }

    public static final f1.c d(f1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f1.c(f491056a, null, null);
    }

    public static final f1.c e(f1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f1.c(f491057b, null, null);
    }

    public static final void f(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getClass();
    }

    public static final void g(f1 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getClass();
    }

    public static final float h(List<Float> r100) {
        return (float) Math.hypot(((Number) ListProtector.get(r100, 0)).floatValue(), ((Number) ListProtector.get(r100, 1)).floatValue());
    }

    public static final long a(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    public static final void b(Path r110, List r111, List r112, List r113, List r114) {
        r110.moveTo(((Number) ListProtector.get(r111, 0)).floatValue(), ((Number) ListProtector.get(r111, 1)).floatValue());
        if (h(r113) != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L14:
        r110.cubicTo(((Number) ListProtector.get(r111, 0)).floatValue() + ((Number) ListProtector.get(r113, 0)).floatValue(), ((Number) ListProtector.get(r111, 1)).floatValue() + ((Number) ListProtector.get(r113, 1)).floatValue(), ((Number) ListProtector.get(r112, 0)).floatValue() + ((Number) ListProtector.get(r114, 0)).floatValue(), ((Number) ListProtector.get(r112, 1)).floatValue() + ((Number) ListProtector.get(r114, 1)).floatValue(), ((Number) ListProtector.get(r112, 0)).floatValue(), ((Number) ListProtector.get(r112, 1)).floatValue());
        return;
    L8:
        if (h(r114) != 0.0f) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        r110.lineTo(((Number) ListProtector.get(r112, 0)).floatValue(), ((Number) ListProtector.get(r112, 1)).floatValue());
        return;
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }
}
