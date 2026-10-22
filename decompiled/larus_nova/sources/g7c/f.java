package g7c;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes38.dex */
public interface f {
    DefaultEmojiPanelData a();

    void b(FragmentActivity r100, MergeForwardContent r101, String r102);

    Message c(Entity r100, String r101);

    void d(Context r100, String r101);

    void e(Chatter r100);

    List<String> f();

    void g(String r100);

    Pair<String, CharSequence> generateMergeForwardInfo(MergeForwardContent r100);

    void getChatById(String r100);

    List<String> h();

    void i(String r100, Map r101, Map r102);

    void n(Context r100, String r101);
}
