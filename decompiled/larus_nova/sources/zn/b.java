package zn;

import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<T> f572894d;

    public b() {
        super(false, 7);
        if (((Boolean) WindowConstDef.f188728p.getValue()).booleanValue() == false) goto L5;
        c<T> r100 = new f();
    L6:
        this.f572894d = r100;
        return;
    L5:
        r100 = new d();
        goto L6
    }

    @Override // zn.a
    public final c<T> f() {
        return this.f572894d;
    }
}
