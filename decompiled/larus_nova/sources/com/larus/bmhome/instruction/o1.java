package com.larus.bmhome.instruction;

import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final class o1 implements Function0<ViewModelStoreOwner> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentFeature f312192a;

    public o1(ComponentFeature r100) {
        this.f312192a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStoreOwner invoke() {
        return s1a.a.getActivity(this.f312192a);
    }
}
