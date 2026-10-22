package e42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends l<HighlightItem.c> {
    public b(HighlightItem.c r100) {
        Intrinsics.checkNotNullParameter(r100, "comment");
        super(PinType.Comment, r100, r100.getMessageId());
    }
}
