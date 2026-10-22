package r11;

import com.bytedance.android.live.revlink.impl.config.PkTipStrategySerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(PkTipStrategySerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/s;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s extends vh7.j<s> {

    @JsonAdapter(PkTipStrategySerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "restore_tip")
    String F2();

    @FieldName(name = "follow_update_tip")
    String X2();

    @FieldName(name = "follow_show_interval")
    long Y0();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
    int getInterval();
}
