package nd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.m;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final ConcurrentHashMap<String, Boolean> a;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = new ConcurrentHashMap();
    }

    public static void b(MusicPanel r1, com.bytedance.android.live.ktv.common.model.bean.f r2) {
        KtvContext.Companion.getClass();
        Map r0 = (Map) KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r0.put(KtvUtilsKt.c(r1), r2);
        ALogger.i("ktv_music_resource_download_opt_tag", r2.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r0);
    }

    public static void a(d r11, MusicPanel r12, p.a r13, boolean r14) {
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "panel");
        Intrinsics.checkNotNullParameter(r13, "downloadCallback");
        if (h.a() == false) goto L8;
        Intrinsics.checkNotNullParameter(r12, "panel");
        Intrinsics.checkNotNullParameter(r13, "downloadCallback");
        Boolean r15 = r11.a.get(String.valueOf(r12.c()));
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r15, r0) == true) goto L18;
        r11.a.put(String.valueOf(r12.c()), r0);
        r12.s = 0;
        r12.b = 2;
        boolean r16 = KtvUtilsKt.a(r12, true);
        b(r12, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        f r1 = new f(r11, r12, r13);
        com.bytedance.livesdk.ktvimpl.base.download.a r17 = com.bytedance.livesdk.ktvimpl.base.download.a.c;
        KtvMusic r18 = r12.a;
        l r19 = new l(r16, false, 60);
        DownloadPriority r110 = DownloadPriority.HIGH;
        r17.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.c(r18, r19, r1, r110, "join chorus");
        return;
    L18:
        return;
    L8:
        Boolean r2 = r11.a.get(String.valueOf(r12.c()));
        Boolean r3 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r2, r3)) == false) goto L16;
        r11.a.put(String.valueOf(r12.c()), r3);
        c r111 = new c(new g(r11, r13), r14);
        Intrinsics.checkNotNullParameter(r12, "panel");
        r12.s = 0;
        r12.b = 2;
        r111.a.put(String.valueOf(r12.a.getId()), Long.valueOf(System.currentTimeMillis()));
        boolean r112 = KtvUtilsKt.a(r12, true);
        c.b(r12, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        KtvMusicManager.e(KtvMusicManager.m, r12, r111.c, false, new m(r112, !r112, 57), r111.e, 4);
        if (h.o() == false) goto L13;
        pd2.d.n.getClass();
        pd2.d.l.f("download", new pd2.b(r12, null));
        return;
    L13:
        pd2.d.n.getClass();
        pd2.d.t("download", r12, null);
        return;
    }
}
