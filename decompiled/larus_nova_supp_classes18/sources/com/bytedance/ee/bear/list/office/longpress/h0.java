package com.bytedance.ee.bear.list.office.longpress;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ g0.a d;
    public final /* synthetic */ oj5.a e;

    public h0(String r1, FragmentActivity r2, Fragment r3, g0.a r4, oj5.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r8) {
        DocMetaInfo r5 = (DocMetaInfo) r8;
        boolean r9 = g0.a(g0.a, this.a, this.b, this.c);
        tt5.a.h("OfficeSecretSettingActionExecutor", "fetch doc meta success. actionId=" + this.a + ", type=" + this.d.getType() + ", actionAlive=" + r9 + ", secDetailFail=" + r5.isGetSecDetailFail() + ", visibleSecList=" + r5.isVisibleSecList());
        if (r9 == false) goto L5;
        String r1 = this.a;
        FragmentActivity r2 = this.b;
        Fragment r3 = this.c;
        g0.a r4 = this.d;
        Intrinsics.checkNotNull(r5);
        com.bytedance.ee.util.ui.j.f(new j0(r1, r2, r3, r4, r5, this.e));
        return;
    L5:
        tt5.a.h("OfficeSecretSettingActionExecutor", "skip show secret because action is not alive after meta. actionId=" + this.a);
        g0.p(this.a);
    }
}
