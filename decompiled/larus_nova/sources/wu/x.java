package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class x extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f561413a = null;

    static {
        f561413a = new x();
    }

    public x() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_login_reservation_opt", "取消预约时清理预约记录优化", r100, r100);
    }
}
