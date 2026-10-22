package com.obric.assistant.window;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricMsgComponent f394950a;

    public /* synthetic */ o(ObricMsgComponent r100) {
        this.f394950a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObricMsgComponent r100 = this.f394950a;
        int r101 = ObricMsgComponent.T;
        va8.c r102 = r100.p3();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b();
    }
}
