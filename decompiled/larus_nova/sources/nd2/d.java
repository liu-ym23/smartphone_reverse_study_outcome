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

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f518763a;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f518763a = new ConcurrentHashMap();
    }

    public static void b(MusicPanel r100, com.bytedance.android.live.ktv.common.model.bean.f r101) {
        KtvContext.Companion.getClass();
        Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r102 = KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r102.put(KtvUtilsKt.c(r100), r101);
        ALogger.i("ktv_music_resource_download_opt_tag", r101.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r102);
    }

    public static void a(d r110, MusicPanel r111, p.a r112, boolean r113) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "panel");
        Intrinsics.checkNotNullParameter(r112, "downloadCallback");
        if (h.a() == false) goto L8;
        Intrinsics.checkNotNullParameter(r111, "panel");
        Intrinsics.checkNotNullParameter(r112, "downloadCallback");
        Boolean r114 = r110.f518763a.get(String.valueOf(r111.c()));
        Boolean r100 = Boolean.TRUE;
        if (Intrinsics.areEqual(r114, r100) == true) goto L18;
        r110.f518763a.put(String.valueOf(r111.c()), r100);
        r111.f153595s = 0;
        r111.f153578b = 2;
        boolean r115 = KtvUtilsKt.a(r111, true);
        b(r111, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        f r101 = new f(r110, r111, r112);
        com.bytedance.livesdk.ktvimpl.base.download.a r116 = com.bytedance.livesdk.ktvimpl.base.download.a.f256305c;
        KtvMusic r117 = r111.f153577a;
        l r118 = new l(r115, false, 60);
        DownloadPriority r119 = DownloadPriority.HIGH;
        r116.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.c(r117, r118, r101, r119, "join chorus");
        return;
    L18:
        return;
    L8:
        Boolean r102 = r110.f518763a.get(String.valueOf(r111.c()));
        Boolean r103 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r102, r103)) == false) goto L16;
        r110.f518763a.put(String.valueOf(r111.c()), r103);
        c r120 = new c(new g(r110, r112), r113);
        Intrinsics.checkNotNullParameter(r111, "panel");
        r111.f153595s = 0;
        r111.f153578b = 2;
        r120.f518758a.put(String.valueOf(r111.f153577a.getId()), Long.valueOf(System.currentTimeMillis()));
        boolean r121 = KtvUtilsKt.a(r111, true);
        c.b(r111, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        KtvMusicManager.e(KtvMusicManager.f70044m, r111, r120.f518760c, false, new m(r121, !r121, 57), r120.f518762e, 4);
        if (h.o() == false) goto L13;
        pd2.d.f528658n.getClass();
        pd2.d.f528656l.f("download", new pd2.b(r111, null));
        return;
    L13:
        pd2.d.f528658n.getClass();
        pd2.d.t("download", r111, null);
        return;
    }
}
