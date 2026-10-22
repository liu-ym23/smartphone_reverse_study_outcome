package s76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a {
    public c() {
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a
    public final f a(h r100) {
        if (r100 == null) goto L6;
        List<f> r101 = r100.b();
        if (r101 == null) goto L6;
        return (f) CollectionsKt.getOrNull(r101, r100.getCurrentIndex() + 1);
    L6:
        return null;
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
        if (r100 == null) goto L6;
        List<f> r101 = r100.b();
        if (r101 == null) goto L6;
        return (f) CollectionsKt.getOrNull(r101, r100.getCurrentIndex() - 1);
    L6:
        return null;
    }
}
