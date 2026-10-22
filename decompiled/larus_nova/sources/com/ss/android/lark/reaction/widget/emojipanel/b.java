package com.ss.android.lark.reaction.widget.emojipanel;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiPageNewFragment2 f439364a;

    public b(EmojiPageNewFragment2 r100) {
        this.f439364a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WeakReference<c> r101 = this.f439364a.f439344d;
        if (r101 == null) goto L8;
        c r102 = r101.get();
        if (r102 == null) goto L9;
        r102.c();
        return;
    L9:
        return;
    }
}
