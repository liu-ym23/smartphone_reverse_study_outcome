package com.ss.android.dypay.bean;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends Lambda implements Function1<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f408456a;

    public b(Map r100) {
        this.f408456a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public String invoke(String r100) {
        Map r101 = this.f408456a;
        String r102 = (String) r101.get(r100);
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102;
    }
}
