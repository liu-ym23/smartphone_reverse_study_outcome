package com.bytedance.ee.bear.share.newshare;

import android.view.KeyEvent;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ ShareDocFragment a;
    public final /* synthetic */ Ref.BooleanRef b;

    public g(ShareDocFragment r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        IDocPublicPermission r5 = (IDocPublicPermission) r4;
        ShareDocFragment r0 = this.a;
        r0.H = r5;
        this.b.element = true;
        KeyEvent.Callback r1 = r0.I;
        ej5.a r2 = null;
        if ((r1 instanceof ej5.a) == false) goto L5;
        ej5.a r3 = (ej5.a) r1;
    L6:
        if (r3 == null) goto L8;
        Intrinsics.checkNotNull(r5);
        r3.setPublicPermission(r5);
    L8:
        KeyEvent.Callback r6 = this.a.J;
        if ((r6 instanceof ej5.a) == false) goto L11;
        ej5.a r7 = (ej5.a) r6;
    L12:
        if (r7 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        r7.setPublicPermission(r5);
    L14:
        KeyEvent.Callback r8 = this.a.K;
        if ((r8 instanceof ej5.a) == false) goto L17;
        r2 = (ej5.a) r8;
    L17:
        if (r2 == null) goto L19;
        Intrinsics.checkNotNull(r5);
        r2.setPublicPermission(r5);
    L19:
        ShareDocFragment.Sa0(this.a);
        return;
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
