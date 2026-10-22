package ga2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f480545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f480546b = null;

    public c() {
    }

    static {
        f480546b = new c();
        ArrayList r100 = new ArrayList();
        f480545a = r100;
        r100.add(b.f480544a);
    }

    @Override // ga2.a
    public final void a(f<?> r100, k r101) {
        Iterator r102 = ((ArrayList) f480545a).iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).a(r100, r101);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("PublicScreenTextMessageMonitor", e);
        goto L4
    }
}
