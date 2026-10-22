package s76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a {
    public a() {
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a
    public final f a(h r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100.getCurrentIndex() + 1) <= CollectionsKt.getLastIndex(r100.b())) goto L8;
        int r101 = 0;
    L10:
        return (f) CollectionsKt.getOrNull(r100.b(), r101);
    L8:
        r101 = r100.getCurrentIndex() + 1;
        goto L10
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a
    public final f b(h r100) {
        if (r100 == null) goto L6;
        List<f> r101 = r100.b();
        if (r101 == null) goto L6;
        return (f) CollectionsKt.getOrNull(r101, r100.getCurrentIndex());
    L6:
        return null;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a
    public final f c(h r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100.getCurrentIndex() - 1) >= 0) goto L8;
        int r101 = CollectionsKt.getLastIndex(r100.b());
    L10:
        return (f) CollectionsKt.getOrNull(r100.b(), r101);
    L8:
        r101 = r100.getCurrentIndex() - 1;
        goto L10
    }
}
