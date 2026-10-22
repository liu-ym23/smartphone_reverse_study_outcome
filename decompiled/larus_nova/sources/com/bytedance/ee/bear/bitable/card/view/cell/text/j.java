package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.view.ActionMode;
import android.view.MotionEvent;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextCellViewHolder f208256a;

    public j(TextCellViewHolder r100) {
        this.f208256a = r100;
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r100) {
        TextCellViewHolder r101 = this.f208256a;
        int r102 = TextCellViewHolder.V;
        ActionMode r103 = r101.N;
        if (r103 == null) goto L5;
        r103.finish();
    L5:
        r101.N = null;
        return false;
    }
}
