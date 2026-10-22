package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l0 implements ew4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bb5.b f231974b;

    @Override // ew4.d
    public final void onDetach() {
        this.f231974b.onDetach();
    }

    @Override // ew4.d
    public final void onPause() {
        this.f231974b.onPause();
    }

    @Override // ew4.d
    public final void onResume() {
        this.f231974b.onResume();
    }

    @Override // ew4.d
    public final void onStart() {
        this.f231974b.onStart();
    }

    @Override // ew4.d
    public final void onStop() {
        this.f231974b.onStop();
    }

    public l0(bb5.b r100) {
        this.f231974b = r100;
    }

    @Override // ew4.d
    public final void a(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f231974b.a(r100);
    }

    @Override // ew4.d
    public final void b(int r100) {
        this.f231974b.b(r100);
    }
}
