package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class a {
    public final AtomicBoolean a;
    public final GestureDetector b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.widgets.nest.a$a, reason: collision with other inner class name */
    public static final class C0134a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ a a;

        public C0134a(a r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return this.a.a.get();
        }
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = new AtomicBoolean(false);
        this.b = new GestureDetector(r3, new C0134a(this));
    }
}
