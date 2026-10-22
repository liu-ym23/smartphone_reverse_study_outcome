package edb;

import android.content.Context;
import com.ss.android.lark.export.entity.WidthMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import idb.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472253a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f472254a = null;

        static {
            int[] r100 = new int[WidthMode.values().length];
            r100[WidthMode.SPACIOUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[WidthMode.FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f472254a = r100;
        }
    }

    static {
    }

    public static int a(WidthMode r100) {
        if (f.a().isEnable("universalcard.renderrouter.widthmode.enable") == true) goto L5;
        return 400;
    L5:
        if (r100 != null) goto L7;
        int r101 = -1;
    L9:
        if (r101 != 1) goto L11;
        return 600;
    L11:
        if (r101 != 2) goto L17;
        return Integer.MAX_VALUE;
    L17:
        return 400;
    L7:
        r101 = a.f472254a[r100.ordinal()];
        goto L9
    }

    public static int b(Context r100, WidthMode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = a(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return MathKt.roundToInt(h18.d.b(r100, r102));
    }
}
