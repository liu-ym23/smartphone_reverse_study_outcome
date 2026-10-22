package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.internal.format.parser.ParseException;
import kotlinx.datetime.internal.format.parser.c;

/* JADX INFO: loaded from: classes42.dex */
public abstract class a<T, U extends kotlinx.datetime.internal.format.parser.c<U>> implements v<T> {
    public abstract kotlinx.datetime.internal.format.f<U> b();

    public abstract U c();

    public abstract T d(U r100);

    public a() {
    }

    @Override // kotlinx.datetime.format.v
    public final T a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        kotlinx.datetime.internal.format.parser.u<U> r101 = b().f505287c;     // Catch: ParseException -> L13
        Intrinsics.checkNotNullParameter(r101, "commands");     // Catch: ParseException -> L13
        return d(kotlinx.datetime.internal.format.parser.m.a(r101, r100, c()));
    L6:
        e = move-exception;
        String r102 = e.getMessage();
        if (r102 != null) goto L10;
        String r103 = "The value parsed from '" + r100 + "' is invalid";
    L12:
        throw new DateTimeFormatException(r103, e);
    L10:
        r103 = r102 + " (when parsing '" + r100 + "')";
    L13:
        e = move-exception;
        throw new DateTimeFormatException("Failed to parse value from '" + r100 + '\'', e);
    }
}
