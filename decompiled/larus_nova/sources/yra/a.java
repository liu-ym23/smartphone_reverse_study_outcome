package yra;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.ainote.AINoteContext;
import com.ss.android.ainote.t;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class a implements e, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f568936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f568938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AINoteContext f568939d;

    /* JADX INFO: renamed from: yra.a$a, reason: collision with other inner class name */
    public static final class C8376a {
    }

    static {
    }

    @Override // yra.e
    public final AINoteContext wc() {
        AINoteContext r100 = this.f568939d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        monitor-enter(this);
        AINoteContext r101 = this.f568939d;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new AINoteContext(this.f568937b, this.f568938c, this.f568936a);     // Catch: Throwable -> L11
        this.f568939d = r101;     // Catch: Throwable -> L11
        int r102 = t.f407207a;     // Catch: Throwable -> L11
        t.d("AINoteUserComponentContext", "create aiNoteContext, userId=" + this.f568937b);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f568936a;
    }

    @Override // yra.e
    public final String getUserId() {
        return this.f568937b;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = t.f407207a;
        t.d("AINoteUserComponentContext", "afterUserOffline, userId=" + this.f568937b + ", state=" + r100);
        monitor-enter(this);
        AINoteContext r102 = this.f568939d;     // Catch: Throwable -> L12
        if (r102 != null) goto L9;
        t.d("AINoteUserComponentContext", "destroyAINoteContext skip, no context, userId=" + this.f568937b);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        t.d("AINoteUserComponentContext", "destroy aiNoteContext, userId=" + this.f568937b);     // Catch: Throwable -> L12
        r102.c();     // Catch: Throwable -> L12
        this.f568939d = null;     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = t.f407207a;
        t.d("AINoteUserComponentContext", "afterUserOnline, userId=" + this.f568937b + ", state=" + r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = t.f407207a;
        t.d("AINoteUserComponentContext", "onUserOffline, userId=" + this.f568937b + ", state=" + r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = t.f407207a;
        t.d("AINoteUserComponentContext", "onUserOnline, userId=" + this.f568937b + ", state=" + r100);
    }

    @Inject
    public a(m r100, String r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "rustClient");
        this.f568936a = r100;
        this.f568937b = r101;
        this.f568938c = r102;
    }
}
