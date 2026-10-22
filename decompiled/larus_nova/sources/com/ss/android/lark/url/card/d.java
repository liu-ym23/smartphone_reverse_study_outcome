package com.ss.android.lark.url.card;

import android.view.View;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardContext f444618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f444619b;

    public d(CardContext r100, View r101) {
        this.f444618a = r100;
        this.f444619b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        CardContext r101 = this.f444618a;
        if (r101 == null) goto L5;
        ICardDependency r102 = r101.getDependency();
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        return this.f444618a.getDependency().onLongClicked(this.f444619b);
    L5:
        r102 = null;
        goto L6
    }
}
