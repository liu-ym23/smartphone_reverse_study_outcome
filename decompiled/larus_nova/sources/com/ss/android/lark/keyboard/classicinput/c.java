package com.ss.android.lark.keyboard.classicinput;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;
import ncc.d;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f428696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f428697c;

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f428696b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f428696b = r100.hashCode();
        EllipsizedEmojiconTextView r101 = this.f428697c.f428648m;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r101 = null;
    L9:
        r100.setTint(r101.getCurrentTextColor());
        super.invalidateDrawable(r100);
    }

    public c(a r100, EllipsizedEmojiconTextView r101) {
        this.f428697c = r100;
        super(r101);
    }
}
