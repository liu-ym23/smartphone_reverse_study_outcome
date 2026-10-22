package zka;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: classes33.dex */
public final class o extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f572729a;

    public o(n r100, Handler r101) {
        this.f572729a = r100;
        super(r101);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        this.f572729a.f572728a.set(-1);
    }
}
