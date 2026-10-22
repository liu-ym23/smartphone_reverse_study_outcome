package lz6;

import com.larus.media.MediaScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class v implements ts6.d {
    public v() {
    }

    @Override // ts6.d
    public final void a() {
        Intrinsics.checkNotNullParameter(MediaScene.LOCAL_LIFE_VIDEO, "scene");
    }

    @Override // ts6.d
    public final void b(ts6.f r100, ts6.e r101) {
        Intrinsics.checkNotNullParameter(MediaScene.LOCAL_LIFE_VIDEO, "scene");
        if (r101 == null) goto L6;
        r101.onResult(true);
        return;
    }
}
