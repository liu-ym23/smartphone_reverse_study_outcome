package zy7;

import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILarkLynxContainer f573950a;

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
    }

    public b(com.larksuite.component.card.service.b r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceContext");
        this.f573950a = r100.f283930b;
    }

    @Override // zy7.c
    public final void k(List r100) {
        Intrinsics.checkNotNullParameter("universalCardAudioStateChange", "event");
        Intrinsics.checkNotNullParameter(r100, "data");
        ILarkLynxContainer r101 = this.f573950a;
        if (r101 == null) goto L6;
        r101.sendGlobalEventToJS("universalCardAudioStateChange", r100);
        return;
    }
}
