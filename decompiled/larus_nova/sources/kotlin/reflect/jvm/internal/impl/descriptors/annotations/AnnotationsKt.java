package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations r100, Annotations r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        if (r100.isEmpty() == false) goto L6;
        return r101;
    L6:
        if (r101.isEmpty() == false) goto L9;
        return r100;
    L9:
        return new CompositeAnnotations(new Annotations[]{r100, r101});
    }
}
