package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseCmtInputPresenter extends az3.a<l> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ez3.e f194490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f194491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f194492e;

    public abstract void G();

    public void H(com.bytedance.awemeopen.apps.framework.comment.write.g r100) {
    }

    public abstract void I();

    public final ez3.e E() {
        if (this.f194490c != null) goto L6;
        ez3.e.a r100 = ez3.e.Z1;
        wy3.a r101 = this.f16804a;
        r100.getClass();
        this.f194490c = ez3.e.a.a(r101);
    L6:
        return this.f194490c;
    }

    public BaseCmtInputPresenter(final wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        super(r100);
        this.f194491d = LazyKt.lazy(new BaseCmtInputPresenter$mEmojiGifAbility$2(r100));
        LifecycleOwner r101 = r100.f561864b.f195172d;
        int r102 = xy3.a.f565402a;
        xy3.a.b(i.class, r101, new a(this));
        xy3.a.b(j.class, r101, new b(this));
        xy3.a.b(h.class, r101, new c(this));
    }

    public void F(l r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        this.f194492e = r100.getRootView();
    }
}
