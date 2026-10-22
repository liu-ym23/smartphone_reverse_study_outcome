package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends MetricAffectingSpan implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f563004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f563005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InlineCodeThemeData f563006c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter(r107, "text");
    }

    public final void a(TextPaint r100) {
        Context r101 = this.f563004a;
        InlineCodeThemeData r102 = this.f563006c;
        com.ss.android.lark.coremd.ext.c r103 = r102.f419572f;
        KProperty<Object>[] r104 = InlineCodeThemeData.f419569h;
        int r105 = UIUtils.getColor(r101, ((Number) r103.getValue(r102, r104[2])).intValue());
        if (r105 != 0) goto L5;
        r105 = ColorUtils.setAlphaComponent(r100.getColor(), 25);
    L5:
        r100.bgColor = r105;
        Context r106 = this.f563004a;
        InlineCodeThemeData r107 = this.f563006c;
        r100.setColor(UIUtils.getColor(r106, ((Number) r107.f419571e.getValue(r107, r104[1])).intValue()));
        Context r108 = this.f563004a;
        InlineCodeThemeData r109 = this.f563006c;
        int r110 = UIUtils.dp2px(r108, ((Number) r109.f419573g.getValue(r109, r104[3])).intValue());
        if (r110 <= 0) goto L9;
        r100.setTextSize(r110);
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        a(r100);
    }

    public c(Context r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "theme");
        this.f563004a = r100;
        this.f563005b = r101;
        this.f563006c = k.f419543b.f(r101);
    }
}
