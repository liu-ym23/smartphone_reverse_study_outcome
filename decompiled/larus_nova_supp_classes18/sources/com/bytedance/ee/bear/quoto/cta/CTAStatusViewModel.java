package com.bytedance.ee.bear.quoto.cta;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/quoto/cta/CTAStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isCTAShown", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CTAStatusViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isCTAShown;

    public CTAStatusViewModel() {
        this.isCTAShown = new MutableLiveData(Boolean.FALSE);
    }

    public final MutableLiveData<Boolean> isCTAShown() {
        return this.isCTAShown;
    }
}
