package os2;

import ls2.c;
import vh1.l;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<T extends ls2.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f526494a;

    public abstract T d();

    public boolean e() {
        return this instanceof l;
    }

    public a() {
        this.f526494a = (T) d();
    }

    public String b() {
        return getClass().getName();
    }
}
