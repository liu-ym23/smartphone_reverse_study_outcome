package com.bytedance.jedi.scene;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\f\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0002\u0010\b*\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/scene/Scene;", "Lcom/bytedance/jedi/arch/JediView;", "VM", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
public final class ExtensionsKt$hostViewModel$1 extends Lambda implements Function0<String> {
    final /* synthetic */ KClass $viewModelClass;

    public ExtensionsKt$hostViewModel$1(KClass r100) {
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
        return JvmClassMappingKt.getJavaClass(this.$viewModelClass).getCanonicalName();
    }
}
