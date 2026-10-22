package rs1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lrs1/b;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "iconUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "d", "iconUrlLight", "b", "e", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("icon_url_light")
    private String iconUrlLight;

    @SerializedName("name")
    private String name;

    public final void e() {
        Intrinsics.checkNotNullParameter("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_exit_clean_screen_light.png", "<set-?>");
        this.iconUrlLight = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_exit_clean_screen_light.png";
    }

    public b() {
        this.name = "";
        this.iconUrl = "";
        this.iconUrlLight = "";
    }

    public final String a() {
        return this.iconUrl;
    }

    public final String b() {
        return this.iconUrlLight;
    }

    public final String c() {
        return this.name;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUrl = r100;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }
}
