package hk6;

import com.bytedance.android.livesdk.interactivity.service.richcontent.config.LiveRichContentConfig;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends ek6.b>, b<? extends ek6.b>> f485574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.live.richcontent.utils.c f485575b;

    public final <T extends ek6.b> b<T> a(T r100) {
        b<T> r101 = (b) this.f485574a.get(r100.getClass());
        if (r101 == null) goto L5;
        return r101;
    L5:
        com.bytedance.live.richcontent.utils.c r102 = this.f485575b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "resource");
        r102.f255805a.error("onFindResourceLoaderFailed, resource is " + r100, null);
        return null;
    }

    public e(LiveRichContentConfig r100, com.bytedance.live.richcontent.utils.c r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        this.f485575b = r101;
        this.f485574a = MapsKt.toMap(r100.f140953d);
    }
}
