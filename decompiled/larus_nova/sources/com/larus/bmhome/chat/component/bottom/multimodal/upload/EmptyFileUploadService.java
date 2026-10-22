package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import ic8.n0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Jp\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0084\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/EmptyFileUploadService;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadService;", "<init>", "()V", "fileUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "createCacheWritingCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IPreprocessUploadCallback;", "localMsgId", "", "entity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "botId", "isMultiFile", "", "fromScene", "clickFrom", "enterMethod", "messageId", "clarifyId", "cacheWriter", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadCacheWriter;", "displayType", "agentType", "EmptyUploader", "EmptyCallback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyFileUploadService implements FileUploadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyFileUploadService f300134a = null;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f300135a = null;

        static {
            f300135a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void b(mr9.l r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uploadResult");
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void c(boolean r100) {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void d(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "processResult");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void e(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
        }
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f300136a = null;

        static {
            f300136a = new b();
        }

        public b() {
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object a(d r100, Continuation<? super Unit> r101) {
            return Unit.INSTANCE;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.l
        public final Object b(q r100, ns8.b r101, Continuation<? super Unit> r102) {
            return Unit.INSTANCE;
        }
    }

    static {
        f300134a = new EmptyFileUploadService();
    }

    private EmptyFileUploadService() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final l b() {
        return b.f300136a;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m c(String r100, UplinkFileEntity r101, String r102, String r103, boolean r104, String r105, String r106, String r107, String r108, String r110, c r111) {
        Intrinsics.checkNotNullParameter(r100, "localMsgId");
        Intrinsics.checkNotNullParameter(r101, "entity");
        return a.f300135a;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m a(String r100, UplinkFileEntity r101, String r102, String r103, boolean r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, c r113) {
        Intrinsics.checkNotNullParameter(r100, "localMsgId");
        Intrinsics.checkNotNullParameter(r101, "entity");
        return a.f300135a;
    }
}
