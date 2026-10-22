package pl9;

import com.larus.music.qq.data.QQPlayStatus;

/* JADX INFO: loaded from: classes30.dex */
public final class d {
    public static final QQPlayStatus a(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L15;
        if (r100 == 10) goto L15;
        return QQPlayStatus.PAUSED;
    L15:
        return QQPlayStatus.PLAYING;
    }
}
