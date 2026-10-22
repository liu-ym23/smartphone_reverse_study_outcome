package fr2;

import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f478519a;

    @Override // fr2.m
    public final m1 F4() {
        return this;
    }

    public final void I() {
        this.f478519a.I();
    }

    @Override // fr2.m
    public final void U() {
        this.f478519a.C0(new uv0.a(LiveRequestSourceRole.Business, "MainLiveStream.stopPushStream", null));
    }

    public final void b() {
        this.f478519a.x0();
    }

    @Override // fr2.m
    public final p getLiveCore() {
        uf2.d0 r100 = this.f478519a.A();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new j1(r100);
    }

    @Override // fr2.m
    public final boolean w0() {
        return this.f478519a.w0();
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478519a;
    }

    public m1(com.bytedance.android.live.pushstream.d r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478519a = r100;
    }

    @Override // fr2.m
    public final void h1(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        this.f478519a.X0(r100, new uv0.a(LiveRequestSourceRole.Business, "MainLiveStream.startPushStream", null));
    }
}
