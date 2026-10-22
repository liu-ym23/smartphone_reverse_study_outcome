package wi;

import android.content.Context;
import com.bytedance.android.ec.core.address.m;
import com.bytedance.android.ec.core.address.q;
import com.bytedance.android.ec.core.address.r;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;

/* JADX INFO: loaded from: classes44.dex */
public interface c {
    boolean a();

    void b(Context r100, ECBaseBridgeMethod.a r101);

    void c(Context r100, ECBaseBridgeMethod.a r101);

    void d(String r100, String r101, m r102);

    void e(q r100);

    void f();

    void g(r r100);

    a h(String r100, String r101);

    boolean onActivityResult();

    void release();
}
