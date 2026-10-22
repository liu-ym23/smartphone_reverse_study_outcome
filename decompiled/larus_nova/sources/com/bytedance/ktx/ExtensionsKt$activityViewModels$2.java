package com.bytedance.ktx;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.jedi.arch.ExtensionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001\"\u0010\b\u0001\u0010\u0004\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0006*\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/ktx/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/arch/JediViewModel;", "VM", "Lcom/bytedance/jedi/arch/State;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/ViewModelProvider$Factory;", AbsMethodDelegate.TAG_INVOKE, "()Landroidx/lifecycle/ViewModelProvider$Factory;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class ExtensionsKt$activityViewModels$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public static final ExtensionsKt$activityViewModels$2 INSTANCE = null;

    static {
        INSTANCE = new ExtensionsKt$activityViewModels$2();
    }

    public ExtensionsKt$activityViewModels$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return ExtensionsKt.getAssertionFactory();
    }
}
