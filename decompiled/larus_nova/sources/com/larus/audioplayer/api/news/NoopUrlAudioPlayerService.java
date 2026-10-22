package com.larus.audioplayer.api.news;

import b88.a;
import b88.b;
import b88.c;
import b88.e;
import b88.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/audioplayer/api/news/NoopUrlAudioPlayerService;", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerService;", "<init>", "()V", "createPlayer", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayer;", "config", "Lcom/larus/audioplayer/api/news/UrlAudioPlayerConfig;", "playCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "managerCallback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayerManagerCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopUrlAudioPlayerService implements IUrlAudioPlayerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoopUrlAudioPlayerService f290182a = null;

    static {
        f290182a = new NoopUrlAudioPlayerService();
    }

    private NoopUrlAudioPlayerService() {
    }

    @Override // com.larus.audioplayer.api.news.IUrlAudioPlayerService
    public final b a(f r100, a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return e.f18199a;
    }
}
