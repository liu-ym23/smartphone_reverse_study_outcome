package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f520091a = null;

    static {
        f520091a = new c();
    }

    public c() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_playback_get_right_enable", "付费回放下发试看视频", r100, r100);
    }
}
