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

/* JADX INFO: loaded from: classes18.dex */
public class MoreItemLinearLayoutManager extends LinearLayoutManagerWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f235040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f235041b;

    public MoreItemLinearLayoutManager(Context r100, RecyclerView r101, boolean r102) {
        super(r100, 0);
        this.f235040a = r101;
        this.f235041b = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.bytedance.android.ec.vlayout.b
    public final void measureChildWithMargins(View r100, int r101, int r102) {
        if (this.f235041b == false) goto L6;
        super.measureChildWithMargins(r100, r101, r102);
        return;
    L6:
        int r103 = ((View) this.f235040a.getParent()).getMeasuredWidth() - (n.d(18) * 2);
        if (r103 > 0) goto L10;
        super.measureChildWithMargins(r100, r101, r102);
        return;
    L10:
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        RecyclerView.Adapter r105 = this.f235040a.getAdapter();
        if (r105 != null) goto L14;
        super.measureChildWithMargins(r100, r101, r102);
        return;
    L14:
        int r106 = r105.getItemCount();
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), ((i0) org.koin.java.a.a(i0.class)).a()) == false) goto L17;
        if (r106 > 4) goto L24;
        int r107 = (r103 - (n.d(4) * 6)) / 4;
    L27:
        ((ViewGroup.MarginLayoutParams) r104).width = r107;
        r100.setLayoutParams(r104);
        super.measureChildWithMargins(r100, r101, r102);
        return;
    L24:
        if (r106 < 5) goto L26;
        r107 = Math.max((int) ((r103 - (n.d(4) * 8)) / 4.35f), n.d(72));
    L26:
        r107 = 0;
        goto L27
    L17:
        if (r106 > 3) goto L19;
        r107 = (r103 - (n.d(4) * 4)) / 3;
        goto L27
    L19:
        if (r106 < 4) goto L26;
        r107 = Math.max((int) ((r103 - (n.d(4) * 6)) / 3.35f), n.d(96));
        goto L27
    }
}
