package com.larus.bmhome.chat.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/api/IMusicService;", "", "createLyricsToSongTemplatePlayerView", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindSonTemplatePlayerData", "", "musicPlayerView", "musicData", "", "position", "", "currentPage", "showFrom", "rebind", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMusicService {
    LyricsToSongTemplatePlayerView a(Context r100);

    void b(FrameLayout r100, String r101, int r102, String r103);
}
