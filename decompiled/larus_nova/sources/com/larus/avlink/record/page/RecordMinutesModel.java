package com.larus.avlink.record.page;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.minutes.api.IMinutesService;
import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class RecordMinutesModel {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f294187g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f294188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f294189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f294190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<i0> f294191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Map<String, com.larus.dora.api.offline.record.e> f294192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f294193f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294194a = null;

        static {
            int[] r100 = new int[MinutesOfflineRecordingDeviceType.values().length];
            r100[MinutesOfflineRecordingDeviceType.GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MinutesOfflineRecordingDeviceType.EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f294194a = r100;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Long r102 = ((i0) r101).f294252g;
            long r103 = Long.MIN_VALUE;
            if (r102 == null) goto L5;
            long r104 = r102.longValue();
        L6:
            Long r105 = Long.valueOf(r104);
            Long r106 = ((i0) r100).f294252g;
            if (r106 == null) goto L10;
            r103 = r106.longValue();
        L10:
            return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
        L5:
            r104 = Long.MIN_VALUE;
            goto L6
        }
    }

    static {
    }

    public RecordMinutesModel() {
        this.f294188a = LazyKt.lazy(new j0());
        this.f294189b = LazyKt.lazy(new k0());
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L12;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L12;
        Integer r102 = Integer.valueOf(r101.y());
        if (r102.intValue() < 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L13:
        this.f294190c = r102;
        this.f294191d = CollectionsKt.emptyList();
        this.f294192e = MapsKt.emptyMap();
        this.f294193f = new ConcurrentHashMap();
        return;
    L9:
        r103 = false;
    L12:
        r102 = null;
        goto L13
    }

    public final i0 g() {
        long r100 = System.currentTimeMillis();
        return new i0("offline_recording_placeholder", j(null, Long.valueOf(r100)), TagType.OFFLINE_RECORDING, k(Long.valueOf(r100)), Long.valueOf(r100), null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW);
    }

    public static String k(Long r100) {
        if (r100 == null) goto L14;
        long r101 = r100.longValue();
        Calendar r102 = com.larus.avlink.record.util.r.f294435a;
        long r103 = System.currentTimeMillis();
        Calendar r104 = com.larus.avlink.record.util.r.f294435a;
        r104.setTimeInMillis(r103);
        Calendar r105 = com.larus.avlink.record.util.r.f294436b;
        r105.setTimeInMillis(r101);
        if (com.larus.avlink.record.util.r.a() == false) goto L6;
        String r106 = AppHost.f326268a.getApplication().getString(R.string.larus_favorites_timestamp_today) + ' ' + com.larus.avlink.record.util.r.f294437c.format(Long.valueOf(r101));
    L13:
        if (r106 == null) goto L14;
        return r106;
    L6:
        r104.add(5, -1);
        if (com.larus.avlink.record.util.r.a() == false) goto L9;
        r106 = AppHost.f326268a.getApplication().getString(R.string.larus_message_time_yesterday) + ' ' + com.larus.avlink.record.util.r.f294437c.format(Long.valueOf(r101));
        goto L13
    L9:
        r104.setTimeInMillis(r103);
        if (r104.get(1) != r105.get(1)) goto L12;
        r106 = com.larus.avlink.record.util.r.f294438d.format(Long.valueOf(r101));
        goto L13
    L12:
        r106 = com.larus.avlink.record.util.r.f294439e.format(Long.valueOf(r101));
    L14:
        return "";
    }

    public final i0 f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "recordingId");
        long r100 = System.currentTimeMillis();
        return new i0(r110, j(null, Long.valueOf(r100)), TagType.RECORDING, k(Long.valueOf(r100)), Long.valueOf(r100), null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW);
    }

    public static final Object c(RecordMinutesModel r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof RecordMinutesModel$fetchDoraSdkOfflineRecordings$1) == false) goto L7;
        RecordMinutesModel$fetchDoraSdkOfflineRecordings$1 r102 = (RecordMinutesModel$fetchDoraSdkOfflineRecordings$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L23
    L21:
        Object r107 = Result.m9449constructorimpl((List) r104);     // Catch: Throwable -> L23
    L25:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "fetch synced list failed: " + r108.getMessage());
    L28:
        List r109 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r107) == false) goto L31;
        r107 = r109;
    L31:
        List r110 = (List) r107;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch synced list, count=" + r110.size());
        LinkedHashMap r111 = new LinkedHashMap(r110.size());
        ArrayList r112 = new ArrayList(r110.size());
        Iterator r113 = r110.iterator();
    L33:
        if (r113.hasNext() == false) goto L41;
        com.larus.dora.api.offline.record.e r114 = (com.larus.dora.api.offline.record.e) r113.next();
        if (r114.f331809o.length() != 0) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == true) goto L39;
        String r116 = "external_opus_glasses_" + r114.f331809o.hashCode();
        r111.put(r116, r114);
        r112.add(r100.n(r114, r116));
        goto L33
    L39:
        com.larus.avlink.n1.d("RecordMinutesModel", "skip synced recording with empty path, vuiId=" + r114.f331795a);
        goto L33
    L37:
        r115 = false;
        goto L38
    L41:
        r100.f294192e = r111;
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        IDoraOfflineRecordSyncService r117 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r117 != null) goto L18;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch synced list skipped, dora record sync service is null");
        r100.f294192e = MapsKt.emptyMap();
        return CollectionsKt.emptyList();
    L18:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L23
        r102.label = 1;     // Catch: Throwable -> L23
        r104 = r117.c(r102);     // Catch: Throwable -> L23
        if (r104 != r105) goto L21;
        return r105;
    L23:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new RecordMinutesModel$fetchDoraSdkOfflineRecordings$1(r100, r101);
        goto L8
    }

    public static final Object d(RecordMinutesModel r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof RecordMinutesModel$fetchOfflineRecordings$1) == false) goto L7;
        RecordMinutesModel$fetchOfflineRecordings$1 r100 = (RecordMinutesModel$fetchOfflineRecordings$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L23
    L21:
        Object r113 = Result.m9449constructorimpl((List) r112);     // Catch: Throwable -> L23
    L25:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r113);
        if (r104 == null) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "fetch offline list failed: " + r104.getMessage());
    L28:
        List r105 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r113) == false) goto L31;
        r113 = r105;
    L31:
        List r114 = (List) r113;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r114.iterator();
    L33:
        if (r107.hasNext() == false) goto L37;
        Object r108 = r107.next();
        if (((yk9.d) r108).f568280c == true) goto L33;
        r106.add(r108);
        goto L33
    L37:
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch offline list, offlineList count: " + r114.size() + ", filter count: " + r106.size());
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r109 = r106.iterator();
    L39:
        if (r109.hasNext() == false) goto L46;
        yk9.d r116 = (yk9.d) r109.next();
        String r117 = r116.f568278a;
        String r118 = r110.i(r116.f568282e, Long.valueOf(r116.f568279b));
        if (r116.f568280c == false) goto L43;
        TagType r119 = TagType.RECORDING;
    L44:
        r115.add(new i0(r117, r118, r119, k(Long.valueOf(r116.f568279b)), Long.valueOf(r116.f568279b), r116.f568281d, r116.f568282e, null, 544));
        goto L39
    L43:
        r119 = TagType.OFFLINE;
        goto L44
    L46:
        return r115;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        IMinutesService r120 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r120 != null) goto L18;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch offline list skipped, minutes service is null");
        return CollectionsKt.emptyList();
    L18:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L23
        r100.label = 1;     // Catch: Throwable -> L23
        r112 = r120.x0(r100);     // Catch: Throwable -> L23
        if (r112 != r102) goto L21;
        return r102;
    L23:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new RecordMinutesModel$fetchOfflineRecordings$1(r110, r111);
        goto L8
    }

    public static final void e(RecordMinutesModel r100, String r101) {
        List<i0> r102 = r100.f294191d;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((i0) r105).f294246a, r101) == true) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r100.f294191d = r103;
    }

    public final String h(int r100, Long r101) {
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        Date r103 = new Date(r102);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        int r105 = com.larus.utils.j0.f375426a;
        return String.format(com.larus.utils.j0.d(r100), Arrays.copyOf(new Object[]{((SimpleDateFormat) this.f294188a.getValue()).format(r103), ((SimpleDateFormat) this.f294189b.getValue()).format(r103)}, 2));
    L5:
        r102 = System.currentTimeMillis();
        goto L6
    }

    public final String i(MinutesOfflineRecordingDeviceType r100, Long r101) {
        if (r100 != null) goto L4;
        int r102 = -1;
    L6:
        if (r102 != 1) goto L8;
        int r103 = R.string.larus_dora_ai_active_record_offline_title_smart_glasses_cn;
    L13:
        return h(r103, r101);
    L8:
        if (r102 != 2) goto L14;
        r103 = R.string.larus_dora_ai_active_record_offline_title_cn;
        goto L13
    L14:
        return j(null, r101);
    L4:
        r102 = b.f294194a[r100.ordinal()];
        goto L6
    }

    public final String j(String r100, Long r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L38;
        Integer r103 = this.f294190c;
        if (r103 != null) goto L13;
    L14:
        if (r103 != null) goto L17;
    L19:
        if (r103 != null) goto L22;
    L24:
        if (r103 != null) goto L27;
    L29:
        if (r103 != null) goto L32;
    L34:
        int r104 = R.string.larus_dora_ai_active_record_offline_title_cn;
    L37:
        return h(r104, r101);
    L32:
        if (r103.intValue() != 1048578) goto L34;
        r104 = R.string.larus_dora_ai_active_record_offline_title_freeclip2_cn;
        goto L37
    L27:
        if (r103.intValue() != 50) goto L29;
        r104 = R.string.larus_dora_ai_active_record_offline_title_freebuds_pro5_cn;
        goto L37
    L22:
        if (r103.intValue() != 81) goto L24;
        r104 = R.string.larus_dora_ai_active_record_offline_title_anker_cn;
        goto L37
    L17:
        if (r103.intValue() != 17) goto L19;
    L35:
        r104 = R.string.larus_dora_ai_active_record_offline_title_smart_glasses_cn;
        goto L37
    L13:
        if (r103.intValue() == 16) goto L35;
    L38:
        return r100;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public final Object m(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof RecordMinutesModel$notifyDoraCleanupSyncedRecording$1) == false) goto L7;
        RecordMinutesModel$notifyDoraCleanupSyncedRecording$1 r101 = (RecordMinutesModel$notifyDoraCleanupSyncedRecording$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        String r105 = (String) r101.L$1;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L36:
        Object r112 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r111).booleanValue()));     // Catch: Throwable -> L14
    L43:
        if (Result.m9456isSuccessimpl(r112) == false) goto L45;
        com.larus.avlink.n1.d("RecordMinutesModel", "dora cleanup after upload success, vuiId=" + r105 + ", result=" + ((Boolean) r112).booleanValue());
    L45:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r112);
        if (r107 == null) goto L48;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup after upload failed, vuiId=" + r105 + ": " + r107.getMessage());
    L48:
        Boolean r108 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r112) == false) goto L52;
        r112 = r108;
    L52:
        if (((Boolean) r112).booleanValue() == true) goto L55;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup incomplete, keep current item, vuiId=" + r105);
        return Boxing.boxBoolean(false);
    L55:
        this.f294193f.remove(r106, r105);
        monitor-enter(this);
        this.f294192e = MapsKt.minus(this.f294192e, r106);     // Catch: Throwable -> L61
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(this);
        return Boxing.boxBoolean(true);
    L61:
        th = move-exception;
        throw th;
    L14:
        Throwable th10 = th;
        String r113 = r106;
        String r114 = r105;
        r100 = r113;
    L41:
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        String r116 = r114;
        r106 = r100;
        r105 = r116;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        String r117 = this.f294193f.get(r100);
        if (r117 != null) goto L21;
    L24:
        boolean r118 = true;
    L25:
        if (r118 == false) goto L28;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup skipped, pending vuiId not found, id=" + r100);
        return Boxing.boxBoolean(false);
    L28:
        IDoraOfflineRecordSyncService r119 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r119 != null) goto L68;
        com.larus.avlink.n1.b("RecordMinutesModel", "dora cleanup skipped, sync service is null, vuiId=" + r117);
        return Boxing.boxBoolean(false);
    L68:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L39
        r101.L$0 = r100;     // Catch: Throwable -> L39
        r101.L$1 = r117;     // Catch: Throwable -> L39
        r101.label = 1;     // Catch: Throwable -> L39
        Object r121 = r119.b(r117, r101);     // Catch: Throwable -> L39
        if (r121 != r103) goto L35;
        return r103;
    L35:
        r106 = r100;
        r105 = r117;
        r111 = r121;
    L39:
        th = move-exception;
        r114 = r117;
        th10 = th;
        goto L41
    L21:
        if (StringsKt.isBlank(r117) == true) goto L24;
        r118 = false;
    L7:
        r101 = new RecordMinutesModel$notifyDoraCleanupSyncedRecording$1(this, r110);
        goto L8
    }

    public final i0 n(com.larus.dora.api.offline.record.e r110, String r111) {
        MinutesOfflineRecordingDeviceType r100 = MinutesOfflineRecordingDeviceType.GLASSES;
        return new i0(r111, i(r100, Long.valueOf(r110.f331798d)), TagType.OFFLINE, k(Long.valueOf(r110.f331798d)), Long.valueOf(r110.f331798d), null, r100, null, 672);
    }

    public static final Object a(RecordMinutesModel r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof RecordMinutesModel$deleteExternalOpusRecording$1) == false) goto L7;
        RecordMinutesModel$deleteExternalOpusRecording$1 r103 = (RecordMinutesModel$deleteExternalOpusRecording$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        String r108 = (String) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
        String r110 = r108;
        r101 = r109;
        Object r111 = r105;
    L36:
        Object r112 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r111).booleanValue()));     // Catch: Throwable -> L38
    L41:
        if (Result.m9456isSuccessimpl(r112) == false) goto L43;
        com.larus.avlink.n1.d("RecordMinutesModel", "delete external opus done, vuiId=" + r110 + ", result=" + ((Boolean) r112).booleanValue());
    L43:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L46;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus failed, vuiId=" + r110 + ": " + r113.getMessage());
    L46:
        Boolean r114 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r112) == false) goto L49;
        r112 = r114;
    L49:
        boolean r115 = ((Boolean) r112).booleanValue();
        if (r115 == false) goto L60;
        r100.f294193f.remove(r101);
        monitor-enter(r100);
        r100.f294192e = MapsKt.minus(r100.f294192e, r101);     // Catch: Throwable -> L56
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r100);
    L56:
        th = move-exception;
        throw th;
    L60:
        return Boxing.boxBoolean(r115);
    L38:
        Throwable th10 = th;
    L39:
        Result.Companion r117 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L14:
        th = move-exception;
        r110 = r108;
        r101 = r109;
        th10 = th;
        goto L39
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        com.larus.dora.api.offline.record.e r118 = r100.f294192e.get(r101);
        if (r118 == null) goto L21;
        r110 = r118.f331795a;
    L22:
        if (r110 != null) goto L24;
    L27:
        boolean r119 = true;
    L28:
        if (r119 == false) goto L30;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus skipped, vuiId not found, id=" + r101);
        return Boxing.boxBoolean(false);
    L30:
        IDoraOfflineRecordSyncService r120 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r120 != null) goto L63;
        com.larus.avlink.n1.b("RecordMinutesModel", "delete external opus skipped, sync service is null, vuiId=" + r110);
        return Boxing.boxBoolean(false);
    L63:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L38
        r103.L$0 = r101;     // Catch: Throwable -> L38
        r103.L$1 = r110;     // Catch: Throwable -> L38
        r103.label = 1;     // Catch: Throwable -> L38
        r111 = r120.b(r110, r103);     // Catch: Throwable -> L38
        if (r111 != r106) goto L36;
        return r106;
    L24:
        if (StringsKt.isBlank(r110) == true) goto L27;
        r119 = false;
        goto L28
    L21:
        r110 = null;
    L7:
        r103 = new RecordMinutesModel$deleteExternalOpusRecording$1(r100, r102);
        goto L8
    }

    public static List l(List r100, List r101, List r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = ((i0) r104.next()).f294246a;
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L8:
        HashSet r106 = CollectionsKt.toHashSet(r103);
        List r107 = r100;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r101.iterator();
    L10:
        if (r109.hasNext() == false) goto L21;
        Object r110 = r109.next();
        String r111 = ((i0) r110).f294246a;
        if (r111 != null) goto L14;
    L17:
        boolean r112 = true;
    L18:
        if (r112 == false) goto L10;
        r108.add(r110);
        goto L10
    L14:
        if (r106.contains(r111) == false) goto L17;
        r112 = false;
        goto L18
    L21:
        return CollectionsKt.sortedWith(CollectionsKt.plus(CollectionsKt.plus(r107, r108), r102), new c());
    }

    public static final com.larus.avlink.record.page.a b(RecordMinutesModel r100, List r101, List r102, String r103) {
        List<i0> r104 = r100.f294191d;
        if (r104.isEmpty() == true) goto L5;
    L9:
        List r105 = l(r104, r101, r102);
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch failed, fallback to cache, cacheCount=" + r104.size() + ", offlineCount=" + r101.size() + ", syncedCount=" + r102.size() + ", mergedCount=" + r105.size());
        return new com.larus.avlink.record.page.a.b(r105);
    L5:
        if (r101.isEmpty() == false) goto L9;
        if (r102.isEmpty() == false) goto L9;
        com.larus.avlink.n1.d("RecordMinutesModel", "fetch failed, cache/offline/synced list all empty, show error page");
        return new com.larus.avlink.record.page.a.C4006a(r103);
    }
}
