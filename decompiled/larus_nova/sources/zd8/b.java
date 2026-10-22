package zd8;

import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes4.dex */
public interface b extends t1a.a {
    void B8(boolean r100, Message r101, String r102);

    i1<MessageLoadingUIState> H4();

    d1<Message> R2();

    i1<CreationQueuingTaskUIState> Um();

    void Xt(Message r100, List<Message> r101);
}
