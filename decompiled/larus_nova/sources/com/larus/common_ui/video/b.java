package com.larus.common_ui.video;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f328027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f328029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f328030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.common_ui.video.a f328031f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        View r100 = this.f328030e;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeCallbacks(this.f328031f);
        View r101 = this.f328030e;
        if (r101 == null) goto L9;
        r101.postOnAnimation(this.f328031f);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.common_ui.video.a] */
    public b() {
        this.f328031f = new com.larus.common_ui.video.a(this);
    }
}
