package x83;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ll.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final View a;
    public final int b;
    public final Map.Entry<String, c> c;

    public b(View r2, int r3, Map.Entry<String, c> r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "regionInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
