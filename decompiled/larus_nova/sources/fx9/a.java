package fx9;

import com.larus.bmhome.chat.mode.q;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends m1a.a {

    /* JADX INFO: renamed from: fx9.a$a, reason: collision with other inner class name */
    public interface InterfaceC5960a {
        void a(String r100, int r101, int r102);
    }

    void KX(Message r100, String r101);

    void Nk(b r100);

    boolean Xe(String r100);

    void dT(q r100);

    void dV(q r100);

    Set<Message> h9(List<Message> r100);

    void k30(Message r100, String r101, String r102, long r103);

    void kP(String r100, int r101, int r102);

    void pi();

    void q9(Function0<Unit> r100);

    void u8(List<Message> r100);

    void vt(Message r100, String r101, String r102, long r103);

    void yT(Message r100);
}
