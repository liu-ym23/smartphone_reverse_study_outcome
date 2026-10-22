package io.noties.markwon.ext.onetex;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class i extends wsc.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f492441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f492443g;

    public static final class a {
    }

    static {
    }

    public i(msc.s r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "drawable");
        super(r100, r101);
        this.f492441e = r101;
        this.f492442f = 2;
        this.f492443g = new Rect();
    }

    @Override // wsc.f, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r110, Paint r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        int r107 = (int) r104;
        this.f492441e.getClass();
        super.draw(r100, r101, r102, r103, r104, r105, r106, r110, r111);
        Drawable r108 = this.f492441e.f561120e;
        if (r108 == null) goto L12;
        this.f492443g.set(r108.getBounds());
        Rect r109 = this.f492443g;
        int r112 = this.f492442f;
        Rect r113 = r108.getBounds();
        int r114 = r110 - r113.bottom;
        if (2 != r112) goto L8;
        float r115 = r114 - (((r110 - r105) - r113.height()) / 2.0f);
    L11:
        r109.offset(r107, (int) r115);
        Unit r116 = Unit.INSTANCE;
    L13:
        if (r116 != null) goto L16;
        this.f492443g.setEmpty();
        return;
    L16:
        return;
    L8:
        if (1 != r112) goto L10;
        r114 = r114 - r111.getFontMetricsInt().descent;
    L10:
        r115 = r114;
        goto L11
    L12:
        r116 = null;
        goto L13
    }
}
