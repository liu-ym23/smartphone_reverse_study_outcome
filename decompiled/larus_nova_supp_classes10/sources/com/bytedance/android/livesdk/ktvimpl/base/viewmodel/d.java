package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface d {
    void clearData();

    void cutFromChallenge(String r1);

    void cutMusic();

    void initLiveStreamWrapper(String r1);

    boolean isNeedMusicDownload(MusicPanel r1);

    i lazyInitKtvCoreController();

    void onPageCreate();

    void onPageResume();

    void onPageStop();

    void toggleOrigin(boolean r1);

    void togglePause(boolean r1);

    void updateCurrentLyricsLine(int r1);
}
