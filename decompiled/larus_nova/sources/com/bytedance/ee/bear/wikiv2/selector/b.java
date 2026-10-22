package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Document f241145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FolderSelectAdapter f241146b;

    public b(Document r100, FolderSelectAdapter r101) {
        this.f241145a = r100;
        this.f241146b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SelectorConfig.CREATOR.getClass();
        WeakReference<td5.a> r101 = SelectorConfig.f229368k;
        if (r101 == null) goto L8;
        td5.a r102 = r101.get();
        if (r102 == null) goto L9;
        r102.b(this.f241145a, this.f241146b.getContext());
        return;
    L9:
        return;
    }
}
