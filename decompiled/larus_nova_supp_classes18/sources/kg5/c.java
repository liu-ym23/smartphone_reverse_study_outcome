package kg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyDocPermPuller;
import com.bytedance.ee.bear.middleground.permission.apply.f;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c<PARAMS extends NonProguard, RESULT extends NonProguard> {
    public final NetService.d<Result<RESULT>> a;
    public final String b;

    public c(NetService r2) {
        this.b = "/api/suite/permission/apply_permission/";
        this.a = r2.Rb(new f().getType());
    }

    public final Flowable a(ApplyDocPermPuller.Params r10) {
        NetService.f r0 = new NetService.f(this.b);
        ((NetService.e) r0).c = 1;
        HashMap r2 = new HashMap();
        Field[] r4 = ApplyDocPermPuller.Params.class.getDeclaredFields();     // Catch: Exception -> L7
        int r5 = r4.length;     // Catch: Exception -> L7
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L9;
        Field r7 = r4[r6];     // Catch: Exception -> L7
        r7.setAccessible(true);     // Catch: Exception -> L7
        r2.put(r7.getName(), String.valueOf(r7.get(r10)));     // Catch: Exception -> L7
        r6 = r6 + 1;
    L9:
        r0.d(r2);
        return this.a.a(r0).map(new b()).onErrorResumeNext(new a());
    L7:
        e = move-exception;
        tt5.a.e("BasePuller", "parse obj to map fail. ", e, false);
        goto L9
    }
}
