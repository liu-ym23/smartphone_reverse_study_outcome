package po5;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements a {
    public static final t b = null;

    static {
        b = new t();
    }

    public t() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r4, Map r5) {
        if (r4 != null) goto L6;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, albumVM not found.");
        return false;
    L6:
        a.a.getClass();
        mo5.g r6 = a.C0291a.a(r4, r5);
        if (r6 != null) goto L10;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, targetVM not found.");
        return false;
    L10:
        tt5.a.h("TtsStartPlayingCommand", "handleAction, targetVM: " + r6);
        mo5.g r7 = r4.h(r6);
        if (r7 == null) goto L21;
        IPlayer.State r0 = (IPlayer.State) r7.u().getValue();
        if (r0 != null) goto L16;
        r0 = IPlayer.State.IDLE;
    L16:
        if (r0 != IPlayer.State.ERROR) goto L18;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, selectedVM(" + r7 + ") is error, prune it first.");
        r7.q();
    L18:
        tt5.a.h("TtsStartPlayingCommand", "handleAction, start playing: " + r7);
        r7.p(TtsLoadScene.DEFAULT, new s(r4));
        return true;
    L21:
        return true;
    }
}
