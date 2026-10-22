package k42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends l<HighlightItem.f> {
    public c(HighlightItem.f r100) {
        Intrinsics.checkNotNullParameter(r100, "video");
        super(PinType.Video, r100, r100.getMessageId());
    }
}
