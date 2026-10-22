package k14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f501374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f501375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f501376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f501377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f501378e;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f501378e = new Paint(1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Paint r101 = this.f501378e;
        Integer r102 = this.f501377d;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.setColor(r103);
        RectF r104 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r105 = this.f501376c;
        r100.drawRoundRect(r104, r105, r105, this.f501378e);
        return;
    L5:
        r103 = this.f501374a;
        goto L6
    }

    public final void setTrackState(boolean r100) {
        if (r100 == false) goto L4;
        this.f501377d = Integer.valueOf(this.f501374a);
        invalidate();
        return;
    L4:
        this.f501377d = Integer.valueOf(this.f501375b);
        invalidate();
    }
}
