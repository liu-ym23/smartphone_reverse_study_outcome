package com.larus.uaigc.instruction.kmp;

import android.net.Uri;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class b implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpDropFeatureSelectorWidget f373402a;

    public /* synthetic */ b(KmpDropFeatureSelectorWidget r100) {
        this.f373402a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r100, Object r101, Object r102) {
        String r103 = (String) r101;
        return KmpDropFeatureSelectorWidget.V5(this.f373402a, (TemplateInfo$TemplateInfo) r100, (Uri) r102);
    }
}
