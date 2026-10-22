package com.bytedance.ee.bear.facade.common;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.ContextsKt;
import java.util.List;
import sa5.d;
import sa5.q;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class BaseFragment extends LifeCycleFragment implements d, q {
    public boolean S90() {
        return false;
    }

    public BaseFragment() {
        a.h("BaseFragment", getClass().getSimpleName().concat(" constructor"));
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L5;
        return null;
    L5:
        return ContextsKt.findActivity(r100);
    }

    public boolean onBackPressed() {
        List<Fragment> r100 = getChildFragmentManager().getFragments();
        if (r100 == null) goto L13;
        int r101 = r100.size() - 1;
    L5:
        if (r101 < 0) goto L19;
        Object r102 = (Fragment) ListProtector.get(r100, r101);
        if ((r102 instanceof d) == false) goto L12;
        if (((d) r102).onBackPressed() == false) goto L12;
        a.h("BaseFragment", "Back press consumed by :" + r102);
        return true;
    L12:
        r101 = r101 - 1;
        goto L5
    L19:
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a.h("BaseFragment", getClass().getSimpleName().concat(" onDestroy"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        a.h("BaseFragment", getClass().getSimpleName().concat(" onDetach"));
    }

    public final void T90(int r100) {
        Fragment r101 = getParentFragment();
        if (r101 == null) goto L5;
        FragmentManager r102 = r101.getChildFragmentManager();
    L6:
        if (r102 == null) goto L12;
        FragmentTransaction r103 = r102.beginTransaction();
        if (r100 == 0) goto L10;
        r103.setCustomAnimations(0, r100);
    L10:
        r103.remove(this).commitAllowingStateLoss();
        return;
    L12:
        return;
    L5:
        r102 = getFragmentManager();
        goto L6
    }

    @Override // sa5.q
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getKeyCode() == 4) goto L5;
        return false;
    L5:
        if (r100.getAction() == 1) goto L7;
        return false;
    L7:
        return S90();
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        a.h("BaseFragment", getClass().getSimpleName().concat(" onCreate"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        a.h("BaseFragment", getClass().getSimpleName().concat(" onViewCreated"));
    }
}
