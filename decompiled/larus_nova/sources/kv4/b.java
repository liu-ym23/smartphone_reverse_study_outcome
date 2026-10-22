package kv4;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f506265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f506266b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f506265a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f506265a = r100;
        this.f506266b = new c();
    }
}
