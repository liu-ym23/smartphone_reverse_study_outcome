package w20;

import com.bytedance.android.live.browser.jsbridge.base.HandlePkNativeViewParamModelSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(HandlePkNativeViewParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lw20/y9;", "Lvh7/j;", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y9 extends vh7.j<y9> {

    @JsonAdapter(HandlePkNativeViewParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "play_widget_type")
    int Z4();

    @FieldName(name = "data")
    List<String> getData();

    @FieldName(name = "type")
    int getType();
}
