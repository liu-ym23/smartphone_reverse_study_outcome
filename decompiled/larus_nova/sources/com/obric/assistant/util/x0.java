package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.n4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class x0 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f393855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f393856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f393857c;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        FLogger.f375446a.i("DeviceCredentialAuthHelper", "onAuthenticationCancelled");
        Function0<Unit> r100 = this.f393856b;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        FLogger.f375446a.i("DeviceCredentialAuthHelper", "onAuthenticationFailed");
        Function0<Unit> r100 = this.f393856b;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        FLogger.f375446a.i("DeviceCredentialAuthHelper", "onAuthenticationNotAvailable");
        Function0<Unit> r100 = this.f393857c;
        if (r100 == null) goto L5;
    L4:
        r100.invoke();
        return;
    L5:
        r100 = this.f393856b;
        if (r100 != null) goto L4;
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        FLogger.f375446a.i("DeviceCredentialAuthHelper", "onAuthenticationPass");
        this.f393855a.invoke();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        FLogger.f375446a.i("DeviceCredentialAuthHelper", "onAuthenticationTimeout");
        Function0<Unit> r100 = this.f393856b;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public x0(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        this.f393855a = r100;
        this.f393856b = r101;
        this.f393857c = r102;
    }
}
