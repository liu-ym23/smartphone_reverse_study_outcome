package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b f229065b;

    public p(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.office.list.adapter.p r101) {
        this.f229064a = r100;
        this.f229065b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OfficeExportAsActionExecutor", "prefetch export permission failed. actionId=" + this.f229064a.f234687a, (Throwable) r100, false);
        com.bytedance.ee.bear.more.office.b r101 = this.f229065b;
        if (r101 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r102 = this.f229064a;
        String r103 = r102.f234687a;
        OfficeLongPressLarkAction r104 = r102.f234688b;
        String r105 = r102.f234689c;
        m r106 = m.f229044a;
        Context r107 = m.b(r102);
        if (r107 == null) goto L8;
        String r108 = r107.getString(R.string.Doc_Facade_OperateFailed);
        if (r108 == null) goto L8;
    L9:
        r101.a(r103, r104, r105, new com.bytedance.ee.bear.more.office.a.C3363a(r108, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L8:
        r108 = com.bytedance.ee.bear.more.office.f.a();
    L10:
        m r109 = m.f229044a;
        CompositeDisposable r110 = m.f229046c.remove(this.f229064a.f234687a);
        if (r110 == null) goto L14;
        r110.clear();
        return;
    }
}
