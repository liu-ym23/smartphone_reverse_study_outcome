package com.ss.android.ugc.aweme.views;

import android.view.View;
import zgc.a;

/* JADX INFO: loaded from: classes40.dex */
public abstract class DebounceOnClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f454355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f454356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f454357c;

    public abstract void a();

    /* JADX WARN: Type inference failed for: r0v1, types: [zgc.a] */
    public DebounceOnClickListener(long r100) {
        this.f454356b = true;
        this.f454357c = new a(this);
        this.f454355a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f454356b == false) goto L6;
        this.f454356b = false;
        r100.postDelayed(this.f454357c, this.f454355a);
        a();
        return;
    }
}
