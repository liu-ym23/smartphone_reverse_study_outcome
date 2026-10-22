package mc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.k;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class a extends r22.a<k> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<k> f512868c;

    /* JADX INFO: renamed from: mc2.a$a, reason: collision with other inner class name */
    public static final class C6798a {
    }

    static {
    }

    @Override // r22.a
    public final k j() {
        return (k) ((LinkedList) this.f512868c).pollFirst();
    }

    @Override // r22.a
    public final Queue<k> h() {
        return this.f512868c;
    }

    public a(r22.b<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f512868c = new LinkedList();
    }

    @Override // r22.a
    public final void e(k r100) {
        k r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        if (((LinkedList) this.f512868c).size() < 10) goto L5;
        ((LinkedList) this.f512868c).removeFirst();
    L5:
        ((LinkedList) this.f512868c).add(r101);
        k();
    }
}
