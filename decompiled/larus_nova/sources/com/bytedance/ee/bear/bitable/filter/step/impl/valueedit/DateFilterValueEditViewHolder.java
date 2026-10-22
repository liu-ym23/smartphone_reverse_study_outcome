package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.filter.model.EFilterDuration;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.ee.bear.bitable.filter.parse.FilterConditionDeserializer;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class DateFilterValueEditViewHolder extends com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<Object[]> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f211937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f211938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f211939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f211940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UDTimePicker f211941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EFilterStep.SubValueStep f211942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Pair<? extends EFilterDuration, Long> f211943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EFilterDuration f211944p;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/DateFilterValueEditViewHolder$DurationListResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "getData", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "setData", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DurationListResult implements NonProguard {
        private FilterOptions.DurationOption[] data;

        public DurationListResult() {
        }

        public final FilterOptions.DurationOption[] getData() {
            return this.data;
        }

        public final void setData(FilterOptions.DurationOption[] r100) {
            this.data = r100;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final boolean b() {
        Map<EFieldType, Class<?>> r100 = FilterConditionDeserializer.f211883a;
        return !Intrinsics.areEqual(this.f211943o, FilterConditionDeserializer.a.a(i()));
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a, com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final String getTitle() {
        Context r100 = this.f211972a;
        if (this.f211942n != EFilterStep.SubValueStep.ExactDate) goto L5;
        int r101 = R.string.Bitable_Filter_SelectDateTitle_Mobile;
    L7:
        return r100.getString(r101);
    L5:
        r101 = R.string.Bitable_Relation_ConditionValue_Mobile;
        goto L7
    }

    public final Object[] i() {
        ArrayList r100 = new ArrayList();
        EFilterDuration r101 = this.f211944p;
        Long r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getValue();
    L6:
        r100.add(r103);
        if (gs4.a.a(this.f211944p) == false) goto L24;
        EFilterStep.SubValueStep r104 = this.f211942n;
        if (r104 != EFilterStep.SubValueStep.Duration) goto L21;
        EFilterDuration r105 = this.f211944p;
        Pair<? extends EFilterDuration, Long> r106 = this.f211943o;
        if (r106 == null) goto L13;
        EFilterDuration r107 = r106.getFirst();
    L14:
        if (r105 != r107) goto L19;
        Pair<? extends EFilterDuration, Long> r108 = this.f211943o;
        if (r108 == null) goto L18;
        r102 = r108.getSecond();
    L18:
        r100.add(r102);
        goto L24
    L19:
        r100.add(null);
        goto L24
    L13:
        r107 = null;
        goto L14
    L21:
        if (r104 != EFilterStep.SubValueStep.ExactDate) goto L24;
        Calendar r109 = this.f211941m.getSelectedCalendar();
        r109.set(11, 0);
        r109.set(12, 0);
        r109.set(13, 0);
        r109.set(14, 0);
        r100.add(Long.valueOf(r109.getTimeInMillis()));
    L24:
        return r100.toArray(new Object[0]);
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final /* bridge */ /* synthetic */ Object[] c() {
        return i();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f211938j;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a, com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final void a(EFilterStep.SubValueStep r100) {
        if (r100 != null) goto L4;
        r100 = EFilterStep.SubValueStep.Duration;
    L4:
        this.f211942n = r100;
        int r101 = 0;
        if (r100 != EFilterStep.SubValueStep.Duration) goto L7;
        boolean r102 = true;
    L8:
        View r103 = this.f211939k;
        if (r102 == false) goto L11;
        int r104 = 0;
    L12:
        r103.setVisibility(r104);
        UDTimePicker r105 = this.f211941m;
        if (r102 == false) goto L15;
        r101 = 8;
    L15:
        r105.setVisibility(r101);
        return;
    L11:
        r104 = 8;
        goto L12
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(Object[] r100) {
        Map<EFieldType, Class<?>> r101 = FilterConditionDeserializer.f211883a;
        Pair<? extends EFilterDuration, Long> r102 = FilterConditionDeserializer.a.a(r100);
        this.f211943o = r102;
        Observable r103 = null;
        if (r102 == null) goto L5;
        EFilterDuration r104 = r102.getFirst();
    L6:
        this.f211944p = r104;
        if (this.f211942n != EFilterStep.SubValueStep.Duration) goto L15;
        JSONObject r105 = new JSONObject();
        r105.put(OnekeyLoginConstants.CU_KEY_OPERATOR, this.f211937i);
        EQueryType r106 = EQueryType.GET_FILTER_DURATIONS;
        Intrinsics.checkNotNullParameter(r106, "queryType");
        Intrinsics.checkNotNullParameter(DurationListResult.class, "resultType");
        vv4.k r107 = this.f211977f;
        if (r107 == null) goto L11;
        r103 = nr4.a.a(r107, r106, r105, DurationListResult.class, null);
    L11:
        if (r103 == null) goto L15;
        Observable r108 = r103.map(d.f211988a);
        if (r108 == null) goto L15;
        r108.subscribe(new e(this), f.f211990a);
    L15:
        Calendar r109 = Calendar.getInstance();
        if (TextUtils.isEmpty(this.f211976e) == true) goto L18;
        r109.setTimeZone(TimeZone.getTimeZone(this.f211976e));
    L18:
        Intrinsics.checkNotNull(r109);
        Pair<? extends EFilterDuration, Long> r110 = this.f211943o;
        if (r110 == null) goto L23;
        Long r111 = r110.getSecond();
        if (r111 == null) goto L23;
        r109.setTimeInMillis(r111.longValue());
    L23:
        this.f211941m.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.f211941m.setSelectedCalendar(r109);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public DateFilterValueEditViewHolder(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        this.f211937i = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_date_filter_value_view, null);
        this.f211938j = r103;
        this.f211939k = r103.findViewById(R.id.durations_panel);
        this.f211940l = (ViewGroup) r103.findViewById(R.id.durations_group_view);
        this.f211941m = (UDTimePicker) r103.findViewById(R.id.date_picker_panel);
    }
}
