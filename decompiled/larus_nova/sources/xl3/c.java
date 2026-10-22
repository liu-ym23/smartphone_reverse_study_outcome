package xl3;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w6.a f564439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f564440b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        byte[] r100 = new byte[4];
        this.f564439a.read(r100);
        Charset r101 = Charsets.UTF_8;
        byte[] r102 = new byte[CastIntegerProtector.parseInt(new String(r100, r101), 16)];     // Catch: NumberFormatException -> L5
        this.f564439a.read(r102);     // Catch: NumberFormatException -> L5
        Class<? extends Object>[] r103 = yl3.a.f568307a;     // Catch: NumberFormatException -> L5
        byte[] r104 = yl3.a.b(new String(r102, r101));     // Catch: NumberFormatException -> L5
        ByteBuffer r105 = ByteBuffer.allocate(r104.length + 4);     // Catch: NumberFormatException -> L5
        r105.putInt(r104.length);     // Catch: NumberFormatException -> L5
        r105.put(r104);     // Catch: NumberFormatException -> L5
        this.f564439a.write(r105.array());     // Catch: NumberFormatException -> L5
        return;
    }

    public final Context getContext() {
        return this.f564440b;
    }

    public c(com.bytedance.android.androidadbbindings.a r100, Context r101) {
        this.f564439a = r100;
        this.f564440b = r101;
    }
}
