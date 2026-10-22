package po5;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f530081a = null;

    static {
        f530081a = new q();
    }

    public q() {
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        tt5.a.h("TtsResumeCommand", "handleAction, prepareAndResume result: " + r100);
    }
}
