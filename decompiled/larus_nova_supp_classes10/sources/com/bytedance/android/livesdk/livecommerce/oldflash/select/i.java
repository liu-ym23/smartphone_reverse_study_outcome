package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ LiveFlashMultiSelectDialogFragment a;

    public i(LiveFlashMultiSelectDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if ((!((List) r3).isEmpty()) == false) goto L7;
        ECTitleBar r4 = this.a.ia0(2131388807);
        if (r4 == null) goto L11;
        r4.setRightTextColor(th.a.a(r4.getContext(), 2131101694));
        r4.setRightTextClickListener(new h(this));
        return;
    L11:
        return;
    L7:
        ECTitleBar r5 = this.a.ia0(2131388807);
        if (r5 == null) goto L13;
        r5.setRightTextColor(th.a.a(r5.getContext(), 2131101695));
        r5.setRightTextClickListener(null);
        return;
    }
}
