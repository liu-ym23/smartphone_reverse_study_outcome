package v3c;

import com.ss.android.lark.chat.api.chatpreview.BasicChatInfo;
import com.ss.android.lark.chat.api.chatpreview.ChatId;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final BasicChatInfo a(SearchBaseInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if ((r110 instanceof SearchChatInfo) == false) goto L17;
        ChatId.ID r100 = new ChatId.ID(r110.getId());
        SearchChatInfo r111 = (SearchChatInfo) r110;
        String r101 = r111.getTitle();
        String r102 = r111.getAvatarKey();
        if (r111.getChatMode() != Chat.ChatMode.THREAD_V2) goto L7;
    L10:
        boolean r103 = true;
    L11:
        boolean r112 = r111.isSecretChat();
        if (r111.getType() != 26) goto L14;
        boolean r113 = true;
    L29:
        return new BasicChatInfo(r100, r101, r102, r103, false, "", null, r112, r113);
    L14:
        r113 = false;
        goto L29
    L7:
        if (r111.getChatMode() == Chat.ChatMode.THREAD) goto L10;
        r103 = false;
        goto L11
    L17:
        if ((r110 instanceof SearchChatterInfo) == false) goto L27;
        SearchChatterInfo r114 = (SearchChatterInfo) r110;
        String r104 = r114.getP2pChatId();
        if (r104 == null) goto L21;
        ChatId r105 = new ChatId.ID(r104);
    L22:
        ChatId r106 = r105;
        String r107 = r114.getTitle();
        String r108 = r114.getAvatarKey();
        String r115 = r114.getId();
        Chatter.ChatterType r116 = r114.getChatterType();
        if (r114.getType() != 26) goto L25;
        boolean r117 = true;
    L30:
        return new BasicChatInfo(r106, r107, r108, false, true, r115, r116, false, r117);
    L25:
        r117 = false;
        goto L30
    L21:
        r105 = ChatId.UnloadChat.INSTANCE;
        goto L22
    L27:
        return null;
    }
}
