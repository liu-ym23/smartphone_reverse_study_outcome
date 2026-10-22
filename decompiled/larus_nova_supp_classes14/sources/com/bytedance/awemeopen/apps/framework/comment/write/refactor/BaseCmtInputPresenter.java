package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseCmtInputPresenter extends az3.a<l> {
    public ez3.e c;
    public final Lazy d;
    public View e;

    public abstract void G();

    public void H(com.bytedance.awemeopen.apps.framework.comment.write.g r1) {
    }

    public abstract void I();

    public final ez3.e E() {
        if (this.c != null) goto L6;
        ez3.e.a r0 = ez3.e.Z1;
        wy3.a r1 = this.a;
        r0.getClass();
        this.c = ez3.e.a.a(r1);
    L6:
        return this.c;
    }

    public BaseCmtInputPresenter(final wy3.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cmtContext");
        super(r3);
        this.d = LazyKt.lazy(new BaseCmtInputPresenter$mEmojiGifAbility$2(r3));
        LifecycleOwner r4 = r3.b.d;
        int r0 = xy3.a.a;
        xy3.a.b(i.class, r4, new a(this));
        xy3.a.b(j.class, r4, new b(this));
        xy3.a.b(h.class, r4, new c(this));
    }

    public void F(l r2) {
        Intrinsics.checkNotNullParameter(r2, "viewProvider");
        Intrinsics.checkNotNullParameter(r2, "viewProvider");
        this.e = r2.getRootView();
    }
}
