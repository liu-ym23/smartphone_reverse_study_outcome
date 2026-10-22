package me.drakeet.multitype;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Class<?>> f513440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<?, ?>> f513441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c<?>> f513442c;

    public d() {
        this.f513440a = new ArrayList();
        this.f513441b = new ArrayList();
        this.f513442c = new ArrayList();
    }

    public final boolean a(Class<?> r100) {
        boolean r101 = false;
    L3:
        int r102 = ((ArrayList) this.f513440a).indexOf(r100);
        if (r102 == (-1)) goto L6;
        ListProtector.remove(this.f513440a, r102);
        ListProtector.remove(this.f513441b, r102);
        ListProtector.remove(this.f513442c, r102);
        r101 = true;
        goto L3
    L6:
        return r101;
    }
}
