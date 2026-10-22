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
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f565055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f565056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f565057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f565058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f565059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f565060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f565061i;

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
        return this.f565054b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f565053a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        RectF r101 = this.f565057e;
        if (r101 == null) goto L5;
        this.f565058f.setAntiAlias(true);
        this.f565058f.setStyle(Paint.Style.FILL);
        this.f565058f.setColor(this.f565061i);
        float r102 = r101.height() / 2.0f;
        this.f565059g.reset();
        this.f565059g.addRoundRect(r101, r102, r102, Path.Direction.CW);
        r100.drawPath(this.f565059g, this.f565058f);
    L5:
        int r103 = r100.getSaveCount();
        r100.save();
        this.f565060h.draw(r100);
        r100.restoreToCount(r103);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        a r104 = this.f565060h;
        int r105 = r103 - r101;
        r104.setBounds(r100, r101, ((r104.f565047a * r105) / r104.f565048b) + r100, r105 + r101);
        super.setBounds(r100, r101, r102, r103);
        this.f565057e = new RectF(r100, r101, r102, r103);
    }

    public b(Context r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f565053a = r101;
        this.f565054b = r102;
        this.f565055c = r103;
        this.f565056d = r104;
        this.f565058f = new Paint();
        this.f565059g = new Path();
        this.f565061i = UIUtils.getColor(r100, R.color.transparent);
        if (r104 == 0) goto L5;
        this.f565055c = (r103 * r102) / r104;
        this.f565056d = r102;
    L5:
        this.f565060h = new a(r100, this.f565055c, this.f565056d);
    }
}
