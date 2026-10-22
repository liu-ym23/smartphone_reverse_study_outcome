package z34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T extends v34.b<T>> implements y34.a<T> {
    public d() {
    }

    @Override // y34.a
    public final y34.b a(AosAwemePreloadModel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = r100.id();
        if (r101 != null) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return new y34.b(true, "PreloadModel id is empty!");
    L14:
        return new y34.b(false, "");
    L5:
        if (r101.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L10;
        r102 = true;
        goto L11
    L7:
        r103 = false;
        goto L8
    }
}
