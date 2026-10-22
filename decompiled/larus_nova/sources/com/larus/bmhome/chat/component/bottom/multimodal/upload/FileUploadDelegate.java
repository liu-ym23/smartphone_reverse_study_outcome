package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jq\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0085\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadDelegate;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadService;", "<init>", "()V", "createCacheWritingCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IPreprocessUploadCallback;", "localMsgId", "", "entity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "conversationId", "botId", "isMultiFile", "", "fromScene", "clickFrom", "enterMethod", "messageId", "clarifyId", "cacheWriter", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/FileUploadCacheWriter;", "displayType", "agentType", "fileUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileUploadDelegate implements FileUploadService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FileUploadDelegate f300137b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileUploadService f300138a;

    static {
        f300137b = new FileUploadDelegate();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m a(String r110, UplinkFileEntity r111, String r112, String r113, boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, c r218) {
        Intrinsics.checkNotNullParameter(r110, "localMsgId");
        Intrinsics.checkNotNullParameter(r111, "entity");
        return this.f300138a.a(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final l b() {
        return this.f300138a.b();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService
    public final m c(String r110, UplinkFileEntity r111, String r112, String r113, boolean r114, String r115, String r210, String r211, String r212, String r213, c r214) {
        Intrinsics.checkNotNullParameter(r110, "localMsgId");
        Intrinsics.checkNotNullParameter(r111, "entity");
        return this.f300138a.c(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    private FileUploadDelegate() {
        FileUploadService r100 = (FileUploadService) ServiceManager.get().getService(FileUploadService.class);
        if (r100 != null) goto L5;
        r100 = EmptyFileUploadService.f300134a;
    L5:
        this.f300138a = r100;
    }
}
