package com.bytedance.locallife.common.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m {
    public static final <VM extends ViewModel> VM a(Context r100, Class<VM> r101) {
        Intrinsics.checkNotNullParameter(r101, "vmClass");
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof FragmentActivity) == true) goto L8;
        return null;
    L8:
        return (VM) ViewModelProviders.of((FragmentActivity) r100).get(r101);
    }
}
