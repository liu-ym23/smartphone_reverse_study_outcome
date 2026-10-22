package yi6;

import com.bytedance.live.livelink.kmp.api.base.video.NodeType;
import com.bytedance.live.livelink.kmp.api.base.video.Status;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import qi6.e;
import qi6.f;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NodeType f567950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Status f567951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f567952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f567953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ei6.a f567954e;

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
        return this.f567951b;
    }

    @Override // qi6.f
    public NodeType getType() {
        return this.f567950a;
    }

    @Override // qi6.f
    public final CopyOnWriteArraySet<f> j() {
        return this.f567953d;
    }

    @Override // qi6.f
    public final CopyOnWriteArraySet<f> k() {
        return this.f567952c;
    }

    public a(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f567954e = r100;
        this.f567950a = NodeType.PROVIDER;
        this.f567951b = Status.UNDEFINED;
        new LinkedHashMap();
        this.f567952c = new CopyOnWriteArraySet();
        this.f567953d = new CopyOnWriteArraySet();
    }

    @Override // qi6.f
    public final void l(Status r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f567951b = r100;
    }
}
