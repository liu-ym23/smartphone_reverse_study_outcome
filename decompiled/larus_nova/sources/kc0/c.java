package kc0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public interface c {
    long A();

    void B(boolean r100);

    IBaseUser C();

    String D();

    void E(Observer<Long> r100);

    boolean F();

    void F0();

    oq2.d G();

    void H(boolean r100);

    void I(String r100);

    Long J();

    void K(Object r100);

    com.bytedance.android.live.revlink.impl.pk.transfer.a L();

    void a(Observer<RevPkState> r100);

    IRoom b();

    void c(Observer<RevPkState> r100);

    RevPkState d();

    pc0.e e();

    void f(Observer<Long> r100);

    HashMap<String, String> getFollowExtraParams(String r100);

    String getInviteMode();

    int getPkState();

    boolean isInBreakThrough();

    boolean isMatching();

    d7 multiLiveCoreInfo();

    v1 multiRtcInfo();

    void sendGuestKickOut(String r100, String r101);
}
