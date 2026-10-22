package com.bytedance.ee.bear.templates.scene;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/templates/scene/BaseSceneFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/templates/scene/BaseScenePresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initMVP", "rootView", "getIModel", "Lcom/bytedance/ee/bear/templates/scene/ISceneModel;", "getIView", "Lcom/bytedance/ee/bear/templates/scene/ISceneView;", "getIPresenter", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSceneFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f239296d;

    public abstract c S90();

    public abstract a T90(c r100, d r101);

    public abstract d U90(View r100);

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        a r100 = this.f239296d;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public BaseSceneFragment() {
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        a r101 = this.f239296d;
        if (r101 == null) goto L8;
        d r102 = r101.f239314c;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        a r102 = T90(S90(), U90(r100));
        this.f239296d = r102;
        if (r102 == null) goto L6;
        r102.create();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_template_scene_list_layout, r101, false);
    }
}
