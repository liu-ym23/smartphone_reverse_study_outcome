package com.larus.avlink.gallery.database;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.dora.api.IDoraService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class AlbumDataBaseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AlbumDataBaseHelper f292393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f292394b = null;

    public AlbumDataBaseHelper() {
    }

    static {
        f292393a = new AlbumDataBaseHelper();
        f292394b = new Gson();
    }

    public static void A(MediaMetadata r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaMetadata");
        long r100 = System.currentTimeMillis();
        int r101 = AlbumDatabase.f292395a.a().c().a(k(r110));     // Catch: Exception -> L9
        FLogger.f375446a.i("AlbumDataBaseHelper", "updateMediaDataSync: uniqId=" + r110.getUniqId() + ", mediaId=" + r110.getMediaId() + ", rows=" + r101);     // Catch: Exception -> L9
        long r102 = System.currentTimeMillis() - r100;     // Catch: Exception -> L9
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L9
        if (GalleryStoragePolicyManager.m() == false) goto L6;
        int r111 = 1;
    L7:
        l("update", "album", 1, r102, 1, r111, "");     // Catch: Exception -> L9
        return;
    L6:
        r111 = 0;
    L9:
        e = move-exception;
        FLogger.f375446a.e("AlbumDataBaseHelper", "updateMediaDataSync: " + e.getMessage(), e);
        long r103 = System.currentTimeMillis() - r100;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r112 = GalleryStoragePolicyManager.m();
        String r113 = e.getMessage();
        if (r113 != null) goto L13;
        r113 = "";
    L13:
        l("update", "album", 1, r103, 0, r112 ? 1 : 0, r113);
    }

    public static a k(MediaMetadata r310) {
        String r100 = r310.getUniqId();
        long r101 = r310.getMediaId();
        Long r102 = r310.getSystemGalleryId();
        String r103 = r310.getFileName();
        Long r104 = r310.getFileSize();
        String r105 = r310.getMediaType();
        int r106 = r310.getWidth();
        int r107 = r310.getHeight();
        long r110 = r310.getDuration();
        int r111 = r310.getOutVideoWidth();
        int r112 = r310.getOutVideoHeight();
        double r113 = r310.getOutputVideoCrop();
        long r114 = r310.getCreateTime();
        GeoLocationInfo r108 = r310.getGeoLocationInfo();
        if (r108 == null) goto L5;
        String r210 = GsonProtectorUtils.toJson(f292394b, r108);
    L6:
        String r311 = r310.getAlgorithmType();
        int r312 = r310.getLifecycleState().getValue();
        MediaLifecycleState r109 = r310.getFailureStage();
        if (r109 == null) goto L9;
        Integer r313 = Integer.valueOf(r109.getValue());
    L11:
        return new a(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r210, r311, r312, r313, r310.getFailureReason(), r310.getDownloadFilePath(), r310.getTempFilePath(), r310.getUnpackDirPath(), r310.getProcessedFilePath(), r310.getFinalFilePath(), r310.getActiveMask());
    L9:
        r313 = null;
        goto L11
    L5:
        r210 = null;
        goto L6
    }

    public final Object m(Continuation<? super List<MediaMetadata>> r210) {
        if ((r210 instanceof AlbumDataBaseHelper$selectAllMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$selectAllMediaData$1 r100 = (AlbumDataBaseHelper$selectAllMediaData$1) r210;
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
        int r106 = r100.I$0;
        String r110 = (String) r100.L$2;
        String r111 = (String) r100.L$1;
        AlbumDataBaseHelper r107 = (AlbumDataBaseHelper) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r112 = r110;
        String r113 = r111;
    L46:
        List r108 = (List) r102;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectAllMediaData: result=" + r108);     // Catch: Exception -> L33
        List r109 = r108;     // Catch: Exception -> L33
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L33
        Iterator r115 = r109.iterator();     // Catch: Exception -> L33
    L25:
        if (r115.hasNext() == false) goto L27;
        r114.add(a(f292393a, (a) r115.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r116 = r114.size();     // Catch: Exception -> L33
        long r117 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r107.getClass();     // Catch: Exception -> L33
        l(r113, r112, r116, r117, 1, r118, "");     // Catch: Exception -> L33
    L41:
        if (r114 == null) goto L43;
        return r114;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r118 = 0;
    L33:
        e = e;
        int r119 = r106;
        r110 = r112;
        String r120 = r113;
    L37:
        long r121 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r107.getClass();
        l(r120, r110, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r114 = null;
    L14:
        e = e;
        r119 = r106;
        r120 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "album";
        long r124 = System.currentTimeMillis();
        b r125 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r100.L$0 = this;     // Catch: Exception -> L35
        r100.L$1 = "batch_load";     // Catch: Exception -> L35
        r100.L$2 = "album";     // Catch: Exception -> L35
        r100.I$0 = 0;     // Catch: Exception -> L35
        r100.J$0 = r124;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r125.h(r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r107 = this;
        r112 = "album";
        r113 = "batch_load";
        r105 = r124;
        r106 = 0;
    L35:
        e = e;
        r107 = this;
        r120 = "batch_load";
        r105 = r124;
        r119 = 0;
    L7:
        r100 = new AlbumDataBaseHelper$selectAllMediaData$1(this, r210);
        goto L8
    }

    public final Object n(Continuation<? super List<ThumbnailMetadata>> r210) {
        if ((r210 instanceof AlbumDataBaseHelper$selectAllThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$selectAllThumbnailData$1 r100 = (AlbumDataBaseHelper$selectAllThumbnailData$1) r210;
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
        int r106 = r100.I$0;
        String r110 = (String) r100.L$2;
        String r111 = (String) r100.L$1;
        AlbumDataBaseHelper r107 = (AlbumDataBaseHelper) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r112 = r110;
        String r113 = r111;
    L46:
        List r108 = (List) r102;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectAllThumbnailData: result=" + r108);     // Catch: Exception -> L33
        List r109 = r108;     // Catch: Exception -> L33
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L33
        Iterator r115 = r109.iterator();     // Catch: Exception -> L33
    L25:
        if (r115.hasNext() == false) goto L27;
        r114.add(b(f292393a, (i) r115.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r116 = r114.size();     // Catch: Exception -> L33
        long r117 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r107.getClass();     // Catch: Exception -> L33
        l(r113, r112, r116, r117, 1, r118, "");     // Catch: Exception -> L33
    L41:
        if (r114 == null) goto L43;
        return r114;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r118 = 0;
    L33:
        e = e;
        int r119 = r106;
        r110 = r112;
        String r120 = r113;
    L37:
        long r121 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r107.getClass();
        l(r120, r110, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r114 = null;
    L14:
        e = e;
        r119 = r106;
        r120 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "album_thumbnail";
        long r124 = System.currentTimeMillis();
        j r125 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L35
        r100.L$0 = this;     // Catch: Exception -> L35
        r100.L$1 = "batch_load";     // Catch: Exception -> L35
        r100.L$2 = "album_thumbnail";     // Catch: Exception -> L35
        r100.I$0 = 0;     // Catch: Exception -> L35
        r100.J$0 = r124;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r125.f(r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r107 = this;
        r112 = "album_thumbnail";
        r113 = "batch_load";
        r105 = r124;
        r106 = 0;
    L35:
        e = e;
        r107 = this;
        r120 = "batch_load";
        r105 = r124;
        r119 = 0;
    L7:
        r100 = new AlbumDataBaseHelper$selectAllThumbnailData$1(this, r210);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object q(Continuation<? super Integer> r210) {
        if ((r210 instanceof AlbumDataBaseHelper$selectMediaDataCount$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataCount$1 r100 = (AlbumDataBaseHelper$selectMediaDataCount$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 0;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        long r106 = r100.J$0;
        int r107 = r100.I$0;
        String r110 = (String) r100.L$2;
        String r111 = (String) r100.L$1;
        AlbumDataBaseHelper r108 = (AlbumDataBaseHelper) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r112 = r110;
        String r113 = r111;
    L49:
        int r109 = ((Number) r102).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataCount: count=" + r109);     // Catch: Exception -> L33
        Comparable r114 = Boxing.boxInt(r109);     // Catch: Exception -> L33
        if ((r114 instanceof List) == false) goto L26;
        int r115 = ((List) r114).size();     // Catch: Exception -> L33
    L27:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r117 = 1;
    L31:
        r108.getClass();     // Catch: Exception -> L33
        l(r113, r112, r115, r116, 1, r117, "");     // Catch: Exception -> L33
        Integer r118 = r114;
    L41:
        if (r118 == 0) goto L44;
        r105 = r118.intValue();
    L44:
        return Boxing.boxInt(r105);
    L30:
        r117 = 0;
        goto L31
    L26:
        r115 = r107;
    L33:
        e = e;
        int r119 = r107;
        r110 = r112;
        String r120 = r113;
    L37:
        long r121 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r108.getClass();
        l(r120, r110, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r118 = 0;
    L14:
        e = e;
        r119 = r107;
        r120 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "album";
        long r124 = System.currentTimeMillis();
        b r125 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r100.L$0 = this;     // Catch: Exception -> L35
        r100.L$1 = "get_one";     // Catch: Exception -> L35
        r100.L$2 = "album";     // Catch: Exception -> L35
        r100.I$0 = 0;     // Catch: Exception -> L35
        r100.J$0 = r124;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r125.f(r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r108 = this;
        r112 = "album";
        r113 = "get_one";
        r106 = r124;
        r107 = 0;
    L35:
        e = e;
        r108 = this;
        r120 = "get_one";
        r106 = r124;
        r119 = 0;
    L7:
        r100 = new AlbumDataBaseHelper$selectMediaDataCount$1(this, r210);
        goto L8
    }

    public static final MediaMetadata a(AlbumDataBaseHelper r310, a r311) {
        r310.getClass();
        String r100 = r311.f292401a;
        long r101 = r311.f292402b;
        Long r102 = r311.f292403c;
        String r103 = r311.f292404d;
        Long r104 = r311.f292405e;
        String r105 = r311.f292406f;
        int r106 = r311.f292407g;
        int r110 = r311.f292408h;
        long r111 = r311.f292409i;
        int r112 = r311.f292410j;
        int r113 = r311.f292411k;
        double r114 = r311.f292412l;
        long r115 = r311.f292413m;
        String r107 = r311.f292414n;
        MediaLifecycleState r116 = null;
        if (r107 != null) goto L5;
    L10:
        GeoLocationInfo r312 = null;
    L11:
        String r117 = r311.f292415o;
        MediaLifecycleState.a r108 = MediaLifecycleState.Companion;
        int r118 = r311.f292416p;
        r108.getClass();
        MediaLifecycleState[] r109 = MediaLifecycleState.values();
        int r119 = r109.length;
        int r120 = 0;
    L12:
        if (r120 >= r119) goto L20;
        MediaLifecycleState r210 = r109[r120];
        MediaLifecycleState[] r211 = r109;
        if (r210.getValue() != r118) goto L16;
        boolean r121 = true;
    L17:
        if (r121 == true) goto L21;
        r120 = r120 + 1;
        r109 = r211;
    L21:
        if (r210 != null) goto L23;
        MediaLifecycleState r313 = MediaLifecycleState.FAILED;
    L24:
        Integer r122 = r311.f292417q;
        if (r122 == null) goto L36;
        int r123 = r122.intValue();
        MediaLifecycleState[] r124 = MediaLifecycleState.values();
        int r125 = r124.length;
        int r126 = 0;
    L27:
        if (r126 >= r125) goto L36;
        MediaLifecycleState r212 = r124[r126];
        MediaLifecycleState[] r213 = r124;
        if (r212.getValue() != r123) goto L31;
        boolean r127 = true;
    L32:
        if (r127 == true) goto L33;
        r126 = r126 + 1;
        r124 = r213;
        goto L27
    L33:
        r116 = r212;
        goto L36
    L31:
        r127 = false;
    L36:
        return new MediaMetadata(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r312, r117, r313, r116, r311.f292418r, r311.f292419s, r311.f292420t, r311.f292421u, r311.f292422v, r311.f292423w, r311.f292424x);
    L23:
        r313 = r210;
        goto L24
    L16:
        r121 = false;
        goto L17
    L20:
        r210 = null;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r107)) == true) goto L8;
        r107 = null;
    L8:
        if (r107 == null) goto L10;
        r312 = (GeoLocationInfo) GsonProtectorUtils.fromJson(f292394b, r107, GeoLocationInfo.class);
        goto L11
    }

    public static final ThumbnailMetadata b(AlbumDataBaseHelper r210, i r211) {
        r210.getClass();
        String r100 = r211.f292456a;
        String r101 = r211.f292457b;
        String r102 = r211.f292458c;
        long r103 = r211.f292459d;
        String r104 = r211.f292460e;
        long r105 = r211.f292461f;
        String r110 = r211.f292462g;
        int r111 = r211.f292463h;
        int r112 = r211.f292464i;
        long r113 = r211.f292465j;
        long r114 = r211.f292466k;
        long r115 = r211.f292467l;
        long r116 = r211.f292468m;
        String r106 = r211.f292469n;
        GeoLocationInfo r212 = null;
        if (r106 == null) goto L12;
        if ((!StringsKt.isBlank(r106)) == true) goto L8;
        r106 = null;
    L8:
        if (r106 == null) goto L12;
        r212 = (GeoLocationInfo) GsonProtectorUtils.fromJson(f292394b, r106, GeoLocationInfo.class);
    L12:
        return new ThumbnailMetadata(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r212, r211.f292470o, r211.f292471p, r211.f292472q);
    }

    public static final i c(AlbumDataBaseHelper r210, ThumbnailMetadata r211) {
        r210.getClass();
        String r100 = r211.getFileId();
        String r101 = r211.getFilePath();
        String r102 = r211.getFileName();
        long r103 = r211.getFileSize();
        String r104 = r211.getSn();
        long r105 = r211.getImageUuid();
        String r106 = r211.getMediaType();
        int r110 = r211.getWidth();
        int r111 = r211.getHeight();
        long r112 = r211.getDuration();
        long r113 = r211.getCreateTime();
        long r114 = r211.getModifyTime();
        long r115 = r211.getDownloadTime();
        GeoLocationInfo r107 = r211.getGeoLocationInfo();
        if (r107 == null) goto L5;
        String r108 = GsonProtectorUtils.toJson(f292394b, r107);
    L7:
        return new i(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r108, r211.getSourceType(), r211.getProcessingStatus(), r211.isSynced());
    L5:
        r108 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object B(ThumbnailMetadata r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof AlbumDataBaseHelper$updateThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$updateThumbnailData$1 r100 = (AlbumDataBaseHelper$updateThumbnailData$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r110 = "album_thumbnail";
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        long r105 = r100.J$0;
        int r106 = r100.I$0;
        r110 = (String) r100.L$3;
        String r111 = (String) r100.L$2;
        AlbumDataBaseHelper r107 = (AlbumDataBaseHelper) r100.L$1;
        ThumbnailMetadata r108 = (ThumbnailMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L15
        String r109 = ", sn=";
        String r112 = "";
    L92:
        int r113 = ((Number) r102).intValue();     // Catch: Exception -> L81
        FLogger.f375446a.i("AlbumDataBaseHelper", "updateThumbnailData: fileId=" + r108.getFileId() + ", imageUuid=" + r108.getImageUuid() + r109 + r108.getSn() + ", rows=" + r113);     // Catch: Exception -> L81
        Unit r114 = Unit.INSTANCE;     // Catch: Exception -> L81
        if ((r114 instanceof List) == false) goto L74;
        int r115 = ((List) r114).size();     // Catch: Exception -> L81
    L75:
        long r212 = System.currentTimeMillis() - r105;     // Catch: Exception -> L81
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L81
        if (GalleryStoragePolicyManager.m() == false) goto L78;
        int r213 = 1;
    L79:
        r107.getClass();     // Catch: Exception -> L81
        l(r111, r110, r115, r212, 1, r213, "");     // Catch: Exception -> L81
        return r114;
    L78:
        r213 = 0;
        goto L79
    L74:
        r115 = r106;
    L81:
        e = e;
        int r116 = r106;
    L83:
        int r117 = r116;
        String r118 = r110;
        String r119 = r111;
        long r120 = r105;
    L86:
        long r214 = System.currentTimeMillis() - r120;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r215 = GalleryStoragePolicyManager.m();
        String r121 = e.getMessage();
        if (r121 != null) goto L89;
        String r216 = r112;
    L90:
        r107.getClass();
        l(r119, r118, r117, r214, 0, r215 ? 1 : 0, r216);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L89:
        r216 = r121;
    L15:
        e = e;
        r116 = r106;
        r112 = "";
        goto L83
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r122 = r100.J$0;
        int r123 = r100.I$0;
        String r124 = (String) r100.L$3;
        String r125 = (String) r100.L$2;
        AlbumDataBaseHelper r126 = (AlbumDataBaseHelper) r100.L$1;
        ThumbnailMetadata r127 = (ThumbnailMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L22
        ThumbnailMetadata r217 = r127;
        String r128 = r124;
        r109 = ", sn=";
        String r129 = r125;
        AlbumDataBaseHelper r130 = r126;
        long r131 = r122;
        r112 = "";
    L108:
    L45:
        e = e;
        r127 = r217;
        String r132 = r128;
        String r133 = r129;
        int r134 = r123;
    L57:
        long r218 = System.currentTimeMillis() - r131;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r219 = GalleryStoragePolicyManager.m();
        String r135 = e.getMessage();
        if (r135 != null) goto L60;
        String r220 = r112;
    L61:
        r130.getClass();
        l(r133, r132, r134, r218, 0, r219 ? 1 : 0, r220);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r102 = null;
    L62:
        i r136 = (i) r102;
        if (r136 != null) goto L66;
        FLogger.f375446a.e("AlbumDataBaseHelper", "updateThumbnailData: thumbnailMetadata not found, imageUuid=" + r127.getImageUuid() + r109 + r127.getSn());
        return Unit.INSTANCE;
    L66:
        r120 = System.currentTimeMillis();
        j r137 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L84
        i r138 = c(f292393a, r127);     // Catch: Exception -> L84
        String r139 = r136.f292456a;     // Catch: Exception -> L84
        Intrinsics.checkNotNullParameter(r139, "<set-?>");     // Catch: Exception -> L84
        r138.f292456a = r139;     // Catch: Exception -> L84
        r100.L$0 = r127;     // Catch: Exception -> L84
        r100.L$1 = this;     // Catch: Exception -> L84
        r100.L$2 = "update";     // Catch: Exception -> L84
        r100.L$3 = "album_thumbnail";     // Catch: Exception -> L84
        r100.I$0 = 1;     // Catch: Exception -> L84
        r100.J$0 = r120;     // Catch: Exception -> L84
        r100.label = 2;     // Catch: Exception -> L84
        r102 = r137.g(r138, r100);     // Catch: Exception -> L84
        if (r102 != r103) goto L70;
        return r103;
    L70:
        r108 = r127;
        r111 = "update";
        r105 = r120;
        r106 = 1;
        r107 = this;
    L84:
        e = e;
        r119 = "update";
        r118 = "album_thumbnail";
        r117 = 1;
        r107 = this;
        goto L86
    L60:
        r220 = r135;
        goto L61
    L36:
        if ((r102 instanceof List) == false) goto L38;
        int r140 = ((List) r102).size();     // Catch: Exception -> L45
    L39:
        long r221 = System.currentTimeMillis() - r131;     // Catch: Exception -> L45
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L45
        if (GalleryStoragePolicyManager.m() == false) goto L42;
        int r222 = 1;
    L43:
        r130.getClass();     // Catch: Exception -> L45
        l(r129, r128, r140, r221, 1, r222, "");     // Catch: Exception -> L45
        r127 = r217;
        goto L62
    L42:
        r222 = 0;
        goto L43
    L38:
        r140 = r123;
    L22:
        e = e;
        r132 = r124;
        r109 = ", sn=";
        r134 = r123;
        r133 = r125;
        r112 = "";
        r130 = r126;
        r131 = r122;
        goto L57
    L24:
        ResultKt.throwOnFailure(r102);
        r133 = "get_one";
        long r141 = System.currentTimeMillis();
        j r142 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L53
        r109 = ", sn=";
        long r143 = r210.getImageUuid();     // Catch: Exception -> L51
        String r144 = r210.getSn();     // Catch: Exception -> L51
        r112 = "";
        ThumbnailMetadata r145 = r210;
        r100.L$0 = r145;     // Catch: Exception -> L49
        r100.L$1 = this;     // Catch: Exception -> L49
        r100.L$2 = "get_one";     // Catch: Exception -> L49
        r100.L$3 = "album_thumbnail";     // Catch: Exception -> L49
        r133 = "get_one";
        r100.I$0 = 1;     // Catch: Exception -> L47
        r100.J$0 = r141;     // Catch: Exception -> L47
        r100.label = 1;     // Catch: Exception -> L47
        r102 = r142.b(r143, r144, r100);     // Catch: Exception -> L47
        if (r102 != r103) goto L34;
        return r103;
    L34:
        r131 = r141;
        r217 = r145;
        r128 = "album_thumbnail";
        r129 = r133;
        r123 = 1;
        r130 = this;
    L47:
        e = e;
    L56:
        r131 = r141;
        r127 = r145;
        r132 = "album_thumbnail";
        r134 = 1;
        r130 = this;
    L49:
        e = e;
        r133 = "get_one";
    L51:
        e = e;
    L55:
        r112 = "";
        r145 = r210;
    L53:
        e = e;
        r109 = ", sn=";
    L7:
        r100 = new AlbumDataBaseHelper$updateThumbnailData$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(String r210, Continuation<? super Unit> r211) {
        String r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$deleteMediaDataById$1) == false) goto L7;
        AlbumDataBaseHelper$deleteMediaDataById$1 r101 = (AlbumDataBaseHelper$deleteMediaDataById$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r107 = r101.I$0;
        String r110 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r108 = r110;
        String r113 = r111;
        AlbumDataBaseHelper r114 = r112;
    L46:
        int r109 = ((Number) r103).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "deleteMediaDataById: id=" + r100 + ", rows=" + r109);     // Catch: Exception -> L33
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r115 instanceof List) == false) goto L26;
        int r116 = ((List) r115).size();     // Catch: Exception -> L33
    L27:
        long r117 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r114.getClass();     // Catch: Exception -> L33
        l(r113, r108, r116, r117, 1, r118, "");     // Catch: Exception -> L33
        return r115;
    L30:
        r118 = 0;
        goto L31
    L26:
        r116 = r107;
    L33:
        e = e;
        r110 = r108;
        int r119 = r107;
        String r120 = r113;
        r112 = r114;
    L37:
        long r121 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r112.getClass();
        l(r120, r110, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r119 = r107;
        r120 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r110 = "album";
        long r124 = System.currentTimeMillis();
        b r125 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r101.L$0 = r100;     // Catch: Exception -> L35
        r101.L$1 = this;     // Catch: Exception -> L35
        r101.L$2 = "delete";     // Catch: Exception -> L35
        r101.L$3 = "album";     // Catch: Exception -> L35
        r101.I$0 = 1;     // Catch: Exception -> L35
        r101.J$0 = r124;     // Catch: Exception -> L35
        r101.label = 1;     // Catch: Exception -> L35
        r103 = r125.m(r100, r101);     // Catch: Exception -> L35
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r114 = this;
        r108 = "album";
        r113 = "delete";
        r106 = r124;
        r107 = 1;
    L35:
        e = e;
        r120 = "delete";
        r106 = r124;
        r119 = 1;
        r112 = this;
    L7:
        r101 = new AlbumDataBaseHelper$deleteMediaDataById$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(List<String> r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof AlbumDataBaseHelper$deleteMediaDataByIds$1) == false) goto L7;
        AlbumDataBaseHelper$deleteMediaDataByIds$1 r100 = (AlbumDataBaseHelper$deleteMediaDataByIds$1) r211;
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
        int r106 = r100.I$0;
        String r107 = (String) r100.L$3;
        String r110 = (String) r100.L$2;
        AlbumDataBaseHelper r111 = (AlbumDataBaseHelper) r100.L$1;
        List r108 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r112 = r107;
        String r113 = r110;
        AlbumDataBaseHelper r114 = r111;
    L47:
        int r109 = ((Number) r102).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "deleteMediaDataByIds: ids=" + r108 + ", rows=" + r109);     // Catch: Exception -> L33
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r115 instanceof List) == false) goto L26;
        int r116 = ((List) r115).size();     // Catch: Exception -> L33
    L27:
        long r117 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r114.getClass();     // Catch: Exception -> L33
        l(r113, r112, r116, r117, 1, r118, "");     // Catch: Exception -> L33
        return r115;
    L30:
        r118 = 0;
        goto L31
    L26:
        r116 = r106;
    L33:
        e = e;
        int r119 = r106;
        r107 = r112;
        String r120 = r113;
    L38:
        long r121 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L41;
        r123 = "";
    L41:
        r114.getClass();
        l(r120, r107, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
    L37:
        r114 = r111;
        String r212 = r110;
        r119 = r106;
        r120 = r212;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "batch_delete";
        r107 = "album";
        ArrayList r124 = (ArrayList) r210;
        r106 = r124.size();
        long r125 = System.currentTimeMillis();
        b r126 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r100.L$0 = r124;     // Catch: Exception -> L35
        r100.L$1 = this;     // Catch: Exception -> L35
        r100.L$2 = "batch_delete";     // Catch: Exception -> L35
        r100.L$3 = "album";     // Catch: Exception -> L35
        r100.I$0 = r106;     // Catch: Exception -> L35
        r100.J$0 = r125;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        Object r127 = r126.c(r124, r100);     // Catch: Exception -> L35
        if (r127 != r103) goto L22;
        return r103;
    L22:
        r114 = this;
        r112 = "album";
        r113 = "batch_delete";
        r105 = r125;
        r108 = r124;
        r102 = r127;
    L35:
        e = e;
        r105 = r125;
        r111 = this;
    L7:
        r100 = new AlbumDataBaseHelper$deleteMediaDataByIds$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(MediaMetadata r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof AlbumDataBaseHelper$insertMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$insertMediaData$1 r100 = (AlbumDataBaseHelper$insertMediaData$1) r211;
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
        int r106 = r100.I$0;
        String r107 = (String) r100.L$3;
        String r110 = (String) r100.L$2;
        AlbumDataBaseHelper r111 = (AlbumDataBaseHelper) r100.L$1;
        MediaMetadata r108 = (MediaMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r112 = r107;
        String r113 = r110;
        AlbumDataBaseHelper r114 = r111;
    L42:
        long r109 = ((Number) r102).longValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "insertMediaData: uniqId=" + r108.getUniqId() + ", mediaId=" + r108.getMediaId() + ", rowId=" + r109);     // Catch: Exception -> L33
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r115 instanceof List) == false) goto L26;
        int r116 = ((List) r115).size();     // Catch: Exception -> L33
    L27:
        long r117 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r114.getClass();     // Catch: Exception -> L33
        l(r113, r112, r116, r117, 1, r118, "");     // Catch: Exception -> L33
        return r115;
    L30:
        r118 = 0;
        goto L31
    L26:
        r116 = r106;
    L33:
        e = e;
        int r119 = r106;
        r107 = r112;
        String r120 = r113;
        r111 = r114;
    L37:
        long r121 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r111.getClass();
        l(r120, r107, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r119 = r106;
        r120 = r110;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r107 = "album";
        long r124 = System.currentTimeMillis();
        b r125 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        f292393a.getClass();     // Catch: Exception -> L35
        a r126 = k(r210);     // Catch: Exception -> L35
        r100.L$0 = r210;     // Catch: Exception -> L35
        r100.L$1 = this;     // Catch: Exception -> L35
        r100.L$2 = SVGRenderEngine.SAVE;     // Catch: Exception -> L35
        r100.L$3 = "album";     // Catch: Exception -> L35
        r100.I$0 = 1;     // Catch: Exception -> L35
        r100.J$0 = r124;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r125.b(r126, r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r114 = this;
        r108 = r210;
        r112 = "album";
        r113 = SVGRenderEngine.SAVE;
        r105 = r124;
        r106 = 1;
    L35:
        e = e;
        r120 = SVGRenderEngine.SAVE;
        r105 = r124;
        r119 = 1;
        r111 = this;
    L7:
        r100 = new AlbumDataBaseHelper$insertMediaData$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(List<MediaMetadata> r210, Continuation<? super Unit> r211) {
        List<MediaMetadata> r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$insertMediaDataList$1) == false) goto L7;
        AlbumDataBaseHelper$insertMediaDataList$1 r101 = (AlbumDataBaseHelper$insertMediaDataList$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r107 = r101.I$0;
        String r110 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r108 = r110;
        String r113 = r111;
        AlbumDataBaseHelper r114 = r112;
    L59:
        List r109 = (List) r103;     // Catch: Exception -> L45
        FLogger r115 = FLogger.f375446a;     // Catch: Exception -> L45
        StringBuilder r116 = new StringBuilder();     // Catch: Exception -> L45
        r116.append("insertMediaDataList: uniqIds=");     // Catch: Exception -> L45
        List<MediaMetadata> r117 = r100;     // Catch: Exception -> L45
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));     // Catch: Exception -> L45
        Iterator<T> r119 = r117.iterator();     // Catch: Exception -> L45
    L29:
        if (r119.hasNext() == false) goto L31;
        r118.add(((MediaMetadata) r119.next()).getUniqId());     // Catch: Exception -> L45
        goto L29
    L31:
        r116.append(r118);     // Catch: Exception -> L45
        r116.append(", mediaIds=");     // Catch: Exception -> L45
        List<MediaMetadata> r120 = r100;     // Catch: Exception -> L45
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));     // Catch: Exception -> L45
        Iterator<T> r122 = r120.iterator();     // Catch: Exception -> L45
    L33:
        if (r122.hasNext() == false) goto L35;
        r121.add(Boxing.boxLong(((MediaMetadata) r122.next()).getMediaId()));     // Catch: Exception -> L45
        goto L33
    L35:
        r116.append(r121);     // Catch: Exception -> L45
        r116.append(", rowIds=");     // Catch: Exception -> L45
        r116.append(r109);     // Catch: Exception -> L45
        r116.append(", total=");     // Catch: Exception -> L45
        r116.append(r100.size());     // Catch: Exception -> L45
        r116.append(", success=");     // Catch: Exception -> L45
        r116.append(r109.size());     // Catch: Exception -> L45
        r115.i("AlbumDataBaseHelper", r116.toString());     // Catch: Exception -> L45
        Unit r123 = Unit.INSTANCE;     // Catch: Exception -> L45
        if ((r123 instanceof List) == false) goto L38;
        int r124 = ((List) r123).size();     // Catch: Exception -> L45
    L39:
        long r125 = System.currentTimeMillis() - r106;     // Catch: Exception -> L45
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L45
        if (GalleryStoragePolicyManager.m() == false) goto L42;
        int r126 = 1;
    L43:
        r114.getClass();     // Catch: Exception -> L45
        l(r113, r108, r124, r125, 1, r126, "");     // Catch: Exception -> L45
        return r123;
    L42:
        r126 = 0;
        goto L43
    L38:
        r124 = r107;
    L45:
        e = e;
        r110 = r108;
        int r127 = r107;
        String r128 = r113;
    L50:
        long r129 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r130 = GalleryStoragePolicyManager.m();
        String r131 = e.getMessage();
        if (r131 != null) goto L53;
        r131 = "";
    L53:
        r114.getClass();
        l(r128, r110, r127, r129, 0, r130 ? 1 : 0, r131);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
    L49:
        r114 = r112;
        String r212 = r111;
        r127 = r107;
        r128 = r212;
        goto L50
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "batch_save";
        r110 = "album";
        r107 = r210.size();
        long r132 = System.currentTimeMillis();
        b r133 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L47
        List<MediaMetadata> r134 = r100;     // Catch: Exception -> L47
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));     // Catch: Exception -> L47
        Iterator<T> r136 = r134.iterator();     // Catch: Exception -> L47
    L21:
        if (r136.hasNext() == false) goto L23;
        MediaMetadata r137 = (MediaMetadata) r136.next();     // Catch: Exception -> L47
        f292393a.getClass();     // Catch: Exception -> L47
        r135.add(k(r137));     // Catch: Exception -> L47
        goto L21
    L23:
        r101.L$0 = r100;     // Catch: Exception -> L47
        r101.L$1 = this;     // Catch: Exception -> L47
        r101.L$2 = "batch_save";     // Catch: Exception -> L47
        r101.L$3 = "album";     // Catch: Exception -> L47
        r101.I$0 = r107;     // Catch: Exception -> L47
        r101.J$0 = r132;     // Catch: Exception -> L47
        r101.label = 1;     // Catch: Exception -> L47
        r103 = r133.g(r135, r101);     // Catch: Exception -> L47
        if (r103 != r104) goto L26;
        return r104;
    L26:
        r114 = this;
        r108 = "album";
        r113 = "batch_save";
        r106 = r132;
    L47:
        e = e;
        r106 = r132;
        r112 = this;
    L7:
        r101 = new AlbumDataBaseHelper$insertMediaDataList$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(ThumbnailMetadata r210, Continuation<? super Unit> r211) {
        ThumbnailMetadata r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$insertThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$insertThumbnailData$1 r101 = (AlbumDataBaseHelper$insertThumbnailData$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r107 = r101.I$0;
        String r110 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (ThumbnailMetadata) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r108 = r110;
        String r113 = r111;
        AlbumDataBaseHelper r114 = r112;
    L46:
        long r115 = ((Number) r103).longValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "insertThumbnailData: fileId=" + r100.getFileId() + ", imageUuid=" + r100.getImageUuid() + ", sn=" + r100.getSn() + ", rowId=" + r115);     // Catch: Exception -> L33
        Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r109 instanceof List) == false) goto L26;
        int r116 = ((List) r109).size();     // Catch: Exception -> L33
    L27:
        long r117 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r118 = 1;
    L31:
        r114.getClass();     // Catch: Exception -> L33
        l(r113, r108, r116, r117, 1, r118, "");     // Catch: Exception -> L33
        return r109;
    L30:
        r118 = 0;
        goto L31
    L26:
        r116 = r107;
    L33:
        e = e;
        r110 = r108;
        int r119 = r107;
        String r120 = r113;
        r112 = r114;
    L37:
        long r121 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r112.getClass();
        l(r120, r110, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r119 = r107;
        r120 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r110 = "album_thumbnail";
        long r124 = System.currentTimeMillis();
        j r125 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L35
        i r126 = c(f292393a, r100);     // Catch: Exception -> L35
        r101.L$0 = r100;     // Catch: Exception -> L35
        r101.L$1 = this;     // Catch: Exception -> L35
        r101.L$2 = SVGRenderEngine.SAVE;     // Catch: Exception -> L35
        r101.L$3 = "album_thumbnail";     // Catch: Exception -> L35
        r101.I$0 = 1;     // Catch: Exception -> L35
        r101.J$0 = r124;     // Catch: Exception -> L35
        r101.label = 1;     // Catch: Exception -> L35
        r103 = r125.e(r126, r101);     // Catch: Exception -> L35
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r114 = this;
        r108 = "album_thumbnail";
        r113 = SVGRenderEngine.SAVE;
        r106 = r124;
        r107 = 1;
    L35:
        e = e;
        r120 = SVGRenderEngine.SAVE;
        r106 = r124;
        r119 = 1;
        r112 = this;
    L7:
        r101 = new AlbumDataBaseHelper$insertThumbnailData$1(this, r211);
        goto L8
    }

    public final Object o(String r210, Continuation<? super MediaMetadata> r211) {
        String r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataById$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataById$1 r101 = (AlbumDataBaseHelper$selectMediaDataById$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r110 = r101.I$0;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r107 = r111;
        String r114 = r112;
        AlbumDataBaseHelper r212 = r113;
    L48:
        a r108 = (a) r103;     // Catch: Exception -> L37
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataById: id=" + r100 + ", result=" + r108);     // Catch: Exception -> L37
        if (r108 == null) goto L26;
        Object r109 = a(f292393a, r108);     // Catch: Exception -> L37
    L28:
        if ((r109 instanceof List) == false) goto L30;
        int r115 = ((List) r109).size();     // Catch: Exception -> L37
    L31:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r117 = 1;
    L35:
        r212.getClass();     // Catch: Exception -> L37
        l(r114, r107, r115, r116, 1, r117, "");     // Catch: Exception -> L37
        return r109;
    L34:
        r117 = 0;
        goto L35
    L30:
        r115 = r110;
        goto L31
    L26:
        r109 = null;
    L37:
        e = e;
        r111 = r107;
        int r118 = r110;
        String r119 = r114;
        r113 = r212;
    L41:
        long r120 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r121 = GalleryStoragePolicyManager.m();
        String r122 = e.getMessage();
        if (r122 != null) goto L44;
        r122 = "";
    L44:
        r113.getClass();
        l(r119, r111, r118, r120, 0, r121 ? 1 : 0, r122);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r118 = r110;
        r119 = r112;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "album";
        long r123 = System.currentTimeMillis();
        b r124 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L39
        r101.L$0 = r100;     // Catch: Exception -> L39
        r101.L$1 = this;     // Catch: Exception -> L39
        r101.L$2 = "get_one";     // Catch: Exception -> L39
        r101.L$3 = "album";     // Catch: Exception -> L39
        r101.I$0 = 1;     // Catch: Exception -> L39
        r101.J$0 = r123;     // Catch: Exception -> L39
        r101.label = 1;     // Catch: Exception -> L39
        r103 = r124.k(r100, r101);     // Catch: Exception -> L39
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r212 = this;
        r107 = "album";
        r114 = "get_one";
        r106 = r123;
        r110 = 1;
    L39:
        e = e;
        r119 = "get_one";
        r106 = r123;
        r118 = 1;
        r113 = this;
    L7:
        r101 = new AlbumDataBaseHelper$selectMediaDataById$1(this, r211);
        goto L8
    }

    public final Object p(String r210, Continuation<? super MediaMetadata> r211) {
        String r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataByPath$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataByPath$1 r101 = (AlbumDataBaseHelper$selectMediaDataByPath$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r110 = r101.I$0;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r107 = r111;
        String r114 = r112;
        AlbumDataBaseHelper r212 = r113;
    L48:
        a r108 = (a) r103;     // Catch: Exception -> L37
        FLogger.f375446a.i("AlbumDataBaseHelper", "getMetadataByPath: filePath=" + r100 + ", result=" + r108);     // Catch: Exception -> L37
        if (r108 == null) goto L26;
        Object r109 = a(f292393a, r108);     // Catch: Exception -> L37
    L28:
        if ((r109 instanceof List) == false) goto L30;
        int r115 = ((List) r109).size();     // Catch: Exception -> L37
    L31:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r117 = 1;
    L35:
        r212.getClass();     // Catch: Exception -> L37
        l(r114, r107, r115, r116, 1, r117, "");     // Catch: Exception -> L37
        return r109;
    L34:
        r117 = 0;
        goto L35
    L30:
        r115 = r110;
        goto L31
    L26:
        r109 = null;
    L37:
        e = e;
        r111 = r107;
        int r118 = r110;
        String r119 = r114;
        r113 = r212;
    L41:
        long r120 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r121 = GalleryStoragePolicyManager.m();
        String r122 = e.getMessage();
        if (r122 != null) goto L44;
        r122 = "";
    L44:
        r113.getClass();
        l(r119, r111, r118, r120, 0, r121 ? 1 : 0, r122);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r118 = r110;
        r119 = r112;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "album";
        long r123 = System.currentTimeMillis();
        b r124 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L39
        r101.L$0 = r100;     // Catch: Exception -> L39
        r101.L$1 = this;     // Catch: Exception -> L39
        r101.L$2 = "get_one";     // Catch: Exception -> L39
        r101.L$3 = "album";     // Catch: Exception -> L39
        r101.I$0 = 1;     // Catch: Exception -> L39
        r101.J$0 = r123;     // Catch: Exception -> L39
        r101.label = 1;     // Catch: Exception -> L39
        r103 = r124.j(r100, r101);     // Catch: Exception -> L39
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r212 = this;
        r107 = "album";
        r114 = "get_one";
        r106 = r123;
        r110 = 1;
    L39:
        e = e;
        r119 = "get_one";
        r106 = r123;
        r118 = 1;
        r113 = this;
    L7:
        r101 = new AlbumDataBaseHelper$selectMediaDataByPath$1(this, r211);
        goto L8
    }

    public final Object r(MediaLifecycleState r210, Continuation<? super List<MediaMetadata>> r211) {
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataListByIncomplete$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByIncomplete$1 r100 = (AlbumDataBaseHelper$selectMediaDataListByIncomplete$1) r211;
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
        int r106 = r100.I$0;
        String r110 = (String) r100.L$3;
        String r111 = (String) r100.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r100.L$1;
        MediaLifecycleState r107 = (MediaLifecycleState) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r113 = r110;
        String r114 = r111;
        AlbumDataBaseHelper r212 = r112;
    L44:
        List r108 = (List) r102;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataListByIncomplete: lifecycleState=" + r107 + ", result=" + r108);     // Catch: Exception -> L33
        List r109 = r108;     // Catch: Exception -> L33
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L33
        Iterator r116 = r109.iterator();     // Catch: Exception -> L33
    L25:
        if (r116.hasNext() == false) goto L27;
        r115.add(a(f292393a, (a) r116.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r117 = r115.size();     // Catch: Exception -> L33
        long r118 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r119 = 1;
    L31:
        r212.getClass();     // Catch: Exception -> L33
        l(r114, r113, r117, r118, 1, r119, "");     // Catch: Exception -> L33
    L41:
        if (r115 == null) goto L43;
        return r115;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r119 = 0;
    L33:
        e = e;
        int r120 = r106;
        r110 = r113;
        String r121 = r114;
        r112 = r212;
    L37:
        long r122 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r123 = GalleryStoragePolicyManager.m();
        String r124 = e.getMessage();
        if (r124 != null) goto L40;
        r124 = "";
    L40:
        r112.getClass();
        l(r121, r110, r120, r122, 0, r123 ? 1 : 0, r124);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r115 = null;
    L14:
        e = e;
        r120 = r106;
        r121 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "album";
        long r125 = System.currentTimeMillis();
        b r126 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        int r127 = r210.getValue();     // Catch: Exception -> L35
        r100.L$0 = r210;     // Catch: Exception -> L35
        r100.L$1 = this;     // Catch: Exception -> L35
        r100.L$2 = "batch_load";     // Catch: Exception -> L35
        r100.L$3 = "album";     // Catch: Exception -> L35
        r100.I$0 = 0;     // Catch: Exception -> L35
        r100.J$0 = r125;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r126.n(r127, r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r212 = this;
        r107 = r210;
        r113 = "album";
        r114 = "batch_load";
        r105 = r125;
        r106 = 0;
    L35:
        e = e;
        r121 = "batch_load";
        r105 = r125;
        r120 = 0;
        r112 = this;
    L7:
        r100 = new AlbumDataBaseHelper$selectMediaDataListByIncomplete$1(this, r211);
        goto L8
    }

    public final Object s(MediaLifecycleState r210, Continuation<? super List<MediaMetadata>> r211) {
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1 r100 = (AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1) r211;
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
        int r106 = r100.I$0;
        String r110 = (String) r100.L$3;
        String r111 = (String) r100.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r100.L$1;
        MediaLifecycleState r107 = (MediaLifecycleState) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        String r113 = r110;
        String r114 = r111;
        AlbumDataBaseHelper r212 = r112;
    L44:
        List r108 = (List) r102;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataListByLifecycleState: lifecycleState=" + r107 + ", result=" + r108);     // Catch: Exception -> L33
        List r109 = r108;     // Catch: Exception -> L33
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L33
        Iterator r116 = r109.iterator();     // Catch: Exception -> L33
    L25:
        if (r116.hasNext() == false) goto L27;
        r115.add(a(f292393a, (a) r116.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r117 = r115.size();     // Catch: Exception -> L33
        long r118 = System.currentTimeMillis() - r105;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r119 = 1;
    L31:
        r212.getClass();     // Catch: Exception -> L33
        l(r114, r113, r117, r118, 1, r119, "");     // Catch: Exception -> L33
    L41:
        if (r115 == null) goto L43;
        return r115;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r119 = 0;
    L33:
        e = e;
        int r120 = r106;
        r110 = r113;
        String r121 = r114;
        r112 = r212;
    L37:
        long r122 = System.currentTimeMillis() - r105;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r123 = GalleryStoragePolicyManager.m();
        String r124 = e.getMessage();
        if (r124 != null) goto L40;
        r124 = "";
    L40:
        r112.getClass();
        l(r121, r110, r120, r122, 0, r123 ? 1 : 0, r124);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r115 = null;
    L14:
        e = e;
        r120 = r106;
        r121 = r111;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r110 = "album";
        long r125 = System.currentTimeMillis();
        b r126 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        int r127 = r210.getValue();     // Catch: Exception -> L35
        r100.L$0 = r210;     // Catch: Exception -> L35
        r100.L$1 = this;     // Catch: Exception -> L35
        r100.L$2 = "batch_load";     // Catch: Exception -> L35
        r100.L$3 = "album";     // Catch: Exception -> L35
        r100.I$0 = 0;     // Catch: Exception -> L35
        r100.J$0 = r125;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r126.i(r127, r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L22;
        return r103;
    L22:
        r212 = this;
        r107 = r210;
        r113 = "album";
        r114 = "batch_load";
        r105 = r125;
        r106 = 0;
    L35:
        e = e;
        r121 = "batch_load";
        r105 = r125;
        r120 = 0;
        r112 = this;
    L7:
        r100 = new AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1(this, r211);
        goto L8
    }

    public final Object t(List<? extends MediaLifecycleState> r210, Continuation<? super List<MediaMetadata>> r211) {
        List<? extends MediaLifecycleState> r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1 r101 = (AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r110 = r101.I$0;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r107 = r111;
        String r114 = r112;
        AlbumDataBaseHelper r212 = r113;
    L52:
        List r108 = (List) r103;     // Catch: Exception -> L37
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataListByLifecycleStates: lifecycleStates=" + r100 + ", result=" + r108);     // Catch: Exception -> L37
        List r109 = r108;     // Catch: Exception -> L37
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L37
        Iterator r116 = r109.iterator();     // Catch: Exception -> L37
    L29:
        if (r116.hasNext() == false) goto L31;
        r115.add(a(f292393a, (a) r116.next()));     // Catch: Exception -> L37
        goto L29
    L31:
        int r117 = r115.size();     // Catch: Exception -> L37
        long r118 = System.currentTimeMillis() - r106;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r119 = 1;
    L35:
        r212.getClass();     // Catch: Exception -> L37
        l(r114, r107, r117, r118, 1, r119, "");     // Catch: Exception -> L37
    L45:
        if (r115 == null) goto L47;
        return r115;
    L47:
        return CollectionsKt.emptyList();
    L34:
        r119 = 0;
    L37:
        e = e;
        r111 = r107;
        int r120 = r110;
        String r121 = r114;
        r113 = r212;
    L41:
        long r122 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r123 = GalleryStoragePolicyManager.m();
        String r124 = e.getMessage();
        if (r124 != null) goto L44;
        r124 = "";
    L44:
        r113.getClass();
        l(r121, r111, r120, r122, 0, r123 ? 1 : 0, r124);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r115 = null;
    L14:
        e = e;
        r120 = r110;
        r121 = r112;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "album";
        long r125 = System.currentTimeMillis();
        b r126 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L39
        List<? extends MediaLifecycleState> r127 = r100;     // Catch: Exception -> L39
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));     // Catch: Exception -> L39
        Iterator<T> r129 = r127.iterator();     // Catch: Exception -> L39
    L21:
        if (r129.hasNext() == false) goto L23;
        r128.add(Boxing.boxInt(((MediaLifecycleState) r129.next()).getValue()));     // Catch: Exception -> L39
        goto L21
    L23:
        r101.L$0 = r100;     // Catch: Exception -> L39
        r101.L$1 = this;     // Catch: Exception -> L39
        r101.L$2 = "batch_load";     // Catch: Exception -> L39
        r101.L$3 = "album";     // Catch: Exception -> L39
        r101.I$0 = 0;     // Catch: Exception -> L39
        r101.J$0 = r125;     // Catch: Exception -> L39
        r101.label = 1;     // Catch: Exception -> L39
        r103 = r126.l(r128, r101);     // Catch: Exception -> L39
        if (r103 != r104) goto L26;
        return r104;
    L26:
        r212 = this;
        r107 = "album";
        r114 = "batch_load";
        r106 = r125;
        r110 = 0;
    L39:
        e = e;
        r121 = "batch_load";
        r106 = r125;
        r120 = 0;
        r113 = this;
    L7:
        r101 = new AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1(this, r211);
        goto L8
    }

    public final Object v(List<Long> r210, Continuation<? super List<MediaMetadata>> r211) {
        List<Long> r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1 r101 = (AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r110 = r101.I$0;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r107 = r111;
        String r114 = r112;
        AlbumDataBaseHelper r212 = r113;
    L46:
        List r108 = (List) r103;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataListBySystemGalleryIds: systemGalleryIds=" + r100 + ", result=" + r108);     // Catch: Exception -> L33
        List r109 = r108;     // Catch: Exception -> L33
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Exception -> L33
        Iterator r116 = r109.iterator();     // Catch: Exception -> L33
    L25:
        if (r116.hasNext() == false) goto L27;
        r115.add(a(f292393a, (a) r116.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r117 = r115.size();     // Catch: Exception -> L33
        long r118 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r119 = 1;
    L31:
        r212.getClass();     // Catch: Exception -> L33
        l(r114, r107, r117, r118, 1, r119, "");     // Catch: Exception -> L33
    L41:
        if (r115 == null) goto L43;
        return r115;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r119 = 0;
    L33:
        e = e;
        r111 = r107;
        int r120 = r110;
        String r121 = r114;
        r113 = r212;
    L37:
        long r122 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r123 = GalleryStoragePolicyManager.m();
        String r124 = e.getMessage();
        if (r124 != null) goto L40;
        r124 = "";
    L40:
        r113.getClass();
        l(r121, r111, r120, r122, 0, r123 ? 1 : 0, r124);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r115 = null;
    L14:
        e = e;
        r120 = r110;
        r121 = r112;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "album";
        long r125 = System.currentTimeMillis();
        b r126 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r101.L$0 = r100;     // Catch: Exception -> L35
        r101.L$1 = this;     // Catch: Exception -> L35
        r101.L$2 = "batch_load";     // Catch: Exception -> L35
        r101.L$3 = "album";     // Catch: Exception -> L35
        r101.I$0 = 0;     // Catch: Exception -> L35
        r101.J$0 = r125;     // Catch: Exception -> L35
        r101.label = 1;     // Catch: Exception -> L35
        r103 = r126.e(r100, r101);     // Catch: Exception -> L35
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r212 = this;
        r107 = "album";
        r114 = "batch_load";
        r106 = r125;
        r110 = 0;
    L35:
        e = e;
        r121 = "batch_load";
        r106 = r125;
        r120 = 0;
        r113 = this;
    L7:
        r101 = new AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object y(MediaMetadata r210, Continuation<? super Unit> r211) {
        MediaMetadata r100 = r210;
        if ((r211 instanceof AlbumDataBaseHelper$updateMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$updateMediaData$1 r101 = (AlbumDataBaseHelper$updateMediaData$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r110 = r101.I$0;
        String r111 = (String) r101.L$3;
        String r112 = (String) r101.L$2;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (MediaMetadata) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r107 = r111;
        String r114 = r112;
        AlbumDataBaseHelper r212 = r113;
    L44:
        int r108 = ((Number) r103).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "updateMediaData: uniqId=" + r100.getUniqId() + ", mediaId=" + r100.getMediaId() + ", rows=" + r108);     // Catch: Exception -> L33
        Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r109 instanceof List) == false) goto L26;
        int r115 = ((List) r109).size();     // Catch: Exception -> L33
    L27:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r117 = 1;
    L31:
        r212.getClass();     // Catch: Exception -> L33
        l(r114, r107, r115, r116, 1, r117, "");     // Catch: Exception -> L33
        return r109;
    L30:
        r117 = 0;
        goto L31
    L26:
        r115 = r110;
    L33:
        e = e;
        r111 = r107;
        int r118 = r110;
        String r119 = r114;
        r113 = r212;
    L37:
        long r120 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r121 = GalleryStoragePolicyManager.m();
        String r122 = e.getMessage();
        if (r122 != null) goto L40;
        r122 = "";
    L40:
        r113.getClass();
        l(r119, r111, r118, r120, 0, r121 ? 1 : 0, r122);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r118 = r110;
        r119 = r112;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "album";
        long r123 = System.currentTimeMillis();
        CoroutineDispatcher r124 = Dispatchers.getIO();     // Catch: Exception -> L35
        AlbumDataBaseHelper$updateMediaData$2$rows$1 r125 = new AlbumDataBaseHelper$updateMediaData$2$rows$1(r100, null);     // Catch: Exception -> L35
        r101.L$0 = r100;     // Catch: Exception -> L35
        r101.L$1 = this;     // Catch: Exception -> L35
        r101.L$2 = "update";     // Catch: Exception -> L35
        r101.L$3 = "album";     // Catch: Exception -> L35
        r101.I$0 = 1;     // Catch: Exception -> L35
        r101.J$0 = r123;     // Catch: Exception -> L35
        r101.label = 1;     // Catch: Exception -> L35
        r103 = BuildersKt.withContext(r124, r125, r101);     // Catch: Exception -> L35
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r212 = this;
        r107 = "album";
        r114 = "update";
        r106 = r123;
        r110 = 1;
    L35:
        e = e;
        r119 = "update";
        r106 = r123;
        r118 = 1;
        r113 = this;
    L7:
        r101 = new AlbumDataBaseHelper$updateMediaData$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(long r210, String r211, Continuation<? super Unit> r212) {
        String r100 = r211;
        if ((r212 instanceof AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1 r101 = (AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$1;
        int r107 = r101.I$0;
        long r110 = r101.J$0;
        String r108 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r109 = r111;
        AlbumDataBaseHelper r213 = r112;
    L42:
        int r113 = ((Number) r103).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "deleteThumbnailDataByImageUuidAndSn: imageUuid=" + r110 + ", sn=" + r100 + ", rows=" + r113);     // Catch: Exception -> L33
        Unit r114 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r114 instanceof List) == false) goto L26;
        int r115 = ((List) r114).size();     // Catch: Exception -> L33
    L27:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r117 = 1;
    L31:
        r213.getClass();     // Catch: Exception -> L33
        l(r109, r108, r115, r116, 1, r117, "");     // Catch: Exception -> L33
        return r114;
    L30:
        r117 = 0;
        goto L31
    L26:
        r115 = r107;
    L33:
        e = e;
        String r118 = r109;
        int r119 = r107;
        String r120 = r108;
        r112 = r213;
    L37:
        long r121 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r122 = GalleryStoragePolicyManager.m();
        String r123 = e.getMessage();
        if (r123 != null) goto L40;
        r123 = "";
    L40:
        r112.getClass();
        l(r118, r120, r119, r121, 0, r122 ? 1 : 0, r123);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r120 = r108;
        r118 = r111;
        r119 = r107;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r108 = "album_thumbnail";
        long r124 = System.currentTimeMillis();
        j r125 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L35
        r101.L$0 = r100;     // Catch: Exception -> L35
        r101.L$1 = this;     // Catch: Exception -> L35
        r101.L$2 = "delete";     // Catch: Exception -> L35
        r101.L$3 = "album_thumbnail";     // Catch: Exception -> L35
        r101.J$0 = r210;     // Catch: Exception -> L35
        r101.I$0 = 1;     // Catch: Exception -> L35
        r101.J$1 = r124;     // Catch: Exception -> L35
        r101.label = 1;     // Catch: Exception -> L35
        r103 = r125.a(r210, r100, r101);     // Catch: Exception -> L35
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r213 = this;
        r109 = "delete";
        r107 = 1;
        r106 = r124;
        r110 = r210;
    L35:
        e = e;
        r112 = this;
        r106 = r124;
        r118 = "delete";
        r119 = 1;
        r120 = "album_thumbnail";
    L7:
        r101 = new AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1(this, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(List<Long> r210, String r211, Continuation<? super Unit> r212) {
        List<Long> r100 = r210;
        String r101 = r211;
        if ((r212 instanceof AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1 r102 = (AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        long r107 = r102.J$0;
        int r108 = r102.I$0;
        String r110 = (String) r102.L$4;
        String r111 = (String) r102.L$3;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r102.L$2;
        String r109 = (String) r102.L$1;
        List<Long> r113 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L14
        String r114 = r110;
        String r115 = r111;
        AlbumDataBaseHelper r213 = r112;
        r101 = r109;
        r100 = r113;
        Object r116 = r104;
        int r117 = r108;
    L43:
        int r118 = ((Number) r116).intValue();     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "deleteThumbnailDataByImageUuidsAndSn: imageUuids=" + r100 + ", sn=" + r101 + ", rows=" + r118);     // Catch: Exception -> L33
        Unit r119 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r119 instanceof List) == false) goto L26;
        int r120 = ((List) r119).size();     // Catch: Exception -> L33
    L27:
        long r121 = System.currentTimeMillis() - r107;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r122 = 1;
    L31:
        r213.getClass();     // Catch: Exception -> L33
        l(r115, r114, r120, r121, 1, r122, "");     // Catch: Exception -> L33
        return r119;
    L30:
        r122 = 0;
        goto L31
    L26:
        r120 = r117;
    L33:
        e = e;
        int r123 = r117;
        String r124 = r114;
        String r125 = r115;
    L38:
        long r126 = System.currentTimeMillis() - r107;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r127 = GalleryStoragePolicyManager.m();
        String r128 = e.getMessage();
        if (r128 != null) goto L41;
        r128 = "";
    L41:
        r213.getClass();
        l(r125, r124, r123, r126, 0, r127 ? 1 : 0, r128);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r213 = r112;
        r123 = r108;
    L37:
        String r214 = r111;
        r124 = r110;
        r125 = r214;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r111 = "delete";
        r110 = "album_thumbnail";
        r117 = r210.size();
        long r129 = System.currentTimeMillis();
        j r130 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L35
        r102.L$0 = r100;     // Catch: Exception -> L35
        r102.L$1 = r101;     // Catch: Exception -> L35
        r102.L$2 = this;     // Catch: Exception -> L35
        r102.L$3 = "delete";     // Catch: Exception -> L35
        r102.L$4 = "album_thumbnail";     // Catch: Exception -> L35
        r102.I$0 = r117;     // Catch: Exception -> L35
        r102.J$0 = r129;     // Catch: Exception -> L35
        r102.label = 1;     // Catch: Exception -> L35
        r116 = r130.c(r100, r101, r102);     // Catch: Exception -> L35
        if (r116 != r105) goto L22;
        return r105;
    L22:
        r213 = this;
        r114 = "album_thumbnail";
        r115 = "delete";
        r107 = r129;
    L35:
        e = e;
        r213 = this;
        r107 = r129;
        r123 = r117;
    L7:
        r102 = new AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1(this, r212);
        goto L8
    }

    public final Object u(int r210, int r211, Continuation<? super List<MediaMetadata>> r212) {
        int r100 = r210;
        int r101 = r211;
        if ((r212 instanceof AlbumDataBaseHelper$selectMediaDataListByPage$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByPage$1 r102 = (AlbumDataBaseHelper$selectMediaDataListByPage$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        long r107 = r102.J$0;
        int r108 = r102.I$2;
        int r109 = r102.I$1;
        int r110 = r102.I$0;
        String r111 = (String) r102.L$2;
        String r112 = (String) r102.L$1;
        AlbumDataBaseHelper r113 = (AlbumDataBaseHelper) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L14
        long r114 = r107;
        AlbumDataBaseHelper r115 = r113;
        Object r116 = r104;
        int r117 = r108;
        r101 = r109;
        r100 = r110;
    L46:
        List r118 = (List) r116;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectMediaDataListByPage: offset=" + r100 + ", limit=" + r101 + ", result=" + r118);     // Catch: Exception -> L33
        List r119 = r118;     // Catch: Exception -> L33
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));     // Catch: Exception -> L33
        Iterator r121 = r119.iterator();     // Catch: Exception -> L33
    L25:
        if (r121.hasNext() == false) goto L27;
        r120.add(a(f292393a, (a) r121.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r122 = r120.size();     // Catch: Exception -> L33
        long r123 = System.currentTimeMillis() - r114;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r213 = 1;
    L31:
        r115.getClass();     // Catch: Exception -> L33
        l(r112, r111, r122, r123, 1, r213, "");     // Catch: Exception -> L33
    L41:
        if (r120 == null) goto L43;
        return r120;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r213 = 0;
    L33:
        e = e;
        r113 = r115;
        String r124 = r112;
        r107 = r114;
        int r125 = r117;
    L37:
        long r126 = System.currentTimeMillis() - r107;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r127 = GalleryStoragePolicyManager.m();
        String r128 = e.getMessage();
        if (r128 != null) goto L40;
        r128 = "";
    L40:
        r113.getClass();
        l(r124, r111, r125, r126, 0, r127 ? 1 : 0, r128);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r120 = null;
    L14:
        e = e;
        r124 = r112;
        r125 = r108;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r112 = "batch_load";
        r111 = "album";
        r114 = System.currentTimeMillis();
        b r129 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L35
        r102.L$0 = this;     // Catch: Exception -> L35
        r102.L$1 = "batch_load";     // Catch: Exception -> L35
        r102.L$2 = "album";     // Catch: Exception -> L35
        r102.I$0 = r100;     // Catch: Exception -> L35
        r102.I$1 = r101;     // Catch: Exception -> L35
        r102.I$2 = 0;     // Catch: Exception -> L35
        r102.J$0 = r114;     // Catch: Exception -> L35
        r102.label = 1;     // Catch: Exception -> L35
        Object r130 = r129.d(r100, r101, r102);     // Catch: Exception -> L35
        if (r130 != r105) goto L22;
        return r105;
    L22:
        r115 = this;
        r116 = r130;
        r117 = 0;
    L35:
        e = e;
        r113 = this;
        r124 = "batch_load";
        r107 = r114;
        r125 = 0;
    L7:
        r102 = new AlbumDataBaseHelper$selectMediaDataListByPage$1(this, r212);
        goto L8
    }

    public final Object w(long r210, String r211, Continuation<? super ThumbnailMetadata> r212) {
        String r100 = r211;
        if ((r212 instanceof AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1 r101 = (AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$1;
        int r107 = r101.I$0;
        long r110 = r101.J$0;
        String r108 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        String r109 = r111;
        AlbumDataBaseHelper r213 = r112;
    L48:
        i r113 = (i) r103;     // Catch: Exception -> L37
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectThumbnailDataByImageUuidAndSn: imageUuid=" + r110 + ", sn=" + r100 + ", result=" + r113);     // Catch: Exception -> L37
        if (r113 == null) goto L26;
        Object r114 = b(f292393a, r113);     // Catch: Exception -> L37
    L28:
        if ((r114 instanceof List) == false) goto L30;
        int r115 = ((List) r114).size();     // Catch: Exception -> L37
    L31:
        long r116 = System.currentTimeMillis() - r106;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r214 = 1;
    L35:
        r213.getClass();     // Catch: Exception -> L37
        l(r109, r108, r115, r116, 1, r214, "");     // Catch: Exception -> L37
        return r114;
    L34:
        r214 = 0;
        goto L35
    L30:
        r115 = r107;
        goto L31
    L26:
        r114 = null;
    L37:
        e = e;
        String r117 = r109;
        int r118 = r107;
        String r119 = r108;
        r112 = r213;
    L41:
        long r120 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r121 = GalleryStoragePolicyManager.m();
        String r122 = e.getMessage();
        if (r122 != null) goto L44;
        r122 = "";
    L44:
        r112.getClass();
        l(r117, r119, r118, r120, 0, r121 ? 1 : 0, r122);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r119 = r108;
        r117 = r111;
        r118 = r107;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r108 = "album_thumbnail";
        long r123 = System.currentTimeMillis();
        j r124 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L39
        r101.L$0 = r100;     // Catch: Exception -> L39
        r101.L$1 = this;     // Catch: Exception -> L39
        r101.L$2 = "get_one";     // Catch: Exception -> L39
        r101.L$3 = "album_thumbnail";     // Catch: Exception -> L39
        r101.J$0 = r210;     // Catch: Exception -> L39
        r101.I$0 = 1;     // Catch: Exception -> L39
        r101.J$1 = r123;     // Catch: Exception -> L39
        r101.label = 1;     // Catch: Exception -> L39
        r103 = r124.b(r210, r100, r101);     // Catch: Exception -> L39
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r213 = this;
        r109 = "get_one";
        r107 = 1;
        r106 = r123;
        r110 = r210;
    L39:
        e = e;
        r112 = this;
        r106 = r123;
        r117 = "get_one";
        r118 = 1;
        r119 = "album_thumbnail";
    L7:
        r101 = new AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1(this, r212);
        goto L8
    }

    public final Object x(List<Long> r210, String r211, Continuation<? super List<ThumbnailMetadata>> r212) {
        List<Long> r100 = r210;
        String r101 = r211;
        if ((r212 instanceof AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1 r102 = (AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        long r107 = r102.J$0;
        int r108 = r102.I$0;
        String r110 = (String) r102.L$4;
        String r111 = (String) r102.L$3;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r102.L$2;
        String r109 = (String) r102.L$1;
        List<Long> r113 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L14
        String r114 = r110;
        String r115 = r111;
        AlbumDataBaseHelper r213 = r112;
        r101 = r109;
        r100 = r113;
        Object r116 = r104;
        int r117 = r108;
    L49:
        List r118 = (List) r116;     // Catch: Exception -> L33
        FLogger.f375446a.i("AlbumDataBaseHelper", "selectThumbnailDataListByImageUuidsAndSn: imageUuids=" + r100 + ", sn=" + r101 + ", result=" + r118);     // Catch: Exception -> L33
        List r119 = r118;     // Catch: Exception -> L33
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));     // Catch: Exception -> L33
        Iterator r121 = r119.iterator();     // Catch: Exception -> L33
    L25:
        if (r121.hasNext() == false) goto L27;
        r120.add(b(f292393a, (i) r121.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r122 = r120.size();     // Catch: Exception -> L33
        long r123 = System.currentTimeMillis() - r107;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r124 = 1;
    L31:
        r213.getClass();     // Catch: Exception -> L33
        l(r115, r114, r122, r123, 1, r124, "");     // Catch: Exception -> L33
    L42:
        if (r120 == null) goto L44;
        return r120;
    L44:
        return CollectionsKt.emptyList();
    L30:
        r124 = 0;
    L33:
        e = e;
        int r125 = r117;
        String r126 = r114;
        String r127 = r115;
    L38:
        long r128 = System.currentTimeMillis() - r107;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r129 = GalleryStoragePolicyManager.m();
        String r130 = e.getMessage();
        if (r130 != null) goto L41;
        r130 = "";
    L41:
        r213.getClass();
        l(r127, r126, r125, r128, 0, r129 ? 1 : 0, r130);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r120 = null;
    L14:
        e = e;
        r213 = r112;
        r125 = r108;
    L37:
        String r214 = r111;
        r126 = r110;
        r127 = r214;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r111 = "batch_load";
        r110 = "album_thumbnail";
        r117 = r210.size();
        long r131 = System.currentTimeMillis();
        j r132 = AlbumDatabase.f292395a.a().d();     // Catch: Exception -> L35
        r102.L$0 = r100;     // Catch: Exception -> L35
        r102.L$1 = r101;     // Catch: Exception -> L35
        r102.L$2 = this;     // Catch: Exception -> L35
        r102.L$3 = "batch_load";     // Catch: Exception -> L35
        r102.L$4 = "album_thumbnail";     // Catch: Exception -> L35
        r102.I$0 = r117;     // Catch: Exception -> L35
        r102.J$0 = r131;     // Catch: Exception -> L35
        r102.label = 1;     // Catch: Exception -> L35
        r116 = r132.d(r100, r101, r102);     // Catch: Exception -> L35
        if (r116 != r105) goto L22;
        return r105;
    L22:
        r213 = this;
        r114 = "album_thumbnail";
        r115 = "batch_load";
        r107 = r131;
    L35:
        e = e;
        r213 = this;
        r107 = r131;
        r125 = r117;
    L7:
        r102 = new AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1(this, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object z(String r210, MediaLifecycleState r211, String r212, Continuation<? super Unit> r310) {
        String r100 = r210;
        if ((r310 instanceof AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1) == false) goto L7;
        AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1 r101 = (AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1) r310;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r101.J$0;
        int r107 = r101.I$0;
        String r110 = (String) r101.L$5;
        String r111 = (String) r101.L$4;
        AlbumDataBaseHelper r112 = (AlbumDataBaseHelper) r101.L$3;
        String r108 = (String) r101.L$2;
        MediaLifecycleState r109 = (MediaLifecycleState) r101.L$1;
        String r113 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
        int r114 = r107;
        r100 = r113;
        String r115 = r108;
        AlbumDataBaseHelper r116 = r112;
    L77:
    L37:
        e = e;
        int r117 = r114;
        String r118 = r110;
        String r119 = r111;
    L46:
        long r120 = System.currentTimeMillis() - r106;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r213 = GalleryStoragePolicyManager.m();
        String r121 = e.getMessage();
        if (r121 != null) goto L49;
        String r214 = "";
    L50:
        r116.getClass();
        l(r119, r118, r117, r120, 0, r213 ? 1 : 0, r214);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r103 = null;
    L51:
        a r122 = (a) r103;
        if (r122 != null) goto L55;
        FLogger.f375446a.e("AlbumDataBaseHelper", "updateMediaDataLifecycleStateFailed: mediaMetadata not found, id=" + r100);
        return Unit.INSTANCE;
    L55:
        long r123 = System.currentTimeMillis();
        b r124 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L70
        if (r109 != MediaLifecycleState.FAILED) goto L59;
        Integer r125 = Boxing.boxInt(r122.f292416p);     // Catch: Exception -> L70
    L60:
        r122.f292417q = r125;     // Catch: Exception -> L70
        r122.f292416p = r109.getValue();     // Catch: Exception -> L70
        r122.f292418r = r115;     // Catch: Exception -> L70
        int r126 = r124.a(r122);     // Catch: Exception -> L70
        FLogger.f375446a.i("AlbumDataBaseHelper", "updateMediaDataLifecycleStateFailed: id=" + r100 + ", newState=" + r109 + ", failureReason=" + r115 + ", rows=" + r126);     // Catch: Exception -> L70
        Unit r127 = Unit.INSTANCE;     // Catch: Exception -> L70
        if ((r127 instanceof List) == false) goto L63;
        int r128 = ((List) r127).size();     // Catch: Exception -> L70
    L64:
        long r129 = System.currentTimeMillis() - r123;     // Catch: Exception -> L70
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L70
        if (GalleryStoragePolicyManager.m() == false) goto L67;
        int r130 = 1;
    L68:
        l("update", "album", r128, r129, 1, r130, "");     // Catch: Exception -> L70
        return r127;
    L67:
        r130 = 0;
        goto L68
    L63:
        r128 = 1;
        goto L64
    L59:
        r125 = null;
    L70:
        e = move-exception;
        long r131 = System.currentTimeMillis() - r123;
        GalleryStoragePolicyManager.f292721a.getClass();
        boolean r132 = GalleryStoragePolicyManager.m();
        String r133 = e.getMessage();
        if (r133 != null) goto L74;
        String r134 = "";
    L75:
        l("update", "album", 1, r131, 0, r132 ? 1 : 0, r134);
        FLogger.f375446a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L74:
        r134 = r133;
        goto L75
    L49:
        r214 = r121;
        goto L50
    L28:
        if ((r103 instanceof List) == false) goto L30;
        int r135 = ((List) r103).size();     // Catch: Exception -> L37
    L31:
        long r136 = System.currentTimeMillis() - r106;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.f292721a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r215 = 1;
    L35:
        r116.getClass();     // Catch: Exception -> L37
        l(r111, r110, r135, r136, 1, r215, "");     // Catch: Exception -> L37
        goto L51
    L34:
        r215 = 0;
        goto L35
    L30:
        r135 = r114;
    L14:
        e = e;
        r117 = r107;
        r100 = r113;
        r118 = r110;
        r119 = r111;
        r115 = r108;
        r116 = r112;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        r111 = "get_one";
        r110 = "album";
        long r137 = System.currentTimeMillis();
        b r138 = AlbumDatabase.f292395a.a().c();     // Catch: Exception -> L43
        r101.L$0 = r100;     // Catch: Exception -> L43
        r109 = r211;
        r101.L$1 = r109;     // Catch: Exception -> L41
        r115 = r212;
        r101.L$2 = r115;     // Catch: Exception -> L39
        r101.L$3 = this;     // Catch: Exception -> L39
        r101.L$4 = "get_one";     // Catch: Exception -> L39
        r101.L$5 = "album";     // Catch: Exception -> L39
        r101.I$0 = 1;     // Catch: Exception -> L39
        r101.J$0 = r137;     // Catch: Exception -> L39
        r101.label = 1;     // Catch: Exception -> L39
        r103 = r138.k(r100, r101);     // Catch: Exception -> L39
        if (r103 != r104) goto L26;
        return r104;
    L26:
        r106 = r137;
        r114 = 1;
        r116 = this;
    L39:
        e = e;
    L45:
        r106 = r137;
        r118 = "album";
        r119 = "get_one";
        r117 = 1;
        r116 = this;
    L41:
        e = e;
    L42:
        r115 = r212;
    L43:
        e = e;
        r109 = r211;
    L7:
        r101 = new AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1(this, r310);
        goto L8
    }

    public static void l(String r100, String r101, int r102, long r103, int r104, int r105, String r106) {
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("op", r100);
        r107.put(ComplianceConstants.ComplianceRequest.MARKET_STORE, r101);
        r107.put("count", Integer.valueOf(r102));
        r107.put("duration_ms", Long.valueOf(r103));
        r107.put("success", Integer.valueOf(r104));
        r107.put("db_transfered", Integer.valueOf(r105));
        r107.put("error_message", r106);
        IDoraService r108 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r108 == null) goto L6;
        r108.A0("flow_dora_album_data_op", r107);
        return;
    }
}
