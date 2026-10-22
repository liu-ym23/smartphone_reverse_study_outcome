package com.larus.paging;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/larus/paging/LivePagedList;", "", "Key", "Value", "Landroidx/lifecycle/LiveData;", "Lcom/larus/paging/g0;", "paging-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class LivePagedList<Key, Value> extends LiveData<g0<Value>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f363662b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f363663a;

    @Override // androidx.lifecycle.LiveData
    public final void onActive() {
        super.onActive();
        a(false);
    }

    public final void a(boolean r100) {
        Job r101 = this.f363663a;
        if (r101 == null) goto L7;
        if (r100 == true) goto L7;
        return;
    L7:
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        this.f363663a = BuildersKt.launch$default(null, null, null, new LivePagedList$invalidate$1(this, null), 2, null);
    }
}
