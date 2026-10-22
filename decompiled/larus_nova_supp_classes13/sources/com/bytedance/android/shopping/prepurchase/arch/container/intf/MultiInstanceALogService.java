package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import android.util.Log;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MultiInstanceALogService implements xi.b {
    public static final Lazy c = null;
    public final Lazy a;
    public final Biz b;

    public static final class a {
        public static final n83.e a() {
            Lazy r0 = MultiInstanceALogService.c;
            return (n83.e) MultiInstanceALogService.c.getValue();
        }

        public a() {
        }
    }

    static {
        new a();
        c = LazyKt.lazy(MultiInstanceALogService$Companion$alogInstance$2.INSTANCE);
    }

    public MultiInstanceALogService(Biz r2) {
        Intrinsics.checkNotNullParameter(r2, "bizCode");
        this.b = r2;
        this.a = LazyKt.lazy(MultiInstanceALogService$enableDToI$2.INSTANCE);
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L5;
        i(r2, r3);
        return;
    L5:
        n83.e r4 = a.a();
        if (r4 == null) goto L10;
        this.b.getValue();
        r4.d();
        return;
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        n83.e r4 = a.a();
        if (r4 == null) goto L6;
        this.b.getValue();
        r4.i();
        return;
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (r4 == null) goto L11;
        if (r3 != null) goto L8;
        n83.e r5 = a.a();
        if (r5 == null) goto L15;
        this.b.getValue();
        Log.getStackTraceString(r4);
        r5.e();
        return;
    L15:
        return;
    L8:
        n83.e r6 = a.a();
        if (r6 == null) goto L17;
        this.b.getValue();
        Log.getStackTraceString(r4);
        r6.e();
        return;
    L17:
        return;
    L11:
        n83.e r7 = a.a();
        if (r7 == null) goto L19;
        this.b.getValue();
        r7.e();
        return;
    }
}
