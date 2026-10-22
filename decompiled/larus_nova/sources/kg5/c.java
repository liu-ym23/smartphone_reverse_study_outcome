package kg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyDocPermPuller;
import com.bytedance.ee.bear.middleground.permission.apply.f;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c<PARAMS extends NonProguard, RESULT extends NonProguard> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService.d<Result<RESULT>> f503372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503373b;

    public c(NetService r100) {
        this.f503373b = "/api/suite/permission/apply_permission/";
        this.f503372a = r100.Rb(new f().getType());
    }

    public final Flowable a(ApplyDocPermPuller.Params r110) {
        NetService.f r100 = new NetService.f(this.f503373b);
        r100.f216906c = 1;
        HashMap r101 = new HashMap();
        Field[] r102 = ApplyDocPermPuller.Params.class.getDeclaredFields();     // Catch: Exception -> L7
        int r103 = r102.length;     // Catch: Exception -> L7
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        Field r105 = r102[r104];     // Catch: Exception -> L7
        r105.setAccessible(true);     // Catch: Exception -> L7
        r101.put(r105.getName(), String.valueOf(r105.get(r110)));     // Catch: Exception -> L7
        r104 = r104 + 1;
    L9:
        r100.d(r101);
        return this.f503372a.a(r100).map(new b()).onErrorResumeNext(new a());
    L7:
        e = move-exception;
        tt5.a.e("BasePuller", "parse obj to map fail. ", e, false);
        goto L9
    }
}
