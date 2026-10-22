package dl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldl/a;", "", "", "enableJisoo", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "uid", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "enableLoop", "b", "", "loopIntervalRaw", "I", "getLoopIntervalRaw", "()I", "ec-local-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable_jisoo")
    private final boolean enableJisoo;

    @SerializedName("enable_loop")
    private final boolean enableLoop;

    @SerializedName("loop_interval")
    private final int loopIntervalRaw;

    @SerializedName("uid")
    private final String uid;

    public a() {
        this(0);
    }

    public final int c() {
        int r100 = this.loopIntervalRaw;
        if (r100 >= 1) goto L5;
        return 1;
    L5:
        return r100;
    }

    public final boolean a() {
        return this.enableJisoo;
    }

    public final boolean b() {
        return this.enableLoop;
    }

    public final String d() {
        return this.uid;
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter("", "uid");
        this.enableJisoo = false;
        this.uid = "";
        this.enableLoop = false;
        this.loopIntervalRaw = 3;
    }
}
