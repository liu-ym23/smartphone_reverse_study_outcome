package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ WikItemLeafView b;

        public a(b r1, WikItemLeafView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            this.a.a(this.b, r3);
            return false;
        }
    }

    public static final void a(b r1, WikItemLeafView r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "view");
        r3.setOnTouchListener(new a(r1, r2));
    }
}
