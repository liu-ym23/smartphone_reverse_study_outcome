package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p extends a<String[]> {
    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List b(Object r110) {
        String[] r111 = (String[]) r110;
        this.f211852j = false;
        ArrayList r100 = new ArrayList();
        if (r111 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L14;
        ArrayList r102 = new ArrayList();
        int r103 = r111.length;
        int r104 = 0;
    L17:
        String r105 = null;
        OptionItem r106 = null;
        r106 = null;
        r106 = null;
        if (r104 >= r103) goto L36;
        String r107 = r111[r104];
        FilterFieldOption r108 = this.f211857o;
        if (r108 == null) goto L29;
        OptionItem[] r109 = r108.getSelectFieldOptions();
        if (r109 == null) goto L29;
        int r112 = r109.length;
        int r113 = 0;
    L24:
        if (r113 >= r112) goto L29;
        OptionItem r114 = r109[r113];
        if (TextUtils.equals(r114.getId(), r107) == true) goto L27;
        r113 = r113 + 1;
        goto L24
    L27:
        r106 = r114;
    L29:
        if (r106 == null) goto L33;
        String r115 = r106.getName();
        if (r115 == null) goto L34;
        r102.add(r115);
    L34:
        r104 = r104 + 1;
        goto L17
    L33:
        this.f211852j = true;
        goto L34
    L36:
        if ((!r102.isEmpty()) == false) goto L38;
        r105 = yu5.c.l(r102, ", ");
    L38:
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r105, this.f211848f, null, false, 12));
    L39:
        return r100;
    L14:
        if (m() == false) goto L39;
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
        goto L39
    L5:
        if (r111.length != 0) goto L7;
        boolean r116 = true;
    L8:
        if (r116 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r116 = false;
        goto L8
    }

    public p(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
