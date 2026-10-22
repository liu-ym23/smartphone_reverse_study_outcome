package nu9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/settings/provider/dora/RtcCapabilityConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "supportLink", "", "", "getSupportLink", "()Ljava/util/List;", "setSupportLink", "(Ljava/util/List;)V", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a0 {

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("support_link")
    private List<String> supportLink;

    public a0() {
    }

    public final Boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.supportLink;
    }

    public final void c(Boolean r100) {
        this.enable = r100;
    }

    public final void d(List<String> r100) {
        this.supportLink = r100;
    }
}
