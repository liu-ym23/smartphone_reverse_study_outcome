package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final LifecycleOwner a(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ForsetiConfig.b() == true) goto L5;
    L17:
        return r4;
    L5:
        if ((r4 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r1 = (FragmentActivity) r4;
        if (com.suite.lark.component.navroute.forseti.f.c(r1, true) == null) goto L17;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r0 = ((sua.a) ApiUtils.getApi(sua.a.class)).getForegroundForsetiNodePieceFragment(r1);
        if (r0 != null) goto L13;
        tt5.a.k("ForsetiMutableLiveData", "findForegroundFragmentInForseti: fragment is null");
        return r4;
    L13:
        if (r0.getHost() != null) goto L16;
        tt5.a.k("ForsetiMutableLiveData", "findForegroundFragmentInForseti: " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName() + " host is null");
        return r4;
    L16:
        return r0;
    }
}
