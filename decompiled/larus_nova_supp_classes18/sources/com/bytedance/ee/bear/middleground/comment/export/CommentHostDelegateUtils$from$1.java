package com.bytedance.ee.bear.middleground.comment.export;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import ew4.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentHostDelegateUtils$from$1 implements k {
    public final /* synthetic */ z a;

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean f() {
        return this.a.f();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final ew4.g l() {
        return this.a.l();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean m() {
        return this.a.H0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean n() {
        return this.a.f1();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean o() {
        final z r1 = this.a;
        return l.a(new CommentHostDelegateUtils$from$1$enableCommentVoice$1(r1));
    }

    public CommentHostDelegateUtils$from$1(z r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean c(DialogFragment r2, CommentImageSelectorDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return this.a.c(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final DialogFragment e(ew4.c r2, ew4.e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        return this.a.e(r2, r3);
    }
}
