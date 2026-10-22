package rk4;

import com.ttnetuploader.uploader.request_protocol.UploaderRequestLan;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import vk4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Interceptor {
    public a() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) throws IOException {
        Request.Builder r101 = r100.request().newBuilder();
        ak4.a r102 = f.f555491c;
        f r103 = f.a.f555494a;
        r103.getClass();
        HashMap r104 = new HashMap();
        String r105 = r103.f555492a.f555501g;
        if (r105 == null) goto L8;
        if (r105.isEmpty() == true) goto L8;
        r104.put(UploaderRequestLan.LAN_SN, r103.f555492a.f555501g);
    L8:
        return r100.proceed(r101.headers(Headers.of(r104)).build());
    }
}
