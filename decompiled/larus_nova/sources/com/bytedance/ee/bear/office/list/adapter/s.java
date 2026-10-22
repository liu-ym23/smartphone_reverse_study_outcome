package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeLongPressActionContextFactory f235857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Document f235858b;

    public s(OfficeLongPressActionContextFactory r100, Document r101) {
        this.f235857a = r100;
        this.f235858b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        StringBuilder r101 = new StringBuilder("preload folder permission failed. token=");
        OfficeLongPressActionContextFactory r102 = this.f235857a;
        Document r103 = this.f235858b;
        r102.getClass();
        r101.append(OfficeLongPressActionContextFactory.f(r103));
        String r104 = r101.toString();
        tt5.a.e("OfficeLongPressActionContextFactory", r104, (Throwable) r100, false);
    }
}
