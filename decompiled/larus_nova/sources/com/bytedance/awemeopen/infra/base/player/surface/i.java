package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements com.bytedance.awemeopen.infra.base.player.surface.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextureView f198793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f198794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SurfaceTexture f198795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f198796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SurfaceTexture f198797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC2875a f198798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Surface f198799g;

    public static final class a {
    }

    static {
    }

    public i() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a
    public final void release() {
        boolean r100 = !Intrinsics.areEqual(this.f198797e, this.f198795c);
        AoLogger.g("TextureViewHolder", new Object[]{"release: Surface:" + this.f198799g + ", SurfaceTexture:" + this.f198797e + ", release texture: " + r100});
        if (r100 == false) goto L8;
        SurfaceTexture r101 = this.f198797e;
        if (r101 == null) goto L7;
        r101.release();
    L7:
        this.f198797e = null;
    L8:
        Surface r102 = this.f198799g;
        if (r102 == null) goto L11;
        r102.release();
    L11:
        this.f198799g = null;
        this.f198793a.setSurfaceTextureListener(null);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a
    public final Surface getSurface() {
        return this.f198799g;
    }

    public i(Context r100, SurfaceTexture r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextureView r103 = new TextureView(r100);
        Intrinsics.checkNotNullParameter(r103, "mTextureView");
        this.f198793a = r103;
        this.f198794b = true;
        this.f198795c = r101;
        this.f198796d = r102;
        r103.addOnAttachStateChangeListener(new f(this));
        r103.setSurfaceTextureListener(new h(this));
    }
}
