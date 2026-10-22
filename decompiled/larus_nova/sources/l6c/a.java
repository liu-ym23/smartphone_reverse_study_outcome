package l6c;

import android.content.Context;
import b1c.c;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements g5c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f507756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f507757b;

    static {
        f507756a = new a();
    }

    public a() {
    }

    @Override // g5c.b
    public final String type() {
        return "keva";
    }

    @Override // g5c.b
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f507757b == true) goto L6;
        KevaBuilder.getInstance().setContext(r100);
        f507757b = true;
        return;
    }

    @Override // g5c.b
    public final g5c.a a(Context r100, String r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        return new b(Keva.getRepo(r101, 1), r102);
    }
}
