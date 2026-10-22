package in4;

import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements mw4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f490584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<mw4.a.InterfaceC6863a> f490585b;

    /* JADX INFO: renamed from: in4.a$a, reason: collision with other inner class name */
    public static final class C6291a {
    }

    static {
    }

    @Override // mw4.a
    public final void c() {
        Iterator r100 = CollectionsKt.toMutableList(this.f490585b).iterator();     // Catch: Exception -> L7
    L4:
        if (r100.hasNext() == false) goto L14;
        ((mw4.a.InterfaceC6863a) r100.next()).onChanged();     // Catch: Exception -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        tt5.a.j("OfficeDarkModeImpl", e);
    }

    @Override // mw4.a
    public final boolean isNightMode() {
        if (this.f490584a != null) goto L8;
        Context r100 = AppLifecycle.a.f408803a.f();
        if (r100 != null) goto L7;
        r100 = LarkContext.getApplication();
    L7:
        this.f490584a = Boolean.valueOf(h18.f.a(r100));
    L8:
        Boolean r101 = this.f490584a;
        if (r101 != null) goto L13;
        return false;
    L13:
        return r101.booleanValue();
    }

    public a() {
        this.f490585b = new LinkedHashSet();
    }

    @Override // mw4.a
    public final void a(mw4.a.InterfaceC6863a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f490585b.remove(r100);
    }

    @Override // mw4.a
    public final void b(mw4.a.InterfaceC6863a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f490585b.add(r100);
    }
}
