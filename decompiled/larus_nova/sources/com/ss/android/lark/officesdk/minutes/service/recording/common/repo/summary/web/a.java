package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.webkit.ValueCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f435379a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Boolean, Unit> r100) {
        this.f435379a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        lvb.a.a("MmSummaryNativeToJSHelper", "[checkFishBoneCanScroll] result=" + r101);
        if (r101 == null) goto L7;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L7;
        boolean r103 = Boolean.parseBoolean(r102);
    L8:
        this.f435379a.invoke(Boolean.valueOf(r103));
        return;
    L7:
        r103 = false;
        goto L8
    }
}
