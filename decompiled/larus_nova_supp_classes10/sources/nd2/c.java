package nd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final Map<String, Long> a;
    public final Map<String, Long> b;
    public final b c;
    public final p.a d;
    public final boolean e;

    public c(g r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "downloadCallback");
        this.d = r2;
        this.e = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new b(this);
    }

    public static final long a(c r4, MusicPanel r5) {
        r4.getClass();
        long r0 = System.currentTimeMillis();
        Map<String, Long> r6 = r4.a;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        Long r8 = (Long) r7.get(String.valueOf(r5.a.getId()));
        if (r8 == null) goto L5;
        long r9 = r8.longValue();
    L7:
        return r0 - r9;
    L5:
        r9 = 0;
        goto L7
    }

    public static void b(MusicPanel r1, com.bytedance.android.live.ktv.common.model.bean.f r2) {
        KtvContext.Companion.getClass();
        Map r0 = (Map) KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r0.put(KtvUtilsKt.c(r1), r2);
        ALogger.i("ktv_music_resource_download_opt_tag", r2.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r0);
    }
}
