package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes25.dex */
public final class ImageViewBitmapLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308513a = 0;

    public static final class a extends ImageView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f308514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super Bitmap, Unit> f308515b;

        @Override // android.widget.ImageView
        public final void setImageBitmap(Bitmap r100) {
            super.setImageBitmap(r100);
            if (r100 != null) goto L5;
            return;
        L5:
            Function1<? super Bitmap, Unit> r101 = this.f308515b;
            if (r101 != null) goto L8;
            return;
        L8:
            this.f308515b = null;
            r101.invoke(r100);
        }

        @Override // android.widget.ImageView
        public final void setImageDrawable(Drawable r110) {
            super.setImageDrawable(r110);
            if (this.f308514a == true) goto L5;
            return;
        L5:
            Function1<? super Bitmap, Unit> r100 = this.f308515b;
            if (r100 != null) goto L8;
            return;
        L8:
            if (r110 != null) goto L10;
            return;
        L10:
            Resources r101 = getResources();
            int r102 = RangesKt.coerceAtLeast((int) (24 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density), 1);
            Bitmap r111 = DrawableKt.toBitmap$default(r110, r102, r102, null, 4, null);
            this.f308515b = null;
            r100.invoke(r111);
        }

        public a(Context r100, boolean r101, ImageViewBitmapLoader$load$2.b r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f308514a = r101;
            this.f308515b = r102;
        }
    }

    static {
    }

    public static Object a(Context r100, boolean r101, Function1 r102, Continuation r103) {
        return TimeoutKt.c(10000, new ImageViewBitmapLoader$load$2(r100, r101, r102, null), r103);
    }
}
