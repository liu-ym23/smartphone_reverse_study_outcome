package i42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends l<HighlightItem.e> {
    public d(HighlightItem.e r100) {
        Intrinsics.checkNotNullParameter(r100, "microApp");
        super(PinType.MicroApp, r100, r100.getMessageId());
    }
}
