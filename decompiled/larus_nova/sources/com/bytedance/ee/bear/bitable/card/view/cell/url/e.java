package com.bytedance.ee.bear.bitable.card.view.cell.url;

import android.text.TextUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlCellViewHolder f208302a;

    public e(UrlCellViewHolder r100) {
        this.f208302a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        db5.a r101 = (db5.a) r100;
        bo4.a[] r102 = r101.f467805b;
        if (r102.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == false) goto L9;
        String r104 = r102[0].f19816f;
    L22:
        if (r104 == null) goto L25;
        UrlCellViewHolder r105 = this.f208302a;
        int r106 = UrlCellViewHolder.S;
        r105.W4(r104);
        return;
    L25:
        return;
    L9:
        db5.j[] r107 = r101.f467806c;
        if (r107.length != 0) goto L12;
        boolean r108 = true;
    L14:
        if ((!r108) == false) goto L21;
        db5.j r109 = r107[0];
        if ((r109 instanceof r) == false) goto L20;
        r r110 = (r) r109;
        if (TextUtils.isEmpty(r110.f208348e) == true) goto L20;
        r104 = r110.f208348e;
    L20:
        r104 = r109.f467829d;
        goto L22
    L21:
        r104 = "";
        goto L22
    L12:
        r108 = false;
        goto L14
    L5:
        r103 = false;
        goto L7
    }
}
