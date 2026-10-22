package com.ss.android.ugc.tools.net;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class WeakNetOptUtilsKt$sortEffectIfNeededUseCategoryV2$isEffectExits$1 extends Lambda implements Function1<Effect, Boolean> {
    public static final WeakNetOptUtilsKt$sortEffectIfNeededUseCategoryV2$isEffectExits$1 INSTANCE = null;

    static {
        INSTANCE = new WeakNetOptUtilsKt$sortEffectIfNeededUseCategoryV2$isEffectExits$1();
    }

    public WeakNetOptUtilsKt$sortEffectIfNeededUseCategoryV2$isEffectExits$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Effect r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Effect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getUnzipPath().length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        if (new PolarisFileWrapper(r100.getUnzipPath()).exists() == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
