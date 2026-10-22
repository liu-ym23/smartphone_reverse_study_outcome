package com.ss.android.lark.tab.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class g implements IChatTabService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f441150a;

    public static final class a {
    }

    static {
    }

    @Inject
    public g(o r100) {
        Intrinsics.checkNotNullParameter(r100, "chatTabRepo");
        this.f441150a = r100;
    }
}
