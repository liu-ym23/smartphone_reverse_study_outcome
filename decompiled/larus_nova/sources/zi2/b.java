package zi2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackActivity;
import com.bytedance.android.livesdk.livecommerce.playback.video.d;
import com.bytedance.android.livesdk.livecommerce.playback.video.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import el2.j;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f572232a = null;

    public b() {
    }

    static {
        f572232a = new b();
    }

    @Override // el2.j
    public final void c() {
        WeakReference<e> r100 = d.f150010a;
        if (r100 == null) goto L8;
        e r101 = r100.get();
        if (r101 == null) goto L9;
        bj2.a.b("VideoPlayBackPlayController", "playVideo");
        r101.f150016e.a();
        return;
    L9:
        return;
    }

    @Override // el2.j
    public final void d() {
        WeakReference<e> r100 = d.f150010a;
        WeakReference<e> r101 = d.f150010a;
        if (r101 == null) goto L8;
        e r102 = r101.get();
        if (r102 == null) goto L9;
        r102.d();
        return;
    L9:
        return;
    }

    @Override // el2.j
    public final void a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        int r102 = ExplainPlaybackActivity.f149903k;
        String r103 = r101.toString();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "url");
        Intent r104 = new Intent(r100, ExplainPlaybackActivity.class);
        r104.putExtra("key_explain_play_back_schema", r103);
        r100.startActivity(r104);
        bj2.a.b("ExplainPlaybackService", "open new shopping playback");
    }
}
