package com.ss.android.lark.contact.customized.search.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f419424a;

    public e(String r100) {
        this.f419424a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r109 = (TextView) r100;
    L6:
        if (r109 != null) goto L8;
        return;
    L8:
        CharSequence r110 = TextUtils.ellipsize(this.f419424a, r109.getPaint(), RangesKt.coerceAtLeast((r109.getWidth() - r109.getPaddingLeft()) - r109.getPaddingRight(), 0), TextUtils.TruncateAt.END);
        if (Intrinsics.areEqual(r109.getHint(), r110) == true) goto L12;
        r109.setHint(r110);
        return;
    L12:
        return;
    L5:
        r109 = null;
        goto L6
    }
}
