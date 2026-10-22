package com.ss.android.lark.keyboard.editor.input;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class z extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f428916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RichTextInputShrinkPlugin f428917c;

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f428916b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f428916b = r100.hashCode();
        EllipsizedEmojiconTextView r101 = this.f428917c.T;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r101 = null;
    L9:
        r100.setTint(r101.getCurrentTextColor());
        super.invalidateDrawable(r100);
    }

    public z(RichTextInputShrinkPlugin r100, EllipsizedEmojiconTextView r101) {
        this.f428917c = r100;
        super(r101);
    }
}
