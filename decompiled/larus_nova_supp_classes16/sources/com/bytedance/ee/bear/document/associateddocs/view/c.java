package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import com.bytedance.ee.bear.document.associateddocs.AssociatedDocViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.document.associateddocs.a.e {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Ref.ObjectRef<String> b;
    public final /* synthetic */ AssociatedActionSheetPanel c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Ref.ObjectRef<String> c;
        public final /* synthetic */ AssociatedActionSheetPanel d;
        public final /* synthetic */ String e;

        public a(int r1, Context r2, Ref.ObjectRef<String> r3, AssociatedActionSheetPanel r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            if (this.a != 0) goto L13;
            HashMap<Context, AssociatedDocViewModel> r0 = AssociatedActionSheetPanel.a;
            AssociatedDocViewModel r2 = r0.get(this.b);
            if (r2 == null) goto L9;
            SingleLiveEvent<SearchBaseInfo> r3 = r2.getAssociatedDoc();
            if (r3 == null) goto L9;
            r3.setValue(null);
        L9:
            AssociatedDocViewModel r1 = r0.get(this.b);
            if (r1 == null) goto L12;
            r1.refreshQuickLaunchBarItemInfo((String) this.c.element);
        L12:
            AssociatedActionSheetPanel r4 = this.d;
            Context r5 = this.b;
            r4.getClass();
            com.bytedance.ee.util.ui.j.f(new h(r5));
            AssociatedActionSheetPanel r6 = this.d;
            Context r7 = this.b;
            String r8 = (String) this.c.element;
            String r9 = this.e;
            r6.getClass();
            AssociatedActionSheetPanel.c(r7, r8, r9);
            AssociatedActionSheetPanel r10 = this.d;
            Context r11 = this.b;
            l r12 = new l((String) this.c.element, "success_relation_docs", "none", "add_docs");
            r10.getClass();
            AssociatedActionSheetPanel.d(r11, r12);
        L14:
            AssociatedDocViewModel r13 = AssociatedActionSheetPanel.a.get(this.b);
            if (r13 == null) goto L20;
            SingleLiveEvent<SearchBaseInfo> r14 = r13.getAssociatedDoc();
            if (r14 == null) goto L21;
            r14.setValue(null);
            return;
        L21:
            return;
        L20:
            return;
        L13:
            AssociatedActionSheetPanel r16 = this.d;
            Context r17 = this.b;
            HashMap<Context, AssociatedDocViewModel> r18 = AssociatedActionSheetPanel.a;
            r16.getClass();
            Toast.showFailureText(r17, r17.getText(2131888949).toString(), 1);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.document.associateddocs.a.e
    public final void a(int r7, String r8) {
        com.bytedance.ee.util.ui.j.f(new a(r7, this.a, this.b, this.c, this.d));
    }

    public c(Context r1, Ref.ObjectRef<String> r2, AssociatedActionSheetPanel r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
