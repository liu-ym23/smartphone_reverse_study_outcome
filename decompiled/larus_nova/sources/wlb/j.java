package wlb;

import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pcb.a f560252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d.a, ocb.a> f560253b;

    @Override // wlb.d
    public final int c() {
        pcb.a r100 = this.f560252a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getVisibleKeyboardHeight();
    }

    @Override // wlb.d
    public final boolean isKeyboardShowing() {
        pcb.a r100 = this.f560252a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isKeyboardShowing();
    }

    public j(FragmentActivity r100) {
        this.f560252a = pcb.a.AbstractC7181a.b(r100);
        this.f560253b = new LinkedHashMap();
    }

    @Override // wlb.d
    public final void a(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onKeyboardHeightChangeListener");
        ocb.a r101 = this.f560253b.remove(r100);
        if (r101 == null) goto L8;
        pcb.a r102 = this.f560252a;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    L9:
        return;
    }

    @Override // wlb.d
    public final void b(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onKeyboardHeightChangeListener");
        pcb.a r101 = this.f560252a;
        if (r101 == null) goto L9;
        LinkedHashMap r102 = (LinkedHashMap) this.f560253b;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L7;
        r103 = new i(r100);
        r102.put(r100, r103);
    L7:
        r101.c((ocb.a) r103);
        return;
    }
}
