package xi3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends LayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563923a = 0;

    public static final class a {
        public static View a(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            b r102 = new b(r100);
            Object r103 = null;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
            LayoutInflaterCompat.setFactory2(r102, new xi3.a());     // Catch: Throwable -> L5
            Object r105 = Result.m9449constructorimpl(r102.inflate(r101, null, false));     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r105) == true) goto L12;
            r103 = r105;
        L12:
            return (View) r103;
        L5:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context r100) {
        return new b(getContext());
    }
}
