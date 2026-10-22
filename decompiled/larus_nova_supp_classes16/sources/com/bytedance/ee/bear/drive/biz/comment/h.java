package com.bytedance.ee.bear.drive.biz.comment;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements com.bytedance.ee.bear.middleground.comment.export.k {
    public final /* synthetic */ ew4.z a;

    public final ew4.g l() {
        return null;
    }

    public final boolean f() {
        return this.a.f();
    }

    public final boolean m() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    public final boolean n() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    public final boolean o() {
        return com.bytedance.ee.bear.middleground.comment.export.k.a.a();
    }

    public h(ew4.z r1) {
        this.a = r1;
    }

    public final boolean c(DialogFragment r2, CommentImageSelectorDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return this.a.c(r2, r3);
    }

    public final DialogFragment e(ew4.c r2, ew4.e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        return this.a.e(r2, r3);
    }
}
