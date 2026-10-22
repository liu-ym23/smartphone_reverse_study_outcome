package p76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.d;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.e;
import kotlin.jvm.internal.Intrinsics;
import o76.f;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f528031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o76.d f528032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f528033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f528034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o76.b f528035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b f528036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m76.b f528037g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f528031a, r101.f528031a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528032b, r101.f528032b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528033c, r101.f528033c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528034d, r101.f528034d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528035e, r101.f528035e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528036f, r101.f528036f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528037g, r101.f528037g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f528031a.hashCode() * 31) + this.f528032b.hashCode()) * 31) + this.f528033c.hashCode()) * 31) + this.f528034d.hashCode()) * 31) + this.f528035e.hashCode()) * 31) + this.f528036f.hashCode()) * 31) + this.f528037g.hashCode();
    }

    public final String toString() {
        return "AttachInfo(queueListenerRegistry=" + this.f528031a + ", playerListenerRegistry=" + this.f528032b + ", queueOperationInterceptorRegistry=" + this.f528033c + ", playerOperationInterceptorRegistry=" + this.f528034d + ", audioPlayer=" + this.f528035e + ", audioQueue=" + this.f528036f + ", audioPlayerQueueController=" + this.f528037g + ')';
    }

    public b(m76.c r100, m76.c r101, m76.c r102, m76.c r103, m76.c r104, m76.c r105, m76.c r106) {
        Intrinsics.checkNotNullParameter(r100, "queueListenerRegistry");
        Intrinsics.checkNotNullParameter(r101, "playerListenerRegistry");
        Intrinsics.checkNotNullParameter(r102, "queueOperationInterceptorRegistry");
        Intrinsics.checkNotNullParameter(r103, "playerOperationInterceptorRegistry");
        Intrinsics.checkNotNullParameter(r104, "audioPlayer");
        Intrinsics.checkNotNullParameter(r105, "audioQueue");
        Intrinsics.checkNotNullParameter(r106, "audioPlayerQueueController");
        this.f528031a = r100;
        this.f528032b = r101;
        this.f528033c = r102;
        this.f528034d = r103;
        this.f528035e = r104;
        this.f528036f = r105;
        this.f528037g = r106;
    }
}
