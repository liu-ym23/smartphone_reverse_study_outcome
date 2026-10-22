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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseFragment extends LifeCycleFragment implements d, q {
    public boolean S90() {
        return false;
    }

    public BaseFragment() {
        a.h("BaseFragment", getClass().getSimpleName().concat(" constructor"));
    }

    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        return ContextsKt.findActivity(r0);
    }

    public boolean onBackPressed() {
        List r0 = getChildFragmentManager().getFragments();
        if (r0 == null) goto L13;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L19;
        d r3 = (Fragment) ListProtector.get(r0, r1);
        if ((r3 instanceof d) == false) goto L12;
        if (r3.onBackPressed() == false) goto L12;
        a.h("BaseFragment", "Back press consumed by :" + r3);
        return true;
    L12:
        r1 = r1 - 1;
        goto L5
    L19:
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onDestroy() {
        super.onDestroy();
        a.h("BaseFragment", getClass().getSimpleName().concat(" onDestroy"));
    }

    public void onDetach() {
        super.onDetach();
        a.h("BaseFragment", getClass().getSimpleName().concat(" onDetach"));
    }

    public final void T90(int r3) {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        FragmentManager r1 = r0.getChildFragmentManager();
    L6:
        if (r1 == null) goto L12;
        FragmentTransaction r2 = r1.beginTransaction();
        if (r3 == 0) goto L10;
        r2.setCustomAnimations(0, r3);
    L10:
        r2.remove(this).commitAllowingStateLoss();
        return;
    L12:
        return;
    L5:
        r1 = getFragmentManager();
        goto L6
    }

    @Override // sa5.q
    public final boolean dispatchKeyEvent(KeyEvent r3) {
        if (r3.getKeyCode() == 4) goto L5;
        return false;
    L5:
        if (r3.getAction() == 1) goto L7;
        return false;
    L7:
        return S90();
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        a.h("BaseFragment", getClass().getSimpleName().concat(" onCreate"));
    }

    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        a.h("BaseFragment", getClass().getSimpleName().concat(" onViewCreated"));
    }
}
