package w41;

import com.bytedance.android.live.revlink.impl.settings.live.model.RevAudienceSeiCheckConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevAudienceSeiCheckConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw41/a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: w41.a$a, reason: collision with other inner class name */
    @JsonAdapter(RevAudienceSeiCheckConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C8065a {
    }

    @FieldName(name = "report_control")
    boolean H3();

    @FieldName(name = "max_stack")
    int O4();

    @FieldName(name = "pk_illegal_report_control")
    boolean Z8();

    @FieldName(name = "wait_sei_threshold")
    long a1();

    @FieldName(name = "illegal_report_control")
    boolean q8();
}
