package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f412669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f412670c;

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f412669b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f412669b = r100.hashCode();
        r100.setTint(this.f412670c);
        super.invalidateDrawable(r100);
    }

    public d(ThreadReplyExposureView r100, int r101) {
        this.f412670c = r101;
        super(r100);
    }
}
