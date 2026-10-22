package com.obric.assistant.audio.service;

import android.media.AudioAttributes;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.e;
import com.obric.assistant.common.spi.audio.IObricAudioService;
import com.obric.assistant.spi.audio.IObricTtsControlService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAudioServiceImpl;", "Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "<init>", "()V", "shouldNotPlayTts", "", "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "isOAutoCallUserMessageMustPlayTts", "getCurrentAudioFocusOwner", "", "isSystemNotification", "isCurrentFocusOwnerPhoneCall", "shouldBypassFocusFail", "scene", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioServiceImpl implements IObricAudioService {
    public ObricAudioServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean d() {
        Lazy r100 = e.f385649a;
        FLogger r101 = FLogger.f375446a;
        r101.i("CurrentAudioFocusManager", "isSystemNotification");
        boolean r102 = false;
        if (e.d() == false) goto L39;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        Object r104 = e.a();     // Catch: Throwable -> L26
        if (r104 == null) goto L36;
        String r105 = e.c(r104);     // Catch: Throwable -> L26
        r101.i("CurrentAudioFocusManager", "getPackageName: ".concat(r105));     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r105, "com.android.systemui") == false) goto L37;
        Method r106 = r104.getClass().getMethod("getAudioAttributes", new Class[0]);     // Catch: Throwable -> L26
        r106.setAccessible(true);     // Catch: Throwable -> L26
        Object r107 = r106.invoke(r104, new Object[0]);     // Catch: Throwable -> L26
        if (r107 == null) goto L38;
        Method r108 = AudioAttributes.class.getMethod("getUsage", new Class[0]);     // Catch: Throwable -> L26
        r108.setAccessible(true);     // Catch: Throwable -> L26
        Object r109 = r108.invoke(r107, new Object[0]);     // Catch: Throwable -> L26
        if ((r109 instanceof Integer) == false) goto L17;
        Integer r110 = (Integer) r109;     // Catch: Throwable -> L26
    L18:
        if (r110 == null) goto L20;
        int r111 = r110.intValue();     // Catch: Throwable -> L26
    L21:
        r101.i("CurrentAudioFocusManager", "getAudioUsage: " + r111 + ", packageName: " + r105);     // Catch: Throwable -> L26
        if (r111 != 5) goto L24;
        r102 = true;
    L24:
        Object r112 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L26
    L28:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L33;
        FLogger.f375446a.i("CurrentAudioFocusManager", "isSystemNotification error: " + r113.getMessage());
        r112 = Boolean.FALSE;
    L33:
        return ((Boolean) r112).booleanValue();
    L20:
        r111 = -1;
        goto L21
    L17:
        r110 = null;
        goto L18
    L38:
        return false;
    L37:
        return false;
    L36:
        return false;
    L26:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L39:
        return false;
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean e() {
        Lazy r100 = e.f385649a;
        FLogger r101 = FLogger.f375446a;
        r101.i("CurrentAudioFocusManager", "isCurrentFocusOwnerPhoneCall");
        String r102 = e.b();
        boolean r103 = e.f385650b.contains(r102);
        if (r103 == false) goto L5;
        r101.i("CurrentAudioFocusManager", "phone call focus owner detected: " + r102);
    L5:
        return r103;
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final String c() {
        return e.b();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IObricTtsControlService r101 = (IObricTtsControlService) ServiceManager.get().getService(IObricTtsControlService.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.b(r100);
    }
}
