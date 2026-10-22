package c28;

import com.larksuite.framework.http.call.c;
import com.larksuite.framework.http.response.BaseResponse;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static BaseResponse a(x18.b r3, z18.a<BaseResponse> r4) {
        com.larksuite.framework.http.call.b r5 = r3.c(r4);
        r5.getClass();
        Object r0 = null;
        Response r1 = r5.c.execute();     // Catch: IOException -> L8
        r5.a.b();
        c.a r6 = c.b(BaseResponse.class, r5.a, r1);
        if (r6.b == null) goto L7;
        Log.e("CallImpl", "execute error = " + r6.b);
        c.a(r5.a, r6.b.getErrorMessage());
    L11:
        return (BaseResponse) r0;
    L7:
        c.a(r5.a, null);
        r0 = r6.a;
    L8:
        e = move-exception;
        e.printStackTrace();
        c.a(r5.a, e.getMessage());
        goto L11
    }
}
