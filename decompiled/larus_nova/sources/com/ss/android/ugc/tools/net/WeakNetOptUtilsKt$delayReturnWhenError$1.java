package com.ss.android.ugc.tools.net;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/tools/net/WeakNetOptUtilsKt$delayReturnWhenError$1", "Landroidx/lifecycle/Observer;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class WeakNetOptUtilsKt$delayReturnWhenError$1 implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f454839a;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Job r101 = this.f454839a;
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        throw null;
    L6:
        throw null;
    }
}
