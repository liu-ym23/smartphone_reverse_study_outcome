package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f474223a = null;

    static {
        f474223a = new m();
    }

    public m() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_follower_share_api_dispose", "修复/aweme/v1/familiar/recommend/status/ 请求主动断开导致服务端499错误上升的问题", r100, r100);
    }
}
