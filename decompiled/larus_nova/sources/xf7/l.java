package xf7;

import java.util.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends Observable {
    public final void a() {
        setChanged();
        notifyObservers(Boolean.TRUE);
    }

    public l() {
    }
}
