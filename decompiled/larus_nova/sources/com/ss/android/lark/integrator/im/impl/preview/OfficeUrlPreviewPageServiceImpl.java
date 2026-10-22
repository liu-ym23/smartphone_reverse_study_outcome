package com.ss.android.lark.integrator.im.impl.preview;

import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/integrator/im/impl/preview/OfficeUrlPreviewPageServiceImpl;", "Lcom/ss/android/lark/biz/officesdk/im/preview/IOfficeUrlPreviewPageService;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/integrator/im/impl/preview/UrlPreviewSession;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/ss/android/lark/integrator/im/impl/preview/UrlPreviewSession;)V", "pullPreview", "", "previewIds", "", "", "needLocalPreview", "", "removePreview", "previewId", "renderPreview", "Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewRenderResult;", "cardType", "Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewCardType;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUrlPreviewPageServiceImpl implements sza.a, DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f427981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f427982b;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    @Override // sza.a
    public final void J(List r100) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        this.f427982b.J(r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        r100.getLifecycle().removeObserver(this);
        this.f427982b.close();
    }

    @Override // sza.a
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        this.f427982b.s(r100);
    }

    public OfficeUrlPreviewPageServiceImpl(LifecycleOwner r100, OfficeUrlPreviewSessionImpl r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f427981a = r100;
        this.f427982b = r101;
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        r101.close();
        return;
    L5:
        r100.getLifecycle().addObserver(this);
    }

    @Override // sza.a
    public final UrlPreviewRenderResult j0(String r100, UrlPreviewCardType r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "cardType");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return this.f427982b.j0(r100, r101, r102);
    }
}
