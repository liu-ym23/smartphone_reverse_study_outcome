package kfb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ss.android.lark.filedetail.impl.folder.manage.drawable.property.ExtraVideoProperty;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mfb.a f503289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BorderProperty f503290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExtraVideoProperty f503291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final lfb.b f503292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f503293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f503294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f503295n;

    @Override // kfb.a, android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.draw(r110);
        if (this.f503289h.f513682d == false) goto L6;
        this.f503292k.a(r110, this.f503282a, this.f503283b, this.f503290i, this.f503291j, this.f503293l, this.f503294m);
        this.f503292k.b(r110, this.f503282a, this.f503283b, this.f503291j, this.f503295n);
        return;
    }

    public b(mfb.a r100, BorderProperty r101, ExtraVideoProperty r102, lfb.a r103) {
        Intrinsics.checkNotNullParameter(r100, "drawableParams");
        Intrinsics.checkNotNullParameter(r101, "borderParams");
        Intrinsics.checkNotNullParameter(r102, "videoParams");
        Intrinsics.checkNotNullParameter(r103, "extraAction");
        super(r100, r101);
        this.f503289h = r100;
        this.f503290i = r101;
        this.f503291j = r102;
        this.f503292k = r103;
        this.f503293l = new RectF();
        this.f503294m = new Paint();
        this.f503295n = new Rect();
    }
}
