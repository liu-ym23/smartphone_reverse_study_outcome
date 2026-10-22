package hab;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$getP2pChatCreatedByChatterId$2$1;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    void a();

    void b(String r100, StrangerInterceptor$getP2pChatCreatedByChatterId$2$1 r101);

    void c(Fragment r100, Context r101, ChatBundle r102);

    IChatParser getChatParser();

    void openChat(Context r100, ChatBundle r101);
}
