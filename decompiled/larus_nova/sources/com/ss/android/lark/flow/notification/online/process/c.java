package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class c extends c0c.c implements INotificationHitPoint {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f423758b;

    public static final class a {
    }

    static {
    }

    @Inject
    public c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passportService");
        super(r100);
        this.f423758b = r100;
    }
}
