package com.ss.android.lark.flow.notification.online.process;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class e extends c0c.c implements zsb.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f423764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.flow.notification.online.process.b f423765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f423766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f423767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f423768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f423769g;

    public static final class a {
    }

    public static final class b implements zsb.e {
        public b() {
        }
    }

    public static final class c implements zsb.e {
        public c() {
        }
    }

    public static final class d implements zsb.e {
        public d() {
        }
    }

    static {
    }

    @Inject
    public e(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passportService");
        super(r100);
        this.f423764b = r100;
        this.f423765c = new com.ss.android.lark.flow.notification.online.process.b();
        this.f423766d = new AtomicBoolean(false);
        this.f423767e = new b();
        this.f423768f = new c();
        this.f423769g = new d();
        s.a(this);
    }

    @Override // c0c.c
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        thb.a.b("FlowOnlineNotificationController", "user offline " + this.f423764b.getUser().userId);
        this.f423765c.getClass();
    }

    @Override // zsb.c
    public final void R2(Notice r100, CurrentProcess r101) {
        if (this.f423766d.get() == true) goto L9;
        StringBuilder r102 = new StringBuilder("collectNotificationWrapperImpl currentProcess:");
        if (r101 == null) goto L7;
        String r103 = r101.name();
    L8:
        r102.append(r103);
        thb.a.b("FlowOnlineNotificationController", r102.toString());
        com.ss.android.lark.flow.notification.online.process.b r104 = this.f423765c;
        this.f423768f.getClass();
        int r105 = new com.ss.android.lark.flow.notification.online.type.message.a().getType();
        this.f423768f.getClass();
        r104.b(r105, new com.ss.android.lark.flow.notification.online.type.message.a());
        com.ss.android.lark.flow.notification.online.process.b r106 = this.f423765c;
        this.f423769g.getClass();
        int r107 = new com.ss.android.lark.flow.notification.online.type.reaction.a().getType();
        this.f423769g.getClass();
        r106.b(r107, new com.ss.android.lark.flow.notification.online.type.reaction.a());
        com.ss.android.lark.flow.notification.online.process.b r108 = this.f423765c;
        this.f423767e.getClass();
        int r109 = new com.ss.android.lark.flow.notification.online.type.appfeed.a().getType();
        this.f423767e.getClass();
        r108.b(r109, new com.ss.android.lark.flow.notification.online.type.appfeed.a());
        this.f423766d.compareAndSet(false, true);
        goto L9
    L7:
        r103 = null;
    L9:
        com.ss.android.lark.flow.notification.online.process.b r110 = this.f423765c;
        r110.getClass();
        CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("NotificationDispatcher").execute(new com.ss.android.lark.flow.notification.online.process.a(r110, r100));
    }
}
