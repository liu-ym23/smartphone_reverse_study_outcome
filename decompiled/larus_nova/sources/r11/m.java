package r11;

import com.bytedance.android.live.revlink.impl.config.LiveRandomPkTitleConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(LiveRandomPkTitleConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/m;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.j<m> {

    @JsonAdapter(LiveRandomPkTitleConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "game_match_popup_message")
    String C8();

    @FieldName(name = "expand_scope_popup_message")
    String I7();

    @FieldName(name = "pk_value_popup_message")
    String i8();
}
