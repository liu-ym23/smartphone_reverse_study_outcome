package nd2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f518754a;

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void c(MusicPanel r100, int r101) {
    }

    public a(c r100) {
        this.f518754a = r100;
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void a(MusicPanel r100, String r110, String r111) {
        Map<String, Long> r112 = this.f518754a.f518759b;
        Long r113 = null;
        String r114 = null;
        r114 = null;
        r113 = null;
        if (r100 == null) goto L7;
        KtvMusic r101 = r100.f153577a;
        if (r101 == null) goto L7;
        Long r102 = Long.valueOf(r101.getId());
    L8:
        Long r115 = (Long) ((LinkedHashMap) r112).get(String.valueOf(r102));
        long r103 = 0;
        if (r115 == null) goto L11;
        long r104 = r115.longValue();
    L13:
        if (r104 != 0) goto L21;
        StringBuilder r105 = new StringBuilder("repeat other_resource success callback ;; songName == ");
        if (r100 == null) goto L19;
        KtvMusic r106 = r100.f153577a;
        if (r106 == null) goto L19;
        r114 = r106.getMTitle();
    L19:
        r105.append(r114);
        r105.append(' ');
        ALogger.i("ktv_music_resource_download_opt_tag", r105.toString());
        return;
    L21:
        StringBuilder r107 = new StringBuilder("other_resource download success duration == ");
        long r108 = System.currentTimeMillis();
        Map<String, Long> r109 = this.f518754a.f518759b;
        if (r100 == null) goto L26;
        KtvMusic r116 = r100.f153577a;
        if (r116 == null) goto L26;
        Long r117 = Long.valueOf(r116.getId());
    L27:
        Long r118 = (Long) ((LinkedHashMap) r109).get(String.valueOf(r117));
        if (r118 == null) goto L30;
        r103 = r118.longValue();
    L30:
        r107.append(r108 - r103);
        r107.append(" ;; songName == ");
        if (r100 == null) goto L35;
        KtvMusic r119 = r100.f153577a;
        if (r119 == null) goto L35;
        String r120 = r119.getMTitle();
    L36:
        r107.append(r120);
        ALogger.i("ktv_music_resource_download_opt_tag", r107.toString());
        c r121 = this.f518754a;
        com.bytedance.android.live.ktv.common.model.bean.f r122 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
        r121.getClass();
        c.b(r100, r122);
        Map<String, Long> r123 = this.f518754a.f518759b;
        if (r100 == null) goto L41;
        KtvMusic r124 = r100.f153577a;
        if (r124 == null) goto L41;
        r113 = Long.valueOf(r124.getId());
    L41:
        r123.remove(String.valueOf(r113));
        return;
    L35:
        r120 = null;
    L26:
        r117 = null;
        goto L27
    L11:
        r104 = 0;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void b(MusicPanel r100, int r101, String r102) {
        StringBuilder r103 = new StringBuilder("other_resource download fail duration == ");
        long r104 = System.currentTimeMillis();
        Map<String, Long> r105 = this.f518754a.f518759b;
        Long r106 = null;
        if (r100 == null) goto L7;
        KtvMusic r107 = r100.f153577a;
        if (r107 == null) goto L7;
        Long r108 = Long.valueOf(r107.getId());
    L8:
        Long r109 = (Long) ((LinkedHashMap) r105).get(String.valueOf(r108));
        if (r109 == null) goto L11;
        long r110 = r109.longValue();
    L12:
        r103.append(r104 - r110);
        r103.append(" ;; songName == ");
        if (r100 == null) goto L17;
        KtvMusic r111 = r100.f153577a;
        if (r111 == null) goto L17;
        String r112 = r111.getMTitle();
    L18:
        r103.append(r112);
        ALogger.i("ktv_music_resource_download_opt_tag", r103.toString());
        c r113 = this.f518754a;
        com.bytedance.android.live.ktv.common.model.bean.f r114 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
        r113.getClass();
        c.b(r100, r114);
        Map<String, Long> r115 = this.f518754a.f518759b;
        if (r100 == null) goto L23;
        KtvMusic r116 = r100.f153577a;
        if (r116 == null) goto L23;
        r106 = Long.valueOf(r116.getId());
    L23:
        r115.remove(String.valueOf(r106));
        return;
    L17:
        r112 = null;
        goto L18
    L11:
        r110 = 0;
    L7:
        r108 = null;
        goto L8
    }
}
