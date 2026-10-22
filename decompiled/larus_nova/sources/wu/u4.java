package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class u4 extends SettingKey<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u4 f561400a = null;

    static {
        f561400a = new u4();
    }

    public u4() {
        super("live_promote_card_new_style_support_list", "讲解卡采用边下边玩样式支持的游戏列表", CollectionsKt.mutableListOf(new String[]{"cgmocn000000000007107799"}), CollectionsKt.mutableListOf(new String[]{"cgmocn000000000007107799"}));
    }
}
