package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes37.dex */
public final class ContainerConstsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f438097a = null;

    static {
        f438097a = LazyKt.lazy(ContainerConstsKt$ABSENT_SESSION$2.INSTANCE);
    }

    public static final UserSession a() {
        return (UserSession) f438097a.getValue();
    }
}
