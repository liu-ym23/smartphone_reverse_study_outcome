package com.obric.assistant.window;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricMsgComponent f394915a;

    public /* synthetic */ l(ObricMsgComponent r100) {
        this.f394915a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricMsgComponent r100 = this.f394915a;
        int r101 = 0;
        r100.F = false;
        RecyclerView r102 = r100.z3();
        if (r102 == null) goto L8;
        r100.E = r102.getWidth();
        int r103 = r102.getChildCount();
    L6:
        if (r101 >= r103) goto L10;
        r100.G3(r102.getChildAt(r101));
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }
}
