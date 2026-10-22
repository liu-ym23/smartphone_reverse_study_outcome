package nd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f518758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f518759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f518760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p.a f518761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f518762e;

    public c(g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadCallback");
        this.f518761d = r100;
        this.f518762e = r101;
        this.f518758a = new LinkedHashMap();
        this.f518759b = new LinkedHashMap();
        this.f518760c = new b(this);
    }

    public static final long a(c r100, MusicPanel r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis();
        Map<String, Long> r103 = r100.f518758a;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Long r105 = (Long) r104.get(String.valueOf(r101.f153577a.getId()));
        if (r105 == null) goto L5;
        long r106 = r105.longValue();
    L7:
        return r102 - r106;
    L5:
        r106 = 0;
        goto L7
    }

    public static void b(MusicPanel r100, com.bytedance.android.live.ktv.common.model.bean.f r101) {
        KtvContext.Companion.getClass();
        Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r102 = KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r102.put(KtvUtilsKt.c(r100), r101);
        ALogger.i("ktv_music_resource_download_opt_tag", r101.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r102);
    }
}
