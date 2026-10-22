package p92;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import h52.d;
import i52.b;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<MessageModelType, Set<p>> f528289a;

    public a() {
        this.f528289a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Set<p> r101 = this.f528289a.get(r100.d());
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((p) r102.next()).a(r100);
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void a(MessageModelType r100, b.C6230b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<p> r102 = this.f528289a.get(r100);
        if (r102 == null) goto L6;
        r102.remove(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.g
    public final void b(MessageModelType r100, b.C6230b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<p> r102 = this.f528289a.get(r100);
        if (r102 == null) goto L5;
        r102.add(r101);
        return;
    L5:
        Set<p> r103 = this.f528289a.put(r100, SetsKt.mutableSetOf(new p[]{r101}));
    }
}
