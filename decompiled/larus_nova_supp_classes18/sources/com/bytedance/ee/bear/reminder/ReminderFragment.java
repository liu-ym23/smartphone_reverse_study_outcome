package com.bytedance.ee.bear.reminder;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.reminder.calendar.ReminderMonthView;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.bytedance.ee.bear.reminder.model.ReminderUserEntity;
import com.bytedance.ee.bear.reminder.person.ReminderPersonView;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.WeekViewPager;
import com.haibin.calendarview.YearViewPager;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ocb.a;
import ql5.e;
import ql5.f;
import ql5.f0;
import ql5.g;
import ql5.h;
import ql5.k;
import ql5.m;
import ql5.o;
import ql5.p;
import ql5.r;
import ql5.s;
import ql5.t;
import ql5.u;
import ql5.v;
import ql5.w;
import ql5.x;
import ql5.y;
import ql5.z;
import rcb.c;
import zo5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderFragment extends BaseDialogFragment implements View.OnClickListener, a {
    public static final /* synthetic */ int H0 = 0;
    public UDSwitch A;
    public UDSwitch B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public UDTimePicker G;
    public WheelView H;
    public ReminderPersonView I;
    public ImageView J;
    public ImageView K;
    public AtEditText L;
    public UDDialog M;
    public UDDialog N;
    public UDDialog O;
    public FrameLayout P;
    public sl5.a Q;
    public ReminderViewModel R;
    public com.bytedance.ee.bear.reminder.model.a S;
    public com.bytedance.ee.bear.reminder.model.a T;
    public int U;
    public int V;
    public int W;
    public BearUrl X;
    public String Y;
    public pcb.a Z;
    public boolean h;
    public NestedScrollView i;
    public View j;
    public View k;
    public boolean k0;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final AnimationSet p0;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public UDNotice x;
    public TextView y;
    public CalendarView z;

    public ReminderViewModel da0() {
        return (ReminderViewModel) q.a(this, ReminderViewModel.class);
    }

    public final boolean ia0() {
        if (this.L.getText() != null) goto L5;
        String r0 = "";
    L7:
        if (r0.length() <= this.U) goto L10;
        ba0(this.N);
        this.Y = r0;
        return false;
    L10:
        this.T.j = r0;
        this.L.setText(r0);
        return true;
    L5:
        r0 = this.L.getText().toString();
        goto L7
    }

    public final void qa0() {
        com.bytedance.ee.bear.reminder.model.a r0 = this.T;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        sl5.a r2 = this.Q;
        if (r1 == false) goto L14;
        List<EAlertTimeEvent> r3 = r0.a();
    L15:
        ((ArrayList) r2.a).clear();
        ((ArrayList) r2.a).addAll(r3);
        WheelView r4 = this.H;
        r4.e();
        r4.requestLayout();
        WheelView r5 = this.H;
        sl5.a r6 = this.Q;
        if (r1 == false) goto L18;
        EAlertTimeEvent r7 = this.T.h;
    L19:
        r5.setCurrentItem(((ArrayList) r6.a).indexOf(r7));
        return;
    L18:
        r7 = this.T.g;
        goto L19
    L14:
        r3 = r0.b();
        goto L15
    L8:
        if (this.h == false) goto L10;
        r1 = true;
        goto L11
    }

    public final void ta0() {
        Calendar r0 = this.z.getSelectedCalendar();
        com.bytedance.ee.bear.reminder.model.a r1 = this.T;
        if (r1.a == false) goto L7;
        if (this.h == false) goto L7;
    L8:
        boolean r2 = true;
    L10:
        int r3 = this.H.getCurrentItem();
        if (r2 == false) goto L13;
        com.bytedance.ee.bear.reminder.model.a r4 = this.T;
        r4.h = (EAlertTimeEvent) ListProtector.get(r4.a(), r3);
    L14:
        com.bytedance.ee.bear.reminder.model.a r5 = this.S;
        if (r5 != null) goto L17;
    L33:
        if (r2 == false) goto L36;
        this.T.b = fa0(r0);
        return;
    L36:
        if (this.T.j() == false) goto L38;
        long r6 = (f0.b(r0, 0, 0, 0) / 1000) * 1000;
    L39:
        this.T.b = r6;
        return;
    L38:
        r6 = f0.b(r0, 23, 59, 59);
        goto L39
    L17:
        if (r5.b == 0) goto L33;
        if (r5.a != r2) goto L33;
        if (this.T.i() == false) goto L33;
        long r7 = this.S.b;
        java.util.Calendar r8 = java.util.Calendar.getInstance();
        r8.setTimeInMillis(r7);
        r8.set(13, 0);
        r8.set(14, 0);
        if (r2 == false) goto L29;
        long r9 = f0.b(r0, this.G.getSelectedCalendar().get(10), this.G.getSelectedCalendar().get(12), 0);
        if ((r9 / 1000) != (r8.getTimeInMillis() / 1000)) goto L28;
        com.bytedance.ee.bear.reminder.model.a r10 = this.T;
        r10.b = this.S.b;
        return;
    L28:
        this.T.b = fa0(r0);
        return;
    L29:
        r8.set(11, 0);
        r8.set(12, 0);
        long r11 = f0.b(r0, 0, 0, 0);
        if ((r11 / 1000) != (r8.getTimeInMillis() / 1000)) goto L32;
        com.bytedance.ee.bear.reminder.model.a r12 = this.T;
        r12.b = this.S.b;
        return;
    L32:
        this.T.b = (f0.b(r0, 0, 0, 0) / 1000) * 1000;
        return;
    L13:
        com.bytedance.ee.bear.reminder.model.a r13 = this.T;
        r13.g = (EAlertTimeEvent) ListProtector.get(r13.b(), r3);
    L7:
        if (r1.e == true) goto L8;
        r2 = false;
        goto L10
    }

    public ReminderFragment() {
        this.h = true;
        this.U = 0;
        this.V = 0;
        this.W = 1;
        this.p0 = new AnimationSet(false);
    }

    public final void ga0() {
        ta0();
        if (this.T.equals(this.S) == true) goto L5;
        ba0(this.M);
        return;
    L5:
        ReminderViewModel r0 = this.R;
        if (r0 == null) goto L10;
        r0.closeReminder();
        return;
    }

    public boolean onBackPressed() {
        ga0();
        return true;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.Z.a(this);
        ((b) org.koin.java.a.a(b.class)).detachWatermark(this.P);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        Window r1 = null;
    L7:
        if (r1 == null) goto L9;
        r1.setSoftInputMode(48);
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.width = -1;
        r3.gravity = 80;
        r3.height = n.p(requireActivity());
        r1.clearFlags(2);
        r3.windowAnimations = 2131951623;
        r1.setAttributes(r3);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r0.setOnKeyListener(new f(this));
    L9:
        setCancelable(false);
        return;
    L5:
        r1 = r0.getWindow();
        goto L7
    }

    public static void ba0(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void ca0(long r4) {
        com.bytedance.ee.bear.reminder.model.a r0 = this.T;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f == true) goto L7;
        return;
    L7:
        if (r4 <= System.currentTimeMillis()) goto L9;
        boolean r5 = true;
    L10:
        ka0(!r5);
        this.k.setEnabled(r5);
        this.k.setClickable(r5);
        this.K.setEnabled(r5);
        return;
    L9:
        r5 = false;
        goto L10
    }

    public com.bytedance.ee.bear.reminder.model.a ea0(com.bytedance.ee.bear.reminder.model.a r2) {
        return new com.bytedance.ee.bear.reminder.model.a(r2);
    }

    public final long fa0(Calendar r4) {
        CalendarDate r0 = new CalendarDate(this.G.getSelectedCalendar());
        return f0.b(r4, r0.getHour(), r0.getMinute(), r0.getSecond());
    }

    public void ha0(List<ReminderUserEntity> r1) {
        ja0(false);
        na0(false);
    }

    public final void ja0(boolean r2) {
        if (r2 == false) goto L4;
        this.R.onSelectReminderTime();
        this.r.setVisibility(0);
        ma0(this.E, this.J);
        return;
    L4:
        this.r.setVisibility(8);
        oa0(this.E, this.J);
    }

    public final void ka0(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 0;
    L6:
        if (this.x.getVisibility() != r0) goto L8;
        return;
    L8:
        if (r3 == false) goto L10;
        this.x.startAnimation(this.p0);
    L10:
        this.x.setVisibility(r0);
        return;
    L4:
        r0 = 8;
        goto L6
    }

    public final void la0(boolean r3) {
        if (r3 == false) goto L7;
        UDEditText r4 = this.L;
        int r0 = n.a;
        if (r4.requestFocus() == true) goto L6;
        r4.setFocusableInTouchMode(true);
        r4.setFocusable(true);
        r4.requestFocus();
    L6:
        j.d(new p(this), 200);
        return;
    L7:
        this.L.clearFocus();
        c.d(this.L);
    }

    public final void na0(boolean r2) {
        if (r2 == false) goto L4;
        this.R.onSelectTime();
        this.q.setVisibility(0);
        ma0(this.D, this.K);
        return;
    L4:
        this.q.setVisibility(8);
        oa0(this.D, this.K);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        boolean r0 = false;
        la0(false);
        if (r7.getId() != 2131384240) goto L14;
        CalendarView r8 = this.z;
        if (r8.e.getVisibility() != 0) goto L7;
        r0 = true;
    L7:
        if (r0 == false) goto L10;
        YearViewPager r9 = r8.e;
        r9.setCurrentItem(r9.getCurrentItem() - 1, true);
        return;
    L10:
        if (r8.c.getVisibility() != 0) goto L12;
        WeekViewPager r10 = r8.c;
        r10.setCurrentItem(r10.getCurrentItem() - 1, true);
        return;
    L12:
        MonthViewPager r11 = r8.b;
        r11.setCurrentItem(r11.getCurrentItem() - 1, true);
        return;
    L14:
        if (r7.getId() != 2131384239) goto L25;
        CalendarView r12 = this.z;
        if (r12.e.getVisibility() != 0) goto L18;
        r0 = true;
    L18:
        if (r0 == false) goto L21;
        YearViewPager r13 = r12.e;
        r13.setCurrentItem(r13.getCurrentItem() + 1, true);
        return;
    L21:
        if (r12.c.getVisibility() != 0) goto L23;
        WeekViewPager r14 = r12.c;
        r14.setCurrentItem(r14.getCurrentItem() + 1, true);
        return;
    L23:
        MonthViewPager r15 = r12.b;
        r15.setCurrentItem(r15.getCurrentItem() + 1, true);
        return;
    L25:
        if (r7.getId() != 2131384235) goto L34;
        if (this.q.getVisibility() != 0) goto L29;
        boolean r16 = true;
    L30:
        boolean r17 = !r16;
        na0(r17);
        if (r17 == false) goto L96;
        ja0(false);
        return;
    L96:
        return;
    L29:
        r16 = false;
        goto L30
    L34:
        if (r7.getId() != 2131384224) goto L48;
        if (this.r.getVisibility() != 0) goto L38;
        boolean r18 = true;
    L39:
        boolean r19 = !r18;
        ja0(r19);
        if (r19 == false) goto L42;
        na0(false);
        return;
    L42:
        String r20 = (String) this.H.getCurrentObject();
        if (getContext() != null) goto L45;
        return;
    L45:
        if (TextUtils.equals(getContext().getString(2131888151), r20) == false) goto L100;
        this.R.onClickNoReminder();
        return;
    L100:
        return;
    L38:
        r18 = false;
        goto L39
    L48:
        if (r7.getId() != 2131384229) goto L51;
        ga0();
        return;
    L51:
        if (r7.getId() != 2131384242) goto L87;
        long r1 = fa0(this.z.getSelectedCalendar());
        if (this.T.f == false) goto L58;
        if (r1 >= System.currentTimeMillis()) goto L58;
        ca0(r1);
        return;
    L58:
        if (ia0() == false) goto L108;
        ta0();
        com.bytedance.ee.bear.reminder.model.a r21 = this.T;
        r21.getClass();
        if ((r21 instanceof fn5.c) == false) goto L80;
        com.bytedance.ee.bear.reminder.model.a r22 = this.T;
        if (r22.a == true) goto L66;
    L68:
        com.bytedance.ee.bear.reminder.model.a r23 = this.T;
        if (r23.a == false) goto L71;
    L73:
        boolean r24 = false;
    L74:
        if (r24 == true) goto L80;
        List<ReminderUserEntity> r25 = this.T.i;
        if (r25 != null) goto L78;
    L81:
        if (r0 == true) goto L83;
        ba0(this.O);
        return;
    L83:
        ReminderViewModel r26 = this.R;
        if (r26 == null) goto L105;
        r26.saveReminder(this.T);
        return;
    L105:
        return;
    L78:
        if (r25.isEmpty() == false) goto L80;
    L71:
        if (EAlertTimeEvent.noAlert.equals(r23.g) == false) goto L73;
    L72:
        r24 = true;
        goto L74
    L66:
        if (EAlertTimeEvent.noAlert.equals(r22.h) == false) goto L68;
    L80:
        r0 = true;
        goto L81
    L108:
        return;
    L87:
        if (r7.getId() != 2131384704) goto L107;
        ha0(this.T.i);
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (getDialog().getWindow() == null) goto L9;
        WindowManager.LayoutParams r3 = getDialog().getWindow().getAttributes();
        r3.width = n.v();
        r3.height = n.p(requireActivity());
        getDialog().getWindow().setAttributes(r3);
        return;
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onCreate(r2);
        this.Z = pcb.a.a.b(getActivity());
        this.R = da0();
        TextUtils.equals(Locale.ENGLISH.getLanguage(), ((i0) org.koin.java.a.a(i0.class)).a());
        aa0(2131100548);
        setStyle(0, 2131953631);
        if (ForsetiHelper.s(this) == false) goto L6;
        this.R.getActive().observe(this, new r(this));
        return;
    }

    public final void pa0(boolean r6) {
        if (r6 == false) goto L4;
        qa0();
    L4:
        String r7 = (String) this.H.getCurrentObject();
        this.E.setText(r7);
        int r1 = 8;
        boolean r2 = true;
        if (getContext() != null) goto L7;
    L9:
        List<String> r8 = this.T.k;
        if (r8 != null) goto L12;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == false) goto L19;
        com.bytedance.ee.bear.reminder.model.a r0 = this.T;
        r0.getClass();
        if ((r0 instanceof fn5.c) == false) goto L19;
        boolean r3 = true;
    L20:
        View r4 = this.t;
        if (r3 == false) goto L23;
        int r5 = 0;
    L24:
        r4.setVisibility(r5);
        if (r9 == false) goto L29;
        com.bytedance.ee.bear.reminder.model.a r10 = this.T;
        r10.getClass();
        if ((r10 instanceof fn5.c) == false) goto L29;
    L30:
        View r11 = this.s;
        if (r2 == false) goto L33;
        r1 = 0;
    L33:
        r11.setVisibility(r1);
        return;
    L29:
        r2 = false;
        goto L30
    L23:
        r5 = 8;
    L19:
        r3 = false;
        goto L20
    L12:
        if (r8.size() <= 0) goto L14;
        this.F.setVisibility(0);
        goto L14
    L7:
        if (TextUtils.equals(getContext().getString(2131888151), r7) == false) goto L9;
        this.F.setVisibility(8);
        r9 = false;
        goto L15
    }

    public final void ra0(long r4) {
        Context r0 = getContext();
        Map r1 = zu5.a.a;
        if (r0 == null) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == false) goto L8;
        String r5 = "";
    L9:
        this.C.setText(r5);
        return;
    L8:
        c7c.a r3 = new c7c.a();
        r3.a(DatePreciseness.MONTH);
        r5 = c7c.b.a(r0, new Date(r4), r3);
        goto L9
    L5:
        r2 = true;
        goto L6
    }

    public final void sa0(long r4) {
        java.util.Calendar r0 = java.util.Calendar.getInstance();
        r0.setTimeInMillis(r4);
        r0.set(2, r0.get(2) + 1);
        this.G.setSelectedCalendar(r0);
        java.util.Calendar r1 = java.util.Calendar.getInstance();
        r1.setTimeInMillis(r4);
        this.D.setText(zu5.a.d(getContext(), r4));
        ReminderMonthView.updateExpireTime(r1.get(11), r1.get(12));
    }

    public static void ma0(TextView r3, ImageView r4) {
        r3.setSelected(true);
        if (r4.isSelected() == true) goto L6;
        r4.animate().rotationBy(-180.0f).setDuration(200).start();
        r4.setSelected(true);
        return;
    }

    public static void oa0(TextView r2, ImageView r3) {
        r2.setSelected(false);
        if (r3.isSelected() == false) goto L6;
        r3.setSelected(false);
        r3.animate().rotationBy(180.0f).setDuration(200).start();
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r3, r4);
        if (ForsetiHelper.s(this) == false) goto L6;
        c.c(requireActivity());
        long r5 = System.currentTimeMillis();
        pcb.a.a.b(requireActivity()).c(new s(this, r5));
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        View r13 = r10.inflate(2131564276, r11, false);
        TranslateAnimation r14 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r14.setDuration(200);
        this.p0.addAnimation(r14);
        AlphaAnimation r15 = new AlphaAnimation(0.0f, 1.0f);
        r15.setDuration(200);
        this.p0.addAnimation(r15);
        this.j = r13.findViewById(2131384229);
        this.k = r13.findViewById(2131384242);
        this.l = r13.findViewById(2131384240);
        this.m = r13.findViewById(2131384239);
        this.o = r13.findViewById(2131384235);
        this.p = r13.findViewById(2131384224);
        this.q = r13.findViewById(2131384246);
        this.r = r13.findViewById(2131384223);
        this.C = (TextView) r13.findViewById(2131384227);
        this.D = (TextView) r13.findViewById(2131384233);
        this.E = (TextView) r13.findViewById(2131384225);
        this.G = r13.findViewById(2131384247);
        this.H = (WheelView) r13.findViewById(2131384222);
        this.A = r13.findViewById(2131384244);
        this.B = r13.findViewById(2131384232);
        this.w = r13.findViewById(2131384231);
        this.z = r13.findViewById(2131384226);
        this.s = r13.findViewById(2131384704);
        this.I = (ReminderPersonView) r13.findViewById(2131371457);
        this.t = r13.findViewById(2131378827);
        this.L = (AtEditText) r13.findViewById(2131371810);
        this.u = r13.findViewById(2131376836);
        this.i = r13.findViewById(2131381933);
        this.K = (ImageView) r13.findViewById(2131376547);
        this.J = (ImageView) r13.findViewById(2131376546);
        this.n = r13.findViewById(2131384243);
        this.v = r13.findViewById(2131388929);
        this.P = (FrameLayout) r13.findViewById(2131384241);
        this.F = (TextView) r13.findViewById(2131391280);
        this.y = (TextView) r13.findViewById(2131384234);
        this.x = r13.findViewById(2131371762);
        l.c((ImageView) this.j, 2131102418);
        Context r16 = getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r16);
        r0.autoDismiss(true);
        r0.message(2131888145);
        r0.addActionButton(2131391777, 2131888144, new k(this));
        r0.addActionButton(2131391778, 2131888146, new ql5.l(this));
        this.M = r0.build();
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        UDDialogBuilder r2 = new UDDialogBuilder(r1);
        r2.autoDismiss(true);
        r2.title(2131888152);
        r2.message(2131888153);
        r2.addActionButton(2131391777, 2131888143, new m(this));
        r2.addActionButton(2131391778, 2131887716, new ql5.n(this));
        this.N = r2.build();
        Context r3 = getContext();
        Intrinsics.checkNotNullParameter(r3, "context");
        UDDialogBuilder r17 = new UDDialogBuilder(r3);
        r17.autoDismiss(true);
        r17.message(2131888148);
        r17.addActionButton(2131391777, 2131887800, null);
        this.O = r17.build();
        this.G.setDatePickerListener(new u(this));
        this.H.setOnItemSelectedListener(new v(this));
        WheelView r18 = this.H;
        sl5.a r4 = new sl5.a(getContext());
        this.Q = r4;
        r18.setAdapter(r4);
        Calendar r19 = f0.a(System.currentTimeMillis());
        HashMap r5 = new HashMap();
        r5.put(r19.toString(), r19);
        this.z.setSchemeDate(r5);
        this.z.setOnCalendarSelectListener(new t(this));
        this.z.setOnMonthChangeListener(new o(this));
        this.L.setFocusable(true);
        this.L.setFocusableInTouchMode(true);
        ((b) org.koin.java.a.a(b.class)).p(this.P);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.A.setOnCheckedChangeListener(new w(this));
        this.B.setOnCheckedChangeListener(new x(this));
        this.L.addOnLayoutChangeListener(new g(this));
        this.L.addTextChangedListener(new y(this));
        r13.setOnClickListener(new h(this));
        this.i.setOnScrollChangeListener(new z(this));
        this.R.getOriginReminderSettings().observe(this, new e(this));
        this.R.getBearUrl().observe(this, new ql5.j(this));
        this.Z.c(this);
        return r13;
    }

    public final void onKeyboardHeightChanged(pcb.a r1, final int r2, int r3) {
        View r4 = this.u;
        if (r4 == null) goto L9;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r2 <= 0) goto L7;
        int r6 = r2;
    L8:
        r5.height = r6;
        this.u.setLayoutParams(r5);
        goto L9
    L7:
        r6 = n.d(30);
    L9:
        if (r2 <= 0) goto L11;
        ja0(false);
        na0(false);
        j.c(new ql5.q(this, r2));
        return;
    L11:
        ia0();
    }
}
