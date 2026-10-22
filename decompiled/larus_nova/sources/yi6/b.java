package yi6;

import com.bytedance.live.livelink.kmp.api.base.video.NodeType;
import com.bytedance.live.livelink.kmp.api.base.video.Status;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import qi6.e;
import qi6.f;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NodeType f567955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Status f567956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f567957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f567958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ei6.a f567959e;

    @Override // qi6.f
    public /* synthetic */ void i() {
        e.f(this);
    }

    @Override // qi6.f
    public /* synthetic */ void init() {
        e.a(this);
    }

    @Override // qi6.f
    public /* synthetic */ void m(qi6.a r100) {
        e.c(this, r100);
    }

    @Override // qi6.f
    public /* synthetic */ void pause() {
        e.b(this);
    }

    @Override // qi6.f
    public /* synthetic */ void release() {
        e.d(this);
    }

    @Override // qi6.f
    public /* synthetic */ void resume() {
        e.e(this);
    }

    @Override // qi6.f
    public /* synthetic */ void stop() {
        e.g(this);
    }

    @Override // qi6.f
    public final Status getStatus() {
        return this.f567956b;
    }

    @Override // qi6.f
    public NodeType getType() {
        return this.f567955a;
    }

    @Override // qi6.f
    public final CopyOnWriteArraySet<f> j() {
        return this.f567958d;
    }

    @Override // qi6.f
    public final CopyOnWriteArraySet<f> k() {
        return this.f567957c;
    }

    public b(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f567959e = r100;
        this.f567955a = NodeType.CONSUMER;
        this.f567956b = Status.UNDEFINED;
        new LinkedHashMap();
        this.f567957c = new CopyOnWriteArraySet();
        this.f567958d = new CopyOnWriteArraySet();
    }

    @Override // qi6.f
    public final void l(Status r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f567956b = r100;
    }
}
