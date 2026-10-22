package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f228924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b f228925b;

    public a0(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.more.office.b r101) {
        this.f228924a = r100;
        this.f228925b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OfficeMoveToActionExecutor", "prefetch move nodeToken failed. actionId=" + this.f228924a.f234687a, (Throwable) r100, false);
        com.bytedance.ee.bear.more.office.b r101 = this.f228925b;
        if (r101 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r102 = this.f228924a;
        String r103 = r102.f234687a;
        OfficeLongPressLarkAction r104 = r102.f234688b;
        String r105 = r102.f234689c;
        b0.f228938a.getClass();
        Context r106 = b0.a(r102);
        if (r106 == null) goto L8;
        String r107 = r106.getString(R.string.Doc_Facade_OperateFailed);
        if (r107 == null) goto L8;
    L9:
        r101.a(r103, r104, r105, new com.bytedance.ee.bear.more.office.a.C3363a(r107, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L8:
        r107 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        b0 r108 = b0.f228938a;
        String r109 = this.f228924a.f234687a;
        r108.getClass();
        CompositeDisposable r110 = b0.f228940c.remove(r109);
        if (r110 == null) goto L14;
        r110.clear();
        return;
    }
}
