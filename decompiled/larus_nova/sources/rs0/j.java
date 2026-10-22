package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f539060a = null;

    static {
        f539060a = new j();
    }

    public j() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_jump_personal_page_when_online", "直播间聊天室麦上嘉宾能否跳转个人页", r100, r100);
    }
}
