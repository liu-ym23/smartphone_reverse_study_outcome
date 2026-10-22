package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.graphics.ColorKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClosedFloatingPointRange<Float> f490798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClosedFloatingPointRange<Float> f490799b = null;

    static {
        f490798a = RangesKt.rangeTo(0.0f, 1.0f);
        f490799b = RangesKt.rangeTo(0.0f, 255.0f);
    }

    public static final long a(List<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = b(((Number) ListProtector.get(r100, 0)).floatValue());
        float r102 = b(((Number) ListProtector.get(r100, 1)).floatValue());
        float r103 = b(((Number) ListProtector.get(r100, 2)).floatValue());
        Float r104 = (Float) CollectionsKt.getOrNull(r100, 3);
        if (r104 == null) goto L5;
        float r105 = b(r104.floatValue());
    L7:
        return ColorKt.Color$default(r101, r102, r103, r105, null, 16, null);
    L5:
        r105 = 1.0f;
        goto L7
    }

    public static final float b(float r100) {
        if (f490798a.contains(Float.valueOf(r100)) == false) goto L6;
        return r100;
    L6:
        if (f490799b.contains(Float.valueOf(r100)) == true) goto L8;
        return r100;
    L8:
        return r100 / 255.0f;
    }
}
