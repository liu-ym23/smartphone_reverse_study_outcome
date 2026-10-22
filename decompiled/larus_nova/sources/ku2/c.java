package ku2;

import com.bytedance.android.live.base.model.message.p5;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lku2/c;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/p5;", "Lku2/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "getLinkedRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "setLinkedRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;)V", "getLinkedRoomInfo$annotations", "()V", "linkedRoomInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface c extends vh7.e<p5>, p5, ku2.a {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.p5, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.p5, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "link_info")
    VSLinkedRoomInfo getLinkedRoomInfo();

    @FieldName(name = "link_info#setter")
    void setLinkedRoomInfo(VSLinkedRoomInfo r100);
}
