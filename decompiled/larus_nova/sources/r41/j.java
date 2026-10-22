package r41;

import com.bytedance.android.live.revlink.impl.settings.config.PkPropCardConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(PkPropCardConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr41/j;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.j<j> {

    @JsonAdapter(PkPropCardConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "live_pk_prop_card_enable")
    boolean G1();

    @FieldName(name = "live_pk_prop_card_threshold")
    int r5();

    @FieldName(name = "live_pk_prop_card_new_guide_count")
    int t2();
}
