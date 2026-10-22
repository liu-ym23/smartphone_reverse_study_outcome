package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f412138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u5b.b f412139c;

    public a(EllipsizedEmojiconTextView r100) {
        this.f412139c = u5b.b.f548898e;
        super(r100);
    }

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f412138b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f412138b = r100.hashCode();
        r100.setTint(this.f412139c.f548900b);
        super.invalidateDrawable(r100);
    }
}
