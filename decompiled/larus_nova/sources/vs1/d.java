package vs1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lvs1/d;", "", "", "useUnify", "Z", "getUseUnify", "()Z", "", "service", "I", "c", "()I", com.alipay.sdk.m.p.e.f25671s, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "scene", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556977a = 0;

    @SerializedName(com.alipay.sdk.m.p.e.f25671s)
    private final int method;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("service")
    private final int service;

    @SerializedName("use_unify")
    private final boolean useUnify;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public final boolean d() {
        if (this.useUnify == true) goto L5;
    L9:
        return false;
    L5:
        if (this.service <= 0) goto L9;
        if (this.method <= 0) goto L9;
        return true;
    }

    public final int a() {
        return this.method;
    }

    public final String b() {
        return this.scene;
    }

    public final int c() {
        return this.service;
    }
}
