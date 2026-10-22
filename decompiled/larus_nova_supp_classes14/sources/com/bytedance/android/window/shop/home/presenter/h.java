package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ uq3.a b;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            e r10 = this.a.a;
            int r11 = r1.getHeight() + wg.a.c(r1)[1];
            List<com.bytedance.android.window.shop.repository.dto.a1> r12 = this.a.b.a;
            int r13 = 0;
            if (r12 == null) goto L25;
            Iterator<T> r14 = r12.iterator();
        L5:
            Object r15 = null;
            Integer r16 = null;
            r16 = null;
            if (r14.hasNext() == false) goto L20;
            Object r17 = r14.next();
            List<com.bytedance.android.window.shop.repository.dto.c> r18 = ((com.bytedance.android.window.shop.repository.dto.a1) r17).a();
            if (r18 == null) goto L12;
            com.bytedance.android.window.shop.repository.dto.c r19 = (com.bytedance.android.window.shop.repository.dto.c) CollectionsKt.firstOrNull(r18);
            if (r19 == null) goto L12;
            r16 = r19.c();
        L12:
            if (r16 != null) goto L15;
        L17:
            boolean r20 = false;
        L18:
            if (r20 == false) goto L5;
            r15 = r17;
            goto L20
        L15:
            if (r16.intValue() != 701) goto L17;
            r20 = true;
        L20:
            com.bytedance.android.window.shop.repository.dto.a1 r21 = (com.bytedance.android.window.shop.repository.dto.a1) r15;
            if (r21 == null) goto L25;
            com.bytedance.android.window.shop.repository.dto.b1 r22 = r21.b();
            if (r22 == null) goto L25;
            r13 = r22.a();
        L25:
            r10.p = r11 + r13;
            View r23 = this.a.a.o;
            if (r23 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L28:
            wg.a.d(r23, this.a.a.p);
        }
    }

    public h(e r1, uq3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.y().findViewById(2131371254);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.addOnLayoutChangeListener(new a(this));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
