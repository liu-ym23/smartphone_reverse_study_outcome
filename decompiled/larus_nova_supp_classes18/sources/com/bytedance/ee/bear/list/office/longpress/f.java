package com.bytedance.ee.bear.list.office.longpress;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public f(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.office.list.adapter.p r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        WikNodePerm r8 = (WikNodePerm) r7;
        ConcurrentHashMap<String, CompositeDisposable> r0 = b.b;
        if (r0.containsKey(this.a.a) == false) goto L8;
        b.d.put(this.a.a, r8);
        com.bytedance.ee.bear.more.office.b r9 = this.b;
        if (r9 == null) goto L7;
        com.bytedance.ee.bear.more.office.c r1 = this.a;
        String r2 = r1.a;
        OfficeLongPressLarkAction r3 = r1.b;
        String r4 = r1.c;
        b r5 = b.a;
        r9.a(r2, r3, r4, b.d(r1, null));
    L7:
        tt5.a.h("OfficeAddShortcutAction", "prefetch wiki shortcut permission success. actionId=" + this.a.a);
    L8:
        CompositeDisposable r10 = r0.remove(this.a.a);
        if (r10 == null) goto L12;
        r10.clear();
        return;
    }
}
