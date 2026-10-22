package com.larus.bmhome.chat.component.bottom.attachment;

import com.alibaba.gaiax.render.view.basic.GXImageView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {
    public static final String a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder("imageId=");
        r101.append(r100.f298117b);
        r101.append(", source=");
        r101.append(b(r100.f298118c));
        r101.append(", baseScene=");
        r101.append(r100.f298119d);
        r101.append(", bizScene=");
        r101.append(r100.f298120e);
        r101.append(", useDraft=");
        r101.append(r100.f298122g);
        r101.append(", allowDetection=");
        r101.append(!r100.f298122g);
        return r101.toString();
    }

    public static final String b(a r100) {
        if ((r100 instanceof a.b) == false) goto L6;
        return GXImageView.LOCAL_PREFIX + ((a.b) r100).f298082a;
    L6:
        if ((r100 instanceof a.c) == false) goto L9;
        return "remote:" + ((a.c) r100).f298083a;
    L9:
        if ((r100 instanceof a.C4030a) == true) goto L18;
        if (r100 != null) goto L15;
        return "none";
    L15:
        throw new NoWhenBranchMatchedException();
    L18:
        return "drive:" + ((a.C4030a) r100).f298081a;
    }
}
