package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public abstract class AbsSurfaceSource implements com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC2875a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.infra.base.player.h f198782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f198783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.awemeopen.infra.base.player.surface.a f198784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f198785d;

    public static final class a {
    }

    static {
    }

    public abstract i a(Context r100);

    public final Surface b() {
        com.bytedance.awemeopen.infra.base.player.surface.a r100 = this.f198784c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.view.Surface] */
    public final void c() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        com.bytedance.awemeopen.infra.base.player.surface.a r101 = this.f198784c;
        if (r101 == null) goto L31;
        ?? r102 = r101.getSurface();
        if (r102 == 0) goto L35;
        r100.element = r102;
        com.bytedance.awemeopen.infra.base.player.h r103 = this.f198782a;
        if (r103 == null) goto L12;
        com.bytedance.awemeopen.infra.base.player.g r104 = r103.getCustomPlayer();
        if (r104 == null) goto L12;
        final String r105 = r104.g();
    L13:
        AoLogger.g("AbsSurfaceSource", new Object[]{"onSurfaceAvailable#" + ((Surface) r100.element).hashCode() + " aid=" + r105 + " hasDestroyed=" + this.f198785d.get()});
        e r106 = this.f198783b;
        Surface r107 = (Surface) r100.element;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "surface");
        c r108 = r106.f198786a;
        if (r108 == null) goto L16;
        r108.a(r107);
    L16:
        Surface r109 = (Surface) r100.element;
        Intrinsics.checkNotNullParameter(r109, "surface");
        d r110 = r106.f198787b;
        if (r110 == null) goto L19;
        r110.a(r109);
    L19:
        Surface r111 = (Surface) r100.element;
        Intrinsics.checkNotNullParameter(r111, "surface");
        b r112 = r106.f198788c;
        if (r112 == null) goto L22;
        r112.a(r111);
    L22:
        r106.f198787b = null;
        r106.f198786a = null;
        r106.f198788c = null;
        com.bytedance.awemeopen.infra.base.player.h r113 = this.f198782a;
        if (r113 == null) goto L32;
        final com.bytedance.awemeopen.infra.base.player.g r114 = r113.getCustomPlayer();
        if (r114 == null) goto L33;
        Function0<Unit> r115 = new AbsSurfaceSource$onSurfaceAvailableInner$2$1$action$1(r114, r100, r105);
        if (this.f198785d.getAndSet(false) == false) goto L29;
        r113.a(r115);
        return;
    L29:
        r115.invoke();
        return;
    L33:
        return;
    L32:
        return;
    L12:
        r105 = null;
        goto L13
    L35:
        return;
    }

    public final void d() {
        com.bytedance.awemeopen.infra.base.player.surface.a r100 = this.f198784c;
        if (r100 == null) goto L5;
        Surface r101 = r100.getSurface();
    L6:
        com.bytedance.awemeopen.infra.base.player.h r102 = this.f198782a;
        if (r102 == null) goto L11;
        com.bytedance.awemeopen.infra.base.player.g r103 = r102.getCustomPlayer();
        if (r103 == null) goto L11;
        String r104 = r103.g();
    L12:
        Object[] r105 = new Object[1];
        StringBuilder r106 = new StringBuilder("onSurfaceDestroyed#");
        if (r101 == null) goto L15;
        int r107 = r101.hashCode();
    L16:
        r106.append(r107);
        r106.append(" aid=");
        r106.append(r104);
        r105[0] = r106.toString();
        AoLogger.g("AbsSurfaceSource", r105);
        this.f198785d.set(true);
        e r108 = this.f198783b;
        r108.f198787b = null;
        r108.f198786a = null;
        r108.f198788c = null;
        return;
    L15:
        r107 = 0;
    L11:
        r104 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC2875a
    public final void onSurfaceAvailable() {
        c();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AoLogger.c("AbsSurfaceSource", new Object[]{"onSurfaceAvailable\n" + Log.getStackTraceString(e)});
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC2875a
    public final void onSurfaceDestroyed() {
        d();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AoLogger.c("AbsSurfaceSource", new Object[]{"onSurfaceDestroyed\n" + Log.getStackTraceString(e)});
    }

    public AbsSurfaceSource(com.bytedance.awemeopen.infra.base.player.h r100) {
        this.f198782a = r100;
        this.f198783b = new e();
        this.f198785d = new AtomicBoolean(false);
    }
}
