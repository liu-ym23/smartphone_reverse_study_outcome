package com.bytedance.kmp.image.painter;

import android.graphics.drawable.Drawable;
import androidx.compose.ui.geometry.Size;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes19.dex */
public final class DrawablePainterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f252174a = null;

    static {
        f252174a = LazyKt.lazy(LazyThreadSafetyMode.NONE, DrawablePainterKt$MAIN_HANDLER$2.INSTANCE);
    }

    public static final long a(Drawable r100) {
        if (r100.getIntrinsicWidth() < 0) goto L8;
        if (r100.getIntrinsicHeight() < 0) goto L8;
        float r101 = r100.getIntrinsicWidth();
        float r102 = r100.getIntrinsicHeight();
        return Size.m4642constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    L8:
        return Size.Companion.m4659getUnspecifiedNHjbRc();
    }
}
