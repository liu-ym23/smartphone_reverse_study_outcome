package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ AnchorV4FindSameView.d a;
    public final /* synthetic */ Bitmap b;

    public g(AnchorV4FindSameView.d r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Bitmap r0 = this.b;
        if (r0 == null) goto L30;
        ConstraintLayout r1 = this.a.a;
        Resources r3 = this.a.a.getContext().getResources();
        ConstraintLayout r4 = this.a.a;
        int r5 = com.bytedance.android.shopping.extensions.b.b(24);
        r4.getClass();
        Bitmap.Config r6 = r0.getConfig();
        if (r6 != null) goto L7;
        r6 = Bitmap.Config.ARGB_8888;
    L7:
        Bitmap r7 = r0.copy(r6, true);
        Context r8 = r4.getContext();
        int r9 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5));
        RenderScript r10 = RenderScript.create(r8);     // Catch: Exception -> L21
        Bitmap r11 = Bitmap.createBitmap(r0);     // Catch: Exception -> L21
        Allocation r12 = Allocation.createFromBitmap(r10, r11, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Exception -> L21
        Allocation r13 = Allocation.createTyped(r10, r12.getType());     // Catch: Exception -> L21
        ScriptIntrinsicBlur r14 = ScriptIntrinsicBlur.create(r10, Element.U8_4(r10));     // Catch: Exception -> L21
    L9:
        if (r9 <= 0) goto L19;
        int r15 = r9 - 10;     // Catch: Exception -> L21
        if (r15 <= 0) goto L13;
        float r16 = 10.0f;
    L14:
        r14.setRadius(r16);     // Catch: Exception -> L21
        r14.setInput(r12);     // Catch: Exception -> L21
        r14.forEach(r13);     // Catch: Exception -> L21
        if (r15 > 0) goto L17;
        r13.copyTo(r7);     // Catch: Exception -> L21
    L18:
        r9 = r15;
        goto L9
    L17:
        r12.copyFrom(r13);     // Catch: Exception -> L21
        goto L18
    L13:
        r16 = r9;
        goto L14
    L19:
        r11.recycle();     // Catch: Exception -> L21
    L23:
        r0.recycle();
        r1.setBackground(new BitmapDrawable(r3, r7));
        return;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
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
