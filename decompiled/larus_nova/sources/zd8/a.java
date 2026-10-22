package zd8;

import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes25.dex */
public interface a {
    void B8(boolean r100, Message r101, String r102);

    void C8(List<Message> r100);

    i1<CreationQueuingTaskUIState> D8();

    d1<Message> R2();

    void onClear();
}
