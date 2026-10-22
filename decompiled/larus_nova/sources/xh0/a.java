package xh0;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements b {
    public a() {
    }

    @Override // xh0.b
    public final boolean beforeOpen() {
        return true;
    }

    @Override // xh0.b
    public final ArrayList<Integer> getOverlayWhiteList() {
        return null;
    }

    @Override // xh0.b
    public g isCanOpen(HashMap<String, Object> r100) {
        return new g(IncompatibleTag.PLAY_MODE, getPlayModeInfo().f563852a, true, null, 24);
    }

    @Override // xh0.b
    public final Pair<Boolean, String> isSupportSceneChange(int r100) {
        return new Pair(Boolean.TRUE, "");
    }

    @Override // xh0.b
    public final Pair<Boolean, String> isSupportUiLayoutChang(int r100) {
        return new Pair(Boolean.TRUE, "");
    }
}
