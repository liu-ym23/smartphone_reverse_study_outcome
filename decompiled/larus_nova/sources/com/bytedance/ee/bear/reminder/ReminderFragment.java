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
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
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

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ImageView f236446J;
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

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f236447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NestedScrollView f236448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f236449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f236450k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f236451k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f236452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f236453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f236454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f236455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f236456p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final AnimationSet f236457p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f236458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f236459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f236460s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f236461t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f236462u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f236463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f236464w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public UDNotice f236465x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f236466y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CalendarView f236467z;

    public ReminderViewModel da0() {
        return (ReminderViewModel) q.a(this, ReminderViewModel.class);
    }

    public final boolean ia0() {
        if (this.L.getText() != null) goto L5;
        String r100 = "";
    L7:
        if (r100.length() <= this.U) goto L10;
        ba0(this.N);
        this.Y = r100;
        return false;
    L10:
        this.T.f236484j = r100;
        this.L.setText(r100);
        return true;
    L5:
        r100 = this.L.getText().toString();
        goto L7
    }

    public final void qa0() {
        com.bytedance.ee.bear.reminder.model.a r100 = this.T;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f236475a == true) goto L8;
    L10:
        boolean r101 = false;
    L11:
        sl5.a r102 = this.Q;
        if (r101 == false) goto L14;
        List<EAlertTimeEvent> r103 = r100.a();
    L15:
        ((ArrayList) r102.f542465a).clear();
        ((ArrayList) r102.f542465a).addAll(r103);
        WheelView r104 = this.H;
        r104.e();
        r104.requestLayout();
        WheelView r105 = this.H;
        sl5.a r106 = this.Q;
        if (r101 == false) goto L18;
        EAlertTimeEvent r107 = this.T.f236482h;
    L19:
        r105.setCurrentItem(((ArrayList) r106.f542465a).indexOf(r107));
        return;
    L18:
        r107 = this.T.f236481g;
        goto L19
    L14:
        r103 = r100.b();
        goto L15
    L8:
        if (this.f236447h == false) goto L10;
        r101 = true;
        goto L11
    }

    public final void ta0() {
        Calendar r100 = this.f236467z.getSelectedCalendar();
        com.bytedance.ee.bear.reminder.model.a r101 = this.T;
        if (r101.f236475a == false) goto L7;
        if (this.f236447h == false) goto L7;
    L8:
        boolean r102 = true;
    L10:
        int r103 = this.H.getCurrentItem();
        if (r102 == false) goto L13;
        com.bytedance.ee.bear.reminder.model.a r104 = this.T;
        r104.f236482h = (EAlertTimeEvent) ListProtector.get(r104.a(), r103);
    L14:
        com.bytedance.ee.bear.reminder.model.a r105 = this.S;
        if (r105 != null) goto L17;
    L33:
        if (r102 == false) goto L36;
        this.T.f236476b = fa0(r100);
        return;
    L36:
        if (this.T.j() == false) goto L38;
        long r106 = (f0.b(r100, 0, 0, 0) / 1000) * 1000;
    L39:
        this.T.f236476b = r106;
        return;
    L38:
        r106 = f0.b(r100, 23, 59, 59);
        goto L39
    L17:
        if (r105.f236476b == 0) goto L33;
        if (r105.f236475a != r102) goto L33;
        if (this.T.i() == false) goto L33;
        long r107 = this.S.f236476b;
        java.util.Calendar r108 = java.util.Calendar.getInstance();
        r108.setTimeInMillis(r107);
        r108.set(13, 0);
        r108.set(14, 0);
        if (r102 == false) goto L29;
        long r109 = f0.b(r100, this.G.getSelectedCalendar().get(10), this.G.getSelectedCalendar().get(12), 0);
        if ((r109 / 1000) != (r108.getTimeInMillis() / 1000)) goto L28;
        com.bytedance.ee.bear.reminder.model.a r110 = this.T;
        r110.f236476b = this.S.f236476b;
        return;
    L28:
        this.T.f236476b = fa0(r100);
        return;
    L29:
        r108.set(11, 0);
        r108.set(12, 0);
        long r111 = f0.b(r100, 0, 0, 0);
        if ((r111 / 1000) != (r108.getTimeInMillis() / 1000)) goto L32;
        com.bytedance.ee.bear.reminder.model.a r112 = this.T;
        r112.f236476b = this.S.f236476b;
        return;
    L32:
        this.T.f236476b = (f0.b(r100, 0, 0, 0) / 1000) * 1000;
        return;
    L13:
        com.bytedance.ee.bear.reminder.model.a r113 = this.T;
        r113.f236481g = (EAlertTimeEvent) ListProtector.get(r113.b(), r103);
    L7:
        if (r101.f236479e == true) goto L8;
        r102 = false;
        goto L10
    }

    public ReminderFragment() {
        this.f236447h = true;
        this.U = 0;
        this.V = 0;
        this.W = 1;
        this.f236457p0 = new AnimationSet(false);
    }

    public final void ga0() {
        ta0();
        if (this.T.equals(this.S) == true) goto L5;
        ba0(this.M);
        return;
    L5:
        ReminderViewModel r100 = this.R;
        if (r100 == null) goto L10;
        r100.closeReminder();
        return;
    }

    public boolean onBackPressed() {
        ga0();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.Z.a(this);
        ((b) org.koin.java.a.a(b.class)).detachWatermark(this.P);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 != null) goto L5;
        Window r101 = null;
    L7:
        if (r101 == null) goto L9;
        r101.setSoftInputMode(48);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.gravity = 80;
        r102.height = n.p(requireActivity());
        r101.clearFlags(2);
        r102.windowAnimations = R.style.ActionSheetWindowStyle;
        r101.setAttributes(r102);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r100.setOnKeyListener(new f(this));
    L9:
        setCancelable(false);
        return;
    L5:
        r101 = r100.getWindow();
        goto L7
    }

    public static void ba0(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final void ca0(long r100) {
        com.bytedance.ee.bear.reminder.model.a r101 = this.T;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f236480f == true) goto L7;
        return;
    L7:
        if (r100 <= System.currentTimeMillis()) goto L9;
        boolean r102 = true;
    L10:
        ka0(!r102);
        this.f236450k.setEnabled(r102);
        this.f236450k.setClickable(r102);
        this.K.setEnabled(r102);
        return;
    L9:
        r102 = false;
        goto L10
    }

    public com.bytedance.ee.bear.reminder.model.a ea0(com.bytedance.ee.bear.reminder.model.a r100) {
        return new com.bytedance.ee.bear.reminder.model.a(r100);
    }

    public final long fa0(Calendar r100) {
        CalendarDate r101 = new CalendarDate(this.G.getSelectedCalendar());
        return f0.b(r100, r101.getHour(), r101.getMinute(), r101.getSecond());
    }

    public void ha0(List<ReminderUserEntity> r100) {
        ja0(false);
        na0(false);
    }

    public final void ja0(boolean r100) {
        if (r100 == false) goto L4;
        this.R.onSelectReminderTime();
        this.f236459r.setVisibility(0);
        ma0(this.E, this.f236446J);
        return;
    L4:
        this.f236459r.setVisibility(8);
        oa0(this.E, this.f236446J);
    }

    public final void ka0(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L6:
        if (this.f236465x.getVisibility() != r101) goto L8;
        return;
    L8:
        if (r100 == false) goto L10;
        this.f236465x.startAnimation(this.f236457p0);
    L10:
        this.f236465x.setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L6
    }

    public final void la0(boolean r100) {
        if (r100 == false) goto L7;
        AtEditText r101 = this.L;
        int r102 = n.f243167a;
        if (r101.requestFocus() == true) goto L6;
        r101.setFocusableInTouchMode(true);
        r101.setFocusable(true);
        r101.requestFocus();
    L6:
        j.d(new p(this), 200);
        return;
    L7:
        this.L.clearFocus();
        c.d(this.L);
    }

    public final void na0(boolean r100) {
        if (r100 == false) goto L4;
        this.R.onSelectTime();
        this.f236458q.setVisibility(0);
        ma0(this.D, this.K);
        return;
    L4:
        this.f236458q.setVisibility(8);
        oa0(this.D, this.K);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        boolean r101 = false;
        la0(false);
        if (r100.getId() != R.id.reminder_pick_previous) goto L14;
        CalendarView r102 = this.f236467z;
        if (r102.f276094e.getVisibility() != 0) goto L7;
        r101 = true;
    L7:
        if (r101 == false) goto L10;
        YearViewPager r103 = r102.f276094e;
        r103.setCurrentItem(r103.getCurrentItem() - 1, true);
        return;
    L10:
        if (r102.f276092c.getVisibility() != 0) goto L12;
        WeekViewPager r104 = r102.f276092c;
        r104.setCurrentItem(r104.getCurrentItem() - 1, true);
        return;
    L12:
        MonthViewPager r105 = r102.f276091b;
        r105.setCurrentItem(r105.getCurrentItem() - 1, true);
        return;
    L14:
        if (r100.getId() != R.id.reminder_pick_next) goto L25;
        CalendarView r106 = this.f236467z;
        if (r106.f276094e.getVisibility() != 0) goto L18;
        r101 = true;
    L18:
        if (r101 == false) goto L21;
        YearViewPager r107 = r106.f276094e;
        r107.setCurrentItem(r107.getCurrentItem() + 1, true);
        return;
    L21:
        if (r106.f276092c.getVisibility() != 0) goto L23;
        WeekViewPager r108 = r106.f276092c;
        r108.setCurrentItem(r108.getCurrentItem() + 1, true);
        return;
    L23:
        MonthViewPager r109 = r106.f276091b;
        r109.setCurrentItem(r109.getCurrentItem() + 1, true);
        return;
    L25:
        if (r100.getId() != R.id.reminder_expire_time_layout) goto L34;
        if (this.f236458q.getVisibility() != 0) goto L29;
        boolean r110 = true;
    L30:
        boolean r111 = !r110;
        na0(r111);
        if (r111 == false) goto L96;
        ja0(false);
        return;
    L96:
        return;
    L29:
        r110 = false;
        goto L30
    L34:
        if (r100.getId() != R.id.reminder_alert_setting) goto L48;
        if (this.f236459r.getVisibility() != 0) goto L38;
        boolean r112 = true;
    L39:
        boolean r113 = !r112;
        ja0(r113);
        if (r113 == false) goto L42;
        na0(false);
        return;
    L42:
        String r114 = (String) this.H.getCurrentObject();
        if (getContext() != null) goto L45;
        return;
    L45:
        if (TextUtils.equals(getContext().getString(R.string.Doc_Reminder_NoAlert), r114) == false) goto L100;
        this.R.onClickNoReminder();
        return;
    L100:
        return;
    L38:
        r112 = false;
        goto L39
    L48:
        if (r100.getId() != R.id.reminder_close) goto L51;
        ga0();
        return;
    L51:
        if (r100.getId() != R.id.reminder_save) goto L87;
        long r115 = fa0(this.f236467z.getSelectedCalendar());
        if (this.T.f236480f == false) goto L58;
        if (r115 >= System.currentTimeMillis()) goto L58;
        ca0(r115);
        return;
    L58:
        if (ia0() == false) goto L108;
        ta0();
        com.bytedance.ee.bear.reminder.model.a r116 = this.T;
        r116.getClass();
        if ((r116 instanceof fn5.c) == false) goto L80;
        com.bytedance.ee.bear.reminder.model.a r117 = this.T;
        if (r117.f236475a == true) goto L66;
    L68:
        com.bytedance.ee.bear.reminder.model.a r118 = this.T;
        if (r118.f236475a == false) goto L71;
    L73:
        boolean r119 = false;
    L74:
        if (r119 == true) goto L80;
        List<ReminderUserEntity> r120 = this.T.f236483i;
        if (r120 != null) goto L78;
    L81:
        if (r101 == true) goto L83;
        ba0(this.O);
        return;
    L83:
        ReminderViewModel r121 = this.R;
        if (r121 == null) goto L105;
        r121.saveReminder(this.T);
        return;
    L105:
        return;
    L78:
        if (r120.isEmpty() == false) goto L80;
    L71:
        if (EAlertTimeEvent.noAlert.equals(r118.f236481g) == false) goto L73;
    L72:
        r119 = true;
        goto L74
    L66:
        if (EAlertTimeEvent.noAlert.equals(r117.f236482h) == false) goto L68;
    L80:
        r101 = true;
        goto L81
    L108:
        return;
    L87:
        if (r100.getId() != R.id.rl_reminder_person) goto L107;
        ha0(this.T.f236483i);
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (getDialog().getWindow() == null) goto L9;
        WindowManager.LayoutParams r101 = getDialog().getWindow().getAttributes();
        r101.width = n.v();
        r101.height = n.p(requireActivity());
        getDialog().getWindow().setAttributes(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.Z = pcb.a.AbstractC7181a.b(getActivity());
        this.R = da0();
        TextUtils.equals(Locale.ENGLISH.getLanguage(), ((i0) org.koin.java.a.a(i0.class)).a());
        aa0(R.color.bg_body);
        setStyle(0, R.style.Theme_AppCompat_Dialog);
        if (ForsetiHelper.s(this) == false) goto L6;
        this.R.getActive().observe(this, new r(this));
        return;
    }

    public final void pa0(boolean r100) {
        if (r100 == false) goto L4;
        qa0();
    L4:
        String r101 = (String) this.H.getCurrentObject();
        this.E.setText(r101);
        int r102 = 8;
        boolean r103 = true;
        if (getContext() != null) goto L7;
    L9:
        List<String> r104 = this.T.f236485k;
        if (r104 != null) goto L12;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L19;
        com.bytedance.ee.bear.reminder.model.a r106 = this.T;
        r106.getClass();
        if ((r106 instanceof fn5.c) == false) goto L19;
        boolean r107 = true;
    L20:
        View r108 = this.f236461t;
        if (r107 == false) goto L23;
        int r109 = 0;
    L24:
        r108.setVisibility(r109);
        if (r105 == false) goto L29;
        com.bytedance.ee.bear.reminder.model.a r110 = this.T;
        r110.getClass();
        if ((r110 instanceof fn5.c) == false) goto L29;
    L30:
        View r111 = this.f236460s;
        if (r103 == false) goto L33;
        r102 = 0;
    L33:
        r111.setVisibility(r102);
        return;
    L29:
        r103 = false;
        goto L30
    L23:
        r109 = 8;
    L19:
        r107 = false;
        goto L20
    L12:
        if (r104.size() <= 0) goto L14;
        this.F.setVisibility(0);
        goto L14
    L7:
        if (TextUtils.equals(getContext().getString(R.string.Doc_Reminder_NoAlert), r101) == false) goto L9;
        this.F.setVisibility(8);
        r105 = false;
        goto L15
    }

    public final void ra0(long r100) {
        Context r101 = getContext();
        Map<String, SimpleDateFormat> r102 = zu5.a.f573665a;
        if (r101 == null) goto L5;
        boolean r103 = false;
    L6:
        if (r103 == false) goto L8;
        String r104 = "";
    L9:
        this.C.setText(r104);
        return;
    L8:
        c7c.a r105 = new c7c.a();
        r105.a(DatePreciseness.MONTH);
        r104 = c7c.b.a(r101, new Date(r100), r105);
        goto L9
    L5:
        r103 = true;
        goto L6
    }

    public final void sa0(long r100) {
        java.util.Calendar r101 = java.util.Calendar.getInstance();
        r101.setTimeInMillis(r100);
        r101.set(2, r101.get(2) + 1);
        this.G.setSelectedCalendar(r101);
        java.util.Calendar r102 = java.util.Calendar.getInstance();
        r102.setTimeInMillis(r100);
        this.D.setText(zu5.a.d(getContext(), r100));
        ReminderMonthView.updateExpireTime(r102.get(11), r102.get(12));
    }

    public static void ma0(TextView r100, ImageView r101) {
        r100.setSelected(true);
        if (r101.isSelected() == true) goto L6;
        r101.animate().rotationBy(-180.0f).setDuration(200).start();
        r101.setSelected(true);
        return;
    }

    public static void oa0(TextView r100, ImageView r101) {
        r100.setSelected(false);
        if (r101.isSelected() == false) goto L6;
        r101.setSelected(false);
        r101.animate().rotationBy(180.0f).setDuration(200).start();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (ForsetiHelper.s(this) == false) goto L6;
        c.c(requireActivity());
        long r102 = System.currentTimeMillis();
        pcb.a.AbstractC7181a.b(requireActivity()).c(new s(this, r102));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        View r113 = r110.inflate(R.layout.reminder_layout, r111, false);
        TranslateAnimation r114 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r114.setDuration(200);
        this.f236457p0.addAnimation(r114);
        AlphaAnimation r115 = new AlphaAnimation(0.0f, 1.0f);
        r115.setDuration(200);
        this.f236457p0.addAnimation(r115);
        this.f236449j = r113.findViewById(R.id.reminder_close);
        this.f236450k = r113.findViewById(R.id.reminder_save);
        this.f236452l = r113.findViewById(R.id.reminder_pick_previous);
        this.f236453m = r113.findViewById(R.id.reminder_pick_next);
        this.f236455o = r113.findViewById(R.id.reminder_expire_time_layout);
        this.f236456p = r113.findViewById(R.id.reminder_alert_setting);
        this.f236458q = r113.findViewById(R.id.reminder_time_picker);
        this.f236459r = r113.findViewById(R.id.reminder_alert_picker);
        this.C = (TextView) r113.findViewById(R.id.reminder_calendar_date);
        this.D = (TextView) r113.findViewById(R.id.reminder_expire_time);
        this.E = (TextView) r113.findViewById(R.id.reminder_alert_time);
        this.G = (UDTimePicker) r113.findViewById(R.id.reminder_time_picker_view);
        this.H = (WheelView) r113.findViewById(R.id.reminder_alert_event_picker);
        this.A = (UDSwitch) r113.findViewById(R.id.reminder_setting_time_switch);
        this.B = (UDSwitch) r113.findViewById(R.id.reminder_create_task_switch);
        this.f236464w = r113.findViewById(R.id.reminder_create_task);
        this.f236467z = (CalendarView) r113.findViewById(R.id.reminder_calendar);
        this.f236460s = r113.findViewById(R.id.rl_reminder_person);
        this.I = (ReminderPersonView) r113.findViewById(R.id.edit_reminder_person_layout);
        this.f236461t = r113.findViewById(R.id.ll_reminder_text);
        this.L = (AtEditText) r113.findViewById(R.id.et_reminder_text);
        this.f236462u = r113.findViewById(R.id.keyboard_placeholder);
        this.f236448i = (NestedScrollView) r113.findViewById(R.id.parent_scroll_view);
        this.K = (ImageView) r113.findViewById(R.id.iv_reminder_expire_time);
        this.f236446J = (ImageView) r113.findViewById(R.id.iv_reminder_alert_time);
        this.f236454n = r113.findViewById(R.id.reminder_setting_time);
        this.f236463v = r113.findViewById(R.id.titlebar_divider);
        this.P = (FrameLayout) r113.findViewById(R.id.reminder_root);
        this.F = (TextView) r113.findViewById(R.id.tv_reminder_person_name);
        this.f236466y = (TextView) r113.findViewById(R.id.reminder_expire_time_hint);
        this.f236465x = (UDNotice) r113.findViewById(R.id.error_notice);
        l.c((ImageView) this.f236449j, R.color.icon_n1);
        Context r116 = getContext();
        Intrinsics.checkNotNullParameter(r116, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r100 = new UDDialogBuilder(r116);
        r100.autoDismiss(true);
        r100.message(R.string.Doc_Reminder_CloseConfirm);
        r100.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Reminder_Cancel, new k(this));
        r100.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Reminder_Confirm, new ql5.l(this));
        this.M = r100.build();
        Context r101 = getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r102 = new UDDialogBuilder(r101);
        r102.autoDismiss(true);
        r102.title(R.string.Doc_Reminder_Note_Fail_Title);
        r102.message(R.string.Doc_Reminder_Note_Max_BodyText);
        r102.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Reminder_Button_Reedit, new m(this));
        r102.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, new ql5.n(this));
        this.N = r102.build();
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r117 = new UDDialogBuilder(r103);
        r117.autoDismiss(true);
        r117.message(R.string.Doc_Reminder_FillNotifyPerson);
        r117.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_Ok, null);
        this.O = r117.build();
        this.G.setDatePickerListener(new u(this));
        this.H.setOnItemSelectedListener(new v(this));
        WheelView r118 = this.H;
        sl5.a r104 = new sl5.a(getContext());
        this.Q = r104;
        r118.setAdapter(r104);
        Calendar r119 = f0.a(System.currentTimeMillis());
        HashMap r105 = new HashMap();
        r105.put(r119.toString(), r119);
        this.f236467z.setSchemeDate(r105);
        this.f236467z.setOnCalendarSelectListener(new t(this));
        this.f236467z.setOnMonthChangeListener(new o(this));
        this.L.setFocusable(true);
        this.L.setFocusableInTouchMode(true);
        ((b) org.koin.java.a.a(b.class)).p(this.P);
        this.f236452l.setOnClickListener(this);
        this.f236453m.setOnClickListener(this);
        this.f236455o.setOnClickListener(this);
        this.f236456p.setOnClickListener(this);
        this.f236449j.setOnClickListener(this);
        this.f236450k.setOnClickListener(this);
        this.f236460s.setOnClickListener(this);
        this.A.setOnCheckedChangeListener(new w(this));
        this.B.setOnCheckedChangeListener(new x(this));
        this.L.addOnLayoutChangeListener(new g(this));
        this.L.addTextChangedListener(new y(this));
        r113.setOnClickListener(new h(this));
        this.f236448i.setOnScrollChangeListener(new z(this));
        this.R.getOriginReminderSettings().observe(this, new e(this));
        this.R.getBearUrl().observe(this, new ql5.j(this));
        this.Z.c(this);
        return r113;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, final int r101, int r102) {
        View r103 = this.f236462u;
        if (r103 == null) goto L9;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r101 <= 0) goto L7;
        int r105 = r101;
    L8:
        r104.height = r105;
        this.f236462u.setLayoutParams(r104);
        goto L9
    L7:
        r105 = n.d(30);
    L9:
        if (r101 <= 0) goto L11;
        ja0(false);
        na0(false);
        j.c(new ql5.q(this, r101));
        return;
    L11:
        ia0();
    }
}
