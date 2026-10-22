package com.ss.android.lark.utils;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/utils/Contexts;", "", "<init>", "()V", "preferActivity", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "findActivity", "Landroid/app/Activity;", "requireActivity", "findActivityFromContext", "feature-shared-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Contexts {
    public static final Contexts INSTANCE = null;

    static {
        INSTANCE = new Contexts();
    }

    private Contexts() {
    }

    @JvmStatic
    public static final Activity findActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return INSTANCE.findActivityFromContext(r100);
    }

    private final Activity findActivityFromContext(Context r100) {
        return ViewUtils.getActivityByContext(r100);
    }

    @JvmStatic
    public static final Context preferActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r101 = INSTANCE.findActivityFromContext(r100);
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r101;
    }

    @JvmStatic
    public static final Activity requireActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r101 = INSTANCE.findActivityFromContext(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
