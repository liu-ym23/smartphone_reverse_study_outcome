package kotlin;

import com.bytedance.android.ec.core.event.a;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", a.KEY_EXCEPTION, "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt {
    public ExceptionsKt__ExceptionsKt() {
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable r100) {
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable r100) {
    }

    public static final StackTraceElement[] getStackTrace(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StackTraceElement[] r101 = r100.getStackTrace();
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public static List<Throwable> getSuppressedExceptions(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(r100);
    }

    private static final void printStackTrace(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.printStackTrace();
    }

    public static String stackTraceToString(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringWriter r101 = new StringWriter();
        PrintWriter r102 = new PrintWriter(r101);
        r100.printStackTrace(r102);
        r102.flush();
        return r101.toString();
    }

    public static void addSuppressed(Throwable r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_EXCEPTION);
        if (r100 == r101) goto L6;
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(r100, r101);
        return;
    }

    private static final void printStackTrace(Throwable r100, PrintStream r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "stream");
        r100.printStackTrace(r101);
    }

    private static final void printStackTrace(Throwable r100, PrintWriter r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "writer");
        r100.printStackTrace(r101);
    }
}
