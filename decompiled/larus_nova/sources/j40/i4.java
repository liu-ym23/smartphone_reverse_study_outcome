package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4 f497241a = null;

    static {
        f497241a = new i4();
    }

    public i4() {
        Boolean r100 = Boolean.TRUE;
        super("match_room_land_animutil_listen_focuschange", "赛事直播间横屏动画压缩工具是否监听焦点变化并兜底", r100, r100);
    }
}
