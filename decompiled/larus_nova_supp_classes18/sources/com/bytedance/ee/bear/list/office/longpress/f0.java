package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.b b;

    public f0(com.bytedance.ee.bear.more.office.c r1, com.bytedance.ee.bear.more.office.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        tt5.a.e("OfficeRenameActionExecutor", "prefetch rename permission failed. actionId=" + this.a.a, (Throwable) r7, false);
        com.bytedance.ee.bear.more.office.b r8 = this.b;
        if (r8 == null) goto L16;
        com.bytedance.ee.bear.more.office.c r0 = this.a;
        String r1 = r0.a;
        OfficeLongPressLarkAction r2 = r0.b;
        String r3 = r0.c;
        c0 r5 = c0.a;
        Context r6 = r0.getActivity();
        if (r6 != null) goto L11;
        Fragment r4 = r0.e;
        if (r4 == null) goto L10;
        r6 = r4.getContext();
        goto L11
    L10:
        r6 = null;
    L11:
        if (r6 == null) goto L14;
        String r9 = r6.getString(2131887802);
        if (r9 == null) goto L14;
    L15:
        r8.a(r1, r2, r3, new com.bytedance.ee.bear.more.office.a.C0116a(r9, OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY));
    L14:
        r9 = com.bytedance.ee.bear.more.office.f.a();
    L16:
        c0 r10 = c0.a;
        CompositeDisposable r11 = c0.e.remove(this.a.a);
        if (r11 == null) goto L20;
        r11.clear();
        return;
    }
}
