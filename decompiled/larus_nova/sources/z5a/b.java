package z5a;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<LynxContext> f570140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<LynxBackgroundRuntime> f570141b;

    public b() {
        this.f570140a = new WeakReference(null);
        this.f570141b = new WeakReference(null);
    }

    public final void a(String r100, JavaOnlyArray r101) {
        LynxContext r102 = this.f570140a.get();
        if (r102 == null) goto L6;
        r102.sendGlobalEvent(r100, r101);
        return;
    L6:
        LynxBackgroundRuntime r103 = this.f570141b.get();
        if (r103 == null) goto L10;
        r103.f(r100, r101);
        return;
    }
}
