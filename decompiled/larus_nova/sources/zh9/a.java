package zh9;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.larkfeed.impl.voice.permission.VoicePermission;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<b, Unit> f572201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f572202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<b> f572203c;

    public final void a() {
        b r100 = this.f572202b.get();
        if (r100 != null) goto L5;
        return;
    L5:
        b r101 = this.f572203c.get();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r100.f572205a == true) goto L11;
    L13:
        Function1<b, Unit> r102 = this.f572201a;
        b r103 = b.f572204c;
        String r104 = r100.f572206b + ' ' + r101.f572206b;
        Intrinsics.checkNotNullParameter(r104, "failureReason");
        r102.invoke(new b(false, r104));
        return;
    L11:
        if (r101.f572205a == false) goto L13;
        this.f572201a.invoke(b.f572204c);
    }

    public a(VoicePermission.g r100) {
        Intrinsics.checkNotNullParameter(r100, LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED);
        this.f572201a = r100;
        this.f572202b = new AtomicReference(null);
        this.f572203c = new AtomicReference(null);
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        monitor-enter(this);
        AtomicReference<b> r101 = this.f572202b;     // Catch: Throwable -> L16
    L6:
        if (r101.compareAndSet(null, r100) == true) goto L7;
        if (r101.get() == null) goto L6;
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        this.f572202b.set(r100);     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
    L13:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L7:
        r102 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        monitor-enter(this);
        AtomicReference<b> r101 = this.f572203c;     // Catch: Throwable -> L16
    L6:
        if (r101.compareAndSet(null, r100) == true) goto L7;
        if (r101.get() == null) goto L6;
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        this.f572203c.set(r100);     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
    L13:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L7:
        r102 = true;
    L16:
        th = move-exception;
        throw th;
    }
}
