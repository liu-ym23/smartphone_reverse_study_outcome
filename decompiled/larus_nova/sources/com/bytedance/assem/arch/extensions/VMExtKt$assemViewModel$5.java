package com.bytedance.assem.arch.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/assem/arch/viewModel/AssemViewModel;", "VM", "Landroidx/fragment/app/FragmentActivity;", ExifInterface.GPS_DIRECTION_TRUE, "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class VMExtKt$assemViewModel$5 extends Lambda implements Function0<String> {
    final /* synthetic */ KClass $viewModelClass;

    public VMExtKt$assemViewModel$5(KClass r100) {
        this.$viewModelClass = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "assem_".concat(JvmClassMappingKt.getJavaClass(this.$viewModelClass).getName());
    }
}
