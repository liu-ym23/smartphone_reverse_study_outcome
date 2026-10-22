package i4c;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f488258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f488259b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final Context getContext() {
        return this.f488258a;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f488258a = r100;
    }
}
