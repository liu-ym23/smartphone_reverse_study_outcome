package xy4;

import android.os.SystemClock;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f565404a;

    public a() {
    }

    public final void a(String r110, String r111, int r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "channel");
        if (Intrinsics.areEqual(r110, EChannel.DOCS_FULLPKG_CHANNEL.toString()) == false) goto L9;
        long r100 = SystemClock.uptimeMillis();
        int r114 = b.f565405a;
        long r101 = r100 - this.f565404a;
        if (r111 != null) goto L7;
        r111 = "error";
    L7:
        b.a(r101, false, r111, r112, r113);
        return;
    }
}
