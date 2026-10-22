package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements a {
    public static final m b = null;

    static {
        b = new m();
    }

    public m() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r4, Map r5) {
        if (r4 != null) goto L6;
        tt5.a.k("TtsPlayPreviousCommand", "handleAction, albumVM is null.");
        return false;
    L6:
        tt5.a.h("TtsPlayPreviousCommand", "handleAction, albumVM: " + r4);
        mo5.g r0 = mo5.h.e(r4);
        if (r0 == null) goto L15;
        mo5.g r1 = r4.f(r0);
        if (r1 == null) goto L16;
        mo5.g r2 = r4.h(r1);
        if (r2 == null) goto L17;
        tt5.a.h("TtsPlayPreviousCommand", "handleAction, switch to previous: " + r2);
        r2.p(TtsLoadScene.SWITCH_ITEM, new l(r4));
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }
}
