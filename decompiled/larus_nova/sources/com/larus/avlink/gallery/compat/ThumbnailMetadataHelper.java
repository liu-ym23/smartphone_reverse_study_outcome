package com.larus.avlink.gallery.compat;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.polaris.PolarisFile;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.g;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.service.l1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class ThumbnailMetadataHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThumbnailMetadataHelper f292369a = null;

    static {
        f292369a = new ThumbnailMetadataHelper();
    }

    public ThumbnailMetadataHelper() {
    }

    public final Object c(List<Long> r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ThumbnailMetadataHelper$deleteBatchThumbnailData$1) == false) goto L7;
        ThumbnailMetadataHelper$deleteBatchThumbnailData$1 r100 = (ThumbnailMetadataHelper$deleteBatchThumbnailData$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        r110 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L53
    L51:
        FLogger.f375446a.i("ThumbnailMetadataHelper", "Batch deleted " + r110.size() + " thumbnail data");     // Catch: Exception -> L53
    L56:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r114 = (String) r100.L$2;
        r111 = (String) r100.L$1;
        List<Long> r104 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L53
        String r115 = r114;
        r110 = r104;
        Object r105 = r113;
    L24:
        Iterable r106 = (Iterable) r105;     // Catch: Exception -> L53
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: Exception -> L53
        Iterator r108 = r106.iterator();     // Catch: Exception -> L53
    L26:
        if (r108.hasNext() == false) goto L28;
        r107.add(((ThumbnailMetadata) r108.next()).getFilePath());     // Catch: Exception -> L53
        goto L26
    L28:
        Iterator r109 = r107.iterator();     // Catch: Exception -> L53
    L30:
        if (r109.hasNext() == false) goto L48;
        String r116 = (String) r109.next();     // Catch: Exception -> L53
        if (r116 == null) goto L39;
    L34:
        if (r116.length() == 0) goto L39;
        boolean r117 = false;
    L40:
        if (r117 == true) goto L30;
        Intrinsics.checkNotNull(r115);     // Catch: Exception -> L37
        File r118 = PolarisFile.getSafeFileOrNullUnderAllowedFolder(r116, r115);     // Catch: Exception -> L37
        if (r118 == null) goto L30;
        if (r118.exists() == false) goto L30;
        r118.delete();     // Catch: Exception -> L37
        FLogger.f375446a.i("ThumbnailMetadataHelper", "Deleted thumbnail file: " + r116);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailMetadataHelper", "Error deleting thumbnail file: " + r116 + ", " + e.getMessage());     // Catch: Exception -> L53
    L39:
        r117 = true;
        goto L40
    L48:
        AlbumDataBaseHelper r119 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L53
        r100.L$0 = r110;     // Catch: Exception -> L53
        r100.L$1 = null;     // Catch: Exception -> L53
        r100.L$2 = null;     // Catch: Exception -> L53
        r100.label = 2;     // Catch: Exception -> L53
        if (r119.g(r110, r111, r100) != r102) goto L51;
        return r102;
    L20:
        ResultKt.throwOnFailure(r113);
        r115 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath();
        AlbumDataBaseHelper r120 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L53
        r100.L$0 = r110;     // Catch: Exception -> L53
        r100.L$1 = r111;     // Catch: Exception -> L53
        r100.L$2 = r115;     // Catch: Exception -> L53
        r100.label = 1;     // Catch: Exception -> L53
        r105 = r120.x(r110, r111, r100);     // Catch: Exception -> L53
        if (r105 != r102) goto L24;
        return r102;
    L53:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailMetadataHelper", "Error batch deleting thumbnail data: " + e.getMessage(), e);
    L7:
        r100 = new ThumbnailMetadataHelper$deleteBatchThumbnailData$1(this, r112);
        goto L8
    }

    public final Object d(long r100, String r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ThumbnailMetadataHelper$deleteThumbnailData$1) == false) goto L7;
        ThumbnailMetadataHelper$deleteThumbnailData$1 r101 = (ThumbnailMetadataHelper$deleteThumbnailData$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        r100 = r101.J$0;
        r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L31
    L20:
        if (r110 != null) goto L22;
    L25:
        if (r105 == true) goto L29;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r110);     // Catch: Exception -> L31
        if (r114.exists() == false) goto L29;
        r114.delete();     // Catch: Exception -> L31
        FLogger.f375446a.i("ThumbnailMetadataHelper", "Deleted thumbnail file: " + r110);     // Catch: Exception -> L31
    L29:
        FLogger.f375446a.i("ThumbnailMetadataHelper", "Deleted thumbnail data for imageUuid: " + r100);     // Catch: Exception -> L31
    L34:
        return Unit.INSTANCE;
    L22:
        if (r110.length() == 0) goto L25;
        r105 = false;
        goto L25
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r113);
        AlbumDataBaseHelper r115 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L31
        r101.L$0 = r110;     // Catch: Exception -> L31
        r101.J$0 = r100;     // Catch: Exception -> L31
        r101.label = 1;     // Catch: Exception -> L31
        if (r115.f(r100, r111, r101) != r103) goto L20;
        return r103;
    L31:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailMetadataHelper", "Error deleting thumbnail data: " + e.getMessage(), e);
    L7:
        r101 = new ThumbnailMetadataHelper$deleteThumbnailData$1(this, r112);
        goto L8
    }

    public static ThumbnailMetadata b(String r210, long r211, String r212, int r310, int r311, long r312, long r313) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r210);
        long r110 = System.currentTimeMillis();
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        int r102 = 0;
        if (r101 == null) goto L9;
        VisionService r103 = r101.V();
        if (r103 == null) goto L9;
        if (r103.p() != true) goto L9;
        int r104 = 1;
    L10:
        boolean r105 = g.a();
        if (r104 == 0) goto L14;
        if (r105 == false) goto L14;
        boolean r106 = true;
    L15:
        FLogger.f375446a.i("ThumbnailMetadataHelper", "createThumbnailMetadataObject isRecordLocationEnabled: " + r106);
        if (r106 == false) goto L18;
        GeoLocationInfo r107 = l1.f365760a.e(r313);
    L19:
        GeoLocationInfo r213 = r107;
        GalleryMobHelper.f293006a.getClass();
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("has_auth", Integer.valueOf(r105 ? 1 : 0));
        r108.put("switch_open", Integer.valueOf(r104));
        r108.put("time_out", 0);
        r108.put("success", 1);
        if (r213 == null) goto L29;
        String r109 = r213.getPoi();
        if (r109 == null) goto L29;
        if (r109.length() <= 0) goto L26;
        boolean r111 = true;
    L27:
        if (r111 != true) goto L29;
        r102 = 1;
        goto L29
    L26:
        r111 = false;
    L29:
        r108.put("has_poi", Integer.valueOf(r102));
        GalleryMobHelper.i("dora_album_location_save", r108);
        String r112 = UUID.randomUUID().toString();
        String r113 = r100.getName();
        long r114 = r100.length();
        IDoraService r115 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r115 == null) goto L34;
        DeviceService r116 = r115.device();
        if (r116 == null) goto L34;
        String r117 = r116.m();
    L36:
        return new ThumbnailMetadata(r112, r210, r113, r114, r117, r211, r212, r310, r311, r312, r313, r110, r110, r213, DocCallbackImpl.KEY_THUMBNAIL, 0, false);
    L34:
        r117 = "";
        goto L36
    L18:
        r107 = null;
    L14:
        r106 = false;
    L9:
        r104 = 0;
        goto L10
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Object a(String r210, long r211, String r212, int r213, int r214, long r215, long r216, Continuation r310) {
        long r110 = r211;
        String r111 = "Created thumbnail metadata: fileId=";
        if ((r310 instanceof ThumbnailMetadataHelper$createThumbnailMetadata$1) == false) goto L7;
        ThumbnailMetadataHelper$createThumbnailMetadata$1 r100 = (ThumbnailMetadataHelper$createThumbnailMetadata$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ThumbnailMetadataHelper$createThumbnailMetadata$1 r102 = r100;
        Object r103 = r102.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 != 0) goto L55;
        ResultKt.throwOnFailure(r103);
        if (r210 != null) goto L28;
        String r105 = "";
    L29:
        String r113 = "ThumbnailMetadataHelper";
        ThumbnailMetadata r106 = b(r105, r211, r212, r213, r214, r215, r216);     // Catch: Exception -> L48
        AlbumDataBaseHelper r107 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L45
        String r108 = r106.getSn();     // Catch: Exception -> L45
        r102.L$0 = r106;     // Catch: Exception -> L45
        r102.J$0 = r110;     // Catch: Exception -> L45
        r102.label = 1;     // Catch: Exception -> L45
        Object r109 = r107.w(r110, r108, r102);     // Catch: Exception -> L45
        Object r114 = r112;
        if (r109 != r114) goto L34;
        return r114;
    L34:
        ThumbnailMetadata r115 = r106;
        r103 = r109;
    L36:
        if (((ThumbnailMetadata) r103) == null) goto L39;
        FLogger.f375446a.i(r113, "createThumbnailMetadata: metadata already exists, imageUuid=" + r110 + ", sn=" + r115.getSn());     // Catch: Exception -> L45
        return Unit.INSTANCE;
    L39:
        AlbumDataBaseHelper r116 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L45
        r102.L$0 = r115;     // Catch: Exception -> L45
        r102.J$0 = r110;     // Catch: Exception -> L45
        r102.label = 2;     // Catch: Exception -> L45
        if (r116.j(r115, r102) != r114) goto L42;
        return r114;
    L42:
        ThumbnailMetadata r117 = r115;
        long r118 = r110;
    L43:
        FLogger.f375446a.i(r113, r111 + r117.getFileId() + ", imageUuid=" + r118);     // Catch: Exception -> L45
    L51:
        return Unit.INSTANCE;
    L45:
        e = e;
    L46:
        FLogger.f375446a.e(r113, "Error creating thumbnail metadata: " + e.getMessage(), e);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        FLogger.f375446a.e(r113, "Error creating thumbnail metadata process: " + e.getMessage(), e);
        goto L51
    L28:
        r105 = r210;
        goto L29
    L55:
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        r118 = r102.J$0;
        r117 = (ThumbnailMetadata) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L20
        r111 = "Created thumbnail metadata: fileId=";
        r113 = "ThumbnailMetadataHelper";
        goto L43
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r119 = r102.J$0;
        r115 = (ThumbnailMetadata) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L20
        r110 = r119;
        r114 = r112;
        r113 = "ThumbnailMetadataHelper";
    L20:
        e = e;
        r113 = "ThumbnailMetadataHelper";
    L7:
        r100 = new ThumbnailMetadataHelper$createThumbnailMetadata$1(this, r310);
        goto L8
    }

    public final Object e(String r210, long r211, String r212, int r213, int r214, long r215, long r216, Continuation r310) {
        if ((r310 instanceof ThumbnailMetadataHelper$updateThumbnailMetadata$1) == false) goto L7;
        ThumbnailMetadataHelper$updateThumbnailMetadata$1 r100 = (ThumbnailMetadataHelper$updateThumbnailMetadata$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        long r105 = r100.J$0;
        ThumbnailMetadata r106 = (ThumbnailMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
    L29:
        FLogger.f375446a.i("ThumbnailMetadataHelper", "Updated thumbnail metadata: fileId=" + r106.getFileId() + ", imageUuid=" + r105);     // Catch: Exception -> L14
    L35:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        if (r210 != null) goto L23;
        String r107 = "";
    L24:
        ThumbnailMetadata r108 = b(r107, r211, r212, r213, r214, r215, r216);     // Catch: Exception -> L21
        AlbumDataBaseHelper r109 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L14
        r100.L$0 = r108;     // Catch: Exception -> L14
        r100.J$0 = r211;     // Catch: Exception -> L14
        r100.label = 1;     // Catch: Exception -> L14
        if (r109.B(r108, r100) != r103) goto L28;
        return r103;
    L28:
        r106 = r108;
        r105 = r211;
        goto L29
    L23:
        r107 = r210;
    L21:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailMetadataHelper", "Error updating thumbnail metadata process: " + e.getMessage(), e);
    L14:
        e = move-exception;
        FLogger.f375446a.e("ThumbnailMetadataHelper", "Error updating thumbnail metadata: " + e.getMessage(), e);     // Catch: Exception -> L21
    L7:
        r100 = new ThumbnailMetadataHelper$updateThumbnailMetadata$1(this, r310);
        goto L8
    }
}
