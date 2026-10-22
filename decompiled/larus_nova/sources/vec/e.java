package vec;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$DateState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$MonthState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$OptionalState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectState;

/* JADX INFO: loaded from: classes38.dex */
public class e extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f554548e;

    public final void e() {
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.ud_N400));
        this.f554546c.setBackgroundResource(0);
    }

    public e(Context r100) {
        super(r100);
        this.f554548e = r100;
    }

    @Override // vec.d
    public final void c(MonthViewAttr$MonthState r100) {
        throw null;
    }

    public final void f(MonthViewAttr$DateState r100) {
        if (r100 != MonthViewAttr$DateState.CURRENT_DATE) goto L5;
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.colorful_blue));
    L6:
        this.f554546c.setBackgroundResource(0);
        return;
    L5:
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.ud_N400));
        goto L6
    }

    public final void d(MonthViewAttr$SelectState r100, MonthViewAttr$DateState r101) {
        if (r100 != MonthViewAttr$SelectState.SELECT) goto L9;
        if (r101 != MonthViewAttr$DateState.CURRENT_DATE) goto L7;
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.ud_N00));
        this.f554546c.setBackgroundResource(R.drawable.bg_blue_circle);
        return;
    L7:
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.ud_N900));
        this.f554546c.setBackgroundResource(R.drawable.bg_gray_circle);
        return;
    L9:
        if (r101 != MonthViewAttr$DateState.CURRENT_DATE) goto L11;
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.colorful_blue));
        this.f554546c.setBackgroundResource(0);
        return;
    L11:
        this.f554546c.setTextColor(UIUtils.getColor(this.f554548e, R.color.ud_N900));
        this.f554546c.setBackgroundResource(0);
    }

    @Override // vec.d
    public void b(MonthViewAttr$MonthState r100, MonthViewAttr$SelectState r101, MonthViewAttr$DateState r102, MonthViewAttr$OptionalState r103) {
        if (r103 != MonthViewAttr$OptionalState.NOT_OPTIONAL) goto L7;
        e();
        return;
    L7:
        if (r102 != MonthViewAttr$DateState.FUTURE_DATE) goto L11;
        e();
        return;
    L11:
        if (r100 != MonthViewAttr$MonthState.CURRENT_MONTH) goto L13;
        d(r101, r102);
        return;
    L13:
        f(r102);
    }
}
