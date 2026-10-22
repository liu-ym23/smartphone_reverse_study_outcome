package zi2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackActivity;
import com.bytedance.android.livesdk.livecommerce.playback.video.d;
import com.bytedance.android.livesdk.livecommerce.playback.video.e;
import el2.j;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements j {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    @Override // el2.j
    public final void c() {
        WeakReference<e> r0 = d.a;
        if (r0 == null) goto L8;
        e r1 = r0.get();
        if (r1 == null) goto L9;
        bj2.a.b("VideoPlayBackPlayController", "playVideo");
        r1.e.a();
        return;
    L9:
        return;
    }

    @Override // el2.j
    public final void d() {
        WeakReference<e> r0 = d.a;
        WeakReference<e> r1 = d.a;
        if (r1 == null) goto L8;
        e r2 = r1.get();
        if (r2 == null) goto L9;
        r2.d();
        return;
    L9:
        return;
    }

    @Override // el2.j
    public final void a(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        int r1 = ExplainPlaybackActivity.k;
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intent r0 = new Intent(r3, ExplainPlaybackActivity.class);
        r0.putExtra("key_explain_play_back_schema", r5);
        r3.startActivity(r0);
        bj2.a.b("ExplainPlaybackService", "open new shopping playback");
    }
}
