package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class ListCalendarWeekIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f449017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f449018b;

    public ListCalendarWeekIndicator(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449018b = r100;
        this.f449017a = UIUtils.getStringArray(r100, R.array.week_text);
        LayoutInflater.from(r100).inflate(R.layout.list_calendar_week_indicator, this);
    }

    public final void a(int r100, boolean r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= 7) goto L7;
        ((TextView) getChildAt(r103)).setText(this.f449017a[r103]);
        r103 = r103 + 1;
    L7:
        if (r102 >= getChildCount()) goto L13;
        if (r101 == false) goto L11;
        if (r102 != r100) goto L11;
        ((TextView) getChildAt(r102)).setTextColor(UIUtils.getColor(this.f449018b, R.color.colorful_blue));
    L12:
        r102 = r102 + 1;
    L11:
        ((TextView) getChildAt(r102)).setTextColor(UIUtils.getColor(this.f449018b, R.color.ud_N900));
        goto L12
    }
}
