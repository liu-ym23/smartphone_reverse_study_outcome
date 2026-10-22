package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r8, Context r9, f r10, Object r11, il2.a r12, e r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            Object r5 = null;
        L7:
            if ((r14 & 8) == 0) goto L9;
            il2.a r6 = null;
        L11:
            if ((r14 & 16) == 0) goto L13;
            e r7 = null;
        L14:
            r8.d(r9, r10, r5, r6, r7);
            return;
        L13:
            r7 = r13;
            goto L14
        L9:
            r6 = r12;
            goto L11
        L5:
            r5 = r11;
            goto L7
        }
    }

    <T> void a(Context r1, f<T> r2, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r3);

    void b(String r1, d<?> r2);

    void c();

    <T> void d(Context r1, f<T> r2, Object r3, il2.a r4, e r5);

    h e();

    <T extends d<?>> T get(String r1);
}
