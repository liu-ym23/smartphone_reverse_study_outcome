package com.larus.login.impl.impl;

import android.app.Activity;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common_ui.dialog.e0;
import com.larus.common_ui.dialog.l0;
import com.larus.nova.R;
import com.larus.xbridge.custom.t;
import java.util.Map;
import kotlin.text.StringsKt;
import n38.h;
import t19.s;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f357781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f357782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tj9.c f357783c;

    public d(l0 r100, Activity r101, t r102) {
        this.f357781a = r100;
        this.f357782b = r101;
        this.f357783c = r102;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        e0.b(this.f357781a, this.f357782b);
        tj9.c r103 = this.f357783c;
        if (r103 == null) goto L6;
        r103.b();
        return;
    }

    @Override // n38.h
    public final void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107) {
        e0.b(this.f357781a, this.f357782b);
        s r108 = s.f544207a;
        Activity r109 = this.f357782b;
        if (r102 != null) goto L5;
    L9:
        r102 = this.f357782b.getString(R.string.larus_log_in_internet_error);
    L10:
        r108.getClass();
        s.c(r109, r102);
        tj9.c r110 = this.f357783c;
        if (r110 == null) goto L14;
        r110.a();
        return;
    L14:
        return;
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L10;
        goto L9
    }
}
