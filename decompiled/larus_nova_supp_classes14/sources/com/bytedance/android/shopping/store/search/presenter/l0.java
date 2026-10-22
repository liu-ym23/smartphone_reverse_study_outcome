package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0<T> implements Observer {
    public final /* synthetic */ StoreSearchSugListPresenter a;

    public l0(StoreSearchSugListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        List r7 = (List) r6;
        int r0 = r7.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        if (((ArrayList) this.a.E().getSugRequestParam().e).size() >= 3) goto L17;
        List r1 = this.a.E().getSugRequestParam().e;
        JSONObject r2 = new JSONObject();
        r2.put("query", String.valueOf(((sj3.h) ListProtector.get(r7, r0)).d));
        Date r3 = ((sj3.h) ListProtector.get(r7, r0)).e;
        if (r3 == null) goto L10;
        Long r4 = Long.valueOf(r3.getTime());
    L11:
        r2.put("time", String.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        ((ArrayList) r1).add(r2);
        goto L3
    L10:
        r4 = null;
        goto L11
    L17:
        return;
    }
}
