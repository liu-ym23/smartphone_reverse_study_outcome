package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity> f207607a;

    public k(f<IChatterEntity> r100) {
        this.f207607a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L5;
    L8:
        this.f207607a.hideKeyboard();
        return true;
    L5:
        if (r101 == 6) goto L8;
        return false;
    }
}
