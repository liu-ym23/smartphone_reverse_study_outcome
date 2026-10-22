package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.ss.android.lark.api.bean.ForsetiViewMode;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListView f239017a;

    public l(BaseTemplateListView r100) {
        this.f239017a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!((ForsetiViewMode) r100).isCompact()) == true) goto L6;
        this.f239017a.D(2);
        return;
    }
}
