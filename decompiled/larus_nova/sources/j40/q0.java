package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class q0 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f497285a = null;

    static {
        f497285a = new q0();
    }

    public q0() {
        super("live_huawei_fold_screen_device_list", "华为折叠屏设备白名单", CollectionsKt.mutableListOf(new String[]{"RLI-AN00", "TAH-AN00m", "TAH-AN00", "TAH-N29", "TAH-N29m", "RLI-N29", "RHA-AN00m", "RHA-N29m"}), new ArrayList());
    }
}
