package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mo5.b f239739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mo5.b f239740c;

    public void b() {
        tt5.a.h(this.f239738a, "onAttach");
    }

    public void c() {
        tt5.a.h(this.f239738a, "onDetach");
    }

    public void d() {
        tt5.a.h(this.f239738a, WidgetCostModule.TYPE_ON_START);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f239738a = r100;
    }

    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        mo5.b r101 = this.f239739b;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        mo5.b r102 = this.f239740c;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }
}
