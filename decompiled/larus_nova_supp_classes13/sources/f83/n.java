package f83;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public boolean a;
    public boolean b;
    public final View c;
    public final String d;
    public final String e;

    public n(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "title");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
