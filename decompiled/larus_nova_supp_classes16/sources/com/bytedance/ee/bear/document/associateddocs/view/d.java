package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements com.bytedance.ee.bear.document.associateddocs.a.e {
    public final /* synthetic */ AssociatedActionSheetPanel a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AssociatedDocViewModel r0 = AssociatedActionSheetPanel.a.get(this.a);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.refreshQuickLaunchBarItemInfo(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.document.associateddocs.a.e
    public final void a(int r5, String r6) {
        if (r5 == 0) goto L4;
    L8:
        AssociatedActionSheetPanel r7 = this.a;
        Context r8 = this.b;
        r7.getClass();
        com.bytedance.ee.util.ui.j.f(new i(r8));
        return;
    L4:
        if (TextUtils.isEmpty(r6) == true) goto L8;
        AssociatedActionSheetPanel r9 = this.a;
        Context r0 = this.b;
        r9.getClass();
        com.bytedance.ee.util.ui.j.f(new h(r0));
        if (r6 == null) goto L10;
        AssociatedActionSheetPanel r10 = this.a;
        Context r1 = this.b;
        String r2 = this.c;
        com.bytedance.ee.util.ui.j.f(new a(r1, r6));
        r10.getClass();
        AssociatedActionSheetPanel.c(r1, r6, r2);
        AssociatedActionSheetPanel.d(r1, new l(r6, "success_create_docs", "none", "add_docs"));
        return;
    }

    public d(AssociatedActionSheetPanel r1, Context r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
