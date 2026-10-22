package com.larus.bmhome.chat.layout.holder.progressloading;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusSketchProgressLoadingBinding;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SketchLoadingController$viewStubMgr$2$1 extends FunctionReferenceImpl implements Function1<View, LarusSketchProgressLoadingBinding> {
    public static final SketchLoadingController$viewStubMgr$2$1 INSTANCE = null;

    static {
        INSTANCE = new SketchLoadingController$viewStubMgr$2$1();
    }

    public SketchLoadingController$viewStubMgr$2$1() {
        super(1, LarusSketchProgressLoadingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusSketchProgressLoadingBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusSketchProgressLoadingBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        int r101 = R.id.content_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.content_container)) == null) goto L15;
        r101 = R.id.description;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.description);
        if (r102 == null) goto L15;
        r101 = R.id.generating_progress;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.generating_progress);
        if (r103 == null) goto L15;
        r101 = R.id.loading_background;
        ImageWebpLoadingBgView r104 = (ImageWebpLoadingBgView) ViewBindings.findChildViewById(r100, R.id.loading_background);
        if (r104 == null) goto L15;
        r101 = R.id.progress_icon;
        LottieAdapterView r105 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.progress_icon);
        if (r105 == null) goto L15;
        return new LarusSketchProgressLoadingBinding((RadiusCardView) r100, r102, r103, r104, r105);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusSketchProgressLoadingBinding invoke(View r100) {
        return invoke2(r100);
    }
}
