package xi3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterCompat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends LayoutInflater {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static View a(Context r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            b r0 = new b(r2);
            Object r4 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            LayoutInflaterCompat.setFactory2(r0, new xi3.a());     // Catch: Throwable -> L5
            Object r5 = Result.constructor-impl(r0.inflate(r3, null, false));     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r5) == true) goto L12;
            r4 = r5;
        L12:
            return (View) r4;
        L5:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context r2) {
        return new b(getContext());
    }
}
