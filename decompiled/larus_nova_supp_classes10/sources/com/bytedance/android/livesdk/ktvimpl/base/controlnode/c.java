package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.f;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements p.a {
    public final /* synthetic */ AddMusicControlNode a;

    public final void c(MusicPanel r1, int r2) {
    }

    public c(AddMusicControlNode r1) {
        this.a = r1;
    }

    public final void a(MusicPanel r9, String r10, String r11) {
        Map<String, Long> r12 = this.a.m;
        Long r13 = null;
        String r14 = null;
        r14 = null;
        r13 = null;
        if (r9 == null) goto L7;
        KtvMusic r0 = r9.a;
        if (r0 == null) goto L7;
        Long r1 = Long.valueOf(r0.getId());
    L8:
        Long r15 = (Long) ((LinkedHashMap) r12).get(String.valueOf(r1));
        long r2 = 0;
        if (r15 == null) goto L11;
        long r3 = r15.longValue();
    L13:
        if (r3 != 0) goto L21;
        StringBuilder r4 = new StringBuilder("repeat other_resource success callback ;; songName == ");
        if (r9 == null) goto L19;
        KtvMusic r16 = r9.a;
        if (r16 == null) goto L19;
        r14 = r16.getMTitle();
    L19:
        r4.append(r14);
        r4.append(' ');
        ALogger.i("ktv_music_resource_download_opt_tag", r4.toString());
        return;
    L21:
        StringBuilder r5 = new StringBuilder("other_resource download success duration == ");
        long r6 = System.currentTimeMillis();
        Map<String, Long> r7 = this.a.m;
        if (r9 == null) goto L26;
        KtvMusic r8 = r9.a;
        if (r8 == null) goto L26;
        Long r17 = Long.valueOf(r8.getId());
    L27:
        Long r18 = (Long) ((LinkedHashMap) r7).get(String.valueOf(r17));
        if (r18 == null) goto L30;
        r2 = r18.longValue();
    L30:
        r5.append(r6 - r2);
        r5.append(" ;; songName == ");
        if (r9 == null) goto L35;
        KtvMusic r19 = r9.a;
        if (r19 == null) goto L35;
        String r20 = r19.getMTitle();
    L36:
        r5.append(r20);
        ALogger.i("ktv_music_resource_download_opt_tag", r5.toString());
        AddMusicControlNode r110 = this.a;
        f r21 = new f(DownloadResourceType.OTHER_RESOURCE, false);
        r110.getClass();
        AddMusicControlNode.n(r9, r21);
        Map<String, Long> r111 = this.a.m;
        if (r9 == null) goto L41;
        KtvMusic r22 = r9.a;
        if (r22 == null) goto L41;
        r13 = Long.valueOf(r22.getId());
    L41:
        r111.remove(String.valueOf(r13));
        return;
    L35:
        r20 = null;
    L26:
        r17 = null;
        goto L27
    L11:
        r3 = 0;
    L7:
        r1 = null;
        goto L8
    }

    public final void b(MusicPanel r6, int r7, String r8) {
        StringBuilder r9 = new StringBuilder("other_resource download fail duration == ");
        long r0 = System.currentTimeMillis();
        Map<String, Long> r10 = this.a.m;
        Long r2 = null;
        if (r6 == null) goto L7;
        KtvMusic r3 = r6.a;
        if (r3 == null) goto L7;
        Long r4 = Long.valueOf(r3.getId());
    L8:
        Long r11 = (Long) ((LinkedHashMap) r10).get(String.valueOf(r4));
        if (r11 == null) goto L11;
        long r5 = r11.longValue();
    L12:
        r9.append(r0 - r5);
        r9.append(" ;; songName == ");
        if (r6 == null) goto L17;
        KtvMusic r12 = r6.a;
        if (r12 == null) goto L17;
        String r13 = r12.getMTitle();
    L18:
        r9.append(r13);
        ALogger.i("ktv_music_resource_download_opt_tag", r9.toString());
        AddMusicControlNode r14 = this.a;
        f r15 = new f(DownloadResourceType.OTHER_RESOURCE, false);
        r14.getClass();
        AddMusicControlNode.n(r6, r15);
        Map<String, Long> r16 = this.a.m;
        if (r6 == null) goto L23;
        KtvMusic r17 = r6.a;
        if (r17 == null) goto L23;
        r2 = Long.valueOf(r17.getId());
    L23:
        r16.remove(String.valueOf(r2));
        return;
    L17:
        r13 = null;
        goto L18
    L11:
        r5 = 0;
    L7:
        r4 = null;
        goto L8
    }
}
