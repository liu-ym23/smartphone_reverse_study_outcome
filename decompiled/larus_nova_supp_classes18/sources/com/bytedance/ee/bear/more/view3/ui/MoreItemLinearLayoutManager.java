package com.bytedance.ee.bear.more.view3.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.util.ui.n;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MoreItemLinearLayoutManager extends LinearLayoutManagerWrapper {
    public final RecyclerView a;
    public final boolean b;

    public MoreItemLinearLayoutManager(Context r2, RecyclerView r3, boolean r4) {
        super(r2, 0);
        this.a = r3;
        this.b = r4;
    }

    public final void measureChildWithMargins(View r6, int r7, int r8) {
        if (this.b == false) goto L6;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChildWithMargins(r6, r7, r8);
        return;
    L6:
        int r0 = ((View) this.a.getParent()).getMeasuredWidth() - (n.d(18) * 2);
        if (r0 > 0) goto L10;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChildWithMargins(r6, r7, r8);
        return;
    L10:
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) r6.getLayoutParams();
        RecyclerView.Adapter r2 = this.a.getAdapter();
        if (r2 != null) goto L14;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChildWithMargins(r6, r7, r8);
        return;
    L14:
        int r3 = r2.getItemCount();
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), ((i0) org.koin.java.a.a(i0.class)).a()) == false) goto L17;
        if (r3 > 4) goto L24;
        int r4 = (r0 - (n.d(4) * 6)) / 4;
    L27:
        ((ViewGroup.MarginLayoutParams) r1).width = r4;
        r6.setLayoutParams(r1);
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChildWithMargins(r6, r7, r8);
        return;
    L24:
        if (r3 < 5) goto L26;
        r4 = Math.max((int) ((r0 - (n.d(4) * 8)) / 4.35f), n.d(72));
    L26:
        r4 = 0;
        goto L27
    L17:
        if (r3 > 3) goto L19;
        r4 = (r0 - (n.d(4) * 4)) / 3;
        goto L27
    L19:
        if (r3 < 4) goto L26;
        r4 = Math.max((int) ((r0 - (n.d(4) * 6)) / 3.35f), n.d(96));
        goto L27
    }
}
