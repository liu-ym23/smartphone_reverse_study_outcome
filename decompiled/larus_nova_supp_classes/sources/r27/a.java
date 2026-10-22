package r27;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    @ProtectorMethod(exceptions = {IllegalArgumentException.class})
    public static <T extends Enum<T>> T a(Class<T> r1, String r2) {
        if (c.b() == false) goto L17;
        return (T) Enum.valueOf(r1, r2);
    L6:
        th = move-exception;
        f r0 = c.a(ProtectorType.ENUM, th);
        if (r0 == null) goto L15;
        Object r3 = r0.a;
        if ((r3 instanceof String) == true) goto L12;
        return null;
    L12:
        return (T) Enum.valueOf(r1, (String) r3);
    L15:
        throw th;
    L17:
        return (T) Enum.valueOf(r1, r2);
    }
}
