package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f412169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u5b.c f412170c;

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f412169b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f412169b = r100.hashCode();
        r100.setTint(this.f412170c.f548905b);
        super.invalidateDrawable(r100);
    }

    public a(u5b.c r100, EllipsizedEmojiconTextView r101) {
        this.f412170c = r100;
        super(r101);
    }
}
