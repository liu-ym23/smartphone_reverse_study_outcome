package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.t6;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface b extends c {
    boolean N(String r100);

    int c();

    void clear(boolean r100);

    List<p> d();

    void e(d r100);

    void f(boolean r100);

    List<IBaseUser> getInviteeList();

    void h(int r100, int r101, String r102);

    t6 j();

    void k(int r100, int r101, String r102, long r103);

    List<IBaseUser> n();

    void o(Function1 r100);

    void p(List<? extends p> r100, String r101, Long r102);

    void q(IBaseUser r100);

    void r(IBaseUser r100);

    List<d> s();

    void t(IBaseUser r100);

    void u(String r100);

    p v(String r100);

    String w();

    void x(r r100);

    void y(IBaseUser r100);
}
