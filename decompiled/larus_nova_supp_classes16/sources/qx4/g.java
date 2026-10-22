package qx4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends t {
    public final /* synthetic */ View c;

    public g(View r1) {
        this.c = r1;
    }

    public final void a(View r3) {
        if (((TextView) this.c.findViewById(2131384432)).getVisibility() != 0) goto L5;
        ((TextView) this.c.findViewById(2131384432)).setVisibility(8);
        ((ImageView) this.c.findViewById(2131384430)).setImageResource(2131254333);
        return;
    L5:
        ((TextView) this.c.findViewById(2131384432)).setVisibility(0);
        ((ImageView) this.c.findViewById(2131384430)).setImageResource(2131254326);
    }
}
