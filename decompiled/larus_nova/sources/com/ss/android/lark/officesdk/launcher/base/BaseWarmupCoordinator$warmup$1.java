package com.ss.android.lark.officesdk.launcher.base;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.internal.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseWarmupCoordinator$warmup$1 extends Lambda implements Function1<IOfficeSDKRuntime, Unit> {
    final /* synthetic */ Application $application;

    public BaseWarmupCoordinator$warmup$1(Application r100) {
        this.$application = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOfficeSDKRuntime r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        List<b> r101 = a.f433428a;
        Application r102 = this.$application;
        Intrinsics.checkNotNullParameter(r102, "application");
        Iterator<T> r103 = a.f433428a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        b r104 = (b) r103.next();
        long r105 = SystemClock.elapsedRealtime();
        Log.i("BaseWarmupExecutor", "OfficeSDK_Boot_Warmup_Task_Begin: " + r104.name());
        r104.a(r102);
        long r106 = SystemClock.elapsedRealtime() - r105;
        Log.i("BaseWarmupExecutor", "OfficeSDK_Boot_Warmup_Task_End: " + r104.name() + ", cost: " + r106 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r107 = g.f433363a;
        String r108 = r104.name();
        Intrinsics.checkNotNullParameter(r108, "name");
        g.a(r108, "warmup", r106);
        goto L4
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IOfficeSDKRuntime r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
