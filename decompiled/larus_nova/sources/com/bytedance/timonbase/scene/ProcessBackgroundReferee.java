package com.bytedance.timonbase.scene;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timonbase/scene/ProcessBackgroundReferee;", "", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class ProcessBackgroundReferee implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f270863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<Boolean, Unit>> f270864b;

    public ProcessBackgroundReferee() {
        this.f270863a = true;
        this.f270864b = new CopyOnWriteArrayList();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        int r102 = d.f270885a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f270863a = false;
        Iterator<T> r103 = this.f270864b.iterator();
    L21:
        if (r103.hasNext() == false) goto L30;
        ((Function1) r103.next()).invoke(Boolean.valueOf(this.f270863a));
        goto L21
    L30:
        return;
    L5:
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L27;
        this.f270863a = true;
        SystemClock.elapsedRealtime();
        Iterator<T> r104 = this.f270864b.iterator();
    L11:
        if (r104.hasNext() == false) goto L28;
        ((Function1) r104.next()).invoke(Boolean.valueOf(this.f270863a));
        goto L11
    L28:
        return;
    L27:
        return;
    L14:
        if (this.f270863a == false) goto L23;
        this.f270863a = false;
        Iterator<T> r105 = this.f270864b.iterator();
    L17:
        if (r105.hasNext() == false) goto L29;
        ((Function1) r105.next()).invoke(Boolean.valueOf(this.f270863a));
        goto L17
    L29:
        return;
    }
}
