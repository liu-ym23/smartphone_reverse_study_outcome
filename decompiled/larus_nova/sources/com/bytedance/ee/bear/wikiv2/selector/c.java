package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FolderSelectAdapter f241147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f241148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Document f241149c;

    public c(FolderSelectAdapter r100, int r101, Document r102) {
        this.f241147a = r100;
        this.f241148b = r101;
        this.f241149c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FolderSelectAdapter.a r101 = this.f241147a.f241078d;
        if (r101 == null) goto L6;
        r101.a(r100, this.f241148b, this.f241149c);
        return;
    }
}
