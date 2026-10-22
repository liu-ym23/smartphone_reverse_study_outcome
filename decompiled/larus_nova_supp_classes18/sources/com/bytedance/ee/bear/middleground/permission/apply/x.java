package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ AuditControlApplyFragment c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AuditControlApplyFragment a;

        public a(AuditControlApplyFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            DefaultResponse r4 = (DefaultResponse) r3;
            this.a.U90().setText("");
            Toast.showSuccessText(this.a.getContext(), this.a.getString(2131887829), 0);
            AuditControlApplyFragment r5 = this.a;
            r5.getClass();
            com.bytedance.ee.util.ui.j.f(new z(r5, false));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AuditControlApplyFragment a;

        public b(AuditControlApplyFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            tt5.a.e("AuditControlApplyFragment", "request perm fail. ", r6, false);
            AuditControlApplyFragment r0 = this.a;
            int r1 = AuditControlApplyFragment.p;
            r0.getClass();
            com.bytedance.ee.util.ui.j.f(new z(r0, false));
            Context r2 = this.a.getContext();
            if (r2 != null) goto L5;
            r2 = eu5.b.a;
        L5:
            Intrinsics.checkNotNull(r2);
            Intrinsics.checkNotNull(r6);
            ui5.a.b(r2, r6, this.a.W90().getOwnerName(), this.a.W90().getToken(), this.a.W90().getDocumentType());
        }
    }

    public x(AuditControlApplyFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r12) {
        rcb.c.d(this.c.getView());
        String r9 = String.valueOf(this.c.U90().getText());
        AuditControlApplyFragment r13 = this.c;
        r13.getClass();
        com.bytedance.ee.util.ui.j.f(new z(r13, true));
        Integer r14 = StringsKt.toIntOrNull(this.c.W90().getDocumentType());
        if (r14 == null) goto L5;
        int r15 = r14.intValue();
    L6:
        NetService r0 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        AuditControlApplyFragment r2 = this.c;
        com.bytedance.ee.bear.middleground.permission.apply.a r3 = r2.n;
        String r4 = r2.W90().getToken();
        r3.getClass();
        Flowable r16 = com.bytedance.ee.bear.middleground.permission.apply.a.b(r4, r15, r9, 1, r0).observeOn(fo5.d.e()).subscribeOn(fo5.d.d());
        AuditControlApplyFragment r1 = this.c;
        Disposable r17 = r16.subscribe(new a(r1), new b(r1));
        com.bytedance.ee.bear.middleground.permission.c.i(this.c.W90().getToken(), sbb.e.g(this.c.W90().getDocumentType()), this.c.W90().getSubType(), this.c.W90().getFromVc(), this.c.W90().isWiki(), this.c.W90().getModule(), this.c.W90().getUserPerm(), this.c.W90().getPublicPerm(), 1, r9, "admin_forbidden");
        this.c.k.add(r17);
        return;
    L5:
        r15 = -1;
        goto L6
    }
}
