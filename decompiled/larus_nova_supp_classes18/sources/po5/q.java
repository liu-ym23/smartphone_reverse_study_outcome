package po5;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements mo5.b {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // mo5.b
    public final void a(TtsResult r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        tt5.a.h("TtsResumeCommand", "handleAction, prepareAndResume result: " + r3);
    }
}
