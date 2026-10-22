package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/music/lyrics_to_song/LyricsToSongCell;", "Lcom/larus/uaigc/music/lyrics_to_song/BaseLyricsToSongCell;", "<init>", "()V", "generateSongBox", "Lcom/larus/uaigc/music/lyrics_to_song/BaseLyricsToSongBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LyricsToSongCell extends BaseLyricsToSongCell {
    public LyricsToSongCell() {
    }

    @Override // com.larus.uaigc.music.lyrics_to_song.BaseLyricsToSongCell
    public final a o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new f(r100);
    }
}
