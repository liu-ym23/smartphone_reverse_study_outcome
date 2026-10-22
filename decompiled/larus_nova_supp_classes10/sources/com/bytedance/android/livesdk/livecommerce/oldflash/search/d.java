package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.View;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ECSearchBar a;

    public d(ECSearchBar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.setText("");
        this.a.clearEditFocus();
    }
}
