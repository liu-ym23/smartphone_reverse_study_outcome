package py4;

import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface j extends b {
    void a(String r1);

    void b(FollowInvokeResult r1);

    e c();

    ry4.a d(RNFollowEvent r1);

    String e(String r1, String r2, String r3, String r4, f r5);

    void f(String r1, String r2, String r3, ry4.a r4, boolean r5);

    void g(String r1, String r2, String r3, String r4);

    k<? extends NonProguard> h(RNFollowEvent r1);

    void i(String r1, String r2, String r3);

    void j(k<? extends NonProguard> r1, ry4.a r2, a r3);

    void onEvent(RNFollowEvent r1);
}
