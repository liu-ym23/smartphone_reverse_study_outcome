package xs1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lxs1/e;", "", "", "enableBusinessBarrage", "Z", "b", "()Z", "setEnableBusinessBarrage", "(Z)V", "enableScreenBar", "c", "setEnableScreenBar", "", "businessDiscardDuration", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setBusinessDiscardDuration", "(I)V", "enableShowCountControl", "d", "setEnableShowCountControl", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("business_discard_duration")
    private int businessDiscardDuration;

    @SerializedName("enable_business_barrage")
    private boolean enableBusinessBarrage;

    @SerializedName("enable_screen_bar")
    private boolean enableScreenBar;

    @SerializedName("enable_show_count_control")
    private boolean enableShowCountControl;

    public e() {
        this.enableBusinessBarrage = true;
        this.enableScreenBar = true;
        this.businessDiscardDuration = 10;
        this.enableShowCountControl = true;
    }

    public final int a() {
        return this.businessDiscardDuration;
    }

    public final boolean b() {
        return this.enableBusinessBarrage;
    }

    public final boolean c() {
        return this.enableScreenBar;
    }

    public final boolean d() {
        return this.enableShowCountControl;
    }
}
