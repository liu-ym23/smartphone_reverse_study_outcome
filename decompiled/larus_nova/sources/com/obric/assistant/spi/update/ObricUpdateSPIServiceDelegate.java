package com.obric.assistant.spi.update;

import com.larus.home.impl.t;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vga.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/update/ObricUpdateSPIServiceDelegate;", "Lcom/obric/assistant/spi/update/IObricUpdateSPIService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/update/IObricUpdateSPIService;", "delegate$delegate", "Lkotlin/Lazy;", "checkUpdate", "", "auto", "", "setRequestTagHeaderProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function0;", "Landroid/util/Pair;", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateSPIServiceDelegate implements IObricUpdateSPIService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricUpdateSPIServiceDelegate f392918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392919b = null;

    private ObricUpdateSPIServiceDelegate() {
    }

    static {
        f392918a = new ObricUpdateSPIServiceDelegate();
        f392919b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void a() {
        IObricUpdateSPIService r100 = (IObricUpdateSPIService) f392919b.getValue();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void b(t r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        IObricUpdateSPIService r101 = (IObricUpdateSPIService) f392919b.getValue();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
