package lk9;

import com.larus.media.MediaState;
import com.larus.media.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f509625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaState f509626b;

    public e(v r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f509625a = r100;
        this.f509626b = MediaState.DEFAULT;
    }
}
