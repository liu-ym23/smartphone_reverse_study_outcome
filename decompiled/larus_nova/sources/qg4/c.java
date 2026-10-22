package qg4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.component.lyric_v2.painter.e;
import com.bytedance.component.lyric_v2.painter.g;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mg4.h;
import ng4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements b {
    public c() {
    }

    @Override // qg4.b
    public final void d(Canvas r100, com.bytedance.component.lyric_v2.painter.d r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "animationManager");
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke();
    }

    @Override // qg4.b
    public final void e(com.bytedance.component.lyric_v2.painter.d r100, float r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "animationManager");
        Intrinsics.checkNotNullParameter(r102, "onAnimationEnd");
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "onAnimationEnd");
        ValueAnimator r103 = r100.f203077b;
        if (r103 != null) goto L5;
    L9:
        r100.f203076a = true;
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{0, 255});
        r104.setDuration(300);
        r104.addUpdateListener(new com.bytedance.component.lyric_v2.painter.b(r100, r102));
        r104.addListener(new com.bytedance.component.lyric_v2.painter.a(r100, r102));
        Unit r105 = Unit.INSTANCE;
        r104.start();
        r100.f203077b = r104;
        return;
    L5:
        if (r103.isRunning() != true) goto L9;
        ValueAnimator r106 = r100.f203077b;
        if (r106 == null) goto L9;
        r106.cancel();
        goto L9
    }

    @Override // qg4.b
    public final void a(float r100, pg4.c r101, mg4.d r110, int r111, ng4.c r112, h r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r112, "node");
        Intrinsics.checkNotNullParameter(r113, "dynamicClipRect");
        if (r110 == null) goto L5;
        r110.f513730d = r111;
    L5:
        if (r110 == null) goto L8;
        r110.a(r100, r113, r115, r112.f519062a, r112.f519063b, false);
        return;
    }

    @Override // qg4.b
    public final void c(Canvas r100, float r101, float r102, pg4.c r103, l r104, int r105, g r106, e r107) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "request");
        Intrinsics.checkNotNullParameter(r106, "paintManager");
        Intrinsics.checkNotNullParameter(r107, "cacheManager");
        pg4.d r108 = (pg4.d) CollectionsKt.getOrNull(r104.f519071c, r105 + 1);
        if (r108 != null) goto L5;
        return;
    L5:
        String r109 = r108.f529201g;
        if (r109 != null) goto L8;
        return;
    L8:
        r100.drawText(r109, r101, r102, r106.f203089c);
    }

    @Override // qg4.b
    public final a b(int r100, pg4.c r101, Rect r102, Rect r103, Paint.FontMetrics r104, Paint.FontMetrics r105, int r106, int r107, mg4.d r108, float r110) {
        Intrinsics.checkNotNullParameter(r101, "displayConfig");
        Intrinsics.checkNotNullParameter(r102, "textBounds");
        Intrinsics.checkNotNullParameter(r103, "nextTextBounds");
        Intrinsics.checkNotNullParameter(r104, "currentFontMetrics");
        Intrinsics.checkNotNullParameter(r105, "nextFontMetrics");
        Intrinsics.checkNotNullParameter(r108, "alignController");
        if ((r100 % 2) != 0) goto L6;
        r102.width();
        float r109 = r108.b(r106) + r101.f529176h;
        h r111 = com.bytedance.component.lyric_v2.painter.h.a(r102);
        Intrinsics.checkNotNullParameter(r111, "lyricsRect");
        float r112 = ((-r111.f513734b) - r110) + r101.f529177i;
        return new a(r109, r112, r106 - r101.f529178j, (((r104.descent + r112) + r101.f529193y) - r105.ascent) - r101.f529179k);
    L6:
        float r113 = r103.width() + r101.f529176h;
        h r114 = com.bytedance.component.lyric_v2.painter.h.a(r103);
        Intrinsics.checkNotNullParameter(r114, "lyricsRect");
        float r115 = ((-r114.f513734b) - r110) + r101.f529177i;
        return new a((r106 - r102.width()) + r101.f529178j, (((r105.descent + r115) + r101.f529193y) - r105.ascent) - r101.f529179k, r113, r115);
    }
}
