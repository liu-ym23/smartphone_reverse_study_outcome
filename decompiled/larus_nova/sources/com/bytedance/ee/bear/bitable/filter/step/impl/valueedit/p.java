package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorListResult;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapterV2;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.bitable.filter.model.EFilterOperator;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import io.reactivex.Observable;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class p extends com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<String[]> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f212011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RecyclerView f212012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SelectEditAdapter f212013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f212014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SpaceEmptyState f212015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f212016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f212017o;

    public static final class a extends SelectEditAdapter.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f212018a;

        public a(p r100) {
            this.f212018a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.d, com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.a
        public final void j(boolean r100) {
            this.f212018a.k(r100);
        }
    }

    public static final class b {
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f212019a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(p r100) {
            this.f212019a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            SelectEditAdapter r101 = this.f212019a.f212013k;
            if (r100 == null) goto L5;
            String r102 = r100.toString();
        L6:
            r101.B2(r102);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final boolean b() {
        return !Arrays.equals(this.f212016n, j());
    }

    public final String[] j() {
        List<String> r100 = this.f212013k.f208064d;
        boolean r101 = false;
        if (r100 == null) goto L5;
        String[] r102 = (String[]) r100.toArray(new String[0]);
    L6:
        if (r102 != null) goto L8;
    L14:
        if (r101 == true) goto L16;
        return null;
    L16:
        return r102;
    L8:
        if (r102.length != 0) goto L10;
        boolean r103 = true;
    L12:
        if ((!r103) != true) goto L14;
        r101 = true;
        goto L14
    L10:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final /* bridge */ /* synthetic */ String[] c() {
        return j();
    }

    public SelectEditAdapter i() {
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L6;
        return new SelectEditAdapterV2();
    L6:
        return new SelectEditAdapter();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f212011i;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(String[] r100) {
        String[] r101 = r100;
        this.f212016n = r101;
        FilterFieldOption r102 = this.f211973b;
        Observable r103 = null;
        if (r102 == null) goto L5;
        OptionItem[] r104 = r102.getSelectFieldOptions();
    L7:
        if (r104 == null) goto L13;
        boolean r105 = false;
        if (r104.length != 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L13;
    L14:
        if (r105 == false) goto L16;
        k(true);
        return;
    L16:
        JSONObject r107 = new JSONObject();
        r107.put("type", CommonActionType.COLOR_LIST.getValue());
        Intrinsics.checkNotNullParameter("lark.biz.util.getBitableCommonData", "funcName");
        Intrinsics.checkNotNullParameter(ColorListResult.class, "resultType");
        Observable r108 = Observable.create(new com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.b(this, r107, ColorListResult.class));
        if (r108 == null) goto L19;
        r103 = r108.map(q.f212020a);
    L19:
        if (r103 == null) goto L23;
        r103.subscribe(new r(this, r101), s.f212023a);
        return;
    L23:
        return;
    L11:
        r106 = false;
    L13:
        r105 = true;
        goto L14
    L5:
        r104 = null;
        goto L7
    }

    public final void k(boolean r100) {
        RecyclerView r101 = this.f212012j;
        int r102 = 8;
        boolean r103 = false;
        if (r100 == false) goto L5;
        int r104 = 8;
    L6:
        r101.setVisibility(r104);
        View r105 = this.f212014l;
        if (r100 == false) goto L9;
        r102 = 0;
    L9:
        r105.setVisibility(r102);
        if (r100 == false) goto L28;
        SpaceEmptyState r106 = this.f212015m;
        FilterFieldOption r107 = this.f211973b;
        if (r107 == null) goto L14;
        OptionItem[] r108 = r107.getSelectFieldOptions();
    L16:
        if (r108 != null) goto L18;
    L22:
        r103 = true;
    L23:
        if (r103 == false) goto L25;
        int r109 = R.drawable.ccm_empty_neutral_no_content;
    L26:
        r106.setImageRes(Integer.valueOf(r109));
        return;
    L25:
        r109 = R.drawable.ccm_empty_neutral_search_failed;
        goto L26
    L18:
        if (r108.length != 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L23;
    L20:
        r110 = false;
        goto L21
    L14:
        r108 = null;
        goto L16
    L28:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public p(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        EFieldType r103 = null;
        View r104 = LayoutInflater.from(r100).inflate(R.layout.bitable_select_filter_value_view, null);
        this.f212011i = r104;
        EditText r105 = (EditText) r104.findViewById(R.id.search_et);
        RecyclerView r106 = (RecyclerView) r104.findViewById(R.id.recycler_view);
        this.f212012j = r106;
        SelectEditAdapter r107 = i();
        this.f212013k = r107;
        this.f212014l = r104.findViewById(R.id.empty_view);
        this.f212015m = (SpaceEmptyState) r104.findViewById(R.id.empty_state);
        if (r101 == null) goto L5;
        r103 = r101.getValueFieldType();
    L5:
        boolean r108 = false;
        if (r103 != EFieldType.SINGLE_SELECT) goto L8;
    L9:
        EFilterOperator.Companion.getClass();
        EFilterOperator r109 = EFilterOperator.a.a(r102);
        if (r109 != null) goto L13;
    L17:
        boolean r110 = false;
    L19:
        if (r110 == false) goto L21;
        r108 = true;
    L21:
        this.f212017o = r108;
        r107.f208066f = !r108;
        r107.f208067g = new a(this);
        r106.setHasFixedSize(true);
        r106.setLayoutManager(new LinearLayoutManager(r100));
        r106.setAdapter(r107);
        r105.addTextChangedListener(new c(this));
        return;
    L13:
        if (r109 != EFilterOperator.Is) goto L15;
    L18:
        r110 = true;
        goto L19
    L15:
        if (r109 != EFilterOperator.IsNot) goto L17;
    L8:
        if (r103 != EFieldType.STAGE) goto L21;
        goto L9
    }
}
