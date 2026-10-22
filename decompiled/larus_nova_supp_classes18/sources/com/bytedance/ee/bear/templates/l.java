package com.bytedance.ee.bear.templates;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends t {
    public final /* synthetic */ TemplateV4 c;
    public final /* synthetic */ TemplateViewHolder2 d;
    public final /* synthetic */ Function0<Unit> e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r11) {
        if (this.c.isCipherInvalid() == false) goto L6;
        UDToast.show(this.d.a.getContext(), 2131887111);
        return;
    L6:
        TemplateViewHolder2 r12 = this.d;
        final TemplateV4 r0 = this.c;
        Function0<Unit> r1 = this.e;
        int r2 = TemplateViewHolder2.j;
        r12.getClass();
        int r4 = r0.getObjType();
        String r5 = r0.getObjToken();
        String r6 = r0.getName();
        boolean r7 = Intrinsics.areEqual(r0.getCategoryId(), "5");
        if (r0.getSource() != 2) goto L9;
        int r8 = 4;
    L10:
        c r3 = new c(r4, r5, r6, r7, r8, 32);
        TemplateUtils r9 = TemplateUtils.a;
        Context r13 = r12.a.getContext();
        Function0<Unit> r10 = new TemplateViewHolder2$showCustomPanel$1(r0);
        Function0<Unit> r14 = new TemplateViewHolder2$showCustomPanel$2(r0);
        r9.getClass();
        TemplateUtils.n(r13, r3, r10, r14, r1);
        return;
    L9:
        r8 = 3;
        goto L10
    }

    public l(TemplateV4 r1, TemplateViewHolder2 r2, Function0<Unit> r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super(300);
    }
}
