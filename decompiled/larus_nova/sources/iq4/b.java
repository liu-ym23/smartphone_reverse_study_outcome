package iq4;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f495340a;

    public static final class a {
    }

    static {
        f495340a = -1;
    }

    public b(Context r100, TextPaint r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "paint");
        n.d(4);
        if (f495340a != (-1)) goto L5;
        f495340a = n.d(20);
        r101.measureText(" ");
        n.d(24);
    L5:
        new iq4.a(r100);
    }
}
