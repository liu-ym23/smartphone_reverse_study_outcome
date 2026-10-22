package com.bytedance.android.shopping.buynow.slice.counter;

import android.widget.EditText;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements SlcKeyboardMonitor.c {
    public final EditText a;
    public final Function1<Integer, Unit> b;

    public final void b(int r1) {
    }

    public final void a() {
        Function1<Integer, Unit> r0 = this.b;
        Integer r1 = StringsKt.toIntOrNull(this.a.getText().toString());
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.invoke(Integer.valueOf(r2));
        return;
    L5:
        r2 = 1;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(EditText r2, Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "expandTextCounter");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }
}
