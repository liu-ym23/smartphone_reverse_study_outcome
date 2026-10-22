package com.larus.uaigc.chat.block.widget.video;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.uaigc.impl.databinding.LarusLayoutVideoGenerateFailedBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VideoFailedViewBinder$viewStubMgr$2$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutVideoGenerateFailedBinding> {
    public static final VideoFailedViewBinder$viewStubMgr$2$1 INSTANCE = null;

    static {
        INSTANCE = new VideoFailedViewBinder$viewStubMgr$2$1();
    }

    public VideoFailedViewBinder$viewStubMgr$2$1() {
        super(1, LarusLayoutVideoGenerateFailedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/uaigc/impl/databinding/LarusLayoutVideoGenerateFailedBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusLayoutVideoGenerateFailedBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        if (r100 == null) goto L7;
        return new LarusLayoutVideoGenerateFailedBinding((FrameLayout) r100);
    L7:
        throw new NullPointerException("rootView");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusLayoutVideoGenerateFailedBinding invoke(View r100) {
        return invoke2(r100);
    }
}
