package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forsetiutils.widget.NoSaveViewStateFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0014J\u0006\u0010#\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u001cH\u0014J\b\u0010%\u001a\u00020\u001cH\u0014J\b\u0010&\u001a\u00020\u001cH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/TabLazyLoadFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mIsNeedLazyLoad", "", "getMIsNeedLazyLoad", "()Z", "setMIsNeedLazyLoad", "(Z)V", "mIsPageShowing", "mIsContentViewCreated", "mIsDestroyed", "mLayoutInflater", "Landroid/view/LayoutInflater;", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "onCreateView", "Landroid/view/View;", "inflater", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onPause", "onDestroyView", "loadContentView", "getContentView", "onContentViewCreated", RootDescription.ROOT_ELEMENT, "isPageShow", "onPageShow", "onPageHide", MapMonitorConst.EVENT_DESTROY, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TabLazyLoadFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f414350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f414351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f414352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LayoutInflater f414353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NoSaveViewStateFrameLayout f414354h;

    public static final class a {
    }

    static {
    }

    public abstract View S90(LayoutInflater r100, ViewGroup r101);

    public final void T90() {
        LayoutInflater r100 = this.f414353g;
        Intrinsics.checkNotNull(r100);
        View r101 = S90(r100, this.f414354h);
        if (r101 == null) goto L7;
        NoSaveViewStateFrameLayout r102 = this.f414354h;
        Intrinsics.checkNotNull(r102);
        r102.addView(r101, new FrameLayout.LayoutParams(-1, -1));
        this.f414351e = true;
        this.f414352f = false;
        return;
    L7:
        throw new RuntimeException("getContentView can't be null");
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        if (this.f414352f == false) goto L5;
    L7:
        super.onDestroyView();
        return;
    L5:
        if (this.f414351e == false) goto L7;
        this.f414351e = false;
        this.f414352f = true;
        goto L7
    }

    public TabLazyLoadFragment() {
        this.f414350d = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f414350d == true) goto L5;
        return;
    L5:
        if (this.f414351e == true) goto L7;
    L8:
        T90();
        return;
    L7:
        if (this.f414352f == true) goto L8;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f414353g = r100;
        this.f414354h = new NoSaveViewStateFrameLayout(requireContext(), null);
        if (this.f414350d == true) goto L5;
        T90();
    L5:
        NoSaveViewStateFrameLayout r103 = this.f414354h;
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
