package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w0<T> implements Observer {
    public final /* synthetic */ ECWindowFloatLayerPresenter a;

    public w0(ECWindowFloatLayerPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Integer r7 = (Integer) r6;
        if (this.a.O().getShopParam().isCroppedStyle() == false) goto L9;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.intValue() == 2) goto L9;
        return;
    L9:
        ECWindowFloatLayerPresenter r8 = this.a;
        monitor-enter(r8);
    L21:
        th = move-exception;
        throw th;
    L12:
        if (r8.m == false) goto L14;
    L19:
        monitor-exit(r8);
        return;
    L14:
        if (r8.T() == false) goto L19;
        r8.m = true;     // Catch: Throwable -> L21
        Ref.BooleanRef r1 = new Ref.BooleanRef();     // Catch: Throwable -> L21
        r1.element = false;     // Catch: Throwable -> L21
        r8.O().getComponentResponse().a(r8.U(), new y0(r8, r1), true);     // Catch: Throwable -> L21
        monitor-exit(r8);
    }
}
