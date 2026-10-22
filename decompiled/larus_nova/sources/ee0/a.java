package ee0;

import com.bytedance.android.live.core.log.ALogger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472271a = 0;

    /* JADX INFO: renamed from: ee0.a$a, reason: collision with other inner class name */
    public static final class C5771a {
        public static String a(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            CharBuffer r101 = Charset.forName("UTF-8").newDecoder().decode(r100);     // Catch: Throwable -> L5
            r100.flip();     // Catch: Throwable -> L5
            return r101.toString();
        L5:
            th = move-exception;
            ALogger.e("byteBufferToString", "byteBufferToString error!", th);
            th.printStackTrace();
            return null;
        }
    }

    static {
        new SimpleDateFormat("HH:mm:ss.SSS");
    }
}
