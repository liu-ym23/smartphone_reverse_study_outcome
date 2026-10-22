package hda;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u1 {
    public static final int a(e1 r100) {
        Integer r101 = Integer.valueOf(r100.f484672r.size());
        if (r101.intValue() <= 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 != null) goto L11;
        return 1;
    L11:
        return r101.intValue();
    L5:
        r102 = false;
        goto L6
    }

    public static final com.obric.assistant.cocreationreview.d b(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "uiModel");
        int r101 = a(r100);
        if (r101 > 1) goto L7;
        return null;
    L7:
        return new com.obric.assistant.cocreationreview.d("待反馈 " + r101 + " 次", CardTemplateTagTone.WARNING, null, null, 28);
    }
}
