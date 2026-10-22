package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.ee.bear.bitable.filter.parse.FilterConditionDeserializer;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FilterCondition f211844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FilterOptions f211845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f211846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConditionView f211847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f211848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k.a f211849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f211850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f211851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f211852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f211853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f211854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f211855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f211856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FilterFieldOption f211857o;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.filter.condition.a$a, reason: collision with other inner class name */
    public static final class C3042a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public final /* synthetic */ String getCallbackId() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final void onDetach() {
        this.f211856n = true;
        this.f211850h.dispose();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public List<ConditionListView.b> e() {
        ArrayList r100 = new ArrayList();
        FilterFieldOption r101 = this.f211857o;
        if (r101 == null) goto L5;
        String r102 = r101.getName();
    L6:
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r102, null, j(), l(), 2));
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(k(), this.f211848f, null, false, 12));
        ArrayList r103 = new ArrayList();
        List r104 = (List) i(this.f211844b.getValue(), new BaseFilterConditionView$handleFilterValue$filterValueList$1(this));     // Catch: Exception -> L22
        if (r104 == null) goto L10;
        r103.addAll(r104);     // Catch: Exception -> L22
    L10:
        Boolean r105 = (Boolean) i(this.f211844b.getValue(), new BaseFilterConditionView$handleFilterValue$contentChanged$1(this));     // Catch: Exception -> L22
        if (r105 == null) goto L13;
        boolean r106 = r105.booleanValue();     // Catch: Exception -> L22
    L14:
        this.f211851i = r106;     // Catch: Exception -> L22
        tt5.a.h("FilterConditionView", "handleFilterValue()... fail=" + this.f211851i + ", contentChanged=" + r105);     // Catch: Exception -> L22
        if (m() == false) goto L28;
        if (this.f211844b.getValue() != null) goto L19;
    L20:
        r103.clear();     // Catch: Exception -> L22
        r103.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));     // Catch: Exception -> L22
        goto L28
    L19:
        if (this.f211851i == true) goto L20;
    L28:
        if ((!r103.isEmpty()) == false) goto L30;
        r100.addAll(r103);
    L30:
        return r100;
    L13:
        r106 = false;
    L22:
        e = move-exception;
        tt5.a.d("FilterConditionView", "handleFilterValue()... class cast failed, " + e);
        this.f211844b.getValue();
        ArrayList r107 = new ArrayList();
        if (m() == false) goto L26;
        r107.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
    L26:
        r103.addAll(r107);
        this.f211851i = true;
        goto L28
    L5:
        r102 = null;
        goto L6
    }

    public Integer j() {
        FilterFieldOption r100 = this.f211857o;
        if (r100 == null) goto L7;
        FieldCompositeType r101 = r100.getFieldCompositeType();
        if (r101 == null) goto L7;
        return Integer.valueOf(r101.getIcon());
    L7:
        return null;
    }

    public String k() {
        FilterFieldOption r100 = this.f211857o;
        if (r100 == null) goto L12;
        FilterFieldOption.OperatorOption[] r101 = r100.getAvaliableOperatorOption();
        if (r101 == null) goto L12;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        FilterFieldOption.OperatorOption r104 = r101[r103];
        if (TextUtils.equals(r104.getValue(), this.f211844b.getOperator()) == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r104 != null) goto L15;
        return null;
    L15:
        return r104.getText();
    L12:
        r104 = null;
        goto L13
    }

    public boolean l() {
        FilterFieldOption r100 = this.f211857o;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSync();
    }

    public boolean m() {
        return !com.bytedance.ee.bear.bitable.filter.model.a.a(this.f211844b.getOperator());
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final FilterFieldOption f() {
        return this.f211857o;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public FilterCondition g() {
        return this.f211844b;
    }

    public final Context getContext() {
        return this.f211843a;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        this.f211847e = r100;
        r100.setConditionTitle(xo5.a.c(this.f211843a, R.string.Bitable_Relation_DefaultConditionName_Mobile, "num", String.valueOf(this.f211846d)));
        r100.setConditionCloseVisible(this.f211853k);
        r100.setWarningInfoVisible(this.f211851i);
        if (this.f211851i == false) goto L6;
        r100.setWarningInfo(this.f211843a.getString(R.string.Bitable_Relation_RecordContentDeletedTip_Mobile));
        return;
    }

    public boolean h(T r100) {
        return this.f211852j;
    }

    public final <R> R i(Object r100, Function1<Object, ? extends R> r101) {
        if (r100 == null) goto L10;
        FilterFieldOption r102 = this.f211857o;
        if (r102 == null) goto L13;
        if (r102.isProxyType() == false) goto L13;
        EFieldType r103 = this.f211857o.getFieldCompositeType().getType();
        EFieldType r104 = this.f211857o.getValueFieldType();
        Map<EFieldType, Class<?>> r105 = FilterConditionDeserializer.f211883a;
        return r101.invoke(FilterConditionDeserializer.a.b(r103, r104, r100));
    L13:
        return r101.invoke(r100);
    L10:
        return null;
    }

    public void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "conditionItem");
        r100.setClickable(true);
        Boolean r103 = this.f211854l;
        if (r103 == null) goto L5;
        r100.setCellDisable(Intrinsics.areEqual(r103, Boolean.FALSE));
    L5:
        if (r101 != 0) goto L10;
        Boolean r104 = this.f211855m;
        if (r104 == null) goto L11;
        r100.setLockIconVisible(Intrinsics.areEqual(r104, Boolean.TRUE));
        return;
    L11:
        return;
    }

    public a(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        this.f211843a = r100;
        this.f211844b = r101;
        this.f211845c = r102;
        this.f211846d = r103;
        this.f211848f = r100.getString(R.string.Bitable_Common_PleaseEnterMobileVer);
        this.f211850h = new CompositeDisposable();
        this.f211853k = true;
        FilterFieldOption r104 = null;
        if (r102 == null) goto L12;
        FilterFieldOption[] r105 = r102.getFieldOptions();
        if (r105 == null) goto L12;
        int r106 = r105.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L12;
        FilterFieldOption r108 = r105[r107];
        if (TextUtils.equals(r108.getId(), this.f211844b.getFieldId()) == true) goto L10;
        r107 = r107 + 1;
        goto L7
    L10:
        r104 = r108;
    L12:
        this.f211857o = r104;
    }
}
