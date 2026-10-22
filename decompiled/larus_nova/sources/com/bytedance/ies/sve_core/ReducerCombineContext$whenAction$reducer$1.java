package com.bytedance.ies.sve_core;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\t\u001a\u00028\u0001\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00028\u0002\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"A2", "Lcom/bytedance/ies/sve_core/s;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/sve_core/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "s", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/sve_core/s;Lcom/bytedance/ies/sve_core/a;)Lcom/bytedance/ies/sve_core/s;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class ReducerCombineContext$whenAction$reducer$1 extends Lambda implements Function2<s, a, s> {
    final /* synthetic */ Function2 $block;

    public ReducerCombineContext$whenAction$reducer$1(Function2 r100) {
        this.$block = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final s invoke2(s r100, a r101) {
        Intrinsics.reifiedOperationMarker(4, "A2");
        if (Reflection.getOrCreateKotlinClass(a.class).isInstance(r101) == true) goto L5;
        return r100;
    L5:
        return (s) this.$block.invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ s invoke(s r100, a r101) {
        return invoke2(r100, r101);
    }
}
