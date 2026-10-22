package androidx.collection.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a-\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a-\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"throwIllegalStateException", "", "message", "", "throwIndexOutOfBoundsException", "throwNoSuchElementException", "throwNoSuchElementExceptionForInline", "", "checkPrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "throwIllegalArgumentException", "requirePrecondition", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RuntimeHelpersKt {
    public static final void throwIllegalArgumentException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new IllegalArgumentException(r1);
    }

    public static final void throwIllegalStateException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new IllegalStateException(r1);
    }

    public static final void throwIndexOutOfBoundsException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new IndexOutOfBoundsException(r1);
    }

    public static final void throwNoSuchElementException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new NoSuchElementException(r1);
    }

    public static final Void throwNoSuchElementExceptionForInline(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new NoSuchElementException(r1);
    }

    public static final void checkPrecondition(boolean r1, Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "lazyMessage");
        if (r1 == true) goto L6;
        throwIllegalStateException((String) r2.invoke());
        return;
    }

    public static final void requirePrecondition(boolean r1, Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "lazyMessage");
        if (r1 == true) goto L6;
        throwIllegalArgumentException((String) r2.invoke());
        return;
    }
}
