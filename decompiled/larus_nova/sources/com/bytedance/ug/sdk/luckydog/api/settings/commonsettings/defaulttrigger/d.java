package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends xk7.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<Function2<Integer, Integer, Unit>> f271623c = null;

    public static final class a implements Interceptor {
        public a() {
        }

        @Override // com.bytedance.retrofit2.intercept.Interceptor
        public final SsResponse<?> intercept(Interceptor.Chain r100) {
            if (r100 == null) goto L20;
            Request r101 = r100.request();
            if (r101 == null) goto L20;
            SsResponse<?> r102 = r100.proceed(r101);
            JSONObject r103 = new JSONObject(r102.body().toString()).optJSONObject("act_common");     // Catch: Exception -> L23
            Iterator<Function2<Integer, Integer, Unit>> r104 = d.f271623c.iterator();     // Catch: Exception -> L23
        L7:
            if (r104.hasNext() == false) goto L18;
            Function2<Integer, Integer, Unit> r105 = r104.next();     // Catch: Exception -> L23
            int r106 = 0;
            if (r103 == null) goto L12;
            int r107 = r103.optInt("static_settings_version");     // Catch: Exception -> L23
        L13:
            Integer r108 = Integer.valueOf(r107);     // Catch: Exception -> L23
            if (r103 == null) goto L16;
            r106 = r103.optInt("dynamic_settings_version");     // Catch: Exception -> L23
        L16:
            r105.invoke(r108, Integer.valueOf(r106));     // Catch: Exception -> L23
            goto L7
        L12:
            r107 = 0;
        L18:
            return r102;
        L20:
            if (r100 != null) goto L22;
            return null;
        L22:
            return r100.proceed(null);
        }
    }

    public static final class b {
    }

    static {
        f271623c = new ArrayList();
        RetrofitUtils.addInterceptor(new a());
    }
}
