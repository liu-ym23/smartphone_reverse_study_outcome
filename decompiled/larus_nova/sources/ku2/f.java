package ku2;

import com.bytedance.android.live.base.model.message.k4;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lku2/f;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/k4;", "Lku2/a;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSCameraInfo;", "getCameraInfos", "()Ljava/util/List;", "getCameraInfos$annotations", "()V", "cameraInfos", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface f extends vh7.e<k4>, k4, ku2.a {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.k4, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.k4, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "camera_infos")
    List<VSCameraInfo> getCameraInfos();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ int randomTime();

    /* synthetic */ String returnMainMessage();

    /* synthetic */ void setReturnMainMessage(String r100);
}
