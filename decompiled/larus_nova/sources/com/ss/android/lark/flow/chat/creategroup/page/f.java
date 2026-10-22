package com.ss.android.lark.flow.chat.creategroup.page;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowGroupCreateFragmentV2 f422100a;

    public f(FlowGroupCreateFragmentV2 r100) {
        this.f422100a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TextView r102 = this.f422100a.f422082i;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r102 = null;
    L5:
        Intrinsics.checkNotNull(r101);
        r102.setEnabled(r101.booleanValue());
    }
}
