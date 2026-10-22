package cw8;

import android.view.ViewGroup;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends b implements aw8.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f465623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<EntranceGroup> f465624j;

    @Override // cw8.b
    public final void c() {
        super.c();
        List<Map<EntranceGroup, LinkedList<e>>> r100 = aw8.c.f16593a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r101 = (ArrayList) aw8.c.f16594b;
        if (r101.contains(this) == true) goto L7;
        r101.add(this);
        return;
    }

    @Override // cw8.b
    public final void d() {
        super.d();
        List<Map<EntranceGroup, LinkedList<e>>> r100 = aw8.c.f16593a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r101 = (ArrayList) aw8.c.f16594b;
        if (r101.contains(this) == false) goto L6;
        r101.remove(this);
        return;
    }

    @Override // aw8.d
    public final void a(boolean r100) {
        if (r100 == false) goto L5;
        this.f465631g.y2();
        return;
    }

    public a(EntrancePage r100, ViewGroup r101, List<EntranceGroup> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "entranceList");
        super(r100, r101, r102);
        this.f465623i = r101;
        this.f465624j = r102;
    }
}
