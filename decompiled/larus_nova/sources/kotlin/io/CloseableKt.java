package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", NameKeys.LoadStrategy_Use, "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CloseableKt {
    public static final void closeFinally(Closeable r100, Throwable r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L10;
        r100.close();
        return;
    L10:
        r100.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        kotlin.ExceptionsKt.addSuppressed(r101, th);
        return;
    }

    private static final <T extends Closeable, R> R use(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        R r102 = r101.invoke(r100);     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        closeFinally(r100, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r102;
    L7:
        if (r100 == null) goto L9;
        r100.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r100 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r100.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        closeFinally(r100, th);
        goto L20
    }
}
