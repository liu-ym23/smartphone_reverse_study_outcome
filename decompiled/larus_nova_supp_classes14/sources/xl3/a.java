package xl3;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static byte[] a(String r5) {
        Charset r0 = Charsets.UTF_8;
        byte[] r6 = r5.getBytes(r0);
        String r1 = String.format("%04X", Arrays.copyOf(new Object[]{Integer.valueOf(r6.length)}, 1));
        if (r1 == null) goto L7;
        byte[] r2 = r1.getBytes(r0);
        ByteBuffer r3 = ByteBuffer.allocate(r2.length + r6.length);
        r3.put(r2);
        r3.put(r6);
        return r3.array();
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
