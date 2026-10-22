package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class a {
    public final AtomicBoolean a;
    public InterfaceC0044a b;
    public final GestureDetector c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.custom_view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0044a {
        void b();
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return this.a.a.get();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r3, "e2");
            InterfaceC0044a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.b();
        L6:
            return super.onScroll(r2, r3, r4, r5);
        }
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = new AtomicBoolean(false);
        this.c = new GestureDetector(r3, new b(this));
    }
}
