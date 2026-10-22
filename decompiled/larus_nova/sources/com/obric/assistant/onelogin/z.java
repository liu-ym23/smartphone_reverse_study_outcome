package com.obric.assistant.onelogin;

import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class z implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f390959a;

    public z(w r100) {
        this.f390959a = r100;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        FLogger.f375446a.i("ObricOneLoginUtils", "doubaoLogout success");
        this.f390959a.invoke();
    }

    @Override // n38.h
    public final void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107) {
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("doubaoLogout failed, errorCode: ");
        r109.append(r101);
        r109.append(", errorMessage: ");
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        g2a.e r110 = g2a.e.f479755a;
        String r111 = g2a.f.a(r102, false, false);
    L6:
        r109.append(r111);
        r108.e("ObricOneLoginUtils", r109.toString());
        this.f390959a.invoke();
        return;
    L5:
        r111 = null;
        goto L6
    }
}
