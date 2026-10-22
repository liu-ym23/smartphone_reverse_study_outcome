package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends AbstractUIModule<l> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f194562e;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final View b(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        return r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final n a() {
        return new n(this);
    }

    public o(g r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContext");
        super(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule
    public final void c(View r100, CommentColorMode r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "colorMode");
        this.f194562e = r100;
    }
}
