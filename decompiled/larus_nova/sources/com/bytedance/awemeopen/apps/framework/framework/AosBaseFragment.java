package com.bytedance.awemeopen.apps.framework.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n44.a;
import z04.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Ln44/a;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBaseFragment<VM extends AosViewModel> extends Fragment implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VM f196843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f196844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, View> f196845f;

    public void S90() {
        ((LinkedHashMap) this.f196845f).clear();
    }

    public abstract int X90();

    public abstract void Y90();

    public abstract void Z90();

    public void aa0() {
    }

    public abstract void ba0(Bundle r100);

    public boolean ca0() {
        return false;
    }

    public abstract Class<VM> da0();

    @Override // n44.a
    public Fragment f() {
        return this;
    }

    public abstract void initView();

    public AosBaseFragment() {
        this.f196845f = new LinkedHashMap();
        if (AoEnv.h() == false) goto L18;
        Constructor<?>[] r100 = getClass().getDeclaredConstructors();
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L23;
        Class<?>[] r103 = r100[r102].getParameterTypes();
        if (r103 == null) goto L17;
        if (r103.length != 0) goto L11;
        boolean r104 = true;
    L13:
        if ((!r104) == false) goto L17;
        throw new RuntimeException("you must support parameterless constructor && it must the only one!");
    L11:
        r104 = false;
    L17:
        r102 = r102 + 1;
        goto L5
    L23:
        return;
    }

    public VM T90() {
        ViewModelProviderFactory r100 = ViewModelProviderFactory.f196951a;
        r100.getClass();
        return (VM) new ViewModelProvider(this, r100).get(da0());
    }

    public final View V90() {
        View r100 = this.f196844e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragmentRootView");
        return null;
    }

    public final VM W90() {
        VM r100 = this.f196843d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Z90();
        S90();
    }

    public Boolean onBackPressed() {
        return Boolean.FALSE;
    }

    public final AosDefaultNetErrorView U90(DmtStatusView r100) {
        Intrinsics.checkNotNullParameter(r100, "statusView");
        return new AosDefaultNetErrorView(r100.getContext());
    }

    public final <T extends View> T findViewById(int r100) {
        return (T) V90().findViewById(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (ca0() == false) goto L6;
        V90().setPadding(V90().getPaddingLeft(), V90().getPaddingTop() + c.a(V90().getContext()), V90().getPaddingRight(), V90().getPaddingBottom());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(X90(), r101, false);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f196844e = r103;
        VM r104 = (VM) T90();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f196843d = r104;
        aa0();
        ba0(r102);
        initView();
        Y90();
        return V90();
    }
}
