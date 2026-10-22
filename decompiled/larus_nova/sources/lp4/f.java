package lp4;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import hp4.g;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes15.dex */
public class f extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UDTimePicker f510221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f510222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f510223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f510224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f510225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f510226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f510227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f510228t;

    public class a implements c18.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f510229a;

        public a(f r100) {
            this.f510229a = r100;
        }

        @Override // c18.a
        public final void a(int r100, int r101, int r102, int r103, int r104) {
            f r105 = this.f510229a;
            r105.f510225q = true;
            r105.v("roll_to_select");
        }
    }

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        w();
    }

    @Override // hp4.g
    public final void t() {
        super.t();
        g.b r100 = this.f486402f;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.f510226r;
        boolean r102 = true;
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L11;
    L19:
        HashMap r103 = new HashMap();
        if (this.f510226r != 1) goto L22;
        boolean r104 = true;
    L23:
        r103.put(BitableAnalytic.EditParamKey.CLICK_DONE_BTN, String.valueOf(r104));
        if (this.f510226r == 2) goto L27;
        r102 = false;
    L27:
        r103.put(BitableAnalytic.EditParamKey.CLICK_CLEAR_BTN, String.valueOf(r102));
        this.f486402f.d(r103, null);
        this.f510226r = 3;
        this.f510225q = false;
        return;
    L22:
        r104 = false;
        goto L23
    L11:
        if (this.f510224p == false) goto L13;
    L16:
        r100.c(Long.valueOf(this.f510221m.getSelectedCalendar().getTimeInMillis()));
        goto L19
    L13:
        if (this.f510225q == true) goto L16;
        return;
    L17:
        r100.c(null);
        goto L19
    L18:
        r100.c(Long.valueOf(this.f510221m.getSelectedCalendar().getTimeInMillis()));
        goto L19
    }

    public final void w() {
        Calendar r100 = Calendar.getInstance();
        if (TextUtils.isEmpty(this.f510227s) == true) goto L5;
        r100.setTimeZone(TimeZone.getTimeZone(this.f510227s));
        r100.get(14);
    L5:
        Long r101 = this.f510222n;
        if (r101 == null) goto L8;
        r100.setTimeInMillis(r101.longValue());
    L10:
        if (TextUtils.isEmpty(this.f510223o) == false) goto L15;
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.record.fix.datecell.selecterror") == false) goto L14;
        r100.set(14, 0);
        r100.set(13, 0);
        r100.set(12, 0);
        r100.set(11, 0);
    L14:
        this.f510221m.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.f510221m.setSelectedCalendar(r100);
        return;
    L15:
        this.f510221m.setPickerMode(PickerModel.MONTHDAY_HOUR_MINUTE_24H);
        this.f510221m.setSelectedCalendar(r100);
        return;
    L8:
        r100.set(13, 0);
        r100.set(14, 0);
        goto L10
    }

    public f(Context r100) {
        super(r100);
        this.f510225q = false;
        this.f510226r = 3;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_date_edit_panel, null);
        this.f486399c = r101;
        UDTimePicker r102 = (UDTimePicker) r101.findViewById(R.id.date_picker_view);
        this.f510221m = r102;
        this.f510228t = (TextView) this.f486399c.findViewById(R.id.field_title);
        this.f486399c.findViewById(R.id.clear_tv).setOnClickListener(new d(this));
        this.f486399c.findViewById(R.id.confirm_tv).setOnClickListener(new e(this));
        r102.setDatePickerListener(new a(this));
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }
}
