package r27;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;
import com.bytedance.mt.protector.impl.ProtectorMethod;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    @ProtectorMethod(exceptions = {IllegalArgumentException.class})
    public static <T extends Enum<T>> T a(Class<T> r100, String r101) {
        if (c.b() == false) goto L17;
        return (T) Enum.valueOf(r100, r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.ENUM, th);
        if (r102 == null) goto L15;
        Object r103 = r102.f265674a;
        if ((r103 instanceof String) == true) goto L12;
        return null;
    L12:
        return (T) Enum.valueOf(r100, (String) r103);
    L15:
        throw th;
    L17:
        return (T) Enum.valueOf(r100, r101);
    }
}
