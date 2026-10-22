package xh0;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public interface b {
    boolean beforeOpen();

    ArrayList<f> getIncompatibleSourceList();

    ArrayList<Integer> getOverlayWhiteList();

    h getPlayModeInfo();

    g isCanOpen(HashMap<String, Object> r100);

    boolean isOpen();

    Pair<Boolean, String> isSupportSceneChange(int r100);

    Pair<Boolean, String> isSupportUiLayoutChang(int r100);

    void tryStartPlayMode(HashMap<String, Object> r100);

    void tryStopPlayMode(HashMap<String, Object> r100);
}
