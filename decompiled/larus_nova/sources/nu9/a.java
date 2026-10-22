package nu9;

import com.facebook.keyframes.model.KFImage;
import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/dora/AndroidConfig;", "", "<init>", "()V", "capabilities", "Lcom/larus/settings/provider/dora/CapabilitiesConfig;", "getCapabilities", "()Lcom/larus/settings/provider/dora/CapabilitiesConfig;", "setCapabilities", "(Lcom/larus/settings/provider/dora/CapabilitiesConfig;)V", KFImage.FEATURES_JSON_FIELD, "Lcom/larus/settings/provider/dora/FeaturesConfig;", SystemAppletMethod.METHOD_GET_FEATURES, "()Lcom/larus/settings/provider/dora/FeaturesConfig;", "setFeatures", "(Lcom/larus/settings/provider/dora/FeaturesConfig;)V", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("capabilities")
    private b capabilities;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private q features;

    public a() {
    }

    public final b a() {
        return this.capabilities;
    }

    public final q b() {
        return this.features;
    }

    public final void c(b r100) {
        this.capabilities = r100;
    }

    public final void d(q r100) {
        this.features = r100;
    }
}
