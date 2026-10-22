package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements com.ss.android.lark.sdk.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InitRustSdkTaskForSimple f425701a;

    @Override // com.ss.android.lark.sdk.d
    public final Long a(String r100) {
        return null;
    }

    @Override // com.ss.android.lark.sdk.d
    public final void b() {
    }

    @Override // com.ss.android.lark.sdk.d
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.lark.sdk.d
    public final boolean e() {
        return false;
    }

    @Override // com.ss.android.lark.sdk.d
    public final String getUserId() {
        return this.f425701a.f425683c.g();
    }

    public k(InitRustSdkTaskForSimple r100) {
        this.f425701a = r100;
    }

    @Override // com.ss.android.lark.sdk.d
    public final boolean c(Command r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if (Intrinsics.areEqual(r100, Command.SET_DEVICE) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, Command.MAKE_USER_ONLINE) == true) goto L10;
        if (Intrinsics.areEqual(r100, Command.GET_INIT_SETTINGS) == true) goto L10;
        return false;
    }
}
