package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.view.View;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MentionPanelListView f298910a;

    public e0(MentionPanelListView r100) {
        this.f298910a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        MentionPanelListView.b(this.f298910a);
    }
}
