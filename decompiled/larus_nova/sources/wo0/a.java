package wo0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends xo0.a {
    jr0.a getAudienceMiniGameWidgetDescriptor();

    void openMountedMiniGame(MountedMiniGameSource r100, String r101);

    void reportMpClick(MountedMiniGameSource r100);

    void reportMpShow();
}
