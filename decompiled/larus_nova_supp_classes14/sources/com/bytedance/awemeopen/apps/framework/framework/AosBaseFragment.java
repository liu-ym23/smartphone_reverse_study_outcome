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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Ln44/a;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBaseFragment<VM extends AosViewModel> extends Fragment implements a {
    public VM d;
    public View e;
    public final Map<Integer, View> f;

    public void S90() {
        ((LinkedHashMap) this.f).clear();
    }

    public abstract int X90();

    public abstract void Y90();

    public abstract void Z90();

    public void aa0() {
    }

    public abstract void ba0(Bundle r1);

    public boolean ca0() {
        return false;
    }

    public abstract Class<VM> da0();

    public Fragment f() {
        return this;
    }

    public abstract void initView();

    public AosBaseFragment() {
        this.f = new LinkedHashMap();
        if (AoEnv.h() == false) goto L18;
        Constructor<?>[] r0 = getClass().getDeclaredConstructors();
        int r1 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L23;
        Class<?>[] r4 = r0[r3].getParameterTypes();
        if (r4 == null) goto L17;
        if (r4.length != 0) goto L11;
        boolean r5 = true;
    L13:
        if ((!r5) == false) goto L17;
        throw new RuntimeException("you must support parameterless constructor && it must the only one!");
    L11:
        r5 = false;
    L17:
        r3 = r3 + 1;
        goto L5
    L23:
        return;
    }

    public VM T90() {
        ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
        r1.getClass();
        return (VM) new ViewModelProvider(this, r1).get(da0());
    }

    public final View V90() {
        View r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragmentRootView");
        return null;
    }

    public final VM W90() {
        VM r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Z90();
        S90();
    }

    public Boolean onBackPressed() {
        return Boolean.FALSE;
    }

    public final AosDefaultNetErrorView U90(DmtStatusView r2) {
        Intrinsics.checkNotNullParameter(r2, "statusView");
        return new AosDefaultNetErrorView(r2.getContext());
    }

    public final <T extends View> T findViewById(int r2) {
        return (T) V90().findViewById(r2);
    }

    public void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        if (ca0() == false) goto L6;
        V90().setPadding(V90().getPaddingLeft(), V90().getPaddingTop() + c.a(V90().getContext()), V90().getPaddingRight(), V90().getPaddingBottom());
        return;
    }

    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(X90(), r4, false);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.e = r6;
        VM r7 = (VM) T90();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.d = r7;
        aa0();
        ba0(r5);
        initView();
        Y90();
        return V90();
    }
}
