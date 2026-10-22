package va8;

import com.ixigua.lib.track.FrozenTrackNode;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface x extends m1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ Object a(x r110, wc9.e r111, String r112, Message r113, String r114, long r115, Continuation r116) {
            return r110.Aa(r111, r112, r113, "stream_interrupt_clickstop", r114, null, r115, r116);
        }
    }

    Object Aa(wc9.e r100, String r101, Message r102, String r103, String r104, Integer r105, long r106, Continuation<? super Unit> r107);

    void Bq(String r100, String r101, String r102);

    void G40(String r100, String r101, String r102);

    String L1();

    long O();

    boolean W();

    String WJ(String r100);

    void Zn(String r100, String r101, String r102, long r103, String r104, String r105, String r106, Boolean r107);

    void ig(String r100, String r101, long r102, String r103, String r104, String r105, Boolean r106);

    void ik(Message r100, String r101, FrozenTrackNode r102);

    String jd();

    String k();

    void tg(String r100, String r101, String r102);

    void uN(String r100, ContainerExceptionType r101, String r102, JSONObject r103);

    void x10(Message r100, String r101);
}
