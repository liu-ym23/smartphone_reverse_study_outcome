package grb;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.message.card.component.CardCalendarDialogFactory$CardCalendarType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends UDDialogController implements View.OnClickListener, c18.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f482416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardCalendarDialogFactory$CardCalendarType f482417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f482418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f482419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f482420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f482421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDTimePicker f482422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDTimePicker f482423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f482424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f482425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f482426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Calendar f482427l;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        int r101 = a.f482412a[this.f482417b.ordinal()];
        if (r101 != 1) goto L5;
        UDTimePicker r102 = (UDTimePicker) r100.findViewById(R.id.first_picker);
        this.f482422g = r102;
        r102.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.f482422g.setSelectedCalendar(this.f482427l);
        this.f482422g.setDatePickerListener(this);
    L12:
        return r100;
    L5:
        if (r101 != 2) goto L7;
        UDTimePicker r103 = (UDTimePicker) r100.findViewById(R.id.first_picker);
        this.f482422g = r103;
        r103.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.f482422g.setSelectedCalendar(this.f482427l);
        this.f482422g.setDatePickerListener(this);
        goto L12
    L7:
        if (r101 != 3) goto L12;
        UDTimePicker r104 = (UDTimePicker) r100.findViewById(R.id.first_picker);
        this.f482422g = r104;
        r104.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.f482422g.setSelectedCalendar(this.f482427l);
        UDTimePicker r105 = (UDTimePicker) r100.findViewById(R.id.second_picker);
        this.f482423h = r105;
        r105.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.f482423h.setSelectedCalendar(this.f482427l);
        this.f482422g.setDatePickerListener(this);
        this.f482423h.setDatePickerListener(this);
        goto L12
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r100 = super.onCreateFooter();
        if (r100 != null) goto L5;
    L7:
        return r100;
    L5:
        if (this.f482417b != CardCalendarDialogFactory$CardCalendarType.DateTime) goto L7;
        this.f482425j = (TextView) r100.findViewById(R.id.date_tab);
        this.f482426k = (TextView) r100.findViewById(R.id.time_tab);
        View r101 = r100.findViewById(R.id.tab_layout);
        this.f482424i = r101;
        r101.setVisibility(0);
        this.f482425j.setOnClickListener(this);
        this.f482426k.setOnClickListener(this);
        goto L7
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateHeader() {
        View r100 = super.onCreateHeader();
        this.f482419d = r100.findViewById(R.id.cancel_tv);
        this.f482420e = (TextView) r100.findViewById(R.id.title_tv);
        this.f482421f = r100.findViewById(R.id.confirm_tv);
        this.f482419d.setOnClickListener(this);
        this.f482421f.setOnClickListener(this);
        return r100;
    }

    public c(Context r100) {
        super(r100);
        this.f482416a = -1;
        this.f482427l = null;
    }

    public static void b(UDDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != this.f482419d) goto L6;
        b(getMDialog());
        return;
    L6:
        if (r100 == this.f482421f) goto L8;
        TextView r101 = this.f482425j;
        if (r100 != r101) goto L24;
        r101.setTextColor(y9c.d.c(getContext(), R.color.primary_fill_default));
        this.f482426k.setTextColor(y9c.d.c(getContext(), R.color.text_title));
        this.f482422g.setVisibility(0);
        this.f482423h.setVisibility(8);
        return;
    L24:
        if (r100 != this.f482426k) goto L31;
        r101.setTextColor(y9c.d.c(getContext(), R.color.text_title));
        this.f482426k.setTextColor(y9c.d.c(getContext(), R.color.primary_fill_default));
        this.f482422g.setVisibility(8);
        this.f482423h.setVisibility(0);
        return;
    L31:
        return;
    L8:
        if (this.f482418c == null) goto L28;
        int r102 = a.f482412a[this.f482417b.ordinal()];
        if (r102 != 1) goto L12;
        String r103 = "yyyy-MM-dd";
    L19:
        this.f482418c.a(c(r103, this.f482427l.getTime(), true), this.f482427l.getTimeInMillis());
        b(getMDialog());
        return;
    L12:
        if (r102 != 2) goto L14;
        r103 = "HH:mm";
        goto L19
    L14:
        if (r102 == 3) goto L16;
        r103 = null;
        goto L19
    L16:
        r103 = "yyyy-MM-dd HH:mm";
        goto L19
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        if ((r100 instanceof b) == false) goto L8;
        b r102 = (b) r100;
        this.f482416a = r102.f482413a;
        Calendar r103 = Calendar.getInstance();
        this.f482427l = r103;
        long r104 = this.f482416a;
        if (r104 <= (-1)) goto L7;
        r103.setTimeInMillis(r104);
    L7:
        this.f482417b = r102.f482414b;
        this.f482418c = r102.f482415c;
    L8:
        super.apply(r100, r101);
    }

    public final String c(String r100, Date r101, boolean r102) {
        if (r102 == false) goto L5;
        r100 = r100 + " Z";
    L5:
        return new SimpleDateFormat(r100, Locale.ENGLISH).format(r101);
    }

    @Override // c18.a
    public final void a(int r100, int r101, int r102, int r110, int r111) {
        this.f482421f.setEnabled(true);
        int r103 = a.f482412a[this.f482417b.ordinal()];
        if (r103 != 1) goto L5;
    L10:
        this.f482427l = this.f482422g.getSelectedCalendar();
        return;
    L5:
        if (r103 == 2) goto L10;
        if (r103 != 3) goto L13;
        Calendar r104 = this.f482422g.getSelectedCalendar();
        Calendar r112 = this.f482423h.getSelectedCalendar();
        Calendar r113 = Calendar.getInstance();
        r113.set(r104.get(1), r104.get(2), r104.get(5), r112.get(11), r112.get(12));
        this.f482427l = r113;
        this.f482420e.setText(c("yyyy-MM-dd HH:mm", r113.getTime(), false));
        return;
    }
}
