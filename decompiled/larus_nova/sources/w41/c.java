package w41;

import com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkSeiBackupOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(RevLinkSeiBackupOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw41/c;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends j<c> {

    @JsonAdapter(RevLinkSeiBackupOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "unload_multi_by_source")
    boolean A4();

    @FieldName(name = "pk_backup_first_sei_opt")
    boolean F4();

    @FieldName(name = "sei_load_refactor")
    boolean O7();

    @FieldName(name = "unload_multi_by_sei_ver")
    boolean a4();

    @FieldName(name = "skip_check_opt")
    boolean a8();

    @FieldName(name = "closed_channel_opt")
    boolean c8();

    @FieldName(name = "sei_ver_max_count")
    int j9();

    @FieldName(name = "multi_backup_first_sei_opt")
    boolean k5();

    @FieldName(name = "switch_scene_skip_check_time")
    int z7();
}
