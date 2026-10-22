package ecb;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends MessageParams<a, Object> {
    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.CARD);
        r102.setMessageContent(null);
        return r102;
    }
}
