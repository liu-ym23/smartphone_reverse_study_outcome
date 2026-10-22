package xl3;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final w6.a a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        byte[] r1 = new byte[4];
        this.a.read(r1);
        Charset r3 = Charsets.UTF_8;
        byte[] r2 = new byte[CastIntegerProtector.parseInt(new String(r1, r3), 16)];     // Catch: NumberFormatException -> L5
        this.a.read(r2);     // Catch: NumberFormatException -> L5
        Class<? extends Object>[] r4 = yl3.a.a;     // Catch: NumberFormatException -> L5
        byte[] r5 = yl3.a.b(new String(r2, r3));     // Catch: NumberFormatException -> L5
        ByteBuffer r0 = ByteBuffer.allocate(r5.length + 4);     // Catch: NumberFormatException -> L5
        r0.putInt(r5.length);     // Catch: NumberFormatException -> L5
        r0.put(r5);     // Catch: NumberFormatException -> L5
        this.a.write(r0.array());     // Catch: NumberFormatException -> L5
        return;
    }

    public final Context getContext() {
        return this.b;
    }

    public c(com.bytedance.android.androidadbbindings.a r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
