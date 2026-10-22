package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.State;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u001a\b\u0000\u0010\u0002*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0003*\u0006\u0012\u0002\b\u00030\u0004\"\u0010\b\u0001\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\b\b\u0002\u0010\u0001*\u00020\u0007*\u0002H\u0001H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "VM", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/arch/State;)Lcom/bytedance/jedi/arch/State;"}, k = 3, mv = {1, 1, 16})
public final class ExtensionsKt$viewModel$2 extends Lambda implements Function1 {
    public static final ExtensionsKt$viewModel$2 INSTANCE = null;

    static {
        INSTANCE = new ExtensionsKt$viewModel$2();
    }

    public ExtensionsKt$viewModel$2() {
        super(1);
    }

    public final State invoke(State r100) {
        return r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((State) r100);
    }
}
