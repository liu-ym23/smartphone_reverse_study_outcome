package nq9;

import com.larus.bmhome.chat.trace.j;
import com.larus.im.bean.message.Message;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public interface f {
    OldUgcGenImgPerfMonitor a(boolean r100);

    void b();

    void c(String r100, String r101, int r102);

    void d(j r100);

    void e(String r100, ISDKPointCallback.EndMsg r101);

    void f(String r100, String r101);

    void g(String r100, String r101, String r102, int r103, String r104, String r105, List<Message> r106, long r107);

    void o4(Message r100);
}
