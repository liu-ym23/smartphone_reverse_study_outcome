package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yj.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartYataLogImpl {
    public final Lazy a;
    public final Lazy b;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public a(h r1, int r2, String r3, Function0 r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.log(this.b, (String) this.c.invoke());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public CartYataLogImpl() {
        this.a = LazyKt.lazy(CartYataLogImpl$hostALogService$2.INSTANCE);
        this.b = LazyKt.lazy(CartYataLogImpl$isDebugOrLocalTest$2.INSTANCE);
    }

    public final void a(int r3, String r4, Function0<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        h r0 = (h) this.a.getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        com.bytedance.android.ec.hybrid.card.util.a.a(new a(r0, r3, r4, r5));
    }
}
