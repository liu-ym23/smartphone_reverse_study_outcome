package er1;

import com.bytedance.android.live.base.model.message.f3;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Ler1/a;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/f3;", "Lku2/a;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "getPoints", "()Ljava/util/List;", "getPoints$annotations", "()V", "points", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface a extends e<f3>, f3, ku2.a {

    /* JADX INFO: renamed from: er1.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class C5804a {
    }

    @Override // com.bytedance.android.live.base.model.message.f3, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.f3, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    /* synthetic */ m0 getBaseMessage();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "points")
    List<EpisodeHighLight> getPoints();

    /* synthetic */ long getTargetSei();
}
