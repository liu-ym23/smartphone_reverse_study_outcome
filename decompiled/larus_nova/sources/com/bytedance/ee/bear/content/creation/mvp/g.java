package com.bytedance.ee.bear.content.creation.mvp;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f216875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f216876b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f216875a.getChildCount() <= 0) goto L7;
        this.f216875a.getViewTreeObserver().removeOnPreDrawListener(this);
        SelectCreationMenuViewModel r100 = this.f216876b.f216890n;
        if (r100 == null) goto L7;
        r100.setSelectCreationMenuState(1);
    L7:
        return true;
    }

    public g(h r100, RecyclerView r101) {
        this.f216876b = r100;
        this.f216875a = r101;
    }
}
