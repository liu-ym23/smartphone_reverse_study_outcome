package com.larus.livetutor.impl.tutor.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.bigimg.l;
import com.larus.livetutor.impl.base.LiveTutorBaseFragment;
import com.larus.livetutor.impl.databinding.FragmentBigImageBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pj9.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007J\u001a\u0010\u0018\u001a\u00020\n2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fJ\u0014\u0010\u001a\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u001b\u001a\u00020\nH\u0016J¸\u0001\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000f0!0 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0 2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n\u0018\u00010\f2(\b\u0002\u0010-\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000f0!0 \u0018\u00010\f2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0002J\b\u0010/\u001a\u00020\"H\u0014J\b\u00100\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorBigImageViewerFragment;", "Lcom/larus/livetutor/impl/base/LiveTutorBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/livetutor/impl/databinding/FragmentBigImageBinding;", "imageData", "Lcom/larus/livetutor/impl/tutor/fragment/TutorBigImageData;", "onDismissCallback", "Lkotlin/Function0;", "", "onPreviewerShowCallback", "Lkotlin/Function1;", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setImageData", "data", "setOnPreviewerShowCallback", "callback", "setOnPreviewerDismissCallback", "initView", "openBigImages", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageViews", "", "Lkotlin/Pair;", "", "imageList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "currIndex", "reportParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "showIndicator", "", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "onGetRestoreViewCallback", "onDynamicGetRestoreViewCallback", "onUserScrollImageCallback", "fragmentLayoutId", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorBigImageViewerFragment extends LiveTutorBaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f356557k = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FragmentBigImageBinding f356558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TutorBigImageData f356559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f356560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Dialog, Unit> f356561j;

    @Override // com.larus.livetutor.impl.base.BaseFragment
    public final void S90() {
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment
    public final void initView() {
        TutorBigImageData r100 = this.f356559h;
        if (r100 != null) goto L5;
        return;
    L5:
        final Context r101 = getContext();
        if (r101 == null) goto L18;
        final View r102 = new View(r101);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(r100.getImageWidth(), r100.getImageHeight());
        r103.leftMargin = r100.getImageRawX();
        r103.topMargin = r100.getImageRawY();
        r102.setLayoutParams(r103);
        FragmentBigImageBinding r104 = this.f356558g;
        if (r104 == null) goto L12;
        FrameLayout r105 = r104.f355915a;
        if (r105 == null) goto L12;
        r105.addView(r102);
    L12:
        final l r106 = new l(null, r100.getImageUrl(), r100.getImageUrl(), r100.getImageUrl(), null, null, null, null, r100.getJumpUrl(), null, 1777);
        FragmentBigImageBinding r107 = this.f356558g;
        if (r107 == null) goto L19;
        FrameLayout r108 = r107.f355915a;
        if (r108 == null) goto L20;
        r108.post(new a(this, r101, r102, r106));
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f356558g = null;
        this.f356560i = null;
        this.f356561j = null;
        this.f356559h = null;
    }

    public LiveTutorBigImageViewerFragment() {
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_big_image, r101, false);
        if (r103 == null) goto L7;
        FrameLayout r104 = (FrameLayout) r103;
        this.f356558g = new FragmentBigImageBinding(r104, r104);
        return r104;
    L7:
        throw new NullPointerException("rootView");
    }
}
