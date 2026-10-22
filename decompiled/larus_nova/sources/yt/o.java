package yt;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569021a = 0;

    static {
    }

    public static void a(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        r100.setTypeface(null, 0);
        return;
    L10:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Typeface r103 = r100.getPaint().getTypeface();     // Catch: Throwable -> L6
        r100.getPaint().setTypeface(Typeface.create(r103, r101, false));     // Catch: Throwable -> L6
        r100.postInvalidate();     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
