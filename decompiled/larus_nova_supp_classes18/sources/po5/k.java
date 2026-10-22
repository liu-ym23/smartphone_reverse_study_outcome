package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements a {
    public static final k b = null;

    static {
        b = new k();
    }

    public k() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r4, Map r5) {
        if (r4 != null) goto L6;
        tt5.a.k("TtsPlayNextCommand", "handleAction, albumVM is null.");
        return false;
    L6:
        tt5.a.h("TtsPlayNextCommand", "handleAction, albumVM: " + r4);
        mo5.g r0 = mo5.h.e(r4);
        if (r0 == null) goto L15;
        mo5.g r1 = r4.d(r0);
        if (r1 == null) goto L16;
        mo5.g r2 = r4.h(r1);
        if (r2 == null) goto L17;
        tt5.a.h("TtsPlayNextCommand", "handleAction, switch to next: " + r2);
        r2.p(TtsLoadScene.SWITCH_ITEM, new j(r4));
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }
}
