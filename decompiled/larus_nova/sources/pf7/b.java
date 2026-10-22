package pf7;

import android.media.AudioRecord;
import com.bytedance.supervisor.token.Token;
import fna.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements c {
    public b() {
    }

    public static void f(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    @Override // pf7.c
    public final void b(AudioRecord r100, Token r101) {
        Intrinsics.checkNotNullParameter(r100, "record");
        Intrinsics.checkNotNullParameter(r101, "token");
        if (g.d() == true) goto L5;
        f(r100);
        return;
    L5:
        f(r100);
        hna.a.b(r100.hashCode());
    }
}
