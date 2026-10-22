package y51;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.adapter.AudienceViewHolder;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Function3<TransparentCircleIconView, Canvas, Paint, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f566233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudienceViewHolder f566234b;

    public b(AudienceViewHolder r100, int r101) {
        this.f566234b = r100;
        this.f566233a = r101;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(TransparentCircleIconView r100, Canvas r101, Paint r102) {
        TransparentCircleIconView r103 = r100;
        Canvas r104 = r101;
        Paint r105 = r102;
        if (r103 != null) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r103.getWidth() <= 0) goto L8;
        int r106 = r103.getWidth();
    L9:
        int r107 = r106 / 2;
        AudienceViewHolder r108 = this.f566234b;
        if (r108.f98893g != null) goto L12;
        r108.f98893g = new Paint(1);
        this.f566234b.f98893g.setStyle(Paint.Style.STROKE);
        this.f566234b.f98893g.setStrokeWidth(s1.f(0.5f));
        this.f566234b.f98893g.setColor(504764451);
    L12:
        float r109 = r107;
        r104.drawCircle(r109, r109, r109, this.f566234b.f98893g);
        if (this.f566233a < 1) goto L16;
        int r110 = r107 + this.f566234b.f98895i;
        r104.drawCircle((-r110) + (r106 * 0.375f), r109, r110, r105);
    L16:
        return Unit.INSTANCE;
    L8:
        r106 = s1.f(24.0f);
        goto L9
    }
}
