package com.bytedance.android.shopping.feed.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.android.ec.core.widget.ECStatusView;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Deprecated(message = "请使用ui-ec-widget中的ECLoadingDialog")
public final class b extends Dialog implements DialogInterface.OnKeyListener {
    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return true;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return true;
    }

    public b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 0);
        setContentView(2131560785);
        ECStatusView r0 = findViewById(2131379014);
        if (r0 == null) goto L5;
        r0.b(r3, null, null);
    L5:
        if (r0 == null) goto L8;
        r0.c();
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 != null) goto L5;
        return;
    L5:
        r4.setBackgroundDrawable(new ColorDrawable(0));
        r4.clearFlags(2);
        setCancelable(false);
        setOnKeyListener(this);
    }
}
