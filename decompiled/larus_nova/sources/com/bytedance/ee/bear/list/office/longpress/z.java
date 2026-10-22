package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b f229095b;

    public z(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.more.office.b r101) {
        this.f229094a = r100;
        this.f229095b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = ((DocContainerInfo) r100).getNode_token();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L16:
        b0 r103 = b0.f228938a;
        String r104 = this.f229094a.f234687a;
        r103.getClass();
        CompositeDisposable r105 = b0.f228940c.remove(r104);
        if (r105 == null) goto L20;
        r105.clear();
        return;
    L20:
        return;
    L11:
        if (b0.f228940c.containsKey(this.f229094a.f234687a) == false) goto L16;
        com.bytedance.ee.bear.more.office.c r106 = this.f229094a;
        r106.f234692f.f227872c = r101;
        com.bytedance.ee.bear.more.office.b r107 = this.f229095b;
        if (r107 == null) goto L15;
        String r108 = r106.f234687a;
        OfficeLongPressLarkAction r109 = r106.f234688b;
        String r110 = r106.f234689c;
        b0.f228938a.getClass();
        r107.a(r108, r109, r110, b0.c(r106, null));
    L15:
        tt5.a.h("OfficeMoveToActionExecutor", "prefetch move nodeToken success. actionId=" + this.f229094a.f234687a);
        goto L16
    L8:
        r102 = false;
        goto L9
    }
}
