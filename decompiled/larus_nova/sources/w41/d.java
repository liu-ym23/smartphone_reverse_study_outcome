package w41;

import com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkSeiUnloadConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevLinkSeiUnloadConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw41/d;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends j<d> {

    @JsonAdapter(RevLinkSeiUnloadConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "unload_by_sei_ver_frequency_time")
    int A3();

    @FieldName(name = "unload_by_sei_source_time_limit")
    int B5();

    @FieldName(name = "unload_by_sei_source_count")
    int b2();

    @FieldName(name = "unload_by_sei_ver_time_limit")
    int h9();
}
