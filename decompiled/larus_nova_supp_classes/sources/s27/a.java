package s27;

import com.bytedance.mt.protector.ProtectorType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a<T> extends com.bytedance.mt.protector.impl.a {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.COLLECTIONS;
    }

    public a() {
    }

    public static <T> T tryProtect(Throwable r1, Class<?> r2) {
        return (T) com.bytedance.mt.protector.impl.a.tryProtect(protectorType, r1, r2);
    }
}
