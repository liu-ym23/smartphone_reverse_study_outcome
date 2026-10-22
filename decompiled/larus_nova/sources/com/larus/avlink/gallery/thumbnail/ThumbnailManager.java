package com.larus.avlink.gallery.thumbnail;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.e.DoraImageManager;
import com.larus.avlink.gallery.compat.ThumbnailMetadataHelper;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes25.dex */
public final class ThumbnailManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThumbnailManager f292763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f292764b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f292765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f292766d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<MediaInfo> f292767e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f292768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<MediaInfo> f292769g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f292770h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MutableSharedFlow f292771i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f292772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f292773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f292774l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f292775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Function0<Boolean> f292776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicBoolean f292777o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static ThumbnailManager$init$protocolInfoCb$1 f292778p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static k0 f292779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static p0 f292780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static n0 f292781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static q0 f292782t;

    public ThumbnailManager() {
    }

    public static final boolean b() {
        if (b98.b.b(1) == false) goto L5;
        return true;
    L5:
        if (b98.b.b(5) == false) goto L7;
        return true;
    L7:
        if (b98.b.b(4) == false) goto L9;
        return true;
    L9:
        if (b98.b.b(7) == false) goto L11;
        return true;
    L11:
        if (ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(f292775m)) == true) goto L19;
        return false;
    L19:
        return true;
    }

    static {
        f292763a = new ThumbnailManager();
        f292764b = LazyKt.lazy(new j0());
        f292766d = new AtomicBoolean(false);
        f292767e = new ConcurrentLinkedQueue();
        f292769g = new ConcurrentLinkedQueue();
        MutableSharedFlow<Integer> r100 = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        f292770h = r100;
        f292771i = r100;
        f292774l = new CopyOnWriteArrayList();
        f292777o = new AtomicBoolean(false);
    }

    public static IDoraService k() {
        return (IDoraService) f292764b.getValue();
    }

    public static PolarisFileWrapper m() {
        String r100 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath();
        String r101 = AccountService.f365697a.getUserId();
        StringBuilder r102 = new StringBuilder("doraG");
        String r103 = File.separator;
        r102.append(r103);
        r102.append(r101);
        r102.append(r103);
        r102.append(DocCallbackImpl.KEY_THUMBNAIL);
        return new PolarisFileWrapper(r100, r102.toString());
    }

    public static void g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FLogger.f375446a.i("ThumbnailManager", "Adding album count change listener: " + r100);
        CopyOnWriteArrayList<a> r101 = f292774l;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        r100.a(f292772j, f292773k);
        return;
    }

    public static String l(String r100) {
        String r101 = com.larus.avlink.gallery.j.e(r100);
        int r102 = r101.hashCode();
        if (r102 == (-1617978531)) goto L14;
        if (r102 != 100313435) goto L7;
        r101.equals("image");
    L16:
        return "image";
    L7:
        if (r102 != 112202875) goto L16;
        if (r101.equals("video") == false) goto L16;
        return "video";
    L14:
        if (r101.equals("video_pack") == false) goto L16;
        return "video";
    }

    public static boolean o(MediaInfo r100) {
        Byte[] r101 = r100.getThumbnailTypes();
        if (r101 == null) goto L33;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        if (r101[r103].byteValue() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L12;
        r103 = r103 + 1;
        goto L6
    L12:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L34;
        int r106 = r101.length;
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L25;
        if (r101[r107].byteValue() != 1) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L23;
        r107 = r107 + 1;
        goto L17
    L23:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L35;
        return true;
    L35:
        return false;
    L21:
        r108 = false;
        goto L22
    L25:
        r109 = false;
        goto L26
    L34:
        return false;
    L10:
        r104 = false;
        goto L11
    L14:
        r105 = false;
        goto L15
    L33:
        return false;
    }

    public static void p(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FLogger.f375446a.i("ThumbnailManager", "Removing album count change listener: " + r100);
        f292774l.remove(r100);
    }

    public static void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (f292766d.compareAndSet(false, true) == false) goto L5;
        FLogger.f375446a.i("ThumbnailManager", "Starting thumbnail sync..., scene: " + r100);
        f292765c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ThumbnailManager$startSyncThumbnail$1(null), 3, null);
        return;
    L5:
        FLogger.f375446a.i("ThumbnailManager", "Already syncing thumbnail, skip. scene: " + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    public static final Object a(ThumbnailManager r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ThumbnailManager$getLocalThumbnailList$1) == false) goto L7;
        ThumbnailManager$getLocalThumbnailList$1 r102 = (ThumbnailManager$getLocalThumbnailList$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        r105 = new ArrayList();
        Iterator r107 = ((Iterable) r104).iterator();
    L19:
        if (r107.hasNext() == false) goto L27;
        Object r108 = r107.next();
        ThumbnailMetadata r109 = (ThumbnailMetadata) r108;
        boolean r110 = new PolarisFileWrapper(r109.getFilePath()).exists();     // Catch: Exception -> L23
    L25:
        if (r110 == false) goto L19;
        r105.add(r108);
    L23:
        e = move-exception;
        n1.c("ThumbnailManager", "local thumbnail file check exist error: " + r109.getFilePath(), e);
        r110 = false;
    L27:
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        AlbumDataBaseHelper r111 = AlbumDataBaseHelper.f292393a;
        r102.label = 1;
        r104 = r111.n(r102);
        if (r104 != r105) goto L17;
    L7:
        r102 = new ThumbnailManager$getLocalThumbnailList$1(r100, r101);
        goto L8
    }

    public static final void c(String r110, List r111) {
        List r112 = r111;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r113 = r112.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        r100.add(String.valueOf(r113.next()));
        goto L4
    L6:
        StringBuilder r114 = new StringBuilder(r110 + ": [");
        int r101 = r114.length();
        int r102 = r100.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        String r104 = (String) ListProtector.get(r100, r103);
        if (r103 >= (r100.size() - 1)) goto L12;
        String r105 = ", ";
    L14:
        if ((((r104.length() + r101) + r105.length()) + 1) <= 3000) goto L16;
        r114.append("...");
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder();
        r107.append(r114);
        r107.append(']');
        r106.i("ThumbnailManager", r107.toString());
        r114 = new StringBuilder(r110 + " (cont.): [");
        r101 = r114.length();
    L16:
        r114.append(r104);
        r114.append(r105);
        r101 = r101 + (r104.length() + r105.length());
        r103 = r103 + 1;
        goto L8
    L12:
        r105 = "";
        goto L14
    L17:
        FLogger.f375446a.i("ThumbnailManager", StringsKt.trimEnd(r114.toString(), new char[]{',', ' '}) + ']');
    }

    public static final void f(Integer r100, Integer r101) {
        int r102 = f292772j;
        int r103 = f292773k;
        int r104 = 0;
        if (r100 == null) goto L5;
        int r105 = r100.intValue();
    L6:
        f292772j = r105;
        if (r101 == null) goto L9;
        r104 = r101.intValue();
    L9:
        f292773k = r104;
        FLogger.f375446a.i("ThumbnailManager", "Album count changed. Old: (photos=" + r102 + ", videos=" + r103 + "), New: (photos=" + f292772j + ", videos=" + f292773k + "). Notifying listeners...");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ThumbnailManager$tryNotifyAlbumCountChanged$1(null), 2, null);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    public static final Object d(ThumbnailManager r100, MediaInfo r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof ThumbnailManager$processDisplayItem$1) == false) goto L7;
        ThumbnailManager$processDisplayItem$1 r101 = (ThumbnailManager$processDisplayItem$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L40:
        MediaInfo r105 = f292767e.poll();
    L44:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (MediaInfo) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L35:
        byte[] r113 = (byte[]) r112;
        if (r113 == null) goto L41;
        r101.L$0 = null;
        r101.label = 2;
        if (r100.n(r113, r110, r101) != r103) goto L40;
        return r103;
    L41:
        FLogger.f375446a.w("ThumbnailManager", "Display: Request thumbnail data failed, retry for mediaId: " + r110.getMediaId());
        ConcurrentLinkedQueue<MediaInfo> r106 = f292767e;
        r106.poll();
        Boxing.boxBoolean(r106.offer(r110));
        goto L44
    L16:
        ResultKt.throwOnFailure(r112);
        if (Intrinsics.areEqual(r110.getHasThumbnail(), Boxing.boxBoolean(true)) == false) goto L42;
        FLogger.f375446a.i("ThumbnailManager", "Display: hasThumbnail is true, deal with mediaId: " + r110.getMediaId());
        Byte[] r114 = r110.getThumbnailTypes();
        int r107 = 0;
        if (r114 == null) goto L32;
        int r108 = r114.length;
        int r109 = 0;
    L21:
        if (r109 >= r108) goto L29;
        if (r114[r109].byteValue() != 1) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == true) goto L27;
        r109 = r109 + 1;
        goto L21
    L27:
        boolean r116 = true;
    L30:
        if (r116 != true) goto L32;
        r107 = 1;
        goto L32
    L25:
        r115 = false;
        goto L26
    L29:
        r116 = false;
    L32:
        r101.L$0 = r110;
        r101.label = 1;
        r112 = r100.q(r110, r107, r101);
        if (r112 != r103) goto L35;
        return r103;
    L42:
        FLogger.f375446a.i("ThumbnailManager", "Display: hasThumbnail is false, skip for mediaId: " + r110.getMediaId());
        MediaInfo r117 = f292767e.poll();
    L7:
        r101 = new ThumbnailManager$processDisplayItem$1(r100, r111);
        goto L8
    }

    public static final Object e(ThumbnailManager r100, MediaInfo r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ThumbnailManager$processUploadItem$1) == false) goto L7;
        ThumbnailManager$processUploadItem$1 r103 = (ThumbnailManager$processUploadItem$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (MediaInfo) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        byte[] r108 = (byte[]) r105;
        if (r108 == null) goto L33;
        Long r109 = r101.getMediaId();
        if (r109 == null) goto L24;
        long r110 = r109.longValue();
    L26:
        if (r110 != 0) goto L37;
        FLogger.f375446a.e("ThumbnailManager", "Upload: Invalid imageUuid, skipping handleUploadThumbnailData.");
    L32:
        MediaInfo r111 = f292769g.poll();
    L36:
        return Unit.INSTANCE;
    L37:
        t(r108, r101, r110);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailManager", "Upload: Error handling thumbnail data for imageUuid=" + r110 + ": " + e.getMessage(), e);
        goto L32
    L24:
        r110 = 0;
        goto L26
    L33:
        FLogger.f375446a.w("ThumbnailManager", "Upload: Request thumbnail data failed, retry for mediaId: " + r101.getMediaId());
        ConcurrentLinkedQueue<MediaInfo> r112 = f292769g;
        r112.poll();
        Boxing.boxBoolean(r112.offer(r101));
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (Intrinsics.areEqual(r101.getHasThumbnail(), Boxing.boxBoolean(true)) == false) goto L34;
        FLogger.f375446a.i("ThumbnailManager", "Upload: hasThumbnail is true, deal with mediaId: " + r101.getMediaId());
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r100.q(r101, 0, r103);
        if (r105 != r106) goto L19;
        return r106;
    L34:
        FLogger.f375446a.i("ThumbnailManager", "Upload: hasThumbnail is false, skip for mediaId: " + r101.getMediaId());
        MediaInfo r113 = f292769g.poll();
    L7:
        r103 = new ThumbnailManager$processUploadItem$1(r100, r102);
        goto L8
    }

    public static void t(byte[] r210, MediaInfo r211, long r212) {
        Long r100 = r211.getCreateTime();
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        long r102 = System.currentTimeMillis() - r101;
        boolean r103 = false;
        if (r102 > 60000) goto L20;
        IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r104 == null) goto L15;
        DeviceService r105 = r104.device();
        if (r105 == null) goto L15;
        if (r105.t() != 2) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L20;
        if (b98.b.b(2) == true) goto L20;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L47;
        Long r108 = r211.getMediaId();
        if (r108 != null) goto L49;
        FLogger.f375446a.e("ThumbnailManager", "Cannot upload thumbnail, mediaId is null.");
    L46:
        FLogger.f375446a.i("ThumbnailManager", "Triggered thumbnail upload to server: imageUuid=" + r212);
        return;
    L49:
        int r109 = (int) r108.longValue();     // Catch: Exception -> L44
        Integer r110 = r211.getWidth();     // Catch: Exception -> L44
        if (r110 == null) goto L29;
        int r111 = r110.intValue();     // Catch: Exception -> L44
    L30:
        Integer r112 = r211.getHeight();     // Catch: Exception -> L44
        if (r112 == null) goto L33;
        int r213 = r112.intValue();     // Catch: Exception -> L44
    L34:
        b49.h r113 = new b49.h(r109, r210, r111, r213, 1, 1, 0, 20, r108.longValue());     // Catch: Exception -> L44
        f98.l r214 = f98.g.b(r113, 10);     // Catch: Exception -> L44
        Map<String, com.larus.avlink.model.a> r114 = DoraImageManager.f291761a;     // Catch: Exception -> L44
        if (DoraImageManager.a(Integer.valueOf(r109)) != null) goto L37;
        com.larus.avlink.model.a r115 = new com.larus.avlink.model.a(Integer.valueOf(r109), r111, r213, 1, 20, null, null, null, -4232, 63);     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r115, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);     // Catch: Exception -> L44
        DoraImageManager.f291761a.put(String.valueOf(r115.f293422a), r115);     // Catch: Exception -> L44
        FLogger.f375446a.i("ThumbnailManager", "uploadThumbnailToServer: init DoraPicModel for thumbnail upload, imageUuid=" + r108);     // Catch: Exception -> L44
    L37:
        if (r214 == null) goto L39;
        com.larus.avlink.e.l.f291786a.b(r113, 20, CollectionsKt.listOf(r214));     // Catch: Exception -> L44
    L39:
        FLogger r116 = FLogger.f375446a;     // Catch: Exception -> L44
        StringBuilder r117 = new StringBuilder("Called doUploadFile for thumbnail upload: imageUuid=");     // Catch: Exception -> L44
        r117.append(r108);     // Catch: Exception -> L44
        r117.append(", fileContent is null=");     // Catch: Exception -> L44
        if (r214 == null) goto L42;
        r103 = true;
    L42:
        r117.append(r103);     // Catch: Exception -> L44
        r116.i("ThumbnailManager", r117.toString());     // Catch: Exception -> L44
        goto L46
    L33:
        r213 = 0;
        goto L34
    L29:
        r111 = 0;
    L44:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailManager", "Error calling doUploadFile for imageUuid=" + r108 + ": " + e.getMessage(), e);
        goto L46
    L47:
        FLogger.f375446a.i("ThumbnailManager", "Skip uploading thumbnail, conditions not met for imageUuid=" + r212);
        return;
    L15:
        r106 = false;
    L20:
        r107 = false;
        goto L22
    L5:
        r101 = 0;
        goto L6
    }

    public final Object h(MediaInfo r210, File r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof ThumbnailManager$createMetaData$1) == false) goto L7;
        ThumbnailManager$createMetaData$1 r100 = (ThumbnailManager$createMetaData$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$createMetaData$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r110.J$0;
        ResultKt.throwOnFailure(r102);
    L43:
        FLogger.f375446a.i("ThumbnailManager", "Successfully created thumbnail metadata: imageUuid=" + r105);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Long r106 = r210.getMediaId();
        long r107 = 0;
        if (r106 == null) goto L17;
        long r111 = r106.longValue();
    L18:
        ThumbnailMetadataHelper r108 = ThumbnailMetadataHelper.f292369a;
        if (r211 == null) goto L21;
        String r109 = r211.getAbsolutePath();
    L22:
        String r112 = r210.getMediaType();
        if (r112 != null) goto L25;
        r112 = "image_pack";
    L25:
        String r113 = l(r112);
        Integer r114 = r210.getWidth();
        int r115 = 0;
        if (r114 == null) goto L28;
        int r116 = r114.intValue();
    L29:
        Integer r117 = r210.getHeight();
        if (r117 == null) goto L32;
        r115 = r117.intValue();
    L32:
        Long r118 = r210.getDuration();
        if (r118 == null) goto L35;
        long r119 = r118.longValue();
    L36:
        Long r120 = r210.getCreateTime();
        if (r120 == null) goto L39;
        r107 = r120.longValue();
    L39:
        long r121 = r107;
        AccountService.f365697a.getUserId();
        r110.J$0 = r111;
        r110.label = 1;
        long r122 = r111;
        if (r108.a(r109, r111, r113, r116, r115, r119, r121, r110) != r103) goto L42;
        return r103;
    L42:
        r105 = r122;
        goto L43
    L35:
        r119 = 0;
        goto L36
    L28:
        r116 = 0;
        goto L29
    L21:
        r109 = null;
        goto L22
    L17:
        r111 = 0;
    L7:
        r100 = new ThumbnailManager$createMetaData$1(this, r212);
        goto L8
    }

    public final Object i(long r100, String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ThumbnailManager$deleteThumbnail$1) == false) goto L7;
        ThumbnailManager$deleteThumbnail$1 r101 = (ThumbnailManager$deleteThumbnail$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$deleteThumbnail$1 r103 = r101;
        Object r112 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        long r106 = r103.J$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L49
    L52:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r100 = r103.J$0;
        r110 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L49
    L19:
        String r107 = r110;
        ThumbnailMetadata r113 = (ThumbnailMetadata) r112;     // Catch: Exception -> L49
        if (r113 == null) goto L47;
        ThumbnailMetadataHelper r108 = ThumbnailMetadataHelper.f292369a;     // Catch: Exception -> L49
        String r109 = r113.getFilePath();     // Catch: Exception -> L49
        r103.L$0 = null;     // Catch: Exception -> L49
        r103.J$0 = r100;     // Catch: Exception -> L49
        r103.label = 2;     // Catch: Exception -> L49
        if (r108.d(r100, r109, r107, r103) != r104) goto L52;
        return r104;
    L47:
        FLogger.f375446a.w("ThumbnailManager", "Thumbnail metadata not found for imageUuid: " + r100);     // Catch: Exception -> L49
        goto L52
    L20:
        ResultKt.throwOnFailure(r112);
        FLogger.f375446a.i("ThumbnailManager", "Deleting thumbnail, imageUuid: " + r100);
        Iterator<MediaInfo> r114 = f292767e.iterator();     // Catch: Exception -> L49
    L23:
        if (r114.hasNext() == false) goto L30;
        Long r115 = r114.next().getMediaId();     // Catch: Exception -> L49
        if (r115 == null) goto L23;
        if (r115.longValue() != r100) goto L23;
        r114.remove();     // Catch: Exception -> L49
        goto L23
    L30:
        Iterator<MediaInfo> r116 = f292769g.iterator();     // Catch: Exception -> L49
    L32:
        if (r116.hasNext() == false) goto L39;
        Long r117 = r116.next().getMediaId();     // Catch: Exception -> L49
        if (r117 == null) goto L32;
        if (r117.longValue() != r100) goto L32;
        r116.remove();     // Catch: Exception -> L49
        goto L32
    L39:
        AlbumDataBaseHelper r118 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L49
        r103.L$0 = r110;     // Catch: Exception -> L49
        r103.J$0 = r100;     // Catch: Exception -> L49
        r103.label = 1;     // Catch: Exception -> L49
        r112 = r118.w(r100, r110, r103);     // Catch: Exception -> L49
        if (r112 != r104) goto L19;
        return r104;
    L49:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailManager", "Error deleting thumbnail for imageUuid=" + r100 + ": " + e.getMessage(), e);
    L7:
        r101 = new ThumbnailManager$deleteThumbnail$1(this, r111);
        goto L8
    }

    public final Object j(List<Long> r100, String r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ThumbnailManager$deleteThumbnails$1) == false) goto L7;
        ThumbnailManager$deleteThumbnails$1 r103 = (ThumbnailManager$deleteThumbnails$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L17;
        if (r107 != 1) goto L16;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L13
    L24:
    L23:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r105);
        FLogger.f375446a.i("ThumbnailManager", "Deleting thumbnails, imageUuids: " + r100);
        ThumbnailMetadataHelper r108 = ThumbnailMetadataHelper.f292369a;     // Catch: Exception -> L13
        r103.label = 1;     // Catch: Exception -> L13
        if (r108.c(r100, r101, r103) != r106) goto L24;
        return r106;
    L13:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailManager", "Error batch deleting thumbnails: " + e.getMessage(), e);
    L7:
        r103 = new ThumbnailManager$deleteThumbnails$1(this, r102);
        goto L8
    }

    public final Object n(byte[] r110, MediaInfo r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ThumbnailManager$handleDisplayThumbnailData$1) == false) goto L7;
        ThumbnailManager$handleDisplayThumbnailData$1 r100 = (ThumbnailManager$handleDisplayThumbnailData$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        long r114 = r100.J$0;
        MediaInfo r104 = (MediaInfo) r100.L$1;
        byte[] r105 = (byte[]) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L14
        long r106 = r114;
        r111 = r104;
        r110 = r105;
    L37:
        if (o(r111) == true) goto L39;
        t(r110, r111, r106);     // Catch: Exception -> L41
    L39:
        f292770h.tryEmit(Boxing.boxInt(1));     // Catch: Exception -> L41
        FLogger.f375446a.d("ThumbnailManager", "Display: Posted thumbnail saved event for imageUuid=" + r106);     // Catch: Exception -> L41
    L45:
        return Unit.INSTANCE;
    L14:
        Exception e100 = e;
    L43:
        FLogger.f375446a.e("ThumbnailManager", "Display: Error handling thumbnail data for imageUuid=" + r114 + ": " + e100.getMessage(), e100);
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        Long r115 = r111.getMediaId();
        if (r115 == null) goto L21;
        r106 = r115.longValue();
    L23:
        if (r106 != 0) goto L46;
        FLogger.f375446a.e("ThumbnailManager", "Display: Invalid imageUuid, skipping handleDisplayThumbnailData.");
        return Unit.INSTANCE;
    L46:
        Long r116 = r111.getCreateTime();     // Catch: Exception -> L41
        String r107 = r111.getMediaType();     // Catch: Exception -> L41
        if (r107 != null) goto L29;
        r107 = "image_pack";
    L29:
        PolarisFileWrapper r117 = r(r106, r116, r110, r107);     // Catch: Exception -> L41
        if (r117 != null) goto L33;
        FLogger.f375446a.e("ThumbnailManager", "Display: Failed to save thumbnail file for imageUuid=" + r106);     // Catch: Exception -> L41
        return Unit.INSTANCE;
    L33:
        r100.L$0 = r110;     // Catch: Exception -> L41
        r100.L$1 = r111;     // Catch: Exception -> L41
        r100.J$0 = r106;     // Catch: Exception -> L41
        r100.label = 1;     // Catch: Exception -> L41
        if (u(r111, r117, r100) != r102) goto L37;
        return r102;
    L41:
        e = move-exception;
        e100 = e;
        r114 = r106;
        goto L43
    L21:
        r106 = 0;
    L7:
        r100 = new ThumbnailManager$handleDisplayThumbnailData$1(this, r112);
        goto L8
    }

    public final Object q(MediaInfo r210, int r211, Continuation<? super byte[]> r212) {
        int r100 = r211;
        if ((r212 instanceof ThumbnailManager$requestThumbnailData$1) == false) goto L7;
        ThumbnailManager$requestThumbnailData$1 r101 = (ThumbnailManager$requestThumbnailData$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$requestThumbnailData$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r106 = r110.J$1;
        long r107 = r110.J$0;
        r100 = r110.I$0;
        Long r108 = (Long) r110.L$2;
        Long r109 = (Long) r110.L$1;
        MediaInfo r111 = (MediaInfo) r110.L$0;
        ResultKt.throwOnFailure(r103);
    L43:
        Long r112 = r108;
        long r213 = r107;
        b49.b r113 = (b49.b) r103;
        Long r114 = r109;
        long r115 = r106;
    L45:
        long r116 = System.currentTimeMillis() - r115;
        StringBuilder r117 = new StringBuilder();
        r117.append(r114);
        r117.append('_');
        r117.append(r112);
        r117.append('_');
        r117.append(r100);
        String r118 = r117.toString();
        if ((r113 instanceof b49.b.C0263b) == false) goto L50;
        b49.b.C0263b r119 = (b49.b.C0263b) r113;
        byte[] r120 = r119.f17647a;
        GalleryMobHelper r121 = GalleryMobHelper.f293006a;
        String r122 = r111.getMediaType();
        int r123 = r119.f17648b;
        int r124 = r120.length;
        r121.getClass();
        GalleryMobHelper.k(r118, r116, r122, 0, 0, r213, r123, r124);
        return r120;
    L50:
        if ((r113 instanceof b49.b.a) == false) goto L52;
        FLogger.f375446a.e("ThumbnailManager", "ThumbnailData is null or empty, skip for mediaId=" + r114);
        GalleryMobHelper r125 = GalleryMobHelper.f293006a;
        String r126 = r111.getMediaType();
        int r127 = ((b49.b.a) r113).f17645a;
        r125.getClass();
        GalleryMobHelper.k(r118, r116, r126, 1, r127, r213, 0, -1);
    L52:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r114 = r210.getMediaId();
        r112 = r210.getCreateTime();
        if (r114 == null) goto L53;
        if (r112 == null) goto L53;
        Byte[] r128 = r210.getThumbnailTypes();
        boolean r129 = false;
        if (r128 == null) goto L32;
        int r130 = r128.length;
        int r131 = 0;
    L21:
        if (r131 >= r130) goto L29;
        if (r128[r131].byteValue() != 1) goto L25;
        boolean r132 = true;
    L26:
        if (r132 == true) goto L27;
        r131 = r131 + 1;
        goto L21
    L27:
        boolean r133 = true;
    L30:
        if (r133 == true) goto L32;
        r129 = true;
        goto L32
    L25:
        r132 = false;
        goto L26
    L29:
        r133 = false;
    L32:
        if (r129 == true) goto L34;
        long r134 = 10000;
    L35:
        long r135 = r134;
        long r136 = System.currentTimeMillis();
        IDoraService r137 = k();
        if (r137 == null) goto L44;
        VisionService r138 = r137.V();
        if (r138 == null) goto L44;
        r110.L$0 = r210;
        r110.L$1 = r114;
        r110.L$2 = r112;
        r110.I$0 = r100;
        r110.J$0 = r135;
        r110.J$1 = r136;
        r110.label = 1;
        Object r139 = r138.v(r114.longValue(), r112.longValue(), (byte) r100, r135, r110);
        if (r139 != r104) goto L42;
        return r104;
    L42:
        r111 = r210;
        r109 = r114;
        r103 = r139;
        r108 = r112;
        r106 = r136;
        r107 = r135;
    L44:
        r111 = r210;
        r113 = null;
        r115 = r136;
        r213 = r135;
        goto L45
    L34:
        r134 = 3000;
    L53:
        FLogger.f375446a.e("ThumbnailManager", "Invalid mediaInfo, mediaId=" + r114 + ", createTime=" + r112);
        return null;
    L7:
        r101 = new ThumbnailManager$requestThumbnailData$1(this, r212);
        goto L8
    }

    public final Object u(MediaInfo r210, PolarisFileWrapper r211, Continuation r212) {
        if ((r212 instanceof ThumbnailManager$updateMetaData$1) == false) goto L7;
        ThumbnailManager$updateMetaData$1 r100 = (ThumbnailManager$updateMetaData$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$updateMetaData$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r110.J$0;
        ResultKt.throwOnFailure(r102);
    L43:
        FLogger.f375446a.i("ThumbnailManager", "Successfully updated thumbnail metadata: imageUuid=" + r105);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Long r106 = r210.getMediaId();
        long r107 = 0;
        if (r106 == null) goto L17;
        long r111 = r106.longValue();
    L18:
        ThumbnailMetadataHelper r108 = ThumbnailMetadataHelper.f292369a;
        if (r211 == null) goto L21;
        String r109 = r211.getAbsolutePath();
    L22:
        String r112 = r210.getMediaType();
        if (r112 != null) goto L25;
        r112 = "image_pack";
    L25:
        String r113 = l(r112);
        Integer r114 = r210.getWidth();
        int r115 = 0;
        if (r114 == null) goto L28;
        int r116 = r114.intValue();
    L29:
        Integer r117 = r210.getHeight();
        if (r117 == null) goto L32;
        r115 = r117.intValue();
    L32:
        Long r118 = r210.getDuration();
        if (r118 == null) goto L35;
        long r119 = r118.longValue();
    L36:
        Long r120 = r210.getCreateTime();
        if (r120 == null) goto L39;
        r107 = r120.longValue();
    L39:
        long r121 = r107;
        AccountService.f365697a.getUserId();
        r110.J$0 = r111;
        r110.label = 1;
        long r122 = r111;
        if (r108.e(r109, r111, r113, r116, r115, r119, r121, r110) != r103) goto L42;
        return r103;
    L42:
        r105 = r122;
        goto L43
    L35:
        r119 = 0;
        goto L36
    L28:
        r116 = 0;
        goto L29
    L21:
        r109 = null;
        goto L22
    L17:
        r111 = 0;
    L7:
        r100 = new ThumbnailManager$updateMetaData$1(this, r212);
        goto L8
    }

    public static PolarisFileWrapper r(long r100, Long r101, byte[] r102, String r110) {
        PolarisFileWrapper r103 = m();     // Catch: Exception -> L25
        if (r103.exists() == true) goto L6;
        r103.mkdirs();     // Catch: Exception -> L25
    L6:
        int r104 = r110.hashCode();     // Catch: Exception -> L25
        if (r104 == (-1617978531)) goto L20;
        if (r104 == (-1442901379)) goto L17;
        if (r104 == 1333277997) goto L14;
    L21:
        String r111 = ".jpg";
    L23:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r103, "thumb_" + r100 + '_' + r101 + r111);     // Catch: Exception -> L25
        FilesKt.writeBytes(r112, r102);     // Catch: Exception -> L25
        FLogger r105 = FLogger.f375446a;     // Catch: Exception -> L25
        StringBuilder r106 = new StringBuilder("Saved thumbnail file: ");     // Catch: Exception -> L25
        r106.append(r112.getAbsolutePath());     // Catch: Exception -> L25
        r105.i("ThumbnailManager", r106.toString());     // Catch: Exception -> L25
        return r112;
    L14:
        if (r110.equals("video_mp4") == false) goto L21;
    L22:
        r111 = ".jpeg";
        goto L23
    L17:
        if (r110.equals("image_pack") == true) goto L22;
    L20:
        if (r110.equals("video_pack") == true) goto L22;
    L25:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailManager", "Error saving thumbnail file for imageUuid=" + r100 + ": " + e.getMessage(), e);
        return null;
    }
}
