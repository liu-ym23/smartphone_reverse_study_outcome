package com.bytedance.ee.bear.bitable.msgcenter.view;

import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements tk5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f214728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f214729b;

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        this.f214728a.invoke();
        this.f214729b.f214732b.invoke();
        HashMap<String, String> r101 = a.f214725a;
        Intrinsics.checkNotNullParameter("try_now", "click");
        HashMap r102 = new HashMap();
        r102.put("click", "try_now");
        a.c("ccm_bitable_notification_onboarding_click", r102);
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        HashMap<String, String> r101 = a.f214725a;
        Intrinsics.checkNotNullParameter("known", "click");
        HashMap r102 = new HashMap();
        r102.put("click", "known");
        a.c("ccm_bitable_notification_onboarding_click", r102);
    }

    public d(Function0<Unit> r100, f r101) {
        this.f214728a = r100;
        this.f214729b = r101;
    }
}
