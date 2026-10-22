package py4;

import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public interface j extends b {
    void a(String r100);

    void b(FollowInvokeResult r100);

    e c();

    ry4.a d(RNFollowEvent r100);

    String e(String r100, String r101, String r102, String r103, f r104);

    void f(String r100, String r101, String r102, ry4.a r103, boolean r104);

    void g(String r100, String r101, String r102, String r103);

    k<? extends NonProguard> h(RNFollowEvent r100);

    void i(String r100, String r101, String r102);

    void j(k<? extends NonProguard> r100, ry4.a r101, a r102);

    void onEvent(RNFollowEvent r100);
}
