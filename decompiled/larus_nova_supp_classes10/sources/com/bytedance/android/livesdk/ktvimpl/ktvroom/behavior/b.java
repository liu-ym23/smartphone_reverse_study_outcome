package com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements c0.b {
    public Disposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            View r5 = this.a;
            KtvContext.Companion.getClass();
            int r0 = 8;
            if (KtvContext.a.c(8) == false) goto L5;
        L6:
            r0 = 0;
        L7:
            r5.setVisibility(r0);
            return;
        L5:
            if (KtvContext.a.c(32) == false) goto L7;
            goto L6
        }
    }

    public b() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r8) {
        pb0.a.a.b(KtvLoggerHelper.d, "interaction_panel", null, null, null, null, 30);
        KtvContext.Companion.getClass();
        KtvContext r9 = KtvContext.a.g();
        if (r9 == null) goto L8;
        k<od2.b> r10 = r9.getOpenKtvRoomDialogEvent();
        if (r10 == null) goto L9;
        r10.post(new od2.b("interact", false, null));
        return;
    L9:
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Disposable r4 = this.a;
        if (r4 == null) goto L6;
        r4.dispose();
        return;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Disposable r4 = this.a;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        KtvContext.Companion.getClass();
        KtvContext r5 = KtvContext.a.g();
        if (r5 == null) goto L12;
        m<Integer> r6 = r5.getKtvAllState();
        if (r6 == null) goto L12;
        Observable r7 = r6.a();
        if (r7 == null) goto L12;
        Disposable r8 = r7.subscribe(new a(r2));
    L13:
        this.a = r8;
        return;
    L12:
        r8 = null;
        goto L13
    }
}
