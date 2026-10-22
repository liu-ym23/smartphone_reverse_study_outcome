package com.bytedance.ee.bear.list.office.longpress;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ g0.a d;
    public final /* synthetic */ DocMetaInfo e;
    public final /* synthetic */ oj5.a f;

    public j0(String r1, FragmentActivity r2, Fragment r3, g0.a r4, DocMetaInfo r5, oj5.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        boolean r0 = g0.a(g0.a, this.a, this.b, this.c);
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret on main. actionId=" + this.a + ", actionAlive=" + r0);
        if (r0 == false) goto L25;
        g0.k(this.a);
        FragmentActivity r4 = this.b;
        Fragment r11 = this.c;
        g0.a r1 = this.d;
        DocMetaInfo r7 = this.e;
        oj5.a r2 = this.f;
        Boolean r5 = null;
        if (com.bytedance.ee.util.ui.b.a(r4) == false) goto L20;
        if (r11 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L20;
        if (r7.isGetSecDetailFail() == false) goto L17;
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret failed because sec detail is failed.");
        Toast.showFailureText(r4, 2131887384);
    L24:
        g0.d(this.a);
        return;
    L17:
        if (r7.isVisibleSecList() == true) goto L19;
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret failed because sec list is invisible. type=" + r1.getType());
        goto L24
    L19:
        tt5.a.h("OfficeSecretSettingActionExecutor", "show secret fragment. type=" + r1.getType() + ", canModify=" + g0.b(r2, r1));
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).k6(r4, r1.a, r1.getType(), r7, r1.c, "from_docs_more_menu", g0.b(r2, r1), r11, true);
        goto L24
    L8:
        if (r11.isAdded() == true) goto L10;
        r3 = true;
    L20:
        StringBuilder r6 = new StringBuilder("show secret failed because page is inactive. type=");
        r6.append(r1.getType());
        r6.append(", activityActive=");
        r6.append(com.bytedance.ee.util.ui.b.a(r4));
        r6.append(", fragmentAdded=");
        if (r11 == null) goto L23;
        r5 = Boolean.valueOf(r11.isAdded());
    L23:
        r6.append(r5);
        tt5.a.h("OfficeSecretSettingActionExecutor", r6.toString());
        goto L24
    L25:
        tt5.a.h("OfficeSecretSettingActionExecutor", "skip show secret on main because action is not alive. actionId=" + this.a);
        g0.p(this.a);
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
