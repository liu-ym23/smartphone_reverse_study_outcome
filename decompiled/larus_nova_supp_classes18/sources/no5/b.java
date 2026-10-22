package no5;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements mo5.b {
    public final /* synthetic */ mo5.a a;
    public final /* synthetic */ mo5.b b;

    public b(mo5.a r1, g.a.C0277a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // mo5.b
    public final void a(TtsResult r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        tt5.a.h("TtsLynxModel", "dispatchSeekAction, result: " + r3);
        this.a.g(r3);
        mo5.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
