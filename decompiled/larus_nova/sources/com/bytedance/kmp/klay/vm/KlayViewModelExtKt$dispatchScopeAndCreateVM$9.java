package com.bytedance.kmp.klay.vm;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.kmp.klay.ui.KlayModuleNode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/kmp/klay/vm/KlayViewModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class KlayViewModelExtKt$dispatchScopeAndCreateVM$9 extends Lambda implements Function0<ViewModelStoreOwner> {
    final /* synthetic */ KlayModuleNode $pageNode;

    public KlayViewModelExtKt$dispatchScopeAndCreateVM$9(KlayModuleNode r100) {
        this.$pageNode = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelStoreOwner invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStoreOwner invoke() {
        return this.$pageNode;
    }
}
