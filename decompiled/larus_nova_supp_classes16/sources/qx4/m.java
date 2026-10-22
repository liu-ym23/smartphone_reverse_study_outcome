package qx4;

import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import sa5.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m extends u {
    public final /* synthetic */ RequestListFragment a;
    public final /* synthetic */ View b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        if (r3 == null) goto L5;
        String r4 = r3.toString();
        if (r4 == null) goto L5;
    L6:
        RequestListFragment.U90(this.a, r4);
        ImageView r0 = (ImageView) this.b.findViewById(2131366930);
        int r1 = 0;
        if (r4.length() != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        r1 = 8;
    L12:
        r0.setVisibility(r1);
        return;
    L9:
        r5 = false;
    L5:
        r4 = "";
        goto L6
    }

    public m(RequestListFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
