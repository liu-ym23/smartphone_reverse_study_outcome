package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f530075b = null;

    static {
        f530075b = new k();
    }

    public k() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        if (r100 != null) goto L6;
        tt5.a.k("TtsPlayNextCommand", "handleAction, albumVM is null.");
        return false;
    L6:
        tt5.a.h("TtsPlayNextCommand", "handleAction, albumVM: " + r100);
        mo5.g r102 = mo5.h.e(r100);
        if (r102 == null) goto L15;
        mo5.g r103 = r100.d(r102);
        if (r103 == null) goto L16;
        mo5.g r104 = r100.h(r103);
        if (r104 == null) goto L17;
        tt5.a.h("TtsPlayNextCommand", "handleAction, switch to next: " + r104);
        r104.p(TtsLoadScene.SWITCH_ITEM, new j(r100));
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }
}
