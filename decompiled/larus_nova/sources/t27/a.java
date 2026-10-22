package t27;

import com.bytedance.mt.protector.ProtectorType;

/* JADX INFO: loaded from: classes3.dex */
public class a<T> extends com.bytedance.mt.protector.impl.a {
    private static ProtectorType protectorType;

    static {
        protectorType = ProtectorType.CAST_COLOR;
    }

    public a() {
    }

    public static <T> T tryProtect(Throwable r100, Class<?> r101) {
        return (T) com.bytedance.mt.protector.impl.a.tryProtect(protectorType, r100, r101);
    }
}
