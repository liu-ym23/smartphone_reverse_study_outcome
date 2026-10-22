package com.bytedance.ee.bear.document.print;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0006J\b\u0010\r\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintFlowState;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mutableActive", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "active", "Landroidx/lifecycle/LiveData;", "getActive", "()Landroidx/lifecycle/LiveData;", "isActive", "tryStart", "finish", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintFlowState extends ViewModel {
    private final LiveData<Boolean> active;
    private final MutableLiveData<Boolean> mutableActive;

    public final boolean isActive() {
        return Intrinsics.areEqual(this.mutableActive.getValue(), Boolean.TRUE);
    }

    public PrintFlowState() {
        MutableLiveData<Boolean> r0 = new MutableLiveData(Boolean.FALSE);
        this.mutableActive = r0;
        this.active = r0;
    }

    public final void finish() {
        if (isActive() == false) goto L6;
        this.mutableActive.setValue(Boolean.FALSE);
        return;
    }

    public final boolean tryStart() {
        if (isActive() == false) goto L6;
        return false;
    L6:
        this.mutableActive.setValue(Boolean.TRUE);
        return true;
    }

    public final LiveData<Boolean> getActive() {
        return this.active;
    }
}
