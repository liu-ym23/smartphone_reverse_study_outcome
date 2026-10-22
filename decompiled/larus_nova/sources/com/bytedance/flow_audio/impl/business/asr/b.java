package com.bytedance.flow_audio.impl.business.asr;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f243791a;

    public b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "codes");
        this.f243791a = r100;
    }

    @Override // com.bytedance.flow_audio.impl.business.asr.a
    public final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f243791a.contains(r100) == false) goto L6;
        return true;
    }
}
