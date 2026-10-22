package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartAutoMatchParamModelSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(StartAutoMatchParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw20/ze;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ze extends vh7.j<ze> {

    @JsonAdapter(StartAutoMatchParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "matchStyleType")
    int W4();

    @FieldName(name = "activityType")
    String getActivityType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "matchType")
    int getMatchType();

    @FieldName(name = "scene")
    int getScene();

    @FieldName(name = "source")
    String getSource();
}
