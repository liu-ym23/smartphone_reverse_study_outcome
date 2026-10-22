package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.graphics.Paint;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    void addLyrics(List<com.bytedance.component.lyric.model.b> r1, long r2);

    void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r1, boolean r2);

    View asView();

    int getCurrentIndex();

    ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics();

    LyricsDisplayConfig getDisplayConfig();

    Paint.Align getTextAlign();

    boolean isFinishDrawLastLine();

    void onConfigComplete();

    void release();

    void renderLyricsByPlayTime(long r1);

    void resetCurrMusicProcess();

    void setLyricOneLineMaxWidth(float r1);

    void setLyricVisible(int r1);

    void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r1);

    void updateDynamicPaintColor();
}
