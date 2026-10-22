package com.bytedance.ee.bear.list.office.longpress;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements SpaceEditText.a {
    public final /* synthetic */ oj5.c a;
    public final /* synthetic */ FragmentActivity b;

    public d0(oj5.c r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText.a
    public final boolean a(int r9) {
        switch(r9) {
            case 16908320: goto L4;
            case 16908321: goto L4;
            default: goto L28;
        };
    L4:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L26;
        com.bytedance.ee.bear.more.b r2 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        String r3 = this.a.getToken();
        oj5.c r4 = this.a;
        BizDomain r5 = BizDomain.FileBizDomainCCM;
        c0 r10 = c0.a;
        if ((r4 instanceof oj5.a) == false) goto L13;
        oj5.a r11 = (oj5.a) r4;
        if (r11.p == false) goto L11;
        Object r12 = r11.s;
    L19:
        PermissionResponse r13 = r2.t(r3, r4, r5, "CONTENT_COPY", r12);
        ph5.e r6 = r13.getCallback();
        FragmentActivity r7 = this.b;
        Intrinsics.checkNotNull(r13);
        r6.a(r7, r13);
        if (r13.getAllow() == true) goto L25;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r13) == true) goto L25;
        Toast.showFailureText(this.b, 2131887613);
    L25:
        return !r13.getAllow();
    L11:
        r12 = r11.i.a;
        goto L19
    L13:
        if ((r4 instanceof oj5.b) == false) goto L18;
        oj5.b r14 = (oj5.b) r4;
        if (r14.q == false) goto L17;
        r12 = r14.u;
        goto L19
    L17:
        r12 = r14.t;
        goto L19
    L18:
        r12 = r4.c().a;
        goto L19
    L26:
        return false;
    L28:
        return false;
    }
}
