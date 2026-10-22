package r11;

import com.bytedance.android.live.revlink.impl.config.AnchorLinkOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(AnchorLinkOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/b;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.j<b> {

    @JsonAdapter(AnchorLinkOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "list_retry_enable")
    boolean C6();

    @FieldName(name = "multi_match_opt")
    boolean T2();

    @FieldName(name = "check_list_version")
    boolean W1();

    @FieldName(name = "battle_stats_retry_enable")
    boolean h0();

    @FieldName(name = "list_invalid_retry_enable")
    boolean j3();

    @FieldName(name = "pk_invite_failed_opt")
    boolean k0();

    @FieldName(name = "invite_panel_show_opt")
    boolean o1();

    @FieldName(name = "couple_be_invited_opt")
    boolean t3();

    @FieldName(name = "link_reset_opt")
    boolean y3();
}
