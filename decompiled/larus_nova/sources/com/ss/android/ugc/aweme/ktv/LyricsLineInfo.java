package com.ss.android.ugc.aweme.ktv;

import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0000J\u0006\u0010&\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR&\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/LyricsLineInfo;", "Ljava/io/Serializable;", "()V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "lineLyrics", "", "getLineLyrics", "()Ljava/lang/String;", "setLineLyrics", "(Ljava/lang/String;)V", "lineOriginLyrics", "getLineOriginLyrics", "setLineOriginLyrics", "lyricsWords", "", "getLyricsWords", "()[Ljava/lang/String;", "setLyricsWords", "([Ljava/lang/String;)V", "[Ljava/lang/String;", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "wordsDisInterval", "", "getWordsDisInterval", "()[I", "setWordsDisInterval", "([I)V", "copy", "", "dist", "orig", "getDefault", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class LyricsLineInfo implements Serializable {
    private int endTime;
    private String lineLyrics;
    private String lineOriginLyrics;
    private String[] lyricsWords;
    private int startTime;
    private int[] wordsDisInterval;

    public LyricsLineInfo() {
    }

    public final LyricsLineInfo getDefault() {
        LyricsLineInfo r100 = new LyricsLineInfo();
        r100.lineLyrics = "";
        r100.startTime = Integer.MAX_VALUE;
        return r100;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final String getLineLyrics() {
        return this.lineLyrics;
    }

    public final String getLineOriginLyrics() {
        return this.lineOriginLyrics;
    }

    public final String[] getLyricsWords() {
        return this.lyricsWords;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final int[] getWordsDisInterval() {
        return this.wordsDisInterval;
    }

    public final void setEndTime(int r100) {
        this.endTime = r100;
    }

    public final void setLineLyrics(String r100) {
        this.lineLyrics = r100;
    }

    public final void setLineOriginLyrics(String r100) {
        this.lineOriginLyrics = r100;
    }

    public final void setLyricsWords(String[] r100) {
        this.lyricsWords = r100;
    }

    public final void setStartTime(int r100) {
        this.startTime = r100;
    }

    public final void setWordsDisInterval(int[] r100) {
        this.wordsDisInterval = r100;
    }

    public final void copy(LyricsLineInfo r100, LyricsLineInfo r101) {
        if (r100 == null) goto L23;
        String r102 = null;
        if (r101 == null) goto L6;
        int[] r103 = r101.wordsDisInterval;
    L7:
        r100.wordsDisInterval = r103;
        int r104 = 0;
        if (r101 == null) goto L10;
        int r105 = r101.startTime;
    L11:
        r100.startTime = r105;
        if (r101 == null) goto L14;
        r104 = r101.endTime;
    L14:
        r100.endTime = r104;
        if (r101 == null) goto L17;
        String[] r106 = r101.lyricsWords;
    L18:
        r100.lyricsWords = r106;
        if (r101 == null) goto L21;
        r102 = r101.lineLyrics;
    L21:
        r100.lineLyrics = r102;
        return;
    L17:
        r106 = null;
        goto L18
    L10:
        r105 = 0;
        goto L11
    L6:
        r103 = null;
        goto L7
    }
}
