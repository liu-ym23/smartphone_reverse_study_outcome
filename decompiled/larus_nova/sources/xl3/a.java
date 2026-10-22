package xl3;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564437a = 0;

    static {
    }

    public static byte[] a(String r100) {
        Charset r101 = Charsets.UTF_8;
        byte[] r102 = r100.getBytes(r101);
        String r103 = String.format("%04X", Arrays.copyOf(new Object[]{Integer.valueOf(r102.length)}, 1));
        if (r103 == null) goto L7;
        byte[] r104 = r103.getBytes(r101);
        ByteBuffer r105 = ByteBuffer.allocate(r104.length + r102.length);
        r105.put(r104);
        r105.put(r102);
        return r105.array();
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
