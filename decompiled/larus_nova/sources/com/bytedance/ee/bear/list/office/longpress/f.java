package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f228970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b f228971b;

    public f(com.bytedance.ee.bear.more.office.c r100, com.bytedance.ee.bear.office.list.adapter.p r101) {
        this.f228970a = r100;
        this.f228971b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WikNodePerm r101 = (WikNodePerm) r100;
        ConcurrentHashMap<String, CompositeDisposable> r102 = b.f228927b;
        if (r102.containsKey(this.f228970a.f234687a) == false) goto L8;
        b.f228929d.put(this.f228970a.f234687a, r101);
        com.bytedance.ee.bear.more.office.b r103 = this.f228971b;
        if (r103 == null) goto L7;
        com.bytedance.ee.bear.more.office.c r104 = this.f228970a;
        String r105 = r104.f234687a;
        OfficeLongPressLarkAction r106 = r104.f234688b;
        String r107 = r104.f234689c;
        b r108 = b.f228926a;
        r103.a(r105, r106, r107, b.d(r104, null));
    L7:
        tt5.a.h("OfficeAddShortcutAction", "prefetch wiki shortcut permission success. actionId=" + this.f228970a.f234687a);
    L8:
        CompositeDisposable r109 = r102.remove(this.f228970a.f234687a);
        if (r109 == null) goto L12;
        r109.clear();
        return;
    }
}
