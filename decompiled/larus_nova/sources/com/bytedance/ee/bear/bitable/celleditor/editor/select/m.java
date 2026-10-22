package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmptyData f209509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f209510b;

    public m(EmptyData r100, i r101) {
        this.f209509a = r100;
        this.f209510b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SimpleItemModel r101 = this.f209509a.getButton();
        if (r101 == null) goto L10;
        ActionPayload r102 = r101.getClickActionPayload();
        if (r102 == null) goto L11;
        e r103 = this.f209510b.f209475q;
        if (r103 == null) goto L12;
        r103.a(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
