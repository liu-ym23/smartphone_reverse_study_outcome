package com.bytedance.commerce.base.bundle;

import android.os.Bundle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/os/Bundle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BundleDSLUtilKt$bundleTo$19 extends Lambda implements Function1<Bundle, Unit> {
    final /* synthetic */ String $this_bundleTo;
    final /* synthetic */ long[] $value;

    public BundleDSLUtilKt$bundleTo$19(String r100, long[] r101) {
        this.$this_bundleTo = r100;
        this.$value = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bundle r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle r100) {
        r100.putLongArray(this.$this_bundleTo, this.$value);
    }
}
