package m61;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f512272a = null;

    static {
        f512272a = new a();
    }

    public a() {
        Boolean r100 = Boolean.TRUE;
        super("live_player_seek_normal_room", "看播侧的普通直播间是否支持时移能力", r100, r100);
    }
}
