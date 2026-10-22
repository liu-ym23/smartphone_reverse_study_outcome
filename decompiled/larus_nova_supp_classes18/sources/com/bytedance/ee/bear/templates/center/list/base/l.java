package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.ss.android.lark.api.bean.ForsetiViewMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ BaseTemplateListView a;

    public l(BaseTemplateListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!((ForsetiViewMode) r2).isCompact()) == true) goto L6;
        this.a.D(2);
        return;
    }
}
