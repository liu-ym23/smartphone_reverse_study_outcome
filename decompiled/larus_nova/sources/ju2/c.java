package ju2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lju2/c;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAppearance;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;", "getToolbarConfigList", "()Ljava/util/List;", "setToolbarConfigList", "(Ljava/util/List;)V", "getToolbarConfigList$annotations", "()V", "toolbarConfigList", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface c extends vh7.e<IRoomAppearance>, IRoomAppearance {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "toolbar_list")
    List<IVSToolbarConfigData> getToolbarConfigList();

    @FieldName(name = "toolbar_list#setter")
    void setToolbarConfigList(List<? extends IVSToolbarConfigData> r100);
}
