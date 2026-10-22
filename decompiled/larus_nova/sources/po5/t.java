package po5;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f530084b = null;

    static {
        f530084b = new t();
    }

    public t() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        if (r100 != null) goto L6;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, albumVM not found.");
        return false;
    L6:
        a.f530050a.getClass();
        mo5.g r102 = a.C7218a.a(r100, r101);
        if (r102 != null) goto L10;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, targetVM not found.");
        return false;
    L10:
        tt5.a.h("TtsStartPlayingCommand", "handleAction, targetVM: " + r102);
        mo5.g r103 = r100.h(r102);
        if (r103 == null) goto L21;
        IPlayer.State r104 = (IPlayer.State) r103.u().getValue();
        if (r104 != null) goto L16;
        r104 = IPlayer.State.IDLE;
    L16:
        if (r104 != IPlayer.State.ERROR) goto L18;
        tt5.a.k("TtsStartPlayingCommand", "handleAction, selectedVM(" + r103 + ") is error, prune it first.");
        r103.q();
    L18:
        tt5.a.h("TtsStartPlayingCommand", "handleAction, start playing: " + r103);
        r103.p(TtsLoadScene.DEFAULT, new s(r100));
        return true;
    L21:
        return true;
    }
}
