package cw8;

import android.view.ViewGroup;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zv8.k;
import zv8.m;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends b implements m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f465635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<EntranceGroup> f465636j;

    @Override // zv8.m
    public final void b() {
        this.f465631g.y2();
    }

    @Override // cw8.b
    public final void c() {
        super.c();
        k.f573760a.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r100 = (ArrayList) k.f573762c;
        if (r100.contains(this) == true) goto L7;
        r100.add(this);
        return;
    }

    @Override // cw8.b
    public final void d() {
        super.d();
        k.f573760a.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r100 = (ArrayList) k.f573762c;
        if (r100.contains(this) == false) goto L7;
        r100.remove(this);
        return;
    }

    public d(EntrancePage r100, ViewGroup r101, List<EntranceGroup> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "entranceList");
        super(r100, r101, r102);
        this.f465635i = r101;
        this.f465636j = r102;
    }
}
