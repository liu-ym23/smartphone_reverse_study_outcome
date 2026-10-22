package com.larus.bmhome.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.databinding.LarusAiGenVideoDetailControlViewBinding;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qs8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J!\u0010\u001d\u001a\u00020\u00102\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u001f¢\u0006\u0002\b!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/larus/bmhome/video/view/AiGenVideoPlayControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusAiGenVideoDetailControlViewBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusAiGenVideoDetailControlViewBinding;", "onDownloadClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "updateProgress", "percent", "", "smooth", "", "hideDownloadComplete", "showDownloadLoading", "loading", "setProgressViewVisibility", "shouldShow", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "asView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiGenVideoPlayControlView extends ConstraintLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusAiGenVideoDetailControlViewBinding f315364a;

    public AiGenVideoPlayControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AiGenVideoPlayControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // qs8.a
    public final void I4(boolean r100) {
    }

    @Override // qs8.a
    public final View asView() {
        return this;
    }

    @Override // qs8.a
    public final void d5(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
    }

    @Override // qs8.a
    public final void h3() {
    }

    public final LarusAiGenVideoDetailControlViewBinding getBinding() {
        return this.f315364a;
    }

    @Override // qs8.a
    public void setProgressViewVisibility(boolean r100) {
        if (r100 == false) goto L4;
        e1.o(this.f315364a.f310771b);
        return;
    L4:
        e1.x(this.f315364a.f310771b);
    }

    @Override // qs8.a
    public final void z1(Function1<? super PlayerProgressView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        r100.invoke(this.f315364a.f310771b);
    }

    @Override // qs8.a
    public final void J1(float r100, boolean r101) {
        this.f315364a.f310771b.J1(r100, r101);
    }

    public AiGenVideoPlayControlView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_ai_gen_video_detail_control_view, this);
        PlayerProgressView r103 = (PlayerProgressView) ViewBindings.findChildViewById(this, R.id.player_progress);
        if (r103 == null) goto L7;
        this.f315364a = new LarusAiGenVideoDetailControlViewBinding(this, r103);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.player_progress)));
    }

    public /* synthetic */ AiGenVideoPlayControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
