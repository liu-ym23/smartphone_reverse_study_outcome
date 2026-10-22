package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.u;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ o a;
    public final /* synthetic */ u b;

    public static final class a implements Runnable {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void a() {
            Context r0 = this.a.a.getContext();
            if (r0 == null) goto L11;
            Bundle r1 = new Bundle();
            r1.putInt("text_color", ContextCompat.getColor(this.a.a.getContext(), 2131101521));
            r1.putInt("bg_color", ContextCompat.getColor(this.a.a.getContext(), 2131101520));
            r1.putFloat("text_size", 13.0f);
            r1.putBoolean("need_arrow", true);
            r1.putString("bubble_text", this.a.b.c());
            r1.putInt("gravity", 80);
            r1.putLong("auto_dismiss_delay_millis", 3000);
            r1.putBoolean("is_middle", false);
            r1.putInt("x_offset", com.bytedance.android.shopping.extensions.b.b(-26) + (this.a.a.getMeasuredWidth() / 2));
            r1.putInt("y_offset", com.bytedance.android.shopping.extensions.b.b(4));
            r1.putFloat("arrow_offset", com.bytedance.android.shopping.extensions.b.b(12));
            Activity r2 = l0.b(r0);
            if (r2 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.i.a.c(r2, this.a.a, r1);
        L7:
            CartViewModel r3 = o.b(this.a.a);
            if (r3 == null) goto L12;
            CartViewModel.doEventAction$default(r3, "cart_list_toast_show", MapsKt.mapOf(TuplesKt.to("toast_word", this.a.b.c())), null, 4, null);
            return;
        L12:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public n(o r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;     // Catch: Throwable -> L4
        com.bytedance.android.shopping.new_cart.utils.a.c(o.b(this.a), "updateTip", new a(this), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
