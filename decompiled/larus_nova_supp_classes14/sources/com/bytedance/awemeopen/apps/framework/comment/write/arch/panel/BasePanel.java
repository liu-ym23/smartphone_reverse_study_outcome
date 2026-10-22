package com.bytedance.awemeopen.apps.framework.comment.write.arch.panel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BasePanel {
    public final LifecycleOwner a;
    public p b;
    public final Lazy c;

    public BasePanel(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.a = r2;
        this.c = LazyKt.lazy(new BasePanel$mCmtContext$2(this));
        r2.getLifecycle().addObserver(new AnonymousClass1(this));
    }
}
