package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class o2 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f497275a = null;

    static {
        f497275a = new o2();
    }

    public o2() {
        super("live_samsung_fold_screen_device_list", "三星折叠屏设备白名单", new ArrayList(), new ArrayList());
    }
}
