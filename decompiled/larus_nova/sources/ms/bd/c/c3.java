package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes42.dex */
public final class c3 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f515123a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f515123a;
    }

    public c3(IBinder r100) {
        this.f515123a = r100;
    }
}
