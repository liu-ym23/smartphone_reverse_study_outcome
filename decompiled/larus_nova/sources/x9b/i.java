package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements LeadingMarginSpan, LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f563014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f563015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f563016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f563017d;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return 0;
    }

    public i(Context r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "theme");
        this.f563014a = r100;
        this.f563015b = r101;
        this.f563016c = com.ss.android.lark.coremd.utils.e.f419970a;
        this.f563017d = com.ss.android.lark.coremd.utils.e.f419972c;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "fm");
        r105.ascent = -10;
        r105.descent = 10;
        r105.top = 0;
        r105.bottom = 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r110, int r111, boolean r112, Layout r113) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r107, "text");
        Intrinsics.checkNotNullParameter(r113, "layout");
        ThematicBreakThemeData r108 = k.f419543b.i(this.f563015b);
        int r109 = r104 + ((r106 - r104) / 2);
        this.f563017d.set(r101);
        Paint r114 = this.f563017d;
        Context r115 = this.f563014a;
        com.ss.android.lark.coremd.ext.c r116 = r108.f419585e;
        KProperty<Object>[] r117 = ThematicBreakThemeData.f419583g;
        r114.setColor(UIUtils.getColor(r115, ((Number) r116.getValue(r108, r117[1])).intValue()));
        this.f563017d.setStyle(Paint.Style.FILL);
        this.f563017d.setStrokeWidth(UIUtils.dp2px(this.f563014a, ((Number) r108.f419586f.getValue(r108, r117[2])).intValue()));
        int r118 = MathKt.roundToInt(this.f563017d.getStrokeWidth()) / MathKt.roundToInt(2.0f);
        if (r103 <= 0) goto L5;
        int r119 = r100.getWidth();
    L6:
        this.f563016c.set(r102, r109 - r118, r119, r109 + r118);
        r100.drawRect(this.f563016c, this.f563017d);
        return;
    L5:
        r119 = r102;
        r102 = r102 - r100.getWidth();
        goto L6
    }
}
