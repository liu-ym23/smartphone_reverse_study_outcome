package k34;

import com.bytedance.awemeopen.awemesdk.se.Aos$init$1$1;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.user.c;
import com.bytedance.awemeopen.bizmodels.user.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface b extends k24.a {
    void B(com.bytedance.awemeopen.bizmodels.user.b r100);

    void G1(Aos$init$1$1 r100);

    void I1(Function2<? super String, ? super String, Unit> r100);

    void M1();

    void Q0(Function2<? super String, ? super String, Unit> r100);

    void S0(f r100, Function1<? super c, Unit> r101);

    User b();

    c getAccessToken();

    boolean isLogin();

    void l0(f r100, com.bytedance.awemeopen.bizmodels.user.b r101);

    void u(com.bytedance.awemeopen.apps.framework.framework.viewpager.helper.a r100);
}
