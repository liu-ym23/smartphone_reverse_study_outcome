package com.larus.audioplayer.api.news;

import b88.a;
import b88.b;
import b88.c;
import b88.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/audioplayer/api/news/UrlAudioPlayerDelegate;", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerService;", "<init>", "()V", "createPlayer", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayer;", "config", "Lcom/larus/audioplayer/api/news/UrlAudioPlayerConfig;", "playCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "managerCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerManagerCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlAudioPlayerDelegate implements IUrlAudioPlayerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UrlAudioPlayerDelegate f290189b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IUrlAudioPlayerService f290190a;

    static {
        f290189b = new UrlAudioPlayerDelegate();
    }

    @Override // com.larus.audioplayer.api.news.IUrlAudioPlayerService
    public final b a(f r100, a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return this.f290190a.a(r100, r101, r102);
    }

    private UrlAudioPlayerDelegate() {
        IUrlAudioPlayerService r100 = (IUrlAudioPlayerService) ServiceManager.get().getService(IUrlAudioPlayerService.class);
        if (r100 != null) goto L5;
        r100 = NoopUrlAudioPlayerService.f290182a;
    L5:
        this.f290190a = r100;
    }
}
