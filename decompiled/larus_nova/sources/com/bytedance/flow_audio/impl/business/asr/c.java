package com.bytedance.flow_audio.impl.business.asr;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f243792a;

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "prefixCodeList");
        this.f243792a = r100;
    }

    @Override // com.bytedance.flow_audio.impl.business.asr.a
    public final boolean a(String r100) {
        if (r100 == null) goto L21;
        List<String> r101 = this.f243792a;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L8;
        if (StringsKt.startsWith$default(r100, (String) r102.next(), false, 2, null) == false) goto L11;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L22;
        return true;
    L22:
        return false;
    L8:
        r103 = false;
        goto L15
    L7:
        if (r101.isEmpty() == false) goto L9;
    L21:
        return false;
    }
}
