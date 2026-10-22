package com.larus.avlink.gallery.model;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020CJ\u0006\u0010E\u001a\u00020CJ\u0006\u0010F\u001a\u00020CJ\u0006\u0010G\u001a\u00020\u0003J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030IJ\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030IJ\u001c\u0010K\u001a\u00020C2\b\u0010L\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010N\u001a\u00020\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u000bHÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u0011HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0017HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\u0098\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020C2\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\u000bHÖ\u0001J\t\u0010m\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010#R\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-¨\u0006n"}, d2 = {"Lcom/larus/avlink/gallery/model/MediaMetadata;", "Ljava/io/Serializable;", "uniqId", "", "mediaId", "", "systemGalleryId", "fileName", "fileSize", "mediaType", "width", "", "height", "duration", "outVideoWidth", "outVideoHeight", "outputVideoCrop", "", "createTime", "geoLocationInfo", "Lcom/larus/platform/model/GeoLocationInfo;", "algorithmType", "lifecycleState", "Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "failureStage", "failureReason", "downloadFilePath", "tempFilePath", "unpackDirPath", "processedFilePath", "finalFilePath", "activeMask", "<init>", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;IIJIIDJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getUniqId", "()Ljava/lang/String;", "getMediaId", "()J", "getSystemGalleryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "getFileSize", "getMediaType", "getWidth", "()I", "getHeight", "getDuration", "getOutVideoWidth", "getOutVideoHeight", "getOutputVideoCrop", "()D", "getCreateTime", "getGeoLocationInfo", "()Lcom/larus/platform/model/GeoLocationInfo;", "getAlgorithmType", "getLifecycleState", "()Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "getFailureStage", "getFailureReason", "getDownloadFilePath", "getTempFilePath", "getUnpackDirPath", "getProcessedFilePath", "getFinalFilePath", "getActiveMask", "isCompleted", "", "isFailed", "isSyncedToSystemAlbum", "isInProgress", "getCurrentFilePath", "getAllFilePaths", "", "getObsoleteFilePaths", "isSamePath", "path", "otherPath", "getFilePath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;IIJIIDJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/larus/avlink/gallery/model/MediaMetadata;", "equals", "other", "", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaMetadata implements Serializable {
    public static final int $stable = 8;
    private final int activeMask;
    private final String algorithmType;
    private final long createTime;
    private final String downloadFilePath;
    private final long duration;
    private final String failureReason;
    private final MediaLifecycleState failureStage;
    private final String fileName;
    private final Long fileSize;
    private final String finalFilePath;
    private final GeoLocationInfo geoLocationInfo;
    private final int height;
    private final MediaLifecycleState lifecycleState;
    private final long mediaId;
    private final String mediaType;
    private final int outVideoHeight;
    private final int outVideoWidth;
    private final double outputVideoCrop;
    private final String processedFilePath;
    private final Long systemGalleryId;
    private final String tempFilePath;
    private final String uniqId;
    private final String unpackDirPath;
    private final int width;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292620a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f292620a = r100;
        }
    }

    public static /* synthetic */ MediaMetadata copy$default(MediaMetadata r110, String r111, long r112, Long r210, String r211, Long r212, String r213, int r214, int r215, long r216, int r217, int r310, double r311, long r312, GeoLocationInfo r313, String r314, MediaLifecycleState r315, MediaLifecycleState r316, String r317, String r410, String r411, String r412, String r413, String r414, int r415, int r416, Object r417) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = r110.uniqId;
    L7:
        if ((r416 & 2) == 0) goto L9;
        long r101 = r110.mediaId;
    L11:
        if ((r416 & 4) == 0) goto L13;
        Long r102 = r110.systemGalleryId;
    L15:
        if ((r416 & 8) == 0) goto L17;
        String r103 = r110.fileName;
    L19:
        if ((r416 & 16) == 0) goto L21;
        Long r104 = r110.fileSize;
    L23:
        if ((r416 & 32) == 0) goto L25;
        String r105 = r110.mediaType;
    L27:
        if ((r416 & 64) == 0) goto L29;
        int r106 = r110.width;
    L31:
        if ((r416 & 128) == 0) goto L33;
        int r113 = r110.height;
    L35:
        if ((r416 & 256) == 0) goto L37;
        long r114 = r110.duration;
    L39:
        if ((r416 & 512) == 0) goto L41;
        int r115 = r110.outVideoWidth;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        int r116 = r110.outVideoHeight;
    L46:
        int r318 = r116;
        if ((r416 & 2048) == 0) goto L49;
        double r117 = r110.outputVideoCrop;
    L50:
        double r319 = r117;
        if ((r416 & 4096) == 0) goto L53;
        long r118 = r110.createTime;
    L54:
        long r320 = r118;
        if ((r416 & 8192) == 0) goto L57;
        GeoLocationInfo r119 = r110.geoLocationInfo;
    L59:
        if ((r416 & 16384) == 0) goto L61;
        String r120 = r110.algorithmType;
    L62:
        String r321 = r120;
        if ((r416 & 32768) == 0) goto L65;
        MediaLifecycleState r121 = r110.lifecycleState;
    L66:
        MediaLifecycleState r322 = r121;
        if ((r416 & 65536) == 0) goto L69;
        MediaLifecycleState r122 = r110.failureStage;
    L70:
        MediaLifecycleState r323 = r122;
        if ((r416 & 131072) == 0) goto L73;
        String r123 = r110.failureReason;
    L74:
        String r324 = r123;
        if ((r416 & 262144) == 0) goto L77;
        String r124 = r110.downloadFilePath;
    L78:
        String r418 = r124;
        if ((r416 & 524288) == 0) goto L81;
        String r125 = r110.tempFilePath;
    L82:
        String r419 = r125;
        if ((r416 & 1048576) == 0) goto L85;
        String r126 = r110.unpackDirPath;
    L86:
        String r420 = r126;
        if ((r416 & 2097152) == 0) goto L89;
        String r127 = r110.processedFilePath;
    L90:
        String r421 = r127;
        if ((r416 & 4194304) == 0) goto L93;
        String r128 = r110.finalFilePath;
    L95:
        if ((r416 & 8388608) == 0) goto L97;
        int r107 = r110.activeMask;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r318, r319, r320, r119, r321, r322, r323, r324, r418, r419, r420, r421, r128, r107);
    L97:
        r107 = r415;
        goto L99
    L93:
        r128 = r414;
        goto L95
    L89:
        r127 = r413;
        goto L90
    L85:
        r126 = r412;
        goto L86
    L81:
        r125 = r411;
        goto L82
    L77:
        r124 = r410;
        goto L78
    L73:
        r123 = r317;
        goto L74
    L69:
        r122 = r316;
        goto L70
    L65:
        r121 = r315;
        goto L66
    L61:
        r120 = r314;
        goto L62
    L57:
        r119 = r313;
        goto L59
    L53:
        r118 = r312;
        goto L54
    L49:
        r117 = r311;
        goto L50
    L45:
        r116 = r310;
        goto L46
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.uniqId;
    }

    public final int component10() {
        return this.outVideoWidth;
    }

    public final int component11() {
        return this.outVideoHeight;
    }

    public final double component12() {
        return this.outputVideoCrop;
    }

    public final long component13() {
        return this.createTime;
    }

    public final GeoLocationInfo component14() {
        return this.geoLocationInfo;
    }

    public final String component15() {
        return this.algorithmType;
    }

    public final MediaLifecycleState component16() {
        return this.lifecycleState;
    }

    public final MediaLifecycleState component17() {
        return this.failureStage;
    }

    public final String component18() {
        return this.failureReason;
    }

    public final String component19() {
        return this.downloadFilePath;
    }

    public final long component2() {
        return this.mediaId;
    }

    public final String component20() {
        return this.tempFilePath;
    }

    public final String component21() {
        return this.unpackDirPath;
    }

    public final String component22() {
        return this.processedFilePath;
    }

    public final String component23() {
        return this.finalFilePath;
    }

    public final int component24() {
        return this.activeMask;
    }

    public final Long component3() {
        return this.systemGalleryId;
    }

    public final String component4() {
        return this.fileName;
    }

    public final Long component5() {
        return this.fileSize;
    }

    public final String component6() {
        return this.mediaType;
    }

    public final int component7() {
        return this.width;
    }

    public final int component8() {
        return this.height;
    }

    public final long component9() {
        return this.duration;
    }

    public final MediaMetadata copy(String r310, long r311, Long r312, String r313, Long r314, String r315, int r316, int r410, long r411, int r412, int r413, double r414, long r415, GeoLocationInfo r416, String r510, MediaLifecycleState r511, MediaLifecycleState r512, String r513, String r514, String r515, String r516, String r517, String r518, int r519) {
        Intrinsics.checkNotNullParameter(r310, "uniqId");
        Intrinsics.checkNotNullParameter(r511, "lifecycleState");
        return new MediaMetadata(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaMetadata) == true) goto L8;
        return false;
    L8:
        MediaMetadata r101 = (MediaMetadata) r100;
        if (Intrinsics.areEqual(this.uniqId, r101.uniqId) == true) goto L12;
        return false;
    L12:
        if (this.mediaId == r101.mediaId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.systemGalleryId, r101.systemGalleryId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L27;
        return false;
    L27:
        if (this.width == r101.width) goto L30;
        return false;
    L30:
        if (this.height == r101.height) goto L33;
        return false;
    L33:
        if (this.duration == r101.duration) goto L36;
        return false;
    L36:
        if (this.outVideoWidth == r101.outVideoWidth) goto L39;
        return false;
    L39:
        if (this.outVideoHeight == r101.outVideoHeight) goto L42;
        return false;
    L42:
        if (Double.compare(this.outputVideoCrop, r101.outputVideoCrop) == 0) goto L45;
        return false;
    L45:
        if (this.createTime == r101.createTime) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.geoLocationInfo, r101.geoLocationInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.algorithmType, r101.algorithmType) == true) goto L54;
        return false;
    L54:
        if (this.lifecycleState == r101.lifecycleState) goto L57;
        return false;
    L57:
        if (this.failureStage == r101.failureStage) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.failureReason, r101.failureReason) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.downloadFilePath, r101.downloadFilePath) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.tempFilePath, r101.tempFilePath) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.unpackDirPath, r101.unpackDirPath) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.processedFilePath, r101.processedFilePath) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.finalFilePath, r101.finalFilePath) == true) goto L78;
        return false;
    L78:
        if (this.activeMask == r101.activeMask) goto L80;
        return false;
    L80:
        return true;
    }

    public final List<String> getAllFilePaths() {
        String[] r100 = new String[6];
        boolean r101 = false;
        r100[0] = this.downloadFilePath;
        r100[1] = this.tempFilePath;
        r100[2] = this.unpackDirPath;
        r100[3] = this.processedFilePath;
        r100[4] = this.finalFilePath;
        String r102 = getFilePath();
        if (r102.length() <= 0) goto L5;
        r101 = true;
    L5:
        if (r101 == true) goto L8;
        r102 = null;
    L8:
        r100[5] = r102;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r100));
    }

    public int hashCode() {
        int r100 = this.uniqId.hashCode() * 31;
        long r101 = this.mediaId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.systemGalleryId;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.fileName;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.fileSize;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mediaType;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (((((r112 + r114) * 31) + this.width) * 31) + this.height) * 31;
        long r116 = this.duration;
        int r117 = (((((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.outVideoWidth) * 31) + this.outVideoHeight) * 31;
        long r118 = Double.doubleToLongBits(this.outputVideoCrop);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.createTime;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        GeoLocationInfo r122 = this.geoLocationInfo;
        if (r122 != null) goto L21;
        int r123 = 0;
    L22:
        int r124 = (r121 + r123) * 31;
        String r125 = this.algorithmType;
        if (r125 != null) goto L25;
        int r126 = 0;
    L26:
        int r127 = (((r124 + r126) * 31) + this.lifecycleState.hashCode()) * 31;
        MediaLifecycleState r128 = this.failureStage;
        if (r128 != null) goto L29;
        int r129 = 0;
    L30:
        int r130 = (r127 + r129) * 31;
        String r131 = this.failureReason;
        if (r131 != null) goto L33;
        int r132 = 0;
    L34:
        int r133 = (r130 + r132) * 31;
        String r134 = this.downloadFilePath;
        if (r134 != null) goto L37;
        int r135 = 0;
    L38:
        int r136 = (r133 + r135) * 31;
        String r137 = this.tempFilePath;
        if (r137 != null) goto L41;
        int r138 = 0;
    L42:
        int r139 = (r136 + r138) * 31;
        String r140 = this.unpackDirPath;
        if (r140 != null) goto L45;
        int r141 = 0;
    L46:
        int r142 = (r139 + r141) * 31;
        String r143 = this.processedFilePath;
        if (r143 != null) goto L49;
        int r144 = 0;
    L50:
        int r145 = (r142 + r144) * 31;
        String r146 = this.finalFilePath;
        if (r146 == null) goto L55;
        r104 = r146.hashCode();
    L55:
        return ((r145 + r104) * 31) + this.activeMask;
    L49:
        r144 = r143.hashCode();
        goto L50
    L45:
        r141 = r140.hashCode();
        goto L46
    L41:
        r138 = r137.hashCode();
        goto L42
    L37:
        r135 = r134.hashCode();
        goto L38
    L33:
        r132 = r131.hashCode();
        goto L34
    L29:
        r129 = r128.hashCode();
        goto L30
    L25:
        r126 = r125.hashCode();
        goto L26
    L21:
        r123 = r122.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaMetadata(uniqId=" + this.uniqId + ", mediaId=" + this.mediaId + ", systemGalleryId=" + this.systemGalleryId + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mediaType=" + this.mediaType + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", outVideoWidth=" + this.outVideoWidth + ", outVideoHeight=" + this.outVideoHeight + ", outputVideoCrop=" + this.outputVideoCrop + ", createTime=" + this.createTime + ", geoLocationInfo=" + this.geoLocationInfo + ", algorithmType=" + this.algorithmType + ", lifecycleState=" + this.lifecycleState + ", failureStage=" + this.failureStage + ", failureReason=" + this.failureReason + ", downloadFilePath=" + this.downloadFilePath + ", tempFilePath=" + this.tempFilePath + ", unpackDirPath=" + this.unpackDirPath + ", processedFilePath=" + this.processedFilePath + ", finalFilePath=" + this.finalFilePath + ", activeMask=" + this.activeMask + ')';
    }

    public final String getCurrentFilePath() {
        String r100 = null;
        switch(a.f292620a[this.lifecycleState.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        String r101 = null;
    L13:
        if (r101 != null) goto L15;
    L17:
        String r102 = getFilePath();
        boolean r103 = true;
        if (r102.length() <= 0) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == true) goto L23;
    L25:
        String[] r105 = new String[6];
        r105[0] = this.finalFilePath;
        r105[1] = this.processedFilePath;
        r105[2] = this.tempFilePath;
        r105[3] = this.downloadFilePath;
        r105[4] = this.unpackDirPath;
        if (r102.length() > 0) goto L29;
        r103 = false;
    L29:
        if (r103 == false) goto L31;
        r100 = r102;
    L31:
        r105[5] = r100;
        Iterator r106 = CollectionsKt.listOfNotNull(r105).iterator();
    L33:
        if (r106.hasNext() == false) goto L40;
        String r107 = (String) r106.next();
        if (new PolarisFileWrapper(r107).exists() == false) goto L33;
        if (Intrinsics.areEqual(r107, r101) == true) goto L39;
        FLogger.f375446a.w("MediaMetadata", "File found at unexpected path for " + this.uniqId + ": expected=" + r101 + ", actual=" + r107);
    L39:
        return r107;
    L40:
        if (r101 == null) goto L42;
        return r101;
    L42:
        return r102;
    L23:
        if (new PolarisFileWrapper(r102).exists() == false) goto L25;
        return r102;
    L20:
        r104 = false;
        goto L21
    L15:
        if (new PolarisFileWrapper(r101).exists() == false) goto L17;
        return r101;
    L7:
        r101 = this.finalFilePath;
        goto L13
    L8:
        r101 = this.processedFilePath;
        goto L13
    L9:
        r101 = this.processedFilePath;
        goto L13
    L10:
        r101 = this.tempFilePath;
        goto L13
    L11:
        r101 = this.tempFilePath;
        goto L13
    L12:
        r101 = this.downloadFilePath;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String getFilePath() {
        MediaLifecycleState r100 = this.lifecycleState;
        switch(a.f292620a[r100.ordinal()]) {
            case 1: goto L23;
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L12;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L23;
            default: goto L5;
        };
    L6:
        String r101 = this.finalFilePath;
        if (r101 != null) goto L22;
        return "";
    L22:
        return r101;
    L9:
        r101 = this.processedFilePath;
        if (r101 != null) goto L22;
        return "";
    L12:
        r101 = this.processedFilePath;
        if (r101 != null) goto L22;
        return "";
    L15:
        r101 = this.tempFilePath;
        if (r101 != null) goto L22;
        return "";
    L18:
        r101 = this.tempFilePath;
        if (r101 != null) goto L22;
        return "";
    L23:
        return "";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final List<String> getObsoleteFilePaths() {
        switch(a.f292620a[this.lifecycleState.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        List r100 = CollectionsKt.emptyList();
    L13:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L15:
        if (r102.hasNext() == false) goto L48;
        Object r103 = r102.next();
        String r104 = (String) r103;
        String r105 = this.downloadFilePath;
        if (r104 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == true) goto L44;
        if (r105 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == true) goto L44;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r104);
        PolarisFileWrapper r109 = new PolarisFileWrapper(r105);
        if (Intrinsics.areEqual(r108.getAbsolutePath(), r109.getAbsolutePath()) == false) goto L49;
    L45:
        boolean r110 = true;
    L46:
        if (r110 == true) goto L15;
        r101.add(r103);
        goto L15
    L49:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L36
        Object r112 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r108.getCanonicalPath(), r109.getCanonicalPath())));     // Catch: Throwable -> L36
    L38:
        Boolean r113 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r112) == false) goto L42;
        r112 = r113;
    L42:
        if (((Boolean) r112).booleanValue() == false) goto L44;
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L26:
        if (r105.length() == 0) goto L29;
        r107 = false;
    L44:
        r110 = false;
        goto L46
    L19:
        if (r104.length() == 0) goto L22;
        r106 = false;
        goto L23
    L48:
        return r101;
    L7:
        r100 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath, this.processedFilePath});
        goto L13
    L8:
        r100 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath});
        goto L13
    L9:
        r100 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath});
        goto L13
    L10:
        r100 = CollectionsKt.emptyList();
        goto L13
    L11:
        r100 = CollectionsKt.emptyList();
        goto L13
    L12:
        r100 = CollectionsKt.emptyList();
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isCompleted() {
        if (this.lifecycleState != MediaLifecycleState.COMPLETED) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFailed() {
        if (this.lifecycleState != MediaLifecycleState.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInProgress() {
        MediaLifecycleState r100 = this.lifecycleState;
        if (r100 != MediaLifecycleState.COMPLETED) goto L5;
    L7:
        return false;
    L5:
        if (r100 == MediaLifecycleState.FAILED) goto L7;
        return true;
    }

    public final boolean isSyncedToSystemAlbum() {
        if (this.lifecycleState != MediaLifecycleState.COMPLETED) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getActiveMask() {
        return this.activeMask;
    }

    public final String getAlgorithmType() {
        return this.algorithmType;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final MediaLifecycleState getFailureStage() {
        return this.failureStage;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getFinalFilePath() {
        return this.finalFilePath;
    }

    public final GeoLocationInfo getGeoLocationInfo() {
        return this.geoLocationInfo;
    }

    public final int getHeight() {
        return this.height;
    }

    public final MediaLifecycleState getLifecycleState() {
        return this.lifecycleState;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final int getOutVideoHeight() {
        return this.outVideoHeight;
    }

    public final int getOutVideoWidth() {
        return this.outVideoWidth;
    }

    public final double getOutputVideoCrop() {
        return this.outputVideoCrop;
    }

    public final String getProcessedFilePath() {
        return this.processedFilePath;
    }

    public final Long getSystemGalleryId() {
        return this.systemGalleryId;
    }

    public final String getTempFilePath() {
        return this.tempFilePath;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final String getUnpackDirPath() {
        return this.unpackDirPath;
    }

    public final int getWidth() {
        return this.width;
    }

    public MediaMetadata(String r100, long r101, Long r102, String r110, Long r111, String r112, int r113, int r114, long r115, int r116, int r117, double r118, long r210, GeoLocationInfo r211, String r212, MediaLifecycleState r213, MediaLifecycleState r214, String r215, String r216, String r217, String r310, String r311, String r312, int r313) {
        Intrinsics.checkNotNullParameter(r100, "uniqId");
        Intrinsics.checkNotNullParameter(r213, "lifecycleState");
        this.uniqId = r100;
        this.mediaId = r101;
        this.systemGalleryId = r102;
        this.fileName = r110;
        this.fileSize = r111;
        this.mediaType = r112;
        this.width = r113;
        this.height = r114;
        this.duration = r115;
        this.outVideoWidth = r116;
        this.outVideoHeight = r117;
        this.outputVideoCrop = r118;
        this.createTime = r210;
        this.geoLocationInfo = r211;
        this.algorithmType = r212;
        this.lifecycleState = r213;
        this.failureStage = r214;
        this.failureReason = r215;
        this.downloadFilePath = r216;
        this.tempFilePath = r217;
        this.unpackDirPath = r310;
        this.processedFilePath = r311;
        this.finalFilePath = r312;
        this.activeMask = r313;
    }

    public /* synthetic */ MediaMetadata(String r310, long r311, Long r312, String r313, Long r410, String r411, int r412, int r413, long r414, int r415, int r416, double r417, long r510, GeoLocationInfo r511, String r512, MediaLifecycleState r513, MediaLifecycleState r514, String r515, String r516, String r517, String r518, String r610, String r611, int r612, int r613, DefaultConstructorMarker r614) {
        if ((r613 & 4) == 0) goto L5;
        Long r100 = 0L;
    L7:
        if ((r613 & 8) == 0) goto L9;
        String r110 = "";
    L11:
        if ((r613 & 16) == 0) goto L13;
        Long r111 = 0L;
    L15:
        if ((r613 & 32) == 0) goto L17;
        String r112 = "image";
    L19:
        if ((r613 & 64) == 0) goto L21;
        int r113 = 3024;
    L23:
        if ((r613 & 128) == 0) goto L25;
        int r114 = MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC;
    L27:
        if ((r613 & 256) == 0) goto L29;
        long r115 = 0;
    L31:
        if ((r613 & 512) == 0) goto L33;
        int r116 = TECameraUtils.CAPTURE_NORMAL;
    L35:
        if ((r613 & 1024) == 0) goto L37;
        int r117 = 1440;
    L39:
        if ((r613 & 2048) == 0) goto L41;
        double r118 = 0.8d;
    L43:
        if ((r613 & 4096) == 0) goto L45;
        long r210 = System.currentTimeMillis();
    L47:
        if ((r613 & 8192) == 0) goto L49;
        GeoLocationInfo r211 = null;
    L51:
        if ((r613 & 16384) == 0) goto L53;
        String r212 = null;
    L55:
        if ((32768 & r613) == 0) goto L57;
        MediaLifecycleState r213 = MediaLifecycleState.DOWNLOAD;
    L59:
        if ((65536 & r613) == 0) goto L61;
        MediaLifecycleState r214 = null;
    L63:
        if ((131072 & r613) == 0) goto L65;
        String r215 = null;
    L67:
        if ((262144 & r613) == 0) goto L69;
        String r216 = null;
    L71:
        if ((524288 & r613) == 0) goto L73;
        String r217 = null;
    L75:
        if ((1048576 & r613) == 0) goto L77;
        String r314 = null;
    L79:
        if ((2097152 & r613) == 0) goto L81;
        String r315 = null;
    L83:
        if ((4194304 & r613) == 0) goto L85;
        String r316 = null;
    L87:
        if ((r613 & 8388608) == 0) goto L89;
        int r317 = 0;
    L90:
        this(r310, r311, r100, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r314, r315, r316, r317);
        return;
    L89:
        r317 = r612;
        goto L90
    L85:
        r316 = r611;
        goto L87
    L81:
        r315 = r610;
        goto L83
    L77:
        r314 = r518;
        goto L79
    L73:
        r217 = r517;
        goto L75
    L69:
        r216 = r516;
        goto L71
    L65:
        r215 = r515;
        goto L67
    L61:
        r214 = r514;
        goto L63
    L57:
        r213 = r513;
        goto L59
    L53:
        r212 = r512;
        goto L55
    L49:
        r211 = r511;
        goto L51
    L45:
        r210 = r510;
        goto L47
    L41:
        r118 = r417;
        goto L43
    L37:
        r117 = r416;
        goto L39
    L33:
        r116 = r415;
        goto L35
    L29:
        r115 = r414;
        goto L31
    L25:
        r114 = r413;
        goto L27
    L21:
        r113 = r412;
        goto L23
    L17:
        r112 = r411;
        goto L19
    L13:
        r111 = r410;
        goto L15
    L9:
        r110 = r313;
        goto L11
    L5:
        r100 = r312;
        goto L7
    }
}
