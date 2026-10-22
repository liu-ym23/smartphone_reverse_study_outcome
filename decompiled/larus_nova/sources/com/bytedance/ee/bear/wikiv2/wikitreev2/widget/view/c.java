package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f242414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikItemLeafView f242415b;

        public a(b r100, WikItemLeafView r101) {
            this.f242414a = r100;
            this.f242415b = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f242414a.a(this.f242415b, r101);
            return false;
        }
    }

    public static final void a(b r100, WikItemLeafView r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "view");
        r102.setOnTouchListener(new a(r100, r101));
    }
}
