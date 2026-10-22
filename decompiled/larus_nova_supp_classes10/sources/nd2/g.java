package nd2;

import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements p.a {
    public final /* synthetic */ d a;
    public final /* synthetic */ p.a b;

    public g(d r1, p.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void c(MusicPanel r2, int r3) {
        this.b.c(r2, r3);
    }

    public final void a(MusicPanel r3, String r4, String r5) {
        this.b.a(r3, r4, r5);
        ConcurrentHashMap<String, Boolean> r6 = this.a.a;
        if (r3 == null) goto L5;
        String r7 = String.valueOf(r3.c());
    L6:
        if (r6 == null) goto L10;
        TypeIntrinsics.asMutableMap(r6).remove(r7);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        r7 = null;
        goto L6
    }

    public final void b(MusicPanel r3, int r4, String r5) {
        this.b.b(r3, r4, r5);
        ConcurrentHashMap<String, Boolean> r6 = this.a.a;
        if (r3 == null) goto L5;
        String r7 = String.valueOf(r3.c());
    L6:
        if (r6 == null) goto L10;
        TypeIntrinsics.asMutableMap(r6).remove(r7);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        r7 = null;
        goto L6
    }
}
