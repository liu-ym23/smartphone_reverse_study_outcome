package xsb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f565049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f565050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f565051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f565052f;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f565048b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f565047a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        RectF r101 = this.f565049c;
        if (r101 == null) goto L6;
        this.f565050d.setAntiAlias(true);
        this.f565050d.setStyle(Paint.Style.FILL);
        this.f565050d.setColor(this.f565052f);
        float r102 = r101.height() / 2.0f;
        this.f565051e.reset();
        this.f565051e.addRoundRect(r101, r102, r102, Path.Direction.CW);
        r100.drawPath(this.f565051e, this.f565050d);
        return;
    }

    public a(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f565047a = r101;
        this.f565048b = r102;
        this.f565050d = new Paint();
        this.f565051e = new Path();
        this.f565052f = UIUtils.getColor(r100, R.color.ud_N900_05);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        this.f565049c = new RectF(r100, r101, r102, r103);
    }
}
