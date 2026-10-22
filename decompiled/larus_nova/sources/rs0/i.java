package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f539058a = null;

    static {
        f539058a = new i();
    }

    public i() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_follow_status_use_local_db", "关注状态发生错误时是否使用兜底IM数据库", r100, r100);
    }
}
