package com.ss.android.lark.profile.core.di;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class ProfileNetClientGetterImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f438823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b38.b f438824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f438825c;

    @Override // com.ss.android.lark.profile.core.di.a
    public final b38.b Q4() {
        return this.f438824b;
    }

    @Inject
    public ProfileNetClientGetterImpl(l r100, b38.b r101) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "scopedRucket");
        this.f438823a = r100;
        this.f438824b = r101;
        this.f438825c = LazyKt.lazy(ProfileNetClientGetterImpl$_userScopeData$2.INSTANCE);
    }
}
