package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements TextView.OnEditorActionListener {
    public final /* synthetic */ ECSearchBar a;
    public final /* synthetic */ LiveFlashSearchDialogFragment b;

    public b(ECSearchBar r1, LiveFlashSearchDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L6;
        LiveFlashSearchDialogFragment.ja0(this.b);
        ECSearchBar r4 = this.a;
        r4.hideSoftInput(r4);
        return true;
    L6:
        return false;
    }
}
