package rp1;

import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeUserStatistics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f538833a = null;

    static {
        f538833a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ListResponse r101 = (ListResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        List<T> r102 = r101.data;
        if (r102 == null) goto L9;
        Episode r103 = (Episode) ListProtector.get(r102, 0);
        if (r103 == null) goto L9;
        EpisodeUserStatistics r104 = r103.userStatistics;
        if (r104 == null) goto L9;
        return Long.valueOf(r104.getWatchDuration());
    L9:
        return null;
    }
}
