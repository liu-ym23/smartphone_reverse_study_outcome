package com.bytedance.ee.bear.share.newshare;

import android.view.KeyEvent;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ShareDocFragment a;
    public final /* synthetic */ Ref.BooleanRef b;

    public e(ShareDocFragment r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        ShareDocInfo r6 = (ShareDocInfo) r5;
        ShareDocFragment r0 = this.a;
        r0.G = r6;
        Intrinsics.checkNotNull(r6);
        boolean r1 = this.b.element;
        if (r0.cb0() == true) goto L22;
        DocPermSetInfo r7 = com.bytedance.ee.bear.share.externalshare.external.g.g(r6, r1, r0.oa0());
        KeyEvent.Callback r2 = r0.I;
        ej5.a r3 = null;
        if ((r2 instanceof ej5.a) == false) goto L8;
        ej5.a r4 = (ej5.a) r2;
    L9:
        if (r4 == null) goto L11;
        r4.setDocPermSetInfo(r7);
    L11:
        KeyEvent.Callback r8 = r0.J;
        if ((r8 instanceof ej5.a) == false) goto L14;
        ej5.a r9 = (ej5.a) r8;
    L15:
        if (r9 == null) goto L17;
        r9.setDocPermSetInfo(r7);
    L17:
        KeyEvent.Callback r10 = r0.K;
        if ((r10 instanceof ej5.a) == false) goto L20;
        r3 = (ej5.a) r10;
    L20:
        if (r3 == null) goto L22;
        r3.setDocPermSetInfo(r7);
        goto L22
    L14:
        r9 = null;
        goto L15
    L8:
        r4 = null;
    L22:
        ShareDocFragment.Sa0(this.a);
    }
}
