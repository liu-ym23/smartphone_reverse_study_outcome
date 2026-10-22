package com.ss.android.ugc.tools.net;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class WeakNetOptUtilsKt$delayReturnWhenError$onError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $startLoadingTime;

    public WeakNetOptUtilsKt$delayReturnWhenError$onError$1(long r100) {
        this.$startLoadingTime = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r100 = b.f454841a;
        b.f454841a.getClass();
        long r101 = 2000 - (System.currentTimeMillis() - this.$startLoadingTime);
        if (r101 <= 0) goto L6;
        Thread.sleep(r101);
        return;
    }
}
