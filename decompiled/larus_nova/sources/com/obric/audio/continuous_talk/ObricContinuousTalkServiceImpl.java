package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricContinuousTalkService;", "<init>", "()V", "tryCloseContinuousTalk", "", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "stopImmediately", "isActive", "", "interruptTTS", "isAudioPlaying", "isTtsPlayingForMessage", "messageId", "", "interruptTtsIfPlayingForMessage", "addContinuousTtsMessageIdObserver", "observer", "Lcom/obric/assistant/spi/audio/ContinuousTtsMessageIdObserver;", "removeContinuousTtsMessageIdObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContinuousTalkServiceImpl implements IObricContinuousTalkService {
    public ObricContinuousTalkServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean a0() {
        AtomicReference<hia.a> r100 = hia.c.f485388a;
        hia.a r101 = hia.c.f485388a.get();
        if (r101 == null) goto L5;
        FLogger.f375446a.i("ObricContTalkSessionStore", "isAudioPlaying");
        return r101.a0();
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void b() {
        AtomicReference<hia.a> r100 = hia.c.f485388a;
        hia.a r101 = hia.c.f485388a.get();
        if (r101 == null) goto L6;
        r101.b();
        FLogger.f375446a.i("ObricContTalkSessionStore", "interruptTTS");
        return;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void c() {
        hia.c.b("regen");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean isActive() {
        hia.a r100 = hia.c.f485388a.get();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isActive() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean a(String r100) {
        AtomicReference<hia.a> r101 = hia.c.f485388a;
        hia.a r102 = hia.c.f485388a.get();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.a(r100) != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void d(com.larus.bmhome.chat.component.list.d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        AtomicReference<hia.a> r101 = hia.c.f485388a;
        Intrinsics.checkNotNullParameter(r100, "observer");
        hia.c.f485389b.remove(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final boolean e(String r100) {
        AtomicReference<hia.a> r101 = hia.c.f485388a;
        hia.a r102 = hia.c.f485388a.get();
        if (r102 != null) goto L6;
        FLogger.f375446a.i("ObricContTalkSessionStore", "interruptTtsIfPlayingForMessage failed: no session, messageId=" + r100);
        return false;
    L6:
        if (r102.a(r100) == true) goto L8;
        FLogger.f375446a.i("ObricContTalkSessionStore", "interruptTtsIfPlayingForMessage failed: not current playing message, messageId=" + r100 + ", isAudioPlaying=" + r102.a0());
        return false;
    L8:
        r102.b();
        FLogger.f375446a.i("ObricContTalkSessionStore", "interruptTtsIfPlayingForMessage, messageId=" + r100);
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void f(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        hia.c.b("");
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void g(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        b r101 = (b) r100.getAbility(b.class);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.m0() != true) goto L7;
    L8:
        if (r102 == false) goto L13;
        c r103 = (c) r100.getAbility(c.class);
        if (r103 == null) goto L14;
        c.a.a(r103, null, null, false, false, 15);
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.obric.assistant.spi.audio.IObricContinuousTalkService
    public final void h(com.larus.bmhome.chat.component.list.d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        AtomicReference<hia.a> r101 = hia.c.f485388a;
        Intrinsics.checkNotNullParameter(r100, "observer");
        hia.c.f485389b.add(r100);
    }
}
