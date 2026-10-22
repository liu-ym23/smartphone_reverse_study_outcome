package zx;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lzx/a;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "scheme", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f573866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f573867b = null;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("scheme")
    private final String scheme;

    /* JADX INFO: renamed from: zx.a$a, reason: collision with other inner class name */
    public static final class C8502a {
    }

    static {
        f573866a = new a();
        f573867b = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_wallet_douyin%2Fpages%2Frecharge%2Fpanel%2Fcustom%2Ftemplate.js&type=popup&height_percent=100&gravity=bottom&mix_container_type=annie&group=webcast_revenue&use_storage_group=1";
    }

    public a() {
        this.scheme = f573867b;
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.scheme;
    }
}
