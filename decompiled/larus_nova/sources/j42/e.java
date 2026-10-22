package j42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends l<HighlightItem.a> {
    public e(HighlightItem.a r100) {
        Intrinsics.checkNotNullParameter(r100, "answer");
        super(PinType.Answer, r100, r100.b());
    }
}
