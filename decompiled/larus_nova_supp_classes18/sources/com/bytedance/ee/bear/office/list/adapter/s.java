package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ OfficeLongPressActionContextFactory a;
    public final /* synthetic */ Document b;

    public s(OfficeLongPressActionContextFactory r1, Document r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        StringBuilder r0 = new StringBuilder("preload folder permission failed. token=");
        OfficeLongPressActionContextFactory r1 = this.a;
        Document r2 = this.b;
        r1.getClass();
        r0.append(OfficeLongPressActionContextFactory.f(r2));
        String r3 = r0.toString();
        tt5.a.e("OfficeLongPressActionContextFactory", r3, (Throwable) r4, false);
    }
}
