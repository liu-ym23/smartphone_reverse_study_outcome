package com.bytedance.livesdk.ktvimpl.base.download;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.ktv.common.music.download.h;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.livesdk.ktvcommon.download.KtvDownloadManager;
import com.bytedance.livesdk.ktvcommon.download.api.f;
import com.bytedance.livesdk.ktvcommon.download.c;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.bytedance.livesdk.ktvcommon.download.model.d;
import com.bytedance.livesdk.ktvcommon.download.model.l;
import com.bytedance.livesdk.ktvcommon.download.model.m;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yk6.e;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f256303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, C3640a> f256304b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f256305c = null;

    /* JADX INFO: renamed from: com.bytedance.livesdk.ktvimpl.base.download.a$a, reason: collision with other inner class name */
    public static final class C3640a implements com.bytedance.livesdk.ktvcommon.download.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f256306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.livesdk.ktvcommon.download.api.a f256307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function2<String, C3640a, Unit> f256308c;

        @Override // com.bytedance.livesdk.ktvcommon.download.api.a
        public final void e(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            dl6.a.b(new String[]{"KtvDownloadHelper", "Batch progress: songId=" + this.f256306a + ", progress=" + r101 + '%'});
            com.bytedance.livesdk.ktvcommon.download.api.a r102 = this.f256307b;
            if (r102 == null) goto L6;
            r102.e(r100, r101);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C3640a(String r100, com.bytedance.livesdk.ktvcommon.download.api.a r101, Function2<? super String, ? super C3640a, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "songId");
            Intrinsics.checkNotNullParameter(r102, "onCleanup");
            this.f256306a = r100;
            this.f256307b = r101;
            this.f256308c = r102;
        }

        @Override // com.bytedance.livesdk.ktvcommon.download.api.a
        public final void c(String r100, String r101, MusicType r102) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r102, "resourceType");
            dl6.a.b(new String[]{"KtvDownloadHelper", "Task cancelled: songId=" + this.f256306a + ", type=" + r102});
            com.bytedance.livesdk.ktvcommon.download.api.a r103 = this.f256307b;
            if (r103 == null) goto L6;
            r103.c(r100, r101, r102);
            return;
        }

        @Override // com.bytedance.livesdk.ktvcommon.download.api.a
        public final void a(String r100, String r101, DownloadState r102, d r103) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            Intrinsics.checkNotNullParameter(r101, "songId");
            Intrinsics.checkNotNullParameter(r102, "state");
            Intrinsics.checkNotNullParameter(r103, "result");
            if (r102 != DownloadState.FAILED) goto L5;
            dl6.a.a(new String[]{"KtvDownloadHelper", "Task failed: songId=" + r101 + ", type=" + r103.f255958c + ", error=" + r103.f255962g});
        L5:
            com.bytedance.livesdk.ktvcommon.download.api.a r104 = this.f256307b;
            if (r104 == null) goto L9;
            r104.a(r100, r101, r102, r103);
            return;
        }

        @Override // com.bytedance.livesdk.ktvcommon.download.api.a
        public final void d(String r100, String r101, List<d> r102, List<d> r103) {
            Intrinsics.checkNotNullParameter(r100, "batchId");
            Intrinsics.checkNotNullParameter(r101, "songId");
            Intrinsics.checkNotNullParameter(r102, "successResults");
            Intrinsics.checkNotNullParameter(r103, "failedResults");
            dl6.a.b(new String[]{"KtvDownloadHelper", "Batch completed: songId=" + r101 + ", success=" + r102.size() + ", failed=" + r103.size()});
            com.bytedance.livesdk.ktvcommon.download.api.a r104 = this.f256307b;
            if (r104 == null) goto L5;
            r104.d(r100, r101, r102, r103);
        L5:
            this.f256308c.invoke(r100, this);
        }

        @Override // com.bytedance.livesdk.ktvcommon.download.api.a
        public final void b(String r110, String r111, String r112, MusicType r113, int r114, DownloadPriority r115) {
            Intrinsics.checkNotNullParameter(r110, "batchId");
            Intrinsics.checkNotNullParameter(r111, "songId");
            Intrinsics.checkNotNullParameter(r112, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r113, "resourceType");
            Intrinsics.checkNotNullParameter(r115, "priority");
            dl6.a.b(new String[]{"KtvDownloadHelper", "Download progress: songId=" + r111 + ", type=" + r113 + ", progress=" + r114 + '%'});
            com.bytedance.livesdk.ktvcommon.download.api.a r100 = this.f256307b;
            if (r100 == null) goto L6;
            r100.b(r110, r111, r112, r113, r114, r115);
            return;
        }
    }

    public a() {
    }

    static {
        f256305c = new a();
        KtvDownloadManager.f255905g.getClass();
        f256303a = (c) KtvDownloadManager.f255904f.getValue();
        f256304b = new LinkedHashMap();
        f.f255932b.getClass();
        boolean r100 = true;
        if (f.f255931a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (f.f255931a != null) goto L13;
        r100 = false;
    L13:
        if (r100 == true) goto L15;
        e r102 = new e();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r102, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L18
        f.f255931a = r102;     // Catch: Throwable -> L18
        dl6.a.b(new String[]{"KtvDownloadHelper", "Platform configuration initialized"});     // Catch: Throwable -> L18
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void b() {
        Iterator r100 = ((LinkedHashMap) f256304b).keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        String r101 = (String) r100.next();
        f256305c.getClass();
        f256303a.d(r101);     // Catch: Exception -> L8
        dl6.a.b(new String[]{"KtvDownloadHelper", "Cancel download success: batchId=" + r101});     // Catch: Exception -> L8
    L10:
        C3640a r102 = f256304b.remove(r101);
        if (r102 == null) goto L4;
        f256303a.b(r101, r102);
    L8:
        e = move-exception;
        dl6.a.b(new String[]{"KtvDownloadHelper", "Cancel download failed: batchId=" + r101 + ", error=" + e.getMessage()});
        goto L10
    L13:
        ((LinkedHashMap) f256304b).clear();
        f256303a.release();
        dl6.a.b(new String[]{"KtvDownloadHelper", "Global business download manager destroyed"});
    }

    public static void c(KtvMusic r210, l r211, com.bytedance.livesdk.ktvcommon.download.api.a r212, DownloadPriority r213, String r214) {
        Intrinsics.checkNotNullParameter(r210, "ktvMusic");
        Intrinsics.checkNotNullParameter(r211, "config");
        Intrinsics.checkNotNullParameter(r213, "priority");
        Intrinsics.checkNotNullParameter(r214, "source");
        ArrayList r100 = new ArrayList();
        if (r211.f255987c == false) goto L10;
        a r101 = f256305c;
        String r102 = r210.getMIdStr();
        String r103 = r210.getMidiUrl();
        if (r103 != null) goto L7;
        String r104 = "";
    L8:
        m r110 = new m(r102, r104, null, null, null, null, null, null, null, 8188);
        r101.getClass();
        r100.add(a(r110, r110.f255991a.toString(), MusicType.MIDI, r110.f255992b, KtvDownloadHelper$createMidiTask$1.INSTANCE, "musicpack_midi"));
        goto L10
    L7:
        r104 = r103;
    L10:
        if (r211.f255988d == false) goto L20;
        a r105 = f256305c;
        String r106 = r210.getMIdStr();
        List<String> r107 = r210.getMLyricUrlList();
        if (r107 == null) goto L17;
        String r108 = (String) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L17;
        String r111 = r108;
    L18:
        m r112 = new m(r106, null, r111, null, null, null, null, null, null, 8182);
        r105.getClass();
        r100.add(a(r112, r112.f255991a, MusicType.LYRIC, r112.f255994d, KtvDownloadHelper$createLyricTask$1.INSTANCE, "musicpack_lyrics"));
    L17:
        r111 = "";
    L20:
        if (r211.f255989e == false) goto L46;
        if (r210.getMFullTrack() == null) goto L46;
        a r109 = f256305c;
        String r113 = r210.getMIdStr();
        AudioInfo r114 = r210.getMFullTrack();
        if (r114 == null) goto L29;
        String r115 = r114.getMUrl();
        if (r115 == null) goto L29;
        String r116 = r115;
    L30:
        AudioInfo r117 = r210.getMFullTrack();
        if (r117 == null) goto L36;
        String r118 = r117.getAudioIdStr();
        if (r118 == null) goto L36;
        String r119 = r118;
    L37:
        AudioInfo r120 = r210.getMFullTrack();
        if (r120 == null) goto L43;
        String r121 = r120.getFileHash();
        if (r121 == null) goto L43;
        String r122 = r121;
    L44:
        m r123 = new m(r113, null, null, r122, r119, r116, null, null, null, 8078);
        r109.getClass();
        r100.add(a(r123, r123.f255991a, MusicType.FULL_TRACK, r123.f255997g, KtvDownloadHelper$createFullTrackTask$1.INSTANCE, "musicpack_full_track"));
    L43:
        r122 = "";
    L36:
        r119 = "";
    L29:
        r116 = "";
    L46:
        if (r211.f255990f == true) goto L48;
    L71:
        Iterator r124 = r100.iterator();
    L72:
        Object r125 = null;
        if (r124.hasNext() == false) goto L80;
        Object r126 = r124.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.f) r126).f255976c != MusicType.MIDI) goto L77;
        boolean r127 = true;
    L78:
        if (r127 == false) goto L72;
    L81:
        com.bytedance.livesdk.ktvcommon.download.model.f r128 = (com.bytedance.livesdk.ktvcommon.download.model.f) r126;
        Iterator r129 = r100.iterator();
    L83:
        if (r129.hasNext() == false) goto L90;
        Object r130 = r129.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.f) r130).f255976c != MusicType.LYRIC) goto L87;
        boolean r131 = true;
    L88:
        if (r131 == false) goto L83;
    L91:
        com.bytedance.livesdk.ktvcommon.download.model.f r132 = (com.bytedance.livesdk.ktvcommon.download.model.f) r130;
        Iterator r133 = r100.iterator();
    L93:
        if (r133.hasNext() == false) goto L100;
        Object r134 = r133.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.f) r134).f255976c != MusicType.FULL_TRACK) goto L97;
        boolean r135 = true;
    L98:
        if (r135 == false) goto L93;
    L101:
        com.bytedance.livesdk.ktvcommon.download.model.f r136 = (com.bytedance.livesdk.ktvcommon.download.model.f) r134;
        Iterator r137 = r100.iterator();
    L103:
        if (r137.hasNext() == false) goto L110;
        Object r138 = r137.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.f) r138).f255976c != MusicType.ACCOMPANIMENT_TRACK) goto L107;
        boolean r139 = true;
    L108:
        if (r139 == false) goto L103;
        r125 = r138;
        goto L110
    L107:
        r139 = false;
    L110:
        com.bytedance.livesdk.ktvcommon.download.model.f r140 = (com.bytedance.livesdk.ktvcommon.download.model.f) r125;
        if (r136 == null) goto L113;
        boolean r141 = true;
    L114:
        if (r140 == null) goto L116;
        boolean r142 = true;
    L118:
        if (r141 == false) goto L122;
        if (r142 == true) goto L122;
        List r143 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(new com.bytedance.livesdk.ktvcommon.download.model.f[]{r136, r132, r128}), "原唱+歌词+midi"));
    L136:
        if (r143.isEmpty() == false) goto L139;
        dl6.a.a(new String[]{"KtvDownloadHelper", "createMusicDownloadBatches failed: batches is empty for songId=" + r210.getMIdStr()});
        return;
    L139:
        dl6.a.b(new String[]{"KtvDownloadHelper", "downloadMusic: songId=" + r210.getMIdStr() + ", source=" + r214 + ", batch count: " + r143.size()});
        List r144 = f256303a.c(r210.getMIdStr(), r213, r143);
        if (r144.isEmpty() == false) goto L143;
        dl6.a.a(new String[]{"KtvDownloadHelper", "submitSongResourceBatches failed for songId=" + r210.getMIdStr()});
        return;
    L143:
        Iterator r145 = r144.iterator();
    L145:
        if (r145.hasNext() == false) goto L147;
        String r146 = (String) r145.next();
        a r147 = f256305c;
        String r148 = r210.getMIdStr();
        r147.getClass();
        C3640a r149 = new C3640a(r148, r212, KtvDownloadHelper$createBatchCallbackWrapper$1.INSTANCE);
        f256303a.a(r146, r149);
        f256304b.put(r146, r149);
        goto L145
    L147:
        return;
    L122:
        if (r141 == true) goto L125;
        if (r142 == false) goto L125;
        r143 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(new com.bytedance.livesdk.ktvcommon.download.model.f[]{r140, r132, r128}), "伴奏+歌词+midi"));
    L125:
        if (r141 == false) goto L134;
        if (r142 == false) goto L134;
        if (r211.f255986b == false) goto L131;
        r143 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(new com.bytedance.livesdk.ktvcommon.download.model.f[]{r136, r140, r132, r128}), "原唱+伴奏+歌词+midi"));
        goto L136
    L131:
        if (r211.f255985a == false) goto L133;
        r143 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c[]{new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(r136), KtvMusic.ORIGIN_TAG), new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(new com.bytedance.livesdk.ktvcommon.download.model.f[]{r140, r132, r128}), "伴奏+歌词+midi")});
        goto L136
    L133:
        r143 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c[]{new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(r140), "伴奏"), new com.bytedance.livesdk.ktvcommon.download.model.c(CollectionsKt.listOfNotNull(new com.bytedance.livesdk.ktvcommon.download.model.f[]{r136, r132, r128}), "原唱+歌词+midi")});
    L134:
        r143 = CollectionsKt.emptyList();
        goto L136
    L116:
        r142 = false;
        goto L118
    L113:
        r141 = false;
        goto L114
    L97:
        r135 = false;
        goto L98
    L100:
        r134 = null;
        goto L101
    L87:
        r131 = false;
        goto L88
    L90:
        r130 = null;
        goto L91
    L77:
        r127 = false;
        goto L78
    L80:
        r126 = null;
        goto L81
    L48:
        if (r210.getMAccompanimentTrack() == null) goto L71;
        a r150 = f256305c;
        String r151 = r210.getMIdStr();
        AudioInfo r152 = r210.getMAccompanimentTrack();
        if (r152 == null) goto L55;
        String r153 = r152.getMUrl();
        if (r153 == null) goto L55;
        String r154 = r153;
    L56:
        AudioInfo r155 = r210.getMAccompanimentTrack();
        if (r155 == null) goto L62;
        String r156 = r155.getAudioIdStr();
        if (r156 == null) goto L62;
        String r157 = r156;
    L63:
        AudioInfo r158 = r210.getMAccompanimentTrack();
        if (r158 == null) goto L69;
        String r159 = r158.getFileHash();
        if (r159 == null) goto L69;
        String r160 = r159;
    L70:
        m r161 = new m(r151, null, null, null, null, null, r160, r157, r154, 7294);
        r150.getClass();
        r100.add(a(r161, r161.f255991a, MusicType.ACCOMPANIMENT_TRACK, r161.f256000j, KtvDownloadHelper$createAccompanyTask$1.INSTANCE, "musicpack_accompany"));
    L69:
        r160 = "";
    L62:
        r157 = "";
    L55:
        r154 = "";
        goto L56
    }

    public static void d(String r210, String r211, String r212, com.bytedance.livesdk.ktvimpl.base.midi.a r213, DownloadPriority r214) {
        Intrinsics.checkNotNullParameter(r210, "songId");
        Intrinsics.checkNotNullParameter(r211, "lyricUrl");
        Intrinsics.checkNotNullParameter(r212, "midiUrl");
        Intrinsics.checkNotNullParameter(r214, "priority");
        Intrinsics.checkNotNullParameter("AndroidMidiDataManager", "source");
        d5.c(r210);
        ArrayList r110 = new ArrayList();
        r110.add(a(new m(r210, null, r211, null, null, null, null, null, null, 8182), r210, MusicType.LYRIC, r211, KtvDownloadHelper$createLyricTask$2.INSTANCE, "musicpack_lyrics"));
        r110.add(a(new m(r210, r212, null, null, null, null, null, null, null, 8188), r210, MusicType.MIDI, r212, KtvDownloadHelper$createMidiTask$2.INSTANCE, "musicpack_midi"));
        List r100 = CollectionsKt.listOf(new com.bytedance.livesdk.ktvcommon.download.model.c(r110, "歌词+MIDI"));
        if (r100.isEmpty() == false) goto L6;
        dl6.a.a(new String[]{"KtvDownloadHelper", "startDownload failed: batches is empty for songId=" + r210});
        return;
    L6:
        dl6.a.b(new String[]{"KtvDownloadHelper", "midi lyric startDownload: songId=" + r210 + ", priority=" + r214 + ", source=AndroidMidiDataManager"});
        List r101 = f256303a.c(r210, r214, r100);
        if (r101.isEmpty() == false) goto L10;
        dl6.a.a(new String[]{"KtvDownloadHelper", "submitSongResourceBatches failed for songId=" + r210});
        return;
    L10:
        Iterator r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        String r103 = (String) r102.next();
        f256305c.getClass();
        C3640a r104 = new C3640a(r210, r213, KtvDownloadHelper$createBatchCallbackWrapper$1.INSTANCE);
        f256303a.a(r103, r104);
        f256304b.put(r103, r104);
        goto L12
    }

    public static com.bytedance.livesdk.ktvcommon.download.model.f a(m r110, String r111, MusicType r112, String r113, Function1 r114, String r115) {
        String r116 = (String) r114.invoke(r110);
        String r100 = h.f(r116);
        if (r100 == null) goto L24;
        if (r116.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        String r102 = null;
    L10:
        String r103 = r102;
    L18:
        if (r103 == null) goto L22;
        dl6.a.b(new String[]{"KtvDownloadHelper", "createDownloadTaskParam: songId=" + r111 + ", resourceType=" + r112 + ", url=" + r113 + ", fullSavePath=" + r116 + ", dirSavePath=" + r100 + ", fileName=" + r103});
        return new com.bytedance.livesdk.ktvcommon.download.model.f(r110, r111, r112, r113, r100, r103, r115);
    L22:
        throw new IllegalArgumentException("Invalid file name: ".concat(r116));
    L11:
        int r104 = StringsKt.lastIndexOf$default(r116, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r104 != (-1)) goto L15;
        r103 = r116;
        goto L18
    L15:
        if (r104 != (r116.length() - 1)) goto L17;
        r102 = "";
        goto L10
    L17:
        r102 = r116.substring(r104 + 1);
        goto L10
    L7:
        r101 = false;
        goto L8
    L24:
        throw new IllegalArgumentException("Invalid save path: ".concat(r116));
    }
}
