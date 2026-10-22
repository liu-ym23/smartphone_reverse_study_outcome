package com.bytedance.awemeopen.apps.framework.comment.write.arch.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.n;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbstractUIModule<F extends a> {
    public final wy3.a a;
    public View b;
    public final Lazy c;
    public View d;

    public abstract n a();

    public abstract View b(Context r1, View r2);

    public abstract void c(View r1, CommentColorMode r2);

    public final Context getContext() {
        wy3.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    public AbstractUIModule(wy3.a r1) {
        this.a = r1;
        this.c = LazyKt.lazy(new AbstractUIModule$viewProvider$2(this));
    }
}
