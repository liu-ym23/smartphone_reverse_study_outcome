package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements a {
    public static final r b = null;

    static {
        b = new r();
    }

    public r() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r2, Map r3) {
        a.a.getClass();
        mo5.g r4 = a.C0291a.a(r2, r3);
        if (r4 != null) goto L6;
        return false;
    L6:
        r4.p(TtsLoadScene.DEFAULT, q.a);
        return true;
    }
}
