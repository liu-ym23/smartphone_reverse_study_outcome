package g84;

import android.accounts.Account;
import android.content.Context;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.u;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a(u r100);

    void b(Account r100);

    void c(Map r100);

    boolean d(JSONObject r100);

    boolean e();

    u f();

    n0 g();

    String getDid();

    void h(Context r100, Map r101, boolean r102);

    void i(u r100);

    void j(u r100, long r101, t0 r102);

    boolean k();

    void l(n0 r100);

    void m(o0 r100, u r101);

    void start();
}
