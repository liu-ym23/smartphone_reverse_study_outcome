package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements d {
    public boolean a;
    public final /* synthetic */ com.ss.android.lark.voiceinput.api.provider.a b;
    public final /* synthetic */ Job c;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d
    public final void onDestroy() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        Job.DefaultImpls.cancel$default(this.c, null, 1, null);
        this.b.onDestroy();
    }

    public r(com.ss.android.lark.voiceinput.api.provider.a r1, CompletableJob r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d
    public final boolean f(View r2, MotionEvent r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, SendEventContainerMethodParamModel.EventKinds.onClick);
        if (this.a == false) goto L7;
        return false;
    L7:
        return this.b.f(r2, r3, r4);
    }
}
