package com.bytedance.android.shopping.yata.biz.popup;

import android.text.TextUtils;
import android.widget.FrameLayout;
import hl3.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PopupLayer implements e {
    public final AtomicBoolean a;
    public FrameLayout b;
    public e.a c;
    public b d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/PopupLayer$UnInitializeExceptions;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UnInitializeExceptions extends RuntimeException {
        public UnInitializeExceptions() {
            super("must call popup layer init first");
        }
    }

    @Override // hl3.b
    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
    }

    @Override // hl3.b
    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
    }

    @Override // hl3.b
    public final void c(hl3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
    }

    @Override // hl3.b
    public final void e(il3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final hl3.a k() {
        b r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L6:
        return r0.c();
    }

    public PopupLayer() {
        this.a = new AtomicBoolean(false);
    }

    @Override // hl3.b
    public final void d(a r4) {
        Intrinsics.checkNotNullParameter(r4, "card");
        FrameLayout r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        r0.removeView(r4.b());
        FrameLayout r5 = this.b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L9:
        if (r5.getChildCount() != 0) goto L23;
        e.a r6 = this.c;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L14:
        if (r6.getHost().findViewById(2131364258) == null) goto L24;
        e.a r7 = this.c;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L18:
        FrameLayout r8 = r7.getHost();
        FrameLayout r1 = this.b;
        if (r1 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L21:
        r8.removeView(r1);
        return;
    L24:
        return;
    }

    @Override // hl3.b
    public final void f(a r4) {
        Intrinsics.checkNotNullParameter(r4, "card");
        e.a r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L6:
        if (r0.getHost().findViewById(2131364258) != null) goto L14;
        e.a r1 = this.c;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L10:
        FrameLayout r2 = r1.getHost();
        FrameLayout r3 = this.b;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L13:
        r2.addView(r3);
    L14:
        FrameLayout r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L17:
        r5.addView(r4.b());
    }

    public final boolean h(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L11;
        Intrinsics.checkNotNull(r4);
        hl3.a r0 = i(r4);
        if (r0 == null) goto L8;
        r0.dismiss();
    L8:
        if (i(r4) == null) goto L24;
        return true;
    L24:
        return false;
    L11:
        b r5 = this.d;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L14:
        hl3.a r6 = r5.c();
        if (r6 == null) goto L17;
        r6.dismiss();
    L17:
        b r7 = this.d;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L21:
        if (r7.c() == null) goto L25;
        return true;
    L25:
        return false;
    }

    public final hl3.a i(String r6) {
        Intrinsics.checkNotNullParameter(r6, "id");
        b r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "id");
        Iterator<hl3.a> r0 = r1.a.iterator();
    L6:
        hl3.a r3 = null;
        if (r0.hasNext() == false) goto L11;
        hl3.a r2 = r0.next();
        if (Intrinsics.areEqual(r2.getId(), r6) == false) goto L6;
    L12:
        hl3.a r4 = r2;
        if (r4 != null) goto L28;
        Iterator<hl3.a> r5 = r1.b.iterator();
    L16:
        if (r5.hasNext() == false) goto L21;
        hl3.a r7 = r5.next();
        if (Intrinsics.areEqual(r7.getId(), r6) == false) goto L16;
        r3 = r7;
    L21:
        return r3;
    L28:
        return r4;
    L11:
        r2 = null;
        goto L12
    }

    public final void j(e.a r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.c = r4;
        FrameLayout r0 = new FrameLayout(r4.getContext());
        r0.setId(2131364258);
        r0.setTag(2131364259, "popup_container_tag." + r0.getId());
        r0.setLayoutParams(r4.getLayoutParams());
        Unit r5 = Unit.INSTANCE;
        this.b = r0;
        this.d = new b();
        return;
    }

    public final void g(il3.a r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        if (this.c == null) goto L13;
        e.a r2 = this.c;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L7:
        a r0 = new a(new WeakReference(r2.getContext()), r5);
        r0.g = r6;
        Intrinsics.checkNotNullParameter(this, "layer");
        r0.b = this;
        b r7 = this.d;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L10:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "card");
        r7.b.offer(r0);
        r7.b();
        return;
    L13:
        throw new UnInitializeExceptions();
    }
}
