package com.larus.profile.impl.mine;

import androidx.lifecycle.MutableLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class r implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MineTabViewModel f366769a;

    public /* synthetic */ r(MineTabViewModel r100) {
        this.f366769a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        MutableLiveData r100 = MineTabViewModel.access$get_showBindPhoneEvent$p(this.f366769a);
        Unit r101 = Unit.INSTANCE;
        r100.postValue(r101);
        return r101;
    }
}
