package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class u extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f430426b;

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (r100.hashCode() != this.f430426b) goto L6;
        super.invalidateDrawable(r100);
        return;
    L6:
        r100.mutate();
        this.f430426b = r100.hashCode();
        throw null;
    }

    public u(v r100, EllipsizedEmojiconTextView r101) {
        super(r101);
    }
}
