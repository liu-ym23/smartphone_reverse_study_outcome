package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.f;
import com.ss.android.lark.utils.o0;
import se6.q;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InitLogTask f425661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f425662b;

    public c(InitLogTask r100, Context r101) {
        this.f425661a = r100;
        this.f425662b = r101;
    }

    @Override // com.ss.android.lark.log.f.c
    public final boolean isEnable() {
        InitLogTask r100 = this.f425661a;
        Context r101 = this.f425662b;
        boolean r102 = true;
        if (r100.f425656c == false) goto L6;
    L12:
        return r102;
    L6:
        if (o0.c(r101) == false) goto L9;
        r102 = false;
    L11:
        r100.f425656c = r102;
        goto L12
    L9:
        if (z.e(r101) == false) goto L11;
        r102 = q.f541601b;
        goto L11
    }
}
