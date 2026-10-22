package com.bytedance.awemeopen.apps.framework.feed.pinch.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/vm/PinchStateViewModel;", "Landroidx/lifecycle/ViewModel;", "", "enterPinch", "", "setPinchLifecycleEvent", "enterFixedSpeed", "setFixedSpeedLifecycleEvent", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/MutableLiveData;", "enterPinchEvent", "Landroidx/lifecycle/MutableLiveData;", "getEnterPinchEvent", "()Landroidx/lifecycle/MutableLiveData;", "enterFixedSpeedEvent", "getEnterFixedSpeedEvent", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchStateViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String VIEW_MODEL_PREFIX = "PINCH_STATE_";
    private final MutableLiveData<Boolean> enterFixedSpeedEvent;
    private final MutableLiveData<Boolean> enterPinchEvent;
    private final LifecycleOwner lifecycleOwner;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PinchStateViewModel a(LifecycleOwner r100) {
            if ((r100 instanceof ViewModelStoreOwner) == false) goto L5;
            ViewModelStoreOwner r101 = (ViewModelStoreOwner) r100;
        L6:
            if (r101 != null) goto L9;
            return null;
        L9:
            return (PinchStateViewModel) new ViewModelProvider(r101, new PinchStateViewModelFactory(r100)).get(PinchStateViewModel.VIEW_MODEL_PREFIX + r100, PinchStateViewModel.class);
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final PinchStateViewModel create(LifecycleOwner r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public final MutableLiveData<Boolean> getEnterFixedSpeedEvent() {
        return this.enterFixedSpeedEvent;
    }

    public final MutableLiveData<Boolean> getEnterPinchEvent() {
        return this.enterPinchEvent;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public PinchStateViewModel(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.lifecycleOwner = r100;
        this.enterPinchEvent = new MutableLiveData();
        this.enterFixedSpeedEvent = new MutableLiveData();
    }

    public final void setFixedSpeedLifecycleEvent(boolean r100) {
        if (b.b() == false) goto L5;
        this.enterFixedSpeedEvent.setValue(Boolean.valueOf(r100));
        return;
    L5:
        this.enterFixedSpeedEvent.postValue(Boolean.valueOf(r100));
    }

    public final void setPinchLifecycleEvent(boolean r100) {
        if (b.b() == false) goto L5;
        this.enterPinchEvent.setValue(Boolean.valueOf(r100));
        return;
    L5:
        this.enterPinchEvent.postValue(Boolean.valueOf(r100));
    }
}
