package com.obric.assistant.common.spi.audio;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oda.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/common/spi/audio/ObricAudioServiceDelegate;", "Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "<init>", "()V", "service", "getService", "()Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "service$delegate", "Lkotlin/Lazy;", "shouldNotPlayTts", "", "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "isOAutoCallUserMessageMustPlayTts", "getCurrentAudioFocusOwner", "", "isSystemNotification", "isCurrentFocusOwnerPhoneCall", "shouldBypassFocusFail", "scene", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioServiceDelegate implements IObricAudioService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricAudioServiceDelegate f387843a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f387844b = null;

    private ObricAudioServiceDelegate() {
    }

    static {
        f387843a = new ObricAudioServiceDelegate();
        f387844b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final String c() {
        IObricAudioService r100 = (IObricAudioService) f387844b.getValue();
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean d() {
        IObricAudioService r100 = (IObricAudioService) f387844b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean e() {
        IObricAudioService r100 = (IObricAudioService) f387844b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IObricAudioService r101 = (IObricAudioService) f387844b.getValue();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.b(r100);
    }
}
