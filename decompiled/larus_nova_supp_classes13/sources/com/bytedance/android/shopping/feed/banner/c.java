package com.bytedance.android.shopping.feed.banner;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements WeakHandler.IHandler {
    public final WeakHandler a;
    public final long b;
    public final float c;
    public a d;
    public boolean e;
    public boolean f;
    public float g;
    public long h;

    public interface a {
        void a();

        void b(float r1, float r2);
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        if (this.a.hasMessages(1) == false) goto L6;
        this.a.removeMessages(1);
        return;
    }

    public c() {
        this.a = new WeakHandler(this);
        this.b = 20;
        this.c = (20 / 2000) * 100.0f;
    }

    public final void handleMsg(Message r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.what != 1) goto L34;
        Object r9 = r8.obj;
        if (r9 == null) goto L32;
        float r10 = ((Float) r9).floatValue();
        if (r10 >= 100.0f) goto L18;
        this.g = r10;
        long r2 = this.b;
        this.h = r2;
        float r4 = this.c;
        float r5 = r10 + r4;
        if (r5 < 100.0f) goto L14;
        this.h = (long) ((((100.0f - r10) * 1.0f) / r4) * r2);
        a r3 = this.d;
        if (r3 == null) goto L17;
        r3.b(r10, 100.0f);
    L17:
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = Float.valueOf(r10 + this.c);
        this.a.sendMessageDelayed(r0, this.h);
        return;
    L14:
        a r1 = this.d;
        if (r1 == null) goto L17;
        r1.b(r10, r5);
        goto L17
    L18:
        this.g = 0.0f;
        a();
        a r6 = this.d;
        if (r6 == null) goto L21;
        r6.b(100.0f, 100.0f);
    L21:
        a r7 = this.d;
        if (r7 == null) goto L24;
        r7.a();
        boolean r11 = false;
    L25:
        if (r11 == true) goto L27;
        return;
    L27:
        if (this.e == true) goto L29;
        return;
    L29:
        if (this.a.hasMessages(1) == true) goto L38;
        Message r12 = Message.obtain();
        r12.what = 1;
        r12.obj = Float.valueOf(0.0f);
        this.a.sendMessageDelayed(r12, this.b);
        return;
    L38:
        return;
    L24:
        r11 = true;
        goto L25
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
