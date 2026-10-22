package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes42.dex */
public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;

    /* JADX INFO: loaded from: classes5.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r100);
    }

    static {
        byte[] r100 = new byte[0];
        EMPTY_BYTE_ARRAY = r100;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r100);
    }

    public static boolean isValidUtf8(byte[] r100) {
        return Utf8.isValidUtf8(r100);
    }

    public static String toStringUtf8(byte[] r100) {
        return new String(r100, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }
}
