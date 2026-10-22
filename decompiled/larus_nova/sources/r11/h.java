package r11;

import com.bytedance.android.live.revlink.impl.config.LinkPushDegradeSettingSerializableObjectImpl;
import com.bytedance.android.live.revlink.impl.config.LinkPushDegradeSetting_PushConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(LinkPushDegradeSettingSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lr11/h;", "Lvh7/j;", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.j<h> {

    @JsonAdapter(LinkPushDegradeSettingSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(LinkPushDegradeSetting_PushConfigSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/h$b;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.j<b> {

        @JsonAdapter(LinkPushDegradeSetting_PushConfigSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "h")
        int getH();

        @FieldName(name = "w")
        int getW();

        @FieldName(name = "bitrate_kbps")
        int j();
    }

    @FieldName(name = "livecore_cap_enable")
    boolean F7();

    @FieldName(name = "enable_force")
    boolean f4();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "config")
    Map<Integer, b> k();

    @FieldName(name = "livecore_config")
    Map<Integer, b> n4();

    @FieldName(name = "livecore_cap_ratio_max")
    float q6();

    @FieldName(name = "livecore_cap_ratio_min")
    float z8();
}
