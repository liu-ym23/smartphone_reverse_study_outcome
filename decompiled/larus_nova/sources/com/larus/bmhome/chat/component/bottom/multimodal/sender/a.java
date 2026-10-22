package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f300044a;

    public /* synthetic */ a(Map r100) {
        this.f300044a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Map r101 = this.f300044a;
        Map r102 = (Map) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        r102.putAll(r101);
        return r102;
    }
}
