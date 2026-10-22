package com.ss.android.lark.officesdk.manager;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.UserComponentEntryPoint;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.internal.v;
import dagger.hilt.EntryPoints;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2 extends Lambda implements Function0<OfficeSDKUserComponent> {
    public static final OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2 INSTANCE = null;

    static {
        INSTANCE = new OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2();
    }

    public OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final OfficeSDKUserComponent invoke() {
        Context r100 = OfficeSDKManager.getContext();
        if (r100 == null) goto L5;
        Context r101 = r100.getApplicationContext();
    L6:
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.Application");
        OfficeSDKUserComponent r102 = ((UserComponentEntryPoint) EntryPoints.get(((v) k.a((Application) r101, v.class)).c(ContainerConstsKt.a()), UserComponentEntryPoint.class)).getOfficeSDKUserComponentManager().generatedComponent();
        if (r102 == null) goto L11;
        return r102;
    L11:
        throw new IllegalStateException("Failed to create OfficeSDK absent user component".toString());
    L13:
        throw new IllegalStateException("OfficeSDK not initialized".toString());
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ OfficeSDKUserComponent invoke() {
        return invoke();
    }
}
