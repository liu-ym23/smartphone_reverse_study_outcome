package com.obric.assistant.spi.mediaplay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/mediaplay/DefaultMediaPlayStateChangeListenerImpl;", "Lcom/obric/assistant/spi/mediaplay/IMediaPlayStateChangeListener;", "<init>", "()V", "onMusicPlayStart", "", "shouldInterruptTutor", "", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "handleInterruptedTutor", "action", "Lkotlin/Function0;", "isReset", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultMediaPlayStateChangeListenerImpl implements IMediaPlayStateChangeListener {
    public DefaultMediaPlayStateChangeListenerImpl() {
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        return false;
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void b() {
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void c(Function0<Unit> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }
}
