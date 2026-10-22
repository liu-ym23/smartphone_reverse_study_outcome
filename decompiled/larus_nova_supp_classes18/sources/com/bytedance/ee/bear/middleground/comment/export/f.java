package com.bytedance.ee.bear.middleground.comment.export;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements k {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean f() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final ew4.g l() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean m() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean n() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean o() {
        return k.a.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean c(DialogFragment r2, CommentImageSelectorDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final DialogFragment e(ew4.c r2, ew4.e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        return null;
    }
}
