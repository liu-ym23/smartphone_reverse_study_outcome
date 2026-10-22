package ff9;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kd9.w0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f476688a = null;

    public static final class a {
    }

    public e() {
    }

    @Override // ff9.x
    public final void a(com.larus.im.service.audio.m r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
    }

    @Override // ff9.x
    public final void d(com.larus.im.service.audio.m r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
    }

    @Override // ff9.x
    public final void e(w0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // ff9.x
    public final void f(w0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    static {
        f476688a = new e();
    }

    @Override // ff9.x
    public final void initialize() {
        fe9.a.f476620a.b("DummyPlayProcessControl", "initialize");
    }

    @Override // ff9.x
    public final void pause() {
        fe9.a.f476620a.b("DummyPlayProcessControl", "pause");
    }

    @Override // ff9.x
    public final void resume() {
        fe9.a.f476620a.b("DummyPlayProcessControl", "resume");
    }

    @Override // ff9.x
    public final void start() {
        fe9.a.f476620a.b("DummyPlayProcessControl", "start");
    }

    @Override // ff9.x
    public final void c(boolean r100) {
        fe9.a.f476620a.b("DummyPlayProcessControl", ITTVideoEngineEventSource.KEY_MUTE);
    }

    @Override // ff9.x
    public final void b(boolean r100, JSONObject r101) {
        fe9.a.f476620a.b("DummyPlayProcessControl", "stop");
    }
}
