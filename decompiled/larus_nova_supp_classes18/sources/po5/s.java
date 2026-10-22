package po5;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements mo5.b {
    public final /* synthetic */ mo5.a a;

    public s(mo5.a r1) {
        this.a = r1;
    }

    @Override // mo5.b
    public final void a(TtsResult r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.g(r2);
    }
}
