package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.render.q;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class d implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WcbRequestPipeline f370106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f370107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f370108c;

    public /* synthetic */ d(WcbRequestPipeline r100, f r101, q r102) {
        this.f370106a = r100;
        this.f370107b = r101;
        this.f370108c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        WcbRequestPipeline r100 = this.f370106a;
        f r101 = this.f370107b;
        q r102 = this.f370108c;
        if (r100.e(r101) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L11;
        FLogger.f375446a.i("WcbLog", "[pipeline] transaction.inactive chat=" + r101.f370116d + " exec=" + r101.f370117e + " currentExec=" + r100.f370077g + " active=" + r102.isActive());
    L11:
        return Boolean.valueOf(r103);
    L5:
        if (r102.isActive() == false) goto L7;
        r103 = true;
        goto L8
    }
}
