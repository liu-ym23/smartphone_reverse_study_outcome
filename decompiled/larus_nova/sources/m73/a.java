package m73;

import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackVideoStruct;
import fj.d;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final d a(PlaybackVideoStruct r210) {
        if (r210 != null) goto L5;
        return null;
    L5:
        return new d(r210.getPlayUrl(), null, r210.getVideoId(), r210.getWidth(), r210.getHeight(), r210.getDuration(), r210.getCoverUrl(), true, false, true, false, true, null, false, 0, null, null, 128256);
    }
}
