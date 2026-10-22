package vec;

import android.content.Context;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$OptionalState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectTimeType;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m extends g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f554560t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f554561u;

    public m(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dayRender");
        super(r100, r101);
        this.f554560t = true;
        this.f554561u = true;
    }

    @Override // vec.g
    public final void e(wec.a r100, CalendarDate r101) {
        Intrinsics.checkNotNullParameter(r100, BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        Intrinsics.checkNotNullParameter(r101, "date");
        MonthViewAttr$SelectTimeType r102 = this.f554555r;
        if (r102 != MonthViewAttr$SelectTimeType.START_TIME) goto L13;
        if (this.f554561u == false) goto L9;
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
        return;
    L9:
        if (r101.getJulianDay() <= this.f554554q.getJulianDay()) goto L11;
        r100.f559451d = MonthViewAttr$OptionalState.NOT_OPTIONAL;
        return;
    L11:
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
        return;
    L13:
        if (r102 == MonthViewAttr$SelectTimeType.END_TIME) goto L15;
        return;
    L15:
        if (this.f554560t == false) goto L19;
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
        return;
    L19:
        if (r101.getJulianDay() >= this.f554553p.getJulianDay()) goto L21;
        r100.f559451d = MonthViewAttr$OptionalState.NOT_OPTIONAL;
        return;
    L21:
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
    }
}
