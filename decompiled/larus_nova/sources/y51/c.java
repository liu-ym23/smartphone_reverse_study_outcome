package y51;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.android.live.room.adapter.AudienceViewHolder;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Function3<TransparentCircleIconView, Canvas, Paint, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f566235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudienceViewHolder f566236b;

    public c(AudienceViewHolder r100, int r101) {
        this.f566236b = r100;
        this.f566235a = r101;
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
        if (this.f566235a < 1) goto L13;
        int r108 = this.f566236b.f98895i + r107;
        r104.drawCircle((-r108) + (r106 * 0.3846f), r107, r108, r105);
    L13:
        return Unit.INSTANCE;
    L8:
        r106 = this.f566236b.f98894h;
        goto L9
    }
}
