package com.larus.asr;

import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class u0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f288090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f288091b;

    public /* synthetic */ u0(boolean r100, boolean r101) {
        this.f288090a = r100;
        this.f288091b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean r100 = this.f288090a;
        boolean r101 = this.f288091b;
        Set<String> r102 = ChatBottomSpeakerComponent.F2;
        if (r100 == true) goto L7;
        if (r101 == true) goto L7;
        boolean r103 = false;
    L9:
        return Boolean.valueOf(r103);
    L7:
        r103 = true;
        goto L9
    }
}
