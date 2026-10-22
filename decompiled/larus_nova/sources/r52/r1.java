package r52;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class r1 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f536249a = null;

    static {
        f536249a = new r1();
    }

    public r1() {
        super("live_new_chat_channel_greeting_emoji_names", "聊天频道打招呼功能使用的互动表情名称", CollectionsKt.listOf(new String[]{"戳一戳", "比心", "在干嘛", "绝了"}), CollectionsKt.listOf(new String[]{"戳一戳", "比心", "在干嘛", "绝了"}));
    }
}
