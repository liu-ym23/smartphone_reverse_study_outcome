package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class r1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f561379a = null;

    static {
        f561379a = new r1();
    }

    public r1() {
        Boolean r100 = Boolean.TRUE;
        super("gamecp_preview_preload_enter_opt", "预览流场景中是否预加载图标", r100, r100);
    }
}
