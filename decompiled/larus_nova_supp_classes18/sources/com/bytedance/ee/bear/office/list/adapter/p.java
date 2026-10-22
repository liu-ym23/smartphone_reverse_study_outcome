package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements com.bytedance.ee.bear.more.office.b {
    public final /* synthetic */ Function0<v> a;
    public final /* synthetic */ OfficeLongPressActionContextFactory b;
    public final /* synthetic */ x c;

    public static final class a implements Runnable {
        public final /* synthetic */ x a;
        public final /* synthetic */ OfficeLongPressMenuAction b;
        public final /* synthetic */ z c;

        public a(x r1, OfficeLongPressMenuAction r2, z r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            x r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b, this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public p(Function0<v> r1, OfficeLongPressActionContextFactory r2, x r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.ee.bear.more.office.b
    public final void a(String r5, OfficeLongPressLarkAction r6, String r7, com.bytedance.ee.bear.more.office.a r8) {
        Intrinsics.checkNotNullParameter(r5, "actionId");
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r8, "availability");
        v r0 = (v) this.a.invoke();
        if (r0 != null) goto L5;
        return;
    L5:
        this.b.getClass();
        z r9 = OfficeLongPressActionContextFactory.g(r8);
        if (r0.d(r5, r6, r7, r9) == true) goto L9;
        StringBuilder r10 = new StringBuilder("drop async availability update. action=");
        r10.append(r6);
        r10.append(", actionId=");
        this.b.getClass();
        r10.append(du5.b.k(r5));
        r10.append(", result=");
        this.b.getClass();
        r10.append(OfficeLongPressActionContextFactory.d(r9));
        tt5.a.h("OfficeLongPressActionContextFactory", r10.toString());
        return;
    L9:
        StringBuilder r11 = new StringBuilder("accept async availability update. action=");
        r11.append(r6);
        r11.append(", actionId=");
        this.b.getClass();
        r11.append(du5.b.k(r5));
        r11.append(", result=");
        this.b.getClass();
        r11.append(OfficeLongPressActionContextFactory.d(r9));
        tt5.a.h("OfficeLongPressActionContextFactory", r11.toString());
        this.b.getClass();
        OfficeLongPressMenuAction r12 = OfficeLongPressActionContextFactory.h(r6);
        if (r12 != null) goto L12;
        return;
    L12:
        this.b.g.post(new a(this.c, r12, r9));
    }
}
