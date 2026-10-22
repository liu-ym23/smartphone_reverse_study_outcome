package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements o {
    public boolean a;
    public final /* synthetic */ com.ss.android.lark.voiceinput.api.provider.a b;
    public final /* synthetic */ View.OnTouchListener c;
    public final /* synthetic */ Job d;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.o
    public final void onDestroy() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        Job.DefaultImpls.cancel$default(this.d, null, 1, null);
        this.b.onDestroy();
    }

    public final void a(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        this.b.A(r3, null);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.o
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.c.onTouch(r2, r3);
    }

    public u(com.ss.android.lark.voiceinput.api.provider.a r1, View.OnTouchListener r2, CompletableJob r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
