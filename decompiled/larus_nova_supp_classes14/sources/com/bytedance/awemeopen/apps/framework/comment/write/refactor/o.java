package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends AbstractUIModule<l> {
    public View e;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final View b(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        return r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final n a() {
        return new n(this);
    }

    public o(g r2) {
        Intrinsics.checkNotNullParameter(r2, "inputContext");
        super(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final void c(View r2, CommentColorMode r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "colorMode");
        this.e = r2;
    }
}
