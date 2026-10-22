package com.obric.assistant.spi.audio;

import com.larus.bmhome.chat.component.list.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricContinuousTalkServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricContinuousTalkService;", "<init>", "()V", "tryCloseContinuousTalk", "", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "stopImmediately", "isActive", "", "interruptTTS", "isAudioPlaying", "isTtsPlayingForMessage", "messageId", "", "interruptTtsIfPlayingForMessage", "addContinuousTtsMessageIdObserver", "observer", "Lcom/obric/assistant/spi/audio/ContinuousTtsMessageIdObserver;", "removeContinuousTtsMessageIdObserver", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricContinuousTalkServiceImpl implements IObricContinuousTalkService {
    public DefaultObricContinuousTalkServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean a(String r100) {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean a0() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void c() {
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean e(String r100) {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void h(d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean isActive() {
        return false;
    }
}
