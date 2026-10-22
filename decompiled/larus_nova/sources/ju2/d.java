package ju2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\"\u0010\u0014\u001a\u00020\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0015"}, d2 = {"Lju2/d;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "", "isEnableEpisodeInteractive", "", "getSeek", "()J", "setSeek", "(J)V", "getSeek$annotations", "()V", "seek", "getInteractiveComponent", "setInteractiveComponent", "getInteractiveComponent$annotations", "interactiveComponent", "getSelectionEntrance", "setSelectionEntrance", "getSelectionEntrance$annotations", "selectionEntrance", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface d extends vh7.e<IRoomAuthStatus>, IRoomAuthStatus {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "InteractiveComponent")
    long getInteractiveComponent();

    @FieldName(name = "Seek")
    long getSeek();

    @FieldName(name = "Selection")
    long getSelectionEntrance();

    boolean isEnableEpisodeInteractive();

    @FieldName(name = "InteractiveComponent#setter")
    void setInteractiveComponent(long r100);

    @FieldName(name = "Seek#setter")
    void setSeek(long r100);

    @FieldName(name = "Selection#setter")
    void setSelectionEntrance(long r100);
}
