package com.bytedance.ui_component;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ui_component/LifecycleAwareViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/arch/State;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "_lifecycle", "Landroidx/lifecycle/Lifecycle;", "get_lifecycle$lib_runtime_release", "()Landroidx/lifecycle/Lifecycle;", "set_lifecycle$lib_runtime_release", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class LifecycleAwareViewModel<T extends State> extends JediViewModel<T> implements LifecycleOwner {
    public Lifecycle _lifecycle;

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        Lifecycle r100 = this._lifecycle;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_lifecycle");
    L5:
        return r100;
    }

    public final Lifecycle get_lifecycle$lib_runtime_release() {
        Lifecycle r100 = this._lifecycle;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_lifecycle");
    L5:
        return r100;
    }

    public LifecycleAwareViewModel() {
    }

    public final void set_lifecycle$lib_runtime_release(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._lifecycle = r100;
    }
}
