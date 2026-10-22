package n3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f516859a = 0;

    static {
    }

    public static OkHttpClient a(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "password");
        OkHttpClient.Builder r102 = new OkHttpClient.Builder();
        TimeUnit r103 = TimeUnit.SECONDS;
        return r102.connectTimeout(10, r103).readTimeout(10, r103).writeTimeout(10, r103).callTimeout(30, r103).addInterceptor(new a(r100, r101)).followRedirects(false).build();
    }
}
