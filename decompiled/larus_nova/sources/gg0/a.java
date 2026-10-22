package gg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.diffutils.DifferNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Class<?>> f481103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<?>> f481104b;

    public a() {
        this.f481103a = new ArrayList();
        this.f481104b = new ArrayList();
    }

    public final b a(tf0.e r100) {
        Class<?> r101 = r100.getClass();
        int r102 = ((ArrayList) this.f481103a).indexOf(r101);
        if (r102 != (-1)) goto L13;
        r102 = 0;
    L7:
        if (r102 >= ((ArrayList) this.f481103a).size()) goto L12;
        if (((Class) ListProtector.get(this.f481103a, r102)).isAssignableFrom(r101) == true) goto L13;
        r102 = r102 + 1;
        goto L7
    L12:
        r102 = -1;
    L13:
        if (r102 == (-1)) goto L17;
        return (b) ListProtector.get(this.f481104b, r102);
    L17:
        throw new DifferNotFoundException(r100.getClass());
    }

    public final <T extends tf0.e> void b(Class<? extends T> r100, b<T> r101) {
        boolean r102 = false;
    L3:
        int r103 = ((ArrayList) this.f481103a).indexOf(r100);
        if (r103 == (-1)) goto L6;
        ListProtector.remove(this.f481103a, r103);
        ListProtector.remove(this.f481104b, r103);
        r102 = true;
        goto L3
    L6:
        if (r102 == true) goto L8;
    L8:
        ((ArrayList) this.f481103a).add(r100);
        ((ArrayList) this.f481104b).add(r101);
    }
}
