package com.ss.android.lark.widget.timepicker;

import android.widget.CompoundButton;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import java.util.Date;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeSelectFragment f448998a;

    public i(TimeSelectFragment r100) {
        this.f448998a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        TimeSelectFragment r102 = this.f448998a;
        boolean r103 = r102.f448959d;
        if (r103 == false) goto L10;
        if (r102.f448979x == null) goto L7;
    L12:
        Date r104 = null;
        boolean r105 = true;
        if (r101 == false) goto L20;
        if (r103 == true) goto L16;
        r102.Z90();
        r102.f448979x = null;
        return;
    L16:
        if (r102.f448981z != 1) goto L18;
        r102.Z90();
        r102.f448979x = null;
        return;
    L18:
        r102.X90();
        r102.f448980y = null;
        return;
    L20:
        if (r103 == true) goto L22;
        CalendarDate r106 = r102.f448978w;
        if (r106 != null) goto L31;
    L33:
        r105 = false;
    L34:
        if (r105 == false) goto L36;
        r102.Z90();
    L41:
        CalendarDate r107 = r102.f448978w;
        if (r107 == null) goto L44;
        r104 = r107.getDate();
    L44:
        r102.f448979x = r104;
        return;
    L36:
        CalendarDate r108 = r102.f448978w;
        if (r108 == null) goto L39;
        Date r109 = r108.getDate();
    L40:
        r102.fa0(r109);
        goto L41
    L39:
        r109 = null;
        goto L40
    L31:
        if (r106.sameDay(r102.f448977v) != true) goto L33;
    L22:
        if (r102.f448981z != 1) goto L24;
        r102.fa0(r102.f448979x);
        return;
    L24:
        Date r110 = r102.f448980y;
        if (TimeSelectFragment.W90(r110) == false) goto L27;
        r102.X90();
        return;
    L27:
        r102.Y90(r110, r102.f448979x, r110);
        return;
    L7:
        if (r102.f448980y != null) goto L12;
        return;
    L10:
        if (r102.f448979x != null) goto L12;
    }
}
