package tib;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.MessageParams;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface f {
    void getThreadTopicsByIds(List<String> r100, IGetDataCallback<ThreadTopic> r101);

    void sendImages(String r100, List<String> r101, boolean r102, IGetDataCallback<String> r103);

    void sendMessage(MessageParams<?, ?> r100, IGetDataCallback<String> r101);
}
