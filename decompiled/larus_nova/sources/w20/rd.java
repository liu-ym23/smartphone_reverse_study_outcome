package w20;

import com.bytedance.android.live.browser.jsbridge.base.RevenueSetRtcEffectEnableParamModelSerializableObjectImpl;
import com.bytedance.android.live.browser.jsbridge.base.RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(RevenueSetRtcEffectEnableParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lw20/rd;", "Lvh7/j;", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface rd extends vh7.j<rd> {

    @JsonAdapter(RevenueSetRtcEffectEnableParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw20/rd$b;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.j<b> {

        @JsonAdapter(RevenueSetRtcEffectEnableParamModel_RevenueSetRtcEffectEnableExtraSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "rtcKey")
        String G();

        @FieldName(name = "layoutKey")
        String c();

        @FieldName(name = "nodePaths")
        List<String> w();
    }

    @FieldName(name = "enable")
    Boolean getEnable();

    @FieldName(name = "extra")
    b getExtra();

    @FieldName(name = "scene")
    String getScene();
}
