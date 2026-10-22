package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class a extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PickerModel f285373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f285374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f285375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDTimePickerBuilder.a f285376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f285377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDTimePickerBuilder.a f285378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f285379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f285380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Calendar f285381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDate f285382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CalendarDate f285383k;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.action.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3920a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f285384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UDTimePickerActionView f285385b;

        public ViewOnClickListenerC3920a(a r100, UDTimePickerActionView r101) {
            this.f285384a = r100;
            this.f285385b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f285384a;
            if (r101.f285376d != null) goto L23;
            UDDialog r102 = r101.getMDialog();
            if (r102 == null) goto L23;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r102);
            goto L23
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r104 == null) goto L20;
            d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L9:
            if (Looper.myLooper() == r103.getLooper()) goto L11;
            r103.post(DialogLancet.createDismissRunnable(r102));
        L23:
            CalendarDate r105 = new CalendarDate(this.f285385b.getUDTimePicker().getSelectedCalendar());
            a r106 = this.f285384a;
            UDTimePickerBuilder.a r107 = r106.f285376d;
            if (r107 == null) goto L30;
            a.b(r106, r107, r105);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTimePickerActionView f285386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f285387b;

        public b(UDTimePickerActionView r100, a r101) {
            this.f285386a = r100;
            this.f285387b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CalendarDate r101 = new CalendarDate(this.f285386a.getUDTimePicker().getSelectedCalendar());
            this.f285387b.getClass();
            a r102 = this.f285387b;
            UDTimePickerBuilder.a r103 = r102.f285378f;
            if (r103 == null) goto L6;
            a.b(r102, r103, r101);
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View createView() {
        View r100 = super.createView();
        UDTimePickerActionView r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof UDTimePickerActionView) == false) goto L8;
        r101 = (UDTimePickerActionView) r100;
    L8:
        if (r101 != null) goto L10;
        return r100;
    L10:
        CalendarDate r102 = this.f285382j;
        CalendarDate r103 = this.f285383k;
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
        r101.getUDTimePicker().setPickerDateRange$universe_ui_datepicker_release(r102, r103);
    L14:
        r101.setPickerMode(this.f285373a);
        String r104 = this.f285379g;
        String r105 = "";
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        r101.setTitleText(r104);
        String r106 = this.f285374b;
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        r101.setLeftActionViewText(r106);
        Integer r107 = this.f285375c;
        if (r107 == null) goto L23;
        r101.setLeftTextColor(r107.intValue());
    L23:
        String r108 = this.f285377e;
        if (r108 == null) goto L27;
        r105 = r108;
    L27:
        r101.setRightActionViewText(r105);
        setupTextView(r101.getTitleTextView(), getMTitleSize(), getMTitleTextColor());
        r101.setInterval(this.f285380h);
        Calendar r109 = this.f285381i;
        if (r109 == null) goto L30;
        r101.setSelectedTime(r109);
    L30:
        r101.setLeftActionViewClickListener(new ViewOnClickListenerC3920a(this, r101));
        r101.setRightActionViewClickListener(new b(r101, this));
        return r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f285373a = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        this.f285380h = 1;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof UDTimePickerBuilder) == false) goto L7;
        super.apply(r100, r101);
        UDTimePickerBuilder r102 = (UDTimePickerBuilder) r100;
        this.f285373a = r102.f285362a;
        this.f285376d = r102.f285365d;
        this.f285375c = r102.f285364c;
        this.f285374b = r102.f285363b;
        this.f285378f = r102.f285367f;
        this.f285377e = r102.f285366e;
        this.f285379g = r102.f285368g;
        this.f285380h = r102.f285369h;
        this.f285381i = r102.f285370i;
        this.f285382j = r102.f285371j;
        this.f285383k = r102.f285372k;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDTimePickerBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }

    public static final void b(a r100, UDTimePickerBuilder.a r101, CalendarDate r102) {
        UDDialog r103 = r100.getMDialog();
        if (r103 == null) goto L6;
        int r104 = r102.getYear();
        int r105 = r102.getMonth() - 1;
        int r106 = r102.getMonthDay();
        r102.getHour();
        r102.getMinute();
        r101.a(r103, r104, r105, r106);
        return;
    }
}
