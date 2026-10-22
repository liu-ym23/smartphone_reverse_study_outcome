package com.suite.lark.platform.component.widget_biz_permissionpurposewindow;

import android.os.Handler;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class PermissionPurposeWindowPermissionResult implements h.e, h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<Handler> f460923a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.utils.h.e
    public void a(boolean r100) {
    }

    public void b(StoragePermissionUtils.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public PermissionPurposeWindowPermissionResult() {
        this.f460923a = LazyKt.lazy(LazyThreadSafetyMode.NONE, PermissionPurposeWindowPermissionResult$handlerLazy$1.INSTANCE);
    }
}
