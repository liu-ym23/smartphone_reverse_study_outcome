package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class d0 extends SettingKey<com.bytedance.android.gamecp.common.setting.config.b2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f561294a = null;

    static {
        f561294a = new d0();
    }

    public d0() {
        com.bytedance.android.gamecp.common.setting.config.b2 r100 = new com.bytedance.android.gamecp.common.setting.config.b2();
        r100.d();
        r100.g();
        r100.e();
        r100.f();
        r100.c();
        Unit r101 = Unit.INSTANCE;
        super("game_steam_wishlist_config", "添加steam心愿单", r100);
    }
}
