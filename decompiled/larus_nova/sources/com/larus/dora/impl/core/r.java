package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class r implements ak4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraDevice f332237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f332238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f332239c;

    public /* synthetic */ r(DoraDevice r100, Ref.ObjectRef r101, Ref.BooleanRef r102) {
        this.f332237a = r100;
        this.f332238b = r101;
        this.f332239c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(boolean r100) {
        DoraDevice r101 = this.f332237a;
        Ref.ObjectRef r102 = this.f332238b;
        Ref.BooleanRef r103 = this.f332239c;
        g49.d.d("DoraConnectExt", "connect: " + r101.f204390sn + ", callback result=" + r100 + ", downLatch=" + r102.element);
        T r104 = r102.element;
        if (r104 == 0) goto L6;
        r103.element = r100;
        ((CountDownLatch) r104).countDown();
        return;
    }
}
