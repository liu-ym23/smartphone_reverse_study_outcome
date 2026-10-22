package com.ss.android.lark.todo.impl.features.tasklist.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u001cH\u0002J\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListsEventLoadingFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "listener", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListsEventLoadingFragment$LoadingFragmentListener;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListsEventLoadingFragment$LoadingFragmentListener;)V", "errContainerLinearFromXml", "Landroid/widget/LinearLayout;", "getErrContainerLinearFromXml", "()Landroid/widget/LinearLayout;", "setErrContainerLinearFromXml", "(Landroid/widget/LinearLayout;)V", "errContainerFromXml", "Landroid/widget/RelativeLayout;", "getErrContainerFromXml", "()Landroid/widget/RelativeLayout;", "setErrContainerFromXml", "(Landroid/widget/RelativeLayout;)V", "loadingContainerFromXml", "getLoadingContainerFromXml", "setLoadingContainerFromXml", "loadingAnimFromXml", "Lcom/airbnb/lottie/LottieAnimationView;", "getLoadingAnimFromXml", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLoadingAnimFromXml", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "clearFromXmlViewCache", "", "onDestroyView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initViewAction", "loadingFailed", "startLoading", "LoadingFragmentListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListsEventLoadingFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f444062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f444063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f444064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f444065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LottieAnimationView f444066h;

    public interface a {
        void reload();
    }

    public final RelativeLayout S90() {
        View r100 = this.f444064f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.err_container);
    L8:
        this.f444064f = (RelativeLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RelativeLayout) r100;
    }

    public final LottieAnimationView T90() {
        View r100 = this.f444066h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.loading_anim);
    L8:
        this.f444066h = (LottieAnimationView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LottieAnimationView) r100;
    }

    public final RelativeLayout U90() {
        View r100 = this.f444065g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.loading_container);
    L8:
        this.f444065g = (RelativeLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RelativeLayout) r100;
    }

    public final void V90() {
        if (isActive() == false) goto L6;
        T90().cancelAnimation();
        U90().setVisibility(8);
        S90().setVisibility(0);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f444063e = null;
        this.f444064f = null;
        this.f444065g = null;
        this.f444066h = null;
    }

    public TaskListsEventLoadingFragment(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f444062d = r100;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (isActive() == false) goto L5;
        T90().playAnimation();
        U90().setVisibility(0);
        S90().setVisibility(8);
    L5:
        View r102 = this.f444063e;
        if (r102 != null) goto L12;
        View r103 = getView();
        if (r103 == null) goto L10;
        r102 = r103.findViewById(R.id.err_container_linear);
    L11:
        this.f444063e = (LinearLayout) r102;
        goto L12
    L10:
        r102 = null;
    L12:
        ((LinearLayout) r102).setOnClickListener(new i(this));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.task_default_loading_fragment, null, false);
    }
}
