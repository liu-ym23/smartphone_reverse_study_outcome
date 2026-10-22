package xp8;

import aq8.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i<T extends aq8.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f564741a;

    public i() {
    }

    public abstract aq8.f a(T r100);

    public final j getContext() {
        j r100 = this.f564741a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
