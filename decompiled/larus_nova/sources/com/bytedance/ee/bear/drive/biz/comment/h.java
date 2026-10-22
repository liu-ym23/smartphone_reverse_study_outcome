package com.bytedance.ee.bear.drive.biz.comment;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements com.bytedance.ee.bear.middleground.comment.export.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ew4.z f222781a;

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final ew4.g l() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean f() {
        return this.f222781a.f();
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
        return com.bytedance.ee.bear.middleground.comment.export.k.a.a();
    }

    public h(ew4.z r100) {
        this.f222781a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final boolean c(DialogFragment r100, CommentImageSelectorDismissReason r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "reason");
        return this.f222781a.c(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.k
    public final DialogFragment e(ew4.c r100, ew4.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        return this.f222781a.e(r100, r101);
    }
}
