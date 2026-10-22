package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ForwardTarget c;
    public final /* synthetic */ i d;

    public static final class a implements UDToast.b {
        public final /* synthetic */ ForwardTarget a;
        public final /* synthetic */ i b;
        public final /* synthetic */ Context c;

        public final void a(com.ss.android.lark.compose.foundation.toast.b r4) {
            Intrinsics.checkNotNullParameter(r4, "toast");
            int r5 = this.a.b();
            if (r5 != 0) goto L5;
        L10:
            i r6 = this.b;
            int r0 = i.b;
            r6.getClass();
            i.b().n(this.c, this.a.a);
        L11:
            t35.a r7 = this.b.a;
            if (r7 == null) goto L15;
            HashMap r1 = new HashMap();
            r1.put("click", "jump_to_chat");
            r1.put("target", "none");
            r1.put("sub_view", "share_to_chat_success");
            r7.a("ccm_docs_toast_click", r1);
            return;
        L15:
            return;
        L5:
            if (r5 == 1) goto L10;
            if (r5 == 2) goto L9;
            tt5.a.d("ShareWordsForwardComponent", "action clicked with unknown target type: " + this.a.b());
            goto L11
        L9:
            i r8 = this.b;
            int r2 = i.b;
            r8.getClass();
            i.b().m7(this.c, this.a.a);
            goto L11
        }

        public a(ForwardTarget r1, i r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public j(Context r1, int r2, ForwardTarget r3, i r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        String r0 = this.a.getString(2131889077);
        int r1 = this.b;
        if (r1 > 0) goto L6;
        tt5.a.h("ShareWordsForwardComponent", "send to im onError: sendChatIds size 0");
        return;
    L6:
        if (r1 == 1) goto L8;
    L12:
        UDToast.show(this.a, r0);
        return;
    L8:
        if (this.c == null) goto L12;
        String r2 = this.a.getString(2131889082);
        UDToast.a r3 = UDToast.build(this.a);
        r3.g(r0);
        r3.c(r2, new a(this.c, this.d, this.a));
        r3.h();
        t35.a r4 = this.d.a;
        if (r4 == null) goto L15;
        HashMap r5 = new HashMap();
        r5.put("sub_view", "share_to_chat_success");
        r4.a("ccm_docs_toast_view", r5);
        return;
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
