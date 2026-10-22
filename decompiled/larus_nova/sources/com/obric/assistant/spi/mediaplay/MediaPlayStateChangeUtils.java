package com.obric.assistant.spi.mediaplay;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/mediaplay/MediaPlayStateChangeUtils;", "Lcom/obric/assistant/spi/mediaplay/IMediaPlayStateChangeListener;", "<init>", "()V", "handleInterruptedTutor", "", "action", "Lkotlin/Function0;", "isReset", "", "onMusicPlayStart", "shouldInterruptTutor", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaPlayStateChangeUtils implements IMediaPlayStateChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaPlayStateChangeUtils f392894b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMediaPlayStateChangeListener f392895a;

    static {
        f392894b = new MediaPlayStateChangeUtils();
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        return this.f392895a.a(r100);
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void b() {
        this.f392895a.b();
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void c(Function0<Unit> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f392895a.c(r100, r101);
    }

    private MediaPlayStateChangeUtils() {
        IMediaPlayStateChangeListener r100 = (IMediaPlayStateChangeListener) ServiceManager.get().getService(IMediaPlayStateChangeListener.class);
        if (r100 != null) goto L5;
        r100 = new DefaultMediaPlayStateChangeListenerImpl();
    L5:
        this.f392895a = r100;
    }
}
