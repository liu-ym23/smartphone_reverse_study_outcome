package com.bytedance.awemeopen.apps.photo.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.photo.event.PinchStableViewEvent;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8F¢\u0006\u0006\u001a\u0004\b)\u0010%¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/viewmodel/FlowPagePinchVM;", "Landroidx/lifecycle/ViewModel;", "", "isIn", "", "setInStableView", "Lcom/bytedance/awemeopen/apps/photo/event/PinchStableViewEvent;", "event", "onStableViewEvent", "", "method", "onStableCloseClick", "onStableViewClick", "isPinching", "Z", "()Z", "setPinching", "(Z)V", "<set-?>", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "getEnterMethod$annotations", "()V", "Landroidx/lifecycle/MutableLiveData;", "_inStableView", "Landroidx/lifecycle/MutableLiveData;", "_stableViewEvent", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "_stableCloseClick", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "", "_stableViewClick", "getInStableView", "()Landroidx/lifecycle/MutableLiveData;", "inStableView", "getStableCloseClick", "stableCloseClick", "getStableViewClick", "stableViewClick", "<init>", "Companion", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class FlowPagePinchVM extends ViewModel {
    public static final a Companion = null;
    private final MutableLiveData<Boolean> _inStableView;
    private final DiscardFirstValueLiveData<String> _stableCloseClick;
    private final MutableLiveData<Object> _stableViewClick;
    private final MutableLiveData<PinchStableViewEvent> _stableViewEvent;
    private String enterMethod;
    private boolean isPinching;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FlowPagePinchVM a(LifecycleOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
            ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
            r1.getClass();
            return (FlowPagePinchVM) new ViewModelProvider((ViewModelStoreOwner) r2, r1).get(FlowPagePinchVM.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final FlowPagePinchVM create(LifecycleOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static /* synthetic */ void getEnterMethod$annotations() {
    }

    public final void onStableViewClick() {
        this._stableViewClick.setValue(Unit.INSTANCE);
    }

    public FlowPagePinchVM() {
        this.enterMethod = PinchEnterMethod.PINCH;
        this._inStableView = new MutableLiveData();
        this._stableViewEvent = new MutableLiveData();
        this._stableCloseClick = new DiscardFirstValueLiveData();
        this._stableViewClick = new MutableLiveData();
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final MutableLiveData<Boolean> getInStableView() {
        return this._inStableView;
    }

    public final MutableLiveData<String> getStableCloseClick() {
        return this._stableCloseClick;
    }

    public final MutableLiveData<Object> getStableViewClick() {
        return this._stableViewClick;
    }

    public final boolean isPinching() {
        return this.isPinching;
    }

    public final void onStableCloseClick(String r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        this._stableCloseClick.setValue(r2);
    }

    public final void onStableViewEvent(PinchStableViewEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this._stableViewEvent.setValue(r2);
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setInStableView(boolean r2) {
        this._inStableView.setValue(Boolean.valueOf(r2));
    }

    public final void setPinching(boolean r1) {
        this.isPinching = r1;
    }

    public static /* synthetic */ void onStableCloseClick$default(FlowPagePinchVM r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "button";
    L5:
        r0.onStableCloseClick(r1);
    }
}
