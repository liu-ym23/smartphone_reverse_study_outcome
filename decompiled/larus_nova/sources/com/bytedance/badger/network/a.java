package com.bytedance.badger.network;

import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class a extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f199068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f199069b;

    public a(String r100, String r101) {
        this.f199068a = r100;
        this.f199069b = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        com.bytedance.badger.C.b r100 = x64.b.f562608a;
        x64.b.a(new x64.l(TriggerStage.login_finished, 15, false, null, this.f199068a, this.f199069b, 12), null);
        return Unit.INSTANCE;
    }
}
