package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b f229043b;

    public l0(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.office.list.adapter.p r101) {
        this.f229042a = r100;
        this.f229043b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OfficeSecretSettingActionExecutor", "prefetch secret permission failed. actionId=" + this.f229042a.f234687a, (Throwable) r100, false);
        com.bytedance.ee.bear.more.office.b r101 = this.f229043b;
        if (r101 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r102 = this.f229042a;
        String r103 = r102.f234687a;
        OfficeLongPressLarkAction r104 = r102.f234688b;
        String r105 = r102.f234689c;
        g0.f228976a.getClass();
        Context r106 = g0.f(r102);
        if (r106 == null) goto L8;
        String r107 = r106.getString(R.string.Doc_Facade_OperateFailed);
        if (r107 == null) goto L8;
    L9:
        r101.a(r103, r104, r105, new com.bytedance.ee.bear.more.office.a.C3363a(r107, null, 2));
    L8:
        r107 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        g0 r108 = g0.f228976a;
        String r109 = this.f229042a.f234687a;
        r108.getClass();
        g0.e(r109);
    }
}
