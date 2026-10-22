package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements cd4.m {
    @Override // cd4.m
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // cd4.m
    public final String getName() {
        return "log";
    }

    @Override // cd4.m
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // cd4.m
    public final void release() {
    }

    public l() {
    }

    @Override // cd4.m
    public final void handle(Context r100, JSONObject r101, cd4.k r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.optString("level");
        String r103 = r101.optString("tag");
        String r104 = r101.optString("log");
        ALogService r105 = (ALogService) ve4.b.a(ALogService.class);
        if (r105 != null) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r103) == false) goto L7;
        r103 = "CJPayAnnieWebKitService";
    L7:
        r105.i(r103, r104);
    }
}
