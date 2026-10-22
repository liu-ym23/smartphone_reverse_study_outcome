package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/ContentAlpha;", "", "<init>", "()V", "high", "", "getHigh", "(Landroidx/compose/runtime/Composer;I)F", "medium", "getMedium", "disabled", "getDisabled", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentAlpha {
    public static final int $stable = 0;
    public static final ContentAlpha INSTANCE = null;

    static {
        INSTANCE = new ContentAlpha();
    }

    private ContentAlpha() {
    }

    public final float getDisabled(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(621183615, r5, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:60)");
    L5:
        float r6 = contentAlpha(0.38f, 0.38f, r4, ((r5 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final float getHigh(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(629162431, r5, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:36)");
    L5:
        float r6 = contentAlpha(1.0f, 0.87f, r4, ((r5 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final float getMedium(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1999054879, r5, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:48)");
    L5:
        float r6 = contentAlpha(0.74f, 0.6f, r4, ((r5 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    private final float contentAlpha(float r5, float r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1528360391, r8, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:77)");
    L5:
        long r0 = ((Color) r7.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        if (MaterialTheme.INSTANCE.getColors(r7, 6).isLight() == false) goto L11;
        if (ColorKt.luminance-8_81llA(r0) > 0.5d) goto L15;
    L13:
        r5 = r6;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r5;
    L11:
        if (ColorKt.luminance-8_81llA(r0) >= 0.5d) goto L13;
        goto L13
    }
}
