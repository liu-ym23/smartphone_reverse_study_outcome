package mb1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.component.lyric.model.b> f512764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.soloktv.template.timeline.a f512765b;

    public final com.bytedance.android.live.soloktv.template.timeline.a getContext() {
        return this.f512765b;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "lyricsFactory");
        new LinkedHashMap();
        this.f512764a = r100.f512772g;
        new ArrayList();
    }
}
