package no5;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mo5.a f519911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mo5.b f519912b;

    public b(mo5.a r100, g.a.C6953a r101) {
        this.f519911a = r100;
        this.f519912b = r101;
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        tt5.a.h("TtsLynxModel", "dispatchSeekAction, result: " + r100);
        this.f519911a.g(r100);
        mo5.b r101 = this.f519912b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
