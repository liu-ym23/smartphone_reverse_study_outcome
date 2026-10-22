package d59;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.t1;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/entity/SingleProductDisplayEntity;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "imageLink", "Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "batteryInfo", "Lcom/larus/dora/impl/dynamic/BatteryInfo;", "getBatteryInfo", "()Lcom/larus/dora/impl/dynamic/BatteryInfo;", "shouldVisible", "", PTYSocketStateCallback.CONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l implements j {

    @SerializedName("battery_info")
    private final com.larus.dora.impl.dynamic.b batteryInfo;

    @SerializedName("image_link")
    private final t1 imageLink;

    public l() {
    }

    @Override // d59.j
    public final boolean a(boolean r100) {
        return true;
    }

    public final com.larus.dora.impl.dynamic.b b() {
        return this.batteryInfo;
    }

    public final t1 c() {
        return this.imageLink;
    }
}
