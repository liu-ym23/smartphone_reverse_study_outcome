package z34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T extends v34.b<T>> implements y34.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a44.a<T> f569872a;

    public a(a44.b r100) {
        Intrinsics.checkNotNullParameter(r100, "producerConsumerQueue");
        this.f569872a = r100;
    }

    @Override // y34.a
    public final y34.b a(AosAwemePreloadModel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a44.a<T> r101 = this.f569872a;
        String r102 = r100.id();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r101.contains(r102) == false) goto L9;
        return new y34.b(true, "preload model already in producerConsumerQueue,wait to been proceed!");
    L9:
        return new y34.b(false, "");
    }
}
