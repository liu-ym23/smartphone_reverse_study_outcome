package to0;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public interface a extends uo0.a {
    void f();

    void g(Context r100, DataCenter r101);

    sq0.a getAudienceMiniAppWidgetDescriptor();

    gq0.a getShelfInfoBackendHandler();

    void hideMiniAppExplainCard();

    boolean isMiniAppExplainCardShowing();

    void onDestroy();

    void onSei(String r100);

    void onSnowFlakeShow(s r100);

    void openMountedMiniApp(MountedMiniAppSource r100);

    void openMountedMiniApp(String r100);

    void openSnowFlake();

    void reportAudienceLiveProjectionWatch(boolean r100);

    void reportAudienceLiveProjectionWatchDuration(long r100, boolean r101);

    void reportMpLiveLinkClick();

    void reportMpLiveLinkShow();

    void reportSnowFlakeAnimShow();

    void showMiniAppExplainCard();
}
