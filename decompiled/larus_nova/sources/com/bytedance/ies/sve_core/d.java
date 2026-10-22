package com.bytedance.ies.sve_core;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final EffectReportFragment b(Fragment r100) {
        Fragment r101 = r100.getChildFragmentManager().findFragmentByTag("EFFECT_FRAGMENT_TAG");
        if (r101 != null) goto L10;
        r101 = new EffectReportFragment();
        FragmentTransaction r102 = r100.getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EFFECT_FRAGMENT_TAG", 0) == true) goto L8;
        r102 = r102.add(r101, "EFFECT_FRAGMENT_TAG");
    L8:
        r102.commitNowAllowingStateLoss();
    L10:
        if ((r101 instanceof EffectReportFragment) == true) goto L13;
        r101 = null;
    L13:
        return (EffectReportFragment) r101;
    }

    public static final Store c(Fragment r100) {
        if ((r100.getContext() instanceof FragmentActivity) == false) goto L11;
        Context r101 = r100.getContext();
        if (r101 == null) goto L9;
        return (Store) new ViewModelProvider(r100, ViewModelProvider.AndroidViewModelFactory.getInstance(((FragmentActivity) r101).getApplication())).get(Store.class);
    L9:
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    L11:
        throw new RuntimeException("activity must FragmentActivity");
    }

    public static void a(Fragment r100, c r101) {
        BaseKt$bindEffect$2 r102 = BaseKt$bindEffect$2.INSTANCE;
        EffectReportFragment r103 = b(r100);
        if (r103 == null) goto L6;
        List<b> r104 = r103.f248667d;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new b(r101, r102));
        return;
    }

    public static e d(Fragment r100, f r101) {
        Store r102 = c(r100);
        EffectReportFragment r103 = b(r100);
        if (r103 == null) goto L6;
        ((ArrayList) r103.f248668e).add(r101);
    L6:
        return r102.useConstant(r101, null);
    }
}
