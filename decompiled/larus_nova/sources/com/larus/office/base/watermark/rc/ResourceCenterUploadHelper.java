package com.larus.office.base.watermark.rc;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import mr9.h;
import mr9.j;

/* JADX INFO: loaded from: classes29.dex */
public final class ResourceCenterUploadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceCenterUploadHelper f361247a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361248a = null;

        static {
            int[] r100 = new int[UploadDataType.values().length];
            r100[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[UploadDataType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f361248a = r100;
        }
    }

    static {
        f361247a = new ResourceCenterUploadHelper();
    }

    public ResourceCenterUploadHelper() {
    }

    public final Object a(List<String> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ResourceCenterUploadHelper$deleteSafely$1) == false) goto L7;
        ResourceCenterUploadHelper$deleteSafely$1 r102 = (ResourceCenterUploadHelper$deleteSafely$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        r100 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L25:
        FLogger.f375446a.i("RcUploadHelper", "deleteSafely: ids=" + r100 + " resp=" + ((String) r104));     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L28:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L32;
        FLogger.f375446a.w("RcUploadHelper", "deleteSafely failed silently: ids=" + r100 + " err=" + r108);
    L32:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        if (r100.isEmpty() == true) goto L21;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L14
        ResourceCenter r110 = ResourceCenter.f313541a;     // Catch: Throwable -> L14
        r102.L$0 = r100;     // Catch: Throwable -> L14
        r102.label = 1;     // Catch: Throwable -> L14
        r104 = r110.b(r100, r102);     // Catch: Throwable -> L14
        if (r104 != r105) goto L25;
        return r105;
    L21:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ResourceCenterUploadHelper$deleteSafely$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r510, String r511, Continuation<? super String> r610) {
        String r100 = r511;
        if ((r610 instanceof ResourceCenterUploadHelper$upload$1) == false) goto L7;
        ResourceCenterUploadHelper$upload$1 r101 = (ResourceCenterUploadHelper$upload$1) r610;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ResourceCenterUploadHelper$upload$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 != 0) goto L159;
        ResultKt.throwOnFailure(r103);
        if (StringsKt.isBlank(r510) == false) goto L28;
        FLogger.f375446a.w("RcUploadHelper", "upload: empty path, abort");
        return null;
    L28:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r510);
        if (r106.exists() == true) goto L31;
    L155:
        FLogger.f375446a.w("RcUploadHelper", "upload: file not exists path=" + r510);
        return null;
    L31:
        if (r106.isFile() == false) goto L155;
        final String r107 = "watermark_" + UUID.randomUUID();
        if (r100 == null) goto L36;
        String r108 = r100.toLowerCase(Locale.ROOT);
    L38:
        if (r108 != null) goto L41;
        r108 = "";
    L41:
        if (StringsKt.startsWith$default(r108, "image/", false, 2, null) == false) goto L45;
        UploadDataType r109 = UploadDataType.IMAGE;
    L43:
        UploadDataType r111 = r109;
        int[] r112 = a.f361248a;
        int r113 = r112[r111.ordinal()];
        if (r113 == 1) goto L100;
        if (r113 == 2) goto L99;
        FlowResourceScene r114 = FlowResourceScene.FileUpload;
    L101:
        String r115 = StringsKt.substringAfterLast(r510, '.', "");
        if (r115.length() != 0) goto L104;
        boolean r116 = true;
    L105:
        if (r116 == false) goto L107;
        String r310 = null;
    L108:
        FLogger.f375446a.i("RcUploadHelper", "upload: identifier=" + r107 + " path=" + r510 + " mime=" + r100 + " dataType=" + r111 + " scene=" + r114 + " size=" + r106.length());
        ResourceCenter.f313541a.getClass();
        ResourceCenter.k(r107, r114);
        Uri r210 = Uri.fromFile(r106);
        int r117 = r112[r111.ordinal()];
        int r118 = 3;
        if (r117 == 1) goto L113;
        if (r117 == 2) goto L112;
        int r119 = UplinkEntityType.EntityTypeFile.getValue();
        UplinkEntityContent r120 = new UplinkEntityContent(null, 0 == true ? 1 : 0, r118, 0 == true ? 1 : 0);
        UplinkFileInfo r121 = new UplinkFileInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
        r121.setFileName(r106.getName());
        r121.setSize(Long.valueOf(r106.length()));
        r121.setFileType(Integer.valueOf(FileType.FileTypeFile.getValue()));
        r121.setMimeType(r100);
        r121.setLocalResPath(r106.getAbsolutePath());
        r120.setUplinkFileInfo(r121);
        UplinkFileEntity r122 = new UplinkFileEntity(Integer.valueOf(r119), r120, r107, null, null, null, null, null, null, false, r210, null, null, null, 15352, null);
    L114:
        h r123 = new h(true, new ResourceAttachmentExtra(null, "", "", "", ""), r122, 24);
        final CompletableDeferred r124 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r512 = "RcUploadHelper";
        Object r125 = r104;
        j r126 = new j(r510, "chat_bot", r111, new com.larus.office.base.watermark.rc.a(r107, r124), new b(r107), new c(r107, r124), false, null, null, r310, r107, false, null, r123, null, null, null, null, null, null, 2077632);
        ResourceUploader r127 = ResourceUploader.f314736a;     // Catch: Throwable -> L137 CancellationException -> L147
        ResourceCenterUploadHelper$upload$1 r128 = r110;
        String r129 = r107;
        r128.L$0 = r129;     // Catch: Throwable -> L133 CancellationException -> L135
        CompletableDeferred r130 = r124;
        r128.L$1 = r130;     // Catch: Throwable -> L133 CancellationException -> L135
        r128.label = 1;     // Catch: Throwable -> L133 CancellationException -> L135
        if (r127.j(r126, r128) != r125) goto L120;
        return r125;
    L120:
        r100 = r129;
    L160:
        r128.L$0 = r100;     // Catch: CancellationException -> L22 Throwable -> L130
        Object r131 = null;
        r128.L$1 = null;     // Catch: CancellationException -> L22 Throwable -> L128
        r128.label = 2;     // Catch: CancellationException -> L22 Throwable -> L128
        r103 = r130.await(r128);     // Catch: CancellationException -> L22 Throwable -> L128
        if (r103 != r125) goto L126;
        return r125;
    L126:
    L171:
        return (String) r103;
    L128:
        th = th;
    L132:
        String r132 = r100;
    L140:
        FLogger.f375446a.e(r512, "upload threw: identifier=" + r132 + " err=" + th);
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L143
        ResourceUploader.c(r132);     // Catch: Throwable -> L143
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L143
    L146:
        return r131;
    L143:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L130:
        th = th;
        r131 = null;
        goto L132
    L135:
        e = e;
    L149:
        r100 = r129;
    L23:
        String r513 = r100;
        CancellationException r135 = e;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L152
        ResourceUploader.c(r513);     // Catch: Throwable -> L152
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L152
        throw r135;
    L152:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw r135;
    L133:
        th = th;
    L134:
        r131 = null;
        r132 = r129;
        goto L140
    L147:
        e = e;
        r129 = r107;
    L137:
        th = th;
        r129 = r107;
        goto L134
    L112:
        int r138 = UplinkEntityType.EntityTypeFile.getValue();
        UplinkEntityContent r139 = new UplinkEntityContent(null, 0 == true ? 1 : 0, r118, 0 == true ? 1 : 0);
        UplinkFileInfo r140 = new UplinkFileInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
        r140.setFileName(r106.getName());
        r140.setSize(Long.valueOf(r106.length()));
        r140.setFileType(Integer.valueOf(FileType.FileTypeVideo.getValue()));
        r140.setMimeType(r100);
        r140.setLocalResPath(r106.getAbsolutePath());
        r139.setUplinkFileInfo(r140);
        r122 = new UplinkFileEntity(Integer.valueOf(r138), r139, r107, null, null, null, null, null, null, false, r210, null, null, null, 15352, null);
        goto L114
    L113:
        int r141 = UplinkEntityType.EntityTypeImage.getValue();
        UplinkEntityContent r142 = new UplinkEntityContent(null, 0 == true ? 1 : 0, r118, 0 == true ? 1 : 0);
        Image r143 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r143.localResPath = r106.getAbsolutePath();
        r143.identifier = r107;
        r142.setUplinkImageInfo(r143);
        r122 = new UplinkFileEntity(Integer.valueOf(r141), r142, r107, null, null, null, null, null, null, false, r210, null, null, null, 15352, null);
        goto L114
    L107:
        r310 = r115;
        goto L108
    L104:
        r116 = false;
        goto L105
    L99:
        r114 = FlowResourceScene.VideoUpload;
        goto L101
    L100:
        r114 = FlowResourceScene.ImageVLM;
        goto L101
    L45:
        if (StringsKt.startsWith$default(r108, "video/", false, 2, null) == false) goto L48;
        r109 = UploadDataType.VIDEO;
        goto L43
    L48:
        if (r108.length() <= 0) goto L50;
        boolean r144 = true;
    L51:
        if (r144 == false) goto L53;
        r109 = UploadDataType.FILE;
        goto L43
    L53:
        String r145 = StringsKt.substringAfterLast(r510, '.', "").toLowerCase(Locale.ROOT);
        switch(r145.hashCode()) {
            case 96980: goto L91;
            case 97669: goto L87;
            case 102340: goto L84;
            case 105441: goto L81;
            case 108184: goto L78;
            case 108273: goto L75;
            case 108308: goto L72;
            case 111145: goto L69;
            case 3198679: goto L66;
            case 3268712: goto L63;
            case 3645337: goto L60;
            case 3645340: goto L57;
            default: goto L94;
        };
    L94:
        r109 = UploadDataType.FILE;
        goto L43
    L57:
        if (r145.equals("webp") == false) goto L94;
    L89:
        r109 = UploadDataType.IMAGE;
        goto L43
    L60:
        if (r145.equals("webm") == false) goto L94;
    L93:
        r109 = UploadDataType.VIDEO;
        goto L43
    L63:
        if (r145.equals(LoadParams.ImageFormat.JPEG) == true) goto L89;
    L66:
        if (r145.equals("heic") == true) goto L89;
    L69:
        if (r145.equals(LoadParams.ImageFormat.PNG) == true) goto L89;
    L72:
        if (r145.equals("mov") == true) goto L93;
    L75:
        if (r145.equals("mp4") == true) goto L93;
    L78:
        if (r145.equals("mkv") == true) goto L93;
    L81:
        if (r145.equals("jpg") == true) goto L89;
    L84:
        if (r145.equals("gif") == true) goto L89;
    L87:
        if (r145.equals("bmp") == true) goto L89;
    L91:
        if (r145.equals("avi") == true) goto L93;
    L50:
        r144 = false;
        goto L51
    L36:
        r108 = null;
        goto L38
    L159:
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        r100 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20 CancellationException -> L22
        r512 = "RcUploadHelper";
        r131 = null;
        goto L126
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        CompletableDeferred r146 = (CompletableDeferred) r110.L$1;
        r100 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20 CancellationException -> L22
        r512 = "RcUploadHelper";
        r128 = r110;
        r130 = r146;
        r125 = r104;
    L20:
        th = th;
        r512 = "RcUploadHelper";
        r131 = null;
    L22:
        e = e;
    L7:
        r101 = new ResourceCenterUploadHelper$upload$1(this, r610);
        goto L8
    }
}
