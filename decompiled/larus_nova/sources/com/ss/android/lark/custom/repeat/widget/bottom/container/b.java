package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.AdapterView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRepeatBottomContainer f420355a;

    public b(CustomRepeatBottomContainer r100) {
        this.f420355a = r100;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        CustomRepeatBottomContainer r104 = this.f420355a;
        nab.a r105 = r104.f420347p;
        if (r105.f518489e == false) goto L36;
        String r106 = "";
        if (r104.f420334c.f512738c != r102) goto L20;
        Integer r107 = r105.f518491g;
        if (r107 == null) goto L38;
        String[] r108 = r104.f420340i;
        if (r108 != null) goto L11;
    L17:
        LKUIToast.show(this.f420355a.getContext(), UIHelper.mustacheFormat(r107.intValue(), "Type", r106));
        return;
    L11:
        if (r108.length <= 0) goto L17;
        if (r102 >= r108.length) goto L17;
        if (r102 < 0) goto L17;
        r106 = r108[r102];
        goto L17
    L38:
        return;
    L20:
        if (r105.f518488d == false) goto L36;
        if (r104.f420346o == null) goto L39;
        Integer r109 = r105.f518492h;
        if (r109 == null) goto L40;
        int r110 = r109.intValue();
        CustomRepeatBottomContainer r111 = this.f420355a;
        int r112 = r111.f420347p.f518490f.getMonthDay() - 1;
        String[] r113 = r111.f420340i;
        if (r113 != null) goto L28;
    L34:
        LKUIToast.show(this.f420355a.getContext(), UIHelper.mustacheFormat(r110, "WeekType", r106));
        return;
    L28:
        if (r113.length <= 0) goto L34;
        if (r112 >= r113.length) goto L34;
        if (r112 < 0) goto L34;
        r106 = r113[r112];
        goto L34
    L40:
        return;
    L39:
        return;
    L36:
        r104.f420334c.c(r102);
        CustomRepeatBottomContainer r114 = this.f420355a;
        r114.a(r114.f420334c, r114.f420348q);
    }
}
