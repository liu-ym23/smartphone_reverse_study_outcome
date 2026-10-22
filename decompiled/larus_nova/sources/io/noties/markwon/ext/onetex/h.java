package io.noties.markwon.ext.onetex;

import com.larus.business.markdown.api.model.ImageSpanStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends wsc.a {
    public h(String r100, j r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r101, "loader");
        Intrinsics.checkNotNullParameter(r102, "imageSizeResolver");
        super(r100, r101, r102);
        ImageSpanStatus r103 = ImageSpanStatus.IDLE;
    }
}
