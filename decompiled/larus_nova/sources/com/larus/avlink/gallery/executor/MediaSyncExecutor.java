package com.larus.avlink.gallery.executor;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import w88.o;

/* JADX INFO: loaded from: classes25.dex */
public final class MediaSyncExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaSyncExecutor f292553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContentResolver f292554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaLifecycleStateManager f292555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Uri> f292556d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f292557e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f292558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f292559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CoroutineScope f292560h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static w88.a f292561i;

    public static final class a extends ContentObserver {
        public a(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            super.onChange(r100, r101);
            FLogger.f375446a.d("MediaSyncExecutor", "Image content changed, uri: " + r101);
            MediaSyncExecutor r102 = MediaSyncExecutor.f292553a;
            MediaSyncExecutor.c(r101);
            MediaAdditionReconciler r103 = MediaAdditionReconciler.f292495a;
            com.larus.avlink.gallery.e.f292493a.getClass();
            if (com.larus.avlink.gallery.e.i() == false) goto L29;
            if (r101 == null) goto L24;
            String r104 = r101.getLastPathSegment();
            if (r104 == null) goto L27;
            Long r105 = StringsKt.toLongOrNull(r104);
            if (r105 == null) goto L28;
            long r106 = r105.longValue();
            if (r106 <= 0) goto L30;
            Object r107 = MediaAdditionReconciler.f292499e;
            monitor-enter(r107);
            MediaAdditionReconciler.f292498d.add(Long.valueOf(r106));     // Catch: Throwable -> L21
            Job r108 = MediaAdditionReconciler.f292500f;     // Catch: Throwable -> L21
            if (r108 == null) goto L18;
            Job.DefaultImpls.cancel$default(r108, null, 1, null);     // Catch: Throwable -> L21
        L18:
            MediaAdditionReconciler.f292500f = BuildersKt.launch$default(MediaAdditionReconciler.f292501g, null, null, new MediaAdditionReconciler$onImageContentChanged$1$1(null), 3, null);     // Catch: Throwable -> L21
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r107);
            return;
        L21:
            th = move-exception;
            throw th;
        L30:
            return;
        L28:
            return;
        L27:
            return;
        L24:
            return;
        }
    }

    public static final class b extends ContentObserver {
        public b(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            super.onChange(r100, r101);
            FLogger.f375446a.d("MediaSyncExecutor", "Video content changed, uri: " + r101);
            MediaSyncExecutor r102 = MediaSyncExecutor.f292553a;
            MediaSyncExecutor.c(r101);
        }
    }

    public MediaSyncExecutor() {
    }

    static {
        f292553a = new MediaSyncExecutor();
        ContentResolver r100 = AppHost.f326268a.getApplication().getContentResolver();
        f292554b = r100;
        f292555c = MediaLifecycleStateManager.f292361b.a();
        f292556d = new LinkedHashSet();
        f292557e = new Object();
        f292560h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        a r101 = new a(new Handler(Looper.getMainLooper()));
        b r102 = new b(new Handler(Looper.getMainLooper()));
        r100.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, r101);
        r100.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, r102);
    }

    public static void c(Uri r100) {
        Object r101 = f292557e;
        monitor-enter(r101);
        boolean r102 = true;
        if (r100 != null) goto L22;
        Job r103 = f292558f;     // Catch: Throwable -> L28
        if (r103 == null) goto L9;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);     // Catch: Throwable -> L28
    L9:
        f292558f = null;     // Catch: Throwable -> L28
        f292556d.clear();     // Catch: Throwable -> L28
        Job r104 = f292559g;     // Catch: Throwable -> L28
        if (r104 != null) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == false) goto L19;
        FLogger.f375446a.d("MediaSyncExecutor", "Full check already in progress, skipping");     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L19:
        f292559g = BuildersKt.launch$default(f292560h, null, null, new MediaSyncExecutor$checkDeletedMedia$1$1(null), 3, null);     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L12:
        if (r104.isActive() != true) goto L14;
    L22:
        f292556d.add(r100);     // Catch: Throwable -> L28
        Job r105 = f292558f;     // Catch: Throwable -> L28
        if (r105 == null) goto L25;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);     // Catch: Throwable -> L28
    L25:
        f292558f = BuildersKt.launch$default(f292560h, null, null, new MediaSyncExecutor$checkDeletedMedia$1$2(null), 3, null);     // Catch: Throwable -> L28
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public static void d(String[] r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaIds");
        if (r110.length != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        FLogger r101 = FLogger.f375446a;
        r101.i("MediaSyncExecutor", "deleteFromAlbum: deleting " + r110.length + " items: " + ArraysKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));
        ContentResolver r102 = f292554b;
        int r103 = com.larus.avlink.gallery.c.d(r102, r110, false);
        int r111 = com.larus.avlink.gallery.c.d(r102, r110, true);
        r101.i("MediaSyncExecutor", "deleteFromAlbum: deleted " + (r103 + r111) + " items (" + r103 + " images, " + r111 + " videos)");
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static String e(MediaMetadata r100, PolarisFileWrapper r101) {
        String r102 = FilesKt.getExtension(r101);
        boolean r103 = com.larus.avlink.gallery.c.k(r101.getName());
        int r104 = ia8.d.f488936a;
        long r105 = r100.getCreateTime();
        if (r105 != 0) goto L5;
        String r106 = "";
    L6:
        String r107 = r100.getAlgorithmType();
        if (r107 != null) goto L9;
    L27:
        int r108 = 0;
    L29:
        if (r103 == false) goto L32;
        return "VID_" + r106 + '_' + r100.getMediaId() + '_' + r100.getActiveMask() + r108 + '.' + r102;
    L32:
        return "IMG_" + r106 + '_' + r100.getMediaId() + '_' + r100.getActiveMask() + r108 + '.' + r102;
    L9:
        switch(r107.hashCode()) {
            case -1068318794: goto L24;
            case 103158: goto L20;
            case 3348765: goto L16;
            case 103060854: goto L12;
            default: goto L27;
        };
    L12:
        if (r107.equals("llhdr") == false) goto L27;
        r108 = 2;
        goto L29
    L16:
        if (r107.equals("mfnr") == false) goto L27;
        r108 = 3;
        goto L29
    L20:
        if (r107.equals("hdr") == false) goto L27;
        r108 = 1;
        goto L29
    L24:
        if (r107.equals(BytedCertConstant.LiveType.LIVE_TYPE_ACTION) == false) goto L27;
        r108 = 4;
        goto L29
    L5:
        Calendar r109 = Calendar.getInstance();
        r109.setTimeInMillis(r105);
        r106 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.getDefault()).format(r109.getTime());
        goto L6
    }

    public final Object f(MediaMetadata r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof MediaSyncExecutor$syncToAlbum$1) == false) goto L7;
        MediaSyncExecutor$syncToAlbum$1 r100 = (MediaSyncExecutor$syncToAlbum$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r111 = ": ";
        String r103 = "Media ";
        switch(r100.label) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L29;
            case 5: goto L24;
            case 6: goto L21;
            case 7: goto L16;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r102);
    L201:
        return Unit.INSTANCE;
    L13:
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L32
        r103 = "Media ";
        String r112 = "MediaSyncExecutor";
        String r105 = ": ";
    L210:
        FLogger.f375446a.i(r112, r103 + r104 + " synced skipped, uniqId: " + r104);     // Catch: Exception -> L187
    L187:
        e = e;
        String r113 = r104;
    L197:
        FLogger.f375446a.e(r112, "Exception syncing media " + r113 + r105 + e.getMessage(), e);
        MediaLifecycleStateManager r106 = f292555c;
        StringBuilder r107 = new StringBuilder("Sync exception: ");
        r107.append(e.getMessage());
        String r108 = r107.toString();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 9;
        if (r106.b(r113, r108, r100) != r110) goto L201;
        return r110;
    L16:
        long r109 = r100.J$0;
        String r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L19
        r103 = "Media ";
        r112 = "MediaSyncExecutor";
        r105 = ": ";
    L206:
        FLogger.f375446a.i(r112, r103 + r114 + " synced successfully, systemGalleryId: " + r109);     // Catch: Exception -> L176
    L176:
        e = e;
    L193:
        r113 = r114;
    L19:
        e = e;
    L34:
        r112 = "MediaSyncExecutor";
        r105 = ": ";
        goto L193
    L21:
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L32
        r112 = "MediaSyncExecutor";
        String r116 = ": ";
    L208:
        return Unit.INSTANCE;
    L156:
        e = e;
        r114 = r115;
        r105 = r116;
        goto L193
    L24:
        long r117 = r100.J$0;
        String r118 = (String) r100.L$1;
        String r119 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L27
        String r120 = r119;
        r103 = "Media ";
        r112 = "MediaSyncExecutor";
        String r121 = ", systemGalleryId: ";
        String r122 = r118;
        long r123 = r117;
        String r124 = ": ";
    L230:
        FLogger.f375446a.i(r112, r103 + r120 + " synced to public album: " + r122 + r121 + r123);     // Catch: Exception -> L115
        return Unit.INSTANCE;
    L115:
        e = e;
    L116:
        r113 = r120;
    L121:
        r105 = r124;
    L117:
        e = e;
    L27:
        e = e;
        r114 = r119;
        goto L34
    L29:
        String r125 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L32
        r112 = "MediaSyncExecutor";
    L212:
        return Unit.INSTANCE;
    L86:
        e = e;
        r113 = r125;
    L104:
        r124 = r111;
        goto L121
    L35:
        ResultKt.throwOnFailure(r102);
    L71:
        return Unit.INSTANCE;
    L36:
        ResultKt.throwOnFailure(r102);
    L60:
        return Unit.INSTANCE;
    L37:
        String r126 = (String) r100.L$1;
        MediaMetadata r127 = (MediaMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r113 = r126;
    L43:
        if (r127.getSystemGalleryId() == null) goto L62;
        Long r128 = r127.getSystemGalleryId();
        if (r128 != null) goto L48;
    L49:
        Long r129 = r127.getSystemGalleryId();
        if (r129 != null) goto L53;
    L54:
        String r130 = r127.getSystemGalleryId().toString();
        if (com.larus.avlink.gallery.c.i(f292554b, r130) == false) goto L61;
        FLogger.f375446a.i("MediaSyncExecutor", "Media already synced to album: " + r113 + ", systemGalleryId: " + r130);
        MediaLifecycleStateManager r131 = f292555c;
        MediaLifecycleState r132 = MediaLifecycleState.COMPLETED;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        if (MediaLifecycleStateManager.g(r131, r113, r132, null, r100, 12) != r110) goto L60;
        return r110;
    L61:
        FLogger.f375446a.i(r112, "Media was deleted from album, re-syncing: " + r113);
        goto L62
    L53:
        if (r129.longValue() == (-1)) goto L62;
    L48:
        if (r128.longValue() != 0) goto L49;
    L62:
        String r133 = r127.getProcessedFilePath();
        if (r133 != null) goto L65;
        r133 = r127.getFilePath();
    L65:
        PolarisFileWrapper r134 = new PolarisFileWrapper(r133);
        if (r134.exists() == true) goto L72;
        FLogger.f375446a.e(r112, "File not found for media " + r113 + ": " + r133);
        MediaLifecycleStateManager r135 = f292555c;
        StringBuilder r136 = new StringBuilder("File not found: ");
        r136.append(r133);
        String r137 = r136.toString();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        if (r135.b(r113, r137, r100) != r110) goto L71;
        return r110;
    L72:
        r111 = r111;
        com.larus.avlink.gallery.e.f292493a.getClass();     // Catch: Exception -> L194
        r105 = "Failed to insert media file: ";
        if (com.larus.avlink.gallery.e.i() == true) goto L202;
        String r138 = r113;
        r116 = r111;
        PolarisFileWrapper r139 = com.larus.avlink.gallery.e.d();     // Catch: Exception -> L178
        r139.mkdirs();     // Catch: Exception -> L178
        final PolarisFileWrapper r140 = new PolarisFileWrapper(r139, e(r127, r134));     // Catch: Exception -> L191
        if (Intrinsics.areEqual(r134.getAbsolutePath(), r140.getAbsolutePath()) == true) goto L132;
        FilesKt.copyTo$default(r134, r140, true, 0, 4, null);     // Catch: Exception -> L191
        FLogger.f375446a.i(r112, "Copied to final directory: " + r140.getAbsolutePath());     // Catch: Exception -> L191
    L133:
        String r141 = ia8.b.f488929a;     // Catch: Exception -> L191
        if (ia8.b.a(AppHost.f326268a.getApplication()) == false) goto L180;
        IDoraService r142 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L191
        if (r142 == null) goto L142;
        VisionService r143 = r142.V();     // Catch: Exception -> L191
        if (r143 == null) goto L142;
        if (r143.q() != true) goto L142;
        boolean r144 = true;
    L143:
        if (r144 == false) goto L180;
        Uri r145 = com.larus.avlink.gallery.c.f(f292554b, r140.getName(), r140.getAbsolutePath(), r127);     // Catch: Exception -> L191
        if (r145 != null) goto L160;
        FLogger.f375446a.e(r112, "Failed to insert media file: " + r140.getName());     // Catch: Exception -> L191
        MediaLifecycleStateManager r146 = f292555c;     // Catch: Exception -> L191
        r100.L$0 = r138;     // Catch: Exception -> L191
        r100.L$1 = null;     // Catch: Exception -> L158
        r100.label = 6;     // Catch: Exception -> L191
        if (r146.b(r138, "Failed to insert to system album", r100) != r110) goto L153;
        return r110;
    L153:
        r115 = r138;
    L158:
        e = e;
    L159:
        r105 = r116;
    L196:
        r113 = r138;
        goto L197
    L160:
        String r147 = r145.getLastPathSegment();     // Catch: Exception -> L191
        if (r147 == null) goto L165;
        Long r148 = StringsKt.toLongOrNull(r147);     // Catch: Exception -> L191
        if (r148 == null) goto L165;
        final long r149 = r148.longValue();     // Catch: Exception -> L191
    L166:
        FLogger.f375446a.i(r112, "Successfully inserted media: uri = " + r145 + ", file = " + r140.getName() + ", systemGalleryId = " + r149);     // Catch: Exception -> L191
        MediaLifecycleStateManager r150 = f292555c;     // Catch: Exception -> L191
        MediaLifecycleState r151 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L191
        Function1 r152 = new f(r149, r140);     // Catch: Exception -> L191
        r100.L$0 = r138;     // Catch: Exception -> L191
        r100.L$1 = null;     // Catch: Exception -> L178
        r100.J$0 = r149;     // Catch: Exception -> L178
        r100.label = 7;     // Catch: Exception -> L178
        r105 = r116;
        if (MediaLifecycleStateManager.g(r150, r138, r151, r152, r100, 8) != r110) goto L173;
        return r110;
    L173:
        long r212 = r149;
        r114 = r138;
        r109 = r212;
    L165:
        r149 = 0;
    L142:
        r144 = false;
    L180:
        r105 = r116;
        MediaLifecycleStateManager r153 = f292555c;     // Catch: Exception -> L189
        MediaLifecycleState r154 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L189
        Function1 r155 = new g(r140);     // Catch: Exception -> L189
        r100.L$0 = r138;     // Catch: Exception -> L189
        r100.L$1 = null;     // Catch: Exception -> L189
        r100.label = 8;     // Catch: Exception -> L189
        if (MediaLifecycleStateManager.g(r153, r138, r154, r155, r100, 8) != r110) goto L184;
        return r110;
    L184:
        r104 = r138;
    L189:
        e = e;
        goto L196
    L132:
        FLogger.f375446a.i(r112, "File already in final directory, skipping copy: " + r140.getAbsolutePath());     // Catch: Exception -> L191
    L191:
        e = e;
        r105 = r116;
        r114 = r138;
    L178:
        e = e;
        goto L159
    L202:
        ContentResolver r156 = f292554b;     // Catch: Exception -> L124
        Uri r157 = com.larus.avlink.gallery.c.f(r156, e(r127, r134), r134.getAbsolutePath(), r127);     // Catch: Exception -> L124
        if (r157 != null) goto L224;
        FLogger.f375446a.e(r112, "Failed to insert media file: " + r134.getName());     // Catch: Exception -> L124
        MediaLifecycleStateManager r158 = f292555c;     // Catch: Exception -> L124
        r100.L$0 = r113;     // Catch: Exception -> L124
        r100.L$1 = null;     // Catch: Exception -> L95
        r100.label = 4;     // Catch: Exception -> L95
        if (r158.b(r113, "Failed to insert to system album", r100) != r110) goto L83;
        return r110;
    L83:
        r125 = r113;
        goto L212
    L224:
        String r159 = r157.getLastPathSegment();     // Catch: Exception -> L122
        if (r159 == null) goto L97;
        Long r160 = StringsKt.toLongOrNull(r159);     // Catch: Exception -> L95
        if (r160 == null) goto L97;
        final long r161 = r160.longValue();     // Catch: Exception -> L95
    L98:
        String r162 = com.larus.avlink.gallery.c.l(r156, r157);     // Catch: Exception -> L122
        if (r162 != null) goto L101;
        FLogger.f375446a.w(r112, "Query public path failed for " + r157 + ", fallback to source path");     // Catch: Exception -> L95
    L101:
        if (r162 != null) goto L105;
        r162 = r134.getAbsolutePath();     // Catch: Exception -> L95
    L105:
        final String r163 = r162;
        MediaLifecycleStateManager r164 = f292555c;     // Catch: Exception -> L122
        MediaLifecycleState r165 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L122
        Function1 r166 = new e(r161, r163);     // Catch: Exception -> L122
        r100.L$0 = r113;     // Catch: Exception -> L122
        r100.L$1 = r163;     // Catch: Exception -> L122
        r100.J$0 = r161;     // Catch: Exception -> L122
        r100.label = 5;     // Catch: Exception -> L122
        long r167 = r161;
        r124 = r111;
        String r168 = r113;
        if (MediaLifecycleStateManager.g(r164, r113, r165, r166, r100, 8) != r110) goto L111;
        return r110;
    L111:
        r120 = r168;
        r122 = r163;
        r123 = r167;
    L119:
        e = e;
    L120:
        r113 = r168;
    L97:
        r161 = 0;
    L122:
        e = e;
        r124 = r111;
        r168 = r113;
    L95:
        e = e;
    L124:
        e = e;
        r105 = r111;
        r114 = r113;
    L194:
        e = e;
        r105 = r111;
        r138 = r113;
        goto L196
    L38:
        ResultKt.throwOnFailure(r102);
        String r169 = r210.getUniqId();
        FLogger.f375446a.i("MediaSyncExecutor", "Syncing media to album: " + r169);
        MediaLifecycleStateManager r170 = f292555c;
        MediaLifecycleState r171 = MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM;
        r100.L$0 = r210;
        r100.L$1 = r169;
        r100.label = 1;
        if (MediaLifecycleStateManager.g(r170, r169, r171, null, r100, 12) != r110) goto L41;
        return r110;
    L41:
        r127 = r210;
        r113 = r169;
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L32:
        e = e;
        r114 = "Successfully inserted media: uri = ";
    L7:
        r100 = new MediaSyncExecutor$syncToAlbum$1(this, r211);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01ba -> B:56:0x01c0). Please report as a decompilation issue!!! */
    public static final Object a(MediaSyncExecutor r110, List r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MediaSyncExecutor$checkAllDeletedMedia$1) == false) goto L7;
        MediaSyncExecutor$checkAllDeletedMedia$1 r100 = (MediaSyncExecutor$checkAllDeletedMedia$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L18;
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L16;
        if (r102 != 3) goto L15;
        List r115 = (List) r100.L$2;
        List r116 = (List) r100.L$1;
        List r103 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L68:
        com.larus.avlink.gallery.business.a.a(r115, r116, "system_album_full_check");
        FLogger.f375446a.i("MediaSyncExecutor", "Full check completed: " + r103.size() + " files, " + r115.size() + " metadata records deleted");
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r117 = (String) r100.L$5;
        MediaMetadata r104 = (MediaMetadata) r100.L$4;
        Iterator r105 = (Iterator) r100.L$3;
        List r106 = (List) r100.L$2;
        List r107 = (List) r100.L$1;
        List r108 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L56:
        o r118 = (o) r113;
        if (r118.f558696a <= 0) goto L59;
        r108.add(new PolarisFileWrapper(r117));
    L59:
        FLogger.f375446a.i("MediaSyncExecutor", "cleanup deleted media result=" + r118 + ", uniqId=" + r104.getUniqId());
        Object r119 = r114;
        r116 = r106;
        r111 = r108;
    L51:
        if (r105.hasNext() == false) goto L60;
        r104 = (MediaMetadata) r105.next();
        String r109 = r104.getCurrentFilePath();
        r116.add(r109);
        GalleryStoragePolicyManager r120 = GalleryStoragePolicyManager.f292721a;
        r100.L$0 = r111;
        r100.L$1 = r107;
        r100.L$2 = r116;
        r100.L$3 = r105;
        r100.L$4 = r104;
        r100.L$5 = r109;
        r100.label = 2;
        r120.getClass();
        Object r121 = GalleryStoragePolicyManager.h(r104, "system_album_delete", r100);
        if (r121 == r119) goto L87;
        List r122 = r116;
        r114 = r119;
        r113 = r121;
        r108 = r111;
        r117 = r109;
        r106 = r122;
    L87:
        return r119;
    L60:
        List r123 = r107;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator r125 = r123.iterator();
    L62:
        if (r125.hasNext() == false) goto L64;
        r124.add(((MediaMetadata) r125.next()).getUniqId());
        goto L62
    L64:
        AlbumDataBaseHelper r126 = AlbumDataBaseHelper.f292393a;
        r100.L$0 = r111;
        r100.L$1 = r116;
        r100.L$2 = r124;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 3;
        if (r126.e(r124, r100) == r119) goto L87;
        r103 = r111;
        r115 = r124;
        goto L68
    L17:
        r111 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L21:
        List r127 = (List) r113;
        FLogger.f375446a.i("MediaSyncExecutor", "=== Full Delete Check Started: " + r127.size() + " completed media ===");
        ArrayList r128 = new ArrayList();
        Iterator r129 = r127.iterator();
    L23:
        if (r129.hasNext() == false) goto L33;
        Object r130 = r129.next();
        Long r131 = ((MediaMetadata) r130).getSystemGalleryId();
        if (r131 != null) goto L27;
    L29:
        boolean r132 = false;
    L30:
        if (r132 == false) goto L23;
        r128.add(r130);
        goto L23
    L27:
        if (r131.longValue() <= 0) goto L29;
        r132 = true;
        goto L30
    L33:
        if (r128.isEmpty() == false) goto L35;
        FLogger.f375446a.i("MediaSyncExecutor", "No valid media to check");
        return Unit.INSTANCE;
    L35:
        FLogger.f375446a.d("MediaSyncExecutor", "Checking " + r128.size() + " valid media");
        ArrayList r133 = new ArrayList();
        Iterator r134 = r128.iterator();
    L37:
        if (r134.hasNext() == false) goto L47;
        MediaMetadata r135 = (MediaMetadata) r134.next();
        Long r136 = r135.getSystemGalleryId();
        if (r136 == null) goto L37;
        String r137 = r136.toString();
        if (r137 == null) goto L37;
        if (com.larus.avlink.gallery.c.j(f292554b, r137) == true) goto L37;
        r133.add(r135);
        FLogger.f375446a.d("MediaSyncExecutor", "✗ Media " + r135.getUniqId() + " (systemGalleryId: " + r137 + ") no longer in Doubao album");
        goto L37
    L47:
        if (r133.isEmpty() == false) goto L49;
        FLogger.f375446a.i("MediaSyncExecutor", "All media still exist in album");
        return Unit.INSTANCE;
    L49:
        FLogger.f375446a.i("MediaSyncExecutor", "Found " + r133.size() + " deleted media, removing local files");
        ArrayList r138 = new ArrayList();
        r105 = r133.iterator();
        r107 = r133;
        r119 = r114;
        r116 = r138;
        goto L51
    L18:
        ResultKt.throwOnFailure(r113);
        AlbumDataBaseHelper r139 = AlbumDataBaseHelper.f292393a;
        MediaLifecycleState r140 = MediaLifecycleState.COMPLETED;
        r100.L$0 = r111;
        r100.label = 1;
        r113 = r139.s(r140, r100);
        if (r113 != r114) goto L21;
        return r114;
    L7:
        r100 = new MediaSyncExecutor$checkAllDeletedMedia$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01e4 -> B:66:0x01ea). Please report as a decompilation issue!!! */
    public static final Object b(MediaSyncExecutor r110, List r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MediaSyncExecutor$checkAndDeleteBatch$1) == false) goto L7;
        MediaSyncExecutor$checkAndDeleteBatch$1 r100 = (MediaSyncExecutor$checkAndDeleteBatch$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        List r105 = (List) r100.L$2;
        List r106 = (List) r100.L$1;
        List r107 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L78:
        com.larus.avlink.gallery.business.a.a(r105, r106, "system_album_incremental");
        FLogger.f375446a.i("MediaSyncExecutor", "Batch delete completed: " + r107.size() + " files, " + r105.size() + " metadata records");
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r108 = (String) r100.L$5;
        MediaMetadata r109 = (MediaMetadata) r100.L$4;
        Iterator r113 = (Iterator) r100.L$3;
        List r114 = (List) r100.L$2;
        List r115 = (List) r100.L$1;
        List r116 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L66:
        o r117 = (o) r102;
        if (r117.f558696a <= 0) goto L69;
        r115.add(new PolarisFileWrapper(r108));
    L69:
        FLogger.f375446a.i("MediaSyncExecutor", "cleanup deleted media result=" + r117 + ", uniqId=" + r109.getUniqId());
        r106 = r114;
    L61:
        if (r113.hasNext() == false) goto L70;
        r109 = (MediaMetadata) r113.next();
        String r118 = r109.getCurrentFilePath();
        r106.add(r118);
        GalleryStoragePolicyManager r119 = GalleryStoragePolicyManager.f292721a;
        r100.L$0 = r116;
        r100.L$1 = r115;
        r100.L$2 = r106;
        r100.L$3 = r113;
        r100.L$4 = r109;
        r100.L$5 = r118;
        r100.label = 2;
        r119.getClass();
        Object r120 = GalleryStoragePolicyManager.h(r109, "system_album_delete", r100);
        if (r120 == r103) goto L100;
        List r121 = r106;
        r108 = r118;
        r102 = r120;
        r114 = r121;
        goto L66
    L100:
        return r103;
    L70:
        List r122 = r116;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L72:
        if (r124.hasNext() == false) goto L74;
        r123.add(((MediaMetadata) r124.next()).getUniqId());
        goto L72
    L74:
        AlbumDataBaseHelper r125 = AlbumDataBaseHelper.f292393a;
        r100.L$0 = r115;
        r100.L$1 = r106;
        r100.L$2 = r123;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 3;
        if (r125.e(r123, r100) == r103) goto L101;
        r105 = r123;
        r107 = r115;
        goto L78
    L101:
        return r103;
    L17:
        ResultKt.throwOnFailure(r102);
    L43:
        List r126 = (List) r102;
        FLogger.f375446a.d("MediaSyncExecutor", "Found " + r126.size() + " metadata records");
        if (r126.isEmpty() == true) goto L97;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L48:
        if (r128.hasNext() == false) goto L57;
        MediaMetadata r129 = (MediaMetadata) r128.next();
        Long r130 = r129.getSystemGalleryId();
        if (r130 == null) goto L48;
        if (r130.longValue() <= 0) goto L48;
        if (com.larus.avlink.gallery.c.j(f292554b, r130.toString()) == true) goto L48;
        r127.add(r129);
        FLogger.f375446a.d("MediaSyncExecutor", "✗ Media " + r129.getUniqId() + " no longer in Doubao album (deleted or moved out)");
        goto L48
    L57:
        if (r127.isEmpty() == false) goto L59;
        FLogger.f375446a.d("MediaSyncExecutor", "All media still exist in album");
        return CollectionsKt.emptyList();
    L59:
        FLogger.f375446a.i("MediaSyncExecutor", "Deleting " + r127.size() + " media files and metadata");
        ArrayList r131 = new ArrayList();
        ArrayList r132 = new ArrayList();
        r113 = r127.iterator();
        r115 = r131;
        r116 = r127;
        r106 = r132;
        goto L61
    L97:
        return CollectionsKt.emptyList();
    L18:
        ResultKt.throwOnFailure(r102);
        if (r111.isEmpty() == true) goto L95;
        ArrayList r133 = new ArrayList();
        Iterator r134 = r111.iterator();
    L23:
        if (r134.hasNext() == false) goto L38;
        String r135 = ((Uri) r134.next()).getLastPathSegment();
        if (r135 == null) goto L34;
        Long r136 = StringsKt.toLongOrNull(r135);
        if (r136 == null) goto L34;
        if (r136.longValue() <= 0) goto L31;
        boolean r137 = true;
    L32:
        if (r137 == false) goto L34;
    L35:
        if (r136 == null) goto L23;
        r133.add(r136);
        goto L23
    L31:
        r137 = false;
    L34:
        r136 = null;
        goto L35
    L38:
        if (r133.isEmpty() == false) goto L40;
        FLogger.f375446a.w("MediaSyncExecutor", "No valid systemGalleryIds found in URIs");
        return CollectionsKt.emptyList();
    L40:
        FLogger.f375446a.d("MediaSyncExecutor", "Batch checking " + r133.size() + " gallery IDs");
        AlbumDataBaseHelper r138 = AlbumDataBaseHelper.f292393a;
        r100.label = 1;
        r102 = r138.v(r133, r100);
        if (r102 != r103) goto L43;
        return r103;
    L95:
        return CollectionsKt.emptyList();
    L7:
        r100 = new MediaSyncExecutor$checkAndDeleteBatch$1(r110, r112);
        goto L8
    }
}
