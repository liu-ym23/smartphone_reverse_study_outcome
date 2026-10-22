package xa1;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f563027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<List<String>> f563028b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingKey<Boolean> f563029c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SettingKey<Boolean> f563030d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SettingKey<Boolean> f563031e = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f563027a = new SettingKey("live_lynx_mapping_switch", "lynx mapping 开关", r100, r100);
        f563028b = new SettingKey("live_jsb_whitelist", "直播JSB白名单", new ArrayList(), new ArrayList());
        Boolean r101 = Boolean.TRUE;
        f563029c = new SettingKey("live_jsb2_enable_finder_register_fix", "直播容器JSB2MethodFinder修复开启开关", r101, r101);
        f563030d = new SettingKey("enable_anniex_live_pia_fetch_fix", "修复 AnnieXLive PIA FetchV3Method 复用导致的 bug ", r101, r101);
        r101.getClass();
        f563031e = new SettingKey("webcast_use_anniex_redirect", "开启AnnieX 重定向", r100, r100);
    }
}
