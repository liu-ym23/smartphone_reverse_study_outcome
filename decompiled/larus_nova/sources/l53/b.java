package l53;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.video.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import vg3.c;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<a> f507499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f507500b;

    public b() {
        this(null);
    }

    @Override // vg3.c
    public final boolean d() {
        if (this.f507500b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public b(f r100) {
        this.f507500b = r100;
        this.f507499a = new HashSet();
    }

    @Override // vg3.c
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionMember");
        if (d() == false) goto L5;
        return;
    L5:
        HashSet<a> r101 = this.f507499a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if ((!Intrinsics.areEqual((a) r104, r100)) == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        Iterator r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        a r106 = (a) r105.next();
        if (r106.isPlaying() == false) goto L13;
        r106.a();
        goto L13
    }

    @Override // vg3.c
    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionMember");
        if (d() == false) goto L5;
        return;
    L5:
        this.f507499a.add(r100);
    }

    @Override // vg3.c
    public final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionMember");
        if (d() == false) goto L5;
        return;
    L5:
        HashSet<a> r101 = this.f507499a;
        ArrayList r102 = new ArrayList();
        Iterator<a> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        a r104 = r103.next();
        if ((!Intrinsics.areEqual(r104, r100)) == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        Iterator r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        a r106 = (a) r105.next();
        if (r106.c() == true) goto L13;
        r106.b();
        goto L13
    L17:
        int r107 = ECSdk.f48106a;
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r108 == null) goto L33;
        j r109 = r108.getLiveWindowService();
        if (r109 == null) goto L34;
        r109.toggleLiveAudio(false);
        return;
    L34:
        return;
    }

    @Override // vg3.c
    public final void e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionMember");
        if (d() == false) goto L5;
        return;
    L5:
        HashSet<a> r101 = this.f507499a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if ((!Intrinsics.areEqual((a) r104, r100)) == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        Iterator r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        a r106 = (a) r105.next();
        if (r106.isPlaying() == false) goto L13;
        if (r106.c() == true) goto L13;
        r106.b();
        goto L13
    }
}
