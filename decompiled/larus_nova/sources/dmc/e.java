package dmc;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes36.dex */
public abstract class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f469267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f469268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f469269c;

    public e(Set<Integer> r100, Set<String> r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "messageTypes");
        Intrinsics.checkNotNullParameter(r101, "messageMethods");
        Intrinsics.checkNotNullParameter(r102, "replayConfig");
        this.f469267a = r100;
        this.f469268b = r101;
        this.f469269c = r102;
    }

    public /* synthetic */ e(Set r100, Set r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = SetsKt.emptySet();
    L6:
        if ((r102 & 4) == 0) goto L8;
        d r103 = new d(0);
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
