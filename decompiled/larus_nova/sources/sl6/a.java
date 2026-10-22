package sl6;

import com.bytedance.locallife.biz.base.cube.f;
import com.bytedance.locallife.common.utils.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements at6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f542467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<at6.a.InterfaceC0224a> f542468b = null;

    public a() {
    }

    static {
        f542467a = new a();
        f542468b = new CopyOnWriteArraySet();
    }

    @Override // at6.a
    public final void a(at6.a.InterfaceC0224a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.a.InterfaceC0224a> r101 = f542468b;
        r101.remove(r100);
        r100.hashCode();
        if (r101.isEmpty() == true) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101.isEmpty() == false) goto L9;
        vn6.b.c(this);     // Catch: Throwable -> L12
        r100.hashCode();     // Catch: Throwable -> L12
    L9:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(a.class);
    }

    @Override // at6.a
    public final void b(f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.a.InterfaceC0224a> r101 = f542468b;
        if (r101.isEmpty() == true) goto L5;
        r101.add(r100);
    L17:
        return;
    L5:
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101.isEmpty() == false) goto L9;
        vn6.b.b(this);     // Catch: Throwable -> L12
    L9:
        r101.add(r100);     // Catch: Throwable -> L12
        monitor-exit(a.class);
        goto L17
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onBulletBroadCastEvent(ln6.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<at6.a.InterfaceC0224a> r101 = f542468b.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().a(r100.f510037a, r100.f510038b);
        goto L6
    L8:
        String r102 = r100.f510038b.optString("eventName");
        if (j.a(r102) == false) goto L17;
        JSONObject r103 = r100.f510038b.optJSONObject("data");
        if (r103 != null) goto L13;
        r103 = new JSONObject();
    L13:
        Iterator<at6.a.InterfaceC0224a> r104 = f542468b.iterator();
    L15:
        if (r104.hasNext() == false) goto L20;
        r104.next().a(r102, r103);
        goto L15
    L20:
        return;
    }
}
