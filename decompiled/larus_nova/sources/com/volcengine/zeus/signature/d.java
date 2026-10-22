package com.volcengine.zeus.signature;

import com.volcengine.zeus.Zeus;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements Function0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f462896a;

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return Zeus.getPlugin(this.f462896a).mSignature;
    }

    public d(String r100) {
        this.f462896a = r100;
    }
}
