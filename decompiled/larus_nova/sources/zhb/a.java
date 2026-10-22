package zhb;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    boolean A00();

    boolean E80();

    String J20();

    ChatChatter N0();

    ThreadTopic N1();

    boolean Pr();

    Message b90();

    void cg(Function0<Unit> r100);

    ChatChatter g7();

    Context getContext();

    <T extends ViewModel> T getViewModel(Class<T> r100);

    boolean hE();

    boolean io();

    boolean q8();

    List<TitleBarActionKey> sr();

    void w9(ThreadTopic r100);
}
