package pt8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f530661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f530662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f530663c;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f530663c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f530662b.reset();
        Path r101 = this.f530662b;
        RectF r102 = this.f530663c;
        float r103 = this.f530661a;
        r101.addRoundRect(r102, r103, r103, Path.Direction.CW);
        r100.save();
        r100.clipPath(this.f530662b);
        super.dispatchDraw(r100);
        r100.restore();
    }

    public a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f530661a = r101;
        this.f530662b = new Path();
        this.f530663c = new RectF();
    }
}
