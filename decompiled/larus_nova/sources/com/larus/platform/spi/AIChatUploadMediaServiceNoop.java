package com.larus.platform.spi;

import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import ic8.n0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ns8.a;
import ns8.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JD\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0017J2\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/larus/platform/spi/AIChatUploadMediaServiceNoop;", "Lcom/larus/platform/spi/IAIChatUploadMediaService;", "<init>", "()V", "onTakePictureSuccess", "", "path", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onPickImageSuccess", "uri", "Landroid/net/Uri;", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildFinalSendImgPath", "isAlbum", "suffix", "isFile", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatUploadMediaServiceNoop implements IAIChatUploadMediaService {
    public AIChatUploadMediaServiceNoop() {
    }

    @Override // com.larus.platform.spi.IAIChatUploadMediaService
    public final String a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "suffix");
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatUploadMediaService
    public final Object b(String r100, a r101, b r102, Continuation r103) {
        return new n0(null, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    }

    @Override // com.larus.platform.spi.IAIChatUploadMediaService
    public final Object c(Uri r100, a r101, boolean r102, b r103, boolean r104, String r105, Continuation<? super n0> r106) {
        return new n0(null, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    }
}
