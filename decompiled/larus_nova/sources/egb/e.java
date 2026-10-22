package egb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.multi_select.ContentListenerImpl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public interface e {
    void a(Context r100, Chat r101, ArrayList r102, int r103, ContentListener r104);

    void b(Context r100, Chat r101, ArrayList r102, ContentListenerImpl r103);

    void c(Context r100, Chat r101, String r102, String r103, Fragment r104);

    void d(Context r100, int r101, Message r102, String r103, boolean r104, ContentListener r105);
}
