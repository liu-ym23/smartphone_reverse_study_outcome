package l60;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Ll60/b;", "", "", "mEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setMEnable", "(Z)V", "mEnableLayerLoad", "c", "setMEnableLayerLoad", "mEnableTetris", "d", "setMEnableTetris", "mEnableElementLoad", "b", "setMEnableElementLoad", "mEnableElementSettingOpt", "getMEnableElementSettingOpt", "setMEnableElementSettingOpt", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enable")
    private boolean mEnable;

    @SerializedName("enable_element_load")
    private boolean mEnableElementLoad;

    @SerializedName("enable_element_setting_opt")
    private boolean mEnableElementSettingOpt;

    @SerializedName("enable_layer_load")
    private boolean mEnableLayerLoad;

    @SerializedName("enable_tetris")
    private boolean mEnableTetris;

    public b() {
    }

    public final boolean a() {
        return this.mEnable;
    }

    public final boolean b() {
        return this.mEnableElementLoad;
    }

    public final boolean c() {
        return this.mEnableLayerLoad;
    }

    public final boolean d() {
        return this.mEnableTetris;
    }
}
