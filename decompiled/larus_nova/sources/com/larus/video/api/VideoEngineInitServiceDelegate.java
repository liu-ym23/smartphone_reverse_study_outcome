package com.larus.video.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/video/api/VideoEngineInitServiceDelegate;", "Lcom/larus/video/api/IVideoEngineInitService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/video/api/IVideoEngineInitService;", "initVideoEngine", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoEngineInitServiceDelegate implements IVideoEngineInitService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoEngineInitServiceDelegate f375655a = null;

    static {
        f375655a = new VideoEngineInitServiceDelegate();
    }

    private VideoEngineInitServiceDelegate() {
    }

    @Override // com.larus.video.api.IVideoEngineInitService
    public final void a() {
        IVideoEngineInitService r100 = (IVideoEngineInitService) ServiceManager.get().getService(IVideoEngineInitService.class);
        if (r100 == null) goto L6;
        r100.a();
        return;
    }
}
