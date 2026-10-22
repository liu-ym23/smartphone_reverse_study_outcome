package sna;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542684a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a() {
        Context r100 = f.f542676a;
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        c r101 = f.b();
        r101.getClass();
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        return r101.a().getBoolean("wakeup_truth_capture_enabled", false);
    }
}
