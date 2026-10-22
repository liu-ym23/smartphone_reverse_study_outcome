package wwa;

import android.content.Context;
import java.util.Observable;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f561739a;

    public abstract void b();

    public final void c() {
        setChanged();
        notifyObservers();
    }

    public a() {
    }

    public Context getContext() {
        return this.f561739a;
    }

    public void a(Context r100) {
        if (r100 == null) goto L5;
        this.f561739a = r100.getApplicationContext();
    L5:
        b();
    }
}
