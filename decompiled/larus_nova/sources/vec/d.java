package vec;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$DateState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$MonthState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$OptionalState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectState;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;

/* JADX INFO: loaded from: classes38.dex */
public abstract class d extends zec.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f554546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f554547d;

    public abstract void b(MonthViewAttr$MonthState r100, MonthViewAttr$SelectState r101, MonthViewAttr$DateState r102, MonthViewAttr$OptionalState r103);

    public abstract void c(MonthViewAttr$MonthState r100);

    @Override // zec.b
    public final void a() {
        if (getMDay() == null) goto L10;
        CalendarDate r100 = getMDay().f559452e;
        MonthViewAttr$SelectState r101 = getMDay().f559448a;
        MonthViewAttr$DateState r102 = getMDay().f559449b;
        MonthViewAttr$MonthState r103 = getMDay().f559450c;
        MonthViewAttr$OptionalState r104 = getMDay().f559451d;
        getMDay().getClass();
        this.f554546c.setText(String.valueOf(r100.getMonthDay()));
        b(r103, r101, r102, r104);
        if (CollectionUtils.isNotEmpty(null) == true) goto L7;
    L9:
        this.f554547d.setVisibility(4);
        goto L10
    L7:
        if (r101 != MonthViewAttr$SelectState.UN_SELECT) goto L9;
        this.f554547d.setVisibility(0);
        this.f554547d.removeAllViews();
        c(r103);
    L10:
        super.a();
    }

    @Override // zec.b, vec.a
    public int getCellViewHeight() {
        return UIUtils.dp2px(getContext(), 36.0f);
    }

    public d(Context r100) {
        super(r100);
        this.f554546c = (TextView) findViewById(R.id.date_day);
        this.f554547d = (LinearLayout) findViewById(R.id.dot_container);
    }

    @Override // zec.b, vec.a
    public void setTypeFace(Typeface r100) {
        this.f554546c.setTypeface(r100);
    }
}
