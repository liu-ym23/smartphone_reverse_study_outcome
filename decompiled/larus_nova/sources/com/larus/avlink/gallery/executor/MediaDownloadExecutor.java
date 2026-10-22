package com.larus.avlink.gallery.executor;

import android.content.Context;
import android.os.Handler;
import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class MediaDownloadExecutor {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f292510n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f292511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaProcessingExecutor f292512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaLifecycleStateManager f292513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutexImpl f292514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.avlink.gallery.processor.f f292515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.avlink.gallery.processor.e f292516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f292517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f292518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super String, ? super MediaLifecycleState, Unit> f292519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Integer, Unit> f292520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f292521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f292522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.avlink.gallery.processor.a f292523m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292524a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f292524a = r100;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadTask f292525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f292526b;

        public c(DownloadTask r100, Context r101) {
            this.f292525a = r100;
            this.f292526b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            FLogger.f375446a.d("MediaDownloadExecutor", "Download cancel, downloadId = " + this.f292525a.getDownloadId());
            Downloader.getInstance(this.f292526b).cancel(this.f292525a.getDownloadId());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("MediaDownloadExecutor", "sql execute err! msg=" + r101);
        }
    }

    static {
    }

    public final void e() {
        com.larus.avlink.gallery.processor.f r100 = this.f292515e;
        r100.f292683b = true;
        Iterator r101 = CollectionsKt.toList(r100.f292682a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Job r102 = (Job) r101.next();
        if (r102.isActive() == false) goto L4;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
        goto L4
    L8:
        r100.f292682a.clear();
        this.f292518h.set(0);
        this.f292517g.set(0);
        this.f292523m = new com.larus.avlink.gallery.processor.a(0);
        this.f292519i = null;
        this.f292521k = null;
        this.f292520j = null;
    }

    public static final void a(final MediaDownloadExecutor r110) {
        if (r110.f292515e.f292683b == false) goto L5;
        FLogger.f375446a.i("MediaDownloadExecutor", "Download cancelled, skipping completion check");
        return;
    L5:
        int r100 = r110.f292518h.incrementAndGet();
        int r101 = (int) ((((double) r100) / ((double) r110.f292517g.get())) * ((double) 100));
        FLogger.f375446a.i("MediaDownloadExecutor", "Download progress: " + r101 + "% (" + r100 + '/' + r110.f292517g + ')');
        Function1<? super Integer, Unit> r102 = r110.f292520j;
        if (r102 == null) goto L9;
        r102.invoke(Integer.valueOf(r101));
    L9:
        if (r100 != r110.f292517g.get()) goto L20;
        com.larus.avlink.gallery.processor.a r103 = r110.f292523m;
        if ((r103.f292670d + r103.f292671e) != r110.f292517g.get()) goto L13;
        int r104 = 0;
    L17:
        GalleryMobHelper r105 = GalleryMobHelper.f293006a;
        com.larus.avlink.gallery.processor.a r106 = r110.f292523m;
        long r107 = r106.f292667a;
        int r108 = r106.f292668b;
        int r109 = r106.f292669c;
        int r111 = r106.f292670d;
        int r112 = r106.f292671e;
        r105.getClass();
        GalleryMobHelper.d(r104, r107, r108, r109, r111, r112);
        com.larus.avlink.gallery.processor.a r113 = r110.f292523m;
        long r114 = r113.f292672f;
        int r115 = r113.f292668b;
        int r116 = r113.f292669c;
        GalleryMobHelper.i("dora_sync_media_to_app", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("total_duration", Long.valueOf(r114)), TuplesKt.to("photo_cnt", Integer.valueOf(r115)), TuplesKt.to("video_cnt", Integer.valueOf(r116)), TuplesKt.to("total_cnt", Integer.valueOf(r115 + r116))}));
        SoftReference<Handler> r117 = y.f375498a;
        Runnable r118 = new com.larus.avlink.gallery.executor.b(r110);
        Intrinsics.checkNotNullParameter(r118, "action");
        y.d(r118, 200);
        return;
    L13:
        com.larus.avlink.gallery.processor.a r119 = r110.f292523m;
        if ((r119.f292670d + r119.f292671e) <= 0) goto L16;
        r104 = 2;
        goto L17
    L16:
        r104 = 1;
        goto L17
    }

    public static String g(String r100) {
        if (Intrinsics.areEqual(j.d(r100), "live_photo") == false) goto L5;
        return "image_pack";
    L5:
        if (r100 != null) goto L9;
        return "image";
    L9:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0084: MOVE (r13 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:16777348), block:B:26:0x0084 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.avlink.gallery.model.MediaMetadata] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.avlink.gallery.model.MediaMetadata] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.Object, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02ca -> B:104:0x00e0). Please report as a decompilation issue!!! */
    public final Object l(Continuation<? super List<String>> r110) {
        ?? r100 = "[Recovery] Found ";
        if ((r110 instanceof MediaDownloadExecutor$recoverIncompleteDownloads$1) == false) goto L7;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r101 = (MediaDownloadExecutor$recoverIncompleteDownloads$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
        MediaDownloadExecutor r103 = this;
    L8:
        Object r104 = r101.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r106 = r101.label;
        int r107 = 4;
        if (r106 == 0) goto L30;
        if (r106 != 1) goto L103;
        List r108 = (List) r101.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L90
        List r109 = r108;
    L34:
        List r111 = (List) r104;     // Catch: Exception -> L90
        if ((!r111.isEmpty()) == false) goto L87;
        FLogger.f375446a.i("MediaDownloadExecutor", "[Recovery] Found " + r111.size() + " incomplete media in repository");     // Catch: Exception -> L90
        MediaDownloadExecutor r112 = r103;
        List r113 = r109;
        ?? r114 = r111.iterator();     // Catch: Exception -> L90
    L104:
    L85:
        e = e;
        r106 = r113;
    L91:
        FLogger.f375446a.e("MediaDownloadExecutor", "[Recovery] Error during recovery: " + e.getMessage(), e);
        ?? r115 = r106;
    L92:
        return r115;
    L39:
        if (r114.hasNext() == false) goto L84;
        MediaMetadata r116 = (MediaMetadata) r114.next();     // Catch: Exception -> L85
        FLogger r117 = FLogger.f375446a;     // Catch: Exception -> L77
        r117.i("MediaDownloadExecutor", "[Recovery] Recovering " + r116.getUniqId() + " (state: " + r116.getLifecycleState() + ')');     // Catch: Exception -> L77
        int r118 = b.f292524a[r116.getLifecycleState().ordinal()];     // Catch: Exception -> L77
        if (r118 != 1) goto L44;
        r101.L$0 = r113;     // Catch: Exception -> L77
        r101.L$1 = r114;     // Catch: Exception -> L77
        r101.L$2 = r116;     // Catch: Exception -> L77
        r101.label = 2;     // Catch: Exception -> L77
        r104 = r112.k(r116, r101);     // Catch: Exception -> L77
        if (r104 != r105) goto L69;
        return r105;
    L69:
        ?? r119 = r114;
        Object r120 = r105;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r121 = r101;
        MediaDownloadExecutor r122 = r112;
        r100 = r116;
        List r123 = r113;
    L101:
        if (((Boolean) r104).booleanValue() == false) goto L73;
        Boxing.boxBoolean(r123.add(r100.getUniqId()));     // Catch: Exception -> L75
    L74:
        r112 = r122;
        r101 = r121;
        r105 = r120;
        ?? r124 = r119;
        List r125 = r123;
    L81:
        r107 = 4;
        r114 = r124;
        r113 = r125;
        goto L104
    L73:
        FLogger.f375446a.w("MediaDownloadExecutor", "[Recovery] Skipping DOWNLOAD state: " + r100.getUniqId());     // Catch: Exception -> L75
    L75:
        e = e;
        List r126 = r123;
        ?? r127 = r119;
    L93:
        FLogger.f375446a.e("MediaDownloadExecutor", "[Recovery] Error recovering " + r100.getUniqId() + ": " + e.getMessage(), e);     // Catch: Exception -> L82
        ?? r128 = r127;
        List r129 = r126;
    L55:
        r112 = r122;
        r101 = r121;
        r105 = r120;
        r124 = r128;
        r125 = r129;
    L82:
        e = e;
        r106 = r126;
        goto L91
    L44:
        if (r118 == 2) goto L65;
        if (r118 == 3) goto L64;
        if (r118 != r107) goto L48;
        r117.i("MediaDownloadExecutor", "Auto-syncing processed media to system album: " + r116 + ".uniqId");     // Catch: Exception -> L77
        MediaSyncExecutor r130 = MediaSyncExecutor.f292553a;     // Catch: Exception -> L77
        r101.L$0 = r113;     // Catch: Exception -> L77
        r101.L$1 = r114;     // Catch: Exception -> L77
        r101.L$2 = r116;     // Catch: Exception -> L77
        r101.label = 3;     // Catch: Exception -> L77
        if (r130.f(r116, r101) != r105) goto L59;
        return r105;
    L59:
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r131 = r101;
        r122 = r112;
        MediaMetadata r132 = r116;
        List r133 = r113;
        ?? r134 = r114;
        r120 = r105;
        r121 = r131;
    L60:
        r133.add(r132.getUniqId());     // Catch: Exception -> L62
        FLogger.f375446a.i("MediaDownloadExecutor", "Sync completed for processed media: " + r132 + ".uniqId");     // Catch: Exception -> L62
        r128 = r134;
        r129 = r133;
        goto L55
    L48:
        if (r118 == 5) goto L50;
        r117.w("MediaDownloadExecutor", "[Recovery] Unexpected state: " + r116.getLifecycleState() + " for " + r116.getUniqId());     // Catch: Exception -> L77
        r124 = r114;
        r125 = r113;
        goto L81
    L50:
        r117.i("MediaDownloadExecutor", "Auto-syncing media to system album: " + r116 + ".uniqId");     // Catch: Exception -> L77
        MediaSyncExecutor r135 = MediaSyncExecutor.f292553a;     // Catch: Exception -> L77
        r101.L$0 = r113;     // Catch: Exception -> L77
        r101.L$1 = r114;     // Catch: Exception -> L77
        r101.L$2 = r116;     // Catch: Exception -> L77
        r101.label = r107;     // Catch: Exception -> L77
        if (r135.f(r116, r101) != r105) goto L53;
        return r105;
    L53:
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r136 = r101;
        r122 = r112;
        r100 = r116;
        r126 = r113;
        r127 = r114;
        r120 = r105;
        r121 = r136;
    L97:
        FLogger.f375446a.i("MediaDownloadExecutor", "Sync completed for media: " + r100 + ".uniqId");     // Catch: Exception -> L62
        r128 = r127;
        r129 = r126;
    L62:
        e = e;
        goto L93
    L64:
        r112.f292512b.a(r116.getUniqId(), true);     // Catch: Exception -> L77
        r113.add(r116.getUniqId());     // Catch: Exception -> L77
        r117.i("MediaDownloadExecutor", "[Recovery] Enqueued processing task for: " + r116.getUniqId());     // Catch: Exception -> L77
        r124 = r114;
        r125 = r113;
        goto L81
    L65:
        r112.f292512b.a(r116.getUniqId(), true);     // Catch: Exception -> L77
        r113.add(r116.getUniqId());     // Catch: Exception -> L77
        r117.i("MediaDownloadExecutor", "[Recovery] Enqueued processing task for: " + r116.getUniqId());     // Catch: Exception -> L77
        r124 = r114;
        r125 = r113;
    L77:
        e = e;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r137 = r101;
        r122 = r112;
        r100 = r116;
        r126 = r113;
        r127 = r114;
        r120 = r105;
        r121 = r137;
        goto L93
    L84:
        r106 = r113;
    L88:
        FLogger.f375446a.i("MediaDownloadExecutor", "[Recovery] ✅ Total recovered: " + r106.size() + " media");     // Catch: Exception -> L90
        r115 = r106;
        goto L92
    L87:
        FLogger.f375446a.d("MediaDownloadExecutor", "[Recovery] No incomplete media found in repository");     // Catch: Exception -> L90
        r106 = r109;
        goto L88
    L103:
        if (r106 == 2) goto L22;
        if (r106 == 3) goto L19;
        if (r106 != 4) goto L18;
        MediaMetadata r138 = (MediaMetadata) r101.L$2;
        Iterator r139 = (Iterator) r101.L$1;
        List r140 = (List) r101.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L25
        r126 = r140;
        r127 = r139;
        r120 = r105;
        r121 = r101;
        r122 = r103;
        r100 = r138;
        goto L97
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r132 = (MediaMetadata) r101.L$2;
        Iterator r141 = (Iterator) r101.L$1;
        List r142 = (List) r101.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L25
        r133 = r142;
        r134 = r141;
        r120 = r105;
        r121 = r101;
        r122 = r103;
        goto L60
    L22:
        MediaMetadata r143 = (MediaMetadata) r101.L$2;
        Iterator r144 = (Iterator) r101.L$1;
        List r145 = (List) r101.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L25
        r119 = r144;
        r120 = r105;
        r121 = r101;
        r122 = r103;
        r100 = r143;
        r123 = r145;
    L25:
        e = e;
        r126 = r12;
        r127 = r106;
        r120 = r105;
        r121 = r101;
        r122 = r103;
        goto L93
    L30:
        ResultKt.throwOnFailure(r104);
        ArrayList r146 = new ArrayList();
        FLogger.f375446a.i("MediaDownloadExecutor", "[Recovery] Querying incomplete media from repository...");     // Catch: Exception -> L90
        AlbumDataBaseHelper r147 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L90
        MediaLifecycleState r148 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L90
        r101.L$0 = r146;     // Catch: Exception -> L90
        r101.label = 1;     // Catch: Exception -> L90
        r104 = r147.r(r148, r101);     // Catch: Exception -> L90
        r109 = r146;
        if (r104 != r105) goto L34;
        return r105;
    L90:
        e = e;
    L7:
        r103 = this;
        r101 = new MediaDownloadExecutor$recoverIncompleteDownloads$1(r103, r110);
        goto L8
    }

    public MediaDownloadExecutor(CoroutineScope r100, MediaProcessingExecutor r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "processingExecutor");
        this.f292511a = r100;
        this.f292512b = r101;
        this.f292513c = MediaLifecycleStateManager.f292361b.a();
        this.f292514d = kotlinx.coroutines.sync.b.a();
        this.f292515e = new com.larus.avlink.gallery.processor.f();
        this.f292516f = new com.larus.avlink.gallery.processor.e();
        this.f292517g = new AtomicInteger(0);
        this.f292518h = new AtomicInteger(0);
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L7;
        IDoraService.j r103 = r102.S();
        if (r103 == null) goto L7;
        String r104 = r103.getHost();
    L8:
        this.f292522l = r104;
        this.f292523m = new com.larus.avlink.gallery.processor.a(0);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public static final int b(MediaDownloadExecutor r100, MediaInfo r101) {
        r100.getClass();
        if (j.a(g(r101.getMediaType())) == false) goto L9;
        Integer r102 = r101.getHeight();
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.intValue();
    L9:
        return r101.getOutVideoHeight();
    }

    public static final int c(MediaDownloadExecutor r100, MediaInfo r101) {
        r100.getClass();
        if (j.a(g(r101.getMediaType())) == false) goto L9;
        Integer r102 = r101.getWidth();
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.intValue();
    L9:
        return r101.getOutVideoWidth();
    }

    public final Object k(MediaMetadata r310, Continuation<? super Boolean> r311) {
        if ((r311 instanceof MediaDownloadExecutor$recoverDownloadedArchive$1) == false) goto L7;
        MediaDownloadExecutor$recoverDownloadedArchive$1 r100 = (MediaDownloadExecutor$recoverDownloadedArchive$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$recoverDownloadedArchive$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        MediaMetadata r106 = (MediaMetadata) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L103:
        boolean r107 = ((Boolean) r103).booleanValue();
        if (r107 == false) goto L107;
        FLogger.f375446a.i("MediaDownloadExecutor", "[Recovery] Recovered downloaded archive and enqueued processing: " + r106.getUniqId());
    L107:
        return Boxing.boxBoolean(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r108 = j.f292609a;
        if (j.b(r310.getMediaType()) == false) goto L17;
        com.larus.avlink.gallery.processor.e r109 = this.f292516f;
        String r110 = r310.getUniqId();
        String r111 = r310.getDownloadFilePath();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "uniqId");
        ArrayList r112 = new ArrayList();
        if (r111 == null) goto L21;
        r112.add(new PolarisFileWrapper(r111));
        r112.add(new PolarisFileWrapper(r111.concat(".tp")));
    L21:
        com.larus.avlink.gallery.e.f292493a.getClass();
        File[] r113 = com.larus.avlink.gallery.e.c().listFiles();
        int r114 = com.larus.avlink.gallery.processor.e.f292674a;
        if (r113 == null) goto L44;
        int r115 = r113.length;
        int r116 = 0;
    L24:
        if (r116 >= r115) goto L44;
        File r117 = r113[r116];
        if (r117.isFile() == true) goto L28;
    L40:
        boolean r118 = false;
    L41:
        if (r118 == false) goto L43;
        r112.add(r117);
    L43:
        r116 = r116 + 1;
        goto L24
    L28:
        if (StringsKt.contains$default(r117.getName(), "_" + r110 + '_', false, 2, null) == false) goto L40;
        String r119 = r117.getName();
        if (com.larus.avlink.gallery.processor.e.a.a(r119) == false) goto L32;
    L37:
        boolean r120 = true;
    L38:
        if (r120 == false) goto L40;
        r118 = true;
        goto L41
    L32:
        if (StringsKt.endsWith$default(r119, ".tp", false, 2, null) == true) goto L34;
    L36:
        r120 = false;
        goto L38
    L34:
        if (com.larus.avlink.gallery.processor.e.a.a(StringsKt.removeSuffix(r119, ".tp")) == false) goto L36;
    L44:
        HashSet r121 = new HashSet();
        ArrayList r122 = new ArrayList();
        Iterator r123 = r112.iterator();
    L46:
        if (r123.hasNext() == false) goto L50;
        Object r124 = r123.next();
        if (r121.add(((File) r124).getAbsolutePath()) == false) goto L46;
        r122.add(r124);
        goto L46
    L50:
        Iterator r125 = r122.iterator();
        File r126 = null;
    L52:
        if (r125.hasNext() == false) goto L93;
        File r127 = (File) r125.next();
        if (r127.exists() == true) goto L56;
    L80:
        Object r128 = com.larus.avlink.gallery.processor.e.b.C3993b.f292676a;
    L82:
        if ((r128 instanceof com.larus.avlink.gallery.processor.e.b.c) == true) goto L98;
        if ((r128 instanceof com.larus.avlink.gallery.processor.e.b.a) == true) goto L86;
        if (Intrinsics.areEqual(r128, com.larus.avlink.gallery.processor.e.b.C3993b.f292676a) == true) goto L52;
        throw new NoWhenBranchMatchedException();
    L86:
        if (r126 != null) goto L52;
        r126 = ((com.larus.avlink.gallery.processor.e.b.a) r128).f292675a;
    L98:
        if ((r128 instanceof com.larus.avlink.gallery.processor.e.b.c) == false) goto L109;
        File r129 = ((com.larus.avlink.gallery.processor.e.b.c) r128).f292677a;
        FLogger.f375446a.i("MediaDownloadExecutor", "[Recovery] Found downloaded archive for DOWNLOAD state: " + r129.getAbsolutePath());
        String r130 = r129.getAbsolutePath();
        String r131 = r129.getName();
        String r132 = r310.getUniqId();
        MediaInfo r133 = new MediaInfo(Long.valueOf(r310.getMediaId()), r310.getMediaType(), null, null, Integer.valueOf(r310.getWidth()), Integer.valueOf(r310.getHeight()), r310.getOutVideoWidth(), r310.getOutVideoHeight(), r310.getOutputVideoCrop(), r310.getFileSize(), Long.valueOf(r310.getDuration()), null, Long.valueOf(r310.getCreateTime()), r129.getName(), null, null, null, 116748, null);
        r102.L$0 = r310;
        r102.label = 1;
        r103 = f(r130, r131, r132, r133, true, r102);
        if (r103 != r104) goto L102;
        return r104;
    L102:
        r106 = r310;
        goto L103
    L109:
        if ((r128 instanceof com.larus.avlink.gallery.processor.e.b.a) == false) goto L113;
        FLogger.f375446a.w("MediaDownloadExecutor", "[Recovery] Archive download is not complete, keep DOWNLOAD state for retry: " + r310.getUniqId() + ", file=" + ((com.larus.avlink.gallery.processor.e.b.a) r128).f292675a.getAbsolutePath());
        return Boxing.boxBoolean(false);
    L113:
        if (Intrinsics.areEqual(r128, com.larus.avlink.gallery.processor.e.b.C3993b.f292676a) == false) goto L117;
        FLogger.f375446a.w("MediaDownloadExecutor", "[Recovery] No downloaded archive found for DOWNLOAD state: " + r310.getUniqId());
        return Boxing.boxBoolean(false);
    L117:
        throw new NoWhenBranchMatchedException();
    L56:
        if (r127.isFile() == false) goto L80;
        if (com.larus.avlink.gallery.processor.e.a.a(r127.getName()) == false) goto L65;
        if (com.larus.avlink.gallery.processor.e.e(r127, r127.getName()) == false) goto L63;
        r128 = new com.larus.avlink.gallery.processor.e.b.c(r127);
        goto L82
    L63:
        r128 = new com.larus.avlink.gallery.processor.e.b.a(r127);
        goto L82
    L65:
        if (StringsKt.endsWith$default(r127.getName(), ".tp", false, 2, null) == true) goto L67;
        r128 = com.larus.avlink.gallery.processor.e.b.C3993b.f292676a;
        goto L82
    L67:
        String r134 = StringsKt.removeSuffix(r127.getName(), ".tp");
        if (com.larus.avlink.gallery.processor.e.a.a(r134) == true) goto L71;
        r128 = com.larus.avlink.gallery.processor.e.b.C3993b.f292676a;
        goto L82
    L71:
        if (StringsKt.endsWith(r134, ".zip", true) == true) goto L73;
    L79:
        r128 = new com.larus.avlink.gallery.processor.e.b.a(r127);
        goto L82
    L73:
        if (com.larus.avlink.gallery.processor.e.e(r127, r134) == false) goto L79;
        PolarisFileWrapper r135 = new PolarisFileWrapper(r127.getParentFile(), r134);
        if (r127.renameTo(r135) == true) goto L78;
        FLogger.f375446a.w("DownloadArchiveProcessor", "Failed to promote temp archive download: " + r127.getAbsolutePath());
        r128 = new com.larus.avlink.gallery.processor.e.b.a(r127);
        goto L82
    L78:
        FLogger.f375446a.i("DownloadArchiveProcessor", "Promoted temp archive download: " + r135.getAbsolutePath());
        r128 = new com.larus.avlink.gallery.processor.e.b.c(r135);
        goto L82
    L93:
        if (r126 == null) goto L95;
        Object r136 = new com.larus.avlink.gallery.processor.e.b.a(r126);
    L96:
        r128 = r136;
        goto L98
    L95:
        r136 = com.larus.avlink.gallery.processor.e.b.C3993b.f292676a;
        goto L96
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new MediaDownloadExecutor$recoverDownloadedArchive$1(this, r311);
        goto L8
    }

    public final Job n(Context r110, MediaInfo r111, MediaSyncCoordinator.SyncMode r112) {
        return BuildersKt.launch$default(this.f292511a, Dispatchers.getIO().plus(new d(CoroutineExceptionHandler.Key)), null, new MediaDownloadExecutor$saveMediaInternal$1(this, r110, r111, AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + File.separator + "doraG/" + IApplog.f287053a.getUserID() + '/', r112, null), 2, null);
    }

    public static void j(MediaMetadata r310, String r311, String r312, String r313) {
        int r100 = com.larus.avlink.gallery.processor.e.f292674a;
        if (com.larus.avlink.gallery.processor.e.a.a(r312) == true) goto L5;
        return;
    L5:
        MediaMetadata r101 = MediaMetadata.copy$default(r310, null, 0, null, r312, null, null, 0, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, null, null, null, null, null, r311, null, null, null, null, 0, 16515063, null);
        AlbumDataBaseHelper.f292393a.getClass();
        AlbumDataBaseHelper.A(r101);
        FLogger.f375446a.i("MediaDownloadExecutor", "Persisted " + r313 + " archive target for recovery: " + r310.getUniqId() + ", path=" + r311);
    }

    public static final Object d(MediaDownloadExecutor r100, Context r101, MediaInfo r102, MediaSyncCoordinator.SyncMode r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof MediaDownloadExecutor$realSaveMedia$1) == false) goto L7;
        MediaDownloadExecutor$realSaveMedia$1 r103 = (MediaDownloadExecutor$realSaveMedia$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$realSaveMedia$1 r105 = r103;
        Object r112 = r105.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r105.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L44:
        String r113 = (String) r112;
        if (r113 != null) goto L48;
        return TuplesKt.to(Boxing.boxInt(2001), "");
    L48:
        return TuplesKt.to(Boxing.boxInt(0), r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        String r114 = r102.getMediaType();
        if (r114 != null) goto L17;
        r114 = "image";
    L17:
        String r115 = j.d(r114);
        switch(r115.hashCode()) {
            case -1617978531: goto L36;
            case -1442901379: goto L33;
            case 100313435: goto L31;
            case 112202875: goto L28;
            case 1210380575: goto L24;
            case 1333277997: goto L21;
            default: goto L40;
        };
    L31:
        r115.equals("image");
    L40:
        String r116 = ".jpeg";
    L39:
        String r108 = r116;
        r105.label = 1;
        r112 = r100.m(r101, r102, r108, r110, r105);
        if (r112 != r106) goto L44;
        return r106;
    L21:
        if (r115.equals("video_mp4") == false) goto L40;
    L30:
        r116 = ".mp4";
        goto L39
    L24:
        if (r115.equals("live_photo") == false) goto L40;
        r116 = ".zip";
        goto L39
    L28:
        if (r115.equals("video") == true) goto L30;
    L33:
        if (r115.equals("image_pack") == false) goto L40;
    L38:
        r116 = ".pack";
        goto L39
    L36:
        if (r115.equals("video_pack") == true) goto L38;
    L7:
        r103 = new MediaDownloadExecutor$realSaveMedia$1(r100, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.larus.dora.api.IDoraService$j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v29 */
    public final Object m(Context r610, MediaInfo r611, String r612, MediaSyncCoordinator.SyncMode r613, Continuation<? super String> r710) {
        if ((r710 instanceof MediaDownloadExecutor$saveMediaFile$1) == false) goto L7;
        MediaDownloadExecutor$saveMediaFile$1 r100 = (MediaDownloadExecutor$saveMediaFile$1) r710;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$saveMediaFile$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        String r104 = (String) r110.L$14;
        Map r105 = (Map) r110.L$13;
        IDoraService.j r106 = (IDoraService.j) r110.L$12;
        MediaMetadata r107 = (MediaMetadata) r110.L$11;
        File r108 = (File) r110.L$10;
        String r109 = (String) r110.L$9;
        Long r112 = (Long) r110.L$8;
        String r113 = (String) r110.L$7;
        String r114 = (String) r110.L$6;
        String r115 = (String) r110.L$5;
        String r116 = (String) r110.L$4;
        String r117 = (String) r110.L$3;
        String r118 = (String) r110.L$2;
        MediaInfo r119 = (MediaInfo) r110.L$1;
        Context r120 = (Context) r110.L$0;
        ResultKt.throwOnFailure(r102);
    L154:
        return r102;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r121 = r110.J$2;
        long r122 = r110.J$1;
        String r123 = "";
        long r124 = r110.J$0;
        MediaMetadata r125 = (MediaMetadata) r110.L$12;
        File r126 = (File) r110.L$11;
        String r127 = (String) r110.L$10;
        Long r128 = (Long) r110.L$9;
        String r129 = (String) r110.L$8;
        String r130 = (String) r110.L$7;
        String r131 = (String) r110.L$6;
        String r132 = (String) r110.L$5;
        String r133 = (String) r110.L$4;
        MediaSyncCoordinator.SyncMode r134 = (MediaSyncCoordinator.SyncMode) r110.L$3;
        String r135 = (String) r110.L$2;
        MediaInfo r136 = (MediaInfo) r110.L$1;
        Context r137 = (Context) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r138 = r131;
        Context r139 = r137;
        String r210 = "MediaDownloadExecutor";
        long r510 = r121;
        MediaSyncCoordinator.SyncMode r140 = r134;
        MediaInfo r141 = r136;
        GeoLocationInfo r142 = null;
        File r143 = r126;
        String r144 = r130;
        MediaMetadata r614 = r125;
        Object r211 = r111;
        String r145 = r133;
        long r212 = r122;
        Long r146 = r128;
        String r147 = r129;
        String r148 = r132;
        final String r149 = r127;
        String r150 = r135;
    L114:
        MediaLifecycleState r151 = r614.getLifecycleState();
        final long r213 = r124;
        Function2<? super String, ? super MediaLifecycleState, Unit> r152 = this.f292519i;
        if (r152 == null) goto L117;
        r152.invoke(r149, r151);
    L117:
        FLogger.f375446a.i(r210, "Created metadata for media: " + r149 + " with state DOWNLOAD");
        IDoraService r153 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r153 == null) goto L120;
        ?? r154 = r153.S();
    L121:
        if (r154 == 0) goto L124;
        Map<String, String> r155 = r154.f();
        if (r155 == null) goto L124;
    L125:
        Map<String, String> r214 = r155;
        IDoraService r156 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r156 == null) goto L133;
        VisionService r157 = r156.V();
        if (r157 == null) goto L133;
        String r158 = r157.w(r140.getValue());
        if (r158 == null) goto L133;
        String r159 = r158;
    L134:
        r110.L$0 = r139;
        r110.L$1 = r141;
        r110.L$2 = r150;
        r110.L$3 = r145;
        r110.L$4 = r148;
        r110.L$5 = r138;
        r110.L$6 = r144;
        r110.L$7 = r147;
        r110.L$8 = r146;
        r110.L$9 = r149;
        r110.L$10 = r143;
        final MediaMetadata r160 = r614;
        r110.L$11 = r160;
        r110.L$12 = r154;
        r110.L$13 = r214;
        r110.L$14 = r159;
        final String r161 = r147;
        r110.J$0 = r213;
        r110.J$1 = r212;
        final long r162 = r510;
        r110.J$2 = r162;
        r110.label = 4;
        final kotlinx.coroutines.j r163 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r110), 1);
        r163.C();
        final String r164 = r138 + '_' + r149 + "_0_" + r141.getDuration() + '_' + r141.getHeight() + '_' + r141.getWidth() + '_' + r146 + '_' + r144 + r150;
        j(r160, new PolarisFileWrapper(r143, r164).getAbsolutePath(), r164, AiBotPollingAuthResult.STATUS_PENDING);
        if (r154 != 0) goto L137;
    L139:
        boolean r165 = false;
    L140:
        DownloadTask r166 = Downloader.with(r139).url(r145);
        ArrayList r167 = new ArrayList(r214.size());
        Iterator<Map.Entry<String, String>> r168 = r214.entrySet().iterator();
    L142:
        if (r168.hasNext() == false) goto L144;
        Map.Entry<String, String> r169 = r168.next();
        r167.add(new HttpHeader(r169.getKey(), r169.getValue()));
        goto L142
    L144:
        DownloadTask r170 = r166.extraHeaders(r167).savePath(r143.getAbsolutePath()).ttnetByPassProxy(true).name(r164).forceWifiBound(r165);
        if (r165 == false) goto L147;
        JSONObject r171 = new JSONObject();
        r171.put(DownloadSettingKeys.NET_LIB_STRATEGY, 1);
    L148:
        DownloadTask r172 = r170.downloadSetting(r171);
        final long r615 = r212;
        final String r173 = r159;
        final String r174 = r148;
        final MediaInfo r175 = r141;
        Object r176 = r211;
        DownloadTask r177 = r172.subThreadListener(new MediaDownloadExecutor$saveMediaFile$2$task$3(r173, r615, this, r149, r174, r213, r175, r164, r160, r163, r161, r162));
        r163.i(new c(r177, r139));
        r177.asyncDownload(null);
        r102 = r163.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L152;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L152:
        if (r102 != r176) goto L154;
        return r176;
    L147:
        r171 = new JSONObject();
        goto L148
    L137:
        if (r154.h() != true) goto L139;
        r165 = true;
    L133:
        r159 = r123;
    L124:
        r155 = MapsKt.emptyMap();
        goto L125
    L120:
        r154 = r142;
        goto L121
    L18:
        r123 = "";
        long r178 = r110.J$2;
        long r179 = r110.J$1;
        long r180 = r110.J$0;
        File r181 = (File) r110.L$12;
        String r182 = (String) r110.L$11;
        Long r183 = (Long) r110.L$10;
        String r184 = (String) r110.L$9;
        String r185 = (String) r110.L$8;
        String r186 = (String) r110.L$7;
        String r187 = (String) r110.L$6;
        String r188 = (String) r110.L$5;
        String r189 = (String) r110.L$4;
        MediaSyncCoordinator.SyncMode r190 = (MediaSyncCoordinator.SyncMode) r110.L$3;
        String r191 = (String) r110.L$2;
        MediaInfo r192 = (MediaInfo) r110.L$1;
        Context r193 = (Context) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r310 = r188;
        long r511 = r180;
        r210 = "MediaDownloadExecutor";
        String r194 = r184;
        r142 = null;
        r145 = r189;
        r148 = r187;
        r144 = r185;
        String r616 = r182;
        Object r195 = r111;
        String r196 = r186;
        Context r197 = r193;
        long r617 = r179;
        r146 = r183;
        r150 = r191;
        MediaInfo r198 = r192;
        MediaSyncCoordinator.SyncMode r199 = r190;
        r143 = r181;
        long r200 = r178;
    L91:
        ThumbnailMetadata r201 = (ThumbnailMetadata) r102;
        Integer r215 = r198.getWidth();
        if (r215 == null) goto L94;
        int r311 = r215.intValue();
    L95:
        Integer r216 = r198.getHeight();
        if (r216 == null) goto L98;
        int r312 = r216.intValue();
    L99:
        Number r217 = r198.getDuration();
        if (r217 != null) goto L102;
        r217 = Boxing.boxDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
    L102:
        long r313 = r217.longValue();
        if (r146 == null) goto L105;
        long r218 = r146.longValue();
    L106:
        long r410 = r218;
        MediaLifecycleState r411 = MediaLifecycleState.DOWNLOAD;
        double r314 = r198.getOutputVideoCrop();
        int r315 = r198.getOutVideoHeight();
        int r316 = r198.getOutVideoWidth();
        if (r201 == null) goto L109;
        GeoLocationInfo r412 = r201.getGeoLocationInfo();
    L110:
        MediaMetadata r202 = new MediaMetadata(r616, r200, null, "", Boxing.boxLong(r617), r310, r311, r312, r313, r316, r315, r314, r410, r412, r196, r411, null, null, null, null, null, null, null, 0, 16711684, null);
        Object r219 = r195;
        AlbumDataBaseHelper r1100 = AlbumDataBaseHelper.f292393a;
        r110.L$0 = r197;
        r110.L$1 = r198;
        r110.L$2 = r150;
        r110.L$3 = r199;
        r110.L$4 = r145;
        r110.L$5 = r148;
        r110.L$6 = r196;
        r110.L$7 = r144;
        r110.L$8 = r194;
        r110.L$9 = r146;
        MediaInfo r618 = r198;
        String r203 = r616;
        r110.L$10 = r203;
        r110.L$11 = r143;
        r110.L$12 = r202;
        String r619 = r196;
        long r204 = r511;
        r110.J$0 = r204;
        long r205 = r617;
        r110.J$1 = r205;
        r110.J$2 = r200;
        r110.label = 3;
        if (r1100.h(r202, r110) != r219) goto L113;
        return r219;
    L113:
        r614 = r202;
        r140 = r199;
        r510 = r200;
        r211 = r219;
        r147 = r194;
        r149 = r203;
        r124 = r204;
        r212 = r205;
        r138 = r619;
        r141 = r618;
        r139 = r197;
        goto L114
    L109:
        r412 = r142;
        goto L110
    L105:
        r218 = System.currentTimeMillis();
        goto L106
    L98:
        r312 = 0;
        goto L99
    L94:
        r311 = 0;
        goto L95
    L19:
        r123 = "";
        long r206 = r110.J$2;
        long r207 = r110.J$1;
        long r208 = r110.J$0;
        String r209 = (String) r110.L$11;
        Long r1101 = (Long) r110.L$10;
        String r1102 = (String) r110.L$9;
        String r1103 = (String) r110.L$8;
        String r220 = (String) r110.L$7;
        String r221 = (String) r110.L$6;
        String r222 = (String) r110.L$5;
        String r223 = (String) r110.L$4;
        MediaSyncCoordinator.SyncMode r224 = (MediaSyncCoordinator.SyncMode) r110.L$3;
        String r225 = (String) r110.L$2;
        MediaInfo r226 = (MediaInfo) r110.L$1;
        Context r227 = (Context) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r1104 = r220;
        String r1105 = "MediaDownloadExecutor";
        Long r228 = r1101;
        String r317 = r1103;
        String r229 = r221;
        r145 = r223;
        String r1106 = r222;
        String r620 = r1102;
        long r1107 = r207;
        MediaSyncCoordinator.SyncMode r230 = r224;
        String r231 = r225;
        Object r232 = r102;
        Context r233 = r227;
        long r234 = r208;
        r200 = r206;
        MediaInfo r235 = r226;
        Object r236 = r111;
        String r1108 = r209;
    L74:
        MediaMetadata r237 = (MediaMetadata) r232;
        if (r237 != null) goto L77;
        r142 = null;
    L87:
        com.larus.avlink.gallery.e.f292493a.getClass();
        PolarisFileWrapper r238 = com.larus.avlink.gallery.e.c();
        r238.mkdirs();
        r210 = r1105;
        AlbumDataBaseHelper r1109 = AlbumDataBaseHelper.f292393a;
        r110.L$0 = r233;
        Context r239 = r233;
        r110.L$1 = r235;
        r110.L$2 = r231;
        r110.L$3 = r230;
        r110.L$4 = r145;
        r110.L$5 = r1106;
        r110.L$6 = r229;
        r110.L$7 = r1104;
        r110.L$8 = r317;
        String r240 = r620;
        r110.L$9 = r240;
        String r621 = r231;
        Long r241 = r228;
        r110.L$10 = r241;
        r110.L$11 = r1108;
        r110.L$12 = r238;
        r110.J$0 = r234;
        r110.J$1 = r1107;
        r110.J$2 = r200;
        long r622 = r234;
        r110.label = 2;
        Object r242 = r1109.w(r200, r240, r110);
        r195 = r236;
        if (r242 != r195) goto L90;
        return r195;
    L90:
        r511 = r622;
        r194 = r240;
        r102 = r242;
        r616 = r1108;
        r198 = r235;
        r196 = r1104;
        r310 = r1106;
        r146 = r241;
        r197 = r239;
        MediaSyncCoordinator.SyncMode r623 = r230;
        r150 = r621;
        r617 = r1107;
        r143 = r238;
        r148 = r229;
        r144 = r317;
        r199 = r623;
        goto L91
    L77:
        if (r237.getLifecycleState() != MediaLifecycleState.DOWNLOAD) goto L79;
    L85:
        r142 = null;
        goto L87
    L79:
        if (r237.getLifecycleState() == MediaLifecycleState.FAILED) goto L85;
        FLogger.f375446a.i(r1105, "Media already exists: " + r1108 + " (state: " + r237.getLifecycleState() + ')');
        MediaLifecycleState r243 = r237.getLifecycleState();
        Function2<? super String, ? super MediaLifecycleState, Unit> r244 = this.f292519i;
        if (r244 == null) goto L83;
        r244.invoke(r1108, r243);
    L83:
        i(0, r1107, r229, System.currentTimeMillis() - r234, 0, String.valueOf(r200), r620);
        return null;
    L20:
        r123 = "";
        ResultKt.throwOnFailure(r102);
        String r245 = r611.getDownloadUrl();
        if (r245 != null) goto L24;
        return null;
    L24:
        String r246 = r245 + "&uuid=" + UUID.randomUUID();
        long r247 = System.currentTimeMillis();
        Long r248 = r611.getSize();
        if (r248 == null) goto L27;
        long r249 = r248.longValue();
    L28:
        r1106 = g(r611.getMediaType());
        if (j.a(r1106) == false) goto L31;
        String r250 = "photo";
    L32:
        String r1110 = r250;
        String r251 = r611.getMediaName();
        if (r251 == null) goto L36;
        String r252 = StringsKt.substringBefore$default(r251, "_", null, 2, null);
        if (r252 == null) goto L36;
    L37:
        String r253 = r252;
        String r254 = r611.getMediaName();
        if (r254 != null) goto L40;
        r1105 = "MediaDownloadExecutor";
        String r255 = null;
    L46:
        IDoraService r256 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r256 == null) goto L51;
        DeviceService r257 = r256.device();
        if (r257 == null) goto L51;
        String r258 = r257.m();
    L52:
        Long r1111 = r611.getCreateTime();
        if (r1111 == null) goto L55;
        long r259 = r1111.longValue();
    L57:
        if (r259 >= 1735660800000L) goto L59;
        Long r1112 = Boxing.boxLong(System.currentTimeMillis());
    L60:
        Long r1113 = r611.getMediaId();
        if (r1113 == null) goto L63;
        long r260 = r1113.longValue();
    L70:
        StringBuilder r1114 = new StringBuilder();
        r1114.append(r260);
        r1114.append('_');
        r1114.append(r1112);
        String r1115 = r1114.toString();
        AlbumDataBaseHelper r1116 = AlbumDataBaseHelper.f292393a;
        r110.L$0 = r610;
        r110.L$1 = r611;
        r110.L$2 = r612;
        r110.L$3 = r613;
        r110.L$4 = r246;
        r110.L$5 = r1106;
        r110.L$6 = r1110;
        r110.L$7 = r253;
        r110.L$8 = r255;
        r110.L$9 = r258;
        r110.L$10 = r1112;
        r110.L$11 = r1115;
        r110.J$0 = r247;
        r110.J$1 = r249;
        r110.J$2 = r260;
        long r261 = r260;
        r110.label = 1;
        Object r262 = r1116.o(r1115, r110);
        if (r262 != r111) goto L73;
        return r111;
    L73:
        r235 = r611;
        r317 = r255;
        r229 = r1110;
        r228 = r1112;
        r1104 = r253;
        r145 = r246;
        r234 = r247;
        r231 = r612;
        r230 = r613;
        r233 = r610;
        r620 = r258;
        r232 = r262;
        r1108 = r1115;
        r1107 = r249;
        r200 = r261;
        r236 = r111;
        goto L74
    L63:
        String r263 = UriProtector.getQueryParameter(UriProtector.parse(r245), "id");
        if (r263 == null) goto L66;
        Long r264 = StringsKt.toLongOrNull(r263);
    L67:
        if (r264 == null) goto L69;
        r260 = r264.longValue();
        goto L70
    L69:
        r260 = 0;
        goto L70
    L66:
        r264 = null;
        goto L67
    L59:
        r1112 = r611.getCreateTime();
        goto L60
    L55:
        r259 = 0;
    L51:
        r258 = r123;
        goto L52
    L40:
        r1105 = "MediaDownloadExecutor";
        MatchResult r265 = Regex.find$default(new Regex("_([^_]+)\\.(?:pack|zip)$"), r254, 0, 2, null);
        if (r265 == null) goto L45;
        List<String> r266 = r265.getGroupValues();
        if (r266 == null) goto L45;
        r255 = (String) ListProtector.get(r266, 1);
    L45:
        r255 = null;
    L36:
        r252 = "media";
        goto L37
    L31:
        r250 = "video";
        goto L32
    L27:
        r249 = 0;
    L7:
        r100 = new MediaDownloadExecutor$saveMediaFile$1(this, r710);
        goto L8
    }

    public final Object f(String r100, String r110, String r111, MediaInfo r112, boolean r113, Continuation<? super Boolean> r114) {
        if ((r114 instanceof MediaDownloadExecutor$completeArchiveDownload$1) == false) goto L7;
        MediaDownloadExecutor$completeArchiveDownload$1 r101 = (MediaDownloadExecutor$completeArchiveDownload$1) r114;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$completeArchiveDownload$1 r103 = r101;
        Object r115 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r113 = r103.Z$0;
        r111 = (String) r103.L$0;
        ResultKt.throwOnFailure(r115);
    L29:
        this.f292512b.a(r111, r113);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        com.larus.avlink.gallery.processor.e r116 = this.f292516f;
        String r106 = r112.getMediaType();
        this.f292516f.getClass();
        Intrinsics.checkNotNullParameter(r110, "fileName");
        if (StringsKt.endsWith(r110, ".zip", true) == true) goto L17;
    L21:
        boolean r107 = false;
    L22:
        r116.getClass();
        final com.larus.avlink.gallery.processor.e.c r108 = com.larus.avlink.gallery.processor.e.f(r100, r110, r111, r112, r107);
        if (r108 == null) goto L25;
        FLogger.f375446a.i("MediaDownloadExecutor", "Found displayable file: " + r108.f292678a);
        MediaLifecycleStateManager r109 = this.f292513c;
        MediaLifecycleState r117 = MediaLifecycleState.DOWNLOADED_TEMP;
        Function1 r118 = new com.larus.avlink.gallery.executor.a(r108);
        r103.L$0 = r111;
        r103.Z$0 = r113;
        r103.label = 1;
        if (MediaLifecycleStateManager.g(r109, r111, r117, r118, r103, 8) != r104) goto L29;
        return r104;
    L25:
        return Boxing.boxBoolean(false);
    L17:
        if (Intrinsics.areEqual(j.d(r106), "live_photo") == false) goto L19;
    L20:
        r107 = true;
        goto L22
    L19:
        if (j.b(r106) == false) goto L21;
    L7:
        r101 = new MediaDownloadExecutor$completeArchiveDownload$1(this, r114);
        goto L8
    }

    public final void i(int r110, long r111, String r210, long r211, int r212, String r213, String r214) {
        n1.d("MediaDownloadExecutor", "onDownloadEnd. id: " + r213 + ", status: " + r110 + ", errorCode: " + r212 + ", sn: " + r214);
        GalleryMobHelper.f293006a.getClass();
        Intrinsics.checkNotNullParameter(r210, "mediaType");
        GalleryMobHelper.i("flow_gallery_single_preview_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", GalleryMobHelper.a()), TuplesKt.to("status", Integer.valueOf(r110)), TuplesKt.to("error_code", Integer.valueOf(r212)), TuplesKt.to("media_size", Long.valueOf(r111)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r210), TuplesKt.to("retry_time", 0), TuplesKt.to("duration", Long.valueOf(r211))}));
        if (r110 != 0) goto L5;
        BuildersKt.launch$default(this.f292511a, Dispatchers.getIO(), null, new MediaDownloadExecutor$deleteThumbnail$1(r213, r214, null), 2, null);
    L5:
        com.larus.avlink.gallery.processor.a r100 = this.f292523m;
        monitor-enter(r100);
        com.larus.avlink.gallery.processor.a r101 = this.f292523m;     // Catch: Throwable -> L19
        r101.f292667a += r111;     // Catch: Throwable -> L19
        if (r110 == 0) goto L10;
    L13:
        monitor-exit(r100);
        String r102 = this.f292522l;
        if (r102 != null) goto L17;
        n1.d("MediaDownloadExecutor", "onDownloadEnd, host is null. id: " + r213 + ", status: " + r110 + ", errorCode: " + r212);
        return;
    L17:
        BuildersKt.launch$default(this.f292511a, Dispatchers.getIO(), null, new MediaDownloadExecutor$onDownloadEnd$2(r102, r213, this, null), 2, null);
        return;
    L10:
        if (Intrinsics.areEqual(r210, "photo") == false) goto L12;
        r101.f292670d++;     // Catch: Throwable -> L19
        goto L13
    L12:
        r101.f292671e++;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void h(MediaDownloadExecutor r100, long r101, String r102, int r103, int r104, long r105, int r110, int r111, long r112) {
        r100.getClass();
        GalleryMobHelper.f293006a.getClass();
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        GalleryMobHelper.i("flow_gallery_single_task_end", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", GalleryMobHelper.a()), TuplesKt.to("status", Integer.valueOf(r103)), TuplesKt.to("error_code", Integer.valueOf(r104)), TuplesKt.to("media_size", Long.valueOf(r101)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r102), TuplesKt.to("retry_time", 0), TuplesKt.to("duration", Long.valueOf(r105)), TuplesKt.to("width", Integer.valueOf(r110)), TuplesKt.to("height", Integer.valueOf(r111)), TuplesKt.to("media_duration", Long.valueOf(r112))}));
    }
}
