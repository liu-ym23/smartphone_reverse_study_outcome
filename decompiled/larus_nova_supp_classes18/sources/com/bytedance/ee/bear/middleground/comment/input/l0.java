package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 implements ew4.d {
    public final /* synthetic */ bb5.b b;

    public final void onDetach() {
        this.b.onDetach();
    }

    public final void onPause() {
        this.b.onPause();
    }

    public final void onResume() {
        this.b.onResume();
    }

    public final void onStart() {
        this.b.onStart();
    }

    public final void onStop() {
        this.b.onStop();
    }

    public l0(bb5.b r1) {
        this.b = r1;
    }

    public final void a(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.b.a(r2);
    }

    public final void b(int r2) {
        this.b.b(r2);
    }
}
