package com.bytedance.jedi.ext.widget;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InternalKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.widget.Widget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\nJ+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/jedi/ext/widget/WidgetLifecycleAwareLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/jedi/arch/lifecycleAwareLazy;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "keyFactory", "Lkotlin/Function0;", "", "initializer", "(Landroid/arch/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ensureViewModel", "", "value", "(Landroid/arch/lifecycle/LifecycleOwner;Landroid/arch/lifecycle/ViewModel;Lkotlin/jvm/functions/Function0;)V", "ext_widget_release"}, k = 1, mv = {1, 1, 15})
public final class WidgetLifecycleAwareLazy<T extends ViewModel> extends lifecycleAwareLazy<T> {
    public WidgetLifecycleAwareLazy(LifecycleOwner r100, Function0<String> r101, Function0<? extends T> r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.lifecycleAwareLazy
    public void ensureViewModel(LifecycleOwner r100, T r101, Function0<String> r102) {
        Object r103 = ((Widget) r100).getHost();
        if ((r103 instanceof Fragment) == true) goto L5;
        r103 = null;
    L5:
        Fragment r104 = (Fragment) r103;
        if (r104 == null) goto L9;
        InternalKt.ensureViewModel(r104, r101, r102);
        return;
    }

    public /* synthetic */ WidgetLifecycleAwareLazy(LifecycleOwner r100, Function0 r101, Function0 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, r102);
    }
}
