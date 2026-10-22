package com.bytedance.android.shopping.new_cart.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import v96.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements g {
    public final Context a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public b(c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECToast.showToast$default(ECToast.INSTANCE, this.a.a, this.b, null, 4, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new b(this, r2));
    }
}
