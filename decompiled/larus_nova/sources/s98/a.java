package s98;

import android.os.Trace;
import com.larus.avlink.gallery.processor.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f541120a = 0;

    static {
    }

    public static Object a(int r100, m r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        Trace.beginSection(StringsKt.take("DoraAlbum#video_sdk_call_t" + r100, 120));
        Object r102 = r101.invoke();     // Catch: Throwable -> L6
        Trace.endSection();
        return r102;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
