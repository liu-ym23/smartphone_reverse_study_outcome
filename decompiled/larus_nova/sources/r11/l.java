package r11;

import com.bytedance.android.live.revlink.impl.config.LivePkInviteConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(LivePkInviteConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/l;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l extends vh7.j<l> {

    @JsonAdapter(LivePkInviteConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "end_limit_interval")
    int A0();

    @FieldName(name = "live_pk_disable_frequency_control")
    boolean P7();

    @FieldName(name = "start_limit_interval")
    int R3();

    @FieldName(name = "continuous_refused_limit_interval")
    int T4();

    @FieldName(name = "rufused_limit_interval")
    int Y();

    @FieldName(name = "initiative_end_times_limit")
    int c7();

    @FieldName(name = "refused_times_limit")
    int l2();
}
