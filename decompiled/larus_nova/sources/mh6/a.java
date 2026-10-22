package mh6;

import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f513966a = 0;

    /* JADX INFO: renamed from: mh6.a$a, reason: collision with other inner class name */
    public static final class C6815a {
        public static InteractMode a(int r100) {
            if (r100 == 9) goto L9;
            if (r100 == 10) goto L11;
            return InteractMode.FM;
        L11:
            return InteractMode.SHARE_VIDEO;
        L9:
            return InteractMode.KTV;
        }
    }

    static {
    }
}
