package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f230668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.voiceinput.api.provider.a f230669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View.OnTouchListener f230670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Job f230671d;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.o
    public final void onDestroy() {
        if (this.f230668a == false) goto L5;
        return;
    L5:
        this.f230668a = true;
        Job.DefaultImpls.cancel$default(this.f230671d, null, 1, null);
        this.f230669b.onDestroy();
    }

    public final void a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f230669b.A(r100, null);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.o
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        return this.f230670c.onTouch(r100, r101);
    }

    public u(com.ss.android.lark.voiceinput.api.provider.a r100, View.OnTouchListener r101, CompletableJob r102) {
        this.f230669b = r100;
        this.f230670c = r101;
        this.f230671d = r102;
    }
}
