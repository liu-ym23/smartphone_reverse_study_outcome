package com.bytedance.awemeopen.apps.framework.framework.livedata;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/livedata/CallbackAfterChangedLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CallbackAfterChangedLiveData<T> extends MutableLiveData<T> {
    public CallbackAfterChangedLiveData() {
    }

    public CallbackAfterChangedLiveData(T r1) {
        setValue(r1);
    }

    public final void a(T r1) {
        super.setValue(r1);
    }

    public final void postValue(T r2) {
        if (Intrinsics.areEqual(getValue(), r2) == false) goto L5;
        return;
    L5:
        super.postValue(r2);
    }

    public final void setValue(T r2) {
        if (Intrinsics.areEqual(getValue(), r2) == false) goto L5;
        return;
    L5:
        super.setValue(r2);
    }
}
