package ta7;

import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformChangeBindAdapter;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.ss.android.account.l;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface i {
    void a(String r100, String r101, String r102, long r103, Map r104, PlatformProfileAdapter.ProfileCallback r105);

    void b(String r100, String r101, String r102, Map r103, l r104);

    void c(String r100, String r101, String r102, Map r103, PlatformLoginAdapter.LoginCallback r104);

    void d(String r100, String r101, String r102, Map<String, String> r103, sa7.h<xa7.k> r104);

    void e(String r100, String r101, String r102, Map r103, PlatformLoginAdapter.LoginCallback r104);

    void f(String r100, String r101, String r102, long r103, Map r104, PlatformBindAdapter.a r105);

    void g(String r100, String r101, String r102, String r103, long r104, Map r105, PlatformLoginAdapter.LoginCallback r106);

    void h(String r100, String r101, String r102, boolean r103, boolean r104, Map r105, PlatformLoginAdapter.LoginCallback r106);

    void i(String r100, String r101, String r102, String r103, long r104, Map r105, l r106);

    void j(String r100, String r101, String r102, long r103, Map r104, PlatformLoginAdapter.LoginCallback r105);

    void k(String r100, String r101, String r102, String r103, long r104, Map r105, PlatformProfileAdapter.ProfileCallback r106);

    void l(String r100, String r101, String r102, Map r103, PlatformProfileAdapter.ProfileCallback r104);

    void m(String r100, String r101, String r102, Map r103, sa7.h r104);

    void n(String r100, String r101, String r102, String r103, boolean r104, boolean r105, Map<String, String> r106, sa7.h<ua7.h> r107);

    void o(String r100, String r101, String r102, Map r103, PlatformBindAdapter.a r104);

    void p(String r100, String r101, String r102, String r103, boolean r104, boolean r105, Map r106, PlatformChangeBindAdapter.a r107);
}
