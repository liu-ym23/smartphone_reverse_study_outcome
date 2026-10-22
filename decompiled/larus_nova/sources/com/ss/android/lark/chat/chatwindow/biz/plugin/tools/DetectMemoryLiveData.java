package com.ss.android.lark.chat.chatwindow.biz.plugin.tools;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/DetectMemoryLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "<init>", "()V", "observerCountFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeForever", "removeObserver", "removeObservers", "getObserverCountFlow", "Lkotlinx/coroutines/flow/Flow;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetectMemoryLiveData<T> extends MediatorLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f412337a;

    public DetectMemoryLiveData() {
        this.f412337a = j1.a(0);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        super.observeForever(r100);
        StateFlowImpl r101 = this.f412337a;
        r101.setValue(Integer.valueOf(((Number) r101.getValue()).intValue() + 1));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        super.removeObserver(r100);
        StateFlowImpl r101 = this.f412337a;
        r101.setValue(Integer.valueOf(((Number) r101.getValue()).intValue() - 1));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObservers(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        super.removeObservers(r100);
        this.f412337a.setValue(0);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        super.observe(r100, r101);
        StateFlowImpl r102 = this.f412337a;
        r102.setValue(Integer.valueOf(((Number) r102.getValue()).intValue() + 1));
    }
}
