package kotlinx.datetime.format;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class x {
    public static final void b(w r100, char r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.o(String.valueOf(r101));
    }

    public static final <T extends w> void a(T r100, Function1<? super T, Unit>[] r101, Function1<? super T, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "alternativeFormats");
        Intrinsics.checkNotNullParameter(r102, "primaryFormat");
        if ((r100 instanceof b) == false) goto L7;
        ((b) r100).f((Function1[]) Arrays.copyOf(r101, r101.length), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 1));
        return;
    L7:
        throw new IllegalStateException("impossible");
    }

    public static final <T extends w> void c(T r100, String r101, Function1<? super T, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ifZero");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        if ((r100 instanceof b) == false) goto L7;
        ((b) r100).p(r101, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 1));
        return;
    L7:
        throw new IllegalStateException("impossible");
    }
}
