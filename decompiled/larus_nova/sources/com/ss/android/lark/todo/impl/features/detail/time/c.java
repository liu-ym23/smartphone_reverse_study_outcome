package com.ss.android.lark.todo.impl.features.detail.time;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskTimeContainer f443552a;

    public c(TaskTimeContainer r100) {
        this.f443552a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "event");
        if (r111.getAction() != 1) goto L37;
        float r100 = r111.getX();
        float r101 = r111.getY();
        TaskTimeContainer r102 = this.f443552a;
        float r103 = r102.f443517y;
        float r104 = (r103 / 2) / r102.f443512t;
        float r105 = r102.f443513u;
        if (r100 > r105) goto L7;
    L9:
        boolean r106 = false;
    L11:
        if ((r101 / (r100 - r105)) <= r104) goto L13;
        boolean r112 = true;
    L15:
        if (((((double) r101) - (((double) r103) / 2.0d)) / ((double) (r102.f443514v - r100))) >= r104) goto L17;
        boolean r107 = true;
    L19:
        if (r100 <= r105) goto L31;
        if (r106 == false) goto L25;
        if (r112 == true) goto L31;
        if (r107 == true) goto L31;
    L25:
        if (r102.f443508p == true) goto L36;
        TaskTimeContainer.a r108 = r102.f443518z;
        if (r108 == null) goto L29;
        r108.b();
    L29:
        TextView r109 = r102.getEndNoTimeTxtFromXml();
        com.ss.android.lark.todo.impl.utils.i r113 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r109.setTextColor(r113.a(R.color.static_white));
        r102.getEndNoTimeIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_add_middle_outlined, r113.a(R.color.static_white)));
        r102.getEndHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined, r113.a(R.color.static_white)));
        r102.getEndTimeDateTxtFromXml().setTextColor(r113.a(R.color.static_white));
        r102.getEndTimeSpecificTxtFromXml().setTextColor(r113.a(R.color.static_white));
        r102.getStartNoTimeTxtFromXml().setTextColor(r113.a(R.color.text_placeholder));
        r102.getStartNoTimeIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_add_middle_outlined, r113.a(R.color.icon_n3)));
        r102.getStartHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined, r113.a(R.color.icon_n3)));
        r102.getStartTimeDateTxtFromXml().setTextColor(r113.a(R.color.text_title));
        r102.getStartTimeSpecificTxtFromXml().setTextColor(r113.a(R.color.text_title));
        r102.f443507o = false;
        r102.f443508p = true;
    L36:
        this.f443552a.invalidate();
    L31:
        if (r102.f443507o == true) goto L36;
        TaskTimeContainer.a r114 = r102.f443518z;
        if (r114 == null) goto L35;
        r114.a();
    L35:
        TextView r115 = r102.getStartNoTimeTxtFromXml();
        com.ss.android.lark.todo.impl.utils.i r116 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r115.setTextColor(r116.a(R.color.static_white));
        r102.getStartNoTimeIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_add_middle_outlined, r116.a(R.color.static_white)));
        r102.getStartHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined, r116.a(R.color.static_white)));
        r102.getStartTimeDateTxtFromXml().setTextColor(r116.a(R.color.static_white));
        r102.getStartTimeSpecificTxtFromXml().setTextColor(r116.a(R.color.static_white));
        r102.getEndNoTimeTxtFromXml().setTextColor(r116.a(R.color.text_placeholder));
        r102.getEndNoTimeIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_add_middle_outlined, r116.a(R.color.icon_n3)));
        r102.getEndHaveTimeCloseIconFromXml().setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_close_outlined, r116.a(R.color.icon_n3)));
        r102.getEndTimeDateTxtFromXml().setTextColor(r116.a(R.color.text_title));
        r102.getEndTimeSpecificTxtFromXml().setTextColor(r116.a(R.color.text_title));
        r102.f443507o = true;
        r102.f443508p = false;
        goto L36
    L17:
        r107 = false;
        goto L19
    L13:
        r112 = false;
        goto L15
    L7:
        if (r100 >= r102.f443514v) goto L9;
        r106 = true;
    L37:
        return true;
    }
}
