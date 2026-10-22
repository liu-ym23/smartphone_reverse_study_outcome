package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public g(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.office.list.adapter.p r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        tt5.a.e("OfficeAddShortcutAction", "prefetch wiki shortcut permission failed. actionId=" + this.a.a, (Throwable) r8, false);
        com.bytedance.ee.bear.more.office.b r9 = this.b;
        if (r9 == null) goto L10;
        com.bytedance.ee.bear.more.office.c r0 = this.a;
        String r1 = r0.a;
        OfficeLongPressLarkAction r2 = r0.b;
        String r3 = r0.c;
        b r5 = b.a;
        Context r4 = b.a(r0);
        if (r4 == null) goto L8;
        String r6 = r4.getString(2131887802);
        if (r6 == null) goto L8;
    L9:
        r9.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r6, null, 2));
    L8:
        r6 = com.bytedance.ee.bear.more.office.f.c();
    L10:
        b r10 = b.a;
        CompositeDisposable r11 = b.b.remove(this.a.a);
        if (r11 == null) goto L14;
        r11.clear();
        return;
    }
}
