package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceSignUrlData;
import com.larus.bmhome.rc.ResourceSignUrlDataV2;
import com.larus.bmhome.rc.ResourceSignUrlParamV2;
import com.larus.bmhome.rc.SignUrlMode;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class NestedFileDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NestedFileDownloader f305412a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f305413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f305414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f305415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f305416d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f305413a == r101.f305413a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f305414b, r101.f305414b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f305415c, r101.f305415c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f305416d, r101.f305416d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f305413a * 31;
            Integer r101 = this.f305414b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f305415c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f305416d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "DownloadResult(resultCode=" + this.f305413a + ", errorCode=" + this.f305414b + ", errorMessage=" + this.f305415c + ", filePath=" + this.f305416d + ')';
        }

        public a(int r100, Integer r101, String r102, String r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            this.f305413a = r100;
            this.f305414b = r101;
            this.f305415c = r102;
            this.f305416d = r103;
        }
    }

    public static final class b extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f305417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<lr8.g> f305418b;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onCanceled(DownloadInfo r110) {
            FLogger.f375446a.i("NestedFileDownloader", "fileName :" + this.f305417a + " download onCanceled");
            this.f305418b.resumeWith(Result.m9449constructorimpl(new lr8.g(2003, null, null, null, null, null, null, null, null, 510)));
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo r100) {
            FLogger.f375446a.i("NestedFileDownloader", "fileName: " + this.f305417a + " download onStart");
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r110) {
            FLogger.f375446a.i("NestedFileDownloader", "fileName: " + this.f305417a + " download onSuccess");
            kotlinx.coroutines.i<lr8.g> r100 = this.f305418b;
            Result.Companion r101 = Result.Companion;
            if (r110 == null) goto L5;
            String r111 = r110.getTargetFilePath();
        L6:
            r100.resumeWith(Result.m9449constructorimpl(new lr8.g(0, null, null, null, null, null, null, r111, null, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300)));
            return;
        L5:
            r111 = null;
            goto L6
        }

        public b(String r100, kotlinx.coroutines.j r101) {
            this.f305417a = r100;
            this.f305418b = r101;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r110, BaseException r111) {
            FLogger.f375446a.i("NestedFileDownloader", "fileName: " + this.f305417a + " download onFailed");
            kotlinx.coroutines.i<lr8.g> r112 = this.f305418b;
            Result.Companion r100 = Result.Companion;
            if (r111 == null) goto L5;
            Integer r101 = Integer.valueOf(r111.getErrorCode());
        L6:
            if (r111 == null) goto L8;
            String r102 = r111.getErrorMessage();
        L9:
            r112.resumeWith(Result.m9449constructorimpl(new lr8.g(2002, null, null, null, null, r101, r102, null, null, 414)));
            return;
        L8:
            r102 = null;
            goto L9
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        f305412a = new NestedFileDownloader();
    }

    public NestedFileDownloader() {
    }

    public final Object a(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof NestedFileDownloader$applyWatermarkOrFallback$1) == false) goto L7;
        NestedFileDownloader$applyWatermarkOrFallback$1 r100 = (NestedFileDownloader$applyWatermarkOrFallback$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r104 = null;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        WatermarkPerfLogger.a r113 = (WatermarkPerfLogger.a) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
    L50:
        if ((r112 instanceof com.larus.platform.service.watermark.g.c) == false) goto L52;
        com.larus.platform.service.watermark.g.c r114 = (com.larus.platform.service.watermark.g.c) r112;     // Catch: Throwable -> L14
    L53:
        if (r114 == null) goto L55;
        String r115 = r114.f365855a;     // Catch: Throwable -> L14
    L56:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L14
    L62:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r116);
        if (r106 != null) goto L75;
        String r117 = (String) r116;
        r113.a("applyWatermarkToFileAsLocal");
        if (r117 == null) goto L67;
        WatermarkPerfLogger.Result r107 = WatermarkPerfLogger.Result.SUCCESS;
    L68:
        if (r117 != null) goto L70;
        r104 = "no_ready_local_file";
    L70:
        r113.b(r107, r104);
        if (r117 != null) goto L74;
        return r105;
    L74:
        return r117;
    L67:
        r107 = WatermarkPerfLogger.Result.FAIL;
        goto L68
    L75:
        FLogger.f375446a.w("NestedFileDownloader", "applyWatermarkOrFallback failed: " + r106);
        r113.b(WatermarkPerfLogger.Result.FAIL, r106.getClass().getSimpleName());
        return r105;
    L55:
        r115 = null;
        goto L56
    L52:
        r114 = null;
    L14:
        Throwable th10 = th;
        WatermarkPerfLogger.a r108 = r113;
    L61:
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r113 = r108;
        goto L62
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        if (r110 != null) goto L21;
    L77:
        return r110;
    L21:
        if (r110.length() <= 0) goto L23;
        boolean r119 = true;
    L24:
        if (r119 == false) goto L26;
        String r120 = r110;
    L27:
        if (r120 == null) goto L77;
        DownloadWatermarkService r121 = DownloadWatermarkService.f365700a;
        r121.getClass();
        if (DownloadWatermarkService.d() == true) goto L33;
        r121 = null;
    L33:
        int r109 = WatermarkPerfLogger.f365828a;
        if (r121 != null) goto L36;
        WatermarkPerfLogger.Version r122 = WatermarkPerfLogger.Version.PERSONAL;
    L37:
        DownloadWatermarkScene r123 = DownloadWatermarkScene.NESTED_FILE_DOWNLOAD;
        r108 = WatermarkPerfLogger.a("nested_file_download", r122, r123);
        if (r121 != null) goto L40;
        WatermarkPerfLogger.Path r124 = WatermarkPerfLogger.Path.NONE;
    L41:
        r108.c(r124);
        if (r121 != null) goto L80;
        r108.b(WatermarkPerfLogger.Result.SUCCESS, null);
        return r120;
    L80:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L59
        com.larus.platform.service.watermark.a r126 = new com.larus.platform.service.watermark.a(r120, MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast(r120, '.', "").toLowerCase(Locale.ROOT)), r123);     // Catch: Throwable -> L59
        r100.L$0 = r120;     // Catch: Throwable -> L59
        r100.L$1 = r108;     // Catch: Throwable -> L59
        r100.label = 1;     // Catch: Throwable -> L59
        Object r127 = r121.a(r126, r100);     // Catch: Throwable -> L59
        if (r127 != r102) goto L48;
        return r102;
    L48:
        r105 = r120;
        r112 = r127;
        r113 = r108;
    L59:
        th = move-exception;
        r105 = r120;
        th10 = th;
        goto L61
    L40:
        r124 = WatermarkPerfLogger.Path.B_FILE;
        goto L41
    L36:
        r122 = WatermarkPerfLogger.Version.ENTERPRISE;
        goto L37
    L26:
        r120 = null;
        goto L27
    L23:
        r119 = false;
    L7:
        r100 = new NestedFileDownloader$applyWatermarkOrFallback$1(this, r111);
        goto L8
    }

    public final Object f(UplinkFileInfo r110, Continuation<? super lr8.g> r111) {
        if ((r111 instanceof NestedFileDownloader$requireFileUrl$1) == false) goto L7;
        NestedFileDownloader$requireFileUrl$1 r100 = (NestedFileDownloader$requireFileUrl$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r112);
    L58:
        return r112;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r112);
    L54:
        return r112;
    L18:
        r110 = (UplinkFileInfo) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L44:
        if (((lr8.g) r112).f510465a != 0) goto L46;
        r104 = true;
    L46:
        if (r104 == true) goto L49;
        r112 = null;
    L49:
        r112 = (lr8.g) r112;
        if (r112 != null) goto L54;
        r100.L$0 = null;
        r100.label = 3;
        r112 = i(r110, r100);
        if (r112 != r102) goto L54;
        return r102;
    L19:
        r110 = (UplinkFileInfo) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        lr8.g r105 = (lr8.g) r112;
        if (r105.f510465a == 0) goto L34;
        Integer r106 = r105.f510466b;
        if (r106 != null) goto L31;
    L33:
        boolean r107 = false;
    L35:
        if (r107 == true) goto L38;
        r112 = null;
    L38:
        r112 = (lr8.g) r112;
        if (r112 != null) goto L54;
        r100.L$0 = r110;
        r100.label = 2;
        r112 = g(r110, r100);
        if (r112 != r102) goto L44;
        return r102;
    L31:
        if (r106.intValue() != 14007) goto L33;
    L34:
        r107 = true;
        goto L35
    L20:
        ResultKt.throwOnFailure(r112);
        ResourceCenter.f313541a.getClass();
        if (ResourceCenter.c() == false) goto L55;
        r100.L$0 = r110;
        r100.label = 1;
        r112 = h(r110, r100);
        if (r112 != r102) goto L25;
        return r102;
    L55:
        r100.label = 4;
        r112 = i(r110, r100);
        if (r112 != r102) goto L58;
        return r102;
    L7:
        r100 = new NestedFileDownloader$requireFileUrl$1(this, r111);
        goto L8
    }

    public final Object g(UplinkFileInfo r210, Continuation<? super lr8.g> r211) {
        if ((r211 instanceof NestedFileDownloader$requireFileUrlByResourceId$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByResourceId$1 r100 = (NestedFileDownloader$requireFileUrlByResourceId$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L35:
        ResourceSignUrlData r107 = (ResourceSignUrlData) ((Map) r102).get(r106);
        if (r107 == null) goto L38;
        String r108 = r107.getExternalUrl();
    L39:
        String r110 = r108;
        if (r110 != null) goto L42;
    L45:
        if (r105 == false) goto L47;
        FLogger.f375446a.w("NestedFileDownloader", "require file url by resource id error: url is empty");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L47:
        FLogger.f375446a.i("NestedFileDownloader", "require file url by resource id success, urlPresent=true");
        return new lr8.g(0, null, r110, Boxing.boxBoolean(false), null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
    L42:
        if (r110.length() == 0) goto L45;
        r105 = false;
        goto L45
    L38:
        r108 = null;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r109 = r210.getResourceId();
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("require file url by resource id, resourceIdPresent=");
        if (r109 != null) goto L17;
    L20:
        boolean r113 = true;
    L21:
        r112.append(!r113);
        r111.i("NestedFileDownloader", r112.toString());
        if (r109 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == false) goto L31;
        r111.w("NestedFileDownloader", "require file url by resource id error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L31:
        ResourceCenter r115 = ResourceCenter.f313541a;
        List<String> r116 = CollectionsKt.listOf(r109);
        SignUrlMode r117 = SignUrlMode.Outer;
        r100.L$0 = r109;
        r100.label = 1;
        Object r118 = r115.m(r116, r117, r100);
        if (r118 != r103) goto L34;
        return r103;
    L34:
        r106 = r109;
        r102 = r118;
        goto L35
    L24:
        if (r109.length() == 0) goto L27;
        r114 = false;
        goto L28
    L17:
        if (r109.length() == 0) goto L20;
        r113 = false;
    L7:
        r100 = new NestedFileDownloader$requireFileUrlByResourceId$1(this, r211);
        goto L8
    }

    public final Object h(UplinkFileInfo r210, Continuation<? super lr8.g> r211) {
        if ((r211 instanceof NestedFileDownloader$requireFileUrlByResourceIdV2$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByResourceIdV2$1 r100 = (NestedFileDownloader$requireFileUrlByResourceIdV2$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L60:
        ResourceSignUrlDataV2 r106 = (ResourceSignUrlDataV2) CollectionsKt.getOrNull((List) r102, 0);
        if (r106 == null) goto L68;
        Integer r107 = r106.getStatusCode();
        if (r107 == null) goto L68;
        if (r107.intValue() != 0) goto L68;
        boolean r108 = true;
    L69:
        if (r108 == true) goto L82;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("require file url by resource id v2 error: code: ");
        Integer r111 = null;
        if (r106 == null) goto L73;
        Integer r112 = r106.getStatusCode();
    L74:
        r110.append(r112);
        r110.append(", msg: ");
        if (r106 == null) goto L77;
        String r113 = r106.getMessage();
    L78:
        r110.append(r113);
        r109.w("NestedFileDownloader", r110.toString());
        if (r106 == null) goto L96;
        r111 = r106.getStatusCode();
    L96:
        return new lr8.g(1001, r111, null, null, null, null, null, null, null, 508);
    L77:
        r113 = null;
        goto L78
    L73:
        r112 = null;
        goto L74
    L82:
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("require file url by resource id v2 success, urlPresent=");
        String r116 = r106.getMainUrl();
        if (r116 != null) goto L85;
    L88:
        boolean r117 = true;
    L89:
        r115.append(!r117);
        r115.append(", isEncrypted=");
        r115.append(r106.isEncrypted());
        r115.append(", keyPresent=");
        String r118 = r106.getDecryptionKey();
        if (r118 != null) goto L92;
    L93:
        r105 = true;
    L94:
        r115.append(!r105);
        r114.i("NestedFileDownloader", r115.toString());
        return new lr8.g(0, null, r106.getMainUrl(), r106.isEncrypted(), r106.getDecryptionKey(), null, null, null, null, 482);
    L92:
        if (r118.length() != 0) goto L94;
    L85:
        if (r116.length() == 0) goto L88;
        r117 = false;
    L68:
        r108 = false;
        goto L69
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r119 = r210.getResourceId();
        String r120 = r210.getTosKey();
        FLogger r121 = FLogger.f375446a;
        StringBuilder r122 = new StringBuilder("require file url by resource id v2, resourceIdPresent=");
        if (r119 != null) goto L17;
    L20:
        boolean r123 = true;
    L21:
        r122.append(!r123);
        r122.append(", uriPresent=");
        if (r120 != null) goto L24;
    L27:
        boolean r124 = true;
    L28:
        r122.append(!r124);
        r121.i("NestedFileDownloader", r122.toString());
        if (r120 != null) goto L31;
    L34:
        boolean r125 = true;
    L35:
        if (r125 == false) goto L38;
        r121.w("NestedFileDownloader", "require file url by resource id v2 error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L38:
        ResourceCenter r126 = ResourceCenter.f313541a;
        Integer r127 = r210.getFileType();
        int r128 = FileType.FileTypeFile.getValue();
        if (r127 != null) goto L42;
    L44:
        int r129 = FileType.FileTypeAudio.getValue();
        if (r127 != null) goto L48;
    L50:
        int r130 = FileType.FileTypeVideo.getValue();
        if (r127 != null) goto L54;
    L56:
        FlowResourceType r131 = FlowResourceType.Unknown;
    L57:
        List<ResourceSignUrlParamV2> r132 = CollectionsKt.listOf(new ResourceSignUrlParamV2(r119, r120, Boxing.boxInt(r131.getValue())));
        r100.label = 1;
        r102 = r126.n(r132, true, r100);
        if (r102 != r103) goto L60;
        return r103;
    L54:
        if (r127.intValue() != r130) goto L56;
        r131 = FlowResourceType.Video;
        goto L57
    L48:
        if (r127.intValue() != r129) goto L50;
        r131 = FlowResourceType.Audio;
        goto L57
    L42:
        if (r127.intValue() != r128) goto L44;
        r131 = FlowResourceType.File;
        goto L57
    L31:
        if (r120.length() == 0) goto L34;
        r125 = false;
        goto L35
    L24:
        if (r120.length() == 0) goto L27;
        r124 = false;
        goto L28
    L17:
        if (r119.length() == 0) goto L20;
        r123 = false;
    L7:
        r100 = new NestedFileDownloader$requireFileUrlByResourceIdV2$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(UplinkFileInfo r210, Continuation<? super lr8.g> r211) {
        if ((r211 instanceof NestedFileDownloader$requireFileUrlByTosKey$1) == false) goto L7;
        NestedFileDownloader$requireFileUrlByTosKey$1 r100 = (NestedFileDownloader$requireFileUrlByTosKey$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L34:
        FileUrlRespData r106 = (FileUrlRespData) ((com.larus.network.http.a) r102).f360135b;
        if (r106 == null) goto L41;
        List<FileUrlData> r107 = r106.getFileUrlList();
        if (r107 == null) goto L41;
        FileUrlData r108 = (FileUrlData) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L41;
        String r109 = r108.getMainUrl();
    L42:
        String r110 = r109;
        if (r110 != null) goto L45;
    L48:
        if (r105 == false) goto L50;
        FLogger.f375446a.w("NestedFileDownloader", "require file url by tos key error: url is empty");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L50:
        FLogger.f375446a.i("NestedFileDownloader", "require file url by tos key success, urlPresent=true");
        return new lr8.g(0, null, r110, Boxing.boxBoolean(false), null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
    L45:
        if (r110.length() == 0) goto L48;
        r105 = false;
    L41:
        r109 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r111 = r210.getTosKey();
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("require file url by tos key, uriPresent=");
        if (r111 != null) goto L17;
    L20:
        boolean r114 = true;
    L21:
        r113.append(!r114);
        r112.i("NestedFileDownloader", r113.toString());
        if (r111 != null) goto L24;
    L27:
        boolean r115 = true;
    L28:
        if (r115 == false) goto L31;
        r112.w("NestedFileDownloader", "require file url by tos key error: illegal params");
        return new lr8.g(1001, null, null, null, null, null, null, null, null, 510);
    L31:
        Lazy<ChatApi> r116 = ChatApi.f297153a;
        ChatApi r117 = ChatApi.a.a();
        List r118 = CollectionsKt.listOf(r111);
        String r119 = UploadDataType.FILE.getType();
        r100.label = 1;
        r117.getClass();
        r102 = ChatApi.e(r118, r119, r100);
        if (r102 != r103) goto L34;
        return r103;
    L24:
        if (r111.length() == 0) goto L27;
        r115 = false;
        goto L28
    L17:
        if (r111.length() == 0) goto L20;
        r114 = false;
    L7:
        r100 = new NestedFileDownloader$requireFileUrlByTosKey$1(this, r211);
        goto L8
    }

    public final Object b(String r310, String r311, String r312, Continuation<? super lr8.g> r313) {
        if ((r313 instanceof NestedFileDownloader$decryptFile$1) == false) goto L7;
        NestedFileDownloader$decryptFile$1 r100 = (NestedFileDownloader$decryptFile$1) r313;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L52:
        String r110 = r105;
        int r106 = ((Number) r102).intValue();
    L54:
        if (r106 != 0) goto L56;
        FLogger.f375446a.i("NestedFileDownloader", "decrypt file success");
        return new lr8.g(0, null, null, null, null, null, null, null, r110, 254);
    L56:
        FLogger.f375446a.w("NestedFileDownloader", "decrypt file error: " + r106);
        return new lr8.g(r106, null, null, null, null, null, null, null, null, 510);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("decrypt file, keyPresent=");
        boolean r111 = false;
        if (r310.length() <= 0) goto L17;
        boolean r109 = true;
    L18:
        r108.append(r109);
        r108.append(", inputPresent=");
        if (r311 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        r108.append(!r112);
        r108.append(", outputPresent=");
        if (r312 != null) goto L28;
    L31:
        boolean r113 = true;
    L32:
        r108.append(!r113);
        r107.i("NestedFileDownloader", r108.toString());
        if (r311 != null) goto L35;
    L38:
        boolean r114 = true;
    L39:
        if (r114 == true) goto L58;
        if (r312 != null) goto L42;
    L43:
        r111 = true;
    L44:
        if (r111 == true) goto L58;
        IChatAzerothService r115 = com.larus.bmhome.x.a();
        if (r115 == null) goto L53;
        r100.L$0 = r312;
        r100.label = 1;
        r102 = r115.c(r310, r311, r312, r100);
        if (r102 != r103) goto L51;
        return r103;
    L51:
        r105 = r312;
        goto L52
    L53:
        r106 = 3001;
        r110 = r312;
        goto L54
    L42:
        if (r312.length() != 0) goto L44;
    L58:
        r107.w("NestedFileDownloader", "decrypt file error: illegal params");
        return new lr8.g(3002, null, null, null, null, null, null, null, null, 510);
    L35:
        if (r311.length() == 0) goto L38;
        r114 = false;
        goto L39
    L28:
        if (r312.length() == 0) goto L31;
        r113 = false;
        goto L32
    L21:
        if (r311.length() == 0) goto L24;
        r112 = false;
        goto L25
    L17:
        r109 = false;
    L7:
        r100 = new NestedFileDownloader$decryptFile$1(this, r313);
        goto L8
    }

    public static void e(String r100, int r101, Long r102, String r103, Integer r104) {
        JSONObject r105 = new JSONObject();
        r105.put("stage", r100);
        r105.put("result", r101);
        r105.put("duration", r102);
        r105.put("toskey", r103);
        r105.put("error_code", r104);
        com.larus.platform.service.o.f365780a.reportEvent("message_file_open_stage", r105);
    }

    public final Object c(Context r310, UplinkFileInfo r311, lr8.g r312, String r313, Continuation<? super a> r410) {
        UplinkFileInfo r100 = r311;
        if ((r410 instanceof NestedFileDownloader$download$1) == false) goto L7;
        NestedFileDownloader$download$1 r101 = (NestedFileDownloader$download$1) r410;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r111 = "get_url";
        String r112 = "full";
        switch(r101.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        int r104 = r101.I$0;
        ResultKt.throwOnFailure(r103);
        int r105 = r104;
    L152:
        return new a(r105, null, null, (String) r103, 6);
    L13:
        long r106 = r101.J$0;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = r110;
    L144:
        lr8.g r109 = (lr8.g) r103;
        int r113 = r109.f510465a;
        if (r113 == 0) goto L147;
        e("download", 1, null, r107, Boxing.boxInt(r113));
        e("full", 1, null, r107, Boxing.boxInt(r109.f510465a));
        return new a(r109.f510465a, r109.f510470f, r109.f510471g, null, 8);
    L147:
        e(r13, 0, null, r107, null);
        e(r112, 0, Boxing.boxLong(System.currentTimeMillis() - r106), r107, null);
        String r114 = r109.f510472h;
        r101.L$0 = null;
        r101.I$0 = 0;
        r101.label = 9;
        r103 = a(r114, r101);
        if (r103 != r108) goto L150;
        return r108;
    L150:
        r105 = 0;
        goto L152
    L14:
        int r115 = r101.I$0;
        ResultKt.throwOnFailure(r103);
        int r116 = r115;
    L135:
        return new a(r116, null, null, (String) r103, 6);
    L15:
        long r117 = r101.J$0;
        String r118 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r210 = "download";
        String r119 = "full";
        NestedFileDownloader r120 = this;
        Object r121 = r110;
    L127:
        lr8.g r122 = (lr8.g) r103;
        int r123 = r122.f510465a;
        if (r123 == 0) goto L130;
        e(r210, 1, null, r118, Boxing.boxInt(r123));
        e(r119, 1, null, r118, Boxing.boxInt(r122.f510465a));
        return new a(r122.f510465a, r122.f510470f, r122.f510471g, null, 8);
    L130:
        e(r210, 0, null, r118, null);
        e(r119, 0, Boxing.boxLong(System.currentTimeMillis() - r117), r118, null);
        String r124 = r122.f510472h;
        r101.L$0 = null;
        r101.I$0 = 0;
        r101.label = 7;
        r103 = r120.a(r124, r101);
        if (r103 != r121) goto L133;
        return r121;
    L133:
        r116 = 0;
        goto L135
    L16:
        long r125 = r101.J$0;
        r118 = (String) r101.L$3;
        String r126 = (String) r101.L$2;
        UplinkFileInfo r127 = (UplinkFileInfo) r101.L$1;
        Context r128 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r129 = r126;
        r111 = "get_url";
        r210 = "download";
        r119 = "full";
        r120 = this;
        r121 = r110;
        Context r130 = r128;
        long r131 = r125;
    L115:
        lr8.g r132 = (lr8.g) r103;
        int r133 = r132.f510465a;
        if (r133 == 0) goto L119;
        e(r111, 1, null, r118, Boxing.boxInt(r133));
        e(r119, 1, null, r118, Boxing.boxInt(r132.f510465a));
        return new a(1001, null, null, null, 14);
    L119:
        e(r111, 0, null, r118, null);
        String r134 = r132.f510467c;
        String r135 = r127.getFileName();
        if (r135 != null) goto L122;
        String r136 = "";
    L123:
        r101.L$0 = r118;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.J$0 = r131;
        r101.label = 6;
        r103 = d(r130, r134, r136, false, r129, r101);
        if (r103 != r121) goto L126;
        return r121;
    L126:
        r117 = r131;
        goto L127
    L122:
        r136 = r135;
        goto L123
    L17:
        int r137 = r101.I$0;
        ResultKt.throwOnFailure(r103);
        int r138 = r137;
    L110:
        return new a(r138, null, null, (String) r103, 6);
    L18:
        long r139 = r101.J$0;
        r118 = (String) r101.L$3;
        String r140 = (String) r101.L$2;
        UplinkFileInfo r141 = (UplinkFileInfo) r101.L$1;
        Context r142 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r211 = "NestedFileDownloader";
        r127 = r141;
        r210 = "download";
        r112 = "full";
        r120 = this;
        r121 = r110;
    L103:
        lr8.g r143 = (lr8.g) r103;
        if (r143.f510465a != 0) goto L111;
        e("decrypt_file", 0, null, r118, null);
        e(r112, 0, Boxing.boxLong(System.currentTimeMillis() - r139), r118, null);
        String r144 = r143.f510473i;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.I$0 = 0;
        r101.label = 4;
        r103 = r120.a(r144, r101);
        if (r103 != r121) goto L108;
        return r121;
    L108:
        r138 = 0;
        goto L110
    L111:
        r119 = r112;
        FLogger.f375446a.i(r211, "decrypt failed, downgrade to download non-encrypted file");
        e("decrypt_file", 1, null, r118, Boxing.boxInt(r143.f510465a));
        r101.L$0 = r142;
        r101.L$1 = r127;
        r101.L$2 = r140;
        r101.L$3 = r118;
        r101.J$0 = r139;
        r101.label = 5;
        r103 = r120.g(r127, r101);
        if (r103 != r121) goto L114;
        return r121;
    L114:
        r131 = r139;
        r129 = r140;
        r130 = r142;
        goto L115
    L19:
        long r145 = r101.J$0;
        lr8.g r146 = (lr8.g) r101.L$4;
        String r147 = (String) r101.L$3;
        String r148 = (String) r101.L$2;
        UplinkFileInfo r149 = (UplinkFileInfo) r101.L$1;
        Context r150 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r127 = r149;
        lr8.g r151 = r146;
        r118 = r147;
        long r152 = r145;
        Object r153 = r103;
    L68:
        lr8.g r154 = (lr8.g) r153;
        int r155 = r154.f510465a;
        if (r155 == 0) goto L72;
        e("download", 1, null, r118, Boxing.boxInt(r155));
        e("full", 1, null, r118, Boxing.boxInt(r154.f510465a));
        return new a(r154.f510465a, r154.f510470f, r154.f510471g, null, 8);
    L72:
        e("download", 0, null, r118, null);
        String r156 = r154.f510472h;
        if (r156 != null) goto L75;
    L78:
        boolean r157 = true;
    L79:
        if (r157 == false) goto L81;
        r110 = r110;
        r210 = "download";
        r112 = "full";
        r211 = "NestedFileDownloader";
        String r158 = "";
    L96:
        String r159 = r151.f510469e;
        if (r159 != null) goto L99;
        r159 = "";
    L99:
        String r160 = r154.f510472h;
        r101.L$0 = r150;
        r101.L$1 = r127;
        r101.L$2 = r148;
        r101.L$3 = r118;
        r101.L$4 = null;
        r101.J$0 = r152;
        r101.label = 3;
        r120 = this;
        r103 = r120.b(r159, r160, r158, r101);
        r121 = r110;
        if (r103 != r121) goto L102;
        return r121;
    L102:
        r139 = r152;
        r140 = r148;
        r142 = r150;
        goto L103
    L81:
        int r161 = StringsKt.lastIndexOf$default(r156, '/', 0, false, 6, null);
        r210 = "download";
        if (r161 != (-1)) goto L84;
    L94:
        r211 = r7;
    L95:
        r158 = r156;
        goto L96
    L84:
        if (r161 == (r156.length() - 1)) goto L94;
        int r162 = r161 + 1;
        r211 = r7;
        String r163 = r156.substring(0, r162);
        String r164 = r156.substring(r162);
        int r165 = StringsKt.lastIndexOf$default(r164, '.', 0, false, 6, null);
        if (r165 <= 0) goto L95;
        r112 = "full";
        String r166 = r164.substring(0, r165);
        String r167 = r164.substring(r165);
        r110 = r110;
        if (StringsKt.endsWith$default(r166, "_encrypted", false, 2, null) == false) goto L92;
        String r168 = StringsKt.removeSuffix(r166, "_encrypted") + r167;
    L93:
        r158 = r163 + r168;
        goto L96
    L92:
        r168 = r164;
        goto L93
    L75:
        if (r156.length() == 0) goto L78;
        r157 = false;
        goto L79
    L20:
        long r169 = r101.J$0;
        String r170 = (String) r101.L$3;
        String r171 = (String) r101.L$2;
        UplinkFileInfo r172 = (UplinkFileInfo) r101.L$1;
        Context r173 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r174 = r170;
        r100 = r172;
        String r175 = r171;
        Context r176 = r173;
        Object r177 = r103;
    L43:
        String r178 = r174;
        r151 = (lr8.g) r177;
    L44:
        long r314 = r169;
        String r179 = r175;
        int r180 = r151.f510465a;
        if (r180 == 0) goto L50;
        e("get_url", 1, null, r178, Boxing.boxInt(r180));
        e("full", 1, null, r178, Boxing.boxInt(r151.f510465a));
        return new a(1001, null, null, null, 14);
    L50:
        e("get_url", 0, null, r178, null);
        if (Intrinsics.areEqual(r151.f510468d, Boxing.boxBoolean(true)) == false) goto L136;
        String r181 = r151.f510469e;
        if (r181 != null) goto L55;
    L58:
        boolean r182 = true;
    L59:
        if (r182 == true) goto L136;
        FLogger.f375446a.i("NestedFileDownloader", "download and decrypt");
        String r183 = r151.f510467c;
        String r184 = r100.getFileName();
        if (r184 != null) goto L63;
        String r185 = "";
    L64:
        r101.L$0 = r176;
        r101.L$1 = r100;
        r101.L$2 = r179;
        r101.L$3 = r178;
        r101.L$4 = r151;
        r101.J$0 = r314;
        r101.label = 2;
        Context r186 = r176;
        Context r187 = r176;
        String r188 = r185;
        String r189 = r178;
        r153 = d(r186, r183, r188, true, r179, r101);
        if (r153 != r110) goto L67;
        return r110;
    L67:
        r150 = r187;
        r127 = r100;
        r118 = r189;
        r148 = r179;
        r152 = r314;
        goto L68
    L63:
        r185 = r184;
        goto L64
    L55:
        if (r181.length() == 0) goto L58;
        r182 = false;
    L136:
        Context r315 = r176;
        String r190 = r178;
        r108 = r110;
        FLogger.f375446a.i("NestedFileDownloader", "just download");
        String r191 = r151.f510467c;
        String r192 = r100.getFileName();
        if (r192 != null) goto L139;
        String r193 = "";
    L140:
        r101.L$0 = r190;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.J$0 = r314;
        r101.label = 8;
        Object r194 = d(r315, r191, r193, false, r179, r101);
        if (r194 != r108) goto L143;
        return r108;
    L143:
        r106 = r314;
        r103 = r194;
        r107 = r190;
        goto L144
    L139:
        r193 = r192;
        goto L140
    L21:
        ResultKt.throwOnFailure(r103);
        FLogger r195 = FLogger.f375446a;
        r195.i("NestedFileDownloader", "download start");
        FlowFileProtectionService r196 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r196 != null) goto L24;
    L26:
        boolean r197 = false;
    L27:
        if (r197 == false) goto L38;
        r195.i("NestedFileDownloader", "download blocked by enterprise file security");
        com.larus.platform.service.o r198 = com.larus.platform.service.o.f365780a;
        JSONObject r199 = new JSONObject();
        r199.put("action", "open_external");
        r199.put("entry", "nested_file_download");
        r199.put("content_type", "file");
        Unit r200 = Unit.INSTANCE;
        r198.reportEvent("flow_enterprise_file_egress_block", r199);
        String r201 = r196.A0();
        if (r201 == null) goto L37;
        if ((!StringsKt.isBlank(r201)) == false) goto L33;
        String r202 = r201;
    L34:
        if (r202 == null) goto L37;
        t19.s.j(t19.s.f544207a, r310, r202, null, false, 28);
        goto L37
    L33:
        r202 = null;
    L37:
        return new a(2004, null, null, null, 14);
    L38:
        r169 = System.currentTimeMillis();
        r174 = r311.getTosKey();
        if (r312 != null) goto L45;
        r176 = r310;
        r101.L$0 = r176;
        r101.L$1 = r100;
        r175 = r313;
        r101.L$2 = r175;
        r101.L$3 = r174;
        r101.J$0 = r169;
        r101.label = 1;
        r177 = f(r100, r101);
        if (r177 != r110) goto L43;
        return r110;
    L45:
        r176 = r310;
        r175 = r313;
        r178 = r174;
        r151 = r312;
        goto L44
    L24:
        if (r196.I0() != true) goto L26;
        r197 = true;
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new NestedFileDownloader$download$1(this, r410);
        goto L8
    }

    public static Object d(Context r110, String r210, String r211, boolean r212, String r213, Continuation r214) {
        boolean r100 = true;
        kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r214), 1);
        r101.C();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("download file, urlPresent=");
        if (r210 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        r103.append(!r104);
        r103.append(", fileNamePresent=");
        if (r211.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        r103.append(r105);
        r103.append(", isEncrypted=");
        r103.append(r212);
        r102.i("NestedFileDownloader", r103.toString());
        if (r210 != null) goto L16;
    L19:
        if (r100 == false) goto L21;
        r102.w("NestedFileDownloader", "download file error: illegal params");
        r101.resumeWith(Result.m9449constructorimpl(new lr8.g(2001, null, null, null, null, null, null, null, null, 510)));
    L22:
        Object r106 = r101.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r214);
    L25:
        return r106;
    L21:
        ChatInputService.f303327b.f().c(r110, r210, r211, r212, r213, new b(r211, r101));
        goto L22
    L16:
        if (r210.length() == 0) goto L19;
        r100 = false;
        goto L19
    L12:
        r105 = false;
        goto L13
    L5:
        if (r210.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
