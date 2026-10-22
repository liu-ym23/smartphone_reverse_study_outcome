package com.larksuite.framework.http.call;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f285573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ErrorResult f285574b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseResponse r100) {
            this.f285573a = r100;
        }

        public a(ErrorResult r100) {
            this.f285574b = r100;
        }
    }

    public static void a(z18.a r100, String r101) {
        StringBuilder r102 = new StringBuilder("X-BaseRequest-ID:");
        r102.append(r100.a().get("X-BaseRequest-ID"));
        r102.append(", request url:");
        r102.append(r100.b());
        r102.append(", statusCode:0");
        if (r101 != null) goto L5;
        Log.i(r100.f569683f, r102.toString());
        return;
    L5:
        Log.e(r100.f569683f, r102.toString(), new RuntimeException(r101));
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 22 */
    public static a b(Class r100, z18.a r101, final Response r110) {
        int r102 = r110.code();
        int r103 = r110.code();
        HashMap r104 = new HashMap();
        Headers r105 = r110.headers();
        if (r105 == null) goto L10;
        Iterator<String> r106 = r105.names().iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        String r107 = r106.next();
        List<String> r108 = r105.values(r107);
        if (CollectionUtils.isNotEmpty(r108) == false) goto L6;
        r104.put(r107, (String) ListProtector.get(r108, 0));
    L10:
        BaseResponse r109 = new BaseResponse(r103, r104, new CallProcessor$1(r110));
        r101.getClass();
        if (r102 >= 200) goto L13;
    L30:
        String r111 = r109.message();     // Catch: IOException -> L22
    L25:
        if (TextUtils.isEmpty(r111) == false) goto L27;
        r111 = "http status code:" + r102 + " server error";
        int r112 = -2;
    L29:
        return new a(new ErrorResult(r112, r102, r111));
    L27:
        r112 = -3;
    L22:
        e = move-exception;
        e.printStackTrace();
        r111 = null;
        goto L25
    L13:
        if (r102 >= 300) goto L30;
        return new a(r109);
    }
}
