package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements TextWatcher {
    public boolean a;
    public final /* synthetic */ ECSearchBar b;
    public final /* synthetic */ LiveFlashSearchDialogFragment c;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L19;
        View r6 = this.c.ia0(2131377932);
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        this.b.hideClear();
        LiveFlashSearchViewModel r7 = this.c.g;
        if (r7 == null) goto L17;
        r7.showOriginData();
    L17:
        this.a = false;
        return;
    L19:
        if (this.a == true) goto L23;
        LiveFlashSearchDialogFragment r8 = this.c;
        int r1 = LiveFlashSearchDialogFragment.o;
        LiveFlashSearchViewModel r9 = r8.g;
        if (r9 == null) goto L23;
        r9.hideDate();
    L23:
        View r10 = this.c.ia0(2131377932);
        if (r10 == null) goto L26;
        r10.setVisibility(4);
    L26:
        this.b.showClear();
        LiveFlashSearchDialogFragment.ja0(this.c);
        this.a = true;
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L10
    }

    public c(ECSearchBar r1, LiveFlashSearchDialogFragment r2) {
        this.b = r1;
        this.c = r2;
    }
}
