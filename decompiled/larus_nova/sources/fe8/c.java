package fe8;

import com.larus.bmhome.interactionpanel.f1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadData;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public interface c extends t1a.a {
    void KG(Function1<? super List<Message>, Unit> r100);

    ThreadData VE();

    void ZF(boolean r100);

    void al(f1 r100);

    List<Message> nL();

    void onRefresh();
}
