package com.larus.platform.spi;

import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ns8.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 !2\u00020\u0001:\u0001!J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&JN\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0015J6\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0010H&J\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010 ¨\u0006\""}, d2 = {"Lcom/larus/platform/spi/IAIChatUploadMediaService;", "", "onTakePictureSuccess", "", "path", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onPickImageSuccess", "uri", "Landroid/net/Uri;", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildFinalSendImgPath", "isAlbum", "suffix", "isFile", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIChatUploadMediaService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f365908a = null;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J#\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001JD\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096A¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0096A¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/larus/platform/spi/IAIChatUploadMediaService$Companion;", "Lcom/larus/platform/spi/IAIChatUploadMediaService;", "<init>", "()V", "buildFinalSendImgPath", "", "isAlbum", "", "suffix", "isFile", "onPickImageSuccess", "", "uri", "Landroid/net/Uri;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "compressConfig", "Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;", "onTakePictureSuccess", "path", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "isMultiFile", "processConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "keepCompressConfig", "scene", "(Landroid/net/Uri;Lcom/larus/bmhome/uploadmedia/bean/CompressConfig;ZLcom/larus/bmhome/uploadmedia/bean/ProcessConfig;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTakePhotoImg", "tmpSrcPath", "(Ljava/lang/String;ZLcom/larus/bmhome/uploadmedia/bean/CompressConfig;Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryUploadFile", "param", "Lcom/larus/bmhome/chat/FileUploadParam;", "(Lcom/larus/bmhome/chat/FileUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAIChatUploadMediaService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f365909c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAIChatUploadMediaService f365910b;

        static {
            f365909c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final String a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "suffix");
            return this.f365910b.a(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final Object b(String r100, ns8.a r101, b r102, Continuation r103) {
            return this.f365910b.b(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatUploadMediaService
        public final Object c(Uri r100, ns8.a r110, boolean r111, b r112, boolean r113, String r114, Continuation<? super n0> r115) {
            return this.f365910b.c(r100, r110, r111, r112, r113, r114, r115);
        }

        private Companion() {
            IAIChatUploadMediaService r100 = (IAIChatUploadMediaService) ServiceManager.get().getService(IAIChatUploadMediaService.class);
            if (r100 != null) goto L5;
            r100 = new AIChatUploadMediaServiceNoop();
        L5:
            this.f365910b = r100;
        }
    }

    public static final class a {
        public static /* synthetic */ Object a(Companion r110, Uri r111, ns8.a r112, boolean r113, boolean r114, String r115, Continuation r116, int r117) {
            if ((r117 & 2) == 0) goto L5;
            ns8.a r100 = null;
        L7:
            if ((r117 & 4) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r117 & 16) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r117 & 32) == 0) goto L17;
            String r103 = null;
        L19:
            return r110.c(r111, r100, r101, null, r102, r103, r116);
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    static {
        f365908a = Companion.f365909c;
    }

    String a(String r100, boolean r101);

    Object b(String r100, ns8.a r101, b r102, Continuation r103);

    Object c(Uri r100, ns8.a r101, boolean r102, b r103, boolean r104, String r105, Continuation<? super n0> r106);
}
