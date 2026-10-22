package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f230663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.voiceinput.api.provider.a f230664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Job f230665c;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d
    public final void onDestroy() {
        if (this.f230663a == false) goto L5;
        return;
    L5:
        this.f230663a = true;
        Job.DefaultImpls.cancel$default(this.f230665c, null, 1, null);
        this.f230664b.onDestroy();
    }

    public r(com.ss.android.lark.voiceinput.api.provider.a r100, CompletableJob r101) {
        this.f230664b = r100;
        this.f230665c = r101;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d
    public final boolean f(View r100, MotionEvent r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        if (this.f230663a == false) goto L7;
        return false;
    L7:
        return this.f230664b.f(r100, r101, r102);
    }
}
