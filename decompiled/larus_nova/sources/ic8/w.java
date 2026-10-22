package ic8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageContentType;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes25.dex */
public interface w {
    ChatPageContext N();

    ReferenceInfo T6();

    Map<String, String> a();

    String b();

    w c(Map<String, String> r100, Map<String, String> r101);

    String content();

    @MessageContentType
    int contentType();

    MessageRequestType d();

    Map<String, String> e();

    Map<String, String> f();

    String g();

    Pair<String, String> h();

    MessageStatus i();
}
