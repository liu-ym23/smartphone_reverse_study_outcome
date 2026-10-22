package nf9;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes30.dex */
public interface d {
    void a(String r100, Message r101);

    void b(String r100, MessageListState r101, List<Message> r102);

    void c(String r100, Message r101, Map<String, String> r102);

    void d(String r100, Message r101);

    void e(String r100, Message r101, Map<String, String> r102);

    void f(String r100, Message r101);

    void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102);
}
