package com.lynx.clay.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterDelegateView extends View implements s5a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f380486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterRenderer f380487b;

    @Override // s5a.c
    public final void b() {
        FlutterRenderer r100 = this.f380487b;
        if (r100 == null) goto L5;
        r100.b(false);
        this.f380487b = null;
        return;
    L5:
        c5a.c.d(5, "FlutterDelegateView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public final void pause() {
        if (this.f380487b == null) goto L5;
        this.f380487b = null;
        return;
    L5:
        c5a.c.d(5, "FlutterDelegateView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.f380487b;
    }

    public FlutterDelegateView(Context r100) {
        this(r100, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r100) {
        c5a.c.e();
        if (this.f380487b == null) goto L5;
        c5a.c.e();
        this.f380487b.b(false);
    L5:
        this.f380487b = r100;
        if (this.f380486a == true) goto L9;
        return;
    L9:
        throw null;
    }

    public FlutterDelegateView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f380486a = false;
    }
}
