package oab;

import android.os.SystemClock;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class d extends IActionTitlebar$TextAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f522589a;

    public d(String r100) {
        super(r100, R.color.primary_fill_default);
        this.f522589a = 0;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f522589a) <= 1000) goto L27;
        com.ss.android.lark.custom.repeat.e r102 = (com.ss.android.lark.custom.repeat.e) this;
        Intrinsics.checkNotNullParameter(r100, "view");
        ChooseCustomRepeatFragment r103 = r102.f420298b;
        ChooseCustomRepeatFragment.b r104 = null;
        if (r103.T90().getVisibility() != 0) goto L21;
        View r105 = r103.f420253f;
        if (r105 != null) goto L13;
        View r106 = r103.getView();
        if (r106 == null) goto L11;
        r105 = r106.findViewById(R.id.wheel_repeat_week_no);
    L12:
        r103.f420253f = (WheelView) r105;
        goto L13
    L11:
        r105 = null;
    L13:
        WheelView r107 = (WheelView) r105;
        r107.f420362c.onItemSelected(r107.getCurrentItem());
        View r108 = r103.f420254g;
        if (r108 != null) goto L20;
        View r109 = r103.getView();
        if (r109 == null) goto L18;
        r108 = r109.findViewById(R.id.wheel_repeat_weeks);
    L19:
        r103.f420254g = (WheelView) r108;
        goto L20
    L18:
        r108 = null;
    L20:
        WheelView r110 = (WheelView) r108;
        r110.f420362c.onItemSelected(r110.getCurrentItem());
    L21:
        WheelView r111 = r103.W90();
        r111.f420362c.onItemSelected(r111.getCurrentItem());
        WheelView r112 = r103.V90();
        r112.f420362c.onItemSelected(r112.getCurrentItem());
        ChooseCustomRepeatFragment.b r113 = r102.f420298b.f420260m;
        if (r113 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("customRepeatAction");
    L25:
        r104.a(r102.f420298b.f420265r.toER());
        ChooseCustomRepeatFragment r114 = r102.f420298b;
        r114.f420265r.clearRule();
        r114.T90().c();
        this.f522589a = r101;
        return;
    L24:
        r104 = r113;
        goto L25
    }
}
