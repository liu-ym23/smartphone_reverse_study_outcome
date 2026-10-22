package com.ss.android.lark.picker;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/PickerDependencyHolder;", "", "<init>", "()V", "dependency", "Lcom/ss/android/lark/picker/IPickerDependency;", "getDependency", "()Lcom/ss/android/lark/picker/IPickerDependency;", "dependency$delegate", "Lkotlin/Lazy;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerDependencyHolder {
    public static final PickerDependencyHolder INSTANCE = null;
    private static final Lazy dependency$delegate = null;

    private PickerDependencyHolder() {
    }

    static {
        INSTANCE = new PickerDependencyHolder();
        dependency$delegate = LazyKt.lazy(PickerDependencyHolder$dependency$2.INSTANCE);
    }

    public final IPickerDependency getDependency() {
        return (IPickerDependency) dependency$delegate.getValue();
    }
}
