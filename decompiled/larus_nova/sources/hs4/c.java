package hs4;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.ee.bear.bitable.ddui.model.StepContentValueItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.StepContentValueModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends hs4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f486968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDTimePicker f486969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f486970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f486971e;

    public static final class a implements c18.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepContentValueModel f486972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f486973b;

        public a(StepContentValueModel r100, c r101) {
            this.f486972a = r100;
            this.f486973b = r101;
        }

        @Override // c18.a
        public final void a(int r100, int r101, int r102, int r103, int r104) {
            StepContentValueModel r105 = this.f486972a;
            if (r105 == null) goto L9;
            ArrayList<StepContentValueItemModel> r106 = r105.getData();
            if (r106 == null) goto L9;
            boolean r107 = true;
            if ((!r106.isEmpty()) != true) goto L9;
        L10:
            String r108 = null;
            if (r107 == false) goto L17;
            ArrayList<StepContentValueItemModel> r109 = this.f486972a.getData();
            if (r109 == null) goto L17;
            StepContentValueItemModel r110 = (StepContentValueItemModel) ListProtector.get(r109, 0);
            if (r110 == null) goto L17;
            r108 = r110.getOnInputChanged();
        L17:
            c r111 = this.f486973b;
            Calendar r112 = r111.f486969c.getSelectedCalendar();
            r112.set(11, 0);
            r112.set(12, 0);
            r112.set(13, 0);
            r112.set(14, 0);
            r111.c(r108, Long.valueOf(r112.getTimeInMillis()));
            return;
        L9:
            r107 = false;
            goto L10
        }
    }

    @Override // hs4.d
    public final void b(StepContentValueModel r100) {
    }

    @Override // hs4.d
    public final View getView() {
        return this.f486968b;
    }

    @Override // hs4.d
    public final void a(StepContentValueModel r100) {
        boolean r101 = true;
        if (r100 == null) goto L9;
        ArrayList<StepContentValueItemModel> r102 = r100.getData();
        if (r102 == null) goto L9;
        if ((!r102.isEmpty()) != true) goto L9;
        boolean r103 = true;
    L10:
        Long r104 = null;
        if (r103 == false) goto L17;
        ArrayList<StepContentValueItemModel> r105 = r100.getData();
        if (r105 == null) goto L17;
        StepContentValueItemModel r106 = (StepContentValueItemModel) ListProtector.get(r105, 0);
        if (r106 == null) goto L17;
        String r107 = r106.getTimeZone();
    L18:
        this.f486970d = r107;
        if (r100 == null) goto L25;
        ArrayList<StepContentValueItemModel> r108 = r100.getData();
        if (r108 == null) goto L25;
        if ((!r108.isEmpty()) != true) goto L25;
    L26:
        if (r101 == false) goto L32;
        ArrayList<StepContentValueItemModel> r109 = r100.getData();
        if (r109 == null) goto L32;
        StepContentValueItemModel r110 = (StepContentValueItemModel) ListProtector.get(r109, 0);
        if (r110 == null) goto L32;
        r104 = r110.getTimestamp();
    L32:
        this.f486971e = r104;
        Calendar r111 = Calendar.getInstance();
        if (TextUtils.isEmpty(this.f486970d) == true) goto L35;
        r111.setTimeZone(TimeZone.getTimeZone(this.f486970d));
    L35:
        Intrinsics.checkNotNull(r111);
        Long r112 = this.f486971e;
        if (r112 == null) goto L38;
        r111.setTimeInMillis(r112.longValue());
    L38:
        this.f486969c.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.f486969c.setSelectedCalendar(r111);
        this.f486969c.setDatePickerListener(new a(r100, this));
        return;
    L25:
        r101 = false;
    L17:
        r107 = null;
    L9:
        r103 = false;
        goto L10
    }

    public c(Context r100, com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_date_filter_value_view_v2, null);
        this.f486968b = r102;
        this.f486969c = (UDTimePicker) r102.findViewById(R.id.date_picker_panel);
    }
}
