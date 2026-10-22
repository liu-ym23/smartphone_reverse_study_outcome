package com.bytedance.awemeopen.apps.framework.comment.write.arch.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.n;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractUIModule<F extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wy3.a f194395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f194396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f194397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f194398d;

    public abstract n a();

    public abstract View b(Context r100, View r101);

    public abstract void c(View r100, CommentColorMode r101);

    public final Context getContext() {
        wy3.a r100 = this.f194395a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public AbstractUIModule(wy3.a r100) {
        this.f194395a = r100;
        this.f194397c = LazyKt.lazy(new AbstractUIModule$viewProvider$2(this));
    }
}
