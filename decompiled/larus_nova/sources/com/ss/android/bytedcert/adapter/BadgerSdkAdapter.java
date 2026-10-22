package com.ss.android.bytedcert.adapter;

import com.bytedance.badger.Badger;
import com.ss.android.cert.manager.ablity.IBadgerSdkConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import z64.h;

/* JADX INFO: loaded from: classes34.dex */
public class BadgerSdkAdapter implements IBadgerSdkConfig {

    public class a implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407252a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Badger.INSTANCE.doBadgerReport(19, new h.e(this.f407252a), new com.ss.android.bytedcert.adapter.a());
            return null;
        }

        public a(int r100) {
            this.f407252a = r100;
        }
    }

    public BadgerSdkAdapter() {
    }

    @Override // com.ss.android.cert.manager.ablity.IBadgerSdkConfig
    public void report(int r100) {
        Badger.INSTANCE.addInitListener(new a(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
