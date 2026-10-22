package r41;

import com.bytedance.android.live.revlink.impl.settings.config.LiveRevenueVolumeIndicatorConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(LiveRevenueVolumeIndicatorConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr41/e;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.j<e> {

    @JsonAdapter(LiveRevenueVolumeIndicatorConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "change_threshold")
    int H2();

    @FieldName(name = "enabled")
    boolean getEnabled();
}
