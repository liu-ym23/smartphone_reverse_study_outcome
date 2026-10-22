package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j<D extends IChatterEntity> extends com.bytedance.ee.bear.bitable.filter.condition.a<D[]> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List b(Object r110) {
        IChatterEntity[] r111 = (IChatterEntity[]) r110;
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        if (r111 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        ArrayList r103 = new ArrayList();
        int r104 = r111.length;
    L17:
        String r105 = null;
        if (r101 >= r104) goto L24;
        String r106 = r111[r101].getLocalName(null);
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        r103.add(r106);
        r101 = r101 + 1;
        goto L17
    L24:
        if ((!r103.isEmpty()) == false) goto L26;
        r105 = yu5.c.l(r103, ", ");
    L26:
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r105, this.f211848f, null, false, 12));
    L27:
        return r100;
    L14:
        if (m() == false) goto L27;
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
        goto L27
    L5:
        if (r111.length != 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r107 = false;
        goto L8
    }

    public j(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
