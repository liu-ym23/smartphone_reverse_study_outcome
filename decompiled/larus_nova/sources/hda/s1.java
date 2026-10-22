package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class s1 {
    public static final String a(q0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f484745f != MemoryReviewFeedbackState.SUBMITTED) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
    L13:
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L13;
        return r101;
    }
}
