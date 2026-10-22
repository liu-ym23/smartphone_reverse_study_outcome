package com.bytedance.ee.bear.bitable.onboarding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR9\u0010\t\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/onboarding/BitableAIOnBoardingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "btnClickCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "param", "", "getBtnClickCallback", "()Lkotlin/jvm/functions/Function1;", "setBtnClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAIOnBoardingViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private Function1<? super String, Unit> btnClickCallback;

    public BitableAIOnBoardingViewModel() {
        this.active = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final Function1<String, Unit> getBtnClickCallback() {
        return this.btnClickCallback;
    }

    public final void setBtnClickCallback(Function1<? super String, Unit> r100) {
        this.btnClickCallback = r100;
    }
}
