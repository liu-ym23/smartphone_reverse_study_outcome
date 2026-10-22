package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SidebarListInfo;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class r implements Function {
    public /* synthetic */ r() {
    }

    public final Object apply(Object r1) {
        return (SidebarListInfo) ((Result) r1).getData();
    }
}
