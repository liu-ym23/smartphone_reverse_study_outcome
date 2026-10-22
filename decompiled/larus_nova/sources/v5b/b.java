package v5b;

import com.ss.android.lark.chat.export.entity.message.MessageType;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import v5b.a;

/* JADX INFO: loaded from: classes35.dex */
public interface b<T extends a<?>> {
    MessageType a();

    @Deprecated(message = "新消息不用再实现该接口，请使用 MessageParser 来提供消息的解析", replaceWith = @ReplaceWith(expression = "MessageParser.getReplyDigest(context, message)", imports = {"com.ss.android.lark.biz.im.api.extension.parser.MessageParser", "android.content.Content", "com.ss.android.lark.chat.entity.message.Message"}))
    CharSequence b(p5b.c r100);

    T c(p5b.c r100);
}
