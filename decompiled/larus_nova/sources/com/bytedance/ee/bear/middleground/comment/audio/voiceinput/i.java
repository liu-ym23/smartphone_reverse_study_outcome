package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements UDToast.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f230429a;

    public i(Function0<Unit> r100) {
        this.f230429a = r100;
    }

    @Override // com.larksuite.component.universe_design.toast.UDToast.b
    public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toast");
        r100.cancel();
        this.f230429a.invoke();
    }
}
