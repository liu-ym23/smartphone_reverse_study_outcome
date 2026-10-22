package com.larus.doc.impl.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.doc.biz.impl.databinding.LarusDocVideoDetailControlViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J!\u0010\u001a\u001a\u00020\u00102\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/doc/impl/video/widget/IVideoPlayControl;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusDocVideoDetailControlViewBinding;", "getBinding", "()Lcom/larus/doc/biz/impl/databinding/LarusDocVideoDetailControlViewBinding;", "onDownloadClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "updateProgress", "percent", "", "smooth", "", "showDownloadLoading", "loading", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/doc/impl/video/widget/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "asView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayControlView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f331515b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusDocVideoDetailControlViewBinding f331516a;

    public VideoPlayControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoPlayControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LarusDocVideoDetailControlViewBinding getBinding() {
        return this.f331516a;
    }

    public final void I4(boolean r100) {
        if (r100 == false) goto L4;
        this.f331516a.f330940b.T5();
        return;
    L4:
        this.f331516a.f330940b.R5();
    }

    public VideoPlayControlView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_doc_video_detail_control_view, this);
        int r103 = R.id.download_layout;
        CommonDownLoadLayout r104 = (CommonDownLoadLayout) ViewBindings.findChildViewById(this, R.id.download_layout);
        if (r104 == null) goto L11;
        r103 = R.id.op_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.op_container)) == null) goto L11;
        r103 = R.id.player_progress;
        PlayerProgressView r105 = (PlayerProgressView) ViewBindings.findChildViewById(this, R.id.player_progress);
        if (r105 == null) goto L11;
        this.f331516a = new LarusDocVideoDetailControlViewBinding(this, r104, r105);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ VideoPlayControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
