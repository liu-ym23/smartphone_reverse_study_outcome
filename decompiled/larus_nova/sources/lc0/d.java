package lc0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.List;
import pc0.e;

/* JADX INFO: loaded from: classes45.dex */
public interface d {
    long A();

    void B(boolean r100);

    User C();

    void E(Observer<Long> r100);

    boolean F();

    void F0();

    oq2.d G();

    void a(Observer<RevPkState> r100);

    Room b();

    void c(Observer<RevPkState> r100);

    RevPkState d();

    e e();

    void f(Observer<Long> r100);

    void g(FragmentActivity r100);

    HashMap<String, String> getFollowExtraParams(String r100);

    int getPkState();

    void h(boolean r100, Boolean r101, List r102, String r103);

    boolean isInBreakThrough();

    boolean isMatching();

    MultiLiveCoreInfo multiLiveCoreInfo();

    MultiRtcInfo multiRtcInfo();
}
