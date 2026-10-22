package ewc;

import javax.annotation.Nullable;
import org.jsoup.helper.ValidationException;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public b() {
    }

    public static void a(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new ValidationException("Must be true");
    }

    public static void b(@Nullable String r100) {
        if (r100 == null) goto L7;
        if (r100.length() == 0) goto L7;
        return;
    L7:
        throw new ValidationException("String must not be empty");
    }

    public static void d(@Nullable Object r100) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new ValidationException("Object must not be null");
    }

    public static void c(@Nullable String r100, String r101) {
        if (r100 == null) goto L7;
        if (r100.length() == 0) goto L7;
        return;
    L7:
        throw new ValidationException(r101);
    }
}
