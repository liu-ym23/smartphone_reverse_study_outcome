package r11;

import com.bytedance.android.live.revlink.impl.config.InvitePreloadStrategySerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(InvitePreloadStrategySerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/d;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.j<d> {

    @JsonAdapter(InvitePreloadStrategySerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "check_never_open_invite")
    boolean B2();

    @FieldName(name = "check_pk_time")
    boolean J1();

    @FieldName(name = "check_active_user")
    boolean O5();

    @FieldName(name = "check_mute_state")
    boolean X();

    @FieldName(name = "aggressive_preload")
    boolean l4();
}
