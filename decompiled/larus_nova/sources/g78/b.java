package g78;

import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements q58.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<q58.b> f480264a;

    public b(q58.b... r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        CopyOnWriteArrayList<q58.b> r101 = new CopyOnWriteArrayList();
        this.f480264a = r101;
        CollectionsKt.addAll(r101, r100);
    }

    @Override // q58.b
    public final void a(AudioPlayerErrorEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Iterator<T> r101 = this.f480264a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((q58.b) r101.next()).a(r100);
        goto L4
    }

    @Override // q58.b
    public final void b(AudioPlayerState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.f480264a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((q58.b) r101.next()).b(r100);
        goto L4
    }
}
